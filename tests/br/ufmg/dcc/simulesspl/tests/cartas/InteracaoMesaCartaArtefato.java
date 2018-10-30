/**
 * 
 */
package br.ufmg.dcc.simulesspl.tests.cartas;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import br.ufmg.reuso.negocio.baralho.BaralhoArtefatosBons;
import br.ufmg.reuso.negocio.baralho.BaralhoArtefatosRuins;
import br.ufmg.reuso.negocio.carta.Artefato;
import br.ufmg.reuso.negocio.jogo.Jogo;
import br.ufmg.reuso.negocio.mesa.Mesa;
import br.ufmg.reuso.negocio.mesa.Modulo;
import junit.framework.TestCase;

/**
 * @author alcemir
 *
 */
public class InteracaoMesaCartaArtefato extends TestCase {
	
	private Jogo jogo;
	private Mesa mesa;

	@Before
	public void setUp(){
		this.jogo = Jogo.getJogo();
		this.jogo.mockinit();
		this.mesa = new Mesa();
	}
	
	//	public void testReceberArtefatos(){}	
	
	
	@Test
	public void testReceberArtefatoAjudaBom(){
		Modulo[] pedido = {new Modulo(), new Modulo()};		
		pedido[0].setAjudas(1);
		
		assertEquals("Existe mais de uma ajuda na mesa!", 0, mesa.getAjudas().size());
		
		mesa.receberArtefatos(pedido, jogo.getBaralhoArtefatosBons(), jogo.getBaralhoArtefatosRuins());
		
		assertEquals("Não existe uma ajuda na mesa!", 1, mesa.getAjudas().size());		
	}
	
	@Test
	public void testReceberArtefatoAjudaRuim(){
		Modulo[] pedido = {new Modulo(), new Modulo()};		
		pedido[1].setAjudas(1);
		
		assertEquals("Existe mais de uma ajuda na mesa!", 0, mesa.getAjudas().size());
		
		mesa.receberArtefatos(pedido, jogo.getBaralhoArtefatosBons(), jogo.getBaralhoArtefatosRuins());
		
		assertEquals("Não existe uma ajuda na mesa!", 1, mesa.getAjudas().size());		
	}
	
	@Test
	public void testReceberArtefatoCodigoBom(){
		Modulo[] pedido = {new Modulo(), new Modulo()};		
		pedido[0].setCodigos(1);
		
		assertEquals("Existe mais de um código na mesa!", 0, mesa.getCodigos().size());
		
		mesa.receberArtefatos(pedido, jogo.getBaralhoArtefatosBons(), jogo.getBaralhoArtefatosRuins());
		
		assertEquals("Não existe um código na mesa!", 1, mesa.getCodigos().size());
	}
	
	@Test
	public void testReceberArtefatoCodigoRuim(){
		Modulo[] pedido = {new Modulo(), new Modulo()};		
		pedido[1].setCodigos(1);
		
		assertEquals("Existe mais de um código na mesa!", 0, mesa.getCodigos().size());
		
		mesa.receberArtefatos(pedido, jogo.getBaralhoArtefatosBons(), jogo.getBaralhoArtefatosRuins());
		
		assertEquals("Não existe um código na mesa!", 1, mesa.getCodigos().size());
	}
	
	@Test
	public void testReceberArtefatoDesenhoBom(){
		Modulo[] pedido = {new Modulo(), new Modulo()};		
		pedido[0].setDesenhos(1);
		
		assertEquals("Existe mais de um desenho na mesa!", 0, mesa.getDesenhos().size());
		
		mesa.receberArtefatos(pedido, jogo.getBaralhoArtefatosBons(), jogo.getBaralhoArtefatosRuins());
		
		assertEquals("Não existe um desenho na mesa!", 1, mesa.getDesenhos().size());	
	}
	
	
	@Test
	public void testReceberArtefatoDesenhoRuim(){
		Modulo[] pedido = {new Modulo(), new Modulo()};		
		pedido[1].setDesenhos(1);
		
		assertEquals("Existe mais de um desenho na mesa!", 0, mesa.getDesenhos().size());
		
		mesa.receberArtefatos(pedido, jogo.getBaralhoArtefatosBons(), jogo.getBaralhoArtefatosRuins());
		
		assertEquals("Não existe um desenho na mesa!", 1, mesa.getDesenhos().size());	
	}
	
