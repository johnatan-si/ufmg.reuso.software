package br.ufmg.reuso.negocio.integracao;

import java.util.ArrayList;
import java.util.List;

import br.ufmg.reuso.negocio.carta.Artefato;
import br.ufmg.reuso.negocio.jogador.Jogador;
import br.ufmg.reuso.negocio.mesa.ArtefatoTipo;

/**
 * Classe concreta  para integração dos artefatos do tipo ajuda.
 * Design Patterns: Strategy
 * 
 * @author Aline Brito, Igor Muzetti (2018-02).
 */
public class IntegradorAjuda extends Integracao implements Integrador{

	public IntegradorAjuda(Jogador jogador, int mesa, int[][] artefatosEscolhidos) {
		super(jogador, mesa, artefatosEscolhidos);
	}
	
	@Override
	public List<Artefato> integrar() {
		
		List<Artefato> ajudas = new ArrayList<Artefato>();

		for (int i = 0; i < artefatos[ArtefatoTipo.AJUDA.getCodigo()].length; i++){
			if (this.isArtefatoEscolhido(ArtefatoTipo.AJUDA, i)){
				Artefato temporario = jogador.getTabuleiro().getMesas()[mesa].getAjudas().get(artefatos[ArtefatoTipo.AJUDA.getCodigo()][i]);
				jogador.getTabuleiro().getMesas()[mesa].getAjudas().remove(artefatos[ArtefatoTipo.AJUDA.getCodigo()][i]);
				ajudas.add(temporario);
			}
		}
		
		return ajudas;
	}

}
