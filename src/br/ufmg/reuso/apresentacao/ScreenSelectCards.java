/*
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * Simules-SPL Project
 *
 * Created by Alisson
 * Date: 18/07/2011
 */
package br.ufmg.reuso.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//=====================================================================================//
//=============================Início da classe ScreenSelectCards======================//
//=====================================================================================//

/**
 * @author Alisson [AS] A classe representa a caixa de diálogo que fornecerá os
 *         tipos de cartas selecionadas.
 * 
 *         Pode ser utilizado como:
 * 
 *         int [] Retorno = createAndShowSelectCards().getReturn() ;
 * 
 *         Ou instanciando a classe ScreenSelectCards como uma janela de
 *         diálogo.
 * 
 *         Retorno TODAS = 0; CODIGO = 1; COMUNICACAO = 2; DESENHO = 3; GERENCIA
 *         = 4; RH = 5; REQUISITOS = 6;
 * 
 */
public class ScreenSelectCards extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;

	Vector<String> names;

	private int[] intReturn;

	private JButton buttonOK;

	private Dimension mySize = new Dimension(300, 400);

	ArrayList<JCheckBox> options = new ArrayList<JCheckBox>();

	@SuppressWarnings("unused")
	private static int TODAS = 0;
	@SuppressWarnings("unused")
	private static int CODIGO = 1;
	@SuppressWarnings("unused")
	private static int COMUNICACAO = 2;
	@SuppressWarnings("unused")
	private static int DESENHO = 3;
	@SuppressWarnings("unused")
	private static int GERENCIA = 4;
	@SuppressWarnings("unused")
	private static int RH = 5;
	@SuppressWarnings("unused")
	private static int REQUISITOS = 6;

	private String title;

	// =====================================================================================//
	/**
	 * Construtor da janela de seleção de modo
	 */
	/**
	 * @param tabuleiro
	 *            - tabuleiro do jogo atual
	 */
	public ScreenSelectCards(String title){
		super();
		names = new Vector<String>(Arrays.asList(new String[]{ "Códigos",
				"Comunicação", "Desenhos", "Gerência", "Recursos Humanos",
				"Requisitos" }));
		this.title = title;

		setLayout(new BorderLayout());
		add(getPanelInfo(), BorderLayout.NORTH);
		add(getPanelOptions(), BorderLayout.CENTER);
		add(getPanelBase(), BorderLayout.SOUTH);
		mySize.height = 100 + (names.size() / 2) * 40;
		this.setPreferredSize(mySize);

	}

	/**
	 * Painel com as informações da parte superior da tela
	 * 
	 * @return JPanel - painel com as informações da parte superio da tela
	 */
	JPanel getPanelInfo(){

		String message = title;
		JPanel panel = new JPanel();
		// panel.setPreferredSize(new Dimension(mySize.width, 30));
		JLabel label = new JLabel(message, JLabel.CENTER);
		label.setPreferredSize(new Dimension(mySize.width, 30));
		label.setFont(new Font("Default", Font.BOLD, 14));
		panel.add(label);
		return panel;

	}

	private JPanel getPanelOptions(){

		JPanel panel = new JPanel();

		Iterator<String> it = names.iterator();

		JCheckBox option = null;
		String item = null;
		Dimension dimension = new Dimension((mySize.width / 2) - mySize.width
				* 10 / 100, 30);
		while (it.hasNext()){
			item = it.next();
			option = new JCheckBox(item);
			option.setSelected(true);
			option.addItemListener(getItemListener());
			option.setPreferredSize(dimension);
			options.add(option);
			panel.add(option);
		}
		return panel;
	}

	private ItemListener getItemListener(){
		ItemListener listener = new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e){

			}
		};
		return listener;
	}

	// =====================================================================================//

	/**
	 * Painel com os resultados da seleção do usuário mais o botão de ok.
	 * 
	 * @return JPanel - com os resultados da seleção do usuário mais o botão de
	 *         ok
	 */
	JPanel getPanelBase(){

		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));

		panel.add(Box
				.createRigidArea(new Dimension(mySize.width * 70 / 100, 30)));

		buttonOK = new JButton("OK");
		buttonOK.addActionListener(this);
		buttonOK.setPreferredSize(new Dimension(mySize.width * 20 / 100, 30));
		panel.add(buttonOK);

		return panel;
	}

	// =====================================================================================//

	/** Controlador de eventos dos botões. */
	@Override
	public void actionPerformed(ActionEvent e){

		if (e.getActionCommand() == "OK"){
			ComputeReturn();
			ScreenSelectCards.this.dispose();
		}
	}

	private void ComputeReturn(){

		Iterator<JCheckBox> it = options.iterator();

		int i = 0;
		while (it.hasNext()){
			if (it.next().isSelected())
				i++;
		}

		int[] out = null;
		if (i == names.size()){
			out = new int[1];
			out[0] = 0;
		} else{
			out = new int[i];
			i = 0;
			for (int j = 0; j < options.size(); j++){
				if (options.get(j).isSelected()){
					out[i] = j;
					i++;
				}
			}
		}

		intReturn = out;
	}

	// =====================================================================================//
	/**
	 * Retorna o modo do jogo selecionado na tela
	 * 
	 * @return - Inteiro contendo a escolha do jogador.
	 * 
	 *         Retorna: TODAS = 0; CODIGO = 1; COMUNICACAO = 2; DESENHO = 3;
	 *         GERENCIA = 4; RH = 5; REQUISITOS = 6;
	 * 
	 */
	public int[] getReturn(){
		return intReturn;
	}

	// =====================================================================================//
	/**
	 * Cria a tela e a faz visível. Por segurança é o método chamado pela Thread
	 * para construção da GUI
	 * 
	 * @param tabuleiro
	 *            - Tabeuleiro atual do jogo
	 */
	public static ScreenSelectCards createAndShowSelectCards(String title){
		// Cria e configura a tela.
		ScreenSelectCards scr = new ScreenSelectCards(title);
		scr.rootPane.setOpaque(true);
		scr.pack();
		scr.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		scr.addWindowListener(ScreenInteraction.getScreenInteraction()
				.windowsExitGame());
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
				int[] out = (createAndShowSelectCards("Selecione os tipos de carta problema")
						.getReturn());

				for (int i = 0; i < out.length; i++){
					System.out.print(out[i]);
				}
			}

		});
	}

}// Fim da classe

// =====================================================================================//
// ===================================Fim da classe
// ScreenModo==========================//
// =====================================================================================//

