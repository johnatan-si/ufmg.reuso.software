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
public class CartaBonificacao extends Carta{
	
	private String referenciaBibliografica;
	private int duracaoEfeito;
	private int custoEfeito;
	private int quantidadePrimeiroEfeito; // contém quanto de efeito será gerado.
	private int quantidadeSegundoEfeito; // contém quanto de efeito será gerado.
	private int tipoPrimeiroEfeito; // será igual a uma das constantes de efeitos oriundos de carta conceito de Constants.java 
	private int tipoSegundoEfeito; // será igual a uma das constantes de efeitos oriundos de carta conceito de Constants.java 
	
	/**
	 * Construtor que inicializa a Carta com tudo zerado.
	 */
	public CartaBonificacao (){
		super (null, null, null, CONCEITO);												
		setReferenciaBibliografica(null);
		setDuracaoEfeito(0);
		setCustoEfeito(0);
		setQuantidadePrimeiroEfeito(0);
		setQuantidadeSegundoEfeito(0);
		setTipoPrimeiroEfeito(0);
		setTipoSegundoEfeito(0);
	}
	
	//TODO: Refatorar
	public CartaBonificacao (String titulo, String codigo, String texto, String referencia, int duracao, int custo, int efeito1, int efeito2, int quantidade1, int quantidade2){ 
		super (titulo, codigo, texto,CONCEITO);												
		setReferenciaBibliografica(referencia);
		setDuracaoEfeito(duracao);
		setCustoEfeito(custo);
		setQuantidadePrimeiroEfeito(quantidade1);
		setQuantidadeSegundoEfeito(quantidade2);
		setTipoPrimeiroEfeito(efeito1);
		setTipoSegundoEfeito(efeito2);
	}
	
	public void inserirEfeito(){
		if (codigoCarta=="a"){
			//TODO[MD]para cada codigo, descrever o que será feito
		}
	}
	
	public int getDuracaoEfeito(){
		return duracaoEfeito;
	}

	public void setDuracaoEfeito(int duracaoEfeito){
		this.duracaoEfeito = duracaoEfeito;
	}

	public int getCustoEfeito(){
		return custoEfeito;
	}

	public void setCustoEfeito(int custoEfeito){
		this.custoEfeito = custoEfeito;
	}

	public String getReferenciaBibliografica(){
		return referenciaBibliografica;
	}

	public void setReferenciaBibliografica(String referenciaBibliografica){
		this.referenciaBibliografica = referenciaBibliografica;
	}

	public int getQuantidadePrimeiroEfeito(){
		return quantidadePrimeiroEfeito;
	}

	public void setQuantidadePrimeiroEfeito(int quantidadePrimeiroEfeito){
		this.quantidadePrimeiroEfeito = quantidadePrimeiroEfeito;
	}

	public int getQuantidadeSegundoEfeito(){
		return quantidadeSegundoEfeito;
	}

	public void setQuantidadeSegundoEfeito(int quantidadeSegundoEfeito){
		this.quantidadeSegundoEfeito = quantidadeSegundoEfeito;
	}

	public int getTipoPrimeiroEfeito(){
		return tipoPrimeiroEfeito;
	}

	public void setTipoPrimeiroEfeito(int tipoPrimeiroEfeito){
		this.tipoPrimeiroEfeito = tipoPrimeiroEfeito;
	}

	public int getTipoSegundoEfeito(){
		return tipoSegundoEfeito;
	}

	public void setTipoSegundoEfeito(int tipoSegundoEfeito){		
		this.tipoSegundoEfeito = tipoSegundoEfeito;
	}
	
}
