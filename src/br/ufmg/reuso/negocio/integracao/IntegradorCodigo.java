package br.ufmg.reuso.negocio.integracao;

import java.util.ArrayList;
import java.util.List;

import br.ufmg.reuso.negocio.carta.Artefato;
import br.ufmg.reuso.negocio.jogador.Jogador;
import br.ufmg.reuso.negocio.mesa.ArtefatoTipo;

/**
 * Classe concreta  para integração dos artefatos do tipo código.
 * Design Patterns: Strategy
 * 
 * @author Aline Brito, Igor Muzetti (2018-02).
 */
public class IntegradorCodigo extends Integracao  implements Integrador {

	public IntegradorCodigo(Jogador jogador, int mesa,	int[][] artefatosEscolhidos) {
		super(jogador, mesa, artefatosEscolhidos);
	}

	@Override
	public List<Artefato> integrar() {
		
		List<Artefato> codigos = new ArrayList<Artefato>();
		
		for (int i = 0; i < artefatos[ArtefatoTipo.CODIGO.getCodigo()].length; i++){
			if (this.isArtefatoEscolhido(ArtefatoTipo.CODIGO, i)){
				Artefato temporario = jogador.getTabuleiro().getMesas()[mesa].getCodigos().get(artefatos[ArtefatoTipo.CODIGO.getCodigo()][i]);
				jogador.getTabuleiro().getMesas()[mesa].getCodigos().remove(artefatos[ArtefatoTipo.CODIGO.getCodigo()][i]);
				codigos.add(temporario);
			}
		}
		
		return codigos;
	}

}
