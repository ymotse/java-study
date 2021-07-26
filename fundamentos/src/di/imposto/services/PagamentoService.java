package di.imposto.services;

public class PagamentoService {
    
    private DeducaoService deducaoService;
    
    public PagamentoService(DeducaoService deducaoService) {
        this.deducaoService = deducaoService;
    }
    
    public double taxa(double valor) {
        valor = valor - deducaoService.deducao(valor);
        return valor * 0.2;
    }
    
}
