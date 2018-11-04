/*
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * Simules-SPL Project
 *
 * Created by Charles / Pedro / Salatiel / Suelen
 * Date: 14/11/2014
 * Aspecto responsável pelas mensagens exibidas (logging)
 * 
 * Editado por: Aline Brito, Igor Muzetti (2018-2). Modificações:
 * 	- Refatoração e reuso dos pointcut iniciarJogo(), criarJogador(), sortearArtefato().
 *  - 3 novos pointcut adicionados: criarJogo()
 */

import br.ufmg.reuso.negocio.baralho.BaralhoCartas;
import br.ufmg.reuso.negocio.jogo.GameController;
import br.ufmg.reuso.negocio.jogo.Jogo;

public aspect LoggingAspect{
	
	private void exibirLog(String mensagem) {
		System.out.println("\nINFO: " + mensagem);
	}
	
	// Aspecto para exibir mensagem de criação do jogo.
	// Executado após  da chamada ao método Jogo.getJogo(..)
	pointcut criarJogo() : call(Jogo Jogo.getJogo(..) );

	after() : criarJogo(){
		exibirLog("Recuperando instância do jogo.");
	}
	
	//Aspecto para exibir status da criação dos jogadores. 
	//Executado após chamada ao método Jogo.cadastrarJogadores(..)
	
	pointcut criarJogador(Jogo jogo) : call(void Jogo.cadastrarJogadores(..) )  && target(jogo);
	
	after(Jogo jogo) : criarJogador(jogo){
		exibirLog("Jogadores criados com sucesso - " + jogo.getJogadoresToString());
	}
	
	//Aspecto para exibir status de termino de jogada.
	//Executado após chamada ao método GameController.terminarJogada(..)
	
	pointcut terminarJogada() : call(void GameController.terminarJogada(..) );
	
	after() : terminarJogada(){
		exibirLog("Terminando jogada.");
	}
	
	//Aspecto para exibir mensagem após inicialização das cartas de conceito.
	//Executado após chamada ao método BaralhoCartas.inicializarCartasConceito(..)
	
	pointcut inicializarCartasConceito() : call(void BaralhoCartas.inicializarCartasConceito(..) );
	
	after() : terminarJogada(){
		exibirLog("Cartas de conceito inicializadas.");
	}
	
	//Aspecto para exibir mensagem após inicialização das cartas de problemas.
	//Executado após chamada ao método BaralhoCartas.inicializarCartasProblemas(..)
	
	pointcut inicializarCartasProblemas() : call(void BaralhoCartas.inicializarCartasProblemas(..) );
	
	after() : terminarJogada(){
		exibirLog("Cartas de problema inicializadas.");
	}
	
	//Aspecto para exibir mensagem após inicialização das cartas de engenheiro.
	//Executado após chamada ao método GameController.terminarJogada(..)
	
	pointcut inicializarCartasEngenheiro() : call(void BaralhoCartas.inicializarCartasEngenheiro(..) );
	
	after() : terminarJogada(){
		exibirLog("Cartas de engenheiro inicializadas.");
	}
	
	//Aspecto para inserir registro no log após exibição do cartão do projeto.
	//Executado após chamada a chamada de qualquer uma das implementações do métod .verProjeto(..)
		
	pointcut verProjeto() : call(void *.exibirProjeto(..) );
	
	after() : verProjeto(){
		exibirLog("Cartão do projeto exibido.");
	}
	
	
}