/*
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * Simules-SPL Project
 *
 * Created by Alisson R Santos
 * Date: 30/07/2011
 */
package br.ufmg.reuso.ui;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JOptionPane;

//#ifdef ConceptCard
import br.ufmg.reuso.negocio.carta.CartaBonificacao;
//#endif
import br.ufmg.reuso.negocio.carta.CartaPenalizacao;
import br.ufmg.reuso.negocio.carta.CartaoProjeto;
import br.ufmg.reuso.negocio.jogador.Jogador;
import br.ufmg.reuso.negocio.jogo.GameController;
import br.ufmg.reuso.negocio.jogo.Jogo;
import br.ufmg.reuso.negocio.mesa.Modulo;
import br.ufmg.reuso.negocio.tabuleiro.SetupInteraction;

/**
 * @author Alisson Rodrigo [AS]
 * 
 */
public class ScreenInteraction implements SetupInteraction{

	public static final int ARTEFATOS_BONS = 0;
	public static final int ARTEFATOS_RUINS = 1;
	public static final String imagePath = "DepositScreen/";

	/**
	 * Este array deve conter os artefatos escolhidos pelo usuário.
	 */
	int[][] artefatosEscolhidos = null;
	private int moduloEscolhido = -1;

	private ScreenTabuleiro tabuleiro;

	@SuppressWarnings("unused")
	private Jogo jogoAtual = null;
	private Jogador jogadorAtual = null;

	private static ScreenInteraction instance;

	private ScreenInteraction(){
	} // evita que cliente use new ScreenInteraction()

	public ScreenTabuleiro getTabuleiro(){
		if (tabuleiro == null)
			tabuleiro = ScreenTabuleiro.createAndShowTabuleiro(null, null);
		return tabuleiro;
	}

	public static ScreenInteraction getScreenInteraction(){
		if (instance == null)
			instance = new ScreenInteraction();
		return instance;
	}

	@Override
	public int exibirStart() /** exibe GUI(tela) para iniciar o jogo */
	{

		tabuleiro = ScreenTabuleiro.createAndShowTabuleiro(null, null);
		@SuppressWarnings("unused")
		String Retorno = ScreenStart.createAndShowGetModo(tabuleiro)
				.getReturn();
		System.out.printf(Retorno);
		return 0; // TODO michael david -> teste [ARS]Micheal voce precisa
					// testar o valor de retorno para saber se entra ou não no
					// modo de configuração. Quais são os valores 0 passa direto
					// e 1 entra na configuração?
	}

	@Override
	public int inserirDificuldadeJogo() /**
	 * valorDificuldade corresponde a:
	 * Fácil: 1 ; Moderado = 2 ; Difícil = 3
	 */
	{
		return ScreenModo.createAndShowGetModo(tabuleiro).getModeGame();
	}

	@Override
	public String[] inserirNomesJogadores() /**
	 * insere nome dos jogadores no
	 * vetor de string
	 */
	{
		String[] retorno = (ScreenGamers.createAndShowGetGamers(tabuleiro)
				.getReturn());
		return retorno;
	}

	@Override
	public void pedirRolarDadosInicial(String nomeJogador) /**
	 * exibe GUI
	 * solicitando que o jogador lance os dados para definir ordem do jogo
	 */
	{
		@SuppressWarnings("unused")
		boolean Retorno = ScreenLaunchDice.createAndShowLaunchDice(tabuleiro,
				nomeJogador, "Lance os dados para definir a ordem do jogo!")
				.getReturn();
	}

	@Override
	public void mostrarPontosObtidosInicial(int pontosObtidos) /**
	 * exibe GUI
	 * mostrando pontos obtidos;
	 */
	{
		ScreenResultDice.createAndShowResultDice(tabuleiro, pontosObtidos)
				.getReturn();
	}

	@Override
	public void mostrarEmpatePontosObtidosInicial(String nomeJogador) /**
	 * exibe
	 * GUI mostrando que houve empate, solicita que o jogador lance dados
	 * novamente
	 */
	{
		System.out.println(ScreenLaunchDice.createAndShowLaunchDice(tabuleiro,
				nomeJogador,
				"Você empatou com outro jogador! Lance os dados novamente!")
				.getReturn());
	}

