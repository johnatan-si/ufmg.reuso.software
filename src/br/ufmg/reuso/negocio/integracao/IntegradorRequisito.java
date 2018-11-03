package br.ufmg.reuso.negocio.integracao;

import java.util.ArrayList;
import java.util.List;

import br.ufmg.reuso.negocio.carta.Artefato;
import br.ufmg.reuso.negocio.jogador.Jogador;
import br.ufmg.reuso.negocio.mesa.ArtefatoTipo;

/**
 * Classe concreta para integração dos artefatos do tipo requisito.
 * Design Patterns: Strategy
 * 
 * @author Aline Brito, Igor Muzetti (2018-02).
 */
public class IntegradorRequisito extends Integracao  implements Integrador {

	public IntegradorRequisito(Jogador jogador, int mesa, int[][] artefatosEscolhidos) {
		super(jogador, mesa, artefatosEscolhidos);
	}

	@Override
	public List<Artefato> integrar() {
		
		List<Artefato> requisitos = new ArrayList<Artefato>();
		
		for (int i = 0; i < artefatos[ArtefatoTipo.REQUISITO.getCodigo()].length; i++){
			if (this.isArtefatoEscolhido(ArtefatoTipo.REQUISITO, i)){
				Artefato temporario = jogador.getTabuleiro().getMesas()[mesa].getRequisitos().get(artefatos[ArtefatoTipo.REQUISITO.getCodigo()][i]);
				jogador.getTabuleiro().getMesas()[mesa].getRequisitos().remove(artefatos[ArtefatoTipo.REQUISITO.getCodigo()][i]);
				requisitos.add(temporario);
			}
		}
		
		return requisitos;
	}

}
