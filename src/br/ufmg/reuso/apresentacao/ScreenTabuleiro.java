/*
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * Simules-SPL Project
 *
 * Created by Alisson
 * Date: 18/07/2011
 * 
 * Tabuleiro do jogo SimulesSPL
 *   
 */
package br.ufmg.reuso.apresentacao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.Border;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import br.ufmg.reuso.negocio.carta.Artefato;
import br.ufmg.reuso.negocio.carta.Carta;
//#ifdef ConceptCard
import br.ufmg.reuso.negocio.carta.CartaBonificacao;
//#endif
import br.ufmg.reuso.negocio.carta.CartaEngenheiro;
import br.ufmg.reuso.negocio.carta.CartaPenalizacao;
import br.ufmg.reuso.negocio.jogador.Jogador;
import br.ufmg.reuso.negocio.jogo.GameController;
import br.ufmg.reuso.negocio.jogo.Jogo;
import br.ufmg.reuso.negocio.mesa.Mesa;

/**
 * @author Alisson Classe responsável por pintar o tabuleiro com as informações
 *         do jogador atual e permitir sua manipulação do jogo
 */
// =====================================================================================//
// Inicio da classe ScreenTabuleiro
// =====================================================================================//
public class ScreenTabuleiro extends JDialog{

	// Variáveis globais
	private static final long serialVersionUID = 2797977843067840264L;

	// Paineis
	JPanel panelBase;
	JPanel panelButtonsLeft;
	JPanel panelButtonsRight;
	JPanel panelMesas;
	JPanel panelCartas;
	JPanel panelTabuleiro;

	//Border border = BorderFactory.createLineBorder(Color.DARK_GRAY, 1);

	Color colorBack = Color.LIGHT_GRAY;

	// Variáveis que fazem ligação com o jogo
	Jogador jogador = null;
	Jogador oponent = null;
	Jogo jogo = null;
	Mesa board = null;
	Carta cartaAtiva = null;

	// Variáveis utilizadas para posicionamento dos paineis.
	private int x, y, width, height, yInc, xInc;
	private Dimension dimPanel;
	private Dimension mySise = new Dimension();

