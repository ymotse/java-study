package di.imposto;

import di.imposto.services.PagamentoService;

public class Programa {

    public static void main(String[] args) {
        
        PagamentoService pagamentoService = new PagamentoService();
        double taxa = pagamentoService.taxa(1000.0);
        
        System.out.println(taxa);
        
    }

}
