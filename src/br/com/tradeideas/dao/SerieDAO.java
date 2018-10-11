package br.com.tradeideas.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.tradeideas.entity.Serie;

public class SerieDAO extends DAO{

	public SerieDAO(Session session, Class persistentClass) {
		super(session, persistentClass);
	}
	
	public Serie getSerieById(Integer idSerie){
		List<Serie> retorno = new ArrayList<Serie>();
		
		Criteria c = session.createCriteria(Serie.class);
		c.add(Restrictions.eq("id", idSerie));
		
		retorno = c.list();
		return retorno.get(0);
	}

	public Serie getSerieBySerie(Serie serie){
		return getSerieById(serie.getId());
	}
	
	public Serie getSerieByNome(String nomeSerie){
		Criteria c = session.createCriteria(Serie.class);
		c.add(Restrictions.eq("nome", nomeSerie));
		List<Serie> retorno = new ArrayList<Serie>();
		retorno = c.list();
		return retorno.get(0);
	}


	public List<Serie> getSerieByTipo(String tipoSerie){
		Criteria c = session.createCriteria(Serie.class);
		c.add(Restrictions.eq("tipo", tipoSerie));
		List<Serie> retorno = new ArrayList<Serie>();
		retorno = c.list();
		return retorno;
	}

	
	public List<Serie> getSeries(){
		Criteria c = session.createCriteria(Serie.class);
		List<Serie> retorno = new ArrayList<Serie>();
		retorno = c.list();
		return retorno;
		
	}

}
