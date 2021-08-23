package com.ymotse.maratona.introducao.execute;

import java.io.IOException;
import java.util.Scanner;

public class GameResponderQualquerPergunta {

    public static void main(String[] args) throws IOException, InterruptedException {

        System.out.println("O grande software de previsão do futuro!!! \n");
        System.out.println("Digite sua pergunta e eu responderei SIM ou NÃO, ou SAIR para finalizar!");
        Scanner in = new Scanner(System.in);

        String pergunta = "";

        while(pergunta != null) {
            pergunta = in.nextLine();

            if(pergunta.equalsIgnoreCase("sair")) {
                System.exit(0);
            }

            System.out.println(pergunta.charAt(0) == ' ' ? "SIM" : "NÃO");
        }
    }

}
