/*
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * Simules-SPL Project
 *
 * Created by Michael David
 * Date: 16/07/2011
 */

package br.ufmg.reuso.negocio.mesa;

/**
 * @author Michael David
 * 
 * Atualizado por Aline Brito, Igor Muzetti (2018-02).
 *
 */
import java.util.ArrayList;
import java.util.List;

import br.ufmg.reuso.negocio.baralho.BaralhoArtefatos;
import br.ufmg.reuso.negocio.baralho.BaralhoArtefatosBons;
import br.ufmg.reuso.negocio.baralho.BaralhoArtefatosRuins;
import br.ufmg.reuso.negocio.carta.Artefato;
import br.ufmg.reuso.negocio.carta.CartaEngenheiro;
import br.ufmg.reuso.negocio.jogo.Jogo;

public class Mesa{
	
	private CartaEngenheiro cartaMesa;
	private boolean moduloJaIntegrado;				/** variavel que mostra se ha modulo integrado na mesa ou nao*/
	private int especificacaoModuloIntegrado;       /** especifica qual modulo integrado do projeto a mesa contem (de 0 ate (tamanho do projeto-1)*/
	private ArrayList<Artefato>[] moduloIntegrado;	/** vetor de ArrayList contendo o modulo da integracao*/
	private List<Artefato> ajudas; //MQS 2019/1 - Tarefa #14, solucao #S10
	private List<Artefato> codigos; //MQS 2019/1 - Tarefa #14, solucao #S10
	private List<Artefato> desenhos; //MQS 2019/1 - Tarefa #14, solucao #S10
	private List<Artefato> rastros; //MQS 2019/1 - Tarefa #14, solucao #S10
	private List<Artefato> requisitos; //MQS 2019/1 - Tarefa #14, solucao #S10
	private List<Artefato> testes; //MQS 2019/1 - Tarefa #14, solucao #S10

	/*----------------------EFEITOS DA CARTA CONCEITO PERMANENTES---------------------------------*/
	private int efeitoAumentarMaturidadeEngenheiro; /**contem um inteiro com efeito na maturidade do engenheiro que ocupa a mesa*/
	private int efeitoAumentarHabilidadeEngenheiro; /**contem um inteiro com efeito na habilidade do engenheiro que ocupa a mesa*/
	private boolean efeitoModuloIntegradoNeutralizado; /**contem o efeito de ter o modulo desta mesa neutralizado na fase de validacao*/
	
	/*--------------------EFEITOS DA CARTA PROBLEMA PERMANENTES-----------------------------------*/

	private int efeitoPenalizarAjuda;				/**contem o efeito de aumentar pontos de habilidade necessarios dos engenheiros para dar ou receber ajuda*/
	
	
	
	/*--------------------EFEITOS TEMPORARIOS DA CARTA PROBLEMA-----------------------------------*/
	/**contem o efeito temporario de deixar todos engenheiros sem produzir artefatos*/
	private int duracaoEfeito_TEMPORARIO_EnginnersNotProduceArtifacts; //TODO efeito Temporario
	
	/**contem o efeito temporario de deixar todos engenheiros sem inspecionar artefatos*/
	private int duracaoEfeito_TEMPORARIO_EnginnersNotInspectArtifacts; //TODO efeito Temporario
	
	/**contem o efeito temporario de deixar todos engenheiros sem corrigir artefatos*/
	private int duracaoEfeito_TEMPORARIO_EnginnersNotCorrectArtifacts; //TODO efeito Temporario
	
	/**contem o efeito temporario de o engenheiro produzir somente artefatos cinzas*/
	private int duracaoEfeito_TEMPORARIO_ProduceOnlyGrayArtifacts;
	
	/**contem o efeito temporario de o engenheiro produzir somente artefatos brancos*/
	private int duracaoEfeito_TEMPORARIO_ProduceOnlyWhiteArtifacts;
	
