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
 * - Possui Bug: TRUE
 */
public class CartaAbertaComBug extends CartaAberta{
	
	public void setBug(Artefato carta){
		carta.setQualidadeArtefatoRuim(true); //define que o artefato possui bug
	}
	
	public void corrigirBug(Artefato carta){
		carta.setQualidadeArtefatoRuim(false);//corrige o bug existente no artefato
	}
}