	@Test
	public void testReceberArtefatoRastroBom(){
		Modulo[] pedido = {new Modulo(), new Modulo()};		
		pedido[0].setRastros(1);
		
		assertEquals("Existe mais de um rastro na mesa!", 0, mesa.getRastros().size());
		
		mesa.receberArtefatos(pedido, jogo.getBaralhoArtefatosBons(), jogo.getBaralhoArtefatosRuins());
		
		assertEquals("Não existe um rastro na mesa!", 1, mesa.getRastros().size());
	}
	@Test
	public void testReceberArtefatoRastroRuim(){
		Modulo[] pedido = {new Modulo(), new Modulo()};		
		pedido[1].setRastros(1);
		
		assertEquals("Existe mais de um rastro na mesa!", 0, mesa.getRastros().size());
		
		mesa.receberArtefatos(pedido, jogo.getBaralhoArtefatosBons(), jogo.getBaralhoArtefatosRuins());
		
		assertEquals("Não existe um rastro na mesa!", 1, mesa.getRastros().size());	
	}
	
	@Test
	public void testReceberArtefatoRequisitoBom(){
		Modulo[] pedido = {new Modulo(), new Modulo()};		
		pedido[0].setRequisitos(1);
		
		assertEquals("Existe mais de um requisito na mesa!", 0, mesa.getRequisitos().size());
		
		mesa.receberArtefatos(pedido, jogo.getBaralhoArtefatosBons(), jogo.getBaralhoArtefatosRuins());
		
		assertEquals("Não existe um requisito na mesa!", 1, mesa.getRequisitos().size());
	}	
	
	@Test
	public void testReceberArtefatoRequisitoRuim(){
		Modulo[] pedido = {new Modulo(), new Modulo()};		
		pedido[1].setRequisitos(1);
		
		assertEquals("Existe mais de um requisito na mesa!", 0, mesa.getRequisitos().size());
		
		mesa.receberArtefatos(pedido, jogo.getBaralhoArtefatosBons(), jogo.getBaralhoArtefatosRuins());
		
		assertEquals("Não existe um requisito na mesa!", 1, mesa.getRequisitos().size());	
	}

//	public void testVirarArtefatos(){}
		
	@Test
	public void testVirarArtefatoAjudaBom(){
		Modulo[] pedido = {new Modulo(), new Modulo()};		
		pedido[0].setAjudas(1);
		mesa.receberArtefatos(pedido, jogo.getBaralhoArtefatosBons(), jogo.getBaralhoArtefatosRuins());
		
		assertFalse("O artefato ajuda já está inspecionado!", mesa.getAjudas().get(0).inspected());
		
		mesa.virarArtefatos(pedido, jogo.getBaralhoArtefatosBons(), jogo.getBaralhoArtefatosRuins());
		
		assertTrue("O artefato ajuda ainda não foi inspecionado!", mesa.getAjudas().get(0).inspected());
	}
	
	@Test
	public void testVirarArtefatoAjudaRuim(){
		Modulo[] pedido = {new Modulo(), new Modulo()};		
		pedido[1].setAjudas(1);
		mesa.receberArtefatos(pedido, jogo.getBaralhoArtefatosBons(), jogo.getBaralhoArtefatosRuins());
		
		assertFalse("O artefato ajuda já está inspecionado!", mesa.getAjudas().get(0).inspected());
		
		mesa.virarArtefatos(pedido, jogo.getBaralhoArtefatosBons(), jogo.getBaralhoArtefatosRuins());
		
		assertTrue("O artefato ajuda ainda não foi inspecionado!", mesa.getAjudas().get(0).inspected());
	}

	@Test
	public void testVirarArtefatoCodigoBom(){
		Modulo[] pedido = {new Modulo(), new Modulo()};		
		pedido[0].setCodigos(1);
		mesa.receberArtefatos(pedido, jogo.getBaralhoArtefatosBons(), jogo.getBaralhoArtefatosRuins());
		
		assertFalse("O artefato código já está inspecionado!", mesa.getCodigos().get(0).inspected());
		mesa.virarArtefatos(pedido, jogo.getBaralhoArtefatosBons(), jogo.getBaralhoArtefatosRuins());
		assertTrue("O artefato ajuda ainda não foi inspecionado!", mesa.getCodigos().get(0).inspected());
	}
	
