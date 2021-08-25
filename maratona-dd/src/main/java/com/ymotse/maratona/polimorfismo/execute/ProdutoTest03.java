package com.ymotse.maratona.polimorfismo.execute;

import com.ymotse.maratona.polimorfismo.dominio.Computador;
import com.ymotse.maratona.polimorfismo.dominio.Produto;
import com.ymotse.maratona.polimorfismo.dominio.Tomate;
import com.ymotse.maratona.polimorfismo.servico.CalculadoraImposto;

public class ProdutoTest03 {

    public static void main(String[] args) {
        Produto ryzer9 = new Computador("Ryzer 9", 3000);

        Tomate tomate = new Tomate("Tomate americano", 20);
        tomate.setDataValidade("2021-12-11");

        CalculadoraImposto.calcularImposto(tomate);
        System.out.println();
        CalculadoraImposto.calcularImposto(ryzer9);

    }

}