	/*---------------------------------------------------------------------------------------*/
	@SuppressWarnings("unchecked")
	public Mesa (){
		efeitoAumentarMaturidadeEngenheiro = 0;     		/**nao ha efeito algum no inicio do jogo*/
		efeitoAumentarHabilidadeEngenheiro = 0;				/**nao ha efeito algum no inicio do jogo*/
		efeitoModuloIntegradoNeutralizado = false;			/**nao ha efeito algum no inicio do jogo*/
				
		duracaoEfeito_TEMPORARIO_EnginnersNotProduceArtifacts = 0;
		duracaoEfeito_TEMPORARIO_EnginnersNotInspectArtifacts = 0;
		duracaoEfeito_TEMPORARIO_EnginnersNotCorrectArtifacts = 0;
		efeitoPenalizarAjuda=0;
		duracaoEfeito_TEMPORARIO_ProduceOnlyGrayArtifacts = 0;
		duracaoEfeito_TEMPORARIO_ProduceOnlyWhiteArtifacts = 0;
		
		
		cartaMesa = null;
		ajudas = new ArrayList <Artefato>();
		codigos = new ArrayList <Artefato>();
		desenhos = new ArrayList <Artefato>();
		rastros = new ArrayList <Artefato>();
		requisitos = new ArrayList <Artefato>();
		testes = new ArrayList <Artefato>();
		moduloJaIntegrado = false;						/** mesa ainda nao contem modulo integrado*/
		especificacaoModuloIntegrado=-1;				/** mesa ainda nao contem modulo integrado*/
		
		moduloIntegrado= new ArrayList[5]; 				/** alocando o moduloIntegracao com 5 posicoes*/
	}
	
	
	public CartaEngenheiro getCartaMesa(){
		return cartaMesa;
	}

	public void setCartaMesa(CartaEngenheiro cartaMesa){
		this.cartaMesa = cartaMesa;
	}

	public boolean getModuloJaIntegrado(){
		return moduloJaIntegrado;
	}

	public void setModuloJaIntegrado(boolean moduloJaIntegrado){
		this.moduloJaIntegrado = moduloJaIntegrado;
	}

	public List<Artefato> getAjudas() { //MQS 2019/1 - Tarefa #14, solucao #S10
		return ajudas;
	}

	public void setAjudas(List<Artefato> ajudas) { //MQS 2019/1 - Tarefa #14, solucao #S10
		this.ajudas = ajudas;
	}

	public List<Artefato> getCodigos() { //MQS 2019/1 - Tarefa #14, solucao #S10
		return codigos;
	}

	public void setCodigos(List<Artefato> codigos) { //MQS 2019/1 - Tarefa #14, solucao #S10
		this.codigos = codigos;
	}

	public List<Artefato> getDesenhos() { //MQS 2019/1 - Tarefa #14, solucao #S10
		return desenhos;
	}

	public void setDesenhos(List<Artefato> desenhos) { //MQS 2019/1 - Tarefa #14, solucao #S10
		this.desenhos = desenhos;
	}

	public List<Artefato> getRastros() { //MQS 2019/1 - Tarefa #14, solucao #S10
		return rastros;
	}

	public void setRastros(List<Artefato> rastros) { //MQS 2019/1 - Tarefa #14, solucao #S10
		this.rastros = rastros;
	}

	public List<Artefato> getRequisitos() { //MQS 2019/1 - Tarefa #14, solucao #S10
		return requisitos;
	}
	
	public List<Artefato> getTestes() { //MQS 2019/1 - Tarefa #14, solucao #S10
		return testes;
	}

	public void setTestes(List<Artefato> testes) { //MQS 2019/1 - Tarefa #14, solucao #S10
		this.testes = testes;
	}

	public void setRequisitos(List<Artefato> requisitos) { //MQS 2019/1 - Tarefa #14, solucao #S10
		this.requisitos = requisitos;
	}

	public ArrayList<Artefato>[] getModuloIntegrado(){
		return moduloIntegrado;
	}

