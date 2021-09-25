package com.ymotse.maratona.generics.execute;

import com.ymotse.maratona.generics.dominio.Barco;
import com.ymotse.maratona.generics.servico.BarcoRentavelService;

public class ClasseGenericaTest02 {

    public static void main(String[] args) {
        BarcoRentavelService barcoRentavelService = new BarcoRentavelService();
        Barco barco = barcoRentavelService.buscarBarcoDisponivel();
        System.out.println("Usando o barco por um mês...");
        barcoRentavelService.retornarBarcoAlugado(barco);
    }

}
