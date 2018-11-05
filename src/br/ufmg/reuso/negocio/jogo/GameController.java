/*
  * Federal University of Minas Gerais 
 * Department of Computer Science
 * Simules-SPL Project
 *
 * Created by Michael David
 * Date: 28/07/2011
 */
package br.ufmg.reuso.negocio.jogo;


import br.ufmg.reuso.apresentacao.ScreenInteraction;
import br.ufmg.reuso.negocio.carta.Carta;
//#ifdef ConceptCard
import br.ufmg.reuso.negocio.carta.CartaBonificacao;
//#endif
import br.ufmg.reuso.negocio.carta.CartaEngenheiro;
import br.ufmg.reuso.negocio.carta.CartaPenalizacao;
import br.ufmg.reuso.negocio.jogador.Jogador;
import br.ufmg.reuso.negocio.tabuleiro.SetupInteraction;

/**
 * @author Michael David
 *
 */
public class GameController implements GameInteraction{
	
	private static GameController GameController;
	
	private GameController(){
		
	}
	
	public static GameController getGameController(){
		if(GameController==null){
			GameController = new GameController();
		}
		return GameController;
	}
	
	@Override
	public Jogador jogarDados(Jogo jogoAtual,Jogador jogadorAtual){ // joga dados do jogadorAtual, no jogoAtual. É retornado as novas carcateristicas do jogadorAtual
		Jogador auxiliar;
		auxiliar=jogoAtual.jogarDado(jogadorAtual);
		jogadorAtual.setDadoJogado(true); // atualiza que o jogador não pode jogar dados, ou seja, na rodada já jogou dados
		return auxiliar;
	} 
	 
	@Override
	public void terminarJogada(Jogador jogadorAtual){//Termina jogada do jogadorAtual
		jogadorAtual.setDadoJogado(false); // atualiza que o jogador pode jogar dados, ou seja, na rodada ainda não jogou dados
		for (int i=0;i<jogadorAtual.getTabuleiro().getMesas().length;i++){
			if(jogadorAtual.getTabuleiro().getMesas()[i].getCartaMesa()==null){// Se mesa vazia, pula iteração
				continue;			
			}
			else{
				//Restaura pontos de habilidade das cartas de engenheiro na mesas do tabuleiro do jogador*/
				jogadorAtual.getTabuleiro().getMesas()[i].getCartaMesa().setHabilidadeEngenheiroAtual(jogadorAtual.getTabuleiro().getMesas()[i].getCartaMesa().getHabilidadeEngenheiro());
			
				//Atualiza que o engenheiro não trabalhou na rodada para a próxima rodada que virá
				jogadorAtual.getTabuleiro().getMesas()[i].getCartaMesa().setEngenheiroTrabalhouNestaRodada(false);
			}
		}
		
	}

	@Override
	public void verProjeto(Jogo jogoAtual){//Mostra cartao de projeto do jogo
		jogoAtual.setupController.exibirProjeto(jogoAtual.getProjeto());
	}

	/**
	 * Retira as cartas do jogadorAtual e o retorna com características novas 
	 */
	@Override
	public Jogador descartarCartas(Jogo jogoAtual, Jogador jogadorAtual, Carta[] cartasDescartadas){
		Jogador auxiliar;
		auxiliar=jogoAtual.retirarCartas(jogadorAtual, cartasDescartadas);
		
		return auxiliar;
	} 
	
	/**
	 * Retira carta de engenheiro do tabuleiro do jogador e a transfere para monte do baralho
	 */
	 @Override
	public Jogador demitirEngenheiro(Jogo jogoAtual, Jogador jogadorAtual, CartaEngenheiro engenheiroDemitido){
		Jogador auxiliar;
		auxiliar=jogoAtual.despedirEngenheiro(jogadorAtual,engenheiroDemitido);
		
		
		return auxiliar;
	}
	
	/**
	 * Retira cartas de engenheiro da mão do jogador e as insere no tabuleiro  
	 */
	@Override
	public Jogador contratarEngenheiroI(Jogo jogoAtual, Jogador jogadorAtual, CartaEngenheiro engenheiroContratado){
		int posicao = jogoAtual.setupController.escolherMesa();
		posicao--;
		Jogador auxiliar;
		auxiliar = jogoAtual.admitirEngenheiro(jogadorAtual,engenheiroContratado,posicao);
		return auxiliar;
	}
	
	/**
	 * Engenheiro produz artefato
	 */
	@Override
	public Jogador produzirArtefatoI(Jogo jogoAtual, Jogador jogadorAtual, CartaEngenheiro engenheiroProduzindo){
		Jogador auxiliar;
		int mesaTrabalho = jogoAtual.setupController.escolherMesadeTrabalho();
		if (mesaTrabalho ==-1){
			ScreenInteraction.getScreenInteraction().exibirMensagem("Operação de produzir artefato cancelada pelo jogador",""); 		//	
			return jogadorAtual; //NÃO FAZ NADA COM JOGADOR
		}
		mesaTrabalho--;
		if (jogadorAtual.getTabuleiro().getMesas()[mesaTrabalho].getCartaMesa()==null){
			ScreenInteraction.getScreenInteraction().exibirMensagem("Operação de produzir artefato cancelada: Mesa vazia","");
			return jogadorAtual; //NÃO FAZ NADA COM JOGADOR
		}	
		auxiliar=jogoAtual.inserirArtefato(jogadorAtual,engenheiroProduzindo, mesaTrabalho);
		return auxiliar;
	}

