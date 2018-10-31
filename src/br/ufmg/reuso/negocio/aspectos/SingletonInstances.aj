package br.ufmg.reuso.negocio.aspectos;

import br.ufmg.reuso.negocio.baralho.factory.CreatorBaralhoArtefatos;

/**
 * @author  Joao Paulo
 * Utilizando SingletonProtocol, de Hannemann & Kiczales, 
 * para definir quais classes que devem ser Singleton.
 */
public aspect SingletonInstances extends SingletonProtocol{ 
    
    /*
     * Configurar abaixo, assinalando Singleton para todas  
     * as classes que devem usar este Design Pattern.
     */
  
	/**
	 * <code>CreatorBaralhoArtefatos</code> deve ser Singleton neste projeto.
	 */
	declare parents: CreatorBaralhoArtefatos implements Singleton;		                	
}