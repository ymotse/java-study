package com.ymotse.maratona.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest02 {

    static void getMatcher(String regex, String texto) {
        System.out.println("texto: " + texto);
        System.out.println("regex: " + regex);

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(texto);

        while(matcher.find()) {
            System.out.print("Posicao: " + matcher.start() + ", Digito: " + matcher.group() + "\n");
        }
    }

    public static void main(String[] args) {

        // \d = Todos os digitos
        // \D = Tudo o que nao for digito
        // \s = Espacos em branco \t \n \f \r
        // \S = Todos os caracteres excluindo os brancos
        // \w = a-zA-Z, digitos, e underscore
        // \W = Tudo o que nao for incluso no \w

        getMatcher("\\d", "a43j65jkm43n2a0");
        System.out.println("----------------------");

        getMatcher("\\D", "a43j65jkm43n2a0");
        System.out.println("----------------------");

        getMatcher("\\s", "a43 j65jkm43n 2a0a");
        System.out.println("----------------------");

        getMatcher("\\S", "a43 j65jkm43n2a0a");
        System.out.println("----------------------");

        getMatcher("\\w", "@#!a43_j65jkm 43n2a0a");
        System.out.println("----------------------");

        getMatcher("\\W", "@#!a43_j65jkm43 n2a0a");
        System.out.println("----------------------");
    }

}
