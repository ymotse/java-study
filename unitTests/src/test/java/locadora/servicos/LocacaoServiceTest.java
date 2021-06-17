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
import locadora.excecoes.FilmeSemEstoqueException;
import locadora.excecoes.LocadoraException;
import locadora.utils.DataUtils;

public class LocacaoServiceTest {
    
    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    
    @Test
    public void alugarFilme_retornaLocacao_quandoBemSucedido() throws Exception {
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
    
    @Test(expected = FilmeSemEstoqueException.class)
    public void alugarFilme_esperadoExcecao_quandoFilmeSemEstoque() throws Exception {
        LocacaoService service = new LocacaoService();
        Usuario usuario = new Usuario("Usuario 1");
        Filme filme = new Filme("Filme 1", 0, 5.0);
        
        service.alugarFilme(usuario, filme);
    }
    
    @Test
    public void alugarFilme_retornaExcecao_quandoUsuarioVazio() throws FilmeSemEstoqueException {
        //#cenario
        LocacaoService locacaoService = new LocacaoService();
        Filme filme = new Filme("Filme 2", 1, 4.0);
        
        //#acao
        try {
            locacaoService.alugarFilme(null, filme);
            fail();
        } catch (LocadoraException e) {
            assertThat(e.getMessage(), is("Usuário vazio"));
        }
    }
    
    @Test
    public void alugarFilme_retornaExcecao_quandoFilmeVazio() throws LocadoraException, FilmeSemEstoqueException {
        //#cenario
        LocacaoService locacaoService = new LocacaoService();
        Usuario usuario = new Usuario("Usuário 1");
        
        expectedException.expect(LocadoraException.class);
        expectedException.expectMessage("Filme vazio");

        //#acao
        locacaoService.alugarFilme(usuario, null);
    }
}
