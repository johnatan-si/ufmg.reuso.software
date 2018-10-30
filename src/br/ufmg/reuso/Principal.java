package br.ufmg.reuso;

/*
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * Simules-SPL Project
 *
 * Created by Michael David
 * Date: 16/07/2011
 * 
 * Update by Aline Brito, Igor Muzetti (2018/2) 
 */

import br.ufmg.reuso.negocio.jogo.Jogo;

/**
 * @author MichaelDavid
 * 
 * Classe que Inicia o a execução do programa.
 */
public class Principal {
	
	/**
	 * @param args
	 * Método principal que cria um objeto da classe jogo e inicia o jogo com este objeto.
	 */ 
	public static void main(String[] args) {
		Jogo jogo = Jogo.getJogo();	//instanciando um objeto da classe jogo ou chamando o existente.
		jogo.start(jogo);			//iniciando a parte dinâmica do jogo	
	}
}
