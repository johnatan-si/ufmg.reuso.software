/*
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * Simules-SPL Project
 *
 * Created by Michael David
 * Date: 16/07/2011
 */

package br.ufmg.reuso.negocio.tabuleiro;

/**
 * @author Michael David
 *
 */

import java.util.ArrayList;

import br.ufmg.reuso.negocio.carta.CartaEngenheiro;
import br.ufmg.reuso.negocio.jogo.Jogo;
import br.ufmg.reuso.negocio.mesa.Mesa;


public class Tabuleiro 
{
	public static final int NUMERO_MAX_MESAS_TABULEIRO = 5;				/** definindo número máximo de mesas no tabuleiro*/
	private Mesa[] mesas = new Mesa[NUMERO_MAX_MESAS_TABULEIRO];		/** criando as mesas do tabuleiro*/
	
	/*----------------------EFEITOS DA CARTA CONCEITO PERMANENTES---------------------------------*/
	
	/** variável que aumentará o orçamento do projeto para o tabuleiro num momento do jogo devido a benefícios*/
	private int efeitoPositivoOrcamento;

	/**vetor de String contém o nome do engenheiro na posição 0 e a quantidade do efeito na posição 1*/
	private ArrayList <String[]> efeitoAumentarHabilidadeEngenheiroLater;
	
	/**contém o efeito de escolher o módulo  de uma mesa, na fase de Validacao, para ser neutralizado nessa fase*/
	private boolean efeitoModuloIntegradoNeutralizadoValidacao; 
	
	/**contém o efeito de neutralizar os artefatos de ajuda, de todas as mesas, na fase de Validacao*/
	private boolean efeitoHelpArtifactsNeutralizadoValidacao;
	
	/**contém o efeito de neutralizar cartas problema relacionadas a artefatos de codigo*/
	private boolean efeitoProblemaArtefatoCodigoNeutralizado;
	
	/**contém o efeito de neutralizar cartas problema relacionadas a artefatos de rastros*/
	private boolean efeitoProblemaArtefatoRastroNeutralizado;

	/**contém o efeito de neutralizar cartas problema relacionadas a artefatos de requisitos*/
	private boolean efeitoProblemaArtefatoRequisitosNeutralizado;
	
	/*--------------------EFEITOS DA CARTA PROBLEMA PERMANENTES-----------------------------------*/
	
	/**contém o efeito de aumentar a dificuldade em inspecionar Artefatos*/
	private int efeitoAdicionaDificuldadeInspecionarArtefatos;
	
	/**contém o efeito de aumentar a dificuldade em corrigir Artefatos*/
	private int efeitoAdicionaDificuldadeCorrigirArtefatos;
	
	/**contém o efeito de aumentar a complexidade do projeto*/
	private int efeitoAdicionaComplexidadeProjeto;
	
	/**contém o efeito de aumentar a qualidade do projeto (limite da qualidade na Validacao é igual ao tamanho do projeto)*/
	private int efeitoAdicionaQualidadeProjeto;
	
	/**contém o efeito de demitir engenheiros do jogador no fim da rodada*/
	private ArrayList <String> efeitoDemitirEngenheiroLater;
	
