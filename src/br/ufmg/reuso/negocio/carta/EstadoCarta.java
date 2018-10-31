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
 * Interface que identifica o estado atual de uma carta: inspecionado ou nao, e se possui bug ou nao
 */
public interface EstadoCarta{
	
	public boolean getEstado(Artefato carta);
	
	public void setEstado(Artefato carta);
}
