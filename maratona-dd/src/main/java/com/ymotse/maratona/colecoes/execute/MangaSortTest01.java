package com.ymotse.maratona.colecoes.execute;

import com.ymotse.maratona.colecoes.dominio.Manga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


class MangaByIdComparator implements Comparator<Manga> {

    @Override
    public int compare(Manga manga1, Manga manga2) {
        return manga1.getId().compareTo(manga2.getId());
    }
}

public class MangaSortTest01 {

    public static void main(String[] args) {
        List<Manga> mangas = new ArrayList<>();
        mangas.add(new Manga(5L, "Berserk", 19.9));
        mangas.add(new Manga(4L, "Attack on Titan", 9.6));
        mangas.add(new Manga(1L, "Pokemon", 12.4));
        mangas.add(new Manga(2L, "Cavaleiros do Zodiaco", 11.23));
        mangas.add(new Manga(3L, "Dragon Ball Z", 21.23));

        for(Manga manga : mangas) {
            System.out.println(manga);
        }
        System.out.println("------------------");

        Collections.sort(mangas);
        for(Manga manga : mangas) {
            System.out.println(manga);
        }
        System.out.println("------------------");

//        Collections.sort(mangas, new MangaByIdComparator());
        mangas.sort(new MangaByIdComparator());

        for(Manga manga : mangas) {
            System.out.println(manga);
        }



    }

}