	@Test
	public void testVirarArtefatoCodigoRuim(){
		Modulo[] pedido = {new Modulo(), new Modulo()};		
		pedido[1].setCodigos(1);
		mesa.receberArtefatos(pedido, jogo.getBaralhoArtefatosBons(), jogo.getBaralhoArtefatosRuins());
		
		assertFalse("O artefato código já está inspecionado!", mesa.getCodigos().get(0).inspected());
		mesa.virarArtefatos(pedido, jogo.getBaralhoArtefatosBons(), jogo.getBaralhoArtefatosRuins());
		assertTrue("O artefato ajuda ainda não foi inspecionado!", mesa.getCodigos().get(0).inspected());
	}
	
	@Test
	public void testVirarArtefatoDesenhoBom(){
		Modulo[] pedido = {new Modulo(), new Modulo()};		
		pedido[0].setDesenhos(1);
		mesa.receberArtefatos(pedido, jogo.getBaralhoArtefatosBons(), jogo.getBaralhoArtefatosRuins());
		
		assertFalse("O artefato desenho já está inspecionado!", mesa.getDesenhos().get(0).inspected());
		
		mesa.virarArtefatos(pedido, jogo.getBaralhoArtefatosBons(), jogo.getBaralhoArtefatosRuins());
		
		assertTrue("O artefato desenho ainda não foi inspecionado!", mesa.getDesenhos().get(0).inspected());
	}
	
	@Test
	public void testVirarArtefatoDesenhoRuim(){
		Modulo[] pedido = {new Modulo(), new Modulo()};		
		pedido[1].setDesenhos(1);
		mesa.receberArtefatos(pedido, jogo.getBaralhoArtefatosBons(), jogo.getBaralhoArtefatosRuins());
		
		assertFalse("O artefato desenho já está inspecionado!", mesa.getDesenhos().get(0).inspected());
		
		mesa.virarArtefatos(pedido, jogo.getBaralhoArtefatosBons(), jogo.getBaralhoArtefatosRuins());
		
		assertTrue("O artefato desenho ainda não foi inspecionado!", mesa.getDesenhos().get(0).inspected());
	}
	
	@Test
	public void testVirarArtefatoRastroBom(){
		Modulo[] pedido = {new Modulo(), new Modulo()};		
		pedido[0].setRastros(1);
		mesa.receberArtefatos(pedido, jogo.getBaralhoArtefatosBons(), jogo.getBaralhoArtefatosRuins());
		
		assertFalse("O artefato rastro já está inspecionado!", mesa.getRastros().get(0).inspected());
		
		mesa.virarArtefatos(pedido, jogo.getBaralhoArtefatosBons(), jogo.getBaralhoArtefatosRuins());
		
		assertTrue("O artefato rastro ainda não foi inspecionado!", mesa.getRastros().get(0).inspected());
	}
	
	@Test
	public void testVirarArtefatoRastroRuim(){
		Modulo[] pedido = {new Modulo(), new Modulo()};		
		pedido[1].setRastros(1);
		mesa.receberArtefatos(pedido, jogo.getBaralhoArtefatosBons(), jogo.getBaralhoArtefatosRuins());
		
		assertFalse("O artefato rastro já está inspecionado!", mesa.getRastros().get(0).inspected());
		
		mesa.virarArtefatos(pedido, jogo.getBaralhoArtefatosBons(), jogo.getBaralhoArtefatosRuins());
		
		assertTrue("O artefato rastro ainda não foi inspecionado!", mesa.getRastros().get(0).inspected());
	}
	
	@Test
	public void testVirarArtefatoRequisitoBom(){
		Modulo[] pedido = {new Modulo(), new Modulo()};		
		pedido[0].setRequisitos(1);
		mesa.receberArtefatos(pedido, jogo.getBaralhoArtefatosBons(), jogo.getBaralhoArtefatosRuins());
		
		assertFalse("O artefato requisito já está inspecionado!", mesa.getRequisitos().get(0).inspected());
		
		mesa.virarArtefatos(pedido, jogo.getBaralhoArtefatosBons(), jogo.getBaralhoArtefatosRuins());
		
		assertTrue("O artefato requisitos ainda não foi inspecionado!", mesa.getRequisitos().get(0).inspected());
	}
	
