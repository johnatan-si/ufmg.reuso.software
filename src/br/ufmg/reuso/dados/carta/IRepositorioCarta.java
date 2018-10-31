package br.ufmg.reuso.dados.carta;

//#ifdef ConceptCard
import br.ufmg.reuso.negocio.carta.CartaBonificacao;
//#endif
import br.ufmg.reuso.negocio.carta.CartaEngenheiro;
import br.ufmg.reuso.negocio.carta.CartaPenalizacao;

public interface IRepositorioCarta{
	
	//#ifdef ConceptCard
	CartaBonificacao obterCartaConceito(String nome);
	//#endif
	CartaPenalizacao obterCartaPenalizacao(String nome);
	CartaEngenheiro obterCartaEngenheiro(String nome);

}
