package br.ufmg.reuso.negocio.baralho.factory;

import br.ufmg.reuso.negocio.baralho.BaralhoArtefatos;
import br.ufmg.reuso.negocio.baralho.BaralhoArtefatosBons;
import br.ufmg.reuso.negocio.baralho.BaralhoArtefatosRuins;
import br.ufmg.reuso.negocio.jogo.ModeGameConstants;

public class CreatorBaralhoArtefatos implements AbstractCreatorBaralhoArtefatos{
	
	public CreatorBaralhoArtefatos() {
		/* nao ha necessidade de executar nada no construtor */
	}
	
	public BaralhoArtefatos getBaralho(String pTipoBaralho, Integer pNumeroArtefatosAtual){

		if (pTipoBaralho.equals(ModeGameConstants.BARALHO_ARTEFATOS_RUINS)){

			if (pNumeroArtefatosAtual != null) {
				return new BaralhoArtefatosRuins(pNumeroArtefatosAtual);
			} else {
				return new BaralhoArtefatosRuins();
			}
		}

		if (pTipoBaralho.equals(ModeGameConstants.BARALHO_ARTEFATOS_BONS)){
			if (pNumeroArtefatosAtual != null) {
				return new BaralhoArtefatosBons(pNumeroArtefatosAtual);
			} else {
				return new BaralhoArtefatosBons();
			}
		}

		return null;
	}
}
