package br.com.tradeideas.business;

import java.util.ArrayList;
import java.util.List;

import br.com.tradeideas.entity.Acao;
import br.com.tradeideas.entity.Opcao;
import br.com.tradeideas.entity.Serie;
import br.com.tradeideas.entity.TravaAlta;
import br.com.tradeideas.factory.TravaAltaBeanFactory;

public class TravaDeAltaBusiness {
	
	private List<Acao> acoes = new ArrayList<Acao>();
	private List<Serie> series = new ArrayList<Serie>();
	
	public List<TravaAlta> getTravasDeAltaPossiveis(){
		OpcaoBusiness ob = new OpcaoBusiness();
		List<TravaAlta> travas = new ArrayList<TravaAlta>();
		TravaAltaBeanFactory tbf = new TravaAltaBeanFactory();

		for(Serie serie : getSeries()){
			for(Acao acao : getAcoes()){
				List<Opcao> opcoes = ob.getBySerieByAcaoOrderByVlExerc(serie.getId(), acao.getId());
				if (opcoes!=null && opcoes.size()>1){
					for(int i=0; i<opcoes.size()-1; i++){
						Opcao compra = opcoes.get(i);
						Opcao venda = opcoes.get(i+1);

						TravaAlta trava = tbf.getTravaAlta(acao, compra, venda);
						if (trava!=null){
							travas.add(trava);	
						}
					}
				}
			}
		}
		return travas;		
	}
	
	public List<Serie> getSeries() {
		if (series.isEmpty()){
			SerieBusiness sb = new SerieBusiness();
			series = sb.getSeries();
		}
		return series;		
	}
	
	public List<Acao> getAcoes(){
		if (acoes.isEmpty()){
			AcaoBusiness ab = new AcaoBusiness();
			acoes = ab.getAcoes();
		}
		return acoes;		
	}
	

}
