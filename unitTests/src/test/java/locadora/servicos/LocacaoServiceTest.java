package locadora.servicos;

import static locadora.builders.FilmeBuilder.umFilme;
import static locadora.builders.LocacaoBuilder.umLocacao;
import static locadora.builders.UsuarioBuilder.umUsuario;
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
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import locadora.entidades.Filme;
import locadora.entidades.Locacao;
import locadora.entidades.Usuario;
import locadora.entidades.dao.LocacaoDAO;
import locadora.excecoes.FilmeSemEstoqueException;
import locadora.excecoes.LocadoraException;
import locadora.utils.DataUtils;

public class LocacaoServiceTest {
    
    @InjectMocks
    private LocacaoService locacaoService;
    
    @Mock
    private SPCService spcService;
    
    @Mock
    private LocacaoDAO dao;
    
    @Mock
    private EmailService emailService;
    
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
        
        MockitoAnnotations.initMocks(this);
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
    
    @Test
    public void naoDeveAlugarFilmeParaNegativadoSPC() throws FilmeSemEstoqueException {
        Usuario usuario = umUsuario().agora();
        List<Filme> filmes = Arrays.asList(umFilme().agora());
        
        when(spcService.possuiNegativacao(Mockito.any(Usuario.class))).thenReturn(true);
        
        try {
            locacaoService.alugarFilme(usuario, filmes);
            Assert.fail();
        } catch (LocadoraException e) {
            Assert.assertThat(e.getMessage(), is("Usuário Negativado!"));
        }
        
        Mockito.verify(spcService).possuiNegativacao(usuario);
    }
    
    @Test
    public void deveEnviarEmailParaLocacoesAtrasados() {
        Usuario usuario = umUsuario().agora();
        Usuario usuario2 = umUsuario().comNome("Usuario em dia").agora();
        Usuario usuario3 = umUsuario().comNome("Outro atrasado").agora();
        
        List<Locacao> locacaoes = Arrays.asList(
                umLocacao().atrasado().comUsuario(usuario).agora(),
                umLocacao().comUsuario(usuario2).agora(),
                umLocacao().atrasado().comUsuario(usuario3).agora());
        
        when(dao.obterLocacoesPendentes()).thenReturn(locacaoes);
        
        locacaoService.notificarAtrasos();
        
        Mockito.verify(emailService, Mockito.times(2)).notificarAtraso(Mockito.any(Usuario.class));
        Mockito.verify(emailService).notificarAtraso(usuario);
        Mockito.verify(emailService, Mockito.atLeastOnce()).notificarAtraso(usuario3);
        Mockito.verify(emailService, Mockito.never()).notificarAtraso(usuario2);
        Mockito.verifyNoMoreInteractions(emailService);
    }
}
