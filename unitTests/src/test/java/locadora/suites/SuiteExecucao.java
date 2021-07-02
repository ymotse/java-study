package locadora.suites;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import locadora.servicos.CalculadoraTest;
import locadora.servicos.CalculoValorLocacaoTest;
import locadora.servicos.LocacaoServiceTest;

@RunWith(Suite.class)
@SuiteClasses({
    CalculadoraTest.class,
    CalculoValorLocacaoTest.class,
    LocacaoServiceTest.class
})
public class SuiteExecucao {
    
    @BeforeClass
    public static void before() {
        System.out.println("before");
    }
    
    @AfterClass
    public static void after() {
        System.out.println("after");
    }
    
}
