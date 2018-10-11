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
@Table(name="cotacaoopcao")
public class CotacaoOpcao {
	
	@Id @GeneratedValue
	private Integer id; //1
	private Float ultimo;
	private Float oscilacao;
	
	//private Integer qUlt;
	//private Integer qoc;
	//private Float ofc;
	//private Integer qov;
	//private Float ofv;

	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data; //21/07/2011 : 10:22:30
	@ManyToOne
	private Opcao opcao; //PETRF46
	
	
	public String getDataStr(){
		return Util.getDataAsDiaMesAnoHoraMinuto(data);
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


	public Calendar getData() {
		return data;
	}


	public void setData(Calendar data) {
		this.data = data;
	}


	public Opcao getOpcao() {
		return opcao;
	}


	public void setOpcao(Opcao opcao) {
		this.opcao = opcao;
	}
	

	

}
