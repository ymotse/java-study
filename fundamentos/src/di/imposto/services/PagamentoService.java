package di.imposto.services;

public class PagamentoService {
    
    private DeducaoService deducaoService = new MGDeducaoService();
    
    public double taxa(double valor) {
        valor = valor - deducaoService.deducao(valor);
        return valor * 0.2;
    }
    
}
