/*
 * Federal University of Minas Gerais 
 * Department of Computer Science
 * Simules-SPL Project
 *
 * Created by Michael David
 * Date: 16/07/2011
 */


package br.ufmg.reuso.negocio.jogador;

/**
 * @author Michael David
 *
 */
import br.ufmg.reuso.negocio.carta.Carta;
import br.ufmg.reuso.negocio.carta.CartaEngenheiro;
import br.ufmg.reuso.negocio.dado.Dado;
import br.ufmg.reuso.negocio.jogo.Jogo;
import br.ufmg.reuso.negocio.tabuleiro.Tabuleiro;

public class Jogador{
	
	private static final int NUMERO_MAX_CARTAS_MAO = 5;	//numero maximo de cartas que o jogador pode ter em mãos.
	private String nome; //contém o nome do jogador
	private int saldo; //contém o saldo que o jogador tem para utilizar (limite é orcamento do projeto)
	private Tabuleiro tabuleiro;
	private boolean dadoJogado;  //se true, jogador jogou dados, senão nao jogou
	private Carta[] cartas = new Carta[NUMERO_MAX_CARTAS_MAO]; //conjunto de cartas na mao do jogador 
	private int numeroCartasMaoAtual; //numero real de cartas em mãos no decorrer do jogo
	
	public Jogador (String nomeJogador, int orcamentoInicial){
		
		setNome(nomeJogador);
		setSaldo(orcamentoInicial);
		setNumeroCartasMaoAtual(0);		
		setDadoJogado(false);
		
		for (int i=0; i<NUMERO_MAX_CARTAS_MAO; i++){
			cartas[i] = null;// iniciando como carta inexistente
		}
		
		tabuleiro = new Tabuleiro();// criando tabuleiro do jogador
	}
	
	//TODO: Refatorar
	public void contratarEngenheiro(Carta novato, int posicaoMesa){
		if(novato instanceof CartaEngenheiro){//Utilizando uma verificação se novato está instanciando uma carta de entenheiro
	
			if(tabuleiro.getMesas()[posicaoMesa].getCartaMesa()!= null) {
				Jogo.getJogo().setupController.exibirExcessoPessoal();
			}
			
			if(tabuleiro.getMesas()[posicaoMesa].getCartaMesa()==null){//Verificando se não há engenheiro na mesa, ou seja, se a mesa está vazia	
				CartaEngenheiro Contratado = (CartaEngenheiro) novato;// se sim, acontece uma coreção (downcast)
				
				if (getSaldo() < Contratado.getSalarioEngenheiro()){
					Jogo.getJogo().setupController.exibirFaltaDinheiro();
				}
				
				if (getSaldo() >= Contratado.getSalarioEngenheiro()){// Verificando se há saldo suficiente				
					setSaldo(this.saldo - Contratado.getSalarioEngenheiro()); // atualizando saldo do jogador devido ao salario do engenheiro
					tabuleiro.alocarMesa(Contratado,posicaoMesa);//  Contrata engenheiro
					
					for (int i=0;i<getCartas().length;i++){
						if (getCartas()[i]==null) {
							continue;
						}
						if (getCartas()[i].getCodigoCarta().compareTo(novato.getCodigoCarta())==0){ // Se a na mao de jogador e a carta de engenheeiro a ser contratado são iguais
							getCartas()[i]=null; // Retira-se a carta da mão do jogador, pois ela agora está no tabuleiro
							setNumeroCartasMaoAtual(getNumeroCartasMaoAtual() -1); // Atualiza o número de cartas na mao do jogador
						}
							
					}
										
				}
				
			}
			
		}
	}
	
