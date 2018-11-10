/**
 * 
 */
package br.ufmg.dcc.simulesspl.tests.cartas;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.is;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.ufmg.reuso.apresentacao.ScreenChooseArtefacts;
import br.ufmg.reuso.negocio.carta.CartaEngenheiro;
import br.ufmg.reuso.negocio.jogador.Jogador;
import br.ufmg.reuso.negocio.jogo.Jogo;
import br.ufmg.reuso.negocio.mesa.Mesa;
import br.ufmg.reuso.negocio.mesa.Modulo;
import junit.framework.TestCase;
/**
 * @author alcemir
 * 
 * Atualizado por Aline Brito, Igor Muzetti (2018-02).
 *
 */
public class InteracaoJogoCartaArtefatoTest extends TestCase{

	private Jogo jogo=null;
	private Jogador jogador = null;
	private CartaEngenheiro engenheiroProduzindo = null;
	private int mesaTrabalho;
	
	@Before
	public void setUp() throws Exception{
		this.jogo = Jogo.getJogo();
		this.jogo.mockinit();
		
		this.jogador = new Jogador("Lazy", 250);
		this.engenheiroProduzindo = new CartaEngenheiro("ES01", "lascado","Tester", 70, 3, 3);
		this.mesaTrabalho=0;
	}
	
	@Test
	public void testEmbaralharCartasEArteafatos(){}
	
	@Test
	public void testInserirArtefatos(){
		
		jogador.contratarEngenheiro(engenheiroProduzindo, mesaTrabalho);
		
		int numRequisitos = jogador.getTabuleiro().getMesas()[mesaTrabalho].getRequisitos().size();
		int numDesenhos = jogador.getTabuleiro().getMesas()[mesaTrabalho].getDesenhos().size();
		int numCodigos = jogador.getTabuleiro().getMesas()[mesaTrabalho].getCodigos().size();
		int numRastros = jogador.getTabuleiro().getMesas()[mesaTrabalho].getRastros().size();
		int numAjudas = jogador.getTabuleiro().getMesas()[mesaTrabalho].getAjudas().size();
				
		jogo.inserirArtefato(jogador, engenheiroProduzindo, mesaTrabalho);
		
		int novoNumRequisitos = jogador.getTabuleiro().getMesas()[mesaTrabalho].getRequisitos().size();
		int novoNumDesenhos = jogador.getTabuleiro().getMesas()[mesaTrabalho].getDesenhos().size();
		int novoNumCodigos = jogador.getTabuleiro().getMesas()[mesaTrabalho].getCodigos().size();
		int novoNumRastros = jogador.getTabuleiro().getMesas()[mesaTrabalho].getRastros().size();
		int novoNumAjudas = jogador.getTabuleiro().getMesas()[mesaTrabalho].getAjudas().size();
		
		assertThat("O novo número de requisitos é menor que o anterior",novoNumRequisitos, is(greaterThanOrEqualTo(numRequisitos)));
		assertThat("O novo número de desenhos é menor que o anterior",novoNumDesenhos, is(greaterThanOrEqualTo(numDesenhos)));
		assertThat("O novo número de códigos é menor que o anterior",novoNumCodigos, is(greaterThanOrEqualTo(numCodigos)));
		assertThat("O novo número de rastros é menor que o anterior",novoNumRastros, is(greaterThanOrEqualTo(numRastros)));
		assertThat("A novo número de ajudas é menor que o anterior",novoNumAjudas, is(greaterThanOrEqualTo(numAjudas)));
	}
	
	@Test
	public void testInserirArtefatoRequisito(){
		
		Jogador jogador = new Jogador("Lazy", 250);
		CartaEngenheiro engenheiroProduzindo = new CartaEngenheiro("ES01", "lascado","Tester", 70, 3, 3);
		int mesaTrabalho=0;
		
		jogador.contratarEngenheiro(engenheiroProduzindo, mesaTrabalho);
		
		int numRequisitos = jogador.getTabuleiro().getMesas()[mesaTrabalho].getRequisitos().size();
				
		jogo.inserirArtefato(jogador, engenheiroProduzindo, mesaTrabalho);
		
		int novoNumRequisitos = jogador.getTabuleiro().getMesas()[mesaTrabalho].getRequisitos().size();
		
		assertThat("O novo número de requisitos é menor que o anterior",novoNumRequisitos, is(greaterThan(numRequisitos)));
	}
	
	@Test
	public void testInserirArtefatoRequisito2(){
		Mesa mesa = new Mesa();
		Modulo[] pedido = ScreenChooseArtefacts.createAndShowChooseArtefacts("", null, 2, 5).getReturn() ;
		
		int numRequisitos = mesa.getRequisitos().size();
		
		mesa.receberArtefatos(pedido, jogo.getBaralhoArtefatosBons(), jogo.getBaralhoArtefatosRuins());
		
		int novoNumRequisitos = mesa.getRequisitos().size();
		
		assertThat("O novo número de requisitos é menor que o anterior",novoNumRequisitos, is(greaterThan(numRequisitos)));
	}
	
