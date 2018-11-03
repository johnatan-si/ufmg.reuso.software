/*
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * Simules-SPL Project
 *
 * Created by Michael David
 * Date: 16/07/2011
 */

package br.ufmg.reuso.negocio.tabuleiro;

//#ifdef ConceptCard
import br.ufmg.reuso.negocio.carta.CartaBonificacao;
//#endif
import br.ufmg.reuso.negocio.carta.CartaPenalizacao;
import br.ufmg.reuso.negocio.carta.CartaoProjeto;
import br.ufmg.reuso.negocio.jogador.Jogador;
import br.ufmg.reuso.negocio.jogo.Jogo;
import br.ufmg.reuso.negocio.mesa.Modulo;

/**
 * @author Michael David
 *
 */
public interface SetupInteraction{
	public static final int EASY = 1; 
	public static final int MODERATE = 2;
	public static final int HARD = 3;
	public static final int PROJETO_CONCLUIDO = 0;
	public static final int PROJETO_NAO_CONCLUIDO = 1;
	public static final int ARTEFATOS_AJUDA = 0;
	public static final int ARTEFATOS_CODIGO = 1;
	public static final int ARTEFATOS_DESENHO = 2;
	public static final int ARTEFATOS_RASTROS = 3;
	public static final int ARTEFATOS_REQUISITOS = 4;
	
	public int exibirStart();  			  								//exibe GUI(tela) para iniciar o jogo. Retorna 1 caso há a necessidade de configurar o jogo. Retorna 0 caso contrário
	  
	public int inserirDificuldadeJogo(); 								//valorDificuldade corresponde a: Fácil: 1 ; Moderado = 2  ; Díficil = 3 

	public String [] inserirNomesJogadores();  							//insere nome dos jogadores no vetor de string        
	  
	public void pedirRolarDadosInicial(String nomeJogador); 			//exibe GUI solicitando que o jogador lance os dados para definir ordem do jogo
	
	public void mostrarPontosObtidosInicial(int pontosObtidos); 		//exibe GUI mostrando pontos obtidos;
	
	public void mostrarEmpatePontosObtidosInicial(String nomeJogador); 	//exibe GUI mostrando que houve empate, solicita que o jogador lance dados novamente;
	
	public void mostrarOrdemJogo(String [] nomeJogadoresOrdenados); 	//recebe vetor de strings já ordenados para exibir na GUI 
	
	public void exibirProjeto(CartaoProjeto projeto);					//exibe cartao de projeto na GUI						
	
	public void exibirDefault(Jogo jogoAtual, Jogador jogador);	/**exibe GUI Default com todas as informações do tabuleiro, cartas na mão do jogador, opções do jogo.*/
	
	public void mostrarNumberCardasDelivered(int numberCardsDelivered);	/**exibe a GUI mostrando o número de cartas recebidas respeito o limite de cartas na mao*/
	
	public void exibirNaoDemiteEngenheiro();									/**exibe GUI informando que engenheiro não pode ser demitido pois ele trabalhou naquela roodada*/
	
	public void exibirExcessoPessoal();									/**exibe GUI informandao que não pode haver contratação de engenheiro devido à excesso de pessoal*/
	
	public void exibirFaltaDinheiro(); 									/**exibe GUI informando que não há recursos para ação solicitada*/ 
	
	public int escolherMesa();											/**exibe GUI para jogador escolher mesa para alocar engenheiro contratado*/
	
	public int escolherMesaTransferencia();								/**exibe GUI para jogador escolher mesa para transferir módulo integrado*/

	public int escolherMesaNeutralizaComponente(); //TODO juntar essas função de mesa

	public int escolherMesaSofrerProblema(); //TODO juntar essas função de mesa

	/**exibe GUI para jogador inserir quantidades de artefatos a serem produzidos*/
	public Modulo[] exibirTabelaProducao(int habilidadeEngenheiro, int complexidadeProjeto);				 
	
	/**exibe GUI para jogador inserir quantidades de artefatos a serem inspecionados*/
	public Modulo[] exibirTabelaInspecao(int habilidadeEngenheiro, Modulo[] artefatosNotInspecionados);	
	
	/**exibe GUI para jogador inserir quantidades de artefatos a serem corrigidos*/
	public Modulo[] exibirTabelaCorrecao(int habilidadeEngenheiro,Modulo[] artefatosInspecionadosBug);				 