	@Test
	public void testVirarArtefatoRequisitoRuim(){
		Modulo[] pedido = {new Modulo(), new Modulo()};		
		pedido[1].setRequisitos(1);
		mesa.receberArtefatos(pedido, jogo.getBaralhoArtefatosBons(), jogo.getBaralhoArtefatosRuins());
		
		assertFalse("O artefato requisito já está inspecionado!", mesa.getRequisitos().get(0).inspected());
		
		mesa.virarArtefatos(pedido, jogo.getBaralhoArtefatosBons(), jogo.getBaralhoArtefatosRuins());
		
		assertTrue("O artefato requisitos ainda não foi inspecionado!", mesa.getRequisitos().get(0).inspected());
	}

//	public void testTrocarArtefatos(){
	@Test
	public void testTrocarArtefatoAjudaBOM(){
		Modulo[] pedido = {new Modulo(), new Modulo()};		
		pedido[0].setAjudas(1);
		mesa.receberArtefatos(pedido, jogo.getBaralhoArtefatosBons(), jogo.getBaralhoArtefatosRuins());
		
		assertEquals("Não existe uma ajuda na mesa!", 1, mesa.getAjudas().size());
		mesa.getAjudas().get(0).setArtefatoInspecionado(true);
		mesa.getAjudas().get(0).setBug(true);
		mesa.getAjudas().get(0).setQualidadeArtefatoRuim(false);
		
		Artefato artefatoVelho = mesa.getAjudas().get(0);
		mesa.trocarArtefatos(pedido, jogo.getBaralhoArtefatosBons(), jogo.getBaralhoArtefatosRuins());
		Artefato artefatoNovo = mesa.getAjudas().get(0);
		
		assertEquals("Não existe uma ajuda na mesa!", 1, mesa.getAjudas().size());
		assertFalse("Não houve troca de artefato!", artefatoVelho == artefatoNovo);
	}
	
	@Test
	public void testTrocarArtefatosAjudasRUINS(){
		Modulo[] pedido = {new Modulo(), new Modulo()};		
		pedido[1].setAjudas(1);
		mesa.receberArtefatos(pedido, jogo.getBaralhoArtefatosBons(), jogo.getBaralhoArtefatosRuins());
		
		assertEquals("Não existe uma ajuda na mesa!", 1, mesa.getAjudas().size());
		mesa.getAjudas().get(0).setArtefatoInspecionado(true);
		mesa.getAjudas().get(0).setBug(true);
		mesa.getAjudas().get(0).setQualidadeArtefatoRuim(true);
		
		Artefato artefatoVelho = mesa.getAjudas().get(0);
		mesa.trocarArtefatos(pedido, jogo.getBaralhoArtefatosBons(), jogo.getBaralhoArtefatosRuins());
		Artefato artefatoNovo = mesa.getAjudas().get(0);
		
		assertEquals("Não existe uma ajuda na mesa!", 1, mesa.getAjudas().size());
		assertFalse("Não houve troca de artefato!", artefatoVelho == artefatoNovo);
	}
	
	@Test
	public void testTrocarArtefatosCodigosBONS(){
		Modulo[] pedido = {new Modulo(), new Modulo()};		
		pedido[0].setCodigos(1);
		mesa.receberArtefatos(pedido, jogo.getBaralhoArtefatosBons(), jogo.getBaralhoArtefatosRuins());
		
		assertEquals("Não existe um codigo na mesa!", 1, mesa.getCodigos().size());
		mesa.getCodigos().get(0).setArtefatoInspecionado(true);
		mesa.getCodigos().get(0).setBug(true);
		mesa.getCodigos().get(0).setQualidadeArtefatoRuim(false);
		
		Artefato artefatoVelho = mesa.getCodigos().get(0);
		mesa.trocarArtefatos(pedido, jogo.getBaralhoArtefatosBons(), jogo.getBaralhoArtefatosRuins());
		Artefato artefatoNovo = mesa.getCodigos().get(0);
		
		assertEquals("Não existe um codigo na mesa!", 1, mesa.getCodigos().size());
		assertFalse("Não houve troca de artefato!", artefatoVelho == artefatoNovo);
	}
	
