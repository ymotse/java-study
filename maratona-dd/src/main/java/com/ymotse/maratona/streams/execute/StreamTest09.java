package com.ymotse.maratona.streams.execute;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest09 {

    public static void main(String[] args) {
        IntStream.rangeClosed(1, 50)
                .filter(n -> n % 2 == 0)
                .forEach(n -> System.out.println(n + " "));

        System.out.println("-------------------------");

        IntStream.range(1, 50)
                .filter(n -> n % 2 == 0)
                .forEach(n -> System.out.println(n + " "));

        System.out.println("-------------------------");

        Stream.of("Eleve", "o ", "Cosmo ", "no seu coracao")
                .map(String::toUpperCase)
                .forEach(s -> System.out.print(s + " "));

        System.out.println("\n-------------------------");

        int [] num = {1, 2, 3, 4, 5};
        Arrays.stream(num).max().ifPresent(System.out::println);
        Arrays.stream(num).min().ifPresent(System.out::println);
        Arrays.stream(num).average().ifPresent(System.out::println);
        System.out.println(Arrays.stream(num).sum());
        System.out.println("\n-------------------------");

        try(Stream<String> lines = Files.lines(Paths.get("file.txt"))) {
            lines
                .filter(l -> l.contains("Java"))
                .forEach(System.out::println);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

}