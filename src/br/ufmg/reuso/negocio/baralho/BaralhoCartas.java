/*
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * Simules-SPL Project
 *
 * Created by Michael David
 * Date: 16/07/2011
 */

package br.ufmg.reuso.negocio.baralho;

/**
 * @author Michael David
 *
 */

import java.io.File;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Random;

import br.ufmg.reuso.dados.carta.RepositorioCarta;
import br.ufmg.reuso.negocio.carta.Carta;
//#ifdef ConceptCard
import br.ufmg.reuso.negocio.carta.CartaBonificacao;
//#endif
import br.ufmg.reuso.negocio.carta.CartaEngenheiro;
import br.ufmg.reuso.negocio.carta.CartaPenalizacao;
import br.ufmg.reuso.negocio.jogo.Jogo;
import br.ufmg.reuso.negocio.jogo.ModeGameConstants;

public class BaralhoCartas{
	private Carta[] baralho;
	private int numeroTotalCartas; // contem o número de cartas total do jogo 
	private int numeroTotalEngenheiro;
	private int numeroTotalProblemas;
	//#ifdef ConceptCard
	private int numeroTotalConceito;
	//#endif
	private int numeroCartasBaralhoAtual; // contem o numero de cartas que o baralho tem no decorrer do jogo
	private int currentCard; // índice da próxima carta a ser distribuída durante o jogo.

	/**
	 * Reuso de Software 2016 - Código Adicionado
	 */
	private RepositorioCarta repositorio = new RepositorioCarta();

	public BaralhoCartas(String facilidade,
		//#ifdef ConceptCard
		int[] cartasConceito,
		//#endif
		int [] cartasProblema) {

		if(facilidade==Jogo.FACIL){

		}

		if(facilidade==Jogo.MODERADO){

		}

		if(facilidade==Jogo.DIFICIL){	
			//#ifdef ConceptCard
			CartaBonificacao [] cartaconceito; //vetor que aloja cartas conceito do jogo
			cartaconceito = inicializarCartasConceito(ModeGameConstants.PATH_CARTA_CONCEITO_DIFICIL, cartasConceito);
			//#endif

			CartaPenalizacao[] cartaproblema; //vetor de todas as cartas problema
			cartaproblema = inicializarCartasProblemas(ModeGameConstants.PATH_CARTA_PROBLEMA_DIFICIL, cartasProblema);

			CartaEngenheiro[] cartaengenheiro; //vetor de todas as cartas de engenheiro
			cartaengenheiro = inicializarCartasEngenheiro(ModeGameConstants.PATH_CARTA_ENGENHEIRO_DIFICIL);

			this.currentCard=0;	// configura currentCard como primeira carta retirada do baralho ser na posicao 0
			// contem o número de cartas total do jogo = soma de cartas de: conceito, engenheiro e problemas
			setNumeroTotalCartas(getNumeroTotalProblemas()
					//#ifdef ConceptCard
					+ getNumeroTotalConceito() 
					//#endif
					+ getNumeroTotalEngenheiro());
			
			baralho = new Carta[getNumeroTotalCartas()]; //contruindo baralho com número de cartas na pasta correspondente ao tipo de jogo
			setNumeroCartasBaralhoAtual(getNumeroTotalCartas()); //numero de cartas no baralho inicialmente é igual ao total de cartas no jogo

			for (int i=0,j=0,k=0;i<baralho.length;i++) {//POLIMORFISMO DE CARTAS NUM VETOR

				if (i<getNumeroTotalEngenheiro()) {
					baralho[i]=cartaengenheiro[i];	//preenchendo as primeiras posições com cartas de engenheiro de software 
				}
																			 
				else {
					//#ifdef ConceptCard
					if(j<getNumeroTotalConceito()){
						baralho[i]=cartaconceito[j]; //preenchendo a parte do meio do baralho com cartas conceito													
						j++;
					}
					else{
					//#endif
						baralho[i]=cartaproblema[k];//preenchendo a parte final do baralho com cartas de problema													
						k++;
					//#ifdef ConceptCard
					}
					//#endif
				}
			}
		}

		//mostrarBaralho(); //-> ok 
	}

