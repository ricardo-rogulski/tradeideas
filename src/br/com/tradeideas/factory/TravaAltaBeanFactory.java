package br.com.tradeideas.factory;

import br.com.tradeideas.entity.Acao;
import br.com.tradeideas.entity.Opcao;
import br.com.tradeideas.entity.TravaAlta;

public class TravaAltaBeanFactory {
	
	
	public TravaAlta getTravaAlta(Acao acao, Opcao opcaoCompra, Opcao opcaoVenda){
		
		if (opcaoCompra.getValor()==null || opcaoVenda.getValor()==null){
			return null;
		}
		TravaAlta trava = new TravaAlta();
		trava.setAcao(acao.getCodigo());
		trava.setOpcaoCompra(opcaoCompra.getCodigo());
		trava.setOpcaoVenda(opcaoVenda.getCodigo());
		trava.setValorOpcaoCompra(opcaoCompra.getValor());
		trava.setValorOpcaoVenda(opcaoVenda.getValor());
		trava.setValorAcao(18f);
		trava.setValorExercOpcaoCompra(opcaoCompra.getValorExerc());
		trava.setValorExercOpcaoVenda(opcaoVenda.getValorExerc());
		
		return trava;
	}
	
}
