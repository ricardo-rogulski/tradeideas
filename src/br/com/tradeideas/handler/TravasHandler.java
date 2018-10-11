package br.com.tradeideas.handler;

import java.util.ArrayList;
import java.util.List;

import br.com.tradeideas.business.AcaoBusiness;
import br.com.tradeideas.business.TravaDeAltaBusiness;
import br.com.tradeideas.entity.Acao;
import br.com.tradeideas.entity.TravaAlta;

public class TravasHandler {
	
	private List<TravaAlta> travasDeAltaDisponiveis = new ArrayList<TravaAlta>();
	
	public List<TravaAlta> getTravasDeAltaDisponiveis() {
		
		TravaDeAltaBusiness tab = new TravaDeAltaBusiness();
		return tab.getTravasDeAltaPossiveis();
	}

}
