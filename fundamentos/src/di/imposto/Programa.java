package di.imposto;

import di.imposto.services.MGDeducaoService;
import di.imposto.services.PagamentoService;
import di.imposto.services.SPDeducaoService;

public class Programa {

    public static void main(String[] args) {
        
        PagamentoService pagamentoServiceMG = new PagamentoService(new MGDeducaoService());
        double taxaMG = pagamentoServiceMG.taxa(1000.0);
        
        System.out.println(taxaMG);
        
        
        PagamentoService pagamentoServiceSP = new PagamentoService(new SPDeducaoService());
        double taxaSP = pagamentoServiceSP.taxa(1000.0);
        
        System.out.println(taxaSP);
    }

}
