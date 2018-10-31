package br.ufmg.dcc.simulesspl.tests.cartas;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ArtefatoTest.class,
		CartaEngenheiroTest.class, CartaEngenheiroTest.class,
		CartaoProjetoTest.class,
		InteracaoJogoCartaArtefatoTest.class, 
		InteracaoJogoCartaConceitoTest.class,
		InteracaoJogoCartaEngenheiroDeSoftwareTest.class,
		InteracaoJogoCartaProblema.class,
		InteracaoJogoCartasTest.class,
		InteracaoTabuleiroCartaEngenheiroTest.class,
		InteracaoMesaCartaArtefato.class})
public class AllCartasTests{

}
