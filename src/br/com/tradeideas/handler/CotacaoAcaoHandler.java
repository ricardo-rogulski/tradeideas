package br.com.tradeideas.handler;

import java.util.ArrayList;
import java.util.List;

import br.com.tradeideas.business.CotacaoAcaoBusiness;
import br.com.tradeideas.entity.CotacaoAcao;

public class CotacaoAcaoHandler {
	
	private List<CotacaoAcao> cotacoesAcoes = new ArrayList<CotacaoAcao>();
	
	
	public List<CotacaoAcao> getCotacoesAcoes(){
		if (cotacoesAcoes.isEmpty()){
			CotacaoAcaoBusiness cab = new CotacaoAcaoBusiness();
			cotacoesAcoes = cab.getCotacoesAcoes();
		}
		return cotacoesAcoes;		
	}

}
