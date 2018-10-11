package br.com.tradeideas.business;

import java.util.List;

import org.hibernate.Session;

import br.com.tradeideas.dao.SerieDAO;
import br.com.tradeideas.entity.Serie;
import br.com.tradeideas.util.HibernateUtil;

public class SerieBusiness {
	
	
	public List<Serie> getSeries(){
		Session session = HibernateUtil.currentSession();
		SerieDAO cd = new SerieDAO(session, Serie.class);
		return cd.getSeries();
	}
	

	public List<Serie> getSeriesByTipo(String tipo){
		Session session = HibernateUtil.currentSession();
		SerieDAO cd = new SerieDAO(session, Serie.class);
		return cd.getSerieByTipo(tipo);
	}

	
	public Serie getSerieById(Integer idSerie){
		Session session = HibernateUtil.currentSession();
		SerieDAO cd = new SerieDAO(session, Serie.class);
		return cd.getSerieById(idSerie);
		
	}
	
}
