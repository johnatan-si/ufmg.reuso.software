/**
 * 
 */
package br.ufmg.dcc.simulesspl.tests.cartas;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

import org.junit.Before;
import org.junit.Test;

import br.ufmg.reuso.negocio.carta.CartaEngenheiro;
import br.ufmg.reuso.negocio.jogo.Jogo;
import br.ufmg.reuso.negocio.mesa.Mesa;
import br.ufmg.reuso.negocio.tabuleiro.Tabuleiro;
import junit.framework.TestCase;

/**
 * @author alcemir
 *
 */
public class InteracaoTabuleiroCartaEngenheiroTest extends TestCase {
	private Jogo jogo;
	private Tabuleiro tabuleiro;
	CartaEngenheiro novato;
	int numMesa;

	@Before
	public void setUp(){
		this.jogo = Jogo.getJogo();
		this.jogo.mockinit();
		this.tabuleiro = new Tabuleiro();
		this.novato = new CartaEngenheiro("ES01", "Experiente", "Zezin", 60, 2, 4);
		this.numMesa = 0;
	}
	
	
	@Test
	public void testAlocarMesa(){

		assertThat("Não é uma instancia de mesa no tabuleiro!",tabuleiro.getMesas()[numMesa], is(instanceOf(Mesa.class)));
		assertNull("Já existe um engenheiro alocado na mesa "+numMesa,tabuleiro.getMesas()[numMesa].getCartaMesa());
		tabuleiro.alocarMesa(novato, numMesa);
		assertThat("O engenheiro alocado na mesa é diferente do esperado!",tabuleiro.getMesas()[numMesa].getCartaMesa(), is(equalTo(novato)));
		
	}
	
	@Test
	public void testDespedirEngenheiro(){
		tabuleiro.alocarMesa(novato, numMesa);
		
		assertNotNull("Não existe um engenheiro alocado na mesa "+numMesa,tabuleiro.getMesas()[numMesa].getCartaMesa());
		assertEquals("O enegheiro alocado na mesa é diferente do esperado.",tabuleiro.getMesas()[numMesa].getCartaMesa(), novato);
		
		boolean result = tabuleiro.despedirEngenheiro(novato);
		
		assertTrue("Não foi possível demitir o engenheiro!",result);
		assertNull("Existe um engenheiro alocado na mesa "+numMesa,tabuleiro.getMesas()[numMesa].getCartaMesa());
		
	}
	
	@Test
	public void testDespedirEngenheiroQueTrabalhou(){
		novato.setEngenheiroTrabalhouNestaRodada(true);
		tabuleiro.alocarMesa(novato, numMesa);
		
		assertNotNull("Não existe um engenheiro alocado na mesa "+numMesa,tabuleiro.getMesas()[numMesa].getCartaMesa());
		assertEquals("O enegheiro alocado na mesa é diferente do esperado.",tabuleiro.getMesas()[numMesa].getCartaMesa(), novato);
		
		boolean result = tabuleiro.despedirEngenheiro(novato);
		
		assertFalse("O engenheiro foi demitido com sucesso!",result);
		assertNotNull("Não existe um engenheiro alocado na mesa "+numMesa,tabuleiro.getMesas()[numMesa].getCartaMesa());
		
	}
	
	@Test
	public void testDespedirEngenheiroQueNaoExiste(){
		CartaEngenheiro engenheiroEstranho = new CartaEngenheiro("ES02", "Inexperiente", "Zoiãos", 60, 2, 4);		
		tabuleiro.alocarMesa(novato, numMesa);
		
		assertNotNull("Não existe um engenheiro alocado na mesa "+numMesa,tabuleiro.getMesas()[numMesa].getCartaMesa());
		assertEquals("O enegheiro alocado na mesa é diferente do esperado.",tabuleiro.getMesas()[numMesa].getCartaMesa(), novato);
		
		boolean result = tabuleiro.despedirEngenheiro(engenheiroEstranho);
		
		assertFalse("O engenheiro foi demitido com sucesso!",result);
		assertNotNull("Não existe um engenheiro alocado na mesa "+numMesa,tabuleiro.getMesas()[numMesa].getCartaMesa());
		
	}
}