	public void setModuloIntegrado(ArrayList<Artefato>[] moduloIntegrado){
		this.moduloIntegrado = moduloIntegrado;
	}

	public int getEspecificacaoModuloIntegrado(){
		return especificacaoModuloIntegrado;
	}

	public void setEspecificacaoModuloIntegrado(int especificacaoModuloIntegrado){
		this.especificacaoModuloIntegrado = especificacaoModuloIntegrado;
	}

	public int getEfeitoAumentarMaturidadeEngenheiro(){
		return efeitoAumentarMaturidadeEngenheiro;
	}

	public void setEfeitoAumentarMaturidadeEngenheiro ( int efeitoAumentarMaturidadeEngenheiro){
		this.efeitoAumentarMaturidadeEngenheiro = efeitoAumentarMaturidadeEngenheiro;
	}

	public int getEfeitoAumentarHabilidadeEngenheiro(){
		return efeitoAumentarHabilidadeEngenheiro;
	}

	public void setEfeitoAumentarHabilidadeEngenheiro
	(
		int efeitoAumentarHabilidadeEngenheiro){this.efeitoAumentarHabilidadeEngenheiro = efeitoAumentarHabilidadeEngenheiro;
	}

	public boolean isEfeitoModuloIntegradoNeutralizado(){
		return efeitoModuloIntegradoNeutralizado;
	}

	public void setEfeitoModuloIntegradoNeutralizado (boolean efeitoModuloIntegradoNeutralizado){
		this.efeitoModuloIntegradoNeutralizado = efeitoModuloIntegradoNeutralizado;
	}

	public int getDuracaoEfeito_TEMPORARIO_EnginnersNotProduceArtifacts(){
		return duracaoEfeito_TEMPORARIO_EnginnersNotProduceArtifacts;
	}

	public void setDuracaoEfeito_TEMPORARIO_EnginnersNotProduceArtifacts(int duracaoEfeito_TEMPORARIO_EnginnersNotProduceArtifacts){
		this.duracaoEfeito_TEMPORARIO_EnginnersNotProduceArtifacts = duracaoEfeito_TEMPORARIO_EnginnersNotProduceArtifacts;
	}

	public int getDuracaoEfeito_TEMPORARIO_EnginnersNotInspectArtifacts(){
		return duracaoEfeito_TEMPORARIO_EnginnersNotInspectArtifacts;
	}

	public void setDuracaoEfeito_TEMPORARIO_EnginnersNotInspectArtifacts(int duracaoEfeito_TEMPORARIO_EnginnersNotInspectArtifacts){
		this.duracaoEfeito_TEMPORARIO_EnginnersNotInspectArtifacts = duracaoEfeito_TEMPORARIO_EnginnersNotInspectArtifacts;
	}

	public int getDuracaoEfeito_TEMPORARIO_EnginnersNotCorrectArtifacts(){
		return duracaoEfeito_TEMPORARIO_EnginnersNotCorrectArtifacts;
	}

	public void setDuracaoEfeito_TEMPORARIO_EnginnersNotCorrectArtifacts(int duracaoEfeito_TEMPORARIO_EnginnersNotCorrectArtifacts){
		this.duracaoEfeito_TEMPORARIO_EnginnersNotCorrectArtifacts = duracaoEfeito_TEMPORARIO_EnginnersNotCorrectArtifacts;
	}

	public int getEfeitoPenalizarAjuda(){
		return efeitoPenalizarAjuda;
	}

	public void setEfeitoPenalizarAjuda(int efeitoPenalizarAjuda){
		this.efeitoPenalizarAjuda = efeitoPenalizarAjuda;
	}

	public int getDuracaoEfeito_TEMPORARIO_ProduceOnlyGrayArtifacts(){
		return duracaoEfeito_TEMPORARIO_ProduceOnlyGrayArtifacts;
	}

