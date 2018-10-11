package br.com.tradeideas.robo;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import br.com.tradeideas.business.AcaoBusiness;
import br.com.tradeideas.business.CotacaoAcaoBusiness;
import br.com.tradeideas.entity.Acao;
import br.com.tradeideas.entity.CotacaoAcao;
import br.com.tradeideas.util.Util;
import sun.misc.BASE64Encoder;

public class RoboCotacoesAcoes implements Job{
	
	
	
	public void execute(JobExecutionContext context) throws JobExecutionException {
		
		if (isBolsaAberta()){		
		
			processaCotacoesAcoes();
		}
	}
	
	private void processaCotacoesAcoes(){
		
		Long inicio = new Date().getTime();
		
		//Pega as ações cadastradas.
		AcaoBusiness ab = new AcaoBusiness();
		List<Acao> acoes = ab.getAcoesByRobo();
		
		for (Acao acao : acoes){
			
			
			//System.out.println("Ação: "+acao.getCodigo());
		
			//Busca as cotações.
			StringBuffer conteudo = getCotacoes(acao.getCodigo());
						
			//Extrai as cotações do conteúdo.
			CotacaoAcao cot = extraiValoresAcao(conteudo, acao);
			
			System.out.println("Exibindo a cotação antes de salvar...");
			System.out.println("Papel: "+cot.getAcao().getCodigo()+ "  Valor: "+cot.getUltimo()+ "  Oscilação: "+cot.getOscilacao());
			
			//Exclui a última, e salva a nova no BD.
			CotacaoAcaoBusiness cab = new CotacaoAcaoBusiness();
			cab.deleteByRobo(cot.getAcao().getCodigo());
			cab.saveByRobo(cot);
		}
		
		Long fim = new Date().getTime();
		System.out.println(Util.getDataAsDiaMesAnoHoraMinuto(Calendar.getInstance())+" - Cotações ações: "+(fim-inicio)+" ms");
		

	}

	private StringBuffer getCotacoes(String papel){
	
		String endereco = "http://www.bolsafinanceira.com/cotacoes/resumo/"+papel;
		String conteudo;
		StringBuffer texto = new StringBuffer();
		try{
			URL url = new URL(endereco);	
			URLConnection con = url.openConnection();
			InputStream is = con.getInputStream();
	        InputStreamReader ir = new InputStreamReader(is, "8859_1"); 
	        BufferedReader in = new BufferedReader(ir); 
	        
	        while ( (conteudo = in.readLine()) != null){ 
	        	texto.append(conteudo);
	        } 
	        
		}catch(Exception e){
			e.printStackTrace();
		}
		return texto;
	}
	
	public CotacaoAcao extraiValoresAcao(StringBuffer texto, Acao acao){
		
		CotacaoAcao cot = new CotacaoAcao();
		cot.setAcao(acao);
		
		String trechoValor = texto.substring(texto.indexOf("pricelabel")+26, texto.indexOf("pricelabel")+38);
		String valor = trechoValor.substring(0, trechoValor.indexOf("</span>"));
		if (valor.contains(",")){
			valor = valor.replace(",", ".");			
		}
		Float fValor = Float.parseFloat(valor);
		
		String trechoOscilacao = texto.substring(texto.indexOf("variation"), texto.indexOf("variation")+24);
		String oscilacao = trechoOscilacao.substring(trechoOscilacao.indexOf(">")+2, trechoOscilacao.indexOf("%"));
		
		if (oscilacao.contains(",")){
			oscilacao = oscilacao.replace(",", ".");			
		}
		Float fOscilacao = Float.parseFloat(oscilacao);

		cot.setUltimo(fValor);
		cot.setOscilacao(fOscilacao);
		
		return cot;
	}
	
	private boolean isBolsaAberta(){
		//Verifica se é dia de semana.
		Calendar calendar = Calendar.getInstance();
		Integer diaDaSemana = calendar.get(Calendar.DAY_OF_WEEK); 
		if (diaDaSemana < 2 || diaDaSemana > 6){
			return false;
		}
		//Verifica se está entre 10:00hs e 17:00hs.
		Integer hora = calendar.get(Calendar.HOUR_OF_DAY);
		//System.out.println("Hora: "+hora);
		if (hora < 10 || hora > 17){
			return false;
		}
		return true;	
	}
	

}
