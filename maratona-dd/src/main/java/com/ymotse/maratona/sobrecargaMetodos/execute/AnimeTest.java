package com.ymotse.maratona.sobrecargaMetodos.execute;

import com.ymotse.maratona.sobrecargaMetodos.dominio.Anime;

public class AnimeTest {

    public static void main(String[] args) {
        Anime anime = new Anime();
        anime.init("Akudama Drive", "Tv", 12);
        anime.imprimir();

        Anime dragonBallZ = new Anime();
        dragonBallZ.init("Dragon Ball Z", "Tv", 120, "Ação");
        dragonBallZ.imprimir();
    }

}
