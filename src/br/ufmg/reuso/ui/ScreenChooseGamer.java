/*
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * Simules-SPL Project
 *
 * Created by Alisson
 * Date: 25/07/2011
 */
package br.ufmg.reuso.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//=====================================================================================//
//============================Inicio da classe ScreenChooseGamer===================//
//=====================================================================================//
/**
 * @author Alisson [AS] Caixa de diálogo para apresentação dos nomes dos
 *         jogadores para seleção.
 * 
 *         A classe recebe um vetor de strings com os nomes dos jogadores já
 *         ordenados e retorna o nome selecionado ou "" (string vazia) caso seja
 *         cancelado ou a tela seja fechada.
 * 
 *         A chamada pode ser feita conforme o exemplo abaixo:
 * 
 *         string Retorno = createAndShowChooseGamer(String []
 *         nomeJogadores).getReturn();
 * 
 *         Ou instanciando a classe ScreenGamers como uma janela de diálogo.
 * 
 */
public class ScreenChooseGamer extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;

	// String com o jogador selecionado.
	private String gamerReturn;
	
	
	// =====================================================================================//
	/**
	 * Construtor da janela para seleção dos nomes dos jogadores
	 * 
	 * @param nomeJogadores
	 *            - Vetor de string com o nome dos jogadores
	 * @param jogadorAtual - Será retirado da lista de escolha
	 */
	public ScreenChooseGamer(String[] nomeJogadores, String jogadorAtual){
		super();
		
		gamerReturn = "";

		setLayout(new BorderLayout());

		JPanel panel = new JPanel();

		GridLayout grid = new GridLayout(7, 1, 5, 10);

		Dimension dim = new Dimension(150, 30);

		panel.setLayout(grid);

		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 10));

		JLabel lblText = new JLabel("Selecione um jogador:", JLabel.CENTER);

		panel.add(lblText);

		int i;
		JButton btnJogador = null;
		for (i = 0; i < nomeJogadores.length; i++){
			
				btnJogador = new JButton(nomeJogadores[i]);
				btnJogador.addActionListener(this);
				if (jogadorAtual.compareToIgnoreCase(nomeJogadores[i])==0){				
					btnJogador.setEnabled(false);
				}

				btnJogador.setPreferredSize(dim);
				panel.add(btnJogador);
		}

		add(panel, BorderLayout.CENTER);

		JButton buttonCancel = new JButton("Cancelar");
		buttonCancel.setActionCommand("");
		buttonCancel.addActionListener(this);
		buttonCancel.setPreferredSize(new Dimension(100, dim.height));
		BorderLayout bdr = new BorderLayout();
		JPanel panel2 = new JPanel(bdr);
		panel2.add(new JLabel(""), BorderLayout.CENTER);
		panel2.add(buttonCancel, BorderLayout.AFTER_LINE_ENDS);
		panel2.setBorder(BorderFactory.createEmptyBorder(0, 0, 10, 10));
		add(panel2, BorderLayout.AFTER_LAST_LINE);

		setPreferredSize(new Dimension(400, 350));
		pack();
	}

	// =====================================================================================//
	/**
	 * Controlador de eventos dos botões.
	 * 
	 * */
	@Override
	public void actionPerformed(ActionEvent e){
		gamerReturn = e.getActionCommand();
		ScreenChooseGamer.this.dispose();
	}

	// =====================================================================================//
	/**
	 * Retorna o nome do jogador selecionado ou "" caso nenhuma tenha sido
	 * escolhido
	 * 
	 * @return Sting como nome do jogador selecionado.
	 * 
	 */
	String getReturn(){
		return gamerReturn;
	}

	// =====================================================================================//
	/**
	 * Cria a tela e a faz visível. Por segurança é o método chamado pela Thread
	 * para construção da GUI
	 * @param jogadorAtual nome do jogador atual - será retirado da lista.
	 */
	public static ScreenChooseGamer createAndShowGetGamers(
			String[] nomeJogadores, String jogadorAtual){

		// Cria e configura a tela.
		ScreenChooseGamer scr = new ScreenChooseGamer(nomeJogadores, jogadorAtual);
		scr.rootPane.setOpaque(true);
		scr.pack();
		scr.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		scr.addWindowListener(ScreenInteraction.getScreenInteraction().windowsExitGame());		
		scr.setModal(true);
		scr.setLocationRelativeTo(null);
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
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				String retorno = (createAndShowGetGamers(new String[]{
						"Alisson", "Rodrigo", "Michel", "Eduardo", "Rafael",
						"Stephanie" }, "Rodrigo").getReturn());

				System.out.println(retorno);
			}
		});

	}

}// Fim da classe
// =====================================================================================//
// ==============================Fim da classe
// ScreenChooseGamer=====================//
// =====================================================================================//
