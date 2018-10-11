package br.com.tradeideas.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import br.com.tradeideas.entity.Usuario;

public class UsuarioDAO extends DAO{

	public UsuarioDAO(Session session, Class persistentClass) {
		super(session, persistentClass);
	}
	
	public Usuario getUsuarioByEmaiBySenha(Usuario user){
		Usuario retorno = null;
		
		Criteria c = session.createCriteria(Usuario.class);
		c.add(Restrictions.ilike("email", user.getEmail()));
		c.add(Restrictions.ilike("senha", user.getSenha()));
		
		List<Usuario> resultados = c.list();
		if (resultados==null || resultados.isEmpty()){
			return null;
		}else{
			retorno = resultados.get(0);
		}
		return retorno;
	}

	public Usuario getUsuarioByEmail(Usuario user){
		Usuario retorno = null;
		
		Criteria c = session.createCriteria(Usuario.class);
		c.add(Restrictions.ilike("email", user.getEmail()));
		
		List<Usuario> resultados = c.list();
		if (resultados==null || resultados.isEmpty()){
			return null;
		}else{
			retorno = resultados.get(0);
		}
		return retorno;
	}


}
