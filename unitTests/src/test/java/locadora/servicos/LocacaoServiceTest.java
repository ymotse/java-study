package locadora.servicos;

import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

import locadora.entidades.Filme;
import locadora.entidades.Locacao;
import locadora.entidades.Usuario;
import locadora.utils.DataUtils;

public class LocacaoServiceTest {

    @Test
    public void alugarFilme_retornaLocacao_quantoBemSucedido() {
        //# cenario:
        LocacaoService service = new LocacaoService();
        Usuario usuario = new Usuario("Usuario 1");
        Filme filme = new Filme("Filme 1", 2, 5.0);
        
        //# acao:
        Locacao locacao = service.alugarFilme(usuario, filme);
        
        //# verificacao:
        assertTrue(locacao.getValor() == 5.0);
        assertTrue(DataUtils.isMesmaData(locacao.getDataLocacao(), new Date()));
        assertTrue(DataUtils.isMesmaData(locacao.getDataRetorno(), DataUtils.obterDataComDiferencaDias(1)));
    }
    
}
