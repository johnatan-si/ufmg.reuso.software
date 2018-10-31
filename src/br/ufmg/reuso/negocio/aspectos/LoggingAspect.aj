/*
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * Simules-SPL Project
 *
 * Created by Charles / Pedro / Salatiel / Suelen
 * Date: 14/11/2014
 */

package br.ufmg.reuso.negocio.aspectos;

/*
 * Aspecto responsável pelas mensagens exibidas (logging)
 */

import javax.swing.JOptionPane;

import br.ufmg.reuso.negocio.carta.Artefato;
import br.ufmg.reuso.negocio.dado.Dado;
import br.ufmg.reuso.negocio.jogo.Jogo;

public aspect LoggingAspect{
		
	// ***** pointcut iniciouJogo ****************************************************** //
	
	pointcut iniciouJogo() : call(void Jogo.start(..) );
	
	before() : iniciouJogo(){
		JOptionPane.showMessageDialog( null,					// posicao default, no centro da tela
				"Início do Jogo - SimulES\n >> Grupo G3 <<",	// mensagem a ser exibida
				"[AS] - SimulES - G3",					// titulo da janela
				JOptionPane.INFORMATION_MESSAGE);				// tipo do icone a ser exibido
	}
	
	// ***** pointcut criouJogador ****************************************************** //
	
	pointcut criouJogador() : call(void Jogo.cadastrarJogadores(..) );
	
	after() : criouJogador(){
		JOptionPane.showMessageDialog( null,
				"Jogadores criados com sucesso!",
				"[AS] - Jogadores Criados!",
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	// ***** pointcut jogouDado ******************************************************** //
	
	pointcut jogouDado(Dado d) : call (* Dado.sortearValor() ) && target(d);
	
	after(Dado d) returning : jogouDado(d){
		JOptionPane.showMessageDialog( null,
				"Resultado obtido no dado: " + d.sortearValor(),
				"[AS] - Dado Jogado",
				JOptionPane.INFORMATION_MESSAGE);
	}
	
	after(Dado d) throwing : jogouDado(d){
		JOptionPane.showMessageDialog( null,
				"ERRO: Nenhum resultado obtido no dado!",
				"[AS] - ERRO ao Jogar o Dado",
				JOptionPane.ERROR_MESSAGE);
	}
	
	// ***** pointcut sorteouArtefato ************************************************** //
	
	pointcut sorteouArtefato(Artefato cArt) : call (void Artefato.mostrarArtefato() ) 
						  && target(cArt);
	
	after(Artefato cArt) : sorteouArtefato(cArt){
		
		if (cArt.inspected() == true){
			JOptionPane.showMessageDialog( null,
				".Artefato ruim? " + cArt.isPoorQuality() + "\n.Possui bug? " + cArt.isBug(),
				"[AS] - Artefato sorteado!",
				JOptionPane.INFORMATION_MESSAGE);
		}
	}
}