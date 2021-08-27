package com.ymotse.maratona.string.execute;

public class StringTest02 {

    public static void main(String[] args) {
        String nome = "Luffy  ";
        System.out.println(nome.charAt(0));
        System.out.println(nome.length());
        System.out.println(nome.replace("f", "L"));
        System.out.println(nome);

        System.out.println(nome.substring(0, 1));
        System.out.println(nome.substring(1, nome.length()));
        System.out.println("|"+nome.trim()+"|");
    }

}
