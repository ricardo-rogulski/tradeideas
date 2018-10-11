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
	 * 1 - Buscar a��es;
	 * 2 - Buscar op��es das a��es, no vencimento selecionado, do tipo CALL;
	 * 3 - Eliminar as op��es com zero no pre�o ou zero dispon�vel na quantidade de compra;
	 * 3 - Montar a lista de lan�amentos poss�veis;
	 * 		Valor extrinsico -> Se strike, � maior ou igual o valor da a��o, o valor extrisico � o valor da op��o.
	 * 						-> Caso contr�rio, pegar o valor da op��o mais o strike, e subtrair da a��o.
	 * 
	 * 		% de lucro -> (vlExtrinsico/vlAcao-vlOpcao)*100
	 * 
	 * 		% Prote��o -> (1 - (Valor da a��o - valor da op�o) / valor da a��o)*100;
	 * 
	 * 		% Lucro por m�s: percentual de lucro / (dias corridos / 30); 
	 * 
	 * 	4 - Montar os filtros default
	 * 
	 */
	
	public List<Lancamento> buscarLancamentos(Integer idAcao){
		
		//Inicializa��es.
		OpcaoBusiness ob = new OpcaoBusiness();
		CotacaoOpcaoBusiness cob = new CotacaoOpcaoBusiness();
		CotacaoAcaoBusiness cab = new CotacaoAcaoBusiness();
		List<CotacaoOpcao> cotacoesOpcoes = new ArrayList<CotacaoOpcao>();
		Util util = new Util();
		
		//Buscar a cota��o da a��o.
		CotacaoAcao cotacaoAcao = cab.getCotacaoByIdAcao(idAcao);

		//Buscar as op��es de compra de acordo com a��o.
		List<Opcao> opcoes = ob.getOpcoesDeCompraByAcao(idAcao);
		
		//Buscar as cota��es das op��es.
		for (Opcao opcao : opcoes){
			CotacaoOpcao co = cob.getCotacaoByCodigo(opcao.getCodigo());
			if (co.getUltimo() > 0){
				cotacoesOpcoes.add(co);	
			}
		}
		List<Lancamento> lancamentos = new ArrayList<Lancamento>();
		for(CotacaoOpcao cotacaoOpcao : cotacoesOpcoes){
			
			//Calcula quantos dias at� o vencimento da S�rie.
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
		
		//Buscar a cota��o da a��o.
		CotacaoAcao cotacaoAcao = cab.getCotacaoByIdAcao(idAcao);
		
		//Buscar as op��es de acordo com a��o e s�rie selecionada.
		List<Opcao> opcoes = ob.getBySerieByAcaoOrderByVlExerc(idSerie, idAcao);
		
		//Calcula quantos dias at� o vencimento da S�rie.
		Serie serie = sb.getSerieById(idSerie);
		
		Util util = new Util();
		Integer diasParaVencimentoSerie = util.getQtdDiasAteData(serie.getDataExercicio()); 
		
		System.out.println("Dias ate o vencimento: "+diasParaVencimentoSerie);
		
		List<CotacaoOpcao> cotacoesOpcoes = new ArrayList<CotacaoOpcao>();
		//Buscar as cota��es das op��es.
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
