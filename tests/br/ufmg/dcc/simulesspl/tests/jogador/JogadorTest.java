package br.ufmg.dcc.simulesspl.tests.jogador;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import br.ufmg.reuso.negocio.carta.Carta;
import br.ufmg.reuso.negocio.carta.CartaEngenheiro;
import br.ufmg.reuso.negocio.jogador.Jogador;
import br.ufmg.reuso.negocio.tabuleiro.Tabuleiro;


/**
 * @author alcemir
 * 
 * Atualizado por Aline Brito, Igor Muzetti (2018-02).
 *
 */
public class JogadorTest{

	Jogador jogador;
	
	
	@Before
	public void setUp() throws Exception{
		jogador  = new Jogador(null, 0);
		
	}

	@After
	public void tearDown() throws Exception{
		jogador = null;
	}

	@Test
	public void testJogador(){
		assertNotNull(jogador);
	}

	@Test
	public void testContratarEngenheiro(){
		CartaEngenheiro cartaRecebida = new CartaEngenheiro(null, null, null, 0, 0, 0); 
		jogador.contratarEngenheiro(cartaRecebida ,1);
		assertTrue(jogador.removerCarta(cartaRecebida));
	}

	@Ignore
	@Test
	public void testAnalisarPontuacao(){

		int pontuacao = jogador.analisarPontuacao();		
		assertTrue(pontuacao <= 5);
		assertTrue(pontuacao >=0 );
	}
	
	@Test
	public void testReceberCarta(){
		Carta carta = new CartaEngenheiro(null, null, null, 0, 0, 0);
		int num = jogador.getNumeroCartasMaoAtual();
		jogador.receberCarta(carta);
		
		assertTrue(jogador.getNumeroCartasMaoAtual() == num + 1);
		
		
	}
	
	@Test
	public void testRetirarCarta(){
		Carta carta = new CartaEngenheiro(null, null, null, 0, 0, 0);
		int num = jogador.getNumeroCartasMaoAtual();
		jogador.receberCarta(carta);
		jogador.retirarCarta(carta);		
		assertTrue(jogador.getNumeroCartasMaoAtual() == num);
	}

	@Test
	public void testRemoverCarta(){
		CartaEngenheiro cartaRecebida =new CartaEngenheiro(null, null, null, 0, 0, 0); 
		jogador.contratarEngenheiro(cartaRecebida , 0);
		assertTrue(jogador.removerCarta(cartaRecebida));
	}

	@Test
	public void testMostrarCartaMao(){
		jogador.mostrarCartaMao();		
	}

	@Test
	public void testContarModuloJaIntegrado(){
		jogador.getTabuleiro().getMesas()[0].setModuloJaIntegrado(true)	;
		assertEquals(1, jogador.contarModuloJaIntegrado());		
	}

	@Test
	public void testGetTabuleiro(){
		
	}

	@Test
	public void testSetTabuleiro(){
		
		jogador.setTabuleiro(null);			
		assertNull(jogador.getTabuleiro());
		jogador.setTabuleiro(new Tabuleiro());
		assertNotNull(jogador.getTabuleiro());		
	}

	@Test
	public void testGetNumeroCartasMaoAtual(){
		Carta carta = new CartaEngenheiro(null, null, null, 0, 0, 0);
		int num = jogador.getNumeroCartasMaoAtual();
		jogador.receberCarta(carta);		
		assertTrue(jogador.getNumeroCartasMaoAtual() == num + 1);
	}

	@Test
	public void testSetNumeroCartasMaoAtual(){
		
		jogador.setNumeroCartasMaoAtual(5);
		
		assertEquals(5, jogador.getNumeroCartasMaoAtual());
		
	}

	@Test
	public void testGetNome(){
		jogador.setNome("Teste");
		assertEquals("Teste", jogador.getNome());
	}

	@Test
	public void testSetNome(){
		jogador.setNome("Teste");
		assertEquals("Teste", jogador.getNome());	
	}

	@Test
	public void testGetSaldo(){
		jogador.setSaldo(10);
		assertEquals(10, jogador.getSaldo());
	}

	@Test
	public void testSetSaldo(){
		jogador.setSaldo(10);
		assertEquals(10, jogador.getSaldo());
	}

	@Test
	public void testGetCartas(){
		Carta [] cartas = new Carta[5];
		cartas[0] = new CartaEngenheiro(null, null, null, 0, 0, 0);		
		jogador.setCartas(cartas);
		assertEquals(cartas, jogador.getCartas());		
	}

	@Test
	public void testSetCartas(){
		Carta [] cartas = new Carta[5];
		cartas[0] = new CartaEngenheiro(null, null, null, 0, 0, 0);		
		jogador.setCartas(cartas);
		assertEquals(cartas, jogador.getCartas());
	}

	@Test
	public void testIsDadoJogado(){
		jogador.setDadoJogado(true);
		assertTrue(jogador.isDadoJogado());
	}

	@Test
	public void testSetDadoJogado(){
		jogador.setDadoJogado(true);
		assertTrue(jogador.isDadoJogado());
	}

}
