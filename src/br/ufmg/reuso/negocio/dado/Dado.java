/*
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * Simules-SPL Project
 *
 * Created by Michael David
 * Date: 16/07/2011
 */

package br.ufmg.reuso.negocio.dado;

/**
 * @author Michael David
 *
 */
import java.util.Random;

public class Dado{
		
	public static int sortearValor(){
		int valorSorteado=0;
		Random sorteio = new Random();
		valorSorteado = sorteio.nextInt(6)+1;
		return valorSorteado;
	}
	
	public static int contarPontos(){
		return sortearValor();
	}
}
