package com.ymotse.maratona.colecoes.execute;

import com.ymotse.maratona.colecoes.dominio.Manga;
import com.ymotse.maratona.colecoes.dominio.Smartphone;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.TreeSet;

class SmartphoneMarcaComparator implements Comparator<Smartphone> {

    @Override
    public int compare(Smartphone o1, Smartphone o2) {
        return o1.getMarca().compareTo(o2.getMarca());
    }
}

class MangaPrecoComparator implements Comparator<Manga> {

    @Override
    public int compare(Manga o1, Manga o2) {
        return Double.compare(o1.getPreco(), o2.getPreco());
    }
}

public class NavegableSetTest01 {

    public static void main(String[] args) {
        NavigableSet<Smartphone> set = new TreeSet<>(new SmartphoneMarcaComparator());
        Smartphone nokia = new Smartphone("123", "Nokia");
        set.add(nokia);
        System.out.println(set);
        System.out.println("------------------");

        NavigableSet<Manga> mangas = new TreeSet<>(new MangaPrecoComparator());
        mangas.add(new Manga(5L, "Berserk", 19.9, 4));
        mangas.add(new Manga(4L, "Attack on Titan", 9.6, 0));
        mangas.add(new Manga(1L, "Pokemon", 12.4, 2));
        mangas.add(new Manga(2L, "Cavaleiros do Zodiaco", 11.23, 0));
        mangas.add(new Manga(3L, "Dragon Ball Z", 21.23, 0));
        mangas.add(new Manga(3L, "Dragon Ball Z", 21.23, 0));
        for (Manga manga : mangas.descendingSet()) {
            System.out.println(manga);
        }

        Manga yuyu = new Manga(5L, "Yuyu Hakusho", 9.6, 5);

        // lower <
        // floor <=
        // higher >
        // ceiling >=

        System.out.println("-----------------------");
        System.out.println(mangas.lower(yuyu));
        System.out.println(mangas.floor(yuyu));
        System.out.println(mangas.higher(yuyu));
        System.out.println(mangas.ceiling(yuyu));

        System.out.println(mangas.size());
//        System.out.println(mangas.pollFirst());
        System.out.println(mangas.pollLast());
        System.out.println(mangas.size());
    }

}