	/** variável que diminuirá o orçamento do projeto para o tabuleiro num momento do jogo devido a problemas*/
	private int efeitoNegativoOrcamento;
	
	
	/*---------------------------------------------------------------------------------------*/
	public Tabuleiro (){
		this.efeitoPositivoOrcamento=0;								/**não há efeito algum no início do jogo*/
		
		efeitoAumentarHabilidadeEngenheiroLater= new ArrayList <String[]>();		
		
		efeitoModuloIntegradoNeutralizadoValidacao = false;	/**não há efeito algum no início do jogo*/
		efeitoHelpArtifactsNeutralizadoValidacao = false;	/**não há efeito algum no início do jogo*/
		efeitoProblemaArtefatoRequisitosNeutralizado = false;/**não há efeito algum no início do jogo*/
		efeitoProblemaArtefatoRastroNeutralizado = false;	/**não há efeito algum no início do jogo*/
		efeitoProblemaArtefatoCodigoNeutralizado = false;	/**não há efeito algum no início do jogo*/
		
		efeitoAdicionaDificuldadeInspecionarArtefatos = 0;
		efeitoAdicionaDificuldadeCorrigirArtefatos = 0;
		efeitoAdicionaComplexidadeProjeto = 0;
		efeitoAdicionaQualidadeProjeto = 0;
		efeitoDemitirEngenheiroLater = new ArrayList <String> ();
		efeitoNegativoOrcamento = 0;
		
		
		
		for (int i=0;i<NUMERO_MAX_MESAS_TABULEIRO;i++){
			mesas [i]= new Mesa();							//inicializando mesas
		}
		
	}
	
	public Mesa[] getMesas(){
		return mesas;
	}

	public void setMesas(Mesa[] mesas){
		this.mesas = mesas;
	}

	public int getEfeitoPositivoOrcamento(){
		return efeitoPositivoOrcamento;
	}

	public void setEfeitoPositivoOrcamento(int efeitoOrcamento){
		this.efeitoPositivoOrcamento = efeitoOrcamento;
	}
	
	public ArrayList<String[]> getEfeitoAumentarHabilidadeEngenheiroLater(){
		return efeitoAumentarHabilidadeEngenheiroLater;
	}

	public void setEfeitoAumentarHabilidadeEngenheiroLater 	(ArrayList<String[]> efeitoAumentarHabilidadeEngenheiroLater){
		this.efeitoAumentarHabilidadeEngenheiroLater = efeitoAumentarHabilidadeEngenheiroLater;
	}

	public boolean isEfeitoModuloIntegradoNeutralizadoValidacao(){
		return efeitoModuloIntegradoNeutralizadoValidacao;
	}

	public void setEfeitoModuloIntegradoNeutralizadoValidacao(boolean efeitoModuloIntegradoNeutralizadoValidacao){
		this.efeitoModuloIntegradoNeutralizadoValidacao = efeitoModuloIntegradoNeutralizadoValidacao;
	}

	public boolean isEfeitoHelpArtifactsNeutralizadoValidacao(){
		return efeitoHelpArtifactsNeutralizadoValidacao;
	}

	public void setEfeitoHelpArtifactsNeutralizadoValidacao(boolean efeitoHelpArtifactsNeutralizadoValidacao){
		this.efeitoHelpArtifactsNeutralizadoValidacao = efeitoHelpArtifactsNeutralizadoValidacao;
	}

	public boolean isEfeitoProblemaArtefatoCodigoNeutralizado(){
		return efeitoProblemaArtefatoCodigoNeutralizado;
	}

	public void setEfeitoProblemaArtefatoCodigoNeutralizado(boolean efeitoProblemaArtefatoCodigoNeutralizado){
		this.efeitoProblemaArtefatoCodigoNeutralizado = efeitoProblemaArtefatoCodigoNeutralizado;
	}

	public boolean isEfeitoProblemaArtefatoRastroNeutralizado(){
		return efeitoProblemaArtefatoRastroNeutralizado;
	}

	public void setEfeitoProblemaArtefatoRastroNeutralizado(boolean efeitoProblemaArtefatoRastroNeutralizado){
		this.efeitoProblemaArtefatoRastroNeutralizado = efeitoProblemaArtefatoRastroNeutralizado;
	}

	public boolean isEfeitoProblemaArtefatoRequisitosNeutralizado(){
		return efeitoProblemaArtefatoRequisitosNeutralizado;
	}

	public void setEfeitoProblemaArtefatoRequisitosNeutralizado(boolean efeitoProblemaArtefatoRequisitosNeutralizado){
		this.efeitoProblemaArtefatoRequisitosNeutralizado = efeitoProblemaArtefatoRequisitosNeutralizado;
	}

