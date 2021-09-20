package com.ymotse.maratona.colecoes.execute;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinarySearchTest01 {

    public static void main(String[] args) {
        List<Integer> numeros = new ArrayList<>();
        numeros.add(2);
        numeros.add(0);
        numeros.add(44);
        numeros.add(3);
        //(-(ponto de inserção) -1)

        Collections.sort(numeros);

        // index 0,1,2,3
        // value 0,2,3,44
        System.out.println(Collections.binarySearch(numeros, 44));
        System.out.println(Collections.binarySearch(numeros, 1));
    }

}
