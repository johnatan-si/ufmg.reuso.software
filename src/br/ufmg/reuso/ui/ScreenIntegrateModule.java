/*
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * Simules-SPL Project
 *
 * Created by Alisson
 * Date: 25/07/2011
 */
package br.ufmg.reuso.ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import br.ufmg.reuso.negocio.carta.Artefato;
import br.ufmg.reuso.negocio.carta.CartaoProjeto;
import br.ufmg.reuso.negocio.jogo.Jogo;
import br.ufmg.reuso.negocio.mesa.Mesa;

//=====================================================================================//
//============================Inicio da classe ScreenInspectArtefacts==================//
//=====================================================================================//

/**
 * @author Alisson [AS] Seleçãoo de artefatos a serem inspecionados.
 * 
 *         A chamada pode ser feita conforme o exemplo abaixo: Modulo[] retorno
 *         = (createAndShowInspectArtefacts(
 *         "Indique o número de artefatos a produzir.", 2, 7) .getReturn());
 * 
 *         Ou instanciando a classe ScreenInspectArtefacts como uma janela de
 *         diálogo.
 * 
 *         A classe recebe uma string com a mensagem, um inteiro representando a
 *         complexidade e outro inteiro representando a habilidade do engenheiro
 * 
 */
public class ScreenIntegrateModule extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;

	JList listModules = null;

	protected Dimension mySize = new Dimension(500, 600);

	CartaoProjeto projeto;
	Mesa board;
	private String[] modules;
	@SuppressWarnings("unused")
	private String[] data;
	private JButton buttonOK;

	private int[][] artefactsReturn = null;
	private JCheckBox [][] listCheck = null;
	

	Border border = BorderFactory.createLineBorder(Color.BLACK);
	
	FlowLayout flw = new FlowLayout(FlowLayout.CENTER,0,0);
	
	JPanel panelInfo = null;
	
	JPanel panelArteracts = null;
	
	JPanel panelBase = null;
	
	JPanel panelModules = null;
	
	

	// =====================================================================================//
	/**
	 * Construtor da janela seleção de artefatos a serem produzidos
	 * 
	 * @param message
	 *            = mensagem a ser exibida
	 * @param complex
	 *            = Complexidade do projeto
	 * @param habilidade
	 *            = habilidade do engenheiro
	 * 
	 */
	public ScreenIntegrateModule(CartaoProjeto projeto, Mesa mesa){
		super();

		this.projeto = projeto;
		
		this.board = mesa;
		
		initiVars();
		getPanels();
		
		getRootPane().setDefaultButton(buttonOK);
		
		this.addComponentListener(getComponentAdapter());
		
		//setResizable(false);

	}

	private void getPanels(){
				 
		
		this.setLayout(flw);
		
		panelInfo = getPanelInfo();
		
		panelModules = getPanelModules();
		
		panelArteracts = getPanelArtefacts();
		
		panelBase = getPanelBase();
				
		add(panelInfo);
				
		
		add(panelModules);
		
		add(panelArteracts );	
			
		add(panelBase);		

	}

	// =====================================================================================//

	/**
	 * Painel com as informações da parte superior da tela
	 * @return JPanel - painel com as informações da parte superio da tela
	 */
	JPanel getPanelInfo(){

		String message = "Selecione um módulo e os artefatos";
		JPanel panel = new JPanel(flw);
		panel.setPreferredSize(new Dimension(500, 30));		
		JLabel label = new JLabel(message, JLabel.CENTER);
		label.setPreferredSize(new Dimension(500, 30));				
		label.setFont(new Font("Default", Font.BOLD, 12));
		panel.add(label);		
		return panel;

	}

	// =====================================================================================//
	/**
	 * Painel com as opções de artefatos
	 * 
	 * @return JPanel com as opções de artefatos
	 */
	JPanel getPanelModules(){

		flw.setAlignment(FlowLayout.CENTER);
		JPanel panel = new JPanel(flw);
		
			
		//int y = 10; 
		panel.setPreferredSize(new Dimension(500,110));
		
		panel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));

		panel.setBorder(border);
		Font font16 = new Font("Default", Font.PLAIN, 12);	
		listModules = new JList(modules);		
		//listModules.setBounds(15, y, 300, 120);		
		listModules.setFont(font16);
		JScrollPane sliderModules = new JScrollPane(listModules);
		sliderModules.setPreferredSize(new Dimension (300,100));
		//sliderModules.setBounds(15, y, 300, 100);
		sliderModules.setPreferredSize(new Dimension (300,100));
		sliderModules.setBorder(BorderFactory.createTitledBorder(border,
				"Módulos", TitledBorder.LEFT, TitledBorder.ABOVE_TOP, font16));
		sliderModules.setViewportView(listModules);
		panel.add(sliderModules);
		return panel;
	}
	
	// =====================================================================================//
		/**
		 * Função inicializa as variáveis do projeto para serem inicializadas.
		 * 
		 */
		void initiVars(){

			if (projeto == null){
				
				ScreenInteraction.getScreenInteraction().exibirMensagem("Projeto Nulo", "");

			} else{
				
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
			
			
			artefactsReturn = new int[10][10] ;
			listCheck = new JCheckBox [10][10];
			
			for( int i = 0; i < 10; i++){
				for( int j = 0; j < 10; j++){
					artefactsReturn[i][j] = -1;
					listCheck[i][j] = new JCheckBox ();
				}
			}
			

		}

		// =====================================================================================//
		/**
		 * Função inicializa as variáveis do projeto para serem inicializadas.
		 * 
		 */		
		JPanel getPanelArtefacts(){

			JPanel panelBoard = new myPanel();
			panelBoard.setBorder(null);
			panelBoard.setLayout(null);			
		
			int height = 30;
			int width = mySize.width /5;
			int x = 0;
			int y = 0;
			int yInc = 30;
			int xInc = mySize.width /5;
			
			Border borderW = BorderFactory.createLineBorder(Color.white);
						
			JLabel label = null;
			
			
			{// Inicio do colocação da matriz de artefatos
				ArrayList<ArrayList<Artefato>> modulo = new ArrayList<ArrayList<Artefato>>();
				modulo.add(board.getAjudas());
				modulo.add(board.getCodigos());
				modulo.add(board.getDesenhos());
				modulo.add(board.getRastros());
				modulo.add(board.getRequisitos());			
				

				Vector<String> names = new Vector<String>(
						Arrays.asList(new String[]{ "Ajudas","Códigos", 
								"Desenhos", "Rastros", "Requisitos" }));
				int i = 0;

				// Para cada tipo de artefato
				Iterator<ArrayList<Artefato>> itModulo = modulo.iterator();
				while (itModulo.hasNext()){

					ArrayList<Artefato> artefatos = itModulo.next();					
					y = 0;
					
					label = new JLabel(names.elementAt(i), JLabel.CENTER);
					label.setOpaque(false);				
					height = yInc;
					label.setBounds(x, y, width, height);
					//label.setBorder(borderW);
					panelBoard.add(label);					

					if (artefatos.size() > 0){
						Iterator<Artefato> it = artefatos.iterator();
						int j = 0;
						Artefato art = null;
						ImageIcon img = null;
						y += height;
						height = yInc / 2;						
						while (it.hasNext()){

							art = it.next();

							img = getImageArtefact(art, height*2);

							label = new JLabel();
							label.setIcon(img);
							label.setBounds(x + 2, y,
									img.getIconWidth(), img.getIconHeight());							
							label.setBorder(borderW);
							panelBoard.add(label);							
							
							listCheck[i][j].setBounds(x + img.getIconWidth() +2, y +2, width, height);
							
							//check.setMnemonic(KeyEvent.VK_C); 
							//check.setSelected(true);
							listCheck[i][j].setActionCommand(Integer.toBinaryString(i));
							panelBoard.add(listCheck[i][j]);
							//Vai ter que verificar o estado de cada check para ver.
						    if (it.hasNext() == true){
								y += img.getIconHeight();
							}
						    j++;
							
						} // Fim do while sobre os artafatos de um tipo

						// y += height/2;
						height = yInc;

					} else{ // Se não há artefatos do tipo atual

					}
					x += xInc;
					i++;
				} // Fim do while sobre tipos de artefatos

				// Inserir Requisitos

			} // Fim do colocação da matriz de artefatos
			
			return panelBoard;

		}

	/**
	 * Painel com os resultados da seleção do usuário mais o botão de ok.
	 * 
	 * @return JPanel - com os resultados da seleção do usuário mais o botão de
	 *         ok
	 */
	JPanel getPanelBase(){

		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));

		panel.add(Box.createRigidArea(new Dimension(mySize.width *70/100,30 )));

		buttonOK = new JButton("OK");
		buttonOK.addActionListener(this);
		buttonOK.setPreferredSize(new Dimension(mySize.width *20/100, 30));
		panel.add(buttonOK);

		return panel;
	}

	// =====================================================================================//
	/**
	 * Controlador de eventos dos botões. Verifica se os nomes foram inseridos e
	 * coloca-os no vetor de saída,
	 * */
	@Override
	public void actionPerformed(ActionEvent e){

		if (e.getActionCommand() == "OK"){			
			
			for( int i = 0; i < 10; i++){
				for( int j = 0; j < 10; j++){
					artefactsReturn[i][j] = 
							(listCheck[i][j].isSelected()==true ? 0 : artefactsReturn[i][j]); 
										
				}
			}
			
			
			ScreenIntegrateModule.this.dispose();


		}

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
		private ImageIcon getImageArtefact(Artefato art, int height){
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
		

		//=====================================================================================//	


		/**
		 * @return ComponentAdapter - responsável pelo controle dinâmico da tela
		 * 
		 * Verifica caso a tela seja modificada  e chama a função de atualização de posicionamento dos componentes.
		 * 
		 * 
		 */
		private ComponentAdapter getComponentAdapter(){

			ComponentAdapter adapter = new ComponentAdapter(){
				public void componentResized(ComponentEvent e){

					ScreenIntegrateModule.this.setPreferredSize(ScreenIntegrateModule.this.getSize());
					updateBounds();
					//System.out.println("resized");
					ScreenIntegrateModule.this.repaint();

				}
			};

			return adapter;
		}
		
		//=====================================================================================//	

		/**
		 * Método responsável por posicionar os objetos na tela com base no tamanho total da tela e no tamanho percentual dos objetos. 
		 */
		void updateBounds(){
			int x, y, width, height;//, xgap, ygap;
						
			//xgap = x = dim.width * 2 / 100; // 2% para borda esquerda
			//ygap = y = dim.height * 3 / 100;
			width = mySize.width * 96 / 100;
			height = mySize.height * 5 / 100;
			x =y =0;
			panelInfo.setBounds(x, y, width, height); 
			
			//ygap = dim.height * 2 / 100;
			y += height;
			//x = xgap;
			//xgap = mySize.width * 2 / 100;
			//width = dim.width * 90 / 100;
			height = mySize.height * 20 / 100;
			
			panelModules.setBounds(x, y, width, height);
			
			//ygap = dim.height * 2 / 100;
			y += height;
			//x = xgap;
			//xgap = mySize.width * 2 / 100;
			//width = dim.width * 90 / 100;
			height = mySize.height * 62 / 100;
			
			panelArteracts.setBounds(x, y, width, height);

			//ygap = dim.height * 2 / 100;
			y += height;
			//x = xgap;
			//xgap = mySize.width * 2 / 100;
			//width = dim.width * 90 / 100;
			height = mySize.height * 7 / 100;
			
			panelBase.setBounds(x, y, width, height);
			
		}

		// =====================================================================================//

	
	/* (non-Javadoc)
		 * @see java.awt.Component#setPreferredSize(java.awt.Dimension)
		 */
		@Override
		public void setPreferredSize(Dimension preferredSize){	
			super.setPreferredSize(preferredSize);
			mySize = preferredSize;
		}

	// =====================================================================================//
	/**
	 * Retorna o modulo a ser integrado.
	 * 
	 * @return int = índice do módulo escolhido para integração no projeto.
	 */
	public  int getModuleReturn(){

		int retorno = listModules.getSelectedIndex();
		
		
		//Testes
		System.out.println("Modulo escolhido:"  + Integer.toString(retorno) );
		for( int i = 0; i < 10; i++){
			for( int j = 0; j < 10; j++){
				System.out.print("["+ Integer.toString(artefactsReturn[i][j])+ "]");											
			}
			System.out.println();
		}		//FIM DO Testes
		
		
		return retorno ;
	}
	
	public  int[][] getArtefatosEscolhidos(){
		
		return artefactsReturn;
	}

	// =====================================================================================//
	/**
	 * Cria a tela e a faz visível a janela seleção de artefatos a serem
	 * produzidos *
	 * 
	 * @param message
	 *            = mensagem a ser exibida
	 * @param complexidade
	 *            = Complexidade do projeto
	 * @param habilidade
	 *            = habilidade do engenheiro
	 */
	public static ScreenIntegrateModule createAndShowIntegrateModule(CartaoProjeto projeto, Mesa mesa){

		// Cria e configura a tela.
		ScreenIntegrateModule scr = new ScreenIntegrateModule( projeto,  mesa);
		scr.rootPane.setOpaque(true);
		scr.setTitle("Simules");
		scr.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		scr.setPreferredSize(new Dimension(500, 600));
		scr.setModal(true);
		scr.pack();
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

				CartaoProjeto projeto = new CartaoProjeto(Jogo.DIFICIL);
				Mesa mesa= new Mesa();		
				
							
				ScreenIntegrateModule scr = createAndShowIntegrateModule(
						 projeto,  mesa);
				
				int [][] artefactsReturn =scr.getArtefatosEscolhidos() ;
				int modulo =  scr.getModuleReturn();
				System.out.println("Modulo escolhido:"  + Integer.toString(modulo) );
				for( int i = 0; i < 10; i++){
					for( int j = 0; j < 10; j++){
						System.out.print("["+ Integer.toString(artefactsReturn[i][j])+ "]");											
					}
					System.out.println();
				}
				

				
			}
		});

	}
	
	
	private class myPanel extends JPanel{
		private static final long serialVersionUID = 1L;

		//método implementado de JPanel
		protected void paintComponent(final Graphics g){
		               super.paintComponent(g);
		               //g.drawImage(bImage, 0, 0, this);
		               g.setColor(Color.white);
		               int xInc = ScreenIntegrateModule.this.mySize.width/5;		               
		               for( int i = 0;  i <= this.getWidth(); i += xInc ){
		            	   g.drawLine(i, 0, i, this.getHeight());
		               }
		        }
	}

}// Fim da classe
// ===========================================================================//
// ===================Fim da classe ScreenInspectArtefacts====================//
//===========================================================================//

	