	public int escolherMesadeTrabalho();								/**exibe GUI para jogador escolher mesa na qual o engenheiro deve trabalhar
	 * @param modulos */
	
	public int escolherModuloProjeto(Modulo[] modulos); 	/**exibe GUI ,com cartão de projeto, para jogador escolher qual módulo do cartão de projeto o engenheiro deve integrar*/
	
	public void exibirEngenheiroNaoIntegra();	/**exibe GUI informando que engenheiro não pode integrar artefatos pois ele trabalhou naquela roodada*/
	
	public void exibirQuantidadeArtefatosInsuficientes(); /**exibe GUI informaando que qualquer combinação de artefatos da mesa do jogador não coincide com a combinação de artefatos do módulo do projeto escolhido*/

	public void exibirHabilidadeInsuficiente(); /**exibe GUI informaando que engenheiro deve ter habilidade >=1 para integrar módulo do projeto escolhido*/
	
	public void exibirModuloJaIntegrado(int mesa); 		/**exibe GUI informado que o modulo já foi integrado*/
	
	public void habilitarTrocarModuloIntegrado(int mesaTrabalho); /**habilita função do engenheiro da mesaTrabalho para trocar modulo integrado de mesa*/

	public void exibirMesaModulo();				/**exibe GUI informando que a mesa já contém módulo integrado*/

	public void exibirVencedor(Jogador jogador);			/**exibe GUI informando que o jogador venceu*/
	
	
	/**  O array multidimensional de inteiros retornado tem 5 posições sendo:
	*  moduloCandidato[0] -> o vetor com posições escolhidas de artefatos de ajuda
	*  moduloCandidato[1] -> o vetor com posições escolhidas de artefatos de codigo
	*  moduloCandidato[2] -> o vetor com posições escolhidas de artefatos de desenho
	*  moduloCandidato[3] -> o vetor com posições escolhidas de artefatos de rastro
	*  moduloCandidato[4] -> o vetor com posições escolhidas de artefatos de requisitos
	*  método recebe o índice da mesa do jogador para limitar escolha de artefatos*/
	public int [][] escolherArtefatos(int mesaTrabalho);
	
	public String[] escolherEngenheiro(Jogador jogadorAtual,int quantitdadeEngenheiro);	/**escolhe uma quantidade de engenheiros de qualquer mesa do jogador, retornando os nomes do engenheiros*/
	
	//#ifdef ConceptCard
	public void exibirQuantidadeBeneficio(int quantidade);			/**exibe GUI informando a quantidade de efeito a receber*/
	//#endif

	//#ifdef ConceptCard
	public void exibirEfeitoinserido(Jogador jogadorAtual,CartaBonificacao cartaUtilizada); /**exibe GUI informando que houve a inserção de conceito*/
	//#endif

	public void exibirEfeitoinserido(Jogador jogadorAtual, Jogador jogadorAlvo, CartaPenalizacao cartaUtilizada, boolean condicaoSatisfeita); /**exibe GUI informando que houve a inserção de problema*/

	
	//#ifdef ConceptCard
	public int[] inserirCartasConceitoSelecionadas();
	//#endif

	public int[] inserirCartasProblemaSelecionadas();

	
	/** Mostra janela com informação contida em mensagem para o usuário com o título contido em titulo.
	 * 	
	 * @param mensagem Mensagem mostrada na caixa de mensagem
	 */
	public void exibirMensagem(String mensagem, String titulo) ;

	public int escolherModuloProjeto(Modulo[] modulos, int Mesa); 
	
	/**Escolhe artefatos do tabuleiro
	 * @return um inteiro que terá:
	 * na linha 0 do vetor há artefatos de ajuda
	 * na linha 1 do vetor há artefatos de código
	 * na linha 2 do vetor há artefatos de desenho
	 * na linha 3 do vetor há artefatos de rastro
	 * na linha 4 do vetor há artefatos de requisitos
	 * O número de colunas é igual ao número de artefatos que o jogador contém em cada linha
	 * as colunas dos vetores terão valores iguais a:
	 * -1 para artefatos não selecionados pelo jogador
	 * 0 para artefatos selecionados pelo jogador
	 */
	public int[][] artefatosEscolhidos();
	
}
