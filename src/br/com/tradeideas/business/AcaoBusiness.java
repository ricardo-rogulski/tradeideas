package br.com.tradeideas.business;

import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;

import org.hibernate.Session;

import br.com.tradeideas.dao.AcaoDAO;
import br.com.tradeideas.entity.Acao;
import br.com.tradeideas.util.HibernateUtil;

public class AcaoBusiness {
	
	
	public List<Acao> getAcoes(){
		Session session = HibernateUtil.currentSession();
		AcaoDAO cd = new AcaoDAO(session, Acao.class);
		return cd.getAcoes();
	}
	
	public Acao getAcaoByCodigo(String codigoAcao){
		Session session = HibernateUtil.currentSession();
		AcaoDAO cd = new AcaoDAO(session, Acao.class);
		
		codigoAcao.le
		
		return cd.getAcaoByCodigo(codigoAcao);	
		
		
	}

	
	public List<Acao> getAcoesByRobo(){
		
		
		System.out.println("0.1");
		
		Session session = HibernateUtil.openSession();
		
		System.out.println("0.2");
		AcaoDAO cd = new AcaoDAO(session, Acao.class);
		System.out.println("0.3");
		List<Acao> acoes = cd.getAcoes();
		System.out.println("0.4");
		session.close();
		System.out.println("0.5");
		return acoes;
	}

}
