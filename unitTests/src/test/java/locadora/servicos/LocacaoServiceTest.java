package locadora.servicos;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
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
    
    LocacaoService locacaoService;
    
    private static int contador = 0;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    
    @BeforeClass
    public static void setupClass() {
        System.out.println("Before class.");
    }
    
    @AfterClass
    public static void tearDownClass() {
        System.out.println("After class.");
    }

    @Before
    public void setup() {
        contador++;
        System.out.println("Test: " + contador);
        
        locacaoService = new LocacaoService();
    }
    
    @After
    public void tearDown() {
        System.out.println("After test " + contador);
    }
    
    
    @Test
    public void alugarFilme_retornaLocacao_quandoBemSucedido() throws Exception {
        //# cenario:
        Usuario usuario = new Usuario("Usuario 1");
        List<Filme> filmes = Arrays.asList(new Filme("Filme 1", 1, 5.0)); 
        
        //# acao:
        Locacao locacao = locacaoService.alugarFilme(usuario, filmes);

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
        Usuario usuario = new Usuario("Usuario 1");
        List<Filme> filmes = Arrays.asList(new Filme("Filme 1", 0, 5.0)); 
        
        locacaoService.alugarFilme(usuario, filmes);
    }
    
    @Test
    public void alugarFilme_retornaExcecao_quandoUsuarioVazio() throws FilmeSemEstoqueException {
        //#cenario
        List<Filme> filmes = Arrays.asList(new Filme("Filme 2", 1, 5.0)); 
        
        //#acao
        try {
            locacaoService.alugarFilme(null, filmes);
            fail();
        } catch (LocadoraException e) {
            assertThat(e.getMessage(), is("Usuário vazio"));
        }
    }
    
    @Test
    public void alugarFilme_retornaExcecao_quandoFilmeVazio() throws LocadoraException, FilmeSemEstoqueException {
        //#cenario
        Usuario usuario = new Usuario("Usuário 1");
        
        expectedException.expect(LocadoraException.class);
        expectedException.expectMessage("Filmes vazios");

        //#acao
        locacaoService.alugarFilme(usuario, null);
    }
    
    @Test
    public void devePagar75porCentoNoFilme3() throws LocadoraException, FilmeSemEstoqueException {
        Usuario usuario = new Usuario("Usuário 1");
        List<Filme> filmes = Arrays.asList(
                new Filme("Filme 1", 2 , 4.0),
                new Filme("Filme 2", 2 , 4.0),
                new Filme("Filme 3", 2 , 4.0));
        
        Locacao locacao = locacaoService.alugarFilme(usuario, filmes);
        
        assertThat(locacao.getValor(), is(11.0));
    }
    
    @Test
    public void devePagar50porCentoNoFilme4() throws LocadoraException, FilmeSemEstoqueException {
        Usuario usuario = new Usuario("Usuário 2");
        List<Filme> filmes = Arrays.asList(
                new Filme("Filme 1", 2 , 4.0),
                new Filme("Filme 2", 2 , 4.0),
                new Filme("Filme 3", 2 , 4.0),
                new Filme("Filme 4", 2 , 4.0));
        
        Locacao locacao = locacaoService.alugarFilme(usuario, filmes);
        
        assertThat(locacao.getValor(), is(13.0));
    }
    
    @Test
    public void devePagar25porCentoNoFilme5() throws LocadoraException, FilmeSemEstoqueException {
        Usuario usuario = new Usuario("Usuário 3");
        List<Filme> filmes = Arrays.asList(
                new Filme("Filme 1", 2 , 4.0),
                new Filme("Filme 2", 2 , 4.0),
                new Filme("Filme 3", 2 , 4.0),
                new Filme("Filme 4", 2 , 4.0),
                new Filme("Filme 5", 2 , 4.0));
        
        Locacao locacao = locacaoService.alugarFilme(usuario, filmes);
        
        assertThat(locacao.getValor(), is(14.0));
    }
    
    @Test
    public void devePagar0porCentoNoFilme6() throws LocadoraException, FilmeSemEstoqueException {
        Usuario usuario = new Usuario("Usuário 4");
        List<Filme> filmes = Arrays.asList(
                new Filme("Filme 1", 2 , 4.0),
                new Filme("Filme 2", 2 , 4.0),
                new Filme("Filme 3", 2 , 4.0),
                new Filme("Filme 4", 2 , 4.0),
                new Filme("Filme 5", 2 , 4.0),
                new Filme("Filme 6", 2 , 4.0));
        
        Locacao locacao = locacaoService.alugarFilme(usuario, filmes);
        
        assertThat(locacao.getValor(), is(14.0));
    }
}
