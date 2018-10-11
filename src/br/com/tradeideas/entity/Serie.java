package br.com.tradeideas.entity;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.tradeideas.util.Util;


@Entity
public class Serie {
	 
	@Id @GeneratedValue
	private Integer id;
	private String tipo; //CALL ou PUT.
	private String nome; //SERIE B
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar dataExercicio = new GregorianCalendar(); //21/07/2011
	private boolean ativo;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Calendar getDataExercicio() {
		return dataExercicio;
	}
	public void setDataExercicio(Calendar dataExercicio) {
		this.dataExercicio = dataExercicio;
	}
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
	public String getDataExercicioStr(){
		return Util.getDataAsDiaMesAno(dataExercicio);
	}

	
	
	
}
