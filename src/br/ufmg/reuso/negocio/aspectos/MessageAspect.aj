

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
	 
	pointcut sortearArtefato(Artefato cArt) : call (void Artefato.mostrarArtefato())  && target(cArt);
	
	after(Artefato cArt) : sortearArtefato(cArt){
		if (cArt.inspected() == true){
			String message = "\nQualidade do artefato: " + cArt.getQualidadeArtefato();
			message += "\n\nPossui bug: " + cArt.isArtefatoBug();
			JOptionPane.showMessageDialog(null, message, "[AOSD] SimulES", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
}
