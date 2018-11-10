package br.ufmg.dcc.simulesspl.tests.tabuleiro;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.ufmg.reuso.negocio.carta.CartaEngenheiro;
import br.ufmg.reuso.negocio.mesa.Mesa;
import br.ufmg.reuso.negocio.tabuleiro.Tabuleiro;

/**
 * 
 * Atualizado por Aline Brito, Igor Muzetti (2018-02).
 *
 */
public class TabuleiroTest{

	private Tabuleiro tabuleiro = null;
	@Before
	public void setUp() throws Exception{
		tabuleiro = new Tabuleiro();
	}

	@After
	public void tearDown() throws Exception{
		tabuleiro = null;
	}

	@Test
	public void testTabuleiro(){
		assertNotNull(tabuleiro);
	}

	@Test
	public void testAlocarMesa(){
		CartaEngenheiro novato = new CartaEngenheiro("2n1", "", "", 0, 2, 2);
		tabuleiro.alocarMesa(novato, 0);		
		assertNotNull(tabuleiro.getMesas()[0].getCartaMesa());		
	}

	@Test
	public void testDespedirEngenheiro(){
		CartaEngenheiro carta = new CartaEngenheiro("2n1", "", "", 0, 2, 2);
		tabuleiro.despedirEngenheiro(carta);			
		assertNull(tabuleiro.getMesas()[0].getCartaMesa());
	}

	@Test
	public void testGetMesas(){
		assertNotNull(tabuleiro.getMesas());
	}

	@Test
	public void testSetMesas(){
		
		Mesa[] mesas = new Mesa[8];
		for (int i = 0; i < 8; i++)
			mesas[i] = new Mesa();
		
		tabuleiro.setMesas(mesas);
		
		assertEquals(8, tabuleiro.getMesas().length);
		
	}

	@Test
	public void testGetEfeitoPositivoOrcamento(){				
		tabuleiro.setEfeitoPositivoOrcamento(100);
		int valor = tabuleiro.getEfeitoPositivoOrcamento();
		assertEquals(100, valor);
	}

	@Test
	public void testSetEfeitoPositivoOrcamento(){
		tabuleiro.setEfeitoPositivoOrcamento(100);
		int valor = tabuleiro.getEfeitoPositivoOrcamento();
		assertEquals(100, valor);
	}

	@Test
	public void testGetEfeitoAumentarHabilidadeEngenheiroLater(){
		tabuleiro.setEfeitoAumentarHabilidadeEngenheiroLater(null);
		assertEquals(null, tabuleiro.getEfeitoAumentarHabilidadeEngenheiroLater());
		
	}

	@Test
	public void testSetEfeitoAumentarHabilidadeEngenheiroLater(){
		tabuleiro.setEfeitoAumentarHabilidadeEngenheiroLater(null);
		assertEquals(null, tabuleiro.getEfeitoAumentarHabilidadeEngenheiroLater());
	}

	@Test
	public void testIsEfeitoModuloIntegradoNeutralizadoValidacao(){
		tabuleiro.setEfeitoModuloIntegradoNeutralizadoValidacao(true);
		assertTrue(tabuleiro.isEfeitoModuloIntegradoNeutralizadoValidacao());
	}

	@Test
	public void testSetEfeitoModuloIntegradoNeutralizadoValidacao(){
		tabuleiro.setEfeitoModuloIntegradoNeutralizadoValidacao(true);
		assertTrue(tabuleiro.isEfeitoModuloIntegradoNeutralizadoValidacao());
	}

	@Test
	public void testIsEfeitoHelpArtifactsNeutralizadoValidacao(){
		tabuleiro.setEfeitoHelpArtifactsNeutralizadoValidacao(true);
		assertTrue(tabuleiro.isEfeitoHelpArtifactsNeutralizadoValidacao());
	}

	@Test
	public void testSetEfeitoHelpArtifactsNeutralizadoValidacao(){
		tabuleiro.setEfeitoHelpArtifactsNeutralizadoValidacao(true);
		assertTrue(tabuleiro.isEfeitoHelpArtifactsNeutralizadoValidacao());
	}

	@Test
	public void testIsEfeitoProblemaArtefatoCodigoNeutralizado(){
		tabuleiro.setEfeitoProblemaArtefatoCodigoNeutralizado(true);
		assertTrue(tabuleiro.isEfeitoProblemaArtefatoCodigoNeutralizado());
	}

	@Test
	public void testSetEfeitoProblemaArtefatoCodigoNeutralizado(){
		tabuleiro.setEfeitoProblemaArtefatoCodigoNeutralizado(true);
		assertTrue(tabuleiro.isEfeitoProblemaArtefatoCodigoNeutralizado());
	}