	public void setDuracaoEfeito_TEMPORARIO_ProduceOnlyGrayArtifacts(int duracaoEfeito_TEMPORARIO_ProduceOnlyGrayArtifacts){
		this.duracaoEfeito_TEMPORARIO_ProduceOnlyGrayArtifacts = duracaoEfeito_TEMPORARIO_ProduceOnlyGrayArtifacts;
	}

	public int getDuracaoEfeito_TEMPORARIO_ProduceOnlyWhiteArtifacts(){
		return duracaoEfeito_TEMPORARIO_ProduceOnlyWhiteArtifacts;
	}

	public void setDuracaoEfeito_TEMPORARIO_ProduceOnlyWhiteArtifacts(int duracaoEfeito_TEMPORARIO_ProduceOnlyWhiteArtifacts){
		this.duracaoEfeito_TEMPORARIO_ProduceOnlyWhiteArtifacts = duracaoEfeito_TEMPORARIO_ProduceOnlyWhiteArtifacts;
	}

	/**
	 * MQS 2019/1 - Tarefa #13, solucao #S4a
	 * @param artefatos
	 * @param qtdItensParaVerificar
	 */
	private void inspecionarArtefatos(List<Artefato> artefatos, int qtdItensParaVerificar) {

		if (qtdItensParaVerificar > 0) {
			int j=0;
			for (int i = 0; i < qtdItensParaVerificar; i++){
				/* Enquanto artefato estiver inspecionado ou artefato ser ruim,
				 * procura proximo artefato */
				while ((artefatos.get(j).inspected() == true) ||
						(artefatos.get(j).isPoorQuality()== true)) {
					j++; //TODO lancar excecao em caso de nao haver artefatos a serem virados
				}
				artefatos.get(j).setArtefatoInspecionado(true);
			}
		}
	}

	/**
	 * MQS 2019/1 - Tarefa #13, solucao #S4b
	 * @param artefatos
	 * @param cabecalhoMsg
	 */
	private void mostrarArtefatos(List<Artefato> artefatos, String cabecalhoMsg) {
		System.out.println("\nartefatos " + cabecalhoMsg + ":");

		for (int i=0; i < artefatos.size(); i++) {
			artefatos.get(i).mostrarArtefato(); //TODO teste, so estou inspecionando requisitos la no metodo exibirTabelaInspecaoCorrecao
			System.out.println("Artefato Inspecionado?: " + artefatos.get(i).inspected() + "\n");
		}
	}

	/**
	 * Virar artefatos = Inspecionar artefatos
	 *  
	 * @param pedido
	 * @param artefatosB
	 * @param artefatosR
	 */
	public void virarArtefatos(Modulo[] pedido, BaralhoArtefatosBons[] artefatosB, BaralhoArtefatosRuins[] artefatosR) {

	/* MQS 2019/1 - Tarefa #13, solucao #S4a inicio de bloco de codigo */
		this.inspecionarArtefatos(this.ajudas, pedido[ArtefatoQualidade.BOM.getCodigo()].getAjudas());
		this.inspecionarArtefatos(this.codigos, pedido[ArtefatoQualidade.BOM.getCodigo()].getCodigos());
		this.inspecionarArtefatos(this.desenhos, pedido[ArtefatoQualidade.BOM.getCodigo()].getDesenhos());
		this.inspecionarArtefatos(this.rastros, pedido[ArtefatoQualidade.BOM.getCodigo()].getRastros());
		this.inspecionarArtefatos(this.requisitos, pedido[ArtefatoQualidade.BOM.getCodigo()].getRequisitos());
		this.inspecionarArtefatos(this.testes, pedido[ArtefatoQualidade.BOM.getCodigo()].getTestes());

		this.inspecionarArtefatos(this.ajudas, pedido[ArtefatoQualidade.RUIM.getCodigo()].getAjudas());
		this.inspecionarArtefatos(this.codigos, pedido[ArtefatoQualidade.RUIM.getCodigo()].getCodigos());
		this.inspecionarArtefatos(this.desenhos, pedido[ArtefatoQualidade.RUIM.getCodigo()].getDesenhos());
		this.inspecionarArtefatos(this.rastros, pedido[ArtefatoQualidade.RUIM.getCodigo()].getRastros());
		this.inspecionarArtefatos(this.requisitos, pedido[ArtefatoQualidade.RUIM.getCodigo()].getRequisitos());
		this.inspecionarArtefatos(this.testes, pedido[ArtefatoQualidade.RUIM.getCodigo()].getTestes());
	/* MQS 2019/1 - Tarefa #13, solucao #S4a - fim de bloco de codigo */

	/* MQS 2019/1 - Tarefa #13, solucao #S4b - inicio de bloco de codigo */
		this.mostrarArtefatos(this.ajudas, "AJUDAS inspecionadas");
		this.mostrarArtefatos(this.codigos, "CODIGOS inspecionados");
		this.mostrarArtefatos(this.desenhos, "DESENHOS inspecionados");
		this.mostrarArtefatos(this.rastros, "RASTROS inspecionados");
		this.mostrarArtefatos(this.requisitos, "REQUISITOS inspecionados");
		this.mostrarArtefatos(this.testes, "TESTES inspecionados");
	/* MQS 2019/1 - Tarefa #13, solucao #S4b - fim de bloco de codigo */
	}
	
