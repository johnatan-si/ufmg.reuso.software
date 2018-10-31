package br.ufmg.reuso.negocio.baralho.factory;

import br.ufmg.reuso.negocio.baralho.BaralhoArtefatos;

public interface AbstractCreatorBaralhoArtefatos{

	public abstract BaralhoArtefatos getBaralho(String pTipoBaralho, Integer pNumeroArtefatosAtual);

}
