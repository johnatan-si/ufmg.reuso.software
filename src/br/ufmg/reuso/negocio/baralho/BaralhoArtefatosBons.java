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
public class BaralhoArtefatosBons extends BaralhoArtefatos{

	private static final double PERCENTUAL_ARTEFATOS_RUINS_QUALIDADE_BOA = 0.2;

	public BaralhoArtefatosBons(){
		super();
	}

	public BaralhoArtefatosBons(int pNumeroArtefatosAtual){
		super(pNumeroArtefatosAtual);
	}

	@Override
	public Artefato[] iniciarArtefatos(){
		Artefato[] bons = new Artefato[getNumeroArtefatosAtual()];
		for (int i = 0; i < ((int) (PERCENTUAL_ARTEFATOS_RUINS_QUALIDADE_BOA * getNumeroArtefatosAtual())); i++){
			// iniciando o comeco do vetor com artefatos bons com bug (20% deles)
			bons[i] = new Artefato(true, false);
		}

		for (int i = ((int) (PERCENTUAL_ARTEFATOS_RUINS_QUALIDADE_BOA * getNumeroArtefatosAtual())); i < getNumeroArtefatosAtual(); i++){
			//iniciando o final do vetor com artefatos bons sem bug (80% deles)
			bons[i] = new Artefato(false, false);
		}

		return bons;
	}

	@Override
	public void embaralhar(){
		Random sorteio = new Random();
		for (int primeiro = 0; primeiro < getNumeroArtefatosAtual(); primeiro++){
			int segundo = sorteio.nextInt(getNumeroArtefatosAtual());
			Artefato temporario = listaArtefatos[primeiro];
			listaArtefatos[primeiro] = listaArtefatos[segundo];
			listaArtefatos[segundo] = temporario;
		}
	}

	/**
	 * Distribui uma artefato bom
	 */
	@Override
	public Artefato darArtefato(){
		
		// Determina se ainda ha artefato a ser distribuido
		if (listaArtefatos[currentArtifact] != null){
			Artefato temporario = listaArtefatos[currentArtifact];
			listaArtefatos[currentArtifact] = null;
			setNumeroArtefatosAtual(getNumeroArtefatosAtual() - 1); // Diminui o numero de artefatos que o baralho contem
			this.currentArtifact++; // Incrementa indice do proximo artefato a ser distribuido
			
			return temporario;
			
		} else{
			return null; // Retorna nulo para indicar que baralho esta vazio
		}
	}

	@Override
	public void recolherArtefato(Artefato artefatoDevolvido){
		artefatoDevolvido.setArtefatoInspecionado(false); // atualizando variavel do artefato para entrada no baralho auxiliar
		listaArtefatos[getNumeroArtefatosAtual()] = artefatoDevolvido; // colocando artefato no baralho
		setNumeroArtefatosAtual(getNumeroArtefatosAtual() + 1); //adicionando numero de artefatos ao baralho que recolhe
	}
}