package com.ymotse.maratona.string.execute;

public class StringTest01 {


    public static void main(String[] args) {
        String nome = "João"; //String - Immutable | String constant pool
        String nome2 = "João";
//        nome.concat(" da Silva");
        nome = nome.concat(" da Silva");

        System.out.println(nome);
        System.out.println(nome == nome2);

        String nome3 = new String("João");
        System.out.println(nome2 == nome3);
        System.out.println(nome2 == nome3.intern());
    }

}
