package br.com.tradeideas.entity;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.tradeideas.util.Util;


@Entity
@Table(name="cotacaoacao")
public class CotacaoAcao {
	
	@Id @GeneratedValue
	private Integer id; 
	private Float ultimo;
	private Float oscilacao;
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataHora; 
	@ManyToOne
	private Acao acao; 
	

	//private Integer qoc;
	//private Float ofc;
	//private Integer qov;
	//private Float ofv;
	//private Integer qUlt;
	
	
	
	public String getDataStr(){
		return Util.getDataAsDiaMesAnoHoraMinuto(dataHora);
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Float getUltimo() {
		return ultimo;
	}


	public void setUltimo(Float ultimo) {
		this.ultimo = ultimo;
	}


	public Float getOscilacao() {
		return oscilacao;
	}


	public void setOscilacao(Float oscilacao) {
		this.oscilacao = oscilacao;
	}


	public Calendar getDataHora() {
		return dataHora;
	}


	public void setDataHora(Calendar dataHora) {
		this.dataHora = dataHora;
	}


	public Acao getAcao() {
		return acao;
	}


	public void setAcao(Acao acao) {
		this.acao = acao;
	}
	
	

}
