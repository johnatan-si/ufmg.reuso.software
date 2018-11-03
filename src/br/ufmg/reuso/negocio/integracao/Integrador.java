package br.ufmg.reuso.negocio.integracao;

import java.util.List;

import br.ufmg.reuso.negocio.carta.Artefato;

/**
 * Interface comum para todas as classes de integração de artefatos.
 * Design Patterns: Strategy
 * 
 * @author Aline Brito, Igor Muzetti (2018-02).
 */
public interface Integrador {

	public List<Artefato> integrar();
	
}
