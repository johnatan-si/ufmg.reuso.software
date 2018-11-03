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
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import br.ufmg.reuso.negocio.mesa.Modulo;

//=====================================================================================//
//============================Inicio da classe ScreenInspectArtefacts==================//
//=====================================================================================//

/**
 * @author Alisson [AS] Seleção de artefatos a serem inspecionados.
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
public class ScreenChooseArtefacts extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;

	private JLabel labelTotal;

	Vector<JComboBox> listBom = new Vector<JComboBox>();
	Vector<JComboBox> listRuim = new Vector<JComboBox>();

	Modulo modulo[];

	private int habilidade;
	
	private int complexit;

	private JButton buttonOK;
	
	private boolean returnOk = false;
		
	Border border = BorderFactory.createLineBorder(Color.BLACK);

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
	public ScreenChooseArtefacts(String message, Modulo[] modulo,
			int complexidade, int habilidade){
		super();

		this.modulo = modulo;

		this.habilidade = habilidade;
		this.complexit = complexidade;

		this.setLayout(new BorderLayout());

		add(getPanelInfo(message, complexidade, habilidade), BorderLayout.NORTH);

		add(getPanelArtefatos(), BorderLayout.CENTER);

		add(getPanelBase(), BorderLayout.SOUTH);

		getRootPane().setDefaultButton(buttonOK);
		
		setResizable(false);
		
		returnOk = true; //TODO [ARS] - true PARA TESTE, ACEITA QUALQUER QUANTIDADE DE ARTEFATOS.

	}

	// =====================================================================================//

	/**
	 * Painel com as informações da parte superior da tela
	 * 
	 * @param message
	 *            - Strig com a mensagem a ser exibida para o jogador
	 * @param habilidade
	 *            - Inteiro com a habilidade do engenheiro que esta executando a
	 *            tarefa.
	 * @return JPanel - painel com as informações da parte superio da tela
	 */
	JPanel getPanelInfo(String message, int complexidade, int habilidade){
				
		BorderLayout bd = new BorderLayout(0,3);
		this.setTitle(message);

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(380, 50));
		panel.setLayout(bd);

		JLabel label;
