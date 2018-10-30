package br.ufmg.reuso.dados.carta;

import java.util.Properties;

import br.ufmg.reuso.dados.RepositorioArquivo;
import br.ufmg.reuso.negocio.carta.CartaoProjeto;

public class RepositorioCartaoProjeto extends RepositorioArquivo implements IRepositorioCartaoProjeto {

	@Override
	public CartaoProjeto obterCartaoProjeto(String nome) {

		Properties a = getArquivoProperties(nome);

		CartaoProjeto c = new CartaoProjeto(
				a.getProperty("codigo"),
				a.getProperty("titulo"),
				a.getProperty("texto"),
				a.getProperty("referenciaBibliografica")); 
		return c;
	}

}
