package br.ufmg.reuso.ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

import br.ufmg.reuso.negocio.carta.Carta;
//#ifdef ConceptCard
import br.ufmg.reuso.negocio.carta.CartaBonificacao;
//#endif
import br.ufmg.reuso.negocio.carta.CartaEngenheiro;
import br.ufmg.reuso.negocio.carta.CartaPenalizacao;

//=====================================================================================//
//===================================Inicio da classe ScreenCard=======================//
//=====================================================================================//

/**
 * @author Alisson
 * 
 * 
 *         Classe que mostra em uma janela separada uma determinada carta.
 * 
 */
public class ScreenCard extends JDialog{

	private static final long serialVersionUID = 1L;

	// Valor de retorno do JDialog
	private int actionReturn;

	public static final int USE = 0;
	public static final int DISCARD = 1;
	public static final int BACK = 2;

	private ComponentCard componentCard = null;

	// =====================================================================================//

	/**
	 * Cria a janela que mostrará a carta.
	 * 
	 * @param carta
	 *            representa a carta no jogo que devera ser pintada
	 * 
	 * @param tabuleiro
	 *            o GUI que representa o tabuleiro. Pode ser obtido pelo metodo
	 *            ScreenInteraction.getTabuleiro()
	 * 
	 */
	public ScreenCard(Carta carta, ScreenTabuleiro tabuleiro){

		actionReturn = BACK;

		getContentPane().setLayout(new BorderLayout());

		this.componentCard = new ComponentCard(carta, tabuleiro);
		{

			add(componentCard, BorderLayout.CENTER);
		}

		add(getButtonPane(), BorderLayout.SOUTH);

	}

	// =====================================================================================//
	/**
	 * @return JPanel com os botões abaixo da carta
	 */
	private JPanel getButtonPane(){
		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new GridLayout(0, 3, 0, 0));
		Font font = new Font("Default", Font.PLAIN, 9);
		{
			JButton buttonUse = new JButton("Usar");
			buttonUse.setActionCommand("Usar");
			buttonUse.addActionListener(getActionListener());
			buttonUse.setFont(font);
			buttonPane.add(buttonUse);
		}
		{
			JButton buttonDiscard = new JButton("Descartar");
			buttonDiscard.setFont(font);
			buttonDiscard.addActionListener(getActionListener());
			buttonDiscard.setActionCommand("Descartar");
			buttonPane.add(buttonDiscard);

		}
		{
			JButton closeButton = new JButton("Voltar");
			closeButton.setFont(font);
			closeButton.addActionListener(getActionListener());
			closeButton.setActionCommand("Voltar");
			buttonPane.add(closeButton);
			// this.setDefaultButton(closeButton);
		}

		return buttonPane;
	}

	// =====================================================================================//
	/**
	 * @return ActionListener responsável pelo controle dos botões
	 */
	private ActionListener getActionListener(){
		ActionListener action = new ActionListener(){

			public void actionPerformed(ActionEvent e){
				if (e.getActionCommand() == "Usar"){
					System.out.println("Usar");
					actionReturn = USE;
				} else if (e.getActionCommand() == "Descartar"){
					System.out.println("Descartar");
					actionReturn = DISCARD;
				} else if (e.getActionCommand() == "Voltar"){
					System.out.println("Voltar");
					actionReturn = BACK;
				}
				ScreenCard.this.dispose();

			}
		};
		return action;
	}

	// =====================================================================================//

	/**
	 * @return um inteiro representado a escolha realizada.
	 * 
	 *         USE = 0; DISCARD = 1; BACK = 2;
	 * 
	 */
	protected int getReturn(){
		return actionReturn;
	}

	public static ScreenCard createAndShowCard(Carta carta,
			ScreenTabuleiro tabuleiro){

		// Cria e configura a tela.
		ScreenCard scr = new ScreenCard(carta, tabuleiro);
		scr.rootPane.setOpaque(true);
		scr.pack();
		scr.setTitle("Simules");
		scr.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		scr.setModal(true);
		scr.setLocationRelativeTo(null);
		scr.setVisible(true);

		return scr;
	}

	// =====================================================================================//

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

				System.out
						.println(createAndShowCard(
								new CartaEngenheiro(
										"ES30",
										"Doutor em Ciência da Computação e 10 anos de experiência. Excelente relacionamento.",
										"Jader", 110, 5, 5), tabuleiro)
								.getReturn());

				System.out
						.println(createAndShowCard(
								new CartaPenalizacao(
										"Replicação de Código",
										"CD12",
										"O jogador perde 1 artefato de código.",
										"[Fowler 1999, cap. 3] [Jacobson et al. 1997][Jacobson et al. 1997][Jacobson et al. 1997][Jacobson et al. 1997][Jacobson et al. 1997][Jacobson et al. 1997][Jacobson et al. 1997]",
										1,
										"Mesa do jogador com bugs em artefatos de código e de rastro.",
										1, 0, 1, 0, 26, 0, 0, 0), tabuleiro)
								.getReturn());

				//#ifdef ConceptCard
				System.out.println(createAndShowCard(
								new CartaBonificacao(
										"Gerador de Código",
										"CCD3",
										"Benefício Permanente: Use essa carta para adicionar, em cada rodada, Use essa carta para adicionar, em cada rodada, 1 Use essa carta para adicionar, em cada rodada, 1 Use essa carta para adicionar, em cada rodada, 1 Use essa carta para adicionar, em cada rodada, 1 Use essa carta para adicionar, em cada rodada, 1 Use essa carta para adicionar, em cada rodada, 1 1 artefato de código branco para um engenheiro.",
										"[Budinsky et al. 1996]", 10000, 10,
										19, 0, 1, 0), tabuleiro).getReturn());
				//#endif

			}
		});
	}

}
// =====================================================================================//
// Fim da classe ScreenCard
// =====================================================================================//