	@Test
	public void testTrocarArtefatosCodigosRUINS(){
		Modulo[] pedido = {new Modulo(), new Modulo()};		
		pedido[1].setCodigos(1);
		mesa.receberArtefatos(pedido, jogo.getBaralhoArtefatosBons(), jogo.getBaralhoArtefatosRuins());
		
		assertEquals("Não existe um codigo na mesa!", 1, mesa.getCodigos().size());
		mesa.getCodigos().get(0).setArtefatoInspecionado(true);
		mesa.getCodigos().get(0).setBug(true);
		mesa.getCodigos().get(0).setQualidadeArtefatoRuim(true);
		
		Artefato artefatoVelho = mesa.getCodigos().get(0);
		mesa.trocarArtefatos(pedido, jogo.getBaralhoArtefatosBons(), jogo.getBaralhoArtefatosRuins());
		Artefato artefatoNovo = mesa.getCodigos().get(0);
		
		assertEquals("Não existe um codigo na mesa!", 1, mesa.getCodigos().size());
		assertFalse("Não houve troca de artefato!", artefatoVelho == artefatoNovo);
	}
	
	@Test
	public void testTrocarArtefatosDesenhosBONS(){
		Modulo[] pedido = {new Modulo(), new Modulo()};		
		pedido[0].setDesenhos(1);
		mesa.receberArtefatos(pedido, jogo.getBaralhoArtefatosBons(), jogo.getBaralhoArtefatosRuins());
		
		assertEquals("Não existe um desenho na mesa!", 1, mesa.getDesenhos().size());
		mesa.getDesenhos().get(0).setArtefatoInspecionado(true);
		mesa.getDesenhos().get(0).setBug(true);
		mesa.getDesenhos().get(0).setQualidadeArtefatoRuim(false);
		
		Artefato artefatoVelho = mesa.getDesenhos().get(0);
		mesa.trocarArtefatos(pedido, jogo.getBaralhoArtefatosBons(), jogo.getBaralhoArtefatosRuins());
		Artefato artefatoNovo = mesa.getDesenhos().get(0);
		
		assertEquals("Não existe um desenho na mesa!", 1, mesa.getDesenhos().size());
		assertFalse("Não houve troca de artefato!", artefatoVelho == artefatoNovo);
	}
	
	@Test
	public void testTrocarArtefatosDesenhosRUINS(){
		Modulo[] pedido = {new Modulo(), new Modulo()};		
		pedido[1].setDesenhos(1);
		mesa.receberArtefatos(pedido, jogo.getBaralhoArtefatosBons(), jogo.getBaralhoArtefatosRuins());
		
		assertEquals("Não existe um desenho na mesa!", 1, mesa.getDesenhos().size());
		mesa.getDesenhos().get(0).setArtefatoInspecionado(true);
		mesa.getDesenhos().get(0).setBug(true);
		mesa.getDesenhos().get(0).setQualidadeArtefatoRuim(true);
		
		Artefato artefatoVelho = mesa.getDesenhos().get(0);
		mesa.trocarArtefatos(pedido, jogo.getBaralhoArtefatosBons(), jogo.getBaralhoArtefatosRuins());
		Artefato artefatoNovo = mesa.getDesenhos().get(0);
		
		assertEquals("Não existe um desenho na mesa!", 1, mesa.getDesenhos().size());
		assertFalse("Não houve troca de artefato!", artefatoVelho == artefatoNovo);
	}

	@Test
	public void testTrocarArtefatosRastrosBONS(){
		Modulo[] pedido = {new Modulo(), new Modulo()};		
		pedido[0].setRastros(1);
		mesa.receberArtefatos(pedido, jogo.getBaralhoArtefatosBons(), jogo.getBaralhoArtefatosRuins());
		
		assertEquals("Não existe um rastro na mesa!", 1, mesa.getRastros().size());
		mesa.getRastros().get(0).setArtefatoInspecionado(true);
		mesa.getRastros().get(0).setBug(true);
		mesa.getRastros().get(0).setQualidadeArtefatoRuim(false);
		
		Artefato artefatoVelho = mesa.getRastros().get(0);
		mesa.trocarArtefatos(pedido, jogo.getBaralhoArtefatosBons(), jogo.getBaralhoArtefatosRuins());
		Artefato artefatoNovo = mesa.getRastros().get(0);
		
		assertEquals("Não existe um rastro na mesa!", 1, mesa.getRastros().size());
		assertFalse("Não houve troca de artefato!", artefatoVelho == artefatoNovo);
	}
	
