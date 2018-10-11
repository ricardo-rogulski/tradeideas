package br.com.tradeideas.business;

import java.util.List;

import org.hibernate.Session;

import br.com.tradeideas.dao.CotacaoOpcaoDAO;
import br.com.tradeideas.entity.CotacaoOpcao;
import br.com.tradeideas.util.HibernateUtil;

public class CotacaoOpcaoBusiness {
	
	public CotacaoOpcao getCotacaoByCodigo(String code){
		Session session = HibernateUtil.currentSession();
		CotacaoOpcaoDAO cad = new CotacaoOpcaoDAO(session, CotacaoOpcao.class);
		return cad.getCotacaoOpcaoByCodigo(code);
	}
	
	public List<CotacaoOpcao> getCotacoesOpcoes(){
		Session session = HibernateUtil.currentSession();
		CotacaoOpcaoDAO cad = new CotacaoOpcaoDAO(session, CotacaoOpcao.class);
		return cad.getCotacoesOpcoes();
	}


	
}
