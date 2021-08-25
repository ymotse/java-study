package com.ymotse.maratona.polimorfismo.execute;

import com.ymotse.maratona.polimorfismo.dominio.Computador;
import com.ymotse.maratona.polimorfismo.dominio.Produto;
import com.ymotse.maratona.polimorfismo.dominio.Tomate;

public class ProdutoTest02 {

    public static void main(String[] args) {
        Produto ryzer9 = new Computador("Ryzer 9", 3000);
        System.out.println(ryzer9.getNome());
        System.out.println(ryzer9.getValor());
        System.out.println(ryzer9.calcularImposto());

        System.out.println();

        Produto tomate = new Tomate("Tomate americano", 20);
        System.out.println(tomate.getNome());
        System.out.println(tomate.getValor());
        System.out.println(tomate.calcularImposto());

    }

}
