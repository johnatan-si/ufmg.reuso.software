/*
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * Simules-SPL Project
 *
 * Created by Michael David
 * Date: 16/07/2011
 */

package br.ufmg.reuso.negocio.jogo;

import br.ufmg.reuso.negocio.carta.Carta;
//#ifdef ConceptCard
import br.ufmg.reuso.negocio.carta.CartaBonificacao;
//#endif
import br.ufmg.reuso.negocio.carta.CartaEngenheiro;
import br.ufmg.reuso.negocio.carta.CartaPenalizacao;
import br.ufmg.reuso.negocio.jogador.Jogador;

/**
 * @author Michael David
 *
 */
public interface GameInteraction{
	
	/**
	 * Joga dados do jogadorAtual, no jogoAtual. É retornado as novas carcateristicas do jogadorAtual
	 * @param jogoAtual
	 * @param jogador
	 * @return
	 */
	public Jogador jogarDados(Jogo jogoAtual,Jogador jogador);
	  
	
	/**
	 * Termina jogada do jogadorAtual
	 * @param jogadorAtual
	 */
	public void terminarJogada(Jogador jogadorAtual);
	
	/**
	 * Mostra cartao de projeto do jogo
	 * @param jogoAtual
	 */
	public void verProjeto(Jogo jogoAtual);
	
	/**
	 * Retira as cartas do jogadorAtual e o retorna com características novas
	 * @param jogoAtual
	 * @param jogadorAtual
	 * @param cartasDescartadas
	 * @return
	 */
	public Jogador descartarCartas(Jogo jogoAtual, Jogador jogadorAtual, Carta[] cartasDescartadas);
	 
	 
	/**
	 * Retira carta de engenhero do tabuleiro do jogador
	 * @param jogoAtual
	 * @param jogadorAtual
	 * @param engenheiroDemitido
	 * @return
	 */
	public Jogador demitirEngenheiro(Jogo jogoAtual, Jogador jogadorAtual, CartaEngenheiro engenheiroDemitido); 
	  
	/**
	 * Retira cartas de engenheiro da mão do jogador e as insere no tabuleiro
	 * @param jogoAtual
	 * @param jogadorAtual
	 * @param engenheiroContratado
	 * @return
	 */
	public Jogador contratarEngenheiroI(Jogo jogoAtual, Jogador jogadorAtual, CartaEngenheiro engenheiroContratado);
	
	/**
	 * Engenheiro produz artefato
	 * @param jogoAtual
	 * @param jogadorAtual
	 * @param engenheiroProduzindo
	 * @return
	 */
	public Jogador produzirArtefatoI(Jogo jogoAtual, Jogador jogadorAtual, CartaEngenheiro engenheiroProduzindo);
	  
	/**
	 * Engenheiro inspeciona artefato
	 * @param jogoAtual
	 * @param jogadorAtual
	 * @param engenheiroInspecionando
	 * @return
	 */
	public Jogador inspecionarArtefatoI(Jogo jogoAtual, Jogador jogadorAtual, CartaEngenheiro engenheiroInspecionando);
	
	/**
	 * Engenheiro corrige artefato com bug
	 * @param jogoAtual
	 * @param jogadorAtual
	 * @param engenheiroCorrigindo
	 * @return
	 */
	public Jogador corrigirArtefatoI(Jogo jogoAtual, Jogador jogadorAtual, CartaEngenheiro engenheiroCorrigindo);
	
	/**
	 * Integra um conjunto de artefatos em módulo, conforme cartão de projeto
	 * @param jogoAtual
	 * @param jogadorAtual
	 * @param engenheiroIntegrador
	 * @param mesaTrabalho
	 * @return
	 */
	public Jogador integrarModuloI(Jogo jogoAtual, Jogador jogadorAtual,CartaEngenheiro engenheiroIntegrador, int mesaTrabalho); 
	
	/**
	 * Transfere modulo integrado de uma mesa para outra mesa sem módulo integrado
	 * @param jogoAtual
	 * @param jogadorAtual
	 * @param engenheiroTransferindo
	 * @return
	 */
	public Jogador tranferirModuloIntegrado(Jogo jogoAtual, Jogador jogadorAtual, CartaEngenheiro engenheiroTransferindo);
  	  
	
	//#ifdef ConceptCard
	/**
	 * Utiliza carta conceito da mão do jogador e insere efeito oriundo da respectiva carta no tabuleiro do jogador
	 * @param jogoAtual
	 * @param jogadorAtual
	 * @param cartaUtilizada
	 * @return
	 */
	public Jogador inserirBeneficio(Jogo jogoAtual, Jogador jogadorAtual, CartaBonificacao cartaUtilizada);
	//#endif
	
	  
	/**
	 * Utiliza carta problema da mão do jogadorAtual e insere efeito oriundo da respectiva carta no tabuleiro do jogadorAlvo
	 * @param jogoAtual
	 * @param jogadorAtual
	 * @param jogadorAlvo
	 * @param cartaUtilizada
	 * @return
	 */
	public Jogador inserirProblema(Jogo jogoAtual, Jogador jogadorAtual, Jogador jogadorAlvo, CartaPenalizacao cartaUtilizada); 
	  
	
}
