package br.com.tradeideas.business;


import java.util.ArrayList;
import java.util.List;

import br.com.tradeideas.entity.CotacaoAcao;
import br.com.tradeideas.entity.CotacaoOpcao;
import br.com.tradeideas.entity.Lancamento;
import br.com.tradeideas.entity.Opcao;
import br.com.tradeideas.entity.Serie;
import br.com.tradeideas.util.Util;

public class LancamentoBusiness {
	
	/*
	 * 1 - Buscar ações;
	 * 2 - Buscar opções das ações, no vencimento selecionado, do tipo CALL;
	 * 3 - Eliminar as opções com zero no preço ou zero disponível na quantidade de compra;
	 * 3 - Montar a lista de lançamentos possíveis;
	 * 		Valor extrinsico -> Se strike, é maior ou igual o valor da ação, o valor extrisico é o valor da opção.
	 * 						-> Caso contrário, pegar o valor da opção mais o strike, e subtrair da ação.
	 * 
	 * 		% de lucro -> (vlExtrinsico/vlAcao-vlOpcao)*100
	 * 
	 * 		% Proteção -> (1 - (Valor da ação - valor da opão) / valor da ação)*100;
	 * 
	 * 		% Lucro por mês: percentual de lucro / (dias corridos / 30); 
	 * 
	 * 	4 - Montar os filtros default
	 * 
	 */
	
	public List<Lancamento> buscarLancamentos(Integer idAcao){
		
		//Inicializações.
		OpcaoBusiness ob = new OpcaoBusiness();
		CotacaoOpcaoBusiness cob = new CotacaoOpcaoBusiness();
		CotacaoAcaoBusiness cab = new CotacaoAcaoBusiness();
		List<CotacaoOpcao> cotacoesOpcoes = new ArrayList<CotacaoOpcao>();
		Util util = new Util();
		
		//Buscar a cotação da ação.
		CotacaoAcao cotacaoAcao = cab.getCotacaoByIdAcao(idAcao);

		//Buscar as opções de compra de acordo com ação.
		List<Opcao> opcoes = ob.getOpcoesDeCompraByAcao(idAcao);
		
		//Buscar as cotações das opções.
		for (Opcao opcao : opcoes){
			CotacaoOpcao co = cob.getCotacaoByCodigo(opcao.getCodigo());
			if (co.getUltimo() > 0){
				cotacoesOpcoes.add(co);	
			}
		}
		List<Lancamento> lancamentos = new ArrayList<Lancamento>();
		for(CotacaoOpcao cotacaoOpcao : cotacoesOpcoes){
			
			//Calcula quantos dias até o vencimento da Série.
			Integer diasParaVencimentoSerie = util.getQtdDiasAteData(cotacaoOpcao.getOpcao().getSerie().getDataExercicio()); 
			
			System.out.println("Dias para vencimento: "+diasParaVencimentoSerie);
			
			Lancamento lancamento = new Lancamento();
			lancamento.setAcao(cotacaoAcao.getAcao().getCodigo());
			lancamento.setOpcao(cotacaoOpcao.getOpcao().getCodigo());
			lancamento.setValorStrike(cotacaoOpcao.getOpcao().getValorExerc());
			lancamento.setDiasParaVenctoSerie(diasParaVencimentoSerie);
			lancamento.setValorAcao(cotacaoAcao.getUltimo());
			lancamento.setValorOpcao(cotacaoOpcao.getUltimo());
			
			lancamentos.add(lancamento);		
		}
		return lancamentos;
	}

	
	
	public List<Lancamento> buscarLancamentos(Integer idAcao, Integer idSerie){

		OpcaoBusiness ob = new OpcaoBusiness();
		CotacaoOpcaoBusiness cob = new CotacaoOpcaoBusiness();
		CotacaoAcaoBusiness cab = new CotacaoAcaoBusiness();
		SerieBusiness sb = new SerieBusiness();
		
		//Buscar a cotação da ação.
		CotacaoAcao cotacaoAcao = cab.getCotacaoByIdAcao(idAcao);
		
		//Buscar as opções de acordo com ação e série selecionada.
		List<Opcao> opcoes = ob.getBySerieByAcaoOrderByVlExerc(idSerie, idAcao);
		
		//Calcula quantos dias até o vencimento da Série.
		Serie serie = sb.getSerieById(idSerie);
		
		Util util = new Util();
		Integer diasParaVencimentoSerie = util.getQtdDiasAteData(serie.getDataExercicio()); 
		
		System.out.println("Dias ate o vencimento: "+diasParaVencimentoSerie);
		
		List<CotacaoOpcao> cotacoesOpcoes = new ArrayList<CotacaoOpcao>();
		//Buscar as cotações das opções.
		for (Opcao opcao : opcoes){
			CotacaoOpcao co = cob.getCotacaoByCodigo(opcao.getCodigo());
			cotacoesOpcoes.add(co);
		}
		List<Lancamento> lancamentos = new ArrayList<Lancamento>();
		for(CotacaoOpcao cotacaoOpcao : cotacoesOpcoes){
			Lancamento lancamento = new Lancamento();
			
			lancamento.setAcao(cotacaoAcao.getAcao().getCodigo());
			lancamento.setOpcao(cotacaoOpcao.getOpcao().getCodigo());
			lancamento.setValorStrike(cotacaoOpcao.getOpcao().getValorExerc());
			lancamento.setDiasParaVenctoSerie(diasParaVencimentoSerie);
			lancamento.setValorAcao(cotacaoAcao.getUltimo());
			lancamento.setValorOpcao(cotacaoOpcao.getUltimo());
			
			lancamentos.add(lancamento);		
		}
		return lancamentos;
	}

}