	@Test
	public void testIsEfeitoProblemaArtefatoRastroNeutralizado(){
		tabuleiro.setEfeitoProblemaArtefatoRastroNeutralizado(true);
		assertTrue(tabuleiro.isEfeitoProblemaArtefatoRastroNeutralizado());
	}

	@Test
	public void testSetEfeitoProblemaArtefatoRastroNeutralizado(){
		tabuleiro.setEfeitoProblemaArtefatoRastroNeutralizado(true);
		assertTrue(tabuleiro.isEfeitoProblemaArtefatoRastroNeutralizado());
	}

	@Test
	public void testIsEfeitoProblemaArtefatoRequisitosNeutralizado(){
		tabuleiro.setEfeitoProblemaArtefatoRequisitosNeutralizado(true);
		assertTrue(tabuleiro.isEfeitoProblemaArtefatoRequisitosNeutralizado());
	}

	@Test
	public void testSetEfeitoProblemaArtefatoRequisitosNeutralizado(){
		tabuleiro.setEfeitoProblemaArtefatoRequisitosNeutralizado(true);
		assertTrue(tabuleiro.isEfeitoProblemaArtefatoRequisitosNeutralizado());
	}

	@Test
	public void testGetEfeitoAdicionaDificuldadeInspecionarArtefatos(){
		tabuleiro.setEfeitoAdicionaDificuldadeInspecionarArtefatos(2);
		assertEquals(2, tabuleiro.getEfeitoAdicionaDificuldadeInspecionarArtefatos());
	}

	@Test
	public void testSetEfeitoAdicionaDificuldadeInspecionarArtefatos(){
		tabuleiro.setEfeitoAdicionaDificuldadeInspecionarArtefatos(2);
		assertEquals(2, tabuleiro.getEfeitoAdicionaDificuldadeInspecionarArtefatos());
	}

	@Test
	public void testGetEfeitoAdicionaDificuldadeCorrigirArtefatos(){
		tabuleiro.setEfeitoAdicionaDificuldadeCorrigirArtefatos(2);
		assertEquals(2, tabuleiro.getEfeitoAdicionaDificuldadeCorrigirArtefatos());
	}

	@Test
	public void testSetEfeitoAdicionaDificuldadeCorrigirArtefatos(){
		tabuleiro.setEfeitoAdicionaDificuldadeCorrigirArtefatos(2);
		assertEquals(2, tabuleiro.getEfeitoAdicionaDificuldadeCorrigirArtefatos());
	}

	@Test
	public void testGetEfeitoAdicionaComplexidadeProjeto(){
		tabuleiro.setEfeitoAdicionaComplexidadeProjeto(2);
		assertEquals(2, tabuleiro.getEfeitoAdicionaComplexidadeProjeto());
	}

	@Test
	public void testSetEfeitoAdicionaComplexidadeProjeto(){
		tabuleiro.setEfeitoAdicionaComplexidadeProjeto(2);
		assertEquals(2, tabuleiro.getEfeitoAdicionaComplexidadeProjeto());
	}

	@Test
	public void testGetEfeitoAdicionaQualidadeProjeto(){
		tabuleiro.setEfeitoAdicionaQualidadeProjeto(2);
		assertEquals(2, tabuleiro.getEfeitoAdicionaQualidadeProjeto());
	}

	@Test
	public void testSetEfeitoAdicionaQualidadeProjeto(){
		tabuleiro.setEfeitoAdicionaQualidadeProjeto(2);
		assertEquals(2, tabuleiro.getEfeitoAdicionaQualidadeProjeto());
	}

	@Test
	public void testGetEfeitoDemitirEngenheiroLater(){
		tabuleiro.setEfeitoDemitirEngenheiroLater(null);
		assertNull(tabuleiro.getEfeitoDemitirEngenheiroLater());
	}

	@Test
	public void testSetEfeitoDemitirEngenheiroLater(){
		tabuleiro.setEfeitoDemitirEngenheiroLater(null);
		assertNull(tabuleiro.getEfeitoDemitirEngenheiroLater());
	}

	@Test
	public void testGetEfeitoNegativoOrcamento(){
		tabuleiro.setEfeitoNegativoOrcamento(200);
		assertEquals(200, tabuleiro.getEfeitoNegativoOrcamento());
	}

	@Test
	public void testSetEfeitoNegativoOrcamento(){
		tabuleiro.setEfeitoNegativoOrcamento(200);
		assertEquals(200, tabuleiro.getEfeitoNegativoOrcamento());
	}

}
