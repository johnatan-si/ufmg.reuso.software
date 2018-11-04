/*
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * Simules-SPL Project
 *
 * Created by Alisson
 * Date: 28/07/2011
 */
package br.ufmg.reuso.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import br.ufmg.reuso.negocio.carta.Carta;
//#ifdef ConceptCard
import br.ufmg.reuso.negocio.carta.CartaBonificacao;
//#endif
import br.ufmg.reuso.negocio.carta.CartaEngenheiro;
import br.ufmg.reuso.negocio.carta.CartaPenalizacao;

//=====================================================================================//
//Inicio da classe ComponentCard
//=====================================================================================//

/**
 * @author Alisson
 *
 * Classe responsável por construir um painel com a representação visual de uma carta.
 * Possui redimensinamento dinâmico e é utilizada pela classe ScreenCard e ScreenTabuleiro.
 * 
 *  Não possui nenhum retorno além da representação visual da carta.
 *  
 */
public class ComponentCard extends JPanel{

	private static final long serialVersionUID = 1L;

	private JPanel panelCenter = null;	
	private Carta card = null;
	
	//Define o tamanho da carta e dos demais objetos
	private Dimension mySize = new Dimension(190, 240);
	
	
	//=====================================================================================//
	//Variáveis para pintura dos componentes na tela.	
	// Todos
	JLabel lblType = null;
	JLabel lblCode = null;
	JTextPane paneDesc = null;
	JScrollPane sliderPaneDesc = null;

	JTextPane paneRef = null; // Conceito e Problema
	JScrollPane sliderPaneRef = null;

	JTextPane paneCondition = null;
	JScrollPane sliderPaneCondition = null;

	// Engenheiro
	JLabel lblFig = null;
	JLabel lblSold = null;
	JLabel lblHabilit = null;
	JLabel lblMaturit = null;
	JLabel lblHabilitValue = null;
	JLabel lblMaturitValue = null;

	//=====================================================================================//	
	/**
	 * Cria a representação da carta
	 * 
	 * @param carta - Carta do jogo a ser pintada
	 * @param tabuleiro - O tabuleiro atual. Pode ser obtido pela chamada de ScreenInteraction.getTabuleiro()
	 * 
	 */
	public ComponentCard(Carta carta, ScreenTabuleiro tabuleiro){

		this(carta, tabuleiro, new Dimension(190, 240));

	}

	/**
	 * Construtor auxiliar com o parâmetro Dimensão da carta.
	 * 
	 * @param carta - Carta do jogo a ser pintada
	 * @param tabuleiro - O tabuleiro atual. Pode ser obtido pela chamada de ScreenInteraction.getTabuleiro()	 * 
	 * @param dim - Dimension com as dimensões que a carta deve assimir
	 */
	public ComponentCard(Carta carta, ScreenTabuleiro tabuleiro, Dimension dim){

		this.card = carta;

		setPreferredSize(dim);

		this.setOpaque(true);

		this.mySize = dim;

		setLayout(new BorderLayout());

		this.addComponentListener(getComponentAdapter());
		{
			createPanels();
		}

	}
	
	//=====================================================================================//
	/**
	 * Chama os construtores dos paineis. 
	 */
	private void createPanels(){

		panelCenter = getPanelCenter();
		add(panelCenter, BorderLayout.CENTER);

	}
	
