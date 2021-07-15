package locadora.servicos;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

public class CalculadoraMockTest {
    
    @Mock
    private Calculadora calcMock;
    
    @Spy
    private Calculadora calcSpy;
    
    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }
    
    @Test
    public void devoMostrarDiferencaEntreMockESpy() {
        
        Mockito.when(calcMock.somar(1, 2)).thenReturn(9);
        Mockito.when(calcSpy.somar(1, 2)).thenReturn(9);
        
        System.out.println("Mock: " + calcMock.somar(1, 5)); // 0
        System.out.println("Spy : " + calcSpy.somar(1, 5));  // 6
        
        Mockito.when(calcMock.somar(1, 2)).thenCallRealMethod();
        System.out.println("Mock: " + calcMock.somar(1, 2)); // 3
        
        
        System.out.println("Mock");
        calcMock.imprimir(); //Not run
        
//        Mockito.doNothing().when(calcSpy).imprimir();

        System.out.println("Spy");
        calcSpy.imprimir();
    }
    
    @Test
    public void teste() {
        Calculadora calc = Mockito.mock(Calculadora.class);
        
//        Mockito.when(calc.somar(1, 2)).thenReturn(5);
//        Mockito.when(calc.somar(Mockito.anyInt(), Mockito.anyInt())).thenReturn(5);
//        Mockito.when(calc.somar(Mockito.eq(1), Mockito.anyInt())).thenReturn(5);
        
        ArgumentCaptor<Integer> argCapt = ArgumentCaptor.forClass(Integer.class);
        Mockito.when(calc.somar(argCapt.capture(), argCapt.capture())).thenReturn(5);
        
        Assert.assertEquals(5, calc.somar(1, 80000));
        System.out.println(argCapt.getAllValues());
    }
    
}
