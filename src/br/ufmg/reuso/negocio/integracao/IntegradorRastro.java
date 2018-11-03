package br.ufmg.reuso.negocio.integracao;

import java.util.ArrayList;
import java.util.List;

import br.ufmg.reuso.negocio.carta.Artefato;
import br.ufmg.reuso.negocio.jogador.Jogador;
import br.ufmg.reuso.negocio.mesa.ArtefatoTipo;

/**
 * Classe concreta  para integração dos artefatos do tipo rastro.
 * Design Patterns: Strategy
 * 
 * @author Aline Brito, Igor Muzetti (2018-02).
 */
public class IntegradorRastro extends Integracao  implements Integrador{
	
	public IntegradorRastro(Jogador jogador, int mesa, int[][] artefatosEscolhidos) {
		super(jogador, mesa, artefatosEscolhidos);
	}

	@Override
	public List<Artefato> integrar() {
		
		List<Artefato> rastros = new ArrayList<Artefato>();
		
		for (int i = 0; i < artefatos[ArtefatoTipo.RASTRO.getCodigo()].length; i++){
			if (this.isArtefatoEscolhido(ArtefatoTipo.RASTRO, i)){
				Artefato temporario = jogador.getTabuleiro().getMesas()[mesa].getRastros().get(artefatos[ArtefatoTipo.RASTRO.getCodigo()][i]);
				jogador.getTabuleiro().getMesas()[mesa].getRastros().remove(artefatos[ArtefatoTipo.RASTRO.getCodigo()][i]);
				rastros.add(temporario);
			}

		}
		
		return rastros;
	}
	

}
