package br.com.tradeideas.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.tradeideas.entity.Acao;
import br.com.tradeideas.entity.Opcao;

public class OpcaoDAO extends DAO{

	public OpcaoDAO(Session session, Class persistentClass) {
		super(session, persistentClass);
	}
	
	public List<Opcao> getOpcaoByAcao(Integer idAcao){
		List<Opcao> retorno = new ArrayList<Opcao>();
		
		Criteria c = session.createCriteria(Opcao.class);
		c.add(Restrictions.eq("acao.id", idAcao));
		c.addOrder(Order.asc("id"));
		
		retorno = c.list();
		return retorno;
	}

	public List<Opcao> getOpcoesDeCompraByAcao(Integer idAcao){
		List<Opcao> retorno = new ArrayList<Opcao>();
		
		Criteria c = session.createCriteria(Opcao.class).createAlias("serie", "serie");
		c.add(Restrictions.eq("acao.id", idAcao));
		c.add(Restrictions.eq("serie.tipo", "CALL"));
		c.addOrder(Order.asc("id"));
		
		retorno = c.list();
		return retorno;
	}

	
	
	public List<Opcao> getOpcoes(){
		List<Opcao> retorno = new ArrayList<Opcao>();
		
		Criteria c = session.createCriteria(Opcao.class);
		c.addOrder(Order.asc("id"));
		retorno = c.list();
		return retorno;
	}

	
	public List<Opcao> getOpcaoByAcao(Acao acao){
		return getOpcaoByAcao(acao.getId());
	}
	


	public Opcao getOpcaoByCodigo(String codigoOpcao){
		
		Criteria c = session.createCriteria(Opcao.class);
		c.add(Restrictions.eq("codigo", codigoOpcao));
		
		Opcao retorno = (Opcao)c.list().get(0);
		return retorno;
	}
	
	public List<Opcao> getBySerieByAcaoOrderByVlExerc(Integer idSerie, Integer idAcao){
		
		Criteria c = session.createCriteria(Opcao.class);
		c.add(Restrictions.eq("serie.id", idSerie));
		c.add(Restrictions.eq("acao.id", idAcao));
		c.addOrder(Order.asc("valorExerc"));
		
		List lista = c.list();
		if (lista==null || lista.isEmpty()){
			return null;
		}
		return lista;
	}


	
}