	@Test
	public void testTrocarArtefatosRastrosRUINS(){
		Modulo[] pedido = {new Modulo(), new Modulo()};		
		pedido[1].setRastros(1);
		mesa.receberArtefatos(pedido, jogo.getBaralhoArtefatosBons(), jogo.getBaralhoArtefatosRuins());
		
		assertEquals("Não existe um rastro na mesa!", 1, mesa.getRastros().size());
		mesa.getRastros().get(0).setArtefatoInspecionado(true);
		mesa.getRastros().get(0).setBug(true);
		mesa.getRastros().get(0).setQualidadeArtefatoRuim(true);
		
		Artefato artefatoVelho = mesa.getRastros().get(0);
		mesa.trocarArtefatos(pedido, jogo.getBaralhoArtefatosBons(), jogo.getBaralhoArtefatosRuins());
		Artefato artefatoNovo = mesa.getRastros().get(0);
		
		assertEquals("Não existe um rastro na mesa!", 1, mesa.getRastros().size());
		assertFalse("Não houve troca de artefato!", artefatoVelho == artefatoNovo);
	}
	@Test
	public void testTrocarArtefatosRequisitosBONS(){
		Modulo[] pedido = {new Modulo(), new Modulo()};		
		pedido[0].setRequisitos(1);
		mesa.receberArtefatos(pedido, jogo.getBaralhoArtefatosBons(), jogo.getBaralhoArtefatosRuins());
		
		assertEquals("Não existe um desenho na mesa!", 1, mesa.getRequisitos().size());
		mesa.getRequisitos().get(0).setArtefatoInspecionado(true);
		mesa.getRequisitos().get(0).setBug(true);
		mesa.getRequisitos().get(0).setQualidadeArtefatoRuim(false);
		
		Artefato artefatoVelho = mesa.getRequisitos().get(0);
		mesa.trocarArtefatos(pedido, jogo.getBaralhoArtefatosBons(), jogo.getBaralhoArtefatosRuins());
		Artefato artefatoNovo = mesa.getRequisitos().get(0);
		
		assertEquals("Não existe um desenho na mesa!", 1, mesa.getRequisitos().size());
		assertFalse("Não houve troca de artefato!", artefatoVelho == artefatoNovo);
	}
	
	@Test
	public void testTrocarArtefatosRequisitosRUINS(){
		Modulo[] pedido = {new Modulo(), new Modulo()};		
		pedido[1].setRequisitos(1);
		mesa.receberArtefatos(pedido, jogo.getBaralhoArtefatosBons(), jogo.getBaralhoArtefatosRuins());
		
		assertEquals("Não existe um desenho na mesa!", 1, mesa.getRequisitos().size());
		mesa.getRequisitos().get(0).setArtefatoInspecionado(true);
		mesa.getRequisitos().get(0).setBug(true);
		mesa.getRequisitos().get(0).setQualidadeArtefatoRuim(true);
		
		Artefato artefatoVelho = mesa.getRequisitos().get(0);
		mesa.trocarArtefatos(pedido, jogo.getBaralhoArtefatosBons(), jogo.getBaralhoArtefatosRuins());
		Artefato artefatoNovo = mesa.getRequisitos().get(0);
		
		assertEquals("Não existe um desenho na mesa!", 1, mesa.getRequisitos().size());
		assertFalse("Não houve troca de artefato!", artefatoVelho == artefatoNovo);
	}
	
	@Test
	public void testTrocarBaralhoArtefatosBons(){
		BaralhoArtefatosBons[] bonsAtefatos = jogo.getBaralhoArtefatosBons();
		BaralhoArtefatosBons principal = bonsAtefatos[jogo.BARALHO_PRINCIPAL];
		BaralhoArtefatosBons auxiliar = bonsAtefatos[jogo.BARALHO_AUXILIAR];
		
		mesa.trocarBaralhoArtefatosBons(bonsAtefatos);
		
		assertTrue("O baralho não foi trocado.", principal == bonsAtefatos[jogo.BARALHO_AUXILIAR]);
		assertTrue("O baralho não foi trocado.", auxiliar == bonsAtefatos[jogo.BARALHO_PRINCIPAL]);
		
	}
	