	public int analisarPontuacao(){
		
		int numberCards;
		numberCards = Dado.contarPontos();
		Jogo.getJogo().setupController.mostrarPontosObtidosInicial(numberCards); // exibe a Gui mostrando pontos obtidos pelo jogador no lançamento de dados
		
		if ((getNumeroCartasMaoAtual() + numberCards) <= NUMERO_MAX_CARTAS_MAO) {
			return numberCards;
		}
		else{
			Jogo.getJogo().setupController.mostrarNumberCardasDelivered(NUMERO_MAX_CARTAS_MAO - getNumeroCartasMaoAtual()); // exibe a GUI mostrando o número de cartas recebidas respeito o limite de cartas na mao
			return (NUMERO_MAX_CARTAS_MAO - getNumeroCartasMaoAtual());
		}
		
	}
	
	public void receberCarta(Carta cartaRecebida){
		int i = 0;
		
		while (cartas[i]!= null){ // verificando se já existe carta na posição i
			i++;
		}
		if (i > NUMERO_MAX_CARTAS_MAO){	//Se a posição no vetor de cartas ultrapassar o número de cartas limite, há erro
			System.exit(1);
		}
		cartas[i]=cartaRecebida;// jogador recebe a carta
		setNumeroCartasMaoAtual(getNumeroCartasMaoAtual() +1); // atualizando o número de carta na mão do jogador
	}
	
	public void retirarCarta(Carta cartaRetirada){
		for(int i=0; i<cartas.length;i++){//percorrendo cartas na mao do jogador
			if (cartas[i]==null) {
				continue;
			}
			if(cartas[i].getCodigoCarta().compareTo(cartaRetirada.getCodigoCarta())==0){//comparando a variável código das cartas, caso elas sejam iguais, retira-se a carta do jogador	
				cartas[i]=null;	//carta do jogador retirada
				setNumeroCartasMaoAtual(getNumeroCartasMaoAtual() -1);
			}
		}
	}
	
	public boolean removerCarta(CartaEngenheiro engenheiroDemitido){
		if (tabuleiro.despedirEngenheiro(engenheiroDemitido) == true){//se true, significa que engenheiro foi demitido (ele não trabalhou na rodada)	
			setSaldo(getSaldo()+engenheiroDemitido.getSalarioEngenheiro());
			return true; // se retorna true, significa que o jogo pode remover a carta para baralho auxiliar
		}
		return false;
	}
	
	public void mostrarCartaMao(){//TODO: usado só pra teste
		System.out.printf("Cartas do jogador %s:\n",getNome());
		for (int i=0;i<NUMERO_MAX_CARTAS_MAO;i++){
			if (cartas[i]==null) {
				continue;
			}
			System.out.println("iteracao: "+i);
			cartas[i].mostrarCarta();
		}
	}
	
	public int contarModuloJaIntegrado(){
		int moduloJaIntegrado =0;
		for (int i=0;i<tabuleiro.getMesas().length;i++){
			if(tabuleiro.getMesas()[i].getModuloJaIntegrado()==true)
				moduloJaIntegrado++;
		}
		
		return moduloJaIntegrado;
	}
	
	public Tabuleiro getTabuleiro(){
		return tabuleiro;
	}

	public void setTabuleiro(Tabuleiro tabuleiro){
		this.tabuleiro = tabuleiro;
	}

	public int getNumeroCartasMaoAtual(){
		return numeroCartasMaoAtual;
	}
	
	public void setNumeroCartasMaoAtual(int numeroCartasMao){
		this.numeroCartasMaoAtual = numeroCartasMao;
	}
	
	public String getNome(){
		return nome;
	}
	
	public void setNome(String nome){
		this.nome = nome;
	}
	
	public int getSaldo(){
		return saldo;
	}
	
	public void setSaldo(int saldo){
		this.saldo = saldo;
	}

	public Carta[] getCartas(){
		return cartas;
	}

	public void setCartas(Carta[] cartas){
		this.cartas = cartas;
	}
	
	public boolean isDadoJogado(){
		return dadoJogado;
	}

	public void setDadoJogado(boolean dadoJogado){
		this.dadoJogado = dadoJogado;
	}
	
}
