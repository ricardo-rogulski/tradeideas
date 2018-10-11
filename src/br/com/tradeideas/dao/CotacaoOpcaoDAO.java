package br.com.tradeideas.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.tradeideas.entity.CotacaoAcao;
import br.com.tradeideas.entity.CotacaoOpcao;
import br.com.tradeideas.entity.Opcao;

public class CotacaoOpcaoDAO extends DAO{

	public CotacaoOpcaoDAO(Session session, Class persistentClass) {
		super(session, persistentClass);
	}
	
	
	public List<CotacaoOpcao> getCotacoesOpcoes(){
		List<CotacaoOpcao> retorno = new ArrayList<CotacaoOpcao>();
		
		Criteria c = session.createCriteria(CotacaoOpcao.class);
		c.addOrder(Order.asc("id"));
		retorno = c.list();
		return retorno;
	}


	public CotacaoOpcao getCotacaoOpcaoByOpcao(Opcao opcao){
		return getCotacaoOpcaoByCodigo(opcao.getCodigo());
	}
	
	public CotacaoOpcao getCotacaoOpcaoByCodigo(String codigoOpcao){
		Criteria c = session.createCriteria(CotacaoOpcao.class).createAlias("opcao", "opcao");
		c.add(Restrictions.eq("opcao.codigo", codigoOpcao));
		List<CotacaoOpcao> retorno = new ArrayList<CotacaoOpcao>();
		retorno = c.list();
		return retorno.get(0);
		
	}

}
