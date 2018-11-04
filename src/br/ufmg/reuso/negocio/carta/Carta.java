/*
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * Simules-SPL Project
 *
 * Created by Michael David
 * Date: 16/07/2011
 */

package br.ufmg.reuso.negocio.carta;

/**
 * @author Michael David
 *
 */

public abstract class Carta {
	protected String tituloCarta; // título da carta
	protected String codigoCarta; // código da carta
	protected String textoCarta; // texto contido na carta
	public static final int CONCEITO = 1;
	public static final int ENGENHEIRO = 2;
	public static final int PROBLEMA = 3;
	private int tipoCarta; // carta deve ter tipo entre: CONCEITO, ENGENHEIRO OU PROBLEMA
	
	public Carta(String titulo, String codigo, String texto, int tipo){
		setTituloCarta(titulo);
		setCodigoCarta(codigo);
		setTextoCarta(texto);
		setTipoCarta(tipo);
	}
	
	public String getTituloCarta(){
		return tituloCarta;
	}

	public void setTituloCarta(String tituloCarta){
		this.tituloCarta = tituloCarta;
	}

	public String getCodigoCarta(){
		return codigoCarta;
	}

	public void setCodigoCarta(String codigoCarta){
		this.codigoCarta = codigoCarta;
	}

	public String getTextoCarta(){
		return textoCarta;
	}

	public void setTextoCarta(String textoCarta){
		this.textoCarta = textoCarta;
	}
	
	public int getTipoCarta(){
		return tipoCarta;
	}
	
	public void setTipoCarta(int tipoCarta){
		this.tipoCarta = tipoCarta;
	}
}