	//=====================================================================================//
 	/**
	 * @return JPanel  - painel com a pintura da carta
	 */
	JPanel getPanelCenter(){

		Carta carta = card;

		JPanel panel = new JPanel();
		Font font = new Font("Default", Font.PLAIN, 10);

		Border border = BorderFactory.createLineBorder(Color.black);

		panel.setLayout(null);

		{
			lblType = new JLabel("");
			lblType.setFont(font);
			panel.add(lblType);
		}
		{
			lblCode = new JLabel(carta.getCodigoCarta(), JLabel.CENTER);
			lblCode.setBorder(border);
			lblCode.setFont(font);
			panel.add(lblCode);
		}

		{

			paneDesc = new JTextPane();
			SimpleAttributeSet bSet = new SimpleAttributeSet();
			StyleConstants.setAlignment(bSet, StyleConstants.ALIGN_JUSTIFIED);
			StyledDocument doc = paneDesc.getStyledDocument();
			doc.setParagraphAttributes(0, doc.getLength(), bSet, false);
			paneDesc.setText(carta.getTextoCarta());
			paneDesc.setInheritsPopupMenu(true);
			paneDesc.setAlignmentX(CENTER_ALIGNMENT);
			paneDesc.setFont(font);
			paneDesc.setBorder(BorderFactory.createLineBorder(Color.white));
			paneDesc.setEditable(false);
			sliderPaneDesc = new JScrollPane(paneDesc);
			sliderPaneDesc.setViewportView(paneDesc);
			panel.add(sliderPaneDesc);
		}
		
		if (card instanceof CartaEngenheiro){
			CartaEngenheiro cartaEngenheiro = (CartaEngenheiro) card;

			lblType.setText("Engenheiro");

			{
				lblFig = new JLabel();
				lblFig.setBorder(BorderFactory.createTitledBorder(
						BorderFactory.createEmptyBorder(),
						cartaEngenheiro.getNomeEngenheiro(), TitledBorder.LEFT,
						TitledBorder.DEFAULT_POSITION, font));
				
				String path = ScreenInteraction.imagePath
						+ carta.getCodigoCarta() + ".png";
				
				lblFig.setHorizontalAlignment(SwingConstants.CENTER);
				
				ImageIcon img = null;
				img = (getImageScalable(path, 0, mySize.height * 24 / 100));
				
				if (img == null){
					img = getImageScalable(ScreenInteraction.imagePath
							+ "smile.png", 0, mySize.height * 24 / 100);
				}
				
				lblFig.setIcon(img);

				panel.add(lblFig);
			}
			
			{
				lblSold = new JLabel("Salário:"
						+ Integer.toString(cartaEngenheiro
								.getSalarioEngenheiro()) + "K");
				
				lblSold.setHorizontalAlignment(SwingConstants.CENTER);
				lblSold.setBackground(Color.LIGHT_GRAY);
				lblSold.setBorder(border);
				lblSold.setOpaque(true);
				panel.add(lblSold);
			}

			{
				lblHabilit = new JLabel("Habilidade");
				lblHabilit.setHorizontalAlignment(SwingConstants.RIGHT);
				panel.add(lblHabilit);
			}

			{
				lblHabilitValue = new JLabel(Integer.toString(cartaEngenheiro
						.getHabilidadeEngenheiro()));
				
				lblHabilitValue.setHorizontalAlignment(SwingConstants.CENTER);
				lblHabilitValue.setBackground(Color.LIGHT_GRAY);
				lblHabilitValue.setOpaque(true);
				lblHabilitValue.setBorder(BorderFactory.createEmptyBorder());
				panel.add(lblHabilitValue);
			}

			{
				lblMaturit = new JLabel("Maturidade");
				lblMaturit.setHorizontalAlignment(SwingConstants.RIGHT);
				panel.add(lblMaturit);
			}

			{
				lblMaturitValue = new JLabel(Integer.toString(cartaEngenheiro
						.getMaturidadeEngenheiro()));
				
				lblMaturitValue.setHorizontalAlignment(SwingConstants.CENTER);
				lblMaturitValue.setBackground(Color.LIGHT_GRAY);
				lblMaturitValue.setOpaque(true);
				lblMaturitValue.setBorder(BorderFactory.createEmptyBorder());
				panel.add(lblMaturitValue);
			}

		}
		//#ifdef ConceptCard
		else if (card instanceof CartaBonificacao){
			{
				CartaBonificacao cartaConceito = (CartaBonificacao) card;

				lblType.setText("Conceito");

				paneRef = new JTextPane();
				SimpleAttributeSet bSet = new SimpleAttributeSet();
				StyleConstants.setAlignment(bSet,
						StyleConstants.ALIGN_JUSTIFIED);
				
				StyledDocument doc = paneRef.getStyledDocument();
				doc.setParagraphAttributes(0, doc.getLength(), bSet, false);
				paneRef.setText(cartaConceito.getReferenciaBibliografica());
				paneRef.setInheritsPopupMenu(true);
				paneRef.setAlignmentX(CENTER_ALIGNMENT);
				paneRef.setFont(font);
				paneRef.setBorder(BorderFactory.createTitledBorder(
						BorderFactory.createLineBorder(Color.LIGHT_GRAY),
						cartaConceito.getTituloCarta(), TitledBorder.LEFT,
						TitledBorder.DEFAULT_POSITION, font));
				
				paneRef.setEditable(false);
				sliderPaneRef = new JScrollPane();
				sliderPaneRef.setViewportView(paneRef);
				panel.add(sliderPaneRef);
			}

		}
		//#endif
		else if (card instanceof CartaPenalizacao){

			{
				CartaPenalizacao cartaProblema = (CartaPenalizacao) card;

				lblType.setText("Problema");

				paneRef = new JTextPane();
				SimpleAttributeSet bSet = new SimpleAttributeSet();
				StyleConstants.setAlignment(bSet,
						StyleConstants.ALIGN_JUSTIFIED);
				
				StyledDocument doc = paneRef.getStyledDocument();
				doc.setParagraphAttributes(0, doc.getLength(), bSet, false);
				paneRef.setText(cartaProblema.getReferenciaBibliografica());
				paneRef.setInheritsPopupMenu(true);
				paneRef.setAlignmentX(CENTER_ALIGNMENT);
				paneRef.setFont(font);				
				paneRef.setBorder(BorderFactory.createTitledBorder(
						BorderFactory.createLineBorder(Color.LIGHT_GRAY),
						cartaProblema.getTituloCarta(), TitledBorder.LEFT,
						TitledBorder.DEFAULT_POSITION, font));
				
				paneRef.setEditable(false);
				sliderPaneRef = new JScrollPane();
				sliderPaneRef.setViewportView(paneRef);

				panel.add(sliderPaneRef);

				paneCondition = new JTextPane();
				doc = paneCondition.getStyledDocument();
				doc.setParagraphAttributes(0, doc.getLength(), bSet, false);
				paneCondition.setText(cartaProblema.getCondicaoProblema());
				paneCondition.setInheritsPopupMenu(true);
				paneCondition.setAlignmentX(CENTER_ALIGNMENT);
				paneCondition.setFont(font);
				paneCondition.setBorder(BorderFactory.createEmptyBorder());
				paneCondition.setEditable(false);
				sliderPaneCondition = new JScrollPane();
				sliderPaneCondition.setViewportView(paneCondition);
				panel.add(sliderPaneCondition);

			}

		}

		return panel;
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

				ComponentCard.this.mySize = ComponentCard.this.getSize();
				updateBounds();
				//System.out.println("resized");
				ComponentCard.this.repaint();

			}
		};

		return adapter;
	}
	
	//=====================================================================================//	

	/**
	 * Método responsável por posicionar os objetos na tela com base no tamanho total da tela e no tamanho percentual dos objetos. 
	 */
	void updateBounds(){
		int x, y, width, height, xgap, ygap;
		xgap = x = mySize.width * 5 / 100; // 5% para borda esquerda
		ygap = y = mySize.height * 3 / 100;
		width = mySize.width * 45 / 100;
		height = mySize.height * 10 / 100;

		lblType.setBounds(x, y, width, height);

		x += width + xgap;
		width = mySize.width * 40 / 100;
		lblCode.setBounds(x, y, width, height);

		// Verifica o tipo de carta
		if (card instanceof CartaEngenheiro){

			ygap = mySize.height * 2 / 100;
			y += height;
			x = xgap;
			xgap = mySize.width * 2 / 100;
			width = mySize.width * 90 / 100;
			height = mySize.height * 30 / 100;
			lblFig.setBounds(x, y, width, height); 
			
			y += height + ygap;
			// x = gap;
			width = mySize.width * 90 / 100;
			height = mySize.height * 27 / 100;
			sliderPaneDesc.setBounds(x, y, width, height);

			y += height + ygap;
			// x = gap;
			width = mySize.width * 90 / 100;
			height = mySize.height * 7 / 100;
			lblSold.setBounds(x, y, width, height);

			ygap = mySize.height * 2 / 100;
			y += height + ygap;
			// x = gap;
			width = mySize.width * 55 / 100;
			height = mySize.height * 7 / 100;
			lblHabilit.setBounds(x, y, width, height);

			// y+= height + gap;
			x = mySize.width * 5 / 100 + width + mySize.width * 5 / 100;
			width = mySize.width * 30 / 100;
			height = mySize.height * 7 / 100;
			lblHabilitValue.setBounds(x, y, width, height);

			y += height + ygap;
			x = mySize.width * 5 / 100;
			width = mySize.width * 55 / 100;
			height = mySize.height * 7 / 100;
			lblMaturit.setBounds(x, y, width, height);

			// y+= height + gap;
			x = mySize.width * 5 / 100 + width + mySize.width * 5 / 100;
			width = mySize.width * 30 / 100;
			height = mySize.height * 7 / 100;
			lblMaturitValue.setBounds(x, y, width, height);

		}
		//#ifdef ConceptCard
		else if (card instanceof CartaBonificacao){

			y += height + ygap;
			x = xgap;
			width = mySize.width * 90 / 100;
			height = mySize.height * 40 / 100;
			sliderPaneRef.setBounds(x, y, width, height);

			y += height + ygap;
			// x = gap;
			width = mySize.width * 90 / 100;
			height = mySize.height * 40 / 100;
			sliderPaneDesc.setBounds(x, y, width, height);

		}
		//#endif
		else if (card instanceof CartaPenalizacao){

			y += height + ygap;
			x = xgap;
			width = mySize.width * 90 / 100;
			height = mySize.height * 30 / 100;
			sliderPaneRef.setBounds(x, y, width, height);

			y += height + ygap;
			// x = gap;
			width = mySize.width * 90 / 100;
			height = mySize.height * 30 / 100;
			sliderPaneDesc.setBounds(x, y, width, height);

			y += height + ygap;
			// x = gap;
			width = mySize.width * 90 / 100;
			height = mySize.height * 15 / 100;
			sliderPaneCondition.setBounds(x, y, width, height);

		}

	}
	
	//=====================================================================================//	
	/**
	 * Método responsável por criar uma imagem que esteja no caminho path proporcional lados x ou y passado como parâmetro.
	 * Caso os valores de x e y forem preenchidos a imagem terá exatamente x por y. Para que a imagem seja proporcional o valor de x ou de y deve ser zero ( 0 ). 
	 * 
	 * @param path - String com o caminho da imagem
	 * @param x - Tamanho horizontal disponível para a imagem
	 * @param y - Tamanho vertical disponível para a imagem
	 * @return  ImageIcon - imagem para ser inserida em um JLabel.
	 * 
	 * Caso a construção da imagem esteja tornando o sistema lento pode-se mudar a constante Image.SCALE_SMOOTH no fim do método para corresponder uma renderização mais rápida da imagem.
	 * 
	 */
	public static ImageIcon getImageScalable(String path, int x, int y){

		BufferedImage img = null;

		try{

			File fl = new File(path);
			if (fl.isFile()){
				img = ImageIO.read(fl);
			} else{
//				System.err.println("Couldn't find file: " + path);
				return null;
			}
		} catch (Exception e){
			e.printStackTrace();
//			System.err.println("Couldn't find file: " + path);
			return null;
		}

		if (img == null)
			System.err.println("Image da carta  = Null");

		Image menor = null;
		double fator = 0;
		if (x != 0 || y != 0){

			if (x == 0){
				fator = (double) y / img.getHeight(null);
				//System.out.println("fator y= " + fator);
			} else{
				fator = (double) x / img.getWidth(null);
				//System.out.println("fator x = " + fator);
			}

			x = (int) Math.round(fator * img.getWidth(null));
			y = (int) Math.round(fator * img.getHeight(null));

		}
		//System.out.println("fator = " + fator + "; X = " + x + ";  Y = " + y);
		menor = img.getScaledInstance(x, y, Image.SCALE_SMOOTH);

		return new ImageIcon(menor);
	}

	
	//=====================================================================================//	
	// Métodos get e set a dimensão da carta
	/**
	 * @return the size
	 */
	public Dimension getMySize(){
		return mySize;
	}

	/**
	 * @param width
	 * @param size
	 *            the size to set
	 */
	public void setMySize(Dimension size){
		this.mySize = size;
	}

}
//=====================================================================================//
//Fim da classe ComponentCard
//=====================================================================================//

