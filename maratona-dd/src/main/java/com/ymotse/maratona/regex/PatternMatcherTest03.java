package com.ymotse.maratona.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest03 {

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
        // [] = Range

        getMatcher("[abcABC]", "a43j65jka1b3cm43ABCn2m0");
        System.out.println("----------------------");

        getMatcher("[a-zA-C]", "43j65ja1k3c43A5BC92m0z");
        System.out.println("----------------------");

        getMatcher("[a-zA-C]", "43j65ja1k3c43A5BC92m0z");
        System.out.println("----------------------");

        getMatcher("[a-zA-C][0-9]", "4j65ja1k3c43A5BC92m0z");
        System.out.println("----------------------");

    }

}
