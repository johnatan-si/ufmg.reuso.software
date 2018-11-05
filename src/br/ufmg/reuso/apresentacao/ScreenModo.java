package br.ufmg.reuso.apresentacao;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import br.ufmg.reuso.negocio.tabuleiro.SetupInteraction;

/*
 * ScreenModo.java requer os seguintes arquivos:
 *   DepositScreen/Fácil.png
 *   DepositScreen/Médio.png
 *   DepositScreen/Difícil.png
 */


/**
 * A classe representa a caixa de diálogo que fornecerá o modo de jogo.
 * Contém o tipo de janela a ser utilizado para caixas de diálogo.
 * Fornece o modo do jogo a partir da chamada de getModeGame.
 * Pode ser utilizado como:
 * 
 * String Retorno = createAndShowGetModo().getModeGame() ;
 * 
 * Ou instanciando a classe ScreenModo como uma janela de diálogo.  
 *  
 */
public class ScreenModo extends JDialog implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	static String easyString = "Fácil";
	static String moderateString = "Médio";
	static String hardString = "Difícil";

	private JLabel picture;

	private int intReturn;
	
	//=====================================================================================//	
	/**
	 * Construtor da janela de seleção de modo
	 */
	/**
	 * @param tabuleiro - tabuleiro do jogo atual
	 */
	public ScreenModo(ScreenTabuleiro tabuleiro){
		super(tabuleiro);		
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(300,200));
		
		JPanel panel = new JPanel(new BorderLayout());
		//Cria os botões de rádio.
		JRadioButton easyButton = new JRadioButton(easyString);
		easyButton.setMnemonic(KeyEvent.VK_F);
		easyButton.setActionCommand(easyString);
		
		JRadioButton moderateButton = new JRadioButton(moderateString);
		moderateButton.setMnemonic(KeyEvent.VK_M);
		moderateButton.setActionCommand(moderateString);

		JRadioButton hardButton = new JRadioButton(hardString);
		hardButton.setMnemonic(KeyEvent.VK_D);
		hardButton.setActionCommand(hardString);
		
		hardButton.setSelected(true);
		intReturn = SetupInteraction.HARD;

		//Cria o grupo de botões de rádio.
		ButtonGroup group = new ButtonGroup();
		group.add(easyButton);
		group.add(moderateButton);
		group.add(hardButton);

		//Registra os objetos no controle de eventos.
		easyButton.addActionListener(this);
		moderateButton.addActionListener(this);
		hardButton.addActionListener(this);

		//Configura a imagem.
		picture = new JLabel(createImageIcon("DepositScreen/"
				+ hardString
				+ ".png"));
		
		picture.setPreferredSize(new Dimension(85, 85));

		//Coloca os botões de rádio em uma coluna no painel.
		JPanel radioPanel = new JPanel(new GridLayout(0, 1));
		radioPanel.add(easyButton);
		radioPanel.add(moderateButton);
		radioPanel.add(hardButton);

		//Button OK
		JButton buttonOk = new JButton("OK");
		buttonOk.addActionListener(this);
		buttonOk.setPreferredSize(new Dimension(50,30));
		buttonOk.setMaximumSize(new Dimension(50,30));


		panel.add(radioPanel, BorderLayout.LINE_START);
		panel.add(picture, BorderLayout.CENTER);
				
		panel.add(buttonOk, BorderLayout.PAGE_END);
		
		getRootPane().setDefaultButton(buttonOk);		
		
		panel.setBorder(BorderFactory.createEmptyBorder(25, 40, 25, 40));
		
		this.add(panel,BorderLayout.CENTER);
		
	}	
	//=====================================================================================//
	/** Controlador de eventos dos botões. */
	@Override
	public void actionPerformed(ActionEvent e){

		
		if (e.getActionCommand()== "OK" ){
			ScreenModo.this.dispose();
		}
		else{		
		
		picture.setIcon(createImageIcon("DepositScreen/"
				+ e.getActionCommand()
				+ ".png"));
		if ( e.getActionCommand().equalsIgnoreCase(easyString)  ){
			intReturn = SetupInteraction.EASY;	
		}
		else if(e.getActionCommand().equalsIgnoreCase(moderateString)){
			intReturn = SetupInteraction.MODERATE;
		}
		else if(e.getActionCommand().equalsIgnoreCase(hardString) ){
			intReturn = SetupInteraction.HARD;
			
		}
		
		}	
	}
	
	//=====================================================================================//
	/**
	 * Retorna o modo do jogo selecionado na tela 
	 * 
	 * 	@return - Inteiro contendo a escolha do jogador. 
	 * 
	 * 	intReturn = UserInteraction.EASY
	 *	intReturn = UserInteraction.MODERATE;	
	 *	intReturn = UserInteraction.HARD;
	 *	  
	 */
	public int getModeGame(){	    	
		return intReturn;
	}
	
	//=====================================================================================//
	/** 
	 * Retorna um ImageIcon ou null se o caminho for inválido. 
	 * @param path - String com o caminho da imagem
	 * @return - ImageIcon para ser inserida em um JLabel.
	 * 
	 */
	protected static ImageIcon createImageIcon(String path){
		File fl = new File(path);
		if (fl.isFile()){
			return new ImageIcon(path);
		} else{
//			System.err.println("Couldn't find file: " + path);
			return null;
		}
	}

	//=====================================================================================//
	/**
	 * Cria a tela e a faz visível. Por segurança é o método chamado pela Thread para construção
	 * da GUI
	 * 
	 * @param tabuleiro  - Tabeuleiro atual do jogo
	 */
	public static ScreenModo createAndShowGetModo(ScreenTabuleiro tabuleiro){
		//Cria e configura a tela.		
		ScreenModo scr = new ScreenModo(tabuleiro);		
		scr.rootPane.setOpaque(true);
		scr.pack();
		scr.setTitle("Dificuldade");
		scr.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		scr.addWindowListener(ScreenInteraction.getScreenInteraction().windowsExitGame());
		scr.setModal(true);
		scr.setLocationRelativeTo(null);
		scr.setVisible(true);

		return scr;
	}

	public static void main(String[] args){
		//O uso da Thread com a utilização de invokeLater tem a 
		//função da construção total da GUI para somente então
		//apresentá-la na tela.		
		final ScreenTabuleiro tabuleiro = ScreenTabuleiro.createAndShowTabuleiro(null, null);
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				System.out.println (createAndShowGetModo(tabuleiro).getModeGame());
			}
		});		
	}


}