//		label = new JLabel(message, JLabel.CENTER);
//		label.setPreferredSize(new Dimension(380, 25));
//		label.setFont(new Font("Default", Font.BOLD, 16));
//		panel.add(label, BorderLayout.NORTH);
		
		
		
		String mensagem = "<HTML>Habilidade atual do engenheiro: " + habilidade;
		if(complexidade != -1){			
				mensagem +=("<BR>Complexidade do projeto: " + complexidade);
		}
		
		label = new JLabel(mensagem, JLabel.CENTER);
		label.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
		label.setPreferredSize(new Dimension(380, 50));
		panel.add(label, BorderLayout.NORTH);

		return panel;

	}

	// =====================================================================================//
	/**
	 * Painel com as opções de artefatos
	 * 
	 * @return JPanel com as opções de artefatos
	 */
	JPanel getPanelArtefatos(){

		JPanel panel = new JPanel(new GridLayout(6, 3, 10, 10));

		panel.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));

		JLabel label;
		JComboBox list;

		panel.add(new JLabel(""));
		panel.add(new JLabel("Bom", JLabel.CENTER));
		panel.add(new JLabel("Ruim", JLabel.CENTER));

		int bons = ScreenInteraction.ARTEFATOS_BONS;
		int ruins = ScreenInteraction.ARTEFATOS_RUINS;

		String[] nomes = new String[]{ "Requisitos", "Desenhos", "Código",
				"Rastros", "Ajudas" };

		int valor = 0;

		ArrayList<Integer> arr;

		for (int i = 0; i < nomes.length; i++){

			label = new JLabel(nomes[i]);
			label.setHorizontalAlignment(SwingConstants.RIGHT);
			panel.add(label);

			if (modulo!= null){
			// bom
			if (nomes[i].equalsIgnoreCase("Requisitos")){
				valor = modulo[bons].getRequisitos();

			} else if (nomes[i].equalsIgnoreCase("Desenhos")){
				valor = modulo[bons].getDesenhos();
			} else if (nomes[i].equalsIgnoreCase("Código")){
				valor = modulo[bons].getCodigos();
			} else if (nomes[i].equalsIgnoreCase("Rastros")){
				valor = modulo[bons].getRastros();
			} else if (nomes[i].equalsIgnoreCase("Ajudas")){
				valor = modulo[bons].getAjudas();
			}
			}else{
				valor = 4;
			}
			arr = new ArrayList<Integer>();
			for (int j = 0; j <= valor; j++){
				arr.add(j);
			}

			list = new JComboBox(arr.toArray());
			list.setName(nomes[i]);
			list.setBorder(BorderFactory.createEmptyBorder());
			list.addActionListener(getActionListener());
			listBom.add(list);

			panel.add(list);

			// ruim
			if (modulo!= null){
			if (nomes[i].equalsIgnoreCase("Requisitos")){
				valor = modulo[ruins].getRequisitos();
			} else if (nomes[i].equalsIgnoreCase("Desenhos")){
				valor = modulo[ruins].getDesenhos();
			} else if (nomes[i].equalsIgnoreCase("Código")){
				valor = modulo[ruins].getCodigos();
			} else if (nomes[i].equalsIgnoreCase("Rastros")){
				valor = modulo[ruins].getRastros();
			} else if (nomes[i].equalsIgnoreCase("Ajudas")){
				valor = modulo[ruins].getAjudas();
			}
			}else{	
				valor = 4;				
			}
			
			arr = new ArrayList<Integer>();
			for (int j = 0; j <= valor; j++){
				arr.add(j);
			}

			list = new JComboBox(arr.toArray());
			list.setName(nomes[i]);
			list.addActionListener(getActionListener());
			listRuim.add(list);

			panel.add(list);
		}

		return panel;
	}

	/**
	 * Painel com os resultados da seleção do usuário mais o botão de ok.
	 * 
	 * @return JPanel - com os resultados da seleção do usuário mais o botão de
	 *         ok
	 */
	JPanel getPanelBase(){

		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));

		panel.add(new JLabel("Complexidade Total: "));
		labelTotal = new JLabel("0", JLabel.LEFT);
		labelTotal.setPreferredSize(new Dimension(100, 25));
		panel.add(labelTotal);

		buttonOK = new JButton("OK");
		buttonOK.addActionListener(this);
		buttonOK.setPreferredSize(new Dimension(60, 25));
		panel.add(buttonOK);

		return panel;
	}

	// =====================================================================================//
	/**
	 * Responsável por somar a quantidade de tarefas e compara com a habilidade
	 * do engenheiro ao modificar o valor de um componente.
	 * 
	 * @return ActionListener - Responsável por somar a quantidade de tarefas e
	 *         compara com a habilidade do engenheiro.
	 * 
	 */
	private ActionListener getActionListener(){

		ActionListener fl = new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				if (complexit == -1){
					calculaComplexidade();
				} else{
					calculaComplexidade(complexit);					
				}				
				
				((Component) e.getSource()).getParent().repaint();

			}
		};

		return fl;
	}

	// =====================================================================================//
	/**
	 * Efetua o cálculo da complexidade total dos artefatos inspecionados até o
	 * momento
	 */
	private void calculaComplexidade(){

		Iterator<JComboBox> bom = listBom.iterator();
		Iterator<JComboBox> ruim = listRuim.iterator();

		int soma = 0;

		JComboBox text = null;
		while (bom.hasNext() || ruim.hasNext()){

			try{

				text = bom.next();

				soma += ((Integer) text.getSelectedItem()).intValue();
				text = ruim.next();

				soma += ((Integer) text.getSelectedItem()).intValue();

			} catch (NumberFormatException e){
				e.printStackTrace();
				text.requestFocus();
				text.setBorder(BorderFactory.createLineBorder(Color.RED));
				break;
			} catch (Exception e){
				e.printStackTrace();
				System.exit(0);
			} finally{

			}

			if (soma > habilidade){
				labelTotal.setBorder(BorderFactory.createLineBorder(Color.RED));
			} else{
				labelTotal.setBorder(BorderFactory.createEmptyBorder());

			}
			labelTotal.setText(Integer.toString(soma));

		}

	}
	
	/**
	 * Efetua o cálculo da complexidade total dos artefatos produzidos até o
	 * momento
	 */
	private void calculaComplexidade(int complexidade){

		Iterator<JComboBox> bom = listBom.iterator();
		Iterator<JComboBox> ruim = listRuim.iterator();

		int soma = 0;
		int value = 0;

		JComboBox text = null;
		while (bom.hasNext() || ruim.hasNext()){

			try{

				text = bom.next();
				value = ((Integer) text.getSelectedItem()).intValue();
				text.setBorder(null);
				soma += complexidade * value;
				text = ruim.next();
				text.setBorder(null);
				value = ((Integer) text.getSelectedItem()).intValue();
				soma += complexidade * value / 2;

			} catch (NumberFormatException e){
				e.printStackTrace();
				text.requestFocus();
				text.setBorder(BorderFactory.createLineBorder(Color.RED));
				break;
			} catch (Exception e){
				e.printStackTrace();
				System.exit(0);
			} finally{

			}

			if (soma > habilidade){
				labelTotal.setBorder(BorderFactory.createLineBorder(Color.RED));
			} else{
				labelTotal.setBorder(BorderFactory.createEmptyBorder());

			}
			labelTotal.setText(Integer.toString(soma));

		}

	}

	// =====================================================================================//
	/**
	 * Controlador de eventos dos botões. Verifica se os nomes foram inseridos e
	 * coloca-os no vetor de saída,
	 * */
	@Override
	public void actionPerformed(ActionEvent e){

		if (e.getActionCommand() == "OK"){
			getReturn();
			int soma = Integer.parseInt(labelTotal.getText());

			if (soma > habilidade){
				String messager = "Seu engenheiro tem menos habilidade do que é necessário para a tarefa. \n"
						+ "" + "Reduza a quantidade de artefatos.";
				String title = "Excesso de artefatos";
				JOptionPane.showMessageDialog(null, messager, title,
						JOptionPane.WARNING_MESSAGE);
				returnOk = false;

			} else{
				returnOk = true;
				ScreenChooseArtefacts.this.dispose();

			}

		}

	}

	// =====================================================================================//
	/**
	 * Retorna os modulos com os artefatos a serem produzidos.
	 * 
	 * @return Modulo[] = vetor com 2 modulos, o primeiro com arte fatos bons e
	 *         o segundo com os artefatos ruins.
	 */
	public Modulo[] getReturn(){

		Modulo[] pedidoArtefatos = new Modulo[2];
		int bons = ScreenInteraction.ARTEFATOS_BONS;
		int ruins = ScreenInteraction.ARTEFATOS_RUINS;

		pedidoArtefatos[bons] = new Modulo();
		pedidoArtefatos[ruins] = new Modulo();

		Iterator<JComboBox> bom = listBom.iterator();
		Iterator<JComboBox> ruim = listRuim.iterator();

		JComboBox text = null;

		int value = 0;
		
		while (bom.hasNext()){

			text = bom.next();
			value = ( returnOk? ((Integer) text.getSelectedItem()).intValue(): 0 );

			if (text.getName() == "Requisitos"){
				pedidoArtefatos[bons].setRequisitos(value);
			} else if (text.getName() == "Desenhos"){
				pedidoArtefatos[bons].setDesenhos(value);
			} else if (text.getName() == "Código"){
				pedidoArtefatos[bons].setCodigos(value);
			} else if (text.getName() == "Rastros"){
				pedidoArtefatos[bons].setRastros(value);
			} else if (text.getName() == "Ajudas"){
				pedidoArtefatos[bons]
						.setAjudas(value);
			}

		}

		while (ruim.hasNext()){

			text = ruim.next();
			value = ( returnOk? ((Integer) text.getSelectedItem()).intValue(): 0 );
			
			if (text.getName() == "Requisitos"){
				pedidoArtefatos[ruins].setRequisitos(value);

			} else if (text.getName() == "Desenhos"){
				pedidoArtefatos[ruins].setDesenhos(value);

			} else if (text.getName() == "Código"){
				pedidoArtefatos[ruins].setCodigos(value);

			} else if (text.getName() == "Rastros"){
				pedidoArtefatos[ruins].setRastros(value);

			} else if (text.getName() == "Ajudas"){
				pedidoArtefatos[ruins].setAjudas(value);

			}

		}

		return pedidoArtefatos;
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
	public static ScreenChooseArtefacts createAndShowChooseArtefacts(
			String message, Modulo[] modulo,int complexidade, int habilidade){

		// Cria e configura a tela.
		ScreenChooseArtefacts scr = new ScreenChooseArtefacts(message,
				modulo, complexidade, habilidade);
		scr.rootPane.setOpaque(true);
		scr.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		scr.setPreferredSize(new Dimension(400, 300));
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
				Modulo modulo[] = new Modulo[2];
				modulo[0] = new Modulo();
				modulo[1] = new Modulo();

				modulo[0].setAjudas(2);
				modulo[0].setCodigos(3);
				modulo[0].setRastros(0);
				modulo[0].setRequisitos(1);
				modulo[1].setAjudas(3);
				modulo[1].setCodigos(1);
				modulo[1].setRastros(4);
				modulo[1].setRequisitos(0);
				Modulo[] retorno = (createAndShowChooseArtefacts(
						"Selecione os artefatos a serem produzidos.",
						null,4, 7).getReturn());

				System.out.println(retorno[0].toString());
				System.out.println(retorno[1].toString());
				
				retorno = (createAndShowChooseArtefacts(
						"Selecione os artefatos a serem inspecionados.",
						modulo,-1, 7).getReturn());

				System.out.println(retorno[0].toString());
				System.out.println(retorno[1].toString());
			}
		});

	}

}// Fim da classe
// ===========================================================================//
// ===================Fim da classe ScreenInspectArtefacts====================//
//===========================================================================//


