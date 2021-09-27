package com.ymotse.maratona.generics.execute;


import com.ymotse.maratona.generics.dominio.Barco;

import java.util.List;

public class MetodosGenericosTest01 {

    public static void main(String[] args) {

        List<Barco> barcoList = criarArrayComUmObjeto(new Barco("Canoa Marota"));
        System.out.println(barcoList);
    }

    private static <T> List<T> criarArrayComUmObjeto(T t) {
        return List.of(t);
    }

}
