package br.ufmg.reuso.apresentacao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.ufmg.reuso.negocio.jogador.Jogador;
//import serializacao.AppSerializacao;

public class ScreenChangePlayer extends JDialog{


	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private Jogador jogador = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args){
		try{
			ScreenChangePlayer dialog = new ScreenChangePlayer(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e){
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ScreenChangePlayer(Jogador jogador){
		if(jogador == null){
			jogador = new Jogador("Nulo", 0);			
		}
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.NORTH);
		{
			JLabel lblJogador = new JLabel("Resmo do Jogador:");
			lblJogador.setForeground(Color.GRAY);
			lblJogador.setFont(new Font("Tahoma", Font.BOLD, 14));
			contentPanel.add(lblJogador);
		}
		{
			JLabel lblNomejogador = new JLabel(jogador.getNome());
			lblNomejogador.setFont(new Font("Tahoma", Font.BOLD, 14));
			contentPanel.add(lblNomejogador);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton btnSalvar = new JButton("Salvar");
				btnSalvar.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e){
//						AppSerializacao.serializaJogo(Jogo.getJogo(), "D:\\jogo.ser");
					}
				});
				buttonPane.add(btnSalvar);
			}
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent arg0){
						ScreenChangePlayer.this.dispose();						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
		}
		{
			JPanel centerPane = new JPanel();
			getContentPane().add(centerPane, BorderLayout.CENTER);
			GridBagLayout gbl_centerPane = new GridBagLayout();
			gbl_centerPane.columnWidths = new int[]{127, 99, 76, 0};
			gbl_centerPane.rowHeights = new int[]{14, 0, 0};
			gbl_centerPane.columnWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
			gbl_centerPane.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			centerPane.setLayout(gbl_centerPane);
			{
				JLabel lblMdulosIntegrados = new JLabel("M�dulos Integrados:");
				GridBagConstraints gbc_lblMdulosIntegrados = new GridBagConstraints();
				gbc_lblMdulosIntegrados.anchor = GridBagConstraints.NORTHEAST;
				gbc_lblMdulosIntegrados.insets = new Insets(0, 0, 5, 5);
				gbc_lblMdulosIntegrados.gridx = 0;
				gbc_lblMdulosIntegrados.gridy = 0;
				centerPane.add(lblMdulosIntegrados, gbc_lblMdulosIntegrados);
			}
			{
				JLabel lblNumeromodulos = new JLabel(Integer.toString(jogador.contarModuloJaIntegrado()));
				GridBagConstraints gbc_lblNumeromodulos = new GridBagConstraints();
				gbc_lblNumeromodulos.insets = new Insets(0, 0, 5, 5);
				gbc_lblNumeromodulos.anchor = GridBagConstraints.NORTHWEST;
				gbc_lblNumeromodulos.gridx = 1;
				gbc_lblNumeromodulos.gridy = 0;
				centerPane.add(lblNumeromodulos, gbc_lblNumeromodulos);
			}
			{
				JLabel lblSaldo = new JLabel("Saldo:");
				GridBagConstraints gbc_lblSaldo = new GridBagConstraints();
				gbc_lblSaldo.anchor = GridBagConstraints.EAST;
				gbc_lblSaldo.insets = new Insets(0, 0, 0, 5);
				gbc_lblSaldo.gridx = 0;
				gbc_lblSaldo.gridy = 1;
				centerPane.add(lblSaldo, gbc_lblSaldo);
			}
			{
				JLabel lblValorsaldo = new JLabel(Integer.toString(jogador.getSaldo()));
				GridBagConstraints gbc_lblValorsaldo = new GridBagConstraints();
				gbc_lblValorsaldo.insets = new Insets(0, 0, 0, 5);
				gbc_lblValorsaldo.anchor = GridBagConstraints.WEST;
				gbc_lblValorsaldo.gridx = 1;
				gbc_lblValorsaldo.gridy = 1;
				centerPane.add(lblValorsaldo, gbc_lblValorsaldo);
			}
		}
	}

}
