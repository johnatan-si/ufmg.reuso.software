/*
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * Simules-SPL Project
 *
 * Created by Charles, Pedro, Salatiel, Suelen
 * Date: 14/11/2014
 */

package br.ufmg.reuso.negocio.carta;

/*
 * Implementa a interface EstadoCarta, definindo:
 * - Inspecionado: TRUE
 * - Possui Bug: FALSE
 */
public class CartaAbertaSemBug extends CartaAberta{
	
	public void setBug(Artefato carta){
		carta.setQualidadeArtefatoRuim(false); //define que o artefato nao possui bug
	}
}