	@Override
	public void mostrarOrdemJogo(String[] nomeJogadoresOrdenados) /**
	 * recebe
	 * vetor de strings já ordenados para exibir na GUI
	 */
	{
		@SuppressWarnings("unused")
		boolean retorno = (ScreenOrderGamers.createAndShowGetGamers(tabuleiro,
				nomeJogadoresOrdenados).getReturn());
	}

	@Override
	public void exibirProjeto(CartaoProjeto projeto){
		ScreenProject.createAndShowProject(tabuleiro, projeto);
	}

	@Override
	public void mostrarNumberCardasDelivered(int numberCardsDelivered) /**
	 * exibe
	 * a GUI mostrando o número de cartas recebidas respeito o limite de cartas
	 * na mao
	 */
	{

		String messager = "Mas você recebeu "
				+ Integer.toString(numberCardsDelivered)
				+ " devido ao limite de cartas que cada jogador pode ter em mãos";
		String title = "Limite de cartas";
		JOptionPane.showMessageDialog(tabuleiro, messager, title,
				JOptionPane.WARNING_MESSAGE);

	}

	/****************************************************************************/
	/************************** Mostra Tabuleiro ********************************/
	/****************************************************************************/

	/**
	 * exibe GUI Default com todas as informações do tabuleiro, cartas na mão do
	 * jogador, opções do jogo.
	 */
	public void exibirDefault(Jogo jogoAtual, Jogador jogador){

		this.jogadorAtual = jogador;
		this.jogoAtual = jogoAtual;
		tabuleiro.setJogador(jogador);
		tabuleiro.setJogo(jogoAtual);
		tabuleiro.setVisible(true);
		GameController.getGameController().terminarJogada(jogador);
	}

	/****************************************************************************/
	/************************ FIM Mostra Tabuleiro ******************************/
	/****************************************************************************/

	@Override
	public void exibirNaoDemiteEngenheiro() /**
	 * exibe GUI informando que
	 * engenheiro não pode ser demitido pois ele trabalhou naquela roodada
	 */
	{
		String messager = "O Engenheiro não pode ser demitido por já ter atuado nesta rodada do jogo.";
		String title = "Impossível demitir.";
		JOptionPane.showMessageDialog(tabuleiro, messager, title,
				JOptionPane.WARNING_MESSAGE);
	}

	@Override
	public void exibirExcessoPessoal() /**
	 * exibe GUI informandao que não pode
	 * haver contratação de engenheiro devido à excesso de pessoal
	 */
	{
		String messager = "Mesa ocupada. O engenheiro não pode ser alocado para esta mesa.";
		String title = "Mesa ocupada.";
		JOptionPane.showMessageDialog(tabuleiro, messager, title,
				JOptionPane.WARNING_MESSAGE);

	}

	@Override
	public void exibirFaltaDinheiro() /**
	 * exibe GUI informando que não há
	 * recursos para ação solicitada
	 */
	{
		String messager = "Você não possui recursos para isso.";
		String title = "Falta de Recurso.";
		JOptionPane.showMessageDialog(tabuleiro, messager, title,
				JOptionPane.WARNING_MESSAGE);
	}

	@Override
	public int escolherMesa() /**
	 * exibe GUI para jogador escolher mesa para
	 * alocar engenheiro contratado
	 */
	{
		String messager = "Em qual mesa deve ser alocado o engenheiro contratado.";
		String[] options = new String[]{ "Mesa 1", "Mesa 2", "Mesa 3",
				"Mesa 4", "Mesa 5" };

		String retorno = ScreenGenericChoose.createAndShowGenericChoose(
				messager, options, "Mesa1").getReturn();

		for (int i = 0; i < options.length; i++){
			if (options[i].compareToIgnoreCase(retorno) == 0){
				return i + 1;
			}
		}
		return -1;
	}

	@Override
	public int escolherMesaTransferencia() /**
	 * exibe GUI para jogador escolher
	 * mesa para transferir módulo integrado
	 */
	{
		String messager = "Escolha uma mesa sem módulo integrado para receber módulo transferido.";

		String[] options = new String[]{ "Mesa 1", "Mesa 2", "Mesa 3",
				"Mesa 4", "Mesa 5" };

		String retorno = ScreenGenericChoose.createAndShowGenericChoose(
				messager, options, "Mesa1").getReturn();

		for (int i = 0; i < options.length; i++){
			if (options[i].compareToIgnoreCase(retorno) == 0){
				return i + 1;
			}
		}
		return -1;
	}

