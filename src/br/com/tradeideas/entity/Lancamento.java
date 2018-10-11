package br.com.tradeideas.entity;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="lancamento")
public class Lancamento {
	
	@Id @GeneratedValue
	private Integer id;
	private String acao;	
	private String opcao;
	private Float valorOpcao;
	private Float valorAcao;
	private Float valorStrike;
	private Integer diasParaVenctoSerie;

	//private Integer qoc;
	
	
	/*
	 * Métodos de cálculo
	 */
	
	
	
	public Float getValorExtrinsico(){
		
		/* Valor extrinsico -> Se strike, é maior ou igual o valor da ação, o valor extrisico é o valor da opção.
		 * 					-> Caso contrário, pegar o valor da opção mais o strike, e subtrair da ação.
		*/
		if (valorStrike >= valorAcao){
			return valorOpcao;
		}
		Float valor = valorOpcao + valorStrike - valorAcao;
		return valor;		
	}
	public Float getValorExtrinsicoStr(){
		return paraDuasCasas(getValorExtrinsico());
	}
	
	
	private Float getPctLucro(){
		//% de lucro -> (vlExtrinsico/vlAcao-vlOpcao)*100
		Float valor = (getValorExtrinsico()/(valorAcao-valorOpcao)*100);
		return valor;
	}
	public float getPctLucroStr(){
		return paraDuasCasas(getPctLucro());
	}
	
	
	public Float getPctProtecao(){
		//% Proteção -> (Valor da ação - valor da opção) / valor da ação;
		
		if (valorStrike < valorAcao){
			Float valor = (1 - ((valorAcao - valorOpcao)/valorAcao))*100;
			return valor;
		}
		return 0f;
		
	}
	public float getPctProtecaoStr(){
		return paraDuasCasas(getPctProtecao());
	}
	
	
	public Float getPctLucroMes(){
		//% Lucro por mês: percentual de lucro / (dias corridos / 30); 		
		
		if (diasParaVenctoSerie == 0){
			return 0f;
		}
		
		Float fatorMes = diasParaVenctoSerie/30f;
		Float lucro = getPctLucro();
		Float valor = lucro/fatorMes;
		return valor;
	}
	public float getPctLucroMesStr(){
		return paraDuasCasas(getPctLucroMes());
	}

		
	
	
	private float paraDuasCasas(Float numero){
		if (numero.isNaN() || numero.isInfinite()){
			return 0f;
		}
		BigDecimal aNumber = new BigDecimal(numero);  
		aNumber = aNumber.setScale(2, BigDecimal.ROUND_HALF_EVEN);      
		return aNumber.floatValue();
	}


	/*
	 * Fim dos métodos de cálculo.
	 */
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAcao() {
		return acao;
	}

	public void setAcao(String acao) {
		this.acao = acao;
	}

	public String getOpcao() {
		return opcao;
	}

	public void setOpcao(String opcao) {
		this.opcao = opcao;
	}

	public Float getValorOpcao() {
		return valorOpcao;
	}

	public void setValorOpcao(Float valorOpcao) {
		this.valorOpcao = valorOpcao;
	}

	public Float getValorAcao() {
		return valorAcao;
	}

	public void setValorAcao(Float valorAcao) {
		this.valorAcao = valorAcao;
	}

	public Float getValorStrike() {
		return valorStrike;
	}

	public void setValorStrike(Float valorStrike) {
		this.valorStrike = valorStrike;
	}
	public Integer getDiasParaVenctoSerie() {
		return diasParaVenctoSerie;
	}
	public void setDiasParaVenctoSerie(Integer diasParaVenctoSerie) {
		this.diasParaVenctoSerie = diasParaVenctoSerie;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acao == null) ? 0 : acao.hashCode());
		result = prime * result + ((diasParaVenctoSerie == null) ? 0 : diasParaVenctoSerie.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((opcao == null) ? 0 : opcao.hashCode());
		result = prime * result + ((valorAcao == null) ? 0 : valorAcao.hashCode());
		result = prime * result + ((valorOpcao == null) ? 0 : valorOpcao.hashCode());
		result = prime * result + ((valorStrike == null) ? 0 : valorStrike.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Lancamento other = (Lancamento) obj;
		if (acao == null) {
			if (other.acao != null)
				return false;
		} else if (!acao.equals(other.acao))
			return false;
		if (diasParaVenctoSerie == null) {
			if (other.diasParaVenctoSerie != null)
				return false;
		} else if (!diasParaVenctoSerie.equals(other.diasParaVenctoSerie))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (opcao == null) {
			if (other.opcao != null)
				return false;
		} else if (!opcao.equals(other.opcao))
			return false;
		if (valorAcao == null) {
			if (other.valorAcao != null)
				return false;
		} else if (!valorAcao.equals(other.valorAcao))
			return false;
		if (valorOpcao == null) {
			if (other.valorOpcao != null)
				return false;
		} else if (!valorOpcao.equals(other.valorOpcao))
			return false;
		if (valorStrike == null) {
			if (other.valorStrike != null)
				return false;
		} else if (!valorStrike.equals(other.valorStrike))
			return false;
		return true;
	}

	
	
	
	
	
	

	
	
	
	
}