	/**
	 * Constroi o baralho tendo como parametro outro baralho
	 * @param baralhoInicial
	 */
	public BaralhoCartas(BaralhoCartas baralhoInicial){
		setNumeroTotalCartas(baralhoInicial.getNumeroTotalCartas()); //o baralho construído tem o mesmo número de cartas do baralhoInicial
		setNumeroTotalEngenheiro(0);
		setNumeroTotalProblemas(0);
		//#ifdef ConceptCard
		setNumeroTotalConceito(0);
		//#endif
		setNumeroCartasBaralhoAtual(0);	// o baralho não contém nenhuma carta quando construído
		this.currentCard = 0;
		this.baralho = new Carta [getNumeroTotalCartas()];
		for (int i=0; i<baralho.length; i++) {
			baralho[i]=null; // logo, não existe cartas no baralho
		}
	}

	//#ifdef ConceptCard
	public CartaBonificacao[] inicializarCartasConceito(String dificuldade, int[] cartasConceitoSelecionadas){
		String[] arquivosDiretorio = repositorio.getNomeArquivosPasta(dificuldade);	
		ArrayList <String> somenteArquivosProperties = new ArrayList <String>(); //preenhendo um vetor de string com nome dos arquivos do diretorio
		for (int i=0;i<arquivosDiretorio.length;i++) {
			if((arquivosDiretorio[i].endsWith(".properties"))&&(selecionarCartaConceito(cartasConceitoSelecionadas,arquivosDiretorio[i])==true)) { // testando se arquivo do diretório é .properties e se carta foi selecionada
				somenteArquivosProperties.add(arquivosDiretorio[i]); // adciona arquivo à lista de array de arquivos properties conforme cartas selecionadas para o jogo
		
			}
		}
		setNumeroTotalConceito(somenteArquivosProperties.size()); // numero de cartas conceito total que o baralho terá
		CartaBonificacao [] cartaconceito = new CartaBonificacao[getNumeroTotalConceito()];	// vetor que aloja cartas conceito do jogo

		for(int i=0;i<somenteArquivosProperties.size();i++)	{ // irá abrir todos os arquivos e extrair dados deles
			try {
				//construindo a carta com dados do arquivo cujo nome está na posicao i do vetor de arquivos do diretorio
				cartaconceito[i] = repositorio.obterCartaConceito(dificuldade + File.separator + somenteArquivosProperties.get(i));; 	
			}
			catch (NoSuchElementException noSuchElementException){//se os dados estiverem fora do formato ou se não haver mais dados para saída, há problema*/
				System.exit(1);	//jogo termina sem êxito devido ao problema
			}
		}
		return cartaconceito;
	}
	//#endif

	//#ifdef ConceptCard
	//TODO: Refatorar.
	public boolean selecionarCartaConceito  (int [] cartasConceitoSelecionadas, String cartaAtual){
		for (int i=0;i<cartasConceitoSelecionadas.length;i++){
			if(cartasConceitoSelecionadas[i]==ModeGameConstants.ALL_CARDS_CONCEITO)
				return true;
			if((cartasConceitoSelecionadas[i]==ModeGameConstants.CARDS_CONCEITO_CODIGO)&&(cartaAtual.startsWith(ModeGameConstants.PATH_CONCEITO_CODIGO)))
				return true;
			if((cartasConceitoSelecionadas[i]==ModeGameConstants.CARDS_CONCEITO_COMUNICACAO)&&(cartaAtual.startsWith(ModeGameConstants.PATH_CONCEITO_COMUNICACAO)))
				return true;
			if((cartasConceitoSelecionadas[i]==ModeGameConstants.CARDS_CONCEITO_DESENHO)&&(cartaAtual.startsWith(ModeGameConstants.PATH_CONCEITO_DESENHO)))
				return true;
			if((cartasConceitoSelecionadas[i]==ModeGameConstants.CARDS_CONCEITO_GERENCIA)&&(cartaAtual.startsWith(ModeGameConstants.PATH_CONCEITO_GERENCIA)))
				return true;
			if((cartasConceitoSelecionadas[i]==ModeGameConstants.CARDS_CONCEITO_RECURSOS_HUMANOS)&&(cartaAtual.startsWith(ModeGameConstants.PATH_CONCEITO_RELACIONAMENTO_HUMANO)))
				return true;
			if((cartasConceitoSelecionadas[i]==ModeGameConstants.CARDS_CONCEITO_REQUISITOS)&&(cartaAtual.startsWith(ModeGameConstants.PATH_CONCEITO_REQUISITOS)))
				return true;
		}
		return false;
	}
	//#endif

