package br.ufmg.dcc.simulesspl.tests.jogo;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import br.ufmg.reuso.apresentacao.ScreenInteraction;
import br.ufmg.reuso.negocio.jogo.Jogo;
import br.ufmg.reuso.negocio.tabuleiro.SetupInteraction;


/**
 * @author alcemir
 * 
 * Atualizado por Aline Brito, Igor Muzetti (2018-02).
 *
 */
public class JogoTest{

	private Jogo jogo;
	private SetupInteraction setupController;
	
	@Before
	public void setUp() throws Exception{
		jogo = Jogo.getJogo();
		setupController = ScreenInteraction.getScreenInteraction();
	}

	@Test
	public void testReturnGame(){
		assertEquals(jogo, Jogo.getJogo());	
	}
	
	@Test
	public void testReturnSetupController(){
		assertEquals(setupController,  ScreenInteraction.getScreenInteraction());
	}

	@Ignore
	@Test
	public void testRun(){//Este teste varia a cobertura dependendo do tanto que você
							//Queira continuar jogando o jogo		
		jogo.start(jogo);
		
		assertEquals(setupController,  ScreenInteraction.getScreenInteraction());
	}
	
	@After
	public void tearDown() throws Exception{
	
	}
}