	/**
	 * MQS 2019/1 - Tarefa #13, solucao #S5a
	 * @param artefatos
	 * @param baralhoArtefatos
	 * @param bonsOuRuins
	 * @param qtdItensParaVerificar
	 */
	private void trocarArtefatos(List<Artefato> artefatos, BaralhoArtefatos[] baralhoArtefatos, 
			ArtefatoQualidade bonsOuRuins, int qtdItensParaVerificar) {

		if (qtdItensParaVerificar > 0) {
			int j=0;
			for (int i=0; i< qtdItensParaVerificar; i++) {
				/* Enquanto artefato nao estiver inspecionado ou artefato nao conter bug ou artefato ser ruim, procura proximo artefato */
				while (!artefatos.get(j).inspected() || !artefatos.get(j).isBug()
						|| artefatos.get(j).isPoorQuality()) {
					j++;
				}
				Artefato temporario = artefatos.get(j);
				baralhoArtefatos[Jogo.BARALHO_AUXILIAR].recolherArtefato(temporario); /* colocando artefato descartado no baralho auxiliar */
				
				artefatos.remove(j); /* removendo artefato descartado do tabuleiro do jogador para troca-lo por outro */
				
				artefatos.add(baralhoArtefatos[Jogo.BARALHO_PRINCIPAL].darArtefato()); /* jogador recebe novo artefato do mesmo tipo, logo houve uma troca de artefatos */
				if (baralhoArtefatos[Jogo.BARALHO_PRINCIPAL].getNumeroArtefatosAtual() <= 0) {
					//TODO JP refatorar metodos trocarBaralhoArtefatosBons e trocarBaralhoArtefatosBons, unificando-os
					if (bonsOuRuins.equals(ArtefatoQualidade.BOM)) {
						this.trocarBaralhoArtefatosBons((BaralhoArtefatosBons[])baralhoArtefatos);
					}
					else if (bonsOuRuins.equals(ArtefatoQualidade.RUIM)) {
						this.trocarBaralhoArtefatosRuins((BaralhoArtefatosRuins[])baralhoArtefatos);
					}
				}
			}
		}
	}
	
