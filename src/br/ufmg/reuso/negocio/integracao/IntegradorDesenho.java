package br.ufmg.reuso.negocio.integracao;

import java.util.ArrayList;
import java.util.List;

import br.ufmg.reuso.negocio.carta.Artefato;
import br.ufmg.reuso.negocio.jogador.Jogador;
import br.ufmg.reuso.negocio.mesa.ArtefatoTipo;

/**
 * Classe concreta  para integração dos artefatos do tipo desenho.
 * Design Patterns: Strategy
 * 
 * @author Aline Brito, Igor Muzetti (2018-02).
 */
public class IntegradorDesenho extends Integracao  implements Integrador{

	public IntegradorDesenho(Jogador jogador, int mesa,	int[][] artefatosEscolhidos) {
		super(jogador, mesa, artefatosEscolhidos);
	}

	@Override
	public List<Artefato> integrar() {
		
		List<Artefato> desenhos = new ArrayList<Artefato>();
		
		for (int i = 0; i < artefatos[ArtefatoTipo.DESENHO.getCodigo()].length; i++){
			if (this.isArtefatoEscolhido(ArtefatoTipo.DESENHO, i)){
				Artefato temporario = jogador.getTabuleiro().getMesas()[mesa].getDesenhos().get(artefatos[ArtefatoTipo.DESENHO.getCodigo()][i]);
				jogador.getTabuleiro().getMesas()[mesa].getDesenhos().remove(artefatos[ArtefatoTipo.DESENHO.getCodigo()][i]);
				desenhos.add(temporario);
			}
		}
		
		return desenhos;
	}
}
