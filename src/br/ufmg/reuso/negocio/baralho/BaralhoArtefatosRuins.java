/*
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * Simules-SPL Project
 *
 * Created by Michael David
 * Date: 16/07/2011
 */

package br.ufmg.reuso.negocio.baralho;

import java.util.Random;

import br.ufmg.reuso.negocio.carta.Artefato;

/**
 * @author Michael David
 * Update by Marina (2016/1)
 */
public class BaralhoArtefatosRuins extends BaralhoArtefatos {

	private static final double PERCENTUAL_ARTEFATOS_RUINS_QUALIDADE_RUIM = 0.6;

	public BaralhoArtefatosRuins() {
		super();
	}

	public BaralhoArtefatosRuins(int pNumeroArtefatosAtual) {
		super(pNumeroArtefatosAtual);
	}

	@Override
	public Artefato[] iniciarArtefatos() {
		Artefato[] ruins = new Artefato[getNumeroArtefatosAtual()];
		for (int i = 0; i < ((int) (PERCENTUAL_ARTEFATOS_RUINS_QUALIDADE_RUIM * getNumeroArtefatosAtual())); i++) {
			ruins[i] = new Artefato(true, true); // iniciando o comeco do vetor com artefatos ruins com bug
		}

		for (int i = ((int) (PERCENTUAL_ARTEFATOS_RUINS_QUALIDADE_RUIM * getNumeroArtefatosAtual())); i < getNumeroArtefatosAtual(); i++) {
			ruins[i] = new Artefato(false, true); // iniciando o final do vetor com artefatos ruins sem bug
		}

		return ruins;
	}

	@Override
	public void embaralhar() {
		Random sorteio = new Random();
		for (int primeiro = 0; primeiro < getNumeroArtefatosAtual(); primeiro++) {
			int segundo = sorteio.nextInt(getNumeroArtefatosAtual());
			Artefato temporario = listaArtefatos[primeiro];
			listaArtefatos[primeiro] = listaArtefatos[segundo];
			listaArtefatos[segundo] = temporario;
		}
	}

	/**
	 * Distribui uma artefato ruim
	 */
	@Override
	public Artefato darArtefato() {

		if (listaArtefatos[currentArtifact] != null) { //Determina se ainda ha artefato a ser distribuido

			setNumeroArtefatosAtual(getNumeroArtefatosAtual() - 1); // Diminui o numero de artefatos que o baralho contem
			Artefato temporario = listaArtefatos[currentArtifact];
			listaArtefatos[currentArtifact] = null;
			this.currentArtifact++; // Incrementa indice do proximo artefato a ser distribuido

			return temporario;
			
		} else {
			return null; // Retorna nulo para indicar que baralho esta vazio
		}
	}

	@Override
	public void recolherArtefato(Artefato artefatoDevolvido) {
		
		artefatoDevolvido.setArtefatoInspecionado(false); // atualizando variavel do artefato para entrada no baralho auxiliar
		listaArtefatos[getNumeroArtefatosAtual()] = artefatoDevolvido; // colocando artefato no baralho
		setNumeroArtefatosAtual(getNumeroArtefatosAtual() + 1); // adicionando numero de artefatos ao baralho que recolhe
	}
}