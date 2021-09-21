package com.ymotse.maratona.colecoes.execute;

import com.ymotse.maratona.colecoes.dominio.Manga;

import java.util.HashSet;
import java.util.Set;

public class SetTest01 {

    public static void main(String[] args) {
        Set<Manga> mangas = new HashSet<>();
        mangas.add(new Manga(5L, "Berserk", 19.9, 4));
        mangas.add(new Manga(4L, "Attack on Titan", 9.6, 0));
        mangas.add(new Manga(1L, "Pokemon", 12.4, 2));
        mangas.add(new Manga(2L, "Cavaleiros do Zodiaco", 11.23, 0));
        mangas.add(new Manga(3L, "Dragon Ball Z", 21.23, 0));
        mangas.add(new Manga(3L, "Dragon Ball Z", 21.23, 0));

        for (Manga manga : mangas) {
            System.out.println(manga);
        }

    }

}
