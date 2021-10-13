package com.ymotse.maratona.streams.execute;

import com.ymotse.maratona.streams.dominio.LightNovel;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class StreamTest06 {

    private static List<LightNovel> lightNovels = new ArrayList<>(List.of(
            new LightNovel("Tensei Shittara", 8.99),
            new LightNovel("Overlord", 10.99),
            new LightNovel("Violet Evergarden", 5.99),
            new LightNovel("No Game no life", 2.99),
            new LightNovel("Fullmetal Alchemist", 5.99),
            new LightNovel("Kumo Desuga", 1.99),
            new LightNovel("Kumo Desuga", 1.99),
            new LightNovel("Monogatari", 4.00)
    ));

    public static void main(String[] args) {
        boolean existePrecoMaiorQueOito = lightNovels.stream().anyMatch(ln -> ln.getPrice() > 8);
        boolean existePrecoMaiorQueNove = lightNovels.stream().anyMatch(ln -> ln.getPrice() > 9);
        System.out.println(existePrecoMaiorQueOito);
        System.out.println(existePrecoMaiorQueNove);

        boolean todosPrecosMaioresQueZero = lightNovels.stream().allMatch(ln -> ln.getPrice() > 0);
        System.out.println(todosPrecosMaioresQueZero);

        boolean nenhumPrecoMaiorQueZero = lightNovels.stream().noneMatch(ln -> ln.getPrice() < 0);
        System.out.println(nenhumPrecoMaiorQueZero);

        lightNovels.stream()
                .filter(ln -> ln.getPrice() > 3)
                .findAny()
                .ifPresent(System.out::println);

        lightNovels.stream()
                .filter(ln -> ln.getPrice() > 3)
                .sorted(Comparator.comparing(LightNovel::getPrice).reversed())
                .findFirst()
                .ifPresent(System.out::println);

        lightNovels.stream()
                .filter(ln -> ln.getPrice() > 3)
                .max(Comparator.comparing(LightNovel::getPrice))
                .ifPresent(System.out::println);
    }

}
