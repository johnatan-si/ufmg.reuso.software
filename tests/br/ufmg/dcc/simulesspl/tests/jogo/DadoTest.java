package br.ufmg.dcc.simulesspl.tests.jogo;

import static org.junit.Assert.*;
import br.ufmg.reuso.negocio.dado.Dado;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DadoTest {

	Dado dado = null;
	int sup = 6;	
	int inf = 0;
	
			
	@Before
	public void setUp() throws Exception {
		dado = new Dado();
	}

	@After
	public void tearDown() throws Exception {		
	}

	@Test
	public void testSortearValorSuperior() {
		int valor = Dado.sortearValor();
		assertTrue(valor <= sup);				
	}
	
	@Test
	public void testSortearValorInferior() {
		int valor = Dado.sortearValor();		
		assertTrue(valor >= inf);		
	}

	@Test
	public void testContarPontosSuperior() {
		int valor = Dado.contarPontos();
		assertTrue(valor <= sup);		
	}
	
	@Test
	public void testContarPontosInferior() {
		int valor = Dado.contarPontos();		
		assertTrue(valor >= inf);
	}


}
