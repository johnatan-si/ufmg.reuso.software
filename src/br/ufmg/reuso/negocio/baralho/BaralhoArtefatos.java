package br.ufmg.reuso.negocio.baralho;

import br.ufmg.reuso.negocio.carta.Artefato;
import br.ufmg.reuso.negocio.jogo.Jogo;

/**
 * @author Marina
 */
public abstract class BaralhoArtefatos {

	//controla o numero de artefatos que o baralho tem no decorrer do jogo
	protected int numeroArtefatosAtual;

	//indice da proxima carta de artefato a ser distribuida durante o jogo
	protected int currentArtifact;
	
	// baralho
	protected Artefato[] listaArtefatos;

	public BaralhoArtefatos() {
		listaArtefatos = new Artefato[(int) (Jogo.NUMERO_TOTAL_ARTEFATOS / 2)];
		setNumeroArtefatosAtual((int) (Jogo.NUMERO_TOTAL_ARTEFATOS / 2));
		currentArtifact = 0;
		listaArtefatos = iniciarArtefatos();
	}
	
	public BaralhoArtefatos(int pNumeroArtefatosAtual) {
		listaArtefatos = new Artefato[((int) (Jogo.NUMERO_TOTAL_ARTEFATOS / 2))];
		setNumeroArtefatosAtual(pNumeroArtefatosAtual);
		this.currentArtifact = 0;
		
		for (int i = 0; i < (int) Jogo.NUMERO_TOTAL_ARTEFATOS / 2; i++) {
			listaArtefatos[i] = null;
		}
	}
	
	public abstract void embaralhar();
	
	public abstract Artefato[] iniciarArtefatos();
	
	public abstract Artefato darArtefato();
	
	public abstract void recolherArtefato(Artefato pArtefatoDevolvido);

	protected void mostrarBaralhoArtefatos() {
		for (int i = 0; i < getNumeroArtefatosAtual(); i++) {
			listaArtefatos[i].mostrarArtefato();
		}
	}
	
	public int getNumeroArtefatosAtual() {
		return numeroArtefatosAtual;
	}

	public void setNumeroArtefatosAtual(int numeroArtefatosAtual) {
		this.numeroArtefatosAtual = numeroArtefatosAtual;
	}

	public int getCurrentArtifact() {
		return currentArtifact;
	}

	public void setCurrentArtifact(int currentArtifact) {
		this.currentArtifact = currentArtifact;
	}

	public Artefato[] getListaArtefatos() {
		return listaArtefatos;
	}

	public void setListaArtefatos(Artefato[] listaArtefatos) {
		this.listaArtefatos = listaArtefatos;
	}
	
}