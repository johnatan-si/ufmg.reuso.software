/*
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * Simules-SPL Project
 *
 * Created by Alisson
 * Date: 18/07/2011
 */
package br.ufmg.reuso.apresentacao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//=====================================================================================//
//==============================Início da classe ScreenResultDice======================//
//=====================================================================================//
/**
 * @author Alisson [AS] A caixa de diálogo que apresenta o total de pontos
 *         obtidos pelo jogador ao jogar os dados.
 * 
 *         Recebe um inteiro que representa o valor dos dados.
 * 
 *         Retorna sempre true, caso seja pressionado ok ou fechada a janela.
 * 
 *         boolean Retorno = createAndShowResultDice().getReturn() ;
 * 
 *         Ou instanciando a classe ScreenResultDice como uma janela de diálogo.
 * 
 */
public class ScreenResultDice extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;

	/**
	 * Construtor da janela apresentação do resultado dos dados
	 * 
	 * @param tabuleiro
	 *            - tabuleiro atual (para efeito de centralização).
	 * 
	 * @param tabuleiro
	 *            resultDices - inteiro com o resultado dos dados.
	 * 
	 */
	public ScreenResultDice(ScreenTabuleiro tabuleiro, int resultDices){
		super(tabuleiro);

		this.setLayout(new BorderLayout());

		JPanel Tpanel = new JPanel();
		Tpanel.setLayout(null);

		Dimension dimensionPanel = new Dimension(300, 200);
		Tpanel.setPreferredSize(dimensionPanel);

		Dimension dimensionButton = new Dimension(120, 30);

		// Calcula a posição inicial e final dos botões na tela
		// de modo a deixá-los centralizados.

		int posX = (dimensionPanel.width / 2) - (dimensionButton.width / 2);
		int posY = (dimensionPanel.height / 10);

		// Rótulo de mensagem
		JLabel labelMensege = new JLabel("Pontos obtidos:", JLabel.CENTER);
		labelMensege.setPreferredSize(dimensionButton);
		posY = 2 * (dimensionPanel.height / 10) - (dimensionButton.height);
		labelMensege.setBounds(posX, posY, dimensionButton.width,
				dimensionButton.height);
		Tpanel.add(labelMensege);

		// Rótulo com Resultado
		JLabel LabelInfo = new JLabel(Integer.toString(resultDices),// + "!",
				JLabel.CENTER);
		Font font = new Font("Default", Font.BOLD, 120);
		LabelInfo.setFont(font);
		LabelInfo.setForeground(Color.red);
		LabelInfo.setPreferredSize(dimensionButton);
		posY = 8 * (dimensionPanel.height / 10) - (dimensionButton.height * 4);
		LabelInfo.setBounds(5, posY, dimensionPanel.width - 10,
				dimensionButton.height * 4);
		Tpanel.add(LabelInfo);

		// Botão de lançar os dados
		JButton buttonLaunch = new JButton("Ok");
		buttonLaunch.setMnemonic(KeyEvent.VK_O);
		buttonLaunch.setActionCommand("OK");
		buttonLaunch.setPreferredSize(dimensionButton);
		posY = (9 * (dimensionPanel.height / 10)) - (dimensionButton.height);

		posX = dimensionPanel.width - 10 - dimensionButton.width / 2;
		buttonLaunch.setBounds(posX, posY, dimensionButton.width / 2,
				dimensionButton.height);
		buttonLaunch.addActionListener(this);
		Tpanel.add(buttonLaunch);
		getRootPane().setDefaultButton(buttonLaunch);

		add(Tpanel);

		setResizable(false);

	}

	// =====================================================================================//
	/** Controlador de eventos dos botões. */
	@Override
	public void actionPerformed(ActionEvent e){
		ScreenResultDice.this.dispose();
	}

	// =====================================================================================//
	/**
	 * Retorna true se o jogador pressionou jogar dado ou false se o jogador
	 * fechou a janela.
	 */
	public boolean getReturn(){
		return true;
	}

	// =====================================================================================//
	/**
	 * Cria a tela e a faz visível. Por segurança é o método chamado pela Thread
	 * para construção da GUI Recebe um string com o nome do jogador e retorna a
	 * caixa de dialogo.
	 * 
	 * @param tabuleiro
	 *            - tabuleiro atual
	 * @param resultDices
	 *            - inteiro com o resultado dos dados.
	 */
	public static ScreenResultDice createAndShowResultDice(
			ScreenTabuleiro tabuleiro, int resultDices){

		// Cria e configura a tela.
		ScreenResultDice scr = new ScreenResultDice(tabuleiro, resultDices);
		scr.rootPane.setOpaque(true);
		scr.pack();	
		scr.setModal(true);
		scr.setLocationRelativeTo(null);
		scr.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		scr.addWindowListener(ScreenInteraction.getScreenInteraction().windowsExitGame());
		scr.setVisible(true);

		return scr;
	}

	/****************************************************************************/
	/**************************** TEST FUNCTION *********************************/
	/****************************************************************************/
	public static void main(String[] args){
		// O uso da Thread com a utilização de invokeLater tem a
		// função da construção total da GUI para somente então
		// apresentá-la na tela.
		final ScreenTabuleiro tabuleiro = ScreenTabuleiro
				.createAndShowTabuleiro(null, null);
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				System.out.println(createAndShowResultDice(tabuleiro, 12)
						.getReturn());
			}
		});
	}

}// Fim da classe

// =====================================================================================//
// ================================Fim da classe// ScreenResultDice=====================//
// =====================================================================================//