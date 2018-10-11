package br.com.tradeideas.handler;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UIParameter;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.hibernate.Session;

import br.com.tradeideas.dao.DAO;
import br.com.tradeideas.entity.Acao;
import br.com.tradeideas.util.HibernateUtil;

public class CrudAcaoHandler {
	
	private Acao acao = new Acao();

	public Acao getAcao() {
		return acao;
	}

	public List<Acao> getAcoes(){
		Session session = HibernateUtil.currentSession();
		DAO<Acao> dao = new DAO<Acao>(session, Acao.class);
		return dao.list();
	}
	
	public String salva (){
		Session session = HibernateUtil.currentSession();
		DAO<Acao> dao = new DAO<Acao>(session, Acao.class);
		
		dao.merge(this.acao);
		this.acao = new Acao();

		return "sucesso";	
	}
	
	public String cancel (){
		this.acao = new Acao();
		return "sucesso";	
	}
	
	public void exclui(ActionEvent event){
		Session session = HibernateUtil.currentSession();
		DAO<Acao> dao = new DAO<Acao>(session, Acao.class);
		
		UIComponent link = event.getComponent();
		UIParameter param = (UIParameter)link.findComponent("excluiId");
		Integer id = (Integer)param.getValue();
		this.acao = dao.load(id);
		
		dao.delete(this.acao);
		this.acao = new Acao();
	}

	public void escolheAcao(ActionEvent event){
		UIComponent link = event.getComponent();
		UIParameter param = (UIParameter)link.findComponent("editId");
		Integer id = (Integer)param.getValue();
		
		Session session = HibernateUtil.currentSession();
		DAO<Acao> dao = new DAO<Acao>(session, Acao.class);
		
		this.acao = dao.get(id);
	}
	
	public List<SelectItem> getAcoesParaComboBox(){
		List<SelectItem> lista = new ArrayList<SelectItem>();
		List<Acao> acoes = getAcoes();
		for(Acao c : acoes){
			lista.add(new SelectItem(c.getId(), c.getCodigo()));
		}
		return lista;
	}


}
