package br.com.tradeideas.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.tradeideas.entity.Acao;
import br.com.tradeideas.entity.CotacaoAcao;

public class CotacaoAcaoDAO extends DAO{

	public CotacaoAcaoDAO(Session session, Class persistentClass) {
		super(session, persistentClass);
	}
	
	
	public List<CotacaoAcao> getCotacoesAcoes(){
		List<CotacaoAcao> retorno = new ArrayList<CotacaoAcao>();
		
		Criteria c = session.createCriteria(CotacaoAcao.class);
		c.addOrder(Order.asc("id"));
		retorno = c.list();
		return retorno;
	}


	public CotacaoAcao getCotacaoAcaoByAcao(Acao acao){
		return getCotacaoAcaoByCodigo(acao.getCodigo());
	}
	
	public CotacaoAcao getCotacaoAcaoByCodigo(String codigoAcao){
		Criteria c = session.createCriteria(CotacaoAcao.class).createAlias("acao", "acao");
		c.add(Restrictions.eq("acao.codigo", codigoAcao));
		List<CotacaoAcao> retorno = new ArrayList<CotacaoAcao>();
		retorno = c.list();
		return retorno.get(0);
		
	}


	public CotacaoAcao getCotacaoAcaoByIdAcao(Integer idAcao){
		Criteria c = session.createCriteria(CotacaoAcao.class).createAlias("acao", "acao");
		c.add(Restrictions.eq("acao.id", idAcao));
		List<CotacaoAcao> retorno = new ArrayList<CotacaoAcao>();
		retorno = c.list();
		return retorno.get(0);
		
	}


}
