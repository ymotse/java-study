package com.ymotse.maratona.string.execute;

public class StringBuilderTest01 {

    public static void main(String[] args) {
        String nome = "William Suane";
        nome.concat(" DevDojo");
        System.out.println(nome);

        nome = nome.substring(0, 3);
        System.out.println(nome);

        StringBuilder sb = new StringBuilder(nome);
        sb.append(" DevDojo").append(" Academy");
        sb.reverse().reverse();
        sb.delete(0,4);
        System.out.println(sb);
    }

}