	// =====================================================================================//
	/**
	 * @param jogador
	 *            Jogador atual a manipular o jogo
	 * @param jogo
	 *            Jogo responsável pelo controle das informações apresentadas
	 * 
	 *            Se os parâmetros forem nulos um tabuleiro vazio será pintado.
	 */
	public ScreenTabuleiro(Jogador jogador, Jogo jogo){
		super();

		try{
			for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()){
				if ("Nimbus".equals(info.getName())){
					UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (Exception e){
			System.out.println(e.getMessage());
		}

		this.jogador = jogador;
		this.jogo = jogo;

		board = null;

		cartaAtiva = null;
		initialize();

		panelTabuleiro = getPanelBase();

	}

	// =====================================================================================//

	/**
	 * Define as dimensoes do painel iguais as dimensões da tela
	 * 
	 */
	private void initialize(){

		Toolkit tk = Toolkit.getDefaultToolkit();
		Dimension screenSize = tk.getScreenSize();
		this.setPreferredSize(screenSize);
		mySise = screenSize;
		mySise.setSize(1366, 768);

	}

	// =====================================================================================//
	/**
	 * Define o painel principal da janela de diálogo
	 * 
	 * @return JPanel contendo o container base do tabuleiro
	 * 
	 */
	private JPanel getPanelBase(){

		JPanel jpanel = new JPanel();

		BorderLayout brd = new BorderLayout();
		jpanel.setLayout(brd);

		JLabel lblNoth = new JLabel();
		lblNoth.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
		lblNoth.setBackground(colorBack);
		lblNoth.setOpaque(true);
		jpanel.add(lblNoth, BorderLayout.NORTH);

		jpanel.add(panelButtonsLeft = getPanelButtonsLeft(), BorderLayout.WEST);

		jpanel.add(panelButtonsRight = getPanelButtonsRight(),
				BorderLayout.EAST);

		if (jogador != null){
			panelMesas = getPanelMesas();
			panelMesas.setEnabled(oponent == null);
			jpanel.add(panelMesas, BorderLayout.CENTER);
			panelCartas = getPanelCards();
			jpanel.add(panelCartas, BorderLayout.SOUTH);

		}

		this.setContentPane(jpanel);

		panelBase = jpanel;

		return jpanel;
	}

	// =====================================================================================//
	/**
	 * Pinta o painel com os botões de acesso geral do usuário
	 * 
	 * @return JPanel contendo o container base do tabuleiro
	 * 
	 */
	private JPanel getPanelButtonsLeft(){
		
		Dimension myDim = new Dimension(mySise.width * 15 / 100, mySise.height * 60 / 100);

		//Define componentes
		JPanel jpanel = new JPanel();
		jpanel.setBorder(BorderFactory.createRaisedBevelBorder());
		jpanel.setBackground(colorBack);
		jpanel.setPreferredSize(myDim);
		jpanel.setLayout(null);

		JButton buttonTabuleiro = new JButton(
				(oponent == null ? "<html><Center>Ver Tabuleiro do Oponente"
						: "<html><Center>Voltar para seu tabuleiro."));
		buttonTabuleiro.setActionCommand("Ver Tabuleiro do Oponente");
		buttonTabuleiro.addActionListener(getActionButtonPanel());

		JButton buttonProjeto = new JButton("<html><Center>Ver Projeto");
		buttonProjeto.setActionCommand("Ver Projeto");
		buttonProjeto.addActionListener(getActionButtonPanel());

		JButton buttonDados = new JButton("<html><Center>Jogar Dados");
		boolean jogadados;
		if ((jogador == null) || (oponent != null)){
			jogadados = false;
		} else{
			jogadados = !jogador.isDadoJogado();
		}
		buttonDados.setEnabled(jogadados);
		buttonDados.setActionCommand("Jogar Dados");
		buttonDados.addActionListener(getActionButtonPanel());

		JButton buttonEnd = new JButton("<html><Center>Terminar Jogada");
		buttonEnd.setActionCommand("Terminar Jogada");
		buttonEnd.addActionListener(getActionButtonPanel());
		buttonEnd.setEnabled(oponent == null);

		
		//Define posições
		int x, y, width, height, ygap, numButtons;
		x = y = width = height = ygap = numButtons = 0;

		numButtons = 4;
		width = myDim.width * 90 / 100;
		x = (myDim.width - width) / 2;
		ygap = (myDim.height) / ((2*numButtons)+1);
		height =  (myDim.height) / (2*numButtons+1);
		y = ygap/2;
		
		int heightButton = 40;
		int widthButton = 150;
		buttonTabuleiro.setBounds(x, y, widthButton, heightButton);

		y += ygap + height;
		buttonProjeto.setBounds(x, y, widthButton, heightButton);

		y += ygap + height;
		buttonDados.setBounds(x, y, widthButton, heightButton);

		y += ygap + height;
		buttonEnd.setBounds(x, y, widthButton, heightButton);
		
		//Define Adiciona no painel
		jpanel.add(buttonTabuleiro);
		jpanel.add(buttonProjeto);
		jpanel.add(buttonDados);
		jpanel.add(buttonEnd);


		return jpanel;
	}

	// =====================================================================================//
	/**
	 * @return JPanel com o painel direito do tabuleiro.
	 * 
	 */
	// TODO [ARS] Este painel pode apresentar problemas e conceitos ativos
	private JPanel getPanelButtonsRight(){

		Dimension myDim = new Dimension(mySise.width * 15 / 100, mySise.height * 60 / 100);
		
		JPanel jpanel = new JPanel();

		jpanel.setBorder(BorderFactory.createRaisedBevelBorder());

		jpanel.setPreferredSize(myDim);

		jpanel.setBackground(colorBack);		
		
		jpanel.setLayout(null);
		
		String messager = "Situação do jogo\n";
			
		//Font font = new Font("Default", Font.PLAIN, 25);
		
		if (jogador != null){
			//jogador.getTabuleiro().getMesas()[1].getModuloIntegrado()
			
		}
		
		JTextPane paneDesc = new JTextPane();
		SimpleAttributeSet bSet = new SimpleAttributeSet();		
		StyleConstants.setAlignment(bSet, StyleConstants.ALIGN_JUSTIFIED);
		StyledDocument doc = paneDesc.getStyledDocument();
		doc.setParagraphAttributes(0, doc.getLength(), bSet, false);		
		paneDesc.setText(messager);		
		paneDesc.setInheritsPopupMenu(true);
		paneDesc.setAlignmentX(CENTER_ALIGNMENT);
		//paneDesc.setFont(font);
		paneDesc.setBorder(BorderFactory.createLineBorder(Color.white));
		paneDesc.setEditable(false);		
		paneDesc.setEnabled(false);		
		JScrollPane sliderPaneDesc = new JScrollPane(paneDesc);		
		sliderPaneDesc.setViewportView(paneDesc);
		sliderPaneDesc.setBounds(0,0, myDim.width, 90*myDim.height/100);				
		jpanel.add(sliderPaneDesc);
		return jpanel;
	}

	// =====================================================================================//
	// Inicio da construção das mesas dos engenheiros
	// =====================================================================================//

	/**
	 * A função é responsável por pintar tanto as mesas com os engenheiros quanto
	 * os títulos destas
	 * 
	 * @return JPanel contendo as mesas com engenheiros e artefatos
	 */
	private JPanel getPanelMesas(){

		JPanel jpanel = new JPanel();
		jpanel.setLayout(null);

		jpanel.setBorder(BorderFactory.createLoweredBevelBorder());

		jpanel.setBackground(colorBack);

		dimPanel = new Dimension(mySise.width * 65 /100, mySise.height * 80 /100);

		jpanel.setPreferredSize(dimPanel);

		Border borderW = BorderFactory.createLineBorder(Color.white, 1);

		// int x, y, height, width, xInc, yInc; // Definido em escopo geral

		x = y = 0;
		xInc = dimPanel.width / 6;
		yInc = 2 * dimPanel.height / 25;
		height = yInc * 3;
		width = xInc;

		// Desenha os títulos das mesas
		jpanel.add(getPanelTitleBoards());

		{
			JPanel panelBoard;
			Jogador jogadorAtual = (oponent == null ? jogador : oponent);
			
			for (int i = 0; i < jogadorAtual.getTabuleiro().getMesas().length; i++){

				board = jogadorAtual.getTabuleiro().getMesas()[i];

				panelBoard = new JPanel();
				panelBoard.setLayout(null);
				panelBoard.setBackground(colorBack);
				
				y = 0;
				height = yInc;
				width = xInc;
				x = 0;
				int maxBoardSize = 0;

				JLabel label = null;

				// Desenha os engenheiros na mesa
				panelBoard = getEnginerLabel(i, panelBoard);

				// ScreenInteraction.getScreenInteraction().exibirMensagem(Integer.toString(x),
				// "");

				{// Inicio do colocação da matriz de artefatos
					ArrayList<List<Artefato>> modulo = new ArrayList<List<Artefato>>(); //MQS 2019/1 - Tarefa #14, solucao #S10
					modulo.add(board.getRequisitos());
					modulo.add(board.getDesenhos());
					modulo.add(board.getCodigos());
					modulo.add(board.getRastros());
					modulo.add(board.getAjudas());
					modulo.add(board.getTestes());

					Vector<String> names = new Vector<String>(Arrays.asList(new String[]{ "Requisitos", "Desenhos", "Códigos", "Rastros", "Ajudas", "Testes" }));
					int j = 0;

					int mesa = i;

					// Para cada tipo de artefato
					Iterator<List<Artefato>> itModulo = modulo.iterator(); //MQS 2019/1 - Tarefa #14, solucao #S10
					while (itModulo.hasNext()){

						List<Artefato> artefatos = itModulo.next(); //MQS 2019/1 - Tarefa #14, solucao #S10
						x = 0;

						if (artefatos.size() > 0){
							Iterator<Artefato> it = artefatos.iterator();
							Artefato art = null;
							ImageIcon img = null;
							y += height;
							height = yInc / 2;
							while (it.hasNext()){

								art = it.next();

								img = getImageArtefact(art);

								label = new JLabel();

								label.setIcon(img);

								label.setBounds(x + 2, y + (height / 2),
										img.getIconWidth(), img.getIconHeight());

								if (it.hasNext() == true){
									x += img.getIconWidth();
									maxBoardSize = (x > maxBoardSize ? x
											: maxBoardSize);
								}

								// label.setBorder(borderW);
								panelBoard.add(label);

							} // Fim do while sobre os artafatos de um tipo

							// y += height/2;
							height = yInc;

						} else{ // Se não há artefatos do tipo atual
							label = new JLabel(names.elementAt(j) + " mesa "
									+ Integer.toString(mesa + 1));
							label.setOpaque(false);

							y += height;
							height = yInc;
							label.setBounds(x, y, width, height);
							// label.setBorder(borderW);
							panelBoard.add(label);
						}
						

						j++;
					} // Fim do while sobre tipos de artefatos

					// Inserir Requisitos

				} // Fim do colocação da matriz de artefatos

				x = 0;

				JButton buttonIntegrate = new JButton("Integrar");
				y += height;
				height = yInc / 2;
				//width = (maxBoardSize > width ? maxBoardSize : width); 
				buttonIntegrate.setBounds(x, y + 20, width, height);
				buttonIntegrate.setActionCommand(Integer.toString(i));
				buttonIntegrate.addActionListener(getActionIntegrate());
				buttonIntegrate.setEnabled(oponent == null);

				panelBoard.add(buttonIntegrate);

				panelBoard.setBounds(width * (i + 1), 0, maxBoardSize, dimPanel.height);
				panelBoard.setPreferredSize(new Dimension(maxBoardSize,dimPanel.height));
				panelBoard.setBorder(borderW);

				JScrollPane scrollBoard;	
				scrollBoard = new JScrollPane();
				scrollBoard.setBorder(null);
				scrollBoard.setBounds(width * (i + 1), 0, width, dimPanel.height);
				scrollBoard.setViewportView(panelBoard);
				
				jpanel.add(scrollBoard);

			}

		}
		return jpanel;
	}

	// =====================================================================================//
	/**
	 * @param mesa
	 *            representa a posição no vetor de mesas no jogo em que o
	 *            engenheiro está alocado
	 * @param panelBoard
	 *            representa o painel vertical em que será pintada a mesa
	 * @return retorna o painel com o engenheiro pintado
	 */
	private JPanel getEnginerLabel(int mesa, JPanel panelBoard){

		JLabel label = null;		
		if (board.getCartaMesa() != null){
			label = new JLabel();
			height = yInc;
			ImageIcon img = ComponentCard.getImageScalable(
					ScreenInteraction.imagePath
							+ board.getCartaMesa().getCodigoCarta() + ".png",
					width, 0);
			if (img == null){
				img = ComponentCard.getImageScalable(
						ScreenInteraction.imagePath + "smile.png", 0, height);
			}
			label.setIcon(img);
			label.setHorizontalAlignment(JLabel.CENTER);
			label.setBounds(x, y, width, height);
			// label.setBorder(borderW);
			panelBoard.add(label);

			label = new JLabel(board.getCartaMesa().getNomeEngenheiro(),
					JLabel.CENTER);
			y += height;
			height = yInc / 2;
			label.setBounds(x, y, width, height);
			// label.setBorder(borderW);
			panelBoard.add(label);

			JButton btnEng = new JButton("Usar");
			y += height;
			btnEng.setActionCommand(Integer.toString(mesa));
			btnEng.addActionListener(getActionEnginer());
			btnEng.setBounds(x, y, width, height);
			btnEng.setEnabled(oponent == null);
			// btnEng.setBorder(borderW);
			panelBoard.add(btnEng);

		} else{
			label = new JLabel("<html><center>Mesa do<br> Eng. "
					+ Integer.toString(mesa + 1), JLabel.CENTER);
			height = 2 * yInc;
			label.setBounds(x, y, width, height);
			// label.setBorder(borderW);
			panelBoard.add(label);
		}

		return panelBoard;
	}

	// =====================================================================================//
	/**
	 * @return JPanel com o painel com as mesas dos engenheiros.
	 * 
	 */
	private JPanel getPanelTitleBoards(){

		JPanel panelTitle = new JPanel();
		panelTitle.setLayout(null);
		panelTitle.setBackground(colorBack);

		//Border borderW = BorderFactory.createLineBorder(Color.WHITE);

		JLabel label = new JLabel("<html><center><b>Jogador: " + (oponent == null ? jogador.getNome() : oponent.getNome()), JLabel.CENTER);
		label.setBounds(x, y - 40, width, height);
		//label.setBorder(borderW);
		panelTitle.add(label);

		panelTitle.setBounds(0, 0, width, dimPanel.height);
		
		label = new JLabel("Requisitos", JLabel.CENTER);
		y += height * 70/100;
		height = yInc;
		label.setBounds(x, y, width, height);
		//label.setBorder(borderW);
		panelTitle.add(label);

		label = new JLabel("Desenhos", JLabel.CENTER);
		y += height;
		label.setBounds(x, y, width, height);
		//label.setBorder(borderW);
		panelTitle.add(label);

		label = new JLabel("Códigos", JLabel.CENTER);
		y += height;
		label.setBounds(x, y, width, height);
		//label.setBorder(borderW);
		panelTitle.add(label);

		label = new JLabel("Rastros", JLabel.CENTER);
		y += height;
		label.setBounds(x, y, width, height);
		//label.setBorder(borderW);
		panelTitle.add(label);

		label = new JLabel("Ajudas", JLabel.CENTER);
		y += height;
		label.setBounds(x, y, width, height);
		//label.setBorder(borderW);
		panelTitle.add(label);
		
		label = new JLabel("Testes", JLabel.CENTER);
		y += height;
		label.setBounds(x, y, width, height);
		//label.setBorder(borderW);
		panelTitle.add(label);

		label = new JLabel("Integração", JLabel.CENTER);
		y += height;
		height = yInc / 2;
		label.setBounds(x, y + 10, width, height);
		//label.setBorder(borderW);
		panelTitle.add(label);

		return panelTitle;

	}

	// =====================================================================================//
	// Fim da construção das mesas dos engenheiros
	// =====================================================================================//

	/**
	 * Métod responsável por pintar as cartas no tabuleiro
	 * 
	 * @return JPanel que pinta as cartas no tabuleiro.
	 */
	private JPanel getPanelCards(){

		Dimension Mydim = new Dimension(mySise.width, mySise.height * 37/100);

		Border border = BorderFactory.createRaisedBevelBorder();
		
		JPanel jpanel = new JPanel();
		jpanel.setLayout(null);
		jpanel.setBackground(colorBack);
		jpanel.setPreferredSize(Mydim);
		jpanel.setBorder(border);

		Carta[] carta = jogador.getCartas();

		int x, y, width, height, xgap;

		x = y = width = height = xgap = 0;

		
		xgap = (Mydim.width / (carta.length + 1)) * 30 / 100;
		x = xgap;

		JPanel component = null;
		for (int i = 0; i < carta.length; i++){

			height = Mydim.height * 80 / 100;
			width = (Mydim.width / carta.length) * 70 / 100;

			x = (x == xgap ? x : x + xgap);
			y = Mydim.height * 5 / 100;

			if (carta[i] != null){
				component = new ComponentCard(carta[i], ScreenTabuleiro.this);
				component.setBorder(border);
				component.setBounds(x, y, width, height);
				jpanel.add(component);

				y += height;
				width = width / 2;

				height = Mydim.height * 10 / 100;
				JButton btnUse = new JButton("Usar");
				btnUse.setName("Usar");
				btnUse.setBounds(x, y, width, height);
				btnUse.setActionCommand(Integer.toString(i));
				btnUse.addActionListener(getActionButtonCard());

				if (oponent == null){
					if (carta[i] instanceof CartaPenalizacao){
						btnUse.setEnabled(false);
					}
				} 
				else{
					if (
							//#ifdef ConceptCard
							(carta[i] instanceof CartaBonificacao) || 
							//#endif
							(carta[i] instanceof CartaEngenheiro)){
						btnUse.setEnabled(false);
					}
				}

				jpanel.add(btnUse);

				x += width;
				JButton btnDiscard = new JButton("Descartar");
				btnDiscard.setName("Descartar");
				btnDiscard.setBounds(x, y, width, height);
				btnDiscard.setActionCommand(Integer.toString(i));
				btnDiscard.addActionListener(getActionButtonCard());
				jpanel.add(btnDiscard);

				x += width;

			}// Fim da carta[i]
			else{
				JLabel label = new JLabel("Vazio", JLabel.CENTER);
				label.setBorder(border);
				label.setBounds(x, y, width * 80/100, height * 90/100);
				jpanel.add(label);
				x += width;
			}

		} //end for
		
		return jpanel;
	}

	// =====================================================================================//
	/**
	 * Recebe um artefato a ser pintado e verifica, segundo seu estado qual a
	 * imagem correspondente
	 * 
	 * @param art
	 *            - Artefato a ser pintado
	 * 
	 * @return a imagem no formato ImagIcon a ser pintada em um Label
	 */
	private ImageIcon getImageArtefact(Artefato art){
		ImageIcon img = null;
		if (art.isPoorQuality() == true){ // Artifact
			// Bad

			if (art.inspected() == true){

				if (art.isBug() == true){
					img = ComponentCard.getImageScalable(
							ScreenInteraction.imagePath
									+ "artefactBadBugged.png", 0, height);
				} else{
					img = ComponentCard.getImageScalable(
							ScreenInteraction.imagePath + "artefactBadOk.png",
							0, height);
				}

			} else{ // Artifact Bad not inspectioned
				img = ComponentCard.getImageScalable(
						ScreenInteraction.imagePath + "artefactBad.png", 0,
						height);
			}

		} else{ // Artifact God

			if (art.inspected() == true){

				if (art.isBug() == true){
					img = ComponentCard.getImageScalable(
							ScreenInteraction.imagePath
									+ "artefactGoodBugged.png", 0, height);
				} else{
					img = ComponentCard.getImageScalable(
							ScreenInteraction.imagePath + "artefactGoodOk.png",
							0, height);
				}

			} else{ // Artifact Bad not inspectioned
				img = ComponentCard.getImageScalable(
						ScreenInteraction.imagePath + "artefactGood.png", 0,
						height);

			}

		}
		return img;
	}

	// =====================================================================================//
	/**
	 * @return ActionListener responsável pelo botão usar dos engenheiros
	 * 
	 *         Controla a ação dos engenheiros
	 */
	private ActionListener getActionEnginer(){

		ActionListener actionListener = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent event){

				int mesa = Integer.parseInt(event.getActionCommand());

				cartaAtiva = jogador.getTabuleiro().getMesas()[mesa]
						.getCartaMesa();

				int back = ScreenCard.createAndShowCard(cartaAtiva,
						ScreenTabuleiro.this).getReturn();

				switch (back){
				case ScreenCard.USE:
					Object[] possibilities ={ "Produzir Artefato",
							"Inspecionar Artefato", "Corrigir Artefato" };
					String s = (String) JOptionPane.showInputDialog(
							ScreenTabuleiro.this,
							"Selecione a ação do engenheiro", "SimulES",
							JOptionPane.PLAIN_MESSAGE, null, possibilities,
							"Produzir Artefato");

					// If a string was returned, say so.
					if ((s != null) && (s.length() > 0)){

						if (s.compareToIgnoreCase("Produzir Artefato") == 0){
							jogador = GameController.getGameController()
									.produzirArtefatoI(jogo, jogador,
											(CartaEngenheiro) cartaAtiva);
						} else if (s
								.compareToIgnoreCase("Inspecionar Artefato") == 0){
							jogador = GameController.getGameController()
									.inspecionarArtefatoI(jogo, jogador,
											(CartaEngenheiro) cartaAtiva);
						} else if (s.compareToIgnoreCase("Corrigir Artefato") == 0){
							jogador = GameController.getGameController()
									.corrigirArtefatoI(jogo, jogador,
											(CartaEngenheiro) cartaAtiva);
						}

					}

					break;
				case ScreenCard.DISCARD:
					jogador = GameController.getGameController()
							.demitirEngenheiro(jogo, jogador,
									(CartaEngenheiro) cartaAtiva);
					break;
				case ScreenCard.BACK:
					// Do nothing
					break;
				}

				if (ScreenCard.BACK != back){
					panelBase.remove(panelMesas);
					panelMesas = getPanelMesas();
					if (panelMesas != null){
						panelBase.add(panelMesas, BorderLayout.CENTER);
						refresh(); // Todo [ARS] alterado para refresh ver
									// atualização
					}
				}

			}
		};

		return actionListener;
	}

