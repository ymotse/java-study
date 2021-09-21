package com.ymotse.maratona.colecoes.execute;

import com.ymotse.maratona.colecoes.dominio.Manga;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class IteratorTest01 {

    public static void main(String[] args) {
        List<Manga> mangas = new ArrayList<>();
        mangas.add(new Manga(5L, "Berserk", 19.9, 4));
        mangas.add(new Manga(4L, "Attack on Titan", 9.6, 0));
        mangas.add(new Manga(1L, "Pokemon", 12.4, 2));
        mangas.add(new Manga(2L, "Cavaleiros do Zodiaco", 11.23, 0));
        mangas.add(new Manga(3L, "Dragon Ball Z", 21.23, 0));

        /*
        Iterator<Manga> mangaIterator = mangas.iterator();
        while(mangaIterator.hasNext()) {
            Manga manga = mangaIterator.next();
            if(manga.getQuantidade() == 0) {
                mangaIterator.remove();
            }
        }
        System.out.println(mangas);
        */

        mangas.removeIf(manga -> manga.getQuantidade() == 0);
        System.out.println(mangas);
    }

}
