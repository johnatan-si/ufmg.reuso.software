package br.ufmg.reuso.dados.carta;

import br.ufmg.reuso.negocio.carta.CartaoProjeto;

public interface IRepositorioCartaoProjeto{
	
	CartaoProjeto obterCartaoProjeto(String nome);

}