	@Override
	public int escolherMesadeTrabalho() /**
	 * exibe GUI para jogador escolher mesa
	 * na qual o engenheiro deve trabalhar
	 */
	{

		String messager = "Em qual mesa o engenheiro vai trabalhar?";
		String[] options = new String[]{ "Mesa 1", "Mesa 2", "Mesa 3",
				"Mesa 4", "Mesa 5" };

		String retorno = ScreenGenericChoose.createAndShowGenericChoose(
				messager, options, "Mesa1").getReturn();

		for (int i = 0; i < options.length; i++){
			if (options[i].compareToIgnoreCase(retorno) == 0){
				return i + 1;
			}
		}
		return -1;

	}

	/**
	 * exibe GUI para jogador inserir quantidades de artefatos a serem
	 * produzidos
	 */
	@Override
	public Modulo[] exibirTabelaProducao(int habilidadeEngenheiro,
			int complexidadeProjeto){
		Modulo[] modulo = null; // Não pinta modulo algum - apresenta um máximo
								// de 4 elementos para criar.
		return ScreenChooseArtefacts.createAndShowChooseArtefacts(
				"Indique o número de artefatos a produzir.", modulo,
				complexidadeProjeto, habilidadeEngenheiro).getReturn();
	}

	/**
	 * exibe GUI para jogador inserir quantidades de artefatos a serem
	 * inspecionados
	 */
	@Override
	public Modulo[] exibirTabelaInspecao(int habilidadeEngenheiro,
			Modulo[] artefatosNotInspecionados){ // os inteiros que iniciam com
													// "artefatos..." servem
													// para fazer teste para ver
													// se houve tentativa de
													// inspecionar um número de
													// artefatos desnecessários
		Modulo[] pedidoArtefatos = artefatosNotInspecionados;

		int complexidade = -1; // Complexidade padrão igual a 1

		Modulo[] retorno = ScreenChooseArtefacts.createAndShowChooseArtefacts(
				"Selecione os artefatos a serem inspecionados",
				pedidoArtefatos, complexidade, habilidadeEngenheiro)
				.getReturn();

		return retorno;
	}

	/**
	 * exibe GUI para jogador inserir quantidades de artefatos a serem
	 * corrigidos
	 */
	@Override
	public Modulo[] exibirTabelaCorrecao(int habilidadeEngenheiro,
			Modulo[] artefatosInspecionadosBug){

		// os inteiros que iniciam com "artefatos..." servem para fazer teste
		// para ver se houve tentativa de corrigir um número de artefatos
		// desnecessários
		Modulo[] pedidoArtefatos = artefatosInspecionadosBug;

		int complexidade = -1; // Complexidade padrão igual a 1

		Modulo[] retorno = ScreenChooseArtefacts.createAndShowChooseArtefacts(
				"Selecione os artefatos a serem corrigidos", pedidoArtefatos,
				complexidade, habilidadeEngenheiro).getReturn();

		return retorno;
	}

	// TODO [ARS] essa função não é mais usada com as Guis
	@Override
	public int escolherModuloProjeto(Modulo[] modulos){

		int mesa = -1;
		String messager = "Selecione o módulo? (-1 para cancelar).";
		String title = "Módulo de trabalho.";

		String s = "";

		while (s == ""){

			try{
				s = JOptionPane.showInputDialog(null, messager, title,
						JOptionPane.QUESTION_MESSAGE);
				System.out.println(s);
				mesa = Integer.parseInt(s);

			} catch (Exception e){
				e.printStackTrace();
			} finally{
				if (s == null)
					return 0;
				if (mesa != -1)
					return -1;

				if ((mesa < 1) || (mesa > 6)){
					messager = "Selecione o módulo?"
							+ "\n Entre com um número entre 1 e 6. (-1 para cancelar)";
					System.out.println(mesa + " final " + s);
					s = "";
				}

			}
		}

		return mesa;

	}