	public CartaPenalizacao[] inicializarCartasProblemas(String dificuldade,int [] cartasProblemaSelecionadas){

		String[] arquivosDiretorio = repositorio.getNomeArquivosPasta(dificuldade);							//preenhendo um vetor de string com nome dos arquivos do diretorio

		ArrayList <String> somenteArquivosProperties = new ArrayList <String>();
		for (int i=0;i<arquivosDiretorio.length;i++){
			if((arquivosDiretorio[i].endsWith(".properties")) && (selecionarCartaProblema(cartasProblemaSelecionadas,arquivosDiretorio[i])==true)) { // testando se arquivo do diretório é .properties e se carta foi selecionada
				somenteArquivosProperties.add(arquivosDiretorio[i]); // adciona arquivo à lista de array de arquivos properties conforme cartas selecionadas para o jogo
			}
		}

		setNumeroTotalProblemas(somenteArquivosProperties.size()); // numero de cartas problema total que o baralho terá

		CartaPenalizacao [] cartaproblema = new CartaPenalizacao[getNumeroTotalProblemas()]; // vetor que aloja cartas problema do jogo

		for(int i=0; i<somenteArquivosProperties.size(); i++){// irá abrir todos os arquivos e extrair dados deles
			try {
				// construindo a carta com dados do arquivo cujo nome está na posicao i do vetor de arquivos do diretorio	
				cartaproblema[i] = repositorio.obterCartaPenalizacao(dificuldade + File.separator + somenteArquivosProperties.get(i));
			}
			catch (NoSuchElementException noSuchElementException){//se os dados estiverem fora do formato ou se não haver mais dados para saída, há problema
				System.exit(1);	 // jogo termina sem êxito devido ao problema
			}
		}
		return cartaproblema;
	}

	//TODO: Refatorar.
	public boolean selecionarCartaProblema  (int [] cartasProblemaSelecionadas, String cartaAtual)
	{
		for (int i=0;i<cartasProblemaSelecionadas.length;i++){
			if(cartasProblemaSelecionadas[i]==ModeGameConstants.ALL_CARDS_PROBLEMA)
				return true;
			if((cartasProblemaSelecionadas[i]==ModeGameConstants.CARDS_PROBLEMA_CODIGO)&&(cartaAtual.startsWith(ModeGameConstants.PATH_PROBLEMA_CODIGO)))
				return true;
			if((cartasProblemaSelecionadas[i]==ModeGameConstants.CARDS_PROBLEMA_COMUNICACAO)&&(cartaAtual.startsWith(ModeGameConstants.PATH_PROBLEMA_COMUNICACAO)))
				return true;
			if((cartasProblemaSelecionadas[i]==ModeGameConstants.CARDS_PROBLEMA_DESENHO)&&(cartaAtual.startsWith(ModeGameConstants.PATH_PROBLEMA_DESENHO)))
				return true;
			if((cartasProblemaSelecionadas[i]==ModeGameConstants.CARDS_PROBLEMA_GERENCIA)&&(cartaAtual.startsWith(ModeGameConstants.PATH_PROBLEMA_GERENCIA)))
				return true;
			if((cartasProblemaSelecionadas[i]==ModeGameConstants.CARDS_PROBLEMA_RECURSOS_HUMANOS)&&(cartaAtual.startsWith(ModeGameConstants.PATH_PROBLEMA_RELACIONAMENTO_HUMANO)))
				return true;
			if((cartasProblemaSelecionadas[i]==ModeGameConstants.CARDS_PROBLEMA_REQUISITOS)&&(cartaAtual.startsWith(ModeGameConstants.PATH_PROBLEMA_REQUISITOS)))
				return true;
		}
		return false;
	}

	public CartaEngenheiro[] inicializarCartasEngenheiro(String dificuldade)
	{
		String[] arquivosDiretorio = repositorio.getNomeArquivosPasta(dificuldade);	

		ArrayList <String> somenteArquivosProperties = new ArrayList <String>();
		for (int i=0;i<arquivosDiretorio.length;i++){
			if(arquivosDiretorio[i].endsWith(".properties"))//testando se arquivo do diretório é .properties
				somenteArquivosProperties.add(arquivosDiretorio[i]);// adciona arquivo à lista de array de arquivos properties
		}

		setNumeroTotalEngenheiro(somenteArquivosProperties.size()); // numero de cartas de engenheiros total que o baralho terá
		CartaEngenheiro[] cartaengenheiro = new CartaEngenheiro[getNumeroTotalEngenheiro()]; // vetor de todas as cartas de engenheiro

		for(int i=0;i<somenteArquivosProperties.size();i++){//irá abrir todos os arquivos e extrair dados deles
			try	{
				cartaengenheiro[i]= repositorio.obterCartaEngenheiro(dificuldade + File.separator + somenteArquivosProperties.get(i)); // construindo a carta com dados do arquivo cujo nome está na posicao i do vetor de arquivos do diretorio	
			}
			catch (NoSuchElementException noSuchElementException){ // se os dados estiverem fora do formato ou se não haver mais dados para saída, há problema
				System.exit(1);	// jogo termina sem êxito devido ao problema
			}
		}										
		return cartaengenheiro;
	}

