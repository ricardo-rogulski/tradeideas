package br.com.tradeideas.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import br.com.tradeideas.business.CotacaoOpcaoBusiness;

@Entity
public class Opcao {
	 
	@Id @GeneratedValue
	private Integer id;
	private String codigo;
	private Float valorExerc;
	private boolean ativo;
	
	
	@Transient
	private Float valor;
	@Transient
	private Float oscilacao;

	
	
	@ManyToOne
	private Acao acao;

	@ManyToOne
	private Serie serie;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Float getValorExerc() {
		return valorExerc;
	}

	public void setValorExerc(Float valorExerc) {
		this.valorExerc = valorExerc;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
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
	
	
	public Float getValor() {
		if (valor==null){
				CotacaoOpcaoBusiness cob = new CotacaoOpcaoBusiness();
				CotacaoOpcao cotacao = cob.getCotacaoByCodigo(codigo);
				valor = cotacao.getUltimo();
				oscilacao = cotacao.getOscilacao();
		}
		return valor;
	}
	public void setValor(Float valor) {
		this.valor = valor;
	}
	public Float getOscilacao() {
		if (oscilacao==null){
			CotacaoOpcaoBusiness cob = new CotacaoOpcaoBusiness();
			CotacaoOpcao cotacao = cob.getCotacaoByCodigo(codigo);
			valor = cotacao.getUltimo();
			oscilacao = cotacao.getOscilacao();
		}
		return oscilacao;
	}
	public void setOscilacao(Float oscilacao) {
		this.oscilacao = oscilacao;
	}


}
