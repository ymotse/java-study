package com.ymotse.maratona.colecoes.execute;

import java.util.ArrayList;
import java.util.List;

public class ListTest01 {

    public static void main(String[] args) {
//        List nomes = new ArrayList(); //1.4
//        List<String> nomes = new ArrayList(); //1.5

        List<String> nomes = new ArrayList<>();
        nomes.add("William");
        nomes.add("DevDojo Academy");

        for (String nome : nomes) {
            System.out.println(nome);
        }
        nomes.add("Suane");
        System.out.println("-----------------");

        List<String> nomes2 = new ArrayList<>();
        nomes2.addAll(nomes);

        nomes.remove(1);
        nomes.remove("William");
        for (int i=0; i<nomes.size(); i++) {
            System.out.println(nomes.get(i));
        }
        System.out.println("-----------------");

        for (String nome : nomes2) {
            System.out.println(nome);
        }

        List<Integer> numeros = new ArrayList<>();
        numeros.add(1);
    }

}
