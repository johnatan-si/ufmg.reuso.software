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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

//=====================================================================================//
//===============================Inicio da classe ScreenGamers=========================//
//=====================================================================================//

/**
 * @author Alisson [AS] 
 * 
 * Caixa de diálogo para inserção dos nomes dos jogadores.
 * 
 * Caso seja fechada sem nenhum nome será retornado os nomes Jogador1 e Jogador2
 * 
 * A chamada pode ser feita conforme o exemplo abaixo:
 * 
 * Vector <String>Retorno = createAndShowGetGamers().getReturn();
 * 
 * Ou instanciando a classe ScreenGamers como uma janela de diálogo.
 * 
 */
public class ScreenGamers extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private Vector<String> jogadores;
	Vector<JTextField> textJogadores;
	
	//Vetor de retorno com os nomes dos jogadores
	private Vector<String> vectorReturn;

	//=====================================================================================//

	/**
	 * Construtor da janela inserção dos nomes dos jogadores
	 * @param tabuleiro - tabueleiro do jogo atual 
	 */
	public ScreenGamers(ScreenTabuleiro tabuleiro){
		super(tabuleiro);

		this.setLocationRelativeTo(tabuleiro);
		this.setLayout(new BorderLayout());

		jogadores = new Vector<String>((Arrays.asList("Jogador1", "Jogador2",
				"Jogador3", "Jogador4", "Jogador5", "Jogador6")));
		textJogadores = new Vector<JTextField>();

		JPanel panel = new JPanel();
		panel.setLayout(null);

		panel.setPreferredSize(new Dimension(340, 200));

		Dimension dim = new Dimension(100, 30);
		JLabel label;
		JTextField text;

		for (int i = 0; i < jogadores.size(); i++){

			label = new JLabel(jogadores.elementAt(i));
			label.setBounds(10, i * dim.height + 10, dim.width, dim.height);
			label.setHorizontalAlignment(SwingConstants.RIGHT);
			panel.add(label);

			text = new JTextField();
			text.setBounds(dim.width + 30, i * dim.height + 10, dim.width,
					dim.height);
			text.addActionListener(this);
			text.setActionCommand(Integer.toString(i));
			textJogadores.add(text);
			panel.add(text);

		}

		JButton buttonOk = new JButton("OK");
		buttonOk.addActionListener(this);
		buttonOk.setBounds(250, 5 * 30 + 10, 80, 25);
		panel.add(buttonOk);
			
		add(panel, BorderLayout.CENTER);
				
		getRootPane().setDefaultButton(buttonOk);
		
		setResizable(false);

	}
	//=====================================================================================//

	/**
	 * Controlador de eventos dos botões. Verifica se os nomes foram inseridos e
	 * coloca-os no vetor de saída,
	 * */
	@Override
	public void actionPerformed(ActionEvent e){

		if (e.getActionCommand() == "OK"){
			getReturn();
			ScreenGamers.this.dispose();
		}
	}
	//=====================================================================================//

	/**
	 * Retorna os nomes dos jogadores. Verifica se os nomes foram inseridos e
	 * coloca-os no vetor de saída, caso contrário insere dois jogadores com
	 * nomes padrão Jogador1 e Jogador2.
	 */
	public String [] getReturn(){

		jogadores.clear();
		for (int i = 0; i < textJogadores.size(); i++){
			if (textJogadores.get(i).getText().compareTo("") != 0){
				jogadores.add(textJogadores.get(i).getText());
			}
		}

		if (jogadores.size() == 0){
			jogadores.add("Jogador1");
			jogadores.add("Jogador2");
		}else if(jogadores.size() == 1){
			jogadores.add("Jogador2");
		}

		vectorReturn = jogadores;
		ScreenGamers.this.dispose();
		String [] retorno = new String[vectorReturn.size()];
		
		for (int i = 0; i < vectorReturn.size(); i++){
			retorno[i] = new String (vectorReturn.get(i));
		}
		

		return retorno;
	}

	//=====================================================================================//
	/**
	 * Cria a tela e a faz visível. Por segurança é o método chamado pela Thread
	 * para construção da GUI
	 * @param tabuleiro - tabueliro do jogo atual
	 */
	public static ScreenGamers createAndShowGetGamers(ScreenTabuleiro tabuleiro){

		// Cria e configura a tela.
		ScreenGamers scr = new ScreenGamers(tabuleiro);
		scr.rootPane.setOpaque(true);		
		scr.pack();
		scr.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		scr.addWindowListener(ScreenInteraction.getScreenInteraction().windowsExitGame());
		scr.setModal(true);
		scr.setLocationRelativeTo(null);
		scr.setVisible(true);

		return scr;
	}

	//=====================================================================================//
	
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
				String[] retorno = (createAndShowGetGamers(tabuleiro).getReturn());
				System.out.println("Nummero de jogadores: " + retorno.length);
			}
		});
	
	}

}//Fim da classe

//=====================================================================================//
//==================================FIM da classe ScreenGamers=========================//
//=====================================================================================//

