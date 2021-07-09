package locadora.entidades.dao;

import java.util.List;

import locadora.entidades.Locacao;

public interface LocacaoDAO {
    
    public void salvar(Locacao locacao);

    public List<Locacao> obterLocacoesPendentes();
    
}
