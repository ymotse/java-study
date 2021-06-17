package locadora.servicos;

import static locadora.utils.DataUtils.adicionarDias;

import java.util.Date;

import locadora.entidades.Filme;
import locadora.entidades.Locacao;
import locadora.entidades.Usuario;

public class LocacaoService {

    public Locacao alugarFilme(Usuario usuario, Filme filme) throws Exception {
        if(filme.getEstoque() == 0) {
            throw new Exception("Filme sem estoque!");
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