	@Test
	public void testInserirArtefatoDesenho(){
		
		Jogador jogador = new Jogador("Lazy", 250);
		CartaEngenheiro engenheiroProduzindo = new CartaEngenheiro("ES01", "lascado","Tester", 70, 3, 3);
		int mesaTrabalho=0;
		
		jogador.contratarEngenheiro(engenheiroProduzindo, mesaTrabalho);
		
		int numDesenhos = jogador.getTabuleiro().getMesas()[mesaTrabalho].getDesenhos().size();
				
		jogo.inserirArtefato(jogador, engenheiroProduzindo, mesaTrabalho);
		
		int novoNumDesenhos = jogador.getTabuleiro().getMesas()[mesaTrabalho].getDesenhos().size();
		
		assertThat("O novo número de desenhos é menor que o anterior",novoNumDesenhos, is(greaterThan(numDesenhos)));
	}
	
	@Test
	public void testInserirArtefatoCodigo(){
		
		Jogador jogador = new Jogador("Lazy", 250);
		CartaEngenheiro engenheiroProduzindo = new CartaEngenheiro("ES01", "lascado","Tester", 70, 3, 3);
		int mesaTrabalho=0;
		
		jogador.contratarEngenheiro(engenheiroProduzindo, mesaTrabalho);
		
		int numCodigos = jogador.getTabuleiro().getMesas()[mesaTrabalho].getCodigos().size();
				
		jogo.inserirArtefato(jogador, engenheiroProduzindo, mesaTrabalho);
		
		int novoNumCodigos = jogador.getTabuleiro().getMesas()[mesaTrabalho].getCodigos().size();
		
		assertThat("O novo número de códigos é menor que o anterior",novoNumCodigos, is(greaterThan(numCodigos)));
	}
	
	@Test
	public void testInserirArtefatoRastro(){
		
		Jogador jogador = new Jogador("Lazy", 250);
		CartaEngenheiro engenheiroProduzindo = new CartaEngenheiro("ES01", "lascado","Tester", 70, 3, 3);
		int mesaTrabalho=0;
		
		jogador.contratarEngenheiro(engenheiroProduzindo, mesaTrabalho);
		
		int numRastros = jogador.getTabuleiro().getMesas()[mesaTrabalho].getRastros().size();
				
		jogo.inserirArtefato(jogador, engenheiroProduzindo, mesaTrabalho);
		
		int novoNumRastros = jogador.getTabuleiro().getMesas()[mesaTrabalho].getRastros().size();
		
		assertThat("O novo número de rastros é menor que o anterior",novoNumRastros, is(greaterThan(numRastros)));
	}
	
	@Test
	public void testInserirArtefatoAjuda(){
		
		Jogador jogador = new Jogador("Lazy", 250);
		CartaEngenheiro engenheiroProduzindo = new CartaEngenheiro("ES01", "lascado","Tester", 70, 3, 3);
		int mesaTrabalho=0;
		
		jogador.contratarEngenheiro(engenheiroProduzindo, mesaTrabalho);
		
		int numAjudas = jogador.getTabuleiro().getMesas()[mesaTrabalho].getAjudas().size();
				
		jogo.inserirArtefato(jogador, engenheiroProduzindo, mesaTrabalho);
		
		int novoNumAjudas = jogador.getTabuleiro().getMesas()[mesaTrabalho].getAjudas().size();
		
		assertThat("A novo número de ajudas é menor que o anterior",novoNumAjudas, is(greaterThan(numAjudas)));
	}
	

	
	@Test
	public void testConferirArtefatoRequisito(){
		Jogador jogador = new Jogador("Lazy", 250);
		CartaEngenheiro engenheiroInspecionando = new CartaEngenheiro("ES01", "lascado","Tester", 70, 3, 3);
		int mesaTrabalho=0;
		
		jogador.contratarEngenheiro(engenheiroInspecionando, mesaTrabalho);
		jogo.inserirArtefato(jogador, engenheiroInspecionando, mesaTrabalho);
		
		boolean statusRequisito = jogador.getTabuleiro().getMesas()[mesaTrabalho].getRequisitos().get(0).inspected();
						
		jogo.conferirArtefato(jogador, engenheiroInspecionando, mesaTrabalho);
		
		boolean novoStatusRequisito = jogador.getTabuleiro().getMesas()[mesaTrabalho].getRequisitos().get(0).inspected();
		
		assertTrue("O requisito não foi inspecionado!",novoStatusRequisito != statusRequisito);
	}

