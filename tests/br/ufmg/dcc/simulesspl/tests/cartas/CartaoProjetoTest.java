package br.ufmg.dcc.simulesspl.tests.cartas;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.ufmg.reuso.negocio.carta.CartaoProjeto;
import br.ufmg.reuso.negocio.jogo.Jogo;
import br.ufmg.reuso.negocio.mesa.Modulo;

public class CartaoProjetoTest{
	
	private CartaoProjeto cartao = null;

	@Before
	public void setUp() throws Exception{
		cartao = new CartaoProjeto(Jogo.DIFICIL);
	}

	@After
	public void tearDown() throws Exception{
		cartao = null;
	}

	@Test
	public void testCartaoProjeto(){
		cartao = new CartaoProjeto(Jogo.DIFICIL);
		assertNotNull(cartao);
	}
	
	@Test
	public void testDefinirProjetoFacil(){
		cartao.definirProjeto(Jogo.FACIL);
		assertEquals(2, cartao.getComplexidade());
	}
	
	@Test
	public void testDefinirProjetoModerado(){
		cartao.definirProjeto(Jogo.MODERADO);
		assertEquals(2, cartao.getComplexidade());
	}

	@Test
	public void testDefinirProjetoDificil(){		
		cartao.definirProjeto(Jogo.DIFICIL);
		assertEquals(4, cartao.getComplexidade());
	}


	@Test
	public void testSetComplexidade(){
		cartao.setComplexidade(8);
		assertEquals(8,cartao.getComplexidade());
	}
	
	@Test
	public void testGetComplexidade(){
		cartao.setComplexidade(8);		
		assertEquals(8,cartao.getComplexidade());
	}

	@Test
	public void testSetTamanho(){
		cartao.setTamanho(5);
		assertEquals(5,cartao.getTamanho());
	}

	@Test
	public void testGetTamanho(){
		cartao.setTamanho(5);
		assertEquals(5,cartao.getTamanho());
	}

	@Test
	public void testSetQualidade(){
		cartao.setQualidade(2);
		assertEquals(2,cartao.getQualidade());
	}
	
	@Test
	public void testGetQualidade(){
		cartao.setQualidade(2);
		assertEquals(2,cartao.getQualidade());
	}

	@Test
	public void testGetOrcamento(){
		cartao.setOrcamento(200);
		assertEquals(200,cartao.getOrcamento());
	}

	@Test
	public void testSetOrcamento(){
		cartao.setOrcamento(100);
		assertEquals(100,cartao.getOrcamento());
	}
	
	@Test
	public void testSetTexto(){
		cartao.setTexto("Testo de teste");		
		assertEquals("Testo de teste",cartao.getTexto());
	}
	
	@Test
	public void testGetTexto(){
		cartao.setTexto("Testo de teste");		
		assertEquals("Testo de teste",cartao.getTexto());
	}
	
	@Test
	public void testGetCodigo(){
		cartao.setCodigo("2n2");
		assertEquals("2n2", cartao.getCodigo());
	}

	@Test
	public void testSetCodigo(){
		cartao.setCodigo("2n3");
		assertEquals("2n3", cartao.getCodigo());
	}

	@Test
	public void testGetTitulo(){
		cartao.setTitulo("Not yet implemented");
		assertEquals("Not yet implemented", cartao.getTitulo());
	}

	@Test
	public void testSetTitulo(){
		cartao.setTitulo("Not yet implemented");
		assertEquals("Not yet implemented", cartao.getTitulo());
	}

	@Test
	public void testGetReferenciaBibliografica(){
		cartao.setReferenciaBibliografica("Not yet implemented");
		assertEquals("Not yet implemented", cartao.getReferenciaBibliografica());
	}

	@Test
	public void testSetReferenciaBibliografica(){
		cartao.setReferenciaBibliografica("Not yet implemented");
		assertEquals("Not yet implemented", cartao.getReferenciaBibliografica());
	}

	@Test
	public void testGetModulos(){
		Modulo[] modulos = new Modulo[5];
		for (int i=0;i<modulos.length;i++)
			modulos[i] = new Modulo();
		
		cartao.setModulos(modulos);
		
		assertNotNull(cartao.getModulos());
		assertEquals(5, cartao.getModulos().length);
	}

	@Test
	public void testSetModulos(){
		Modulo[] modulos = new Modulo[5];
		for (int i=0;i<modulos.length;i++)
			modulos[i] = new Modulo();
		
		cartao.setModulos(modulos);
		
		assertNotNull(cartao.getModulos());
		assertEquals(5, cartao.getModulos().length);
				
	}

}
