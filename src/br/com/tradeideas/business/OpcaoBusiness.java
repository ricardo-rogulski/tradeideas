package br.com.tradeideas.business;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.hibernate.Session;

import br.com.tradeideas.dao.OpcaoDAO;
import br.com.tradeideas.entity.Opcao;
import br.com.tradeideas.util.HibernateUtil;

public class OpcaoBusiness {
	
	
	public List<Opcao> getOpcoes(){
		Session session = HibernateUtil.currentSession();
		OpcaoDAO cd = new OpcaoDAO(session, Opcao.class);
		return cd.getOpcoes();
	}
	
	public Opcao getOpcaoByCodigo(String codigoOpcao){
		Session session = HibernateUtil.currentSession();
		OpcaoDAO cd = new OpcaoDAO(session, Opcao.class);
		return cd.getOpcaoByCodigo(codigoOpcao);		
	}

	

	public List<Opcao> getOpcoesDeCompraByAcao(Integer idAcao){
		Session session = HibernateUtil.currentSession();
		OpcaoDAO od = new OpcaoDAO(session, Opcao.class);
		return od.getOpcoesDeCompraByAcao(idAcao);
	}

	
	
	public List<Opcao> getBySerieByAcaoOrderByVlExerc(Integer idSerie, Integer idAcao){
		Session session = HibernateUtil.currentSession();
		OpcaoDAO od = new OpcaoDAO(session, Opcao.class);
		return od.getBySerieByAcaoOrderByVlExerc(idSerie, idAcao);
	}


	
	
}
