package br.com.tradeideas.handler;

import java.util.ArrayList;
import java.util.List;

import br.com.tradeideas.business.AcaoBusiness;
import br.com.tradeideas.business.CotacaoOpcaoBusiness;
import br.com.tradeideas.business.OpcaoBusiness;
import br.com.tradeideas.entity.Acao;
import br.com.tradeideas.entity.CotacaoOpcao;
import br.com.tradeideas.entity.Opcao;

public class CotacaoOpcaoHandler {
	
	private List<Acao> acoes = new ArrayList<Acao>();
	private List<Opcao> opcoes = new ArrayList<Opcao>();
	private List<CotacaoOpcao> cotacoesOpcoes = new ArrayList<CotacaoOpcao>();
	
	
	public List<CotacaoOpcao> getCotacoesOpcoes(){
		if (cotacoesOpcoes.isEmpty()){
			CotacaoOpcaoBusiness cob = new CotacaoOpcaoBusiness();
			cotacoesOpcoes = cob.getCotacoesOpcoes();
		}
		return cotacoesOpcoes;		
	}
	
	

}