	/**
	 * Engenheiro inspeciona artefato
	 */
	 @Override
	 public Jogador inspecionarArtefatoI(Jogo jogoAtual, Jogador jogadorAtual, CartaEngenheiro engenheiroInspecionando){
		Jogador auxiliar;
		int mesaTrabalho = jogoAtual.setupController.escolherMesadeTrabalho();
		if (mesaTrabalho ==-1){
			ScreenInteraction.getScreenInteraction().exibirMensagem("Operação de inspecionar artefato cancelada pelo jogadoR",""); 		
			return jogadorAtual;												
		}
		mesaTrabalho--;
		if (jogadorAtual.getTabuleiro().getMesas()[mesaTrabalho].getCartaMesa()==null){
			ScreenInteraction.getScreenInteraction().exibirMensagem("Operação de inspecionar artefato cancelada: Mesa vazia, sem engenheiro","");
			return jogadorAtual;
		}
		
		auxiliar=jogoAtual.conferirArtefato(jogadorAtual,engenheiroInspecionando, mesaTrabalho);
		return auxiliar;

	}
	
	/**
	* Engenheiro corrige artefato com bug
	*/
	@Override
	public Jogador corrigirArtefatoI(Jogo jogoAtual, Jogador jogadorAtual, CartaEngenheiro engenheiroCorrigindo){
		Jogador auxiliar;
		int mesaTrabalho = jogoAtual.setupController.escolherMesadeTrabalho();
		if (mesaTrabalho ==-1){
			ScreenInteraction.getScreenInteraction().exibirMensagem("Operação de inspecionar artefato cancelada pelo jogador.",""); 
			return jogadorAtual;
		}
		mesaTrabalho--;
		if (jogadorAtual.getTabuleiro().getMesas()[mesaTrabalho].getCartaMesa()==null){
			ScreenInteraction.getScreenInteraction().exibirMensagem("Operação de inspecionar artefato cancelada: Mesa vazia","");
			return jogadorAtual;												
		}
		auxiliar=jogoAtual.repararArtefato(jogadorAtual,engenheiroCorrigindo, mesaTrabalho);
		return auxiliar;
	}
	
	/** 
	 * Integra um conjunto de artefatos em módulo, conforme cartão de projeto.
	 */
	 @Override
	public Jogador integrarModuloI(Jogo jogoAtual, Jogador jogadorAtual, CartaEngenheiro engenheiroIntegrador, int mesa){
		
		 Jogador auxiliar;
		
		if (mesa ==-1){
			ScreenInteraction.getScreenInteraction().exibirMensagem("Operação de integrar modulo cancelada pelo jogador.","");
			return jogadorAtual;												
		}		
		int mesaTrabalho = mesa;
		
		if (jogadorAtual.getTabuleiro().getMesas()[mesaTrabalho].getCartaMesa()==null){
			jogoAtual.setupController.exibirMensagem("Operação de integrar módulo cancelada: Mesa vazia, sem engenheiro", "Integração.");
			return jogadorAtual;										
		}
		
		int moduloEscolhido = jogoAtual.setupController.escolherModuloProjeto(jogoAtual.getProjeto().getModulos(), mesaTrabalho);
		int [][]artefatosEscolhidos = jogoAtual.setupController.artefatosEscolhidos();
		
		auxiliar=jogoAtual.integrarModuloJ(jogadorAtual, engenheiroIntegrador, mesaTrabalho,moduloEscolhido,artefatosEscolhidos);
		jogoAtual.setupController.habilitarTrocarModuloIntegrado(mesaTrabalho); /**habilita o engenheiro situado na mesaTrabalho a trocar modulo integrado de mesa*/
		
		//System.out.println("\n validação vai ocorrer se "+ jogoAtual.getProjeto().getTamanho() + " for igual a " + jogadorAtual.contarModuloJaIntegrado()); 
		if (jogoAtual.validarProjeto(jogadorAtual)==SetupInteraction.PROJETO_CONCLUIDO){
			jogoAtual.setupController.exibirVencedor(jogadorAtual);
			jogoAtual.setGameStatus(Jogo.Status.WINNER_END);
		}
		return auxiliar;
	}
	 
	@Override
	public Jogador tranferirModuloIntegrado(Jogo jogoAtual, Jogador jogadorAtual, CartaEngenheiro engenheiroTransferindo){// transfere modulo integrado de uma mesa para outra mesa sem módulo integrado
		ScreenInteraction.getScreenInteraction().exibirMensagem("tranferir módulo requerido","");
		int mesaEscolhida = jogoAtual.setupController.escolherMesaTransferencia();//contém mesa para transferir módulo integrado
		mesaEscolhida--;
		if(jogadorAtual.getTabuleiro().getMesas()[mesaEscolhida].getModuloJaIntegrado()==true){
			jogoAtual.setupController.exibirMesaModulo();
			return jogadorAtual;
		}
		else{
			return jogoAtual.trocarModuloMesa(jogadorAtual,engenheiroTransferindo, mesaEscolhida);
		}
	}
		
	//#ifdef ConceptCard
	/**
	 * Utiliza carta conceito da mao do jogador e insere efeito oriundo da respectiva carta no tabuleiro do jogador
	 * */
	@Override
	public Jogador inserirBeneficio(Jogo jogoAtual, Jogador jogadorAtual, CartaBonificacao cartaUtilizada){
		Jogador auxiliar = jogoAtual.usarConceito(jogadorAtual, cartaUtilizada);
		return auxiliar;
	}
	//#endif
	
	/**
	 * Utiliza carta problema da mao do jogadorAtual e insere efeito oriundo da respectiva carta no tabuleiro do jogadorAlvo
	 * */
	 @Override
	public Jogador inserirProblema(Jogo jogoAtual, Jogador jogadorAtual, Jogador jogadorAlvo, CartaPenalizacao cartaUtilizada){
		Jogador auxiliar = jogoAtual.usarProblema(jogadorAtual, jogadorAlvo,cartaUtilizada);
		return auxiliar;
	}

}
