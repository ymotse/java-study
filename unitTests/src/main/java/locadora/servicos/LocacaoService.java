package locadora.servicos;

import static locadora.utils.DataUtils.adicionarDias;

import java.util.Date;

import locadora.entidades.Filme;
import locadora.entidades.Locacao;
import locadora.entidades.Usuario;
import locadora.excecoes.FilmeSemEstoqueException;
import locadora.excecoes.LocadoraException;

public class LocacaoService {

    public Locacao alugarFilme(Usuario usuario, Filme filme) throws LocadoraException, FilmeSemEstoqueException {
        
        if(filme == null) {
            throw new LocadoraException("Filme vazio");
        }

        if(filme.getEstoque() == 0) {
            throw new FilmeSemEstoqueException();
        }
        
        if(usuario == null) {
            throw new LocadoraException("Usuário vazio");
        }
        
        Locacao locacao = new Locacao();
        locacao.setFilme(filme);
        locacao.setUsuario(usuario);
        locacao.setDataLocacao(new Date());
        locacao.setValor(filme.getPrecoLocacao());

        // Entrega no dia seguinte
        Date dataEntrega = new Date();
        dataEntrega = adicionarDias(dataEntrega, 1);
        locacao.setDataRetorno(dataEntrega);

        // TODO adicionar metodo para salvar locacao.

        return locacao;
    }

}