	public void trocarArtefatos(Modulo[] pedido, BaralhoArtefatosBons[] artefatosB, BaralhoArtefatosRuins[] artefatosR) {
		
	/* MQS 2019/1 - Tarefa #13, solucao #S5a - inicio de bloco de codigo */
		this.trocarArtefatos(this.ajudas, artefatosB, ArtefatoQualidade.BOM, pedido[ArtefatoQualidade.BOM.getCodigo()].getAjudas());
		this.trocarArtefatos(this.codigos, artefatosB, ArtefatoQualidade.BOM, pedido[ArtefatoQualidade.BOM.getCodigo()].getCodigos());
		this.trocarArtefatos(this.desenhos, artefatosB, ArtefatoQualidade.BOM, pedido[ArtefatoQualidade.BOM.getCodigo()].getDesenhos());
		this.trocarArtefatos(this.rastros, artefatosB, ArtefatoQualidade.BOM, pedido[ArtefatoQualidade.BOM.getCodigo()].getRastros());
		this.trocarArtefatos(this.requisitos, artefatosB, ArtefatoQualidade.BOM, pedido[ArtefatoQualidade.BOM.getCodigo()].getRequisitos());
		this.trocarArtefatos(this.testes, artefatosB, ArtefatoQualidade.BOM, pedido[ArtefatoQualidade.BOM.getCodigo()].getTestes());

		this.trocarArtefatos(this.ajudas, artefatosB, ArtefatoQualidade.RUIM, pedido[ArtefatoQualidade.RUIM.getCodigo()].getAjudas());
		this.trocarArtefatos(this.codigos, artefatosB, ArtefatoQualidade.RUIM, pedido[ArtefatoQualidade.RUIM.getCodigo()].getCodigos());
		this.trocarArtefatos(this.desenhos, artefatosB, ArtefatoQualidade.RUIM, pedido[ArtefatoQualidade.RUIM.getCodigo()].getDesenhos());
		this.trocarArtefatos(this.rastros, artefatosB, ArtefatoQualidade.RUIM, pedido[ArtefatoQualidade.RUIM.getCodigo()].getRastros());
		this.trocarArtefatos(this.requisitos, artefatosB, ArtefatoQualidade.RUIM, pedido[ArtefatoQualidade.RUIM.getCodigo()].getRequisitos());
		this.trocarArtefatos(this.testes, artefatosB, ArtefatoQualidade.RUIM, pedido[ArtefatoQualidade.RUIM.getCodigo()].getTestes());
	/* MQS 2019/1 - Tarefa #13, solucao #S5a - fim de bloco de codigo */

	/* MQS 2019/1 - Tarefa #13, solucao #S5b - inicio de bloco de codigo */
		this.mostrarArtefatos(this.ajudas, "AJUDAS inspecionadas");
		this.mostrarArtefatos(this.codigos, "CODIGOS inspecionados");
		this.mostrarArtefatos(this.desenhos, "DESENHOS inspecionados");
		this.mostrarArtefatos(this.rastros, "RASTROS inspecionados");
		this.mostrarArtefatos(this.requisitos, "REQUISITOS inspecionados");
		this.mostrarArtefatos(this.testes, "TESTES inspecionados");
	/* MQS 2019/1 - Tarefa #13, solucao #S5b - fim de bloco de codigo */
	}
	
	public void trocarBaralhoArtefatosBons(BaralhoArtefatosBons[] artefatosB){//troca o baralho principal pelo auxiliar
		BaralhoArtefatosBons temporario = artefatosB[Jogo.BARALHO_PRINCIPAL];
		artefatosB[Jogo.BARALHO_AUXILIAR].embaralhar();								/**embaralhando as cartas que foram retiradas*/
		artefatosB[Jogo.BARALHO_PRINCIPAL] = artefatosB[Jogo.BARALHO_AUXILIAR];
		artefatosB[Jogo.BARALHO_AUXILIAR] = temporario;
		artefatosB[Jogo.BARALHO_AUXILIAR].setCurrentArtifact(0);					/**o novo baralho auxiliar tem o indice retornada para zero*/
	}
	
	public void trocarBaralhoArtefatosRuins(BaralhoArtefatosRuins[] artefatosR){//troca o baralho principal pelo auxiliar
		BaralhoArtefatosRuins temporario = artefatosR[Jogo.BARALHO_PRINCIPAL];
		artefatosR[Jogo.BARALHO_AUXILIAR].embaralhar();								/**embaralhando as cartas que foram retiradas*/
		artefatosR[Jogo.BARALHO_PRINCIPAL] = artefatosR[Jogo.BARALHO_AUXILIAR];
		artefatosR[Jogo.BARALHO_AUXILIAR] = temporario;
		artefatosR[Jogo.BARALHO_AUXILIAR].setCurrentArtifact(0);					/**o novo baralho auxiliar tem o indice retornada para zero*/
	}
	
