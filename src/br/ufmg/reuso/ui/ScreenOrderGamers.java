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
import java.awt.Color;
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
//============================Inicio da classe ScreenOrderGamers=======================//
//=====================================================================================//

/**
 * @author Alisson [AS] Caixa de diálogo para apresentação dos nomes dos jogadores na ordem das jogadas.
 * 
 *	A classe recebe um vetor de strings com os nomes dos jogadores já ordenados e retorna sempre true.
 * 
 *  A chamada pode ser feita conforme o exemplo abaixo: boolean Retorno = createAndShowOrderGamers(String [] nomeJogadores).getReturn();
 * 
 *	Ou instanciando a classe ScreenGamers como uma janela de diálogo.
 * 
 */
public class ScreenOrderGamers extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;

	/**
	 * Construtor da janela de apresentação dos nomes dos jogadores na ordem do jogo
	 *
	 * @param tabuleiro - Tabuleiro do jogo atual
	 * @param nomeJogadores  - String com o nome dos jogadores na ordem das jogadas.
	 */
	public ScreenOrderGamers(ScreenTabuleiro tabuleiro, String[] nomeJogadores){
		super(tabuleiro);
				
		setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		
		GridLayout grid = new GridLayout(7,1, 5, 10);		
		
		panel.setLayout(grid);
		
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 0,10));
		
		Dimension dim = new Dimension(150,30);
		
		JLabel lblText = new JLabel("Ordem dos jogadores:", JLabel.CENTER);
		lblText.setPreferredSize(dim);
		panel.add(lblText);
		setPreferredSize( new Dimension(dim.width*2, dim.height * 12));
		
		int i;
		JLabel lblJogador = null;
		for(i = 0 ; i < nomeJogadores.length; i++){
			lblJogador = new JLabel(Integer.toString(i+1)+ " - " + nomeJogadores[i], JLabel.CENTER);
			lblJogador.setPreferredSize(dim);
			lblJogador.setBorder(BorderFactory.createLineBorder(Color.white));
			panel.add(lblJogador);
		}
		
		while(i <= 5){
			lblJogador = new JLabel("     "+ Integer.toString(i+1)+ " - " , JLabel.LEFT);
			lblJogador.setPreferredSize(dim);
			lblJogador.setBorder(BorderFactory.createLineBorder(Color.white));
			panel.add(lblJogador);	
			i++;
		}
		
		
		add(panel,BorderLayout.CENTER);
		
		JButton buttonOk = new JButton("OK");
		buttonOk.addActionListener(this);		
		BorderLayout bdr = new BorderLayout();		
		JPanel panel2 = new JPanel(bdr);
		panel2.add(new JLabel(""),BorderLayout.CENTER);
		panel2.add(buttonOk,BorderLayout.AFTER_LINE_ENDS);
		getRootPane().setDefaultButton(buttonOk);		
		panel2.setBorder(BorderFactory.createEmptyBorder(0, 0, 10,20));
		add(panel2,BorderLayout.AFTER_LAST_LINE);			

		pack();
	}
	//=====================================================================================//


	/**
	 * Controlador de eventos dos botões
	 * 
	 * */
	@Override
	public void actionPerformed(ActionEvent e){
		ScreenOrderGamers.this.dispose();
	}
	//=====================================================================================//
	/**
	 * Retorna sempre true, pois a tela foi mostrada.
	 */
	public boolean getReturn(){
		return true;
	}

	//=====================================================================================//
	/**
	 * Cria a tela e a faz visível. 
	 * 
	 * @param tabuleiro - tabuleiro atual do jogo. 
	 */
	public static ScreenOrderGamers createAndShowGetGamers(
			ScreenTabuleiro tabuleiro, String[] nomeJogadores){

		// Cria e configura a tela.
		ScreenOrderGamers scr = new ScreenOrderGamers(tabuleiro, nomeJogadores);
		scr.rootPane.setOpaque(true);
		scr.pack();		
		scr.setModal(true);
		scr.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		scr.addWindowListener(ScreenInteraction.getScreenInteraction().windowsExitGame());
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
		final ScreenTabuleiro tabuleiro = ScreenTabuleiro.createAndShowTabuleiro(null, null);
		javax.swing.SwingUtilities.invokeLater(new Runnable(){
			@Override
			public void run(){
				boolean retorno = (createAndShowGetGamers(tabuleiro, new String[]{
						"Alisson","Eduardo" , "Rafael","Stephanie"  }).getReturn());

				System.out.println(retorno);
			}
		});

	}

}// Fim da classe

//=====================================================================================//
//============================Inicio da classe ScreenOrderGamers=======================//
//=====================================================================================//

