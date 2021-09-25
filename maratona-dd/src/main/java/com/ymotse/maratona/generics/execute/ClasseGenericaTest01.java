package com.ymotse.maratona.generics.execute;

import com.ymotse.maratona.generics.dominio.Carro;
import com.ymotse.maratona.generics.servico.CarroRentavelService;

public class ClasseGenericaTest01 {

    public static void main(String[] args) {
        CarroRentavelService carroRentavelService = new CarroRentavelService();
        Carro carro = carroRentavelService.buscarCarroDisponivel();
        System.out.println("Usando o carro por um mês...");
        carroRentavelService.retornarCarroAlugado(carro);
    }

}
