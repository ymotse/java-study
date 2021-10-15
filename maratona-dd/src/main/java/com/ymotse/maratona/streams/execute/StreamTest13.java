package com.ymotse.maratona.streams.execute;

import com.ymotse.maratona.streams.dominio.Category;
import com.ymotse.maratona.streams.dominio.LightNovel;
import com.ymotse.maratona.streams.dominio.Promotion;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.ymotse.maratona.streams.dominio.Promotion.NORMAL_PRICE;
import static com.ymotse.maratona.streams.dominio.Promotion.UNDER_PROMOTION;

public class StreamTest13 {
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
        Map<Promotion, List<LightNovel>> collect = lightNovels
                .stream()
                .collect(Collectors.groupingBy(ln -> {
                            return ln.getPrice() < 6 ? UNDER_PROMOTION : NORMAL_PRICE;
                        }
                ));

        System.out.println(collect);

        Map<Category, Map<Promotion, List<LightNovel>>> collect1 = lightNovels
                .stream()
                .collect(Collectors.groupingBy(LightNovel::getCategory,
                        Collectors.groupingBy(ln -> {
                            return ln.getPrice() < 6 ? UNDER_PROMOTION : NORMAL_PRICE;
                        })
                ));

        System.out.println(collect1);
    }

}
