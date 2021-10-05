package com.ymotse.maratona.lambda.execute;

import com.ymotse.maratona.lambda.dominio.Anime;
import com.ymotse.maratona.lambda.service.AnimeComparators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MathodReferenceTest01 {

    public static void main(String[] args) {
        List<Anime> animeList = new ArrayList<>(List.of(
                new Anime("Berserk", 43),
                new Anime("One piece", 100),
                new Anime("Naruto", 500)));

//        Collections.sort(animeList, (a1, a2) -> a1.getTitle().compareTo(a2.getTitle()));
        animeList.sort((a1, a2) -> AnimeComparators.compareByTitle(a1, a2));
        System.out.println(animeList);

        animeList.sort(AnimeComparators::compareByTitle);
        System.out.println(animeList);

        animeList.sort(AnimeComparators::compareByEpisodes);
        System.out.println(animeList);
    }

}
