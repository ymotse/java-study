package com.ymotse.maratona.colecoes.execute;

import com.ymotse.maratona.colecoes.dominio.Smartphone;

public class EqualsTest01 {

    public static void main(String[] args) {
        Smartphone s1 = new Smartphone("1ABC", "Iphone");
        Smartphone s2 = new Smartphone("1ABC", "Iphone");

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

        s2 = s1;

        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }

}
