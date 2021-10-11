package com.ymotse.maratona.streams.execute;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class StreamTest04 {

    public static void main(String[] args) {
        List<List<String>> devdojo = new ArrayList<>();
        List<String> graphicDesigners = List.of("Joao Silva", "Maria Souza");
        List<String> developers = List.of("Ana", "Pedro", "Jose");
        List<String> students = List.of("Bia", "Lia", "Guga", "Carlos");

        devdojo.add(graphicDesigners);
        devdojo.add(developers);
        devdojo.add(students);

        devdojo.stream()
                .flatMap(Collection::stream)
                .forEach(System.out::println);
    }

}
