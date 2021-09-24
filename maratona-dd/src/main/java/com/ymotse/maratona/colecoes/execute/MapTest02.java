package com.ymotse.maratona.colecoes.execute;

import com.ymotse.maratona.colecoes.dominio.Consumidor;
import com.ymotse.maratona.colecoes.dominio.Manga;

import java.util.HashMap;
import java.util.Map;

public class MapTest02 {

    public static void main(String[] args) {
        Consumidor consumidor1 = new Consumidor("William Suane");
        Consumidor consumidor2 = new Consumidor("DevDojo Academy");

        Manga berserk = new Manga(5L, "Berserk", 19.9);
        Manga attackOnTitan = new Manga(4L, "Attack on Titan", 9.6);
        Manga pokemon = new Manga(1L, "Pokemon", 12.4);
        Manga cavaleirosDoZodiaco = new Manga(2L, "Cavaleiros do Zodiaco", 11.23);
        Manga dragonBallZ = new Manga(3L, "Dragon Ball Z", 21.23);

        Map<Consumidor, Manga> consumidorManga = new HashMap<>();
        consumidorManga.put(consumidor1, berserk);
        consumidorManga.put(consumidor2, cavaleirosDoZodiaco);

        for (Map.Entry<Consumidor, Manga> entry : consumidorManga.entrySet()) {
            System.out.println(entry.getKey().getNome() + ": " + entry.getValue());
        }

    }

}
