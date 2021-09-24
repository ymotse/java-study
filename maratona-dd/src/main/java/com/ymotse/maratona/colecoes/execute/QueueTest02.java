package com.ymotse.maratona.colecoes.execute;

import com.ymotse.maratona.colecoes.dominio.Manga;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest02 {

    public static void main(String[] args) {
        Queue<Manga> mangasQueue = new PriorityQueue<>(new MangaPrecoComparator().reversed());
        mangasQueue.add(new Manga(4L, "Attack on Titan", 9.6, 0));
        mangasQueue.add(new Manga(6L, "Dragon Ball GT", 21.23, 0));
        mangasQueue.add(new Manga(1L, "Pokemon", 12.4, 2));
        mangasQueue.add(new Manga(5L, "Berserk", 19.9, 4));
        mangasQueue.add(new Manga(2L, "Cavaleiros do Zodiaco", 11.23, 0));
        mangasQueue.add(new Manga(3L, "Dragon Ball Z", 21.23, 0));

        while (!mangasQueue.isEmpty()) {
            System.out.println(mangasQueue.poll());
        }
    }

}
