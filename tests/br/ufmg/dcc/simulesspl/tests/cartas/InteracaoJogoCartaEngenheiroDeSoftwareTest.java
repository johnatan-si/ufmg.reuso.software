/**
 * 
 */
package br.ufmg.dcc.simulesspl.tests.cartas;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.ufmg.reuso.negocio.baralho.BaralhoCartas;
import br.ufmg.reuso.negocio.carta.Carta;
import br.ufmg.reuso.negocio.carta.CartaEngenheiro;
import br.ufmg.reuso.negocio.carta.CartaoProjeto;
import br.ufmg.reuso.negocio.jogador.Jogador;
import br.ufmg.reuso.negocio.jogo.ModeGameConstants;
import junit.framework.TestCase;

/**
 * @author alcemir
 *
 */
public class InteracaoJogoCartaEngenheiroDeSoftwareTest extends TestCase{

	public static final int BARALHO_PRINCIPAL = 0;
	public static final int BARALHO_AUXILIAR = 1;
	public static final String DIFICIL = "dificil";
	
	private CartaoProjeto projeto = null;
	private String nomeJogador = null;
	private Jogador jogador = null;
	private BaralhoCartas[] baralhoCartas = null;
	private int[] cartasConceito, cartasProblema;
	
	@Before
	public void setUp() throws Exception{
		
		baralhoCartas = new BaralhoCartas[2]; 
		cartasConceito = cartasProblema = new int[1];
		cartasConceito[0] = ModeGameConstants.ALL_CARDS_CONCEITO;
		cartasProblema[0] = ModeGameConstants.ALL_CARDS_PROBLEMA;
		
		baralhoCartas[BARALHO_PRINCIPAL] = new BaralhoCartas(DIFICIL, cartasConceito, cartasProblema);
		baralhoCartas[BARALHO_AUXILIAR] = new BaralhoCartas(baralhoCartas[BARALHO_PRINCIPAL]);
		
		projeto = new CartaoProjeto(DIFICIL);
		nomeJogador = "Tester";
		jogador = new Jogador(nomeJogador, projeto.getOrcamento());
	}
	
	@Test
	public void testInserirEngenheiroInicial(){
		Random sorteioEngenheiro = new Random();
		Carta novato=null;
		int numeMesa = 0;
		
		assertNull("Já existe um engenheiro na mesa.",jogador.getTabuleiro().getMesas()[0].getCartaMesa());
		
		while (novato == null){
			int sorteado = sorteioEngenheiro.nextInt(baralhoCartas[BARALHO_PRINCIPAL].getNumeroTotalEngenheiro());		
			novato = baralhoCartas[BARALHO_PRINCIPAL].darCartaInicial(sorteado);											
		}
		jogador.contratarEngenheiro(novato, numeMesa);
		
		assertNotNull("Deveria existir um engenheiro na mesa "+numeMesa,jogador.getTabuleiro().getMesas()[numeMesa]);
	}
	
	@Test
	public void testAdmitirengenheiro(){
		int numMesa = 0;
		CartaEngenheiro novoEngenheiro = new CartaEngenheiro("ES01", "Experiente", "Antoin", 50, 3, 3);
		
		assertNull("Já existe um engenheiro na mesa.",jogador.getTabuleiro().getMesas()[0].getCartaMesa());
		
		jogador.contratarEngenheiro(novoEngenheiro, numMesa);
		
		assertEquals("Deveria existir na mesa "+numMesa+" um engenheiro de chamado"+novoEngenheiro.getNomeEngenheiro()
				, novoEngenheiro, jogador.getTabuleiro().getMesas()[numMesa].getCartaMesa());
		
	}
	
	
	@Test
	public void testDespedirEngenheiro(){
		int numMesa = 0;
		CartaEngenheiro engenheiroInutil = new CartaEngenheiro("ES01", "Experiente", "Zezin", 60, 2, 4);
		
		jogador.contratarEngenheiro(engenheiroInutil, numMesa);
		
		assertEquals("Deveria existir na mesa "+numMesa+" um engenheiro de chamado"+engenheiroInutil.getNomeEngenheiro()
				, engenheiroInutil, jogador.getTabuleiro().getMesas()[numMesa].getCartaMesa());
		
		jogador.removerCarta(engenheiroInutil);
		
		assertNull("Não deveria existir um engenheiro de chamado"+engenheiroInutil.getNomeEngenheiro()+" na mesa "+numMesa
				, jogador.getTabuleiro().getMesas()[numMesa].getCartaMesa());
		
	}

	@After
	public void tearDown() throws Exception{
		
	}

}
