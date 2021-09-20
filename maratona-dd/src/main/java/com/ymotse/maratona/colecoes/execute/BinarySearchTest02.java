package com.ymotse.maratona.colecoes.execute;

import com.ymotse.maratona.colecoes.dominio.Manga;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class BinarySearchTest02 {

    public static void main(String[] args) {
        List<Manga> mangas = new ArrayList<>();
        mangas.add(new Manga(5L, "Berserk", 19.9));
        mangas.add(new Manga(4L, "Attack on Titan", 9.6));
        mangas.add(new Manga(1L, "Pokemon", 12.4));
        mangas.add(new Manga(2L, "Cavaleiros do Zodiaco", 11.23));
        mangas.add(new Manga(3L, "Dragon Ball Z", 21.23));

//        Collections.sort(mangas);
        MangaByIdComparator mangaByIdComparator = new MangaByIdComparator();

        mangas.sort(mangaByIdComparator);

        for (Manga manga : mangas) {
            System.out.println(manga);
        }

        Manga mangaToSearch = new Manga(2L, "Cavaleiros do Zodiaco", 11.23);

        System.out.println(Collections.binarySearch(mangas, mangaToSearch, mangaByIdComparator));

    }

}