	public int getEfeitoAdicionaDificuldadeInspecionarArtefatos(){
		return efeitoAdicionaDificuldadeInspecionarArtefatos;
	}

	public void setEfeitoAdicionaDificuldadeInspecionarArtefatos(int efeitoAdicionaInspecionarArtefatos){
		this.efeitoAdicionaDificuldadeInspecionarArtefatos = efeitoAdicionaInspecionarArtefatos;
	}

	public int getEfeitoAdicionaDificuldadeCorrigirArtefatos(){
		return efeitoAdicionaDificuldadeCorrigirArtefatos;
	}

	public void setEfeitoAdicionaDificuldadeCorrigirArtefatos(int efeitoAdicionaCorrigirArtefatos){
		this.efeitoAdicionaDificuldadeCorrigirArtefatos = efeitoAdicionaCorrigirArtefatos;
	}

	public int getEfeitoAdicionaComplexidadeProjeto(){
		return efeitoAdicionaComplexidadeProjeto;
	}

	public void setEfeitoAdicionaComplexidadeProjeto(int efeitoAdicionaComplexidadeProjeto){
		this.efeitoAdicionaComplexidadeProjeto = efeitoAdicionaComplexidadeProjeto;
	}

	public int getEfeitoAdicionaQualidadeProjeto(){
		return efeitoAdicionaQualidadeProjeto;
	}

	public void setEfeitoAdicionaQualidadeProjeto(int efeitoAdicionaQualidadeProjeto){	
		this.efeitoAdicionaQualidadeProjeto = efeitoAdicionaQualidadeProjeto;
	}

	public ArrayList<String> getEfeitoDemitirEngenheiroLater(){
		return efeitoDemitirEngenheiroLater;
	}

	public void setEfeitoDemitirEngenheiroLater(ArrayList<String> efeitoDemitirEngenheiroLater){
		this.efeitoDemitirEngenheiroLater = efeitoDemitirEngenheiroLater;
	}

	public int getEfeitoNegativoOrcamento(){
		return efeitoNegativoOrcamento;
	}

	public void setEfeitoNegativoOrcamento(int efeitoNegativoOrcamento){
		this.efeitoNegativoOrcamento = efeitoNegativoOrcamento;
	}

	public void alocarMesa(CartaEngenheiro novato, int posicaoMesa){
		mesas[posicaoMesa].setCartaMesa(novato);				//inserindo engenheiro novato na mesa conforme a posição escolhida
		
		System.out.printf("engenheiro alocado:\n");				// TODO teste
		mesas[posicaoMesa].getCartaMesa().mostrarCarta();		// TODO utilizado para mostrar a carta de engenheiro de software deste jogador -> ok
	}
	
	public boolean despedirEngenheiro(CartaEngenheiro engDemitido){
		
		for(int i=0;i<mesas.length;i++){
			if (mesas[i].getCartaMesa()==null)
				continue;
			/**comparando a variável código das cartas, caso elas sejam iguais, tenta-se retirar a carta de engenheiro do jogador*/
			if (mesas[i].getCartaMesa().getCodigoCarta().compareTo(engDemitido.getCodigoCarta())==0){
				if (mesas[i].getCartaMesa().isEngenheiroTrabalhouNestaRodada()==true)/**se o engenheiro já trabalhou na rodada, ele não pode ser demitido nessa rodada*/
				{
					Jogo.getJogo().setupController.exibirNaoDemiteEngenheiro();
					return false;						/**retorna que jogador não pode demitir engenheiro*/								
				}
				mesas[i].setCartaMesa(null);			/**carta da mesa do jogador retirada, logo demitiu-se o engenheiro*/ 		
				return true;							/**retorna que jogador deve demitir engenheiro*/
			}	
		}
		return false;									/**retorna que jogador não pode demitir engenheiro*/
	}
	
}
