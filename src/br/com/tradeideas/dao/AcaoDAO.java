package br.com.tradeideas.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.tradeideas.entity.Acao;
import br.com.tradeideas.entity.Opcao;

public class AcaoDAO extends DAO{

	public AcaoDAO(Session session, Class persistentClass) {
		super(session, persistentClass);
	}
	
	
	public List<Acao> getAcoes(){
		List<Acao> retorno = new ArrayList<Acao>();
		
		Criteria c = session.createCriteria(Acao.class);
		c.addOrder(Order.asc("id"));
		retorno = c.list();
		return retorno;
	}

	
	public List<Acao> getAcaoById(Integer idAcao){
		List<Acao> retorno = new ArrayList<Acao>();
		
		Criteria c = session.createCriteria(Acao.class);
		c.add(Restrictions.eq("acao.id", idAcao));
		
		retorno = c.list();
		return retorno;
	}

	public List<Acao> getAcaoByAcao(Acao acao){
		return getAcaoById(acao.getId());
	}
	
	public Acao getAcaoByCodigo(String codigoAcao){
		
		Criteria c = session.createCriteria(Acao.class);
		c.add(Restrictions.eq("codigo", codigoAcao));
		List<Acao> retorno = new ArrayList<Acao>();
		retorno = c.list();
		return retorno.get(0);
		
	}

}
