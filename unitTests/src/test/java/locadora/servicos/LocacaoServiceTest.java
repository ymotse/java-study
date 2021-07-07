package locadora.servicos;

import static locadora.matchers.MatchersProprios.caiEm;
import static locadora.matchers.MatchersProprios.caiEmUmaSegunda;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assume.assumeFalse;
import static org.junit.Assume.assumeTrue;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static locadora.builders.FilmeBuilder.umFilme;
import static locadora.builders.UsuarioBuilder.umUsuario;

import locadora.entidades.Filme;
import locadora.entidades.Locacao;
import locadora.entidades.Usuario;
import locadora.excecoes.FilmeSemEstoqueException;
import locadora.excecoes.LocadoraException;
import locadora.matchers.DiaSemanaMatcher;
import locadora.matchers.MatchersProprios;
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
        
        assumeFalse(DataUtils.verificarDiaSemana(new Date(), Calendar.SATURDAY));
        
        //# cenario:
        Usuario usuario = umUsuario().agora();
        List<Filme> filmes = Arrays.asList(umFilme().agora()); 
        
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
        Usuario usuario = umUsuario().agora();
        List<Filme> filmes = Arrays.asList(umFilme().semEstoque().agora()); 
        
        locacaoService.alugarFilme(usuario, filmes);
    }
    
    @Test
    public void alugarFilme_retornaExcecao_quandoUsuarioVazio() throws FilmeSemEstoqueException {
        //#cenario
        List<Filme> filmes = Arrays.asList(umFilme().agora()); 
        
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
        Usuario usuario = umUsuario().agora();
        
        expectedException.expect(LocadoraException.class);
        expectedException.expectMessage("Filmes vazios");

        //#acao
        locacaoService.alugarFilme(usuario, null);
    }
    
    @Test
    public void devePagar75porCentoNoFilme3() throws LocadoraException, FilmeSemEstoqueException {
        Usuario usuario = umUsuario().agora();
        List<Filme> filmes = Arrays.asList(
                new Filme("Filme 1", 2 , 4.0),
                new Filme("Filme 2", 2 , 4.0),
                new Filme("Filme 3", 2 , 4.0));
        
        Locacao locacao = locacaoService.alugarFilme(usuario, filmes);
        
        assertThat(locacao.getValor(), is(11.0));
    }
    
    @Test
    public void devePagar50porCentoNoFilme4() throws LocadoraException, FilmeSemEstoqueException {
        Usuario usuario = umUsuario().agora();
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
        Usuario usuario = umUsuario().agora();
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
        Usuario usuario = umUsuario().agora();
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
    
    @Test
//    @Ignore
    public void deveDevolverNaSegundaAoAlugarNoSabado() throws LocadoraException, FilmeSemEstoqueException {
        assumeTrue(DataUtils.verificarDiaSemana(new Date(), Calendar.SATURDAY));
        
        //#cenario
        Usuario usuario = new Usuario("Usuário 1");
        List<Filme> filmes = Arrays.asList(umFilme().agora());
        
        //#acao
        Locacao retorno = locacaoService.alugarFilme(usuario, filmes);
        
        //#verificacao
        boolean ehSegunda = DataUtils.verificarDiaSemana(retorno.getDataRetorno(), Calendar.MONDAY);
        
        assertTrue(ehSegunda);
        assertThat(retorno.getDataRetorno(), caiEm(Calendar.MONDAY));
        assertThat(retorno.getDataRetorno(), caiEmUmaSegunda());
    }
}
