package com.ymotse.maratona.generics.servico;

import java.util.List;

public class RentalService<T> {

    private List<T> objetosDisponiveis;

    public RentalService(List<T> objetosDisponiveis) {
        this.objetosDisponiveis = objetosDisponiveis;
    }

    public T buscarObjetoDisponivel() {
        System.out.println("Buscando carro disponivel...");
        T t = objetosDisponiveis.remove(0);
        System.out.println("Alugando objeto: " + t);
        System.out.println("Objetos disponiveis para alugar:");
        System.out.println(objetosDisponiveis);
        return t;
    }

    public void retornarObjetoAlugado(T objeto) {
        System.out.println("Devolvendo objeto: " + objeto);
        objetosDisponiveis.add(objeto);
        System.out.println("Objetos disponiveis para alugar:");
        System.out.println(objetosDisponiveis);
    }

}
