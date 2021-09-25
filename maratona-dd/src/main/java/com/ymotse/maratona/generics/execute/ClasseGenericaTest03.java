package com.ymotse.maratona.generics.execute;

import com.ymotse.maratona.generics.dominio.Barco;
import com.ymotse.maratona.generics.dominio.Carro;
import com.ymotse.maratona.generics.servico.BarcoRentavelService;
import com.ymotse.maratona.generics.servico.CarroRentavelService;
import com.ymotse.maratona.generics.servico.RentalService;

import java.util.ArrayList;
import java.util.List;

public class ClasseGenericaTest03 {

    public static void main(String[] args) {
        List<Carro> carrosDisponiveis = new ArrayList<>(
                List.of(
                        new Carro("BMW"),
                        new Carro("Fusca")
                )
        );

        List<Barco> barcosDisponiveis = new ArrayList<>(
                List.of(
                        new Barco("Lancha"),
                        new Barco("Canoa")
                )
        );

        RentalService<Carro> rentalServiceCarro = new RentalService<>(carrosDisponiveis);
        Carro carro = rentalServiceCarro.buscarObjetoDisponivel();
        System.out.println("Usando o carro por um mês...");
        rentalServiceCarro.retornarObjetoAlugado(carro);

        System.out.println("---------------------");

        RentalService<Barco> rentalServiceBarco = new RentalService<>(barcosDisponiveis);
        Barco barco = rentalServiceBarco.buscarObjetoDisponivel();
        System.out.println("Usando o barco por um mês...");
        rentalServiceBarco.retornarObjetoAlugado(barco);
    }

}
