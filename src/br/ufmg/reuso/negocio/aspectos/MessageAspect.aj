/*
 * Criado por: Aline Brito, Igor Muzetti (2018-2).
 * Aspecto responsável por exibir janelas com informações ou avisos para os usuários.
 */

import javax.swing.JOptionPane;

import br.ufmg.reuso.negocio.carta.Artefato;
import br.ufmg.reuso.negocio.jogo.Jogo;

public aspect MessageAspect {

	// Aspecto para exibir janela com informações sobre o grupo para início do Jogo. 
	// Executado antes da chamada ao método Jogo.start(..)

	pointcut iniciarJogo() : call(void Jogo.start(..) );

	before() : iniciarJogo(){
		String mensagem = "\nDisciplina: Reuso de Sofware, DCC/UFMG";
		mensagem += "\nProfessor: Eduardo Figueiredo";
		mensagem += "\n\nGrupo: G1";
		mensagem += "\nAlunos: Aline Brito, Igor Muzetti";
		JOptionPane.showMessageDialog(null, mensagem, "[AOSD] SimulES", JOptionPane.INFORMATION_MESSAGE);
	}
	
	// Aspecto para exibir qualidade do artefato inspecionado.
	// Executado após da chamada ao método Artefato.mostrarArtefato()
	 
	pointcut mostrarArtefato(Artefato artefato) : call (void Artefato.mostrarArtefato())  && target(artefato);
	
	after(Artefato artefato) : mostrarArtefato(artefato){
		if (artefato.inspected() == true){
			String message = "\nQualidade do artefato: " + artefato.getQualidadeArtefato();
			message += "\n\nPossui bug: " + artefato.isArtefatoBug();
			JOptionPane.showMessageDialog(null, message, "[AOSD] SimulES", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
}
