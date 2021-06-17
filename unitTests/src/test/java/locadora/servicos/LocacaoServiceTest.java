package locadora.servicos;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Date;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import locadora.entidades.Filme;
import locadora.entidades.Locacao;
import locadora.entidades.Usuario;
import locadora.utils.DataUtils;

public class LocacaoServiceTest {
    
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    
    @Test
    public void alugarFilme_retornaLocacao_quantoBemSucedido() throws Exception {
        //# cenario:
        LocacaoService service = new LocacaoService();
        Usuario usuario = new Usuario("Usuario 1");
        Filme filme = new Filme("Filme 1", 1, 5.0);
        
        //# acao:
        Locacao locacao = service.alugarFilme(usuario, filme);

        //# verificacao:
        assertTrue(locacao.getValor() == 5.0);
        assertThat(locacao.getValor(), is(equalTo(5.0)));
        assertThat(locacao.getValor(), is(not(6.0)));
        
        assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
        assertThat(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()), is(true));
        
        assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
    }
    
    @Test(expected = Exception.class)
    public void alugarFilme_esperadoExcecao_quandoFilmeSemEstoque() throws Exception {
        LocacaoService service = new LocacaoService();
        Usuario usuario = new Usuario("Usuario 1");
        Filme filme = new Filme("Filme 1", 0, 5.0);
        
        service.alugarFilme(usuario, filme);
    }
    
    @Test
    public void alugarFilme_esperadoExcecao_quandoFilmeSemEstoque_2() throws Exception {
        LocacaoService service = new LocacaoService();
        Usuario usuario = new Usuario("Usuario 1");
        Filme filme = new Filme("Filme 1", 0, 5.0);
        
        expectedException.expect(Exception.class);
        expectedException.expectMessage("Filme sem estoque!");

        service.alugarFilme(usuario, filme);
    }
    
    @Test
    public void alugarFilme_lancadoExcecao_quandoFilmeSemEstoque() {
        LocacaoService service = new LocacaoService();
        Usuario usuario = new Usuario("Usuario 1");
        Filme filme = new Filme("Filme 1", 0, 5.0);
        
        try {
            service.alugarFilme(usuario, filme);
            fail("Deveria lancar uma excecao");
        } catch (Exception e) {
            assertThat(e.getMessage(), is("Filme sem estoque!"));
        }
    }
    
}
