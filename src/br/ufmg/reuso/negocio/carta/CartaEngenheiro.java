/*
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * Simules-SPL Project
 *
 * Created by Michael David
 * Date: 16/07/2011
 */

package br.ufmg.reuso.negocio.carta;

/**
 * @author Michael David
 *
 */

public class CartaEngenheiro extends Carta
{
	private String nomeEngenheiro; //variável que guarda nome do engenheiro
	private int salarioEngenheiro; //variável que guarda salário do engenheiro
	private int habilidadeEngenheiro; //variável que guarda habilidade do engenheiro
	private int maturidadeEngenheiro; //variável que guarda a maturidade do engenheiro
	private boolean engenheiroTrabalhouNestaRodada;// se true-> trabalhou, se false-> não trabalhou na rodada
	private int habilidadeEngenheiroAtual; // contém a pontos de habilidade que engenheiro tem na rodada 

	public CartaEngenheiro (String codigo, String texto, String nomeEng, int salarioEng, int habilidadeEng, int maturidadeEng){
		super ("Eng.Software", codigo, texto,ENGENHEIRO);
		setNomeEngenheiro(nomeEng);
		setSalarioEngenheiro(salarioEng);
		setHabilidadeEngenheiro(habilidadeEng);
		setHabilidadeEngenheiroAtual(getHabilidadeEngenheiro()); // habilidade atual na construção da carta do engenheiro é igual à habildade da carta
		setMaturidadeEngenheiro(maturidadeEng);
		this.engenheiroTrabalhouNestaRodada=false;
	}
		
	public String getNomeEngenheiro(){
		return nomeEngenheiro;
	}

	public void setNomeEngenheiro(String nomeEngenheiro){
		this.nomeEngenheiro = nomeEngenheiro;
	}

	public int getSalarioEngenheiro(){
		return salarioEngenheiro;
	}

	public void setSalarioEngenheiro(int salarioEngenheiro){
		this.salarioEngenheiro = salarioEngenheiro;
	}

	public int getHabilidadeEngenheiro(){
		return habilidadeEngenheiro;
	}

	public void setHabilidadeEngenheiro(int habilidadeEngenheiro){
		this.habilidadeEngenheiro = habilidadeEngenheiro;
	}

	public int getMaturidadeEngenheiro(){
		return maturidadeEngenheiro;
	}

	public void setMaturidadeEngenheiro(int maturidadeEngenheiro){
		this.maturidadeEngenheiro = maturidadeEngenheiro;
	}

	public boolean isEngenheiroTrabalhouNestaRodada(){
		return engenheiroTrabalhouNestaRodada;
	}

	public void setEngenheiroTrabalhouNestaRodada(boolean engenheiroTrabalhouNestaRodada){
		this.engenheiroTrabalhouNestaRodada = engenheiroTrabalhouNestaRodada;
	}

	public int getHabilidadeEngenheiroAtual(){
		return habilidadeEngenheiroAtual;
	}

	public void setHabilidadeEngenheiroAtual(int habilidadeEngenheiroAtual){
		this.habilidadeEngenheiroAtual = habilidadeEngenheiroAtual;
	}
	
}
