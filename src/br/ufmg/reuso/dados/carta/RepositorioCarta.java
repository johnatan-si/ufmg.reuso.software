package br.ufmg.reuso.dados.carta;

import java.util.Properties;

import br.ufmg.reuso.dados.RepositorioArquivo;
//#ifdef ConceptCard
import br.ufmg.reuso.negocio.carta.CartaBonificacao;
//#endif
import br.ufmg.reuso.negocio.carta.CartaEngenheiro;
import br.ufmg.reuso.negocio.carta.CartaPenalizacao;

public class RepositorioCarta extends RepositorioArquivo implements IRepositorioCarta{

	//#ifdef ConceptCard
	@Override
	public CartaBonificacao obterCartaConceito(String nome){

		Properties a = getArquivoProperties(nome);

		CartaBonificacao c = new CartaBonificacao(
				a.getProperty("titulo"),
				a.getProperty("codigo"),
				a.getProperty("texto"),
				a.getProperty("referenciaBibliografica"),
				Integer.parseInt(a.getProperty("duracaoEfeito")),
				Integer.parseInt(a.getProperty("custo")),
				Integer.parseInt(a.getProperty("tipoPrimeiroEfeito")),
				Integer.parseInt(a.getProperty("tipoSegundoEfeito")),
				Integer.parseInt(a.getProperty("quantidadePrimeiroEfeito")),
				Integer.parseInt(a.getProperty("quantidadeSegundoEfeito"))); 

		return c;
	}
	//#endif

	@Override
	public CartaPenalizacao obterCartaPenalizacao(String nome){

		Properties a = getArquivoProperties(nome);

		CartaPenalizacao c = new CartaPenalizacao(
				a.getProperty("titulo"),
				a.getProperty("codigo"),
				a.getProperty("texto"),
				a.getProperty("referenciaBibliografica"),
				Integer.parseInt(a.getProperty("duracaoEfeito")),
				a.getProperty("condicao"),
				Integer.parseInt(a.getProperty("tipoPrimeiroEfeito")),
				Integer.parseInt(a.getProperty("tipoSegundoEfeito")),
				Integer.parseInt(a.getProperty("quantidadePrimeiroEfeito")),
				Integer.parseInt(a.getProperty("quantidadeSegundoEfeito")),
				Integer.parseInt(a.getProperty("tipoPrimeiraCondicao")),
				Integer.parseInt(a.getProperty("tipoSegundaCondicao")),
				Integer.parseInt(a.getProperty("quantidadePrimeiraCondicao")),
				Integer.parseInt(a.getProperty("quantidadeSegundaCondicao"))); 

		return c;
	}

	@Override
	public CartaEngenheiro obterCartaEngenheiro(String nome){

		Properties a = getArquivoProperties(nome);

		CartaEngenheiro c = new CartaEngenheiro(
				a.getProperty("codigo"),
				a.getProperty("texto"), 
				a.getProperty("nome"),
				Integer.parseInt(a.getProperty("salario")), 
				Integer.parseInt(a.getProperty("habilidade")), 
				Integer.parseInt(a.getProperty("maturidade")));
		return c;
	}

}
