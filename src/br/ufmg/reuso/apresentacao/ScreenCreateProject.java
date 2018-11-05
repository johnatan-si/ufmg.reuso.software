package br.ufmg.reuso.apresentacao;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

//=====================================================================================//
//===============================Inicio da classe ScreenCreateProject=========================//
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
 * Ou instanciando a classe ScreenCreateProject como uma janela de diálogo.
 * 
 */
public class ScreenCreateProject extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	
	private Vector<String> jogadores;
	Vector<JTextField> textJogadores;
	JTextArea  area;
	//Vetor de retorno com os nomes dos jogadores
	private Vector<String> vectorReturn;

	//=====================================================================================//

	/**
	 * Construtor da janela inserção dos nomes dos jogadores
	 * @param tabuleiro - tabueleiro do jogo atual 
	 */
	public ScreenCreateProject(ScreenTabuleiro tabuleiro){
		super(tabuleiro);

		this.setLocationRelativeTo(tabuleiro);
		this.setLayout(new BorderLayout());

		jogadores = new Vector<String>((Arrays.asList("Código", "Nome")));
		textJogadores = new Vector<JTextField>();

		JPanel panel = new JPanel();
		panel.setLayout(null);

		panel.setPreferredSize(new Dimension(340, 300));

		Dimension dim = new Dimension(100, 30);
		JLabel label;
		JTextField text;
		

		for (int i = 0; i < jogadores.size(); i++){

			label = new JLabel(jogadores.elementAt(i));
			label.setBounds(10, i * dim.height + 10, dim.width, dim.height);
			label.setHorizontalAlignment(SwingConstants.RIGHT);
			panel.add(label);
			text = new JTextField();
			text.setBounds(dim.width + 50, i * dim.height + 10, dim.width,
						dim.height);
			text.addActionListener(this);
			text.setActionCommand(Integer.toString(i));
			textJogadores.add(text);
			panel.add(text);
			
		}
		label = new JLabel("Descrição");
		label.setBounds(10, 2 * dim.height + 10, dim.width, dim.height);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(label);
		
		area = new JTextArea();
		area.setBounds(dim.width + 50, 2 * dim.height + 10, dim.width,
					dim.height);
		panel.add(area);
		
		label = new JLabel("Tamanho:");
		label.setBounds(20, 5 * dim.height + 10, dim.width, dim.height);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(label);
		
		//Escolher tamanho do projeto
		
		label = new JLabel("Pequeno");
		label.setBounds(20, 6 * dim.height + 10, dim.width, dim.height);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(label);
		JRadioButton checaP = new JRadioButton();
		checaP.setBounds(dim.width + 50, 6 * dim.height + 10, dim.width,
				dim.height);
	    panel.add(checaP);
	    
	    label = new JLabel("Médio");
		label.setBounds(20, 7 * dim.height + 10, dim.width, dim.height);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(label);
		JRadioButton checaM = new JRadioButton();
		checaM.setBounds(dim.width + 50, 7 * dim.height + 10, dim.width,
				dim.height);
	    panel.add(checaM);
	    
	    label = new JLabel("Grande");
		label.setBounds(20, 8 * dim.height + 10, dim.width, dim.height);
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(label);
		JRadioButton checaG = new JRadioButton();
		checaG.setBounds(dim.width + 50, 8 * dim.height + 10, dim.width,
				dim.height);
	    panel.add(checaG);
	    
	    ButtonGroup group = new ButtonGroup();
		group.add(checaP);
		group.add(checaM);
		group.add(checaG);
	    
		textJogadores.get(0).setSize(dim.width+50, dim.height);
		textJogadores.get(1).setSize(dim.width+50, dim.height);
		area.setSize(dim.width+50, dim.height+50);
		
		
		
		JButton buttonOk = new JButton("OK");
		buttonOk.addActionListener(this);
		buttonOk.setBounds(250, 8 * 30 + 10, 80, 25);
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
			ScreenCreateProject.this.dispose();
		}
	}
	//=====================================================================================//

	/**
	 * Retorna os nomes dos jogadores. Verifica se os nomes foram inseridos e
	 * coloca-os no vetor de saída, caso contrário insere dois jogadores com
	 * nomes padrão Jogador1 e Jogador2.
	 * @throws IOException 
	 */
	public String [] getReturn(){

		/*jogadores.clear();
		for (int i = 0; i < textJogadores.size(); i++){
			if (textJogadores.get(i).getText().compareTo("") != 0){
				jogadores.add(textJogadores.get(i).getText());
			}
		}*/
		String codigo = textJogadores.get(0).getText();
		String nome = textJogadores.get(1).getText();
		String descricao = area.getText();

		//vectorReturn = (codigo,nome,descricao);
		//ScreenCreateProject.this.dispose();
		String [] retorno = new String[3];
		retorno[0]=codigo;
		retorno[1]=nome;
		retorno[2]=descricao;
		
		try{
			String nomeArquivo = "P"+retorno[0]+".properties";
			ScreenControl.nomeProjeto = nomeArquivo;
			BufferedWriter br;
			br = new BufferedWriter(new FileWriter(new File("CartaoProjeto/"+nomeArquivo)));
			br.write("codigo = "+codigo+"\n"); 
			br.write("titulo = "+nome+"\n"); 
			br.write("texto = "+descricao+"\n"); 
			br.close(); 
			
		} catch (IOException e){
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
						
		return retorno;
		
	}

	//=====================================================================================//
	/**
	 * Cria a tela e a faz visível. Por segurança é o método chamado pela Thread
	 * para construção da GUI
	 * @param tabuleiro - tabueliro do jogo atual
	 */
	public static ScreenCreateProject createAndShowGetCProject(ScreenTabuleiro tabuleiro){

		// Cria e configura a tela.
		ScreenCreateProject scr = new ScreenCreateProject(tabuleiro);
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
				String[] retorno = (createAndShowGetCProject(tabuleiro).getReturn());
				  
				
			}
		});
	
	}

}//Fim da classe

//=====================================================================================//
//==================================FIM da classe ScreenCreateProject=========================//
//=====================================================================================//