	@Override
	public void exibirEngenheiroNaoIntegra() /**
	 * exibe GUI informando que
	 * engenheiro não pode integrar artefatos pois ele trabalhou naquela roodada
	 */
	{
		String messager = "O Engenheiro não pode integrar módulo por já ter atuado nesta rodada do jogo.";
		String title = "Impossível integrar.";
		JOptionPane.showMessageDialog(null, messager, title,
				JOptionPane.WARNING_MESSAGE);

	}

	@Override
	public void exibirQuantidadeArtefatosInsuficientes() /**
	 * exibe GUI
	 * informaando que qualquer combinação de artefatos da mesa do jogador não
	 * coincide com a combinação de artefatos do módulo do projeto escolhido
	 */
	{
		String messager = "Quantidade de artefatos não coincide com módulo escolhido.";
		String title = "Módulo errado.";
		JOptionPane.showMessageDialog(null, messager, title,
				JOptionPane.WARNING_MESSAGE);

	}

	@Override
	public void exibirHabilidadeInsuficiente() /**
	 * exibe GUI informaando que
	 * engenheiro deve ter habilidade >=1 para integrar módulo do projeto
	 * escolhido
	 */
	{
		System.out
				.printf("\nEngenheiro deve ter habilidade >=1 para integrar módulo do projeto escolhido");

		String messager = "Engenheiro deve ter habilidade maior ou igual a 1 para integrar módulo do projeto escolhido.";
		String title = "Impossível integrar módulo.";
		JOptionPane.showMessageDialog(null, messager, title,
				JOptionPane.WARNING_MESSAGE);

	}

	@Override
	public void exibirModuloJaIntegrado(int mesa) /**
	 * exibe GUI informado que o
	 * modulo já foi integrado
	 */
	{
		String messager = "O módulo solicitado já está integrado na mesa "
				+ "mesa"; // TODO modificação Michael
		String title = "Impossível integrar módulo.";
		JOptionPane.showMessageDialog(null, messager, title,
				JOptionPane.WARNING_MESSAGE);

	}

	@Override
	public void habilitarTrocarModuloIntegrado(int mesaTrabalho) /**
	 * habilita
	 * função do engenheiro da mesaTrabalho para trocar modulo integrado de mesa
	 */
	{
		// TODO aqui rola coisa da GUI /[AS] Não entendi o que essa função faz.

	}

	@Override
	public void exibirMesaModulo() /**
	 * exibe GUI informando que a mesa já contém
	 * módulo integrado
	 */
	{
		String messager = "Mesa escolhida para transferência já contém módulo integrado.";
		String title = "Impossável integrar módulo.";
		JOptionPane.showMessageDialog(null, messager, title,
				JOptionPane.WARNING_MESSAGE);
	}

	@Override
	public void exibirVencedor(Jogador jogador) /**
	 * exibe GUI informando que o
	 * jogador venceu
	 */
	{
		String messager = jogador.getNome()
				+ "\nVocê venceu o jogo por integrar todos os módulos do projeto.";
		String title = "Impossível integrar módulo.";
		JOptionPane.showMessageDialog(null, messager, title,
				JOptionPane.PLAIN_MESSAGE);
	}

	/**
	 * O array multidimensional de inteiros retornado tem 5 posições sendo:
	 * moduloCandidato[0] -> o vetor com posições escolhidas de artefatos de
	 * ajuda moduloCandidato[1] -> o vetor com posições escolhidas de artefatos
	 * de codigo moduloCandidato[2] -> o vetor com posições escolhidas de
	 * artefatos de desenho moduloCandidato[3] -> o vetor com posições
	 * escolhidas de artefatos de rastro moduloCandidato[4] -> o vetor com
	 * posições escolhidas de artefatos de requisitos método recebe o índice da
	 * mesa do jogador para limitar escolha de artefatos
	 */
	@Override
	public int[][] escolherArtefatos(int mesaTrabalho){
		int[][] artefatosRetornados = artefatosEscolhidos;
		artefatosEscolhidos = null;
		moduloEscolhido = -1;
		return artefatosRetornados;
	}