	@Test
	public void testConferirArtefatoDesenho(){
		Jogador jogador = new Jogador("Lazy", 250);
		CartaEngenheiro engenheiroInspecionando = new CartaEngenheiro("ES01", "lascado","Tester", 70, 3, 3);
		int mesaTrabalho=0;
		
		jogador.contratarEngenheiro(engenheiroInspecionando, mesaTrabalho);
		jogo.inserirArtefato(jogador, engenheiroInspecionando, mesaTrabalho);
		
		boolean statusDesenho = jogador.getTabuleiro().getMesas()[mesaTrabalho].getDesenhos().get(0).inspected();
				
		jogo.conferirArtefato(jogador, engenheiroInspecionando, mesaTrabalho);
		
		boolean novoStatusDesenho = jogador.getTabuleiro().getMesas()[mesaTrabalho].getDesenhos().get(0).inspected();
		
		assertTrue("O desenho não foi inspecionado!",novoStatusDesenho != statusDesenho);
	}
	
	@Test
	public void testConferirArtefatoCodigo(){
		Jogador jogador = new Jogador("Lazy", 250);
		CartaEngenheiro engenheiroInspecionando = new CartaEngenheiro("ES01", "lascado","Tester", 70, 3, 3);
		int mesaTrabalho=0;
		
		jogador.contratarEngenheiro(engenheiroInspecionando, mesaTrabalho);
		jogo.inserirArtefato(jogador, engenheiroInspecionando, mesaTrabalho);
		
		boolean statusCodigo = jogador.getTabuleiro().getMesas()[mesaTrabalho].getCodigos().get(0).inspected();
				
		jogo.conferirArtefato(jogador, engenheiroInspecionando, mesaTrabalho);
		
		boolean novoStatusCodigo = jogador.getTabuleiro().getMesas()[mesaTrabalho].getCodigos().get(0).inspected();
		
		assertTrue("O código não foi inspecionado!",novoStatusCodigo != statusCodigo);
	}

	@Test
	public void testConferirArtefatoRastro(){
		Jogador jogador = new Jogador("Lazy", 250);
		CartaEngenheiro engenheiroInspecionando = new CartaEngenheiro("ES01", "lascado","Tester", 70, 3, 3);
		int mesaTrabalho=0;
		
		jogador.contratarEngenheiro(engenheiroInspecionando, mesaTrabalho);
		jogo.inserirArtefato(jogador, engenheiroInspecionando, mesaTrabalho);
		
		boolean statusRastro = jogador.getTabuleiro().getMesas()[mesaTrabalho].getRastros().get(0).inspected();
				
		jogo.conferirArtefato(jogador, engenheiroInspecionando, mesaTrabalho);
		
		boolean novoStatusRastro = jogador.getTabuleiro().getMesas()[mesaTrabalho].getRastros().get(0).inspected();
		
		assertTrue("O rastro não foi inspecionado!",novoStatusRastro != statusRastro);
	}

	@Test
	public void testConferirArtefatoAjuda(){
		Jogador jogador = new Jogador("Lazy", 250);
		CartaEngenheiro engenheiroInspecionando = new CartaEngenheiro("ES01", "lascado","Tester", 70, 3, 3);
		int mesaTrabalho=0;
		
		jogador.contratarEngenheiro(engenheiroInspecionando, mesaTrabalho);
		jogo.inserirArtefato(jogador, engenheiroInspecionando, mesaTrabalho);
		
		boolean statusAjuda = jogador.getTabuleiro().getMesas()[mesaTrabalho].getAjudas().get(0).inspected();
				
		jogo.conferirArtefato(jogador, engenheiroInspecionando, mesaTrabalho);
		
		boolean novoStatusAjuda = jogador.getTabuleiro().getMesas()[mesaTrabalho].getAjudas().get(0).inspected();
		
		assertTrue("A ajuda não foi inspecionado!",novoStatusAjuda != statusAjuda);
	}
	
	@Test
	public void testRepararArtefato(){}

	@Test
	public void testCoferirQuantidadeArtefaftosSuficiente(){}

	@Test
	public void testInserirArtefatoPorEfeitoComEngenheiro(){}
	
	@Test
	public void testInserirArtefatoPorEfeitoSemEngenheiro(){}
	
	@Test
	public void testMudarArtefatoCinzaParaArtefatoBranco(){}
	
	@Test
	public void testInspecionarArtefatoPorEfeito(){}
	
	@Test
	public void testTodosEngenheirosPerdemArtefatos(){}

	@Test
	public void testRetirarTodosArtefatos(){}

	@Test
	public void testRetirarArtefato(){}

	@Test
	public void testMudarArtefatoBrancoPorArtefatoCinza(){}

	@Test
	public void testRetirarTodosArtefatosCinzasTipoARTEFATOS_AJUDA(){	}
	@Test
	public void testRetirarTodosArtefatosCinzasTipoARTEFATOS_CODIGO(){}
	@Test
	public void testRetirarTodosArtefatosCinzasTipoARTEFATOS_DESENHO(){}
	@Test
	public void testRetirarTodosArtefatosCinzasTipoARTEFATOS_RASTROS(){}
	@Test
	public void testRetirarTodosArtefatosCinzasTipoARTEFATOS_REQUISITOS(){}
	

	@After
	public void tearDown() throws Exception{
		
	}

}
