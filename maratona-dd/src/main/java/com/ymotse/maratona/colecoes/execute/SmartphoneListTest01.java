package com.ymotse.maratona.colecoes.execute;

import com.ymotse.maratona.colecoes.dominio.Manga;
import com.ymotse.maratona.colecoes.dominio.Smartphone;

import java.util.ArrayList;
import java.util.List;

public class SmartphoneListTest01 {

    public static void main(String[] args) {
        Smartphone s1 = new Smartphone("1ABC1", "Iphone");
        Smartphone s2 = new Smartphone("2ABC2", "Pixel");
        Smartphone s3 = new Smartphone("3ABC3", "Samsung");

        List<Smartphone> smartphones = new ArrayList<>();
        smartphones.add(s1);
        smartphones.add(s2);
        smartphones.add(0, s3);

        for(Smartphone smartphone : smartphones) {
            System.out.println(smartphone);
        }

        Smartphone s4 = new Smartphone("2ABC2", "Pixel");;
        System.out.println(smartphones.contains(s4));

        int indexSmartphone4 = smartphones.indexOf(s4);
        System.out.println(indexSmartphone4);

        System.out.println(smartphones.get(indexSmartphone4));
    }

}
