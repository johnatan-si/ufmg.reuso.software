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

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import br.ufmg.reuso.negocio.carta.CartaoProjeto;
import br.ufmg.reuso.negocio.jogo.Jogo;

//=====================================================================================//
//=================================Inicio da classe ScreenProject======================//
//=====================================================================================//

/**
 * @author Alisson Rodrigo [AS]
 * 
 *         Classe responsável por pintar o projeto atual
 * 
 *         Pode ser executado por
 * 
 *         createAndShowProject(new CartaoProjeto(Jogo.DIFICIL));
 * 
 *         Não retorna nada.
 * 
 */
public class ScreenProject extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;

	boolean projectReturn = true;

	JPanel panelButtonsLeft;

	JPanel panelButtonsRight;

	JPanel panelMesas;

	JPanel panelCartas;

	JPanel panelProject;

	Border border = BorderFactory.createLineBorder(Color.black, 1);

	Dimension dim = new Dimension(800, 600);

	CartaoProjeto projeto;
	private String code;
	private String title;
	private String reference;
	private String text;
	private String[] modules;
	private String[] data;

	// =====================================================================================//
	/**
	 * Responsável por criar a JDiálogo que mostra o projeto.
	 * 
	 * @param tabuleiro
	 *            - Tabueliro atual
	 * @param projeto
	 *            - Projeto a ser mostrado.
	 * 
	 *            A construtora recebe e o projeto e apresenta suas informações
	 *            e não retorna nada
	 * 
	 */
	public ScreenProject(ScreenTabuleiro tabuleiro, CartaoProjeto projeto){

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

		this.projeto = projeto;
		initiVars();
		panelProject = getPanelProject();
		this.setContentPane(panelProject);

	}

	// =====================================================================================//
	/**
	 * Define o painel principal da janela de diálogo
	 * 
	 * @return JPanel com o projeto pintado.
	 * 
	 */
	private JPanel getPanelProject(){

		JPanel panel = new JPanel();

		Font font = new Font("Default", Font.PLAIN, 24);

		panel.setLayout(null);

		int y;

		JLabel lblProject = new JLabel("Projeto");
		lblProject.setBounds(10, y = 10, 100, 30);
		lblProject.setFont(font);
		panel.add(lblProject);

		JLabel lblCode = new JLabel(code);
		lblCode.setBounds(dim.width - 60, y, 50, 30);
		lblCode.setBorder(border);
		lblCode.setFont(font);
		panel.add(lblCode);

		JLabel lblTitle = new JLabel(title, JLabel.CENTER);
		lblTitle.setBounds(10, y += 40, dim.width - 20, 30);
		lblTitle.setBorder(border);
		lblTitle.setFont(font);
		panel.add(lblTitle);

		JPanel aux = new JPanel(new BorderLayout());
		aux.setBorder(border);
		aux.setBackground(Color.PINK);
		aux.setBounds(10, y += 40, dim.width - 20, 220);
		aux.setPreferredSize(new Dimension(dim.width - 7, 50));
		JTextArea textArea = new JTextArea(text);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setBorder(BorderFactory.createEmptyBorder(5, 15, 5, 5));
		textArea.setFont(new Font("Serif", Font.PLAIN, 24));
		textArea.setAlignmentX(CENTER_ALIGNMENT);

		JScrollPane paneScrollPane = new JScrollPane(textArea);
		paneScrollPane
				.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		textArea.setFont(font);
		textArea.setEditable(false);
		aux.add(textArea, BorderLayout.CENTER);
		panel.add(aux);

		JLabel lblRef = new JLabel(reference, JLabel.CENTER);
		lblRef.setBounds(10, y += 220, dim.width - 20, 30);
		lblRef.setBorder(border);
		lblRef.setFont(font);
		panel.add(lblRef);

		y = y + 40;

		Font font16 = new Font("Default", Font.PLAIN, 16);
		JList listModules = new JList(modules);
		listModules.setBounds(410, y, 380, 180);
		listModules.setBorder(BorderFactory.createTitledBorder(border,
				"Módulos", TitledBorder.LEFT, TitledBorder.ABOVE_TOP, font16));
		listModules.setFont(font16);
		panel.add(listModules);

		String nomes[] = new String[]{ "Complexidade", "Tamanho", "Qualidade",
				"Orcamento" };
		JLabel lblData;

		int i;
		for (i = 0; i < nomes.length; i++){
			lblData = new JLabel(nomes[i], JLabel.RIGHT);
			lblData.setBounds(10, y + i * 30, 280, 30);
			lblData.setFont(font);
			panel.add(lblData);

			lblData = new JLabel(data[i], JLabel.CENTER);
			lblData.setBounds(300, y + i * 30, 80, 30);
			lblData.setBorder(border);
			lblData.setFont(font);
			panel.add(lblData);

			y = y + 20;
		}

		y = y + i * 30;

		JButton btnOk = new JButton("OK");
		btnOk.setBounds(dim.width - 90, y - 15, 80, 30);

		// btnOk.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
		btnOk.setFont(font);
		btnOk.addActionListener(this);
		panel.add(btnOk);
		getRootPane().setDefaultButton(btnOk);

		return panel;
	}

	// =====================================================================================//
	/**
	 * Função inicializa as variáveis do projeto para serem inicializadas.
	 * 
	 */
	void initiVars(){

		if (projeto == null){

			code = "";
			title = "";
			text = "";

			reference = "[]";
			modules = new String[]{ "", "", "", "", "", "" };

			data = new String[]{ "2", "4", "2", "200K" };

		} else{
			code = projeto.getCodigo();
			title = projeto.getTitulo();
			text = projeto.getTexto();

			reference = projeto.getReferenciaBibliografica();

			modules = new String[projeto.getModulos().length];

			for (int i = 0; i < projeto.getModulos().length; i++){
				modules[i] = new String(Integer.toString(i + 1) + "é -   ");

				if (projeto.getModulos()[i].getRequisitos() > 0){
					modules[i] += (Integer.toString(projeto.getModulos()[i]
							.getRequisitos()) + " RQ");
				}
				if (projeto.getModulos()[i].getDesenhos() > 0){
					modules[i] += (" + "
							+ Integer.toString(projeto.getModulos()[i]
									.getDesenhos()) + "DS");
				}
				if (projeto.getModulos()[i].getCodigos() > 0){
					modules[i] += (" + "
							+ Integer.toString(projeto.getModulos()[i]
									.getCodigos()) + "CD");
				}
				if (projeto.getModulos()[i].getRastros() > 0){
					modules[i] += (" + "
							+ Integer.toString(projeto.getModulos()[i]
									.getRastros()) + "RS");
				}
				if (projeto.getModulos()[i].getAjudas() > 0){
					modules[i] += (" + "
							+ Integer.toString(projeto.getModulos()[i]
									.getAjudas()) + "AJ");
				}
				if (projeto.getModulos()[i].getTestes() > 0){
					modules[i] += (" + "
							+ Integer.toString(projeto.getModulos()[i]
									.getTestes()) + "TE");
				}

			}

			data = new String[]{ Integer.toString(projeto.getComplexidade()),
					Integer.toString(projeto.getTamanho()),
					Integer.toString(projeto.getQualidade()),
					Integer.toString(projeto.getOrcamento()) + "K" };

		}

	}

	// =====================================================================================//
	/**
	 * @param dim
	 *            - Dimension com o tamanho da tela do projeto. Define o tamanho
	 *            da tela e disponibiliza a informação para construção dos
	 *            componentes.
	 */
	public void setDim(Dimension dim){
		this.dim = dim;
		setSize(dim.width, dim.height);
		setPreferredSize(dim);
	}

	// =====================================================================================//

	/**
	 * Controla a ação do botão ok.
	 */
	@Override
	public void actionPerformed(ActionEvent e){

		ScreenProject.this.dispose();
	}

	/**
	 * Cria a tela e a faz visível. Por segurança é o método chamado pela Thread
	 * para construção da GUI
	 * 
	 * @param tabuleiro
	 */
	public static ScreenProject createAndShowProject(ScreenTabuleiro tabuleiro,
			CartaoProjeto projeto){
		// Cria e configura a tela.

		ScreenProject scr = new ScreenProject(tabuleiro, projeto);
		scr.rootPane.setOpaque(true);
		scr.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		scr.setDim(new Dimension(820, 620));
		scr.setAlwaysOnTop(true);
		scr.pack();
		scr.setModal(true);
		scr.setLocationRelativeTo(null);
		scr.setVisible(true);
		scr.setResizable(false);

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
				createAndShowProject(tabuleiro, new CartaoProjeto(Jogo.DIFICIL));
			}
		});
	}

}
// ===================================================================================//
// ===============================Fim da classe ScreenProject=========================//
// ===================================================================================//
