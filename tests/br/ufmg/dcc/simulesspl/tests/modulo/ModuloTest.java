/*
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * Simules-SPL Project
 *
 * Created by Alisson
 * Date: 10/10/2011
 */
package br.ufmg.dcc.simulesspl.tests.modulo;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.ufmg.reuso.negocio.mesa.Modulo;

/**
 * @author Alisson
 *
 */
public class ModuloTest{
	
	private Modulo modulo; 
	private int in = 5;
	private int out = 5;
	
	
	@Before
	public void setUp() throws Exception{
		modulo = new Modulo();
	}

	@Test
	public void testAjudas(){
		modulo.setAjudas(in);
		assertEquals(out,modulo.getAjudas());
	}
	@Test
	public void testCodigos(){
		modulo.setCodigos(in);
		assertEquals(out,modulo.getCodigos());
	}
	
	@Test
	public void testDesenhos(){
		modulo.setDesenhos(in);
		assertEquals(out,modulo.getDesenhos());
	}
	@Test
	public void testRastros(){
		modulo.setRastros(in);
		assertEquals(out,modulo.getRastros());
	}
	@Test
	public void testRequisitos(){
		modulo.setRequisitos(in);
		assertEquals(out,modulo.getRequisitos());		
	}
	@Test
	public void testTestes(){
		modulo.setTestes(in);
		assertEquals(out,modulo.getTestes());		
	}
	
	@Test
	public void testTotal(){		
		testAjudas();
		testCodigos();
		testDesenhos();
		testRastros();
		testRequisitos();	
		testTestes();
		assertEquals(5*out, modulo.somatorioModulo());
		System.out.println(modulo.toString());
	}
	
	
	@After
	public void tearDown() throws Exception{
	
	}

}