	@Override
	public int escolherMesaNeutralizaComponente(){
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int escolherMesaSofrerProblema(){
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String[] escolherEngenheiro(Jogador jogadorAtual,
			int quantitdadeEngenheiro){
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void exibirQuantidadeBeneficio(int quantidade){
		// TODO Auto-generated method stub

	}

	//#ifdef ConceptCard
	@Override
	public void exibirEfeitoinserido(Jogador jogadorAtual,
			CartaBonificacao cartaUtilizada){
		// TODO Auto-generated method stub

	}
	//#endif

	@Override
	public void exibirEfeitoinserido(Jogador jogadorAtual, Jogador jogadorAlvo,
			CartaPenalizacao cartaUtilizada, boolean condicaoSatisfeita){
		// TODO Auto-generated method stub

	}

	//#ifdef ConceptCard
	@Override
	public int[] inserirCartasConceitoSelecionadas() /**
	 * insere quais tipos de
	 * cartas conceito o jogo terá, conforme as constantes de ModeGmaeConstants
	 */
	{
		// System.out.println("quantos tipos de cartas de conceito?");
		// Scanner in = new Scanner(System.in);
		// int[] cartas = new int [in.nextInt()];
		// for(int i=0;i<cartas.length;i++)
		//{
		// System.out.println("quais tipos de cartas você deseja:\n0: todas\n1: código\n2:comunicação\n3:desenho\n4:gerencia\n5:RH\n6:requisitos");
		// cartas[i]=in.nextInt();
		// }
		// return cartas;
		int[] out = (ScreenSelectCards
				.createAndShowSelectCards("Selecione os tipos de carta conceito.")
				.getReturn());

		return out;
	}
	//#endif

	@Override
	public int[] inserirCartasProblemaSelecionadas() /**
	 * insere quais tipos de
	 * cartas problema o jogo terá, conforme as constantes de ModeGmaeConstants
	 */
	{
		// System.out.println("quantos tipos de cartas de problema?");
		// Scanner in = new Scanner(System.in);
		// int[] cartas = new int [in.nextInt()];
		// for(int i=0;i<cartas.length;i++)
		//{
		// System.out.println("quais tipos de cartas você deseja:\n0: todas\n1: código\n2:comunicação\n3:desenho\n4:gerencia\n5:RH\n6:requisitos");
		// cartas[i]=in.nextInt();
		// }
		int[] out = (ScreenSelectCards
				.createAndShowSelectCards("Selecione os tipos de carta problema")
				.getReturn());

		return out;
	}

	/**
	 * Mostra janela com informação contida em mensagem para o usuário com o
	 * título contido em titulo.
	 * 
	 * @param mensagem
	 * @param titulo
	 */
	@Override
	public void exibirMensagem(String mensagem, String titulo){
		JOptionPane.showMessageDialog(null, mensagem, titulo,
				JOptionPane.WARNING_MESSAGE);
	}

	// **-------------------As tres próximas funções trabalham
	// juntas-------------------**//
	/**
	 * Função auxiliar que inicializa modulo e artefatos a serem integrados.
	 * 
	 * @param mesaTrabalho
	 * @param jogadorAtual
	 */
	public void escolherModuloEArtefatos(int mesaTrabalho){
		ScreenIntegrateModule scr = ScreenIntegrateModule
				.createAndShowIntegrateModule(Jogo.getJogo().getProjeto(),
						jogadorAtual.getTabuleiro().getMesas()[mesaTrabalho]);
		artefatosEscolhidos = scr.getArtefatosEscolhidos();
		moduloEscolhido = scr.getModuleReturn();

	}

	@Override
	public int escolherModuloProjeto(Modulo[] modulos, int mesa){
		escolherModuloEArtefatos(mesa);
		return moduloEscolhido;
	}

	@Override
	public int[][] artefatosEscolhidos(){
		int[][] returnArtefatosEscolhidos = artefatosEscolhidos;
		artefatosEscolhidos = null;
		moduloEscolhido = -1;
		return returnArtefatosEscolhidos;
	}

	// **----------------As tres funções anteriores trabalham
	// juntas--------------------**//

	public WindowAdapter windowsExitGame(){
		WindowAdapter adapter = new WindowAdapter(){
			public void windowClosing(WindowEvent we){
				String messager = "Tem certeza que você quer sair do jogo?";
				String title = "Sair do jogo";
				int back = (int) JOptionPane
						.showConfirmDialog(ScreenInteraction
								.getScreenInteraction().getTabuleiro(),
								messager, title, JOptionPane.OK_CANCEL_OPTION);
				if (back == JOptionPane.OK_OPTION){
					System.exit(0);
				}
			}
		};

		return adapter;
	}
}
