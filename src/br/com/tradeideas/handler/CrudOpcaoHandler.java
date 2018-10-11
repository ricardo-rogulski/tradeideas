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
import br.com.tradeideas.entity.Acao;
import br.com.tradeideas.entity.Opcao;
import br.com.tradeideas.entity.Serie;
import br.com.tradeideas.util.HibernateUtil;

public class CrudOpcaoHandler {
	
	private Opcao opcao = new Opcao();

	public CrudOpcaoHandler(){
		this.opcao = montaOpcao();
	}
	
	private HtmlSelectOneMenu acaoSelecionada;
	private HtmlSelectOneMenu serieSelecionada;
	
	public Opcao getOpcao() {
		return opcao;
	}
	
	public Opcao montaOpcao(){
		Acao acao = new Acao();	
		Serie serie = new Serie();
		
		this.opcao = new Opcao();
		opcao.setAcao(acao);
		opcao.setSerie(serie);
		return opcao;
	}

	
	public HtmlSelectOneMenu getAcaoSelecionada() {
		return acaoSelecionada;
	}

	public void setAcaoSelecionada(HtmlSelectOneMenu acaoSelecionada) {
		this.acaoSelecionada = acaoSelecionada;
	}
	
	public HtmlSelectOneMenu getSerieSelecionada() {
		return serieSelecionada;
	}

	public void setSerieSelecionada(HtmlSelectOneMenu serieSelecionada) {
		this.serieSelecionada = serieSelecionada;
	}

	public List<Opcao> getOpcoes(){
		Session session = HibernateUtil.currentSession();
		DAO<Opcao> dao = new DAO<Opcao>(session, Opcao.class);
		return dao.list();
	}
	
	public String salva (){
		Session session = HibernateUtil.currentSession();
		DAO<Opcao> dao = new DAO<Opcao>(session, Opcao.class);
		
		DAO<Acao> acaoDao = new DAO<Acao>(session, Acao.class);
		Integer id = Integer.parseInt(acaoSelecionada.getValue().toString());		
		Acao c = acaoDao.load(id); 
		this.opcao.setAcao(c);
		
		dao.merge(this.opcao);
		this.opcao = montaOpcao();

		return "sucesso";	
	}
	
	public void exclui(ActionEvent event){
		Session session = HibernateUtil.currentSession();
		DAO<Opcao> dao = new DAO<Opcao>(session, Opcao.class);
		
		UIComponent link = event.getComponent();
		UIParameter param = (UIParameter)link.findComponent("excluiId");
		Integer id = (Integer)param.getValue();
		this.opcao = dao.load(id);
		
		dao.delete(this.opcao);
		this.opcao = montaOpcao();
	}

	public void escolheOpcao(ActionEvent event){
		UIComponent link = event.getComponent();
		UIParameter param = (UIParameter)link.findComponent("editId");
		Integer id = (Integer)param.getValue();
		
		Session session = HibernateUtil.currentSession();
		DAO<Opcao> dao = new DAO<Opcao>(session, Opcao.class);
		
		this.opcao = dao.get(id);
	}
	
	public List<SelectItem> getOpcoesParaComboBox(){
		List<SelectItem> lista = new ArrayList<SelectItem>();
		List<Opcao> opcoes = getOpcoes();
		for(Opcao c : opcoes){
			lista.add(new SelectItem(c.getId(), c.getCodigo()));
		}
		return lista;
	}
	
	


}
