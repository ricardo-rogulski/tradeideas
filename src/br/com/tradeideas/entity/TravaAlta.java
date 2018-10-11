package br.com.tradeideas.entity;

import java.math.BigDecimal;
import java.text.DecimalFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="trava_alta")
public class TravaAlta {
	
	@Id @GeneratedValue
	private Integer id;
	private String acao;	
	private String opcaoCompra;
	private String opcaoVenda;
	private Float valorOpcaoCompra;
	private Float valorOpcaoVenda;
	private Float valorAcao;
	private Float valorExercOpcaoCompra;
	private Float valorExercOpcaoVenda;
	private Integer quantidade = 100;
	
	/*
	 * Métodos de cálculo, inerentes somente à classe Trava.
	 */
	
	private Float getMargemSeguranca(){
		Float margem = 100-((valorExercOpcaoVenda/valorAcao)*100);
		return paraDuasCasas(margem);
	}
	
	public Float getSpreedMaximo(){
		Float spreed = valorExercOpcaoVenda-valorExercOpcaoCompra;
		return paraDuasCasas(spreed);
	}
	
	public Float getSpreed(){
		Float spreed = valorOpcaoCompra-valorOpcaoVenda;
		return paraDuasCasas(spreed);
	}

	
	private Float getLucroPotencialRS(){
		Float lucro = ((getSpreedMaximo()-getSpreed())*quantidade);
		return paraDuasCasas(lucro);
	}
	
	private Float getLucroPotencialPCT(){
		
		Float lucroPotencialPCT = (getSpreedMaximo()/getSpreed())*100;
		
		//Float valorInvestido = getSpreed()*quantidade;
		//Float lucroPotencial = getLucroPotencialRS();
		//Float lucroPct = ((lucroPotencial/valorInvestido)*100);
		return paraDuasCasas(lucroPotencialPCT);		
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
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TravaAlta other = (TravaAlta) obj;
		if (opcaoCompra == null) {
			if (other.opcaoCompra != null)
				return false;
		} else if (!opcaoCompra.equals(other.opcaoCompra))
			return false;
		return true;
	}

	public Float getValorNegocio(){
		Float valorInvestido = getSpreed()*quantidade;
		return paraDuasCasas(valorInvestido);
	}
	
	public String getValorNegocioStr(){
		DecimalFormat df = new DecimalFormat("#,###.00");
		return df.format(getValorNegocio());
	}
	
	public String getQuantidadeStr(){
		DecimalFormat df = new DecimalFormat("#,###");
		return df.format(quantidade);
	}
	
	public String getMargemSegurancaStr(){
		DecimalFormat df = new DecimalFormat("0.00");
		String margem = df.format(Math.abs(getMargemSeguranca()));
		if (getMargemSeguranca()<0){
			return "Precisa subir "+margem+" %";
		}
		return "Pode cair " +margem+" %";
	}
	
	public String getLucroPotencialRSStr() {
		DecimalFormat df = new DecimalFormat("#,###.00");
		return df.format(getLucroPotencialRS());
	}

	public String getLucroPotencialPCTStr(){
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(getLucroPotencialPCT());		
	}
	
	public String getSpreedStr(){
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(getSpreed());		
	}

	public String getSpreedMaximoStr(){
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(getSpreedMaximo());		
	}
	

	public void setSpreedInicial(Float a){
		
	}
	
	public void setSpreedAtual(Float a){
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

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

	public String getOpcaoCompra() {
		return opcaoCompra;
	}

	public void setOpcaoCompra(String opcaoCompra) {
		this.opcaoCompra = opcaoCompra;
	}

	public String getOpcaoVenda() {
		return opcaoVenda;
	}

	public void setOpcaoVenda(String opcaoVenda) {
		this.opcaoVenda = opcaoVenda;
	}

	public Float getValorOpcaoCompra() {
		return valorOpcaoCompra;
	}

	public void setValorOpcaoCompra(Float valorOpcaoCompra) {
		this.valorOpcaoCompra = valorOpcaoCompra;
	}

	public Float getValorOpcaoVenda() {
		return valorOpcaoVenda;
	}

	public void setValorOpcaoVenda(Float valorOpcaoVenda) {
		this.valorOpcaoVenda = valorOpcaoVenda;
	}

	public Float getValorAcao() {
		return valorAcao;
	}

	public void setValorAcao(Float valorAcao) {
		this.valorAcao = valorAcao;
	}

	public Float getValorExercOpcaoCompra() {
		return valorExercOpcaoCompra;
	}

	public void setValorExercOpcaoCompra(Float valorExercOpcaoCompra) {
		this.valorExercOpcaoCompra = valorExercOpcaoCompra;
	}

	public Float getValorExercOpcaoVenda() {
		return valorExercOpcaoVenda;
	}

	public void setValorExercOpcaoVenda(Float valorExercOpcaoVenda) {
		this.valorExercOpcaoVenda = valorExercOpcaoVenda;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	
}
