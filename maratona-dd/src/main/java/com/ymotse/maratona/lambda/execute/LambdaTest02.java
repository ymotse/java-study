package com.ymotse.maratona.lambda.execute;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class LambdaTest02 {

    public static void main(String[] args) {
        List<String> strings = List.of("Natsu", "Allucard");
        List<Integer> lengthStringListElements = map(strings, (String s) -> s.length());
        System.out.println(lengthStringListElements);

        List<String> uppers = map(strings, s -> s.toUpperCase());
        System.out.println(uppers);
    }

    private static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        List<R> resultado = new ArrayList<>();
        for (T e : list) {
            R r = function.apply(e);
            resultado.add(r);
        }
        return resultado;
    }

}
