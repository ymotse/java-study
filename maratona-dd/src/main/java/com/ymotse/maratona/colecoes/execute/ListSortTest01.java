package com.ymotse.maratona.colecoes.execute;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSortTest01 {

    public static void main(String[] args) {
        List<String> mangas = new ArrayList<>();
        mangas.add("Berserk");
        mangas.add("Attack on Titan");
        mangas.add("Pokemon");
        mangas.add("Cavaleiros do Zodiaco");
        mangas.add("Dragon Ball Z");

        Collections.sort(mangas);

        for (String manga : mangas) {
            System.out.println(manga);
        }

        List<Double> dinheiros = new ArrayList<>();
        dinheiros.add(100.21);
        dinheiros.add(23.98);
        dinheiros.add(21.21);
        dinheiros.add(98.10);
        dinheiros.add(40.21);

        Collections.sort(dinheiros);

        for (Double dinheiro : dinheiros) {
            System.out.println(dinheiro);
        }

    }

}