	/** 
	 * calcula quantos artefatos nao inspecionados um ArrayList contem.
	 * @param arrayArtefatos MQS 2019/1 - Tarefa #14, solucao #S10
	 */
	public int somarArtefatosNotInspecionados(List<Artefato> arrayArtefatos) {
		int contador = 0;
		for (int i=0;i<arrayArtefatos.size();i++){	
			if (arrayArtefatos.get(i).inspected() == true)			/** se artefato foi inspecionado, pula iteracao*/
				continue;
			contador++;
		}
		return contador;
	}
	
	/** 
	 * calcula quantos artefatos que contem bug estao inspecionados em um ArrayList.
	 * @param arrayArtefatos MQS 2019/1 - Tarefa #14, solucao #S10
	 */
	public int somarArtefatosInspecionadosBug(List<Artefato> arrayArtefatos) {
		int contador = 0;
		for (int i=0;i<arrayArtefatos.size();i++){	
			if (arrayArtefatos.get(i).inspected() == false) /**se artefato nao foi inspecionado, pula iteracao*/
				continue;
			if((arrayArtefatos.get(i).inspected() == true) &&(arrayArtefatos.get(i).isBug()==false)) /** se artefato foi inspecionado e nao contem bug, pula iteracao*/
				continue;
			contador++;
		}
		return contador;
	}
	
	/**
	 * @param arrayArtefatos MQS 2019/1 - Tarefa #14, solucao #S10
	 * @return
	 */
	public int[] somarArtefatosNotInspecionadosSeparados(List<Artefato> arrayArtefatos) {
		int[] artefatosSeparados = new int[2];
		int contadorArtefatosBons = 0;
		int contadorArtefatosRuins = 0;
		for (int i=0;i<arrayArtefatos.size();i++){	
			if (arrayArtefatos.get(i).inspected() == true){//se artefato foi inspecionado, pula iteracao
				continue;
			}
			else{
				if(arrayArtefatos.get(i).isPoorQuality()==true){//se artefato e ruim
					contadorArtefatosRuins++;
				}
				else{
					contadorArtefatosBons++;
				}
			}
		}
		artefatosSeparados[ArtefatoQualidade.BOM.getCodigo()]=contadorArtefatosBons;
		artefatosSeparados[ArtefatoQualidade.RUIM.getCodigo()]=contadorArtefatosRuins;

		return artefatosSeparados;
		
	}
	
	/**
	 * @param arrayArtefatos MQS 2019/1 - Tarefa #14, solucao #S10
	 * @return
	 */
	public int[] somarArtefatosInspecionadosBugSeparados(List<Artefato> arrayArtefatos) {
		int[] artefatosSeparados = new int[2];
		int contadorArtefatosBons = 0;
		int contadorArtefatosRuins = 0;
		for (int i=0;i<arrayArtefatos.size();i++){	
			if (arrayArtefatos.get(i).inspected() == false) /**se artefato nao foi inspecionado, pula iteracao*/
				continue;
			if((arrayArtefatos.get(i).inspected() == true) &&(arrayArtefatos.get(i).isBug()==false)) /** se artefato foi inspecionado e nao contem bug, pula iteracao*/
				continue;
			if(arrayArtefatos.get(i).isPoorQuality()==true)
				contadorArtefatosRuins++;
			else
				contadorArtefatosBons++;
		}
		artefatosSeparados[ArtefatoQualidade.BOM.getCodigo()]=contadorArtefatosBons;
		artefatosSeparados[ArtefatoQualidade.RUIM.getCodigo()]=contadorArtefatosRuins;

		return artefatosSeparados;
	}

