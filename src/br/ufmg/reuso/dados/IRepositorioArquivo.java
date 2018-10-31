package br.ufmg.reuso.dados;

import java.util.Properties;

public interface IRepositorioArquivo{
	
	public Properties getArquivoProperties(String nome);
	
	public String[] getNomeArquivosPasta(String nome);
}
