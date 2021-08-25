package com.ymotse.maratona.polimorfismo.execute;

import com.ymotse.maratona.polimorfismo.dominio.Computador;
import com.ymotse.maratona.polimorfismo.dominio.Televisao;
import com.ymotse.maratona.polimorfismo.dominio.Tomate;
import com.ymotse.maratona.polimorfismo.servico.CalculadoraImposto;

public class ProdutoTest01 {

    public static void main(String[] args) {
        Computador computador = new Computador("NUC10i7", 10000);
        Tomate tomate = new Tomate("Tomate Siciliano", 10);
        Televisao tv = new Televisao("Samsung 50\"", 5000);

        CalculadoraImposto.calcularImposto(computador);
        System.out.println();

        CalculadoraImposto.calcularImposto(tomate);
        System.out.println();

        CalculadoraImposto.calcularImposto(tv);
    }

}
