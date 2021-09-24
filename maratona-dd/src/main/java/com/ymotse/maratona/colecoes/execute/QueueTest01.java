package com.ymotse.maratona.colecoes.execute;

import java.util.PriorityQueue;
import java.util.Queue;

public class QueueTest01 {

    public static void main(String[] args) {
        // FIFO - First In, First Out
        Queue<String> fila = new PriorityQueue<>();
        fila.add("C");
        fila.add("A");
        fila.add("B");

        for (String s : fila) {
            System.out.println(s);
        }
        System.out.println(fila);
        System.out.println("----------------");

        while (!fila.isEmpty()) {
            System.out.println(fila.poll());
        }


    }

}
