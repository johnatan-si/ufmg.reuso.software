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
 */
public class CartaAberta implements EstadoCarta {
	
	@Override
	public boolean getEstado(Artefato carta) {
		return carta.inspected();
	}
	
	@Override
	public void setEstado(Artefato carta) {
		carta.setArtefatoInspecionado(true);//define que o artefato ja foi inspecionado
	}
}