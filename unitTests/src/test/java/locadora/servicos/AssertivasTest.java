package locadora.servicos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import locadora.entidades.Usuario;

public class AssertivasTest {

    @Test
    public void test() {
        assertTrue(true);
        assertFalse(false);
        
        assertEquals("Erro de comparação!", 1, 1);
        assertEquals(0.51, 0.52, 0.1);
        assertEquals(Math.PI, 3.14, 0.01);
        
        int i = 5;
        Integer i2 = 5;
        assertEquals(Integer.valueOf(i), i2);
        assertEquals(i, i2.intValue());
        
        assertEquals("bola", "bola");
        assertTrue("bola".equalsIgnoreCase("Bola"));
        assertTrue("bola".startsWith("bola"));
        
        Usuario usuario1 = new Usuario("Usuario 1");
        Usuario usuario2 = new Usuario("Usuario 1");
        Usuario usuario3 = usuario2;
        Usuario usuario4 = null;
        
        assertEquals(usuario1, usuario2); // Equals on Usuario class
        
        assertSame(usuario2, usuario3);
        assertNotSame(usuario1, usuario2);
        
        assertNull(usuario4);
        assertNotNull(usuario3);
    }

}
