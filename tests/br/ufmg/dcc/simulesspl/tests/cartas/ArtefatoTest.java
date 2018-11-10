/*
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * Simules-SPL Project
 *
 * Created by Alisson
 * Date: 11/10/2011
 */
package br.ufmg.dcc.simulesspl.tests.cartas;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.ufmg.reuso.negocio.carta.Artefato;

/**
 * @author Alisson
 * 
 * Atualizado por Aline Brito, Igor Muzetti (2018-02).
 *
 */
public class ArtefatoTest{

	private Artefato artefato;
	boolean buged = true;
	boolean notBuged = false;	
	boolean bad = true;
	boolean notBad = false;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception{
		artefato = new Artefato(buged, bad);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception{
		artefato = null;
	}

	/**
	 * Test method for{@link cartas.Artefato#Artefato(boolean, boolean)}.
	 */
	@Test
	public void testArtefato(){
		assertNotNull(artefato);		
	}

	/**
	 * Test method for{@link cartas.Artefato#isBug()}.
	 */
	@Test
	public void testIsBug(){
		assertTrue(artefato.isBug());
	}

	/**
	 * Test method for{@link cartas.Artefato#setBug(boolean)}.
	 */
	@Test
	public void testSetBug(){
		artefato.setBug(notBuged);
		assertFalse(artefato.isBug());
		
	}

	/**
	 * Test method for{@link cartas.Artefato#isPoorQuality()}.
	 */
	@Test
	public void testIsPoorQuality(){
		assertTrue(artefato.isPoorQuality());		
	}

	/**
	 * Test method for{@link cartas.Artefato#setQualidadeArtefatoRuim(boolean)}.
	 */
	@Test
	public void testSetQualidadeArtefatoRuim(){
		artefato.setQualidadeArtefatoRuim(notBad);
		assertFalse(artefato.isPoorQuality());		
	}

	/**
	 * Test method for{@link cartas.Artefato#inspected()}.
	 */
	@Test
	public void testInspected(){
		assertFalse(artefato.inspected());
	}

	/**
	 * Test method for{@link cartas.Artefato#setArtefatoInspecionado(boolean)}.
	 */
	@Test
	public void testSetArtefatoInspecionado(){
		artefato.setArtefatoInspecionado(true);
		assertTrue(artefato.inspected());
	}

}
