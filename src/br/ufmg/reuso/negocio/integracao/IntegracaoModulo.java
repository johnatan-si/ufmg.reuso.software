package br.ufmg.reuso.negocio.integracao;

import java.util.List;

import br.ufmg.reuso.negocio.carta.Artefato;

/**
 * Classe para integração do módulo.
 * Design Patterns: Strategy
 * 
 * @author Aline Brito, Igor Muzetti (2018-02).
 */
public class IntegracaoModulo {
	
	public List<Artefato> integrar(Integrador integrador){
		return integrador.integrar();
	}
	
}
