package locadora.servicos;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import locadora.excecoes.NaoPodeDividirPorZeroException;

/**
 * TDD
 * 
 * Baby steps
 * 
 * [1] Red, 
 * [2] Green, 
 * [3] Refactor
 *
 */
public class CalculadoraTest {
    
    private Calculadora calculadora;
    
    @Before
    public void setup() {
        calculadora = new Calculadora();
    }
    
    
    @Test
    public void deveSomarDoisValores() {
        //#cenario
        int a = 5;
        int b = 3;
        
        //#acao
        int resultado = calculadora.somar(a, b);
        
        //#verificacao
        assertEquals(8, resultado);
    }
    
    @Test
    public void deveDividirDoisValores() throws NaoPodeDividirPorZeroException {
        //#cenario
        int a = 8;
        int b = 2;
        
        //#acao
        int resultado = calculadora.dividir(a, b);
        
        //#verificacao
        assertEquals(4, resultado);
    }
    
    @Test(expected = NaoPodeDividirPorZeroException.class)
    public void deveLancarExcecaoAoDividirPorZero() throws NaoPodeDividirPorZeroException {
        int a = 10;
        int b = 0;
        
        calculadora.dividir(a, b);
    }
    
}