	// =====================================================================================//

	/**
	 * @return ActionListener responsável por controlar a ação dos botões abaixo
	 *         das cartas no painel de cartas na posição inferior do tabuleiro.
	 */
	private ActionListener getActionButtonCard(){

		ActionListener action = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){

				if (((JButton) e.getSource()).getName().compareToIgnoreCase(
						"Descartar") == 0){

					System.out.println(((JButton) e.getSource()).getName()
							+ " " + e.getActionCommand());

					Carta[] cartas = new Carta[1];
					int numCard = Integer.parseInt(e.getActionCommand());
					cartas[0] = ScreenTabuleiro.this.jogador.getCartas()[numCard];
					jogador = GameController.getGameController()
							.descartarCartas(jogo, jogador, cartas);

				} else if (((JButton) e.getSource()).getName()
						.compareToIgnoreCase("Usar") == 0){
					System.out.println(((JButton) e.getSource()).getName()
							+ " " + e.getActionCommand());
					int numCard = Integer.parseInt(e.getActionCommand());
					Carta carta = ScreenTabuleiro.this.jogador.getCartas()[numCard];
					if (carta instanceof CartaEngenheiro){
						jogador = GameController.getGameController()
								.contratarEngenheiroI(jogo, jogador,
										(CartaEngenheiro) carta);
					} 
					//#ifdef ConceptCard
					else if (carta instanceof CartaBonificacao){
						jogador = GameController.getGameController()
								.inserirBeneficio(jogo, jogador, (CartaBonificacao) carta);
					}
					//#endif
				} else{
					System.out.println(((JButton) e.getSource()).getName()
							+ " " + e.getActionCommand() + " Não bateu");
				}
				ScreenTabuleiro.this.refresh();
			}
		};
		return action;
	}

	// =====================================================================================//

	/**
	 * @return ActionListener responsável por controlar os eventos dos botões do
	 *         painel esquerdo do tabuleiro
	 */
	private ActionListener getActionButtonPanel(){

		ActionListener action = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){

				if (e.getActionCommand().compareToIgnoreCase("Terminar Jogada") == 0){

					ScreenTabuleiro.this.setVisible(false);

				} else if (e.getActionCommand().compareToIgnoreCase(
						"Jogar Dados") == 0){

					jogador = GameController.getGameController().jogarDados(
							jogo, jogador);

					if (jogador.getCartas().length > 0){
						panelBase.remove(panelCartas);
						panelCartas = getPanelCards();
						if (panelCartas != null){
							ScreenTabuleiro.this.refresh();
						}
					}

				} else if (e.getActionCommand().compareToIgnoreCase(
						"Ver Projeto") == 0){

					GameController.getGameController().verProjeto(jogo);

				} else if (e.getActionCommand().compareToIgnoreCase(
						"Ver Tabuleiro do Oponente") == 0){

					{
						if (oponent == null){

							Jogador[] jogadores = jogo.getJogadores();
							String[] nomes = new String[jogadores.length];
							for (int i = 0; i < jogadores.length; i++){
								nomes[i] = jogadores[i].getNome();
							}

							String nome = ScreenChooseGamer
									.createAndShowGetGamers(nomes,
											jogador.getNome()).getReturn();

							for (int i = 0; i < jogadores.length; i++){
								if (nome.compareToIgnoreCase(jogadores[i]
										.getNome()) == 0){
									oponent = jogadores[i];
								}
							}

						} else{
							oponent = null;
						}
						ScreenTabuleiro.this.refresh();
					}// FIM DO TESTE VER OPONENTE

				}
				System.out.println(e.getActionCommand());
			}

		};

		return action;
	}

	// =====================================================================================//
	/**
	 * @return ActionListener responsável por controlar a chamada de integração
	 *         de módulos.
	 */
	private ActionListener getActionIntegrate(){
		ActionListener action = (new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e){
				if (jogador != null){
					int numMesa = Integer.parseInt(e.getActionCommand());
					CartaEngenheiro carta = jogador.getTabuleiro().getMesas()[numMesa]
							.getCartaMesa();
					jogador = GameController.getGameController()
							.integrarModuloI(jogo, jogador, carta, numMesa);
					// ScreenInteraction.getScreenInteraction().exibirMensagem("Mesa a integra "
					// + Integer.toString(numMesa) , "");
					ScreenTabuleiro.this.refresh();
				}
			}
		});
		return action;
	}

	// =====================================================================================//

	/**
	 * Método responsável por repintar todo o tabuleiro. O método recalcula a
	 * pisição e recria os objetos a serem pintados.
	 * 
	 * útil principalemente quando o jogador tem propriedades alteradas ou
	 * muda-se o jogador.
	 * 
	 */
	protected void refresh(){
		SwingUtilities.invokeLater(new Runnable(){
			public void run(){
				panelTabuleiro = getPanelBase();
				panelCartas.revalidate();
				panelCartas.repaint();

			}
		});
	}

	// =====================================================================================//
	// Métods get e set para jogo e jogador
	/**
	 * @return the jogador
	 */
	public Jogador getJogador(){
		return jogador;
	}

	/**
	 * @param jogador
	 *            the jogador to set
	 */
	public void setJogador(Jogador jogador){
		this.jogador = jogador;
		this.refresh();
	}

	public void setJogo(Jogo jogoAtual){
		this.jogo = jogoAtual;
	}

	// =====================================================================================//
	// =====================================================================================//
	/**
	 * Cria a tela que mostra o tabuleiro e a torna visível.
	 * 
	 * @param jogador
	 *            - Variávelque representa o jogador atual
	 * @param jogo
	 *            - Variávelque representa o jogo atual
	 * 
	 * @return ScreenTabuleiro - Retorna a janela de diálogo com as informações
	 *         do jogador.
	 * 
	 *         Para obter o valor de retorno pode-se utilizar a janela com a
	 *         chamada:
	 * 
	 *         createAndShowCard(jogador, jogo);
	 * 
	 *         O tabuleiro não retorna nada ao método chamador, porem pode fazer
	 *         várias chamadas diferentes ao motor do jogo e somente retorna o
	 *         controle ao selecionada a opção de terminar jogada, ou ao fechar
	 *         a janela do jogo, fato que termina o programa.
	 * 
	 */
	public static ScreenTabuleiro createAndShowTabuleiro(Jogador jogador,
			Jogo jogo){
		// Cria e configura a tela.
		ScreenTabuleiro scr = new ScreenTabuleiro(jogador, jogo);
		scr.rootPane.setOpaque(true);
		scr.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		scr.setSize(1024, 768);
		scr.pack();
		scr.setModal(true);
		scr.addWindowListener(ScreenInteraction.getScreenInteraction().windowsExitGame());
		return scr;
	}

	/****************************************************************************/
	/**************************** TEST FUNCTION *********************************/
	/****************************************************************************/
	public static void main(String[] args){
		// O uso da Thread com a utilização de invokeLater tem a
		// função da construção total da GUI para somente então
		// apresentá-la na tela.
		final Jogador jogador = new Jogador("Jose", 300);
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				ScreenTabuleiro tab = createAndShowTabuleiro(jogador, null);
				tab.setVisible(true);
			}
		});
	}

}
// =====================================================================================//
// Fim da classe ScreenTabuleiro
// =====================================================================================//

