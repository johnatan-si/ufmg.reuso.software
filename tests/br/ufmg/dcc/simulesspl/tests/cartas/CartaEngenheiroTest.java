package br.ufmg.dcc.simulesspl.tests.cartas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.ufmg.reuso.negocio.carta.CartaEngenheiro;

public class CartaEngenheiroTest{
	
	CartaEngenheiro carta;
	
	@Before
	public void setUp() throws Exception{
		carta = new CartaEngenheiro("", "", "", 0, 0, 0);
		
	}

	@After
	public void tearDown() throws Exception{
		carta = null;
	}

	@Test
	public void testCartaEngenheiro(){
		assertNotNull(carta);		
	}

	@Test
	public void testGetNomeEngenheiro(){
		carta.setNomeEngenheiro("NomeTeste");
		assertEquals("NomeTeste", carta.getNomeEngenheiro());
	}

	@Test
	public void testSetNomeEngenheiro(){
		carta.setNomeEngenheiro("NomeTeste");
		assertEquals("NomeTeste", carta.getNomeEngenheiro());
	}

	@Test
	public void testGetSalarioEngenheiro(){
		carta.setSalarioEngenheiro(100);
		assertEquals(100, carta.getSalarioEngenheiro());
	}

	@Test
	public void testSetSalarioEngenheiro(){
		carta.setSalarioEngenheiro(100);
		assertEquals(100, carta.getSalarioEngenheiro());
	}

	@Test
	public void testGetHabilidadeEngenheiro(){
		carta.setHabilidadeEngenheiro(5);
		assertEquals(5, carta.getHabilidadeEngenheiro());
	}

	@Test
	public void testSetHabilidadeEngenheiro(){
		carta.setHabilidadeEngenheiro(5);
		assertEquals(5, carta.getHabilidadeEngenheiro());
	}

	@Test
	public void testGetMaturidadeEngenheiro(){
		carta.setMaturidadeEngenheiro(3);
		assertEquals(3, carta.getMaturidadeEngenheiro());
	}

	@Test
	public void testSetMaturidadeEngenheiro(){
		carta.setMaturidadeEngenheiro(3);
		assertEquals(3, carta.getMaturidadeEngenheiro());
	}

	@Test
	public void testIsEngenheiroTrabalhouNestaRodada(){
		carta.setEngenheiroTrabalhouNestaRodada(true);
		assertTrue(carta.isEngenheiroTrabalhouNestaRodada());
	}

	@Test
	public void testSetEngenheiroTrabalhouNestaRodada(){
		carta.setEngenheiroTrabalhouNestaRodada(true);
		assertTrue(carta.isEngenheiroTrabalhouNestaRodada());
	}

	@Test
	public void testGetHabilidadeEngenheiroAtual(){
		carta.setHabilidadeEngenheiroAtual(3);
		assertEquals(3, carta.getHabilidadeEngenheiroAtual());
	}

	@Test
	public void testSetHabilidadeEngenheiroAtual(){
		carta.setHabilidadeEngenheiroAtual(3);
		assertEquals(3, carta.getHabilidadeEngenheiroAtual());
	}

}