	/**
	 * vai deixar as cartas de engenheiro retiradas do baralho nas ultimas posições e embaralhar o baralho restante.
	 */
	public void embaralharInicial(){
		int ultimaCartaValida = getNumeroTotalCartas()-1;//será a posicao da ultima carta do baralho não null
		for (int i=0;i<getNumeroTotalEngenheiro(); i++){//for precisa ser rodado até o fim das cartas de engenheiro no baralho
			if (baralho[i]==null){//caso a carta seja nula
				baralho[i]=baralho[ultimaCartaValida]; //a ultima carta (existente) do baralho ocupa a posicao desta nula
				baralho[ultimaCartaValida]=null; //a carta nula vai ocupar o lugar da última carta existente
				ultimaCartaValida--; //a utima carta válida tem posicao decrescida de 1
			}
		} //neste ponto todas as cartas null estáo no final do baralho

		embaralhar();

	}

	public void embaralhar(){
		Random sorteio = new Random();
		for (int primeiro=0;primeiro<getNumeroCartasBaralhoAtual();primeiro++)//embaralha cartas restantes, excluindo as cartas inexistentes						
		{
			int segundo = sorteio.nextInt(getNumeroCartasBaralhoAtual());
			Carta temporaria = baralho[primeiro];
			baralho[primeiro]=baralho[segundo];
			baralho[segundo]=temporaria;
		}
	}

	public Carta darCartaInicial(int posicaoCarta){
		if (baralho[posicaoCarta]!=null){
			setNumeroCartasBaralhoAtual(getNumeroCartasBaralhoAtual()-1);
			Carta temporaria = baralho[posicaoCarta];
			baralho[posicaoCarta]=null;
			return temporaria;
		}
		else {
			return null;
		}
	}

	public Carta darCarta(){//Distribui uma carta
		if (baralho[currentCard]!=null){//Determina se ainda há carta a ser distribuída
			setNumeroCartasBaralhoAtual(getNumeroCartasBaralhoAtual()-1); // Diminui o número de cartas que o baralho contém
			Carta temporaria = baralho[currentCard];
			baralho[currentCard]=null;
			this.currentCard++;	// Incrementa índice da próxima carta a ser distribuída
			return temporaria;
		}
		else
			return null; // Retorna nulo para indicar que baralho está vazio
	}

	public void recolherCarta(Carta cartaDevolvida){
		baralho[getNumeroCartasBaralhoAtual()]=cartaDevolvida;	// colocando carta no baralho
		setNumeroCartasBaralhoAtual(getNumeroCartasBaralhoAtual() + 1);	// adicionando carta ao baralho que recolhe carta
	}






	public int getNumeroTotalCartas() 
	{
		return numeroTotalCartas;
	}


	public void setNumeroTotalCartas(int numeroTotalCartas) 
	{
		this.numeroTotalCartas = numeroTotalCartas;
	}


	public int getNumeroTotalEngenheiro() 
	{
		return numeroTotalEngenheiro;
	}


	public void setNumeroTotalEngenheiro(int numeroTotalEngenheiro) 
	{
		this.numeroTotalEngenheiro = numeroTotalEngenheiro;
	}


	public int getNumeroTotalProblemas() 
	{
		return numeroTotalProblemas;
	}


	public void setNumeroTotalProblemas(int numeroTotalProblemas) 
	{
		this.numeroTotalProblemas = numeroTotalProblemas;
	}


	//#ifdef ConceptCard
	public int getNumeroTotalConceito()
	{
		return numeroTotalConceito;
	}
	//#endif


	//#ifdef ConceptCard
	public void setNumeroTotalConceito(int numeroTotalConceito)
	{
		this.numeroTotalConceito = numeroTotalConceito;
	}
	//#endif


	public int getNumeroCartasBaralhoAtual() 
	{
		return numeroCartasBaralhoAtual;
	}

	public void setNumeroCartasBaralhoAtual(int numeroCartasBaralho) 
	{
		this.numeroCartasBaralhoAtual = numeroCartasBaralho;
	}

	public int getCurrentCard() 
	{
		return currentCard;
	}

	public void setCurrentCard(int currentCard) 
	{
		this.currentCard = currentCard;
	}







}