	@Test 
	public void testTrocarBaralhoArtefatosRuins(){
		BaralhoArtefatosRuins[] atefatosRuins = jogo.getBaralhoArtefatosRuins();
		BaralhoArtefatosRuins principal = atefatosRuins[jogo.BARALHO_PRINCIPAL];
		BaralhoArtefatosRuins auxiliar = atefatosRuins[jogo.BARALHO_AUXILIAR];
		
		mesa.trocarBaralhoArtefatosRuins(atefatosRuins);
		
		assertTrue("O baralho não foi trocado.", principal == atefatosRuins[jogo.BARALHO_AUXILIAR]);
		assertTrue("O baralho não foi trocado.", auxiliar == atefatosRuins[jogo.BARALHO_PRINCIPAL]);
	}
	
	@Test
	public void testSomarArtefatosNotInspecionados(){
		ArrayList<Artefato> artefatos = new ArrayList<Artefato>();
		
		int numArtefatosNaoInspecionados = 5;
		for (int i = 0; i < numArtefatosNaoInspecionados; i++) {
			artefatos.add(new Artefato(false, false));
		}
		
		assertTrue("Não existem "+numArtefatosNaoInspecionados +" artefatos no conjunto de artefatos", artefatos.size()==numArtefatosNaoInspecionados);
		
		int result = mesa.somarArtefatosNotInspecionados(artefatos);
		
		assertTrue("O resultado da contagem dos artefatos não inspecionados foi diferente do esperado!", result == numArtefatosNaoInspecionados);
		
	}
	
	@Test
	public void testSomarArtefatosInspecionadosBug(){
		ArrayList<Artefato> artefatos = new ArrayList<Artefato>();
		
		int numArtefatosBugInspecionados = 5;
		for (int i = 0; i < numArtefatosBugInspecionados; i++) {
			artefatos.add(new Artefato(true, false));
			artefatos.get(i).setArtefatoInspecionado(true);
		}
		
		assertTrue("Não existem "+numArtefatosBugInspecionados +" artefatos no conjunto de artefatos", artefatos.size()==numArtefatosBugInspecionados);
		
		int result = mesa.somarArtefatosInspecionadosBug(artefatos);
		
		assertTrue("O resultado da contagem dos artefatos não inspecionados foi diferente do esperado!", result == numArtefatosBugInspecionados);
	}
	
	@Test
	public void testSomarArtefatosNotInspecionadosSeparados(){
		ArrayList<Artefato> artefatos = new ArrayList<Artefato>();
		
		int numArtefatosBonsNaoInspecionados = 5;
		int numArtefatosRuinsNaoInspecionados = 5;
		for (int i = 0; i < numArtefatosBonsNaoInspecionados; i++) {
			artefatos.add(new Artefato(false, true));
		}
		for (int i = 0; i < numArtefatosRuinsNaoInspecionados; i++) {
			artefatos.add(new Artefato(false, false));
		}
		
		int[] result = mesa.somarArtefatosNotInspecionadosSeparados(artefatos);
		
		assertTrue("O resultado da contagem dos artefatos bons não inspecionados foi diferente do esperado!", result[0] == numArtefatosBonsNaoInspecionados);
		assertTrue("O resultado da contagem dos artefatos ruins não inspecionados foi diferente do esperado!", result[1] == numArtefatosRuinsNaoInspecionados);
	}
	
	@Test
	public void testSomarArtefatosInspecionadosBugSeparados (){
		ArrayList<Artefato> artefatos = new ArrayList<Artefato>();
		
		int numArtefatosBonsNaoInspecionados = 5;
		int numArtefatosRuinsNaoInspecionados = 5;
		for (int i = 0; i < numArtefatosBonsNaoInspecionados; i++) {
			artefatos.add(new Artefato(true, false));
			artefatos.get(i).setArtefatoInspecionado(true);
		}
		for (int i = 0; i < numArtefatosRuinsNaoInspecionados; i++) {
			artefatos.add(new Artefato(true, true));
			artefatos.get(i+numArtefatosBonsNaoInspecionados).setArtefatoInspecionado(true);
		}
		
		int[] result = mesa.somarArtefatosInspecionadosBugSeparados(artefatos);
		
		assertTrue("O resultado da contagem foi <"+result[0]+">; esperava-se <"+numArtefatosBonsNaoInspecionados+">.", result[0] == numArtefatosBonsNaoInspecionados);
		assertTrue("O resultado da contagem foi <"+result[1]+">; esperava-se <"+numArtefatosRuinsNaoInspecionados+">.", result[1] == numArtefatosRuinsNaoInspecionados);
	}
}
