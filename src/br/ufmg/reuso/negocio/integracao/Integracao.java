package br.ufmg.reuso.negocio.integracao;

import br.ufmg.reuso.negocio.jogador.Jogador;
import br.ufmg.reuso.negocio.mesa.ArtefatoEstado;
import br.ufmg.reuso.negocio.mesa.ArtefatoTipo;

/**
 * Superclasse para encapsular atributos necessários para integração dos módulos da mesa.
 * Design Patterns: Strategy
 * 
 * @author Aline Brito, Igor Muzetti (2018-02).
 */
public class Integracao {
	
	protected Jogador jogador;
	
	protected int mesa;
	
	protected int[][] artefatos;
	
	public Integracao(Jogador jogador, int mesa, int[][] artefatos) {
		this.jogador = jogador;
		this.mesa = mesa;
		this.artefatos = artefatos;
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
	}

	public int getMesa() {
		return mesa;
	}

	public void setMesa(int mesa) {
		this.mesa = mesa;
	}

	public int[][] getArtefatos() {
		return artefatos;
	}

	public void setArtefatos(int[][] artefatos) {
		this.artefatos = artefatos;
	}
	
	/**
	 * Verifica se o artefato foi escolhido.
	 * @param artefatoTipo
	 * @param i
	 * @return true, se artefato escolhido, falso caso contrário.
	 */
	public boolean isArtefatoEscolhido(ArtefatoTipo artefatoTipo, int i){
		if (artefatos[artefatoTipo.getCodigo()][i] == ArtefatoEstado.SELECIONADO.getCodigo()){
			return true;
		}
		return false;
	}

}
