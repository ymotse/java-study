package com.ymotse.maratona.regex;

import java.util.Scanner;

public class ScannerTest01 {

    public static void main(String[] args) {
        String texto = "Levi,Eren,Mikasa,true,200";
        Scanner scanner = new Scanner(texto);
        scanner.useDelimiter(",");

        while(scanner.hasNext()) {
            System.out.println(scanner.next());

            if(scanner.hasNextInt()) {
                int i = scanner.nextInt();
                System.out.println("Int: " + i);
            } else if(scanner.hasNextBoolean()) {
                boolean b = scanner.hasNextBoolean();
                System.out.println("Boolean: " + b);
            } else {
                System.out.println(scanner.next());
            }
        }
    }

}
