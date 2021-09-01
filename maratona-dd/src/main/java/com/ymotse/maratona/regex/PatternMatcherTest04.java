package com.ymotse.maratona.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternMatcherTest04 {

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
        // ? Zero ou uma
        // * Zero ou mais
        // + Uma ou mais
        // (n,m) de n ate m
        // ()
        // |
        // $

        getMatcher("0[xX]([0-9a-fA-F])+(\\s|$)", "12 0x 0X 0xFFABC 0x10G 0x1");
        System.out.println("----------------------");

    }

}
