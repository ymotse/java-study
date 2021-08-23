package com.ymotse.maratona.modificadorFinal.execute;

import com.ymotse.maratona.modificadorFinal.dominio.Carro;
import com.ymotse.maratona.modificadorFinal.dominio.Comprador;
import com.ymotse.maratona.modificadorFinal.dominio.Ferrari;

public class CarroTest01 {

    public static void main(String[] args) {
        Carro carro = new Carro();

        System.out.println(Carro.VELOCIDADE_LIMITE);
        System.out.println(carro.COMPRADOR);

        carro.COMPRADOR.setNome("Kuririn");
        System.out.println(carro.COMPRADOR);

        Ferrari ferrari = new Ferrari();
        ferrari.setNome("Enzo");
        ferrari.imprimir();
    }

}
