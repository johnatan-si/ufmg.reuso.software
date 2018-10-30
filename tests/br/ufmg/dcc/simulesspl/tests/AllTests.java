package br.ufmg.dcc.simulesspl.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ufmg.dcc.simulesspl.tests.cartas.AllCartasTests;
import br.ufmg.dcc.simulesspl.tests.cartas.ArtefatoTest;
import br.ufmg.dcc.simulesspl.tests.jogo.DadoTest;
import br.ufmg.dcc.simulesspl.tests.jogo.JogoTest;
import br.ufmg.dcc.simulesspl.tests.modulo.ModuloTest;
import br.ufmg.dcc.simulesspl.tests.tabuleiro.TabuleiroTest;




@RunWith(Suite.class)
@SuiteClasses({ JogoTest.class, ModuloTest.class , ArtefatoTest.class, DadoTest.class,TabuleiroTest.class, AllCartasTests.class})
public class AllTests {

}
