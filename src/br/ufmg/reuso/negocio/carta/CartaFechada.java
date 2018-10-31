/*
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * Simules-SPL Project
 *
 * Created by Charles / Pedro / Salatiel / Suelen
 * Date: 14/11/2014
 */

package br.ufmg.reuso.negocio.carta;

/*
 * Implementa a interface EstadoCarta, definindo:
 * - Inspecionado: FALSE
 */

public class CartaFechada implements EstadoCarta{
	
	@Override
	public boolean getEstado(Artefato carta){
		return carta.inspected();
	}
	
	@Override
	public void setEstado(Artefato carta){
		carta.setArtefatoInspecionado(false);//define que o artefato ainda nao foi inspecionado
	}
	
	public void virarCarta(Artefato carta){
		carta.setArtefatoInspecionado(true);//opcao para inspecionar o artefato
	}
}