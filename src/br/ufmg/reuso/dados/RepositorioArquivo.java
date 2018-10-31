package br.ufmg.reuso.dados;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class RepositorioArquivo implements IRepositorioArquivo{

	private Properties arquivoProperties;

	@Override
	public Properties getArquivoProperties(String nome){
		FileInputStream arquivo;
		this.arquivoProperties = new Properties();
		try{
			arquivo = new FileInputStream(nome);
			arquivoProperties.load(arquivo);
			arquivo.close();					
		} catch (FileNotFoundException e){
			e.printStackTrace();
		} catch (IOException e){
			e.printStackTrace();
		}
		return arquivoProperties;
	}
	
	@Override
	public String[] getNomeArquivosPasta(String nome){
		File pastaCartasConceito = new File(nome);						
		return pastaCartasConceito.list();	
	}


}
