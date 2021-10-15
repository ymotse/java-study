package com.ymotse.maratona.streams.execute;

import com.ymotse.maratona.streams.dominio.Category;
import com.ymotse.maratona.streams.dominio.LightNovel;
import com.ymotse.maratona.streams.dominio.Promotion;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTest15 {
    private static List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Tensei Shittara", 8.99, Category.FANTASY),
            new LightNovel("Overlord", 10.99, Category.FANTASY),
            new LightNovel("Violet Evergarden", 5.99, Category.DRAMA),
            new LightNovel("No Game no life", 2.99, Category.FANTASY),
            new LightNovel("Fullmetal Alchemist", 5.99, Category.FANTASY),
            new LightNovel("Kumo Desuga", 1.99, Category.FANTASY),
            new LightNovel("Kumo Desuga", 1.99, Category.FANTASY),
            new LightNovel("Monogatari", 4.00, Category.ROMANCE)
    ));

    public static void main(String[] args) {
        Map<Category, DoubleSummaryStatistics> collect = lightNovels.stream()
                .collect(Collectors.groupingBy(LightNovel::getCategory, Collectors.summarizingDouble(LightNovel::getPrice)));

        System.out.println(collect);
        System.out.println("---------------------------");

        Map<Category, List<Promotion>> collect1 = lightNovels.stream()
                .collect(
                        Collectors.groupingBy(LightNovel::getCategory, Collectors.mapping(ln -> {
                            return ln.getPrice() < 6 ? Promotion.UNDER_PROMOTION : Promotion.NORMAL_PRICE;
                        }, Collectors.toList()))
                );

        System.out.println(collect1);
        System.out.println("---------------------------");

        Map<Category, Set<Promotion>> collect2 = lightNovels.stream()
                .collect(
                        Collectors.groupingBy(LightNovel::getCategory, Collectors.mapping(ln -> {
                            return ln.getPrice() < 6 ? Promotion.UNDER_PROMOTION : Promotion.NORMAL_PRICE;
                        }, Collectors.toSet()))
                );

        System.out.println(collect2);
        System.out.println("---------------------------");

        Map<Category, LinkedHashSet<Promotion>> collect3 = lightNovels.stream()
                .collect(
                        Collectors.groupingBy(LightNovel::getCategory, Collectors.mapping(ln -> {
                            return ln.getPrice() < 6 ? Promotion.UNDER_PROMOTION : Promotion.NORMAL_PRICE;
                        }, Collectors.toCollection(LinkedHashSet::new)))
                );

        System.out.println(collect3);
    }

}
