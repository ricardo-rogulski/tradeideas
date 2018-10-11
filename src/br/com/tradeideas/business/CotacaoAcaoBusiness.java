package br.com.tradeideas.business;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Session;

import br.com.tradeideas.dao.AcaoDAO;
import br.com.tradeideas.dao.CotacaoAcaoDAO;
import br.com.tradeideas.entity.Acao;
import br.com.tradeideas.entity.CotacaoAcao;
import br.com.tradeideas.util.HibernateUtil;

public class CotacaoAcaoBusiness {
	
	public CotacaoAcao getCotacaoByCodigo(String code){
		Session session = HibernateUtil.currentSession();
		CotacaoAcaoDAO cad = new CotacaoAcaoDAO(session, CotacaoAcao.class);
		return cad.getCotacaoAcaoByCodigo(code);
	}

	public CotacaoAcao getCotacaoByIdAcao(Integer idAcao){
		Session session = HibernateUtil.currentSession();
		CotacaoAcaoDAO cad = new CotacaoAcaoDAO(session, CotacaoAcao.class);
		return cad.getCotacaoAcaoByIdAcao(idAcao);
	}

	
	
	public List<CotacaoAcao> getCotacoesAcoes(){
		Session session = HibernateUtil.currentSession();
		CotacaoAcaoDAO cad = new CotacaoAcaoDAO(session, CotacaoAcao.class);
		return cad.getCotacoesAcoes();
	}
	
	public void saveByRobo(CotacaoAcao cotacao){
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		CotacaoAcaoDAO cd = new CotacaoAcaoDAO(session, CotacaoAcao.class);
		cd.merge(cotacao);
		session.getTransaction().commit();
		session.close();
	}

	public void deleteByRobo(String code){
		Session session = HibernateUtil.openSession();
		session.beginTransaction();
		CotacaoAcaoDAO cd = new CotacaoAcaoDAO(session, CotacaoAcao.class);
		CotacaoAcao cotacao = getCotacaoByCodigo(code);
		cd.delete(cotacao);
		session.getTransaction().commit();
		session.close();
	}
	
}
