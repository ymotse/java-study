package com.ymotse.maratona.polimorfismo.servico;

import com.ymotse.maratona.polimorfismo.dominio.Produto;
import com.ymotse.maratona.polimorfismo.dominio.Tomate;

public class CalculadoraImposto {

    public static void calcularImposto(Produto produto) {
        System.out.println("Relatorio de imposto");
        double imposto = produto.calcularImposto();
        System.out.println("Produto: " + produto.getNome());
        System.out.println("Valor: " + produto.getValor());
        System.out.println("Imposto a ser pago: " + imposto);

        if(produto instanceof Tomate) {
            String dataValidadeTomate = ((Tomate) produto).getDataValidade();
            System.out.println(dataValidadeTomate);
        }
    }

}
