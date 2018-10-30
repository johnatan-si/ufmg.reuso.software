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


import java.io.File;
import java.util.NoSuchElementException;
import java.util.Random;

import br.ufmg.reuso.dados.carta.RepositorioCartaoProjeto;
import br.ufmg.reuso.negocio.jogo.Jogo;
import br.ufmg.reuso.negocio.mesa.Modulo;
import br.ufmg.reuso.ui.ScreenControl;

public class CartaoProjeto{
	private static final String PATH = "CartaoProjeto";	//variavel referenciando o diretório CartaoProjeto no qual há os cartoes de projeto
	private int complexidade;
	private int tamanho;
	private int qualidade;
	private int orcamento;
	private String codigo;
	private String titulo;
	private String texto;
	private String referenciaBibliografica;
	private Modulo[] modulos;

	private RepositorioCartaoProjeto repositorio = new RepositorioCartaoProjeto();

	public CartaoProjeto(String codigo, String titulo, String texto, String referenciaBibliografica){
		this.codigo = codigo;
		this.titulo = titulo;
		this.referenciaBibliografica = referenciaBibliografica;
	}

	public CartaoProjeto(String facilidade){
		definirProjeto(facilidade);
	}

	//TODO: Refatorar.
	public void definirProjeto(String facilidade){

		if (facilidade.equals(Jogo.FACIL)){
			Random sorteio = new Random(); // variável para conferir valores aleatórios
			setComplexidade(2);	 // definindo complexidade do projeto com valor igual a 2
			setTamanho((sorteio.nextInt(2)+1));		// definindo tamanho do projeto com valores de 1 a 2
			setQualidade((sorteio.nextInt(getTamanho())));  // definindo qualidade do projeto conforme tamanho do projeto
			if (this.qualidade==0) {// caso qualidade seja zero 
				setQualidade(1); // ela é configurada como 1, para ter qualidade mínima
			}
			setOrcamento((sorteio.nextInt(31)+150)); // definindo orçamento de 150 a 180 

			modulos= new Modulo[getTamanho()]; // criando o número de módulos conforme o tamanho do projeto
			for (int i=0;i<modulos.length;i++) {
				modulos[i] = new Modulo(); // construindo os módulos
			}
			int contador; // controla o número do módulo para preenchimento
			for (contador = 0;contador <getTamanho(); contador++) { //preenche os módulos 
				modulos[contador].setRequisitos((sorteio.nextInt(2)+1));
				modulos[contador].setDesenhos((sorteio.nextInt(2)+1));
				modulos[contador].setCodigos((sorteio.nextInt(2)+1));
				modulos[contador].setRastros((sorteio.nextInt(2)+1));
				modulos[contador].setAjudas((sorteio.nextInt(2)+1));
			} //fim do preenchimento do módulo

		}
		if (facilidade.equals(Jogo.MODERADO)){
			Random sorteio = new Random(); // variável para conferir valores aleatórios
			setComplexidade(2);	// definindo complexidade do projeto com valor igual a 2
			setTamanho((sorteio.nextInt(3)+2));	// definindo tamanho do projeto com valores de 2 a 4
			setQualidade((sorteio.nextInt(getTamanho()))); // definindo qualidade do projeto conforme tamnho do projeto
			if (this.qualidade<2) {// caso qualidade seja zero 
				setQualidade(2);// ela é configurada como 1
			}
			setOrcamento((sorteio.nextInt(21)+190)); // definindo orçamento de 190 a 210

			modulos= new Modulo[getTamanho()]; // criando o número de módulos conforme o tamanho do projeto
			for (int i=0;i<modulos.length;i++) {
				modulos[i] = new Modulo();	 // construindo os módulos
			}
			int contador; // controla o número do mdulo para preenchimento
			for (contador = 0;contador <getTamanho(); contador++){//preenche os módulos 
				modulos[contador].setRequisitos((sorteio.nextInt(3)+1));
				modulos[contador].setDesenhos((sorteio.nextInt(3)+1));
				modulos[contador].setCodigos((sorteio.nextInt(3)+1));
				modulos[contador].setRastros((sorteio.nextInt(3)+1));
				modulos[contador].setAjudas((sorteio.nextInt(3)+1));
			}//fim do preenchimento do módulo

		}
		if (facilidade.equals(Jogo.DIFICIL)){
			String[] arquivosDiretorio = repositorio.getNomeArquivosPasta(PATH);	
			Random sorteio = new Random(); // variável para conferir valores aleatórios
			int projetoSorteado = sorteio.nextInt(arquivosDiretorio.length); // sorteia um valor que siginificará o projeto a ser selecionado para o jogo 
			CartaoProjeto c = null;
			int sentinela = -1;
			int controlador = 0;
			while (sentinela ==-1){
				if(arquivosDiretorio[projetoSorteado].endsWith(".properties")) {
					sentinela=0;												/**atualiza sentinela para sair do while*/
				}
				else {
					controlador++;
					projetoSorteado = sorteio.nextInt(arquivosDiretorio.length);/**sorteia um número novamente*/
				}
				if (controlador>=arquivosDiretorio.length) {
					sentinela=0; /**se chegar aqui, significa que pasta não tem arquivo propesties*/
				}
			}

			if (!ScreenControl.nomeProjeto.equals("padrao")){
				c = repositorio.obterCartaoProjeto(PATH + File.separator + ScreenControl.nomeProjeto);	
			}else{
				c = repositorio.obterCartaoProjeto(PATH + File.separator + arquivosDiretorio[projetoSorteado]);
			}

			try	{
				setCodigo(c.getCodigo()); // lendo o valor da chave codigo do arquivo e inserindo dados lidos em no campo codigo
				setTitulo(c.getTitulo()); // lendo o valor da chave codigo do arquivo e inserindo dados lidos em no campo titulo
				setTexto(c.getTexto());	//  lendo o valor da chave codigo do arquivo e inserindo dados lidos em no campo texto
				setReferenciaBibliografica(c.getReferenciaBibliografica());	/** lendo o valor da chave codigo do arquivo e inserindo dados lidos em no campo referenciaBibliografica*/
			}
			catch (NoSuchElementException noSuchElementException){
				//se os dados estiverem fora do formato ou se não haver mais dados para saída, há problema
				System.exit(1);	//jogo termina sem êxito devido ao problema
			}

			setComplexidade(4);	 // definindo complexidade do projeto com valor igual a 4
			setTamanho((sorteio.nextInt(3)+3)); // definindo tamanho do projeto com valores de 3 a 5
			setQualidade((sorteio.nextInt(getTamanho())));  // definindo qualidade do projeto conforme tamnho do projeto
			if (this.qualidade<3) { // caso qualidade seja zero
				setQualidade(3); // ela é configurada como 1
			}
			setOrcamento((sorteio.nextInt(21)+230)); // definindo orçamento de 230 a 250

			modulos= new Modulo[getTamanho()]; // criando o número de módulos conforme o tamanho do projeto
			/*IMP*/		for (int i=0;i<modulos.length;i++)
				modulos[i] = new Modulo(); // construindo os módulos
			int contador; // controla o número do módulo para preenchimento
			for (contador = 0;contador <getTamanho(); contador++){//preenche o módulo
				modulos[contador].setRequisitos((sorteio.nextInt(3)+2));
				modulos[contador].setDesenhos((sorteio.nextInt(3)+2));
				modulos[contador].setCodigos((sorteio.nextInt(3)+2));
				modulos[contador].setRastros((sorteio.nextInt(3)+2));
				modulos[contador].setAjudas((sorteio.nextInt(3)+2));
			}//fim do preenchimento do módulo
		}

	}

