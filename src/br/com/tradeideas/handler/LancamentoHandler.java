package br.com.tradeideas.handler;

import java.util.ArrayList;
import java.util.List;

import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.model.SelectItem;

import org.richfaces.component.html.HtmlInputNumberSlider;

import br.com.tradeideas.business.AcaoBusiness;
import br.com.tradeideas.business.LancamentoBusiness;
import br.com.tradeideas.business.SerieBusiness;
import br.com.tradeideas.entity.Acao;
import br.com.tradeideas.entity.Lancamento;
import br.com.tradeideas.entity.Serie;
import br.com.tradeideas.util.Util;

public class LancamentoHandler {
	
	Acao acao = new Acao();
	Serie serie = new Serie();
	List<Lancamento> lancamentos = new ArrayList<Lancamento>();
	List<Lancamento> lancamentosRefinados = new ArrayList<Lancamento>();
	
	private HtmlSelectOneMenu acaoSelecionada;
	private HtmlSelectOneMenu serieSelecionada;
	
	private HtmlInputNumberSlider protecaoRefinada;
	private HtmlInputNumberSlider lucroRefinado;
	
	private Float protecao;
	private Float lucroMes;
	private Integer quantidade;
	
	
	public String buscar(){

		Integer idAcao = Integer.parseInt(acaoSelecionada.getValue().toString());
		Integer idSerie = Integer.parseInt(serieSelecionada.getValue().toString());
		
		if (idAcao == -1){
			return "";
		}
		LancamentoBusiness lb = new LancamentoBusiness();
		if (idSerie == -1){
			lancamentos = lb.buscarLancamentos(idAcao);
		}else{
			lancamentos = lb.buscarLancamentos(idAcao, idSerie);	
		}
		refinaLista();

		return "";
	}
	
	
	
	public void refinaLista(){
		
		Float valorMinProtecao = Float.parseFloat(protecaoRefinada.getValue().toString());
		Float valorMinLucroMes = Float.parseFloat(lucroRefinado.getValue().toString());
		
		System.out.println("valorMinProtecao: "+valorMinProtecao);
		System.out.println("valorMinLucroMes: "+valorMinLucroMes);
		
		lancamentosRefinados = new ArrayList<Lancamento>();
		
		for (Lancamento lancamento : lancamentos){
			if (lancamento.getPctProtecao() >= valorMinProtecao){
				
				System.out.println("Estou dizendo que "+lancamento.getPctProtecao()+ "é maior que "+valorMinProtecao);
				
				if (lancamento.getPctLucroMes() >= valorMinLucroMes){
					
					System.out.println("E que "+lancamento.getPctLucroMes()+ "é maior que "+valorMinLucroMes);
					
					lancamentosRefinados.add(lancamento);	
				}
			}
		}
	}
	
	
	public boolean isLancamentosToShow(){
		if (lancamentos.isEmpty()){
			return false;
		}
		return true;
	}


	public List<SelectItem> getAcoesParaComboBox(){
		List<SelectItem> lista = new ArrayList<SelectItem>();
		AcaoBusiness ab = new AcaoBusiness();
		List<Acao> acoes = ab.getAcoes();
		for(Acao c : acoes){
			lista.add(new SelectItem(c.getId(), c.getCodigo()));
		}
		return lista;
	}


	public List<SelectItem> getSeriesParaComboBox(){
		List<SelectItem> lista = new ArrayList<SelectItem>();
		SerieBusiness sb = new SerieBusiness();
		List<Serie> series = sb.getSeriesByTipo("CALL");
		for(Serie s : series){
			
			String vencSerie = Util.getDataAsDiaMesAno(s.getDataExercicio());  
			String nomeLegalSerie = "Serie "+s.getNome() + " - ("+vencSerie+")";
			
			lista.add(new SelectItem(s.getId(), nomeLegalSerie));
		}
		return lista;
	}
	
	
	public Acao getAcao() {
		return acao;
	}
	public void setAcao(Acao acao) {
		this.acao = acao;
	}
	public Serie getSerie() {
		return serie;
	}
	public void setSerie(Serie serie) {
		this.serie = serie;
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

	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}



	public void setLancamentos(List<Lancamento> lancamentos) {
		this.lancamentos = lancamentos;
	}


	public Float getProtecao() {
		return protecao;
	}


	public void setProtecao(Float protecao) {
		this.protecao = protecao;
	}


	public Float getLucroMes() {
		return lucroMes;
	}


	public void setLucroMes(Float lucroMes) {
		this.lucroMes = lucroMes;
	}


	public Integer getQuantidade() {
		return quantidade;
	}


	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public List<Lancamento> getLancamentosRefinados() {
		return lancamentosRefinados;
	}


	public void setLancamentosRefinados(List<Lancamento> lancamentosRefinados) {
		this.lancamentosRefinados = lancamentosRefinados;
	}


	public HtmlInputNumberSlider getProtecaoRefinada() {
		return protecaoRefinada;
	}


	public void setProtecaoRefinada(HtmlInputNumberSlider protecaoRefinada) {
		this.protecaoRefinada = protecaoRefinada;
	}


	public HtmlInputNumberSlider getLucroRefinado() {
		return lucroRefinado;
	}


	public void setLucroRefinado(HtmlInputNumberSlider lucroRefinado) {
		this.lucroRefinado = lucroRefinado;
	}
	
	
	
	
	

	
	

	
	

}
