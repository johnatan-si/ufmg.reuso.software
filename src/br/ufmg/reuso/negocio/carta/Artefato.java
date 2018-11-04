/*
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * Simules-SPL Project
 *
 * Created by Michael David
 * Date: 16/07/2011
 * 
 * Edited by Charles, Pedro, Salatiel, Suelen
 * Date: 14/11/2014
 */

package br.ufmg.reuso.negocio.carta;

/**
 * @author Michael David
 * Classe que contém o objeto artefato
 */


public class Artefato{
	
	private boolean bug; // se true há bug, do contrário não há bug
	private boolean qualidadeArtefatoRuim; // se true é ruim, se não é bom
	private boolean artefatoInspecionado; // se true foi inspecionado, se false não foi inspecionado
	
	protected EstadoCarta estado; //verifica o estado da carta artefato
	
	/**
	 * @param bug
	 * @param qualidade
	 * Construtor da classe Artefato sendo os parâmetros,independentemente um do outro, bom ou ruim.
	 */
	public Artefato (boolean bug, boolean qualidade){
		setBug(bug);
		setQualidadeArtefatoRuim(qualidade);
		setArtefatoInspecionado(false);
	}
	
	/**
	 * Método mostra artefato no console.
	 */
	public void mostrarArtefato(){
		System.out.printf("QualidadeRuim: %s\nBugExistente: %s\n",qualidadeArtefatoRuim,bug);
	}
	
	public boolean isBug(){
		return bug;
	}
	
	public void setBug(boolean bug){
		this.bug = bug;
	}

	public boolean isPoorQuality(){
		return qualidadeArtefatoRuim;
	}
	
	public void setQualidadeArtefatoRuim (boolean qualidadeArtefato){
		this.qualidadeArtefatoRuim = qualidadeArtefato;
	}

	public boolean inspected(){
		return artefatoInspecionado;
	}

	public void setArtefatoInspecionado(boolean artefatoInspecionado){
		this.artefatoInspecionado = artefatoInspecionado;
	}
	
	// implementacao para o padrao de projeto State
	public void obtemEstado(){
		estado.getEstado(this);
	}
	
	public String getQualidadeArtefato() {
		return qualidadeArtefatoRuim ? "ruim" : "bom";
	}
	
	public String isArtefatoBug() {
		return this.bug ? "sim" : "não";
	}
	
	
}