	public int getComplexidade() {
		return complexidade;
	}

	public void setComplexidade(int complexidade){
		this.complexidade = complexidade;
	}

	public int getTamanho(){
		return tamanho;
	}

	public void setTamanho(int tamanho){
		this.tamanho = tamanho;
	}

	public int getQualidade(){
		return qualidade;
	}

	public void setQualidade(int qualidade){
		this.qualidade = qualidade;
	}

	public int getOrcamento(){
		return orcamento;
	}

	public void setOrcamento(int orcamento){
		while ((orcamento%10)!=0){//garante que orçamento é um número divisível por 10
			orcamento++;
		}
		this.orcamento = orcamento;
	}

	public String getTexto(){
		return texto;
	}

	public void setTexto(String texto){
		this.texto = texto;
	}

	public String getCodigo(){
		return codigo;
	}

	public void setCodigo(String codigo){
		this.codigo = codigo;
	}

	public String getTitulo(){
		return titulo;
	}

	public void setTitulo(String titulo){
		this.titulo = titulo;
	}

	public String getReferenciaBibliografica(){
		return referenciaBibliografica;
	}

	public void setReferenciaBibliografica(String referenciaBibliografica){
		this.referenciaBibliografica = referenciaBibliografica;
	}

	public Modulo[] getModulos(){
		return modulos;
	}

	public void setModulos(Modulo[] modulos){
		this.modulos = modulos;
	}
}