	/**
	 * MQS 2019/1 - Tarefa #13, solucao #S6
	 * @param artefatos
	 * @param baralhoArtefatos
	 * @param bonsOuRuins
	 * @param qtdItensParaVerificar
	 */
	public void receberArtefatos(List<Artefato> artefatos, 	BaralhoArtefatos[] baralhoArtefatos, 
			ArtefatoQualidade bonsOuRuins, int qtdItensParaVerificar) {
		
		if (qtdItensParaVerificar > 0) {
			for (int i=0; i < qtdItensParaVerificar; i++) {
				artefatos.add(baralhoArtefatos[Jogo.BARALHO_PRINCIPAL].darArtefato());
				if (baralhoArtefatos[Jogo.BARALHO_PRINCIPAL].getNumeroArtefatosAtual() <= 0) {
					//TODO JP refatorar metodos trocarBaralhoArtefatosBons e trocarBaralhoArtefatosBons, unificando-os
					if (bonsOuRuins.equals(ArtefatoQualidade.BOM)) {
						this.trocarBaralhoArtefatosBons((BaralhoArtefatosBons[])baralhoArtefatos);
					}
					else if (bonsOuRuins.equals(ArtefatoQualidade.RUIM)) {
						this.trocarBaralhoArtefatosRuins((BaralhoArtefatosRuins[])baralhoArtefatos);
					}
				}
			}
		}
	}

	public void receberArtefatos(Modulo[] pedido, BaralhoArtefatosBons[] artefatosB, BaralhoArtefatosRuins[] artefatosR) {
		
	/* MQS 2019/1 - Tarefa #13, solucao #S6 - inicio de bloco de codigo */
		this.receberArtefatos(this.ajudas, artefatosB, ArtefatoQualidade.BOM, pedido[ArtefatoQualidade.BOM.getCodigo()].getAjudas());
		this.receberArtefatos(this.codigos, artefatosB, ArtefatoQualidade.BOM, pedido[ArtefatoQualidade.BOM.getCodigo()].getCodigos());
		this.receberArtefatos(this.desenhos, artefatosB, ArtefatoQualidade.BOM, pedido[ArtefatoQualidade.BOM.getCodigo()].getDesenhos());
		this.receberArtefatos(this.rastros, artefatosB, ArtefatoQualidade.BOM, pedido[ArtefatoQualidade.BOM.getCodigo()].getRastros());
		this.receberArtefatos(this.requisitos, artefatosB, ArtefatoQualidade.BOM, pedido[ArtefatoQualidade.BOM.getCodigo()].getRequisitos());
		this.receberArtefatos(this.testes, artefatosB, ArtefatoQualidade.BOM, pedido[ArtefatoQualidade.BOM.getCodigo()].getTestes());

		this.receberArtefatos(this.ajudas, artefatosB, ArtefatoQualidade.RUIM, pedido[ArtefatoQualidade.RUIM.getCodigo()].getAjudas());
		this.receberArtefatos(this.codigos, artefatosB, ArtefatoQualidade.RUIM, pedido[ArtefatoQualidade.RUIM.getCodigo()].getCodigos());
		this.receberArtefatos(this.desenhos, artefatosB, ArtefatoQualidade.RUIM, pedido[ArtefatoQualidade.RUIM.getCodigo()].getDesenhos());
		this.receberArtefatos(this.rastros, artefatosB, ArtefatoQualidade.RUIM, pedido[ArtefatoQualidade.RUIM.getCodigo()].getRastros());
		this.receberArtefatos(this.requisitos, artefatosB, ArtefatoQualidade.RUIM, pedido[ArtefatoQualidade.RUIM.getCodigo()].getRequisitos());
		this.receberArtefatos(this.testes, artefatosB, ArtefatoQualidade.RUIM, pedido[ArtefatoQualidade.RUIM.getCodigo()].getTestes());
	/* MQS 2019/1 - Tarefa #13, solucao #S6 - fim de bloco de codigo */
	}

}
