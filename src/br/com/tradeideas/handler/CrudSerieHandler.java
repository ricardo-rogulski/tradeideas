package br.com.tradeideas.handler;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.component.UIParameter;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.hibernate.Session;

import br.com.tradeideas.dao.DAO;
import br.com.tradeideas.entity.Serie;
import br.com.tradeideas.util.HibernateUtil;

public class CrudSerieHandler {
	
	private Serie serie = new Serie();
	
	private HtmlSelectOneMenu tipoSerieSelecionada;
	
	
	public HtmlSelectOneMenu getTipoSerieSelecionada() {
		return tipoSerieSelecionada;
	}

	public void setTipoSerieSelecionada(HtmlSelectOneMenu tipoSerieSelecionada) {
		this.tipoSerieSelecionada = tipoSerieSelecionada;
	}

	public Serie getSerie() {
		return serie;
	}

	public List<Serie> getSeries(){
		Session session = HibernateUtil.currentSession();
		DAO<Serie> dao = new DAO<Serie>(session, Serie.class);
		return dao.list();
	}
	
	public String salva (){
		Session session = HibernateUtil.currentSession();
		DAO<Serie> dao = new DAO<Serie>(session, Serie.class);
		
		dao.merge(this.serie);
		this.serie = new Serie();

		return "sucesso";	
	}
	
	public String cancel (){
		this.serie = new Serie();
		return "sucesso";	
	}
	
	public void exclui(ActionEvent event){
		Session session = HibernateUtil.currentSession();
		DAO<Serie> dao = new DAO<Serie>(session, Serie.class);
		
		UIComponent link = event.getComponent();
		UIParameter param = (UIParameter)link.findComponent("excluiId");
		Integer id = (Integer)param.getValue();
		this.serie = dao.load(id);
		
		dao.delete(this.serie);
		this.serie = new Serie();
	}

	public void escolheSerie(ActionEvent event){
		UIComponent link = event.getComponent();
		UIParameter param = (UIParameter)link.findComponent("editId");
		Integer id = (Integer)param.getValue();
		
		Session session = HibernateUtil.currentSession();
		DAO<Serie> dao = new DAO<Serie>(session, Serie.class);
		
		this.serie = dao.get(id);
	}
	
	public List<SelectItem> getSeriesParaComboBox(){
		List<SelectItem> lista = new ArrayList<SelectItem>();
		List<Serie> series = getSeries();
		for(Serie c : series){
			lista.add(new SelectItem(c.getId(), c.getNome()));
		}
		return lista;
	}

	
	public List<SelectItem> getTiposOpcaoParaComboBox(){
		List<SelectItem> lista = new ArrayList<SelectItem>();
		lista.add(new SelectItem("CALL", "CALL"));
		lista.add(new SelectItem("PUT", "PUT"));
		return lista;
	}


}
