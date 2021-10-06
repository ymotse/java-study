package com.ymotse.maratona.lambda.execute;

import com.ymotse.maratona.lambda.dominio.Anime;
import com.ymotse.maratona.lambda.service.AnimeComparators;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;

// Reference to a constructor
public class MethodReferenceTest04 {

    public static void main(String[] args) {
        Supplier<AnimeComparators> newAnimesComparators = AnimeComparators::new;
        AnimeComparators animeComparators = newAnimesComparators.get();

        List<Anime> animeList = new ArrayList<>(List.of(
                new Anime("Berserk", 43),
                new Anime("One piece", 100),
                new Anime("Naruto", 500)));

        animeList.sort(animeComparators::compareByEpisodesNonStatic);
        System.out.println(animeList);

        BiFunction<String, Integer, Anime> animeBiFunction = (title, episodes) -> new Anime(title, episodes);
        BiFunction<String, Integer, Anime> animeBiFunction2 = Anime::new;

        System.out.println(animeBiFunction2.apply("Super Campeoes", 36));
    }

}
