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
 * Classe que contém o objeto Módulo.
 * 
 * Editado por Aline Brito, Igor Muzetti (2018-02). Modificações:
 * 	- Cartas de teste adicionadas.	
 * 
 */

public class Modulo{
	
	private int requisitos;
	private int desenhos;
	private int codigos;
	private int rastros;
	private int ajudas;
	private int testes;
	
	
	/**
	 * @return o somatório de todas as variáveis inteiras do módulo.
	 */
	public int somatorioModulo(){
		return (getRequisitos()+getDesenhos()+getCodigos()+getRastros()+getAjudas());
	}
	
	
	public int getRequisitos(){
		return requisitos;
	}

	public void setRequisitos(int requisitos){
		this.requisitos = requisitos;
	}

	public int getDesenhos(){
		return desenhos;
	}

	public void setDesenhos(int desenhos){
		this.desenhos = desenhos;
	}

	public int getCodigos(){
		return codigos;
	}

	public void setCodigos(int codigos){
		this.codigos = codigos;
	}

	public int getRastros(){
		return rastros;
	}

	public void setRastros(int rastros){
		this.rastros = rastros;
	}

	public int getAjudas(){
		return ajudas;
	}

	public void setAjudas(int ajudas){
		this.ajudas = ajudas;
	}
	

	public int getTestes() {
		return testes;
	}


	public void setTestes(int testes) {
		this.testes = testes;
	}


	@Override
	public String toString(){
		
		String modules = "";
		
		if (this.getRequisitos() > 0){
			modules += (Integer.toString(this
					.getRequisitos()) + " RQ");
		}
		if (this.getDesenhos() > 0){
			modules += (" + "
				+ Integer.toString(this
						.getDesenhos()) + "DS");
		}
		if (this.getCodigos() > 0){
			modules += (" + "
				+ Integer.toString(this
						.getCodigos()) + "CD");
		}
		if (this.getRastros() > 0){
			modules += (" + "
				+ Integer.toString(this
						.getRastros()) + "RS");
		}
		if (this.getAjudas() > 0){
			modules += (" + "
				+ Integer.toString(this
						.getAjudas()) + "AJ");
		}
		
		if (this.getTestes() > 0){
			modules += (" + "
				+ Integer.toString(this
						.getTestes()) + "TE");
		}
		
			
		return modules;
	}
	
}
