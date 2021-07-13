package locadora.servicos;

import static locadora.utils.DataUtils.adicionarDias;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import locadora.entidades.Filme;
import locadora.entidades.Locacao;
import locadora.entidades.Usuario;
import locadora.entidades.dao.LocacaoDAO;
import locadora.excecoes.FilmeSemEstoqueException;
import locadora.excecoes.LocadoraException;
import locadora.utils.DataUtils;

public class LocacaoService {
    
    private LocacaoDAO dao;
    private SPCService spcService;
    private EmailService emailService;
    
    
    public Locacao alugarFilme(Usuario usuario, List<Filme> filmes) throws LocadoraException, FilmeSemEstoqueException {
        
        if(usuario == null) {
            throw new LocadoraException("Usu�rio vazio");
        }

        if(filmes == null || filmes.isEmpty()) {
            throw new LocadoraException("Filmes vazios");
        }
        
        for (Filme filme : filmes) {
            if(filme.getEstoque() == 0) {
                throw new FilmeSemEstoqueException();
            }
        }
        
        boolean negativado;
        
        try {
            negativado = spcService.possuiNegativacao(usuario);
        } catch(Exception e) {
            throw new LocadoraException("Problemas com SPC, tente novamente");
        }
        
        if(negativado) {
            throw new LocadoraException("Usu�rio Negativado!");
        }
        
        Locacao locacao = new Locacao();
        locacao.setFilme(filmes);
        locacao.setUsuario(usuario);
        locacao.setDataLocacao(new Date());
        
        Double precoLocacao = 0d;
        for (int i = 0; i < filmes.size(); i++) {
            Filme filme = filmes.get(i);
            Double valorDoFilme = filme.getPrecoLocacao();
            
            switch (i) {
                case 2:
                    valorDoFilme *= 0.75;
                break;
                case 3:
                    valorDoFilme *= 0.50;
                break;
                case 4:
                    valorDoFilme *= 0.25;
                break;
                case 5:
                    valorDoFilme = 0.0;
                break;
            }
            
            precoLocacao += valorDoFilme; 
        }
        locacao.setValor(precoLocacao);

        // Entrega no dia seguinte
        Date dataEntrega = new Date();
        dataEntrega = adicionarDias(dataEntrega, 1);
        if(DataUtils.verificarDiaSemana(dataEntrega, Calendar.SUNDAY)) {
            dataEntrega = adicionarDias(dataEntrega, 1);
        }
        locacao.setDataRetorno(dataEntrega);

        // TODO adicionar metodo para salvar locacao.
        dao.salvar(locacao);

        return locacao;
    }
    
    public void notificarAtrasos() {
        List<Locacao> locacoes = dao.obterLocacoesPendentes();
        
        for(Locacao locacao : locacoes) {
            if(locacao.getDataRetorno().before(new Date())) {
                emailService.notificarAtraso(locacao.getUsuario());
            }
        }
    }
    
}