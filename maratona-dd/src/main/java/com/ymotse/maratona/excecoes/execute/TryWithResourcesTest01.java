package com.ymotse.maratona.excecoes.execute;

import com.ymotse.maratona.excecoes.dominio.Leitor1;
import com.ymotse.maratona.excecoes.dominio.Leitor2;

import java.io.*;

public class TryWithResourcesTest01 {

    public static void main(String[] args) {
        lerArquivo3();
    }

    public static void lerArquivo() {
        Reader reader = null;

        try {
            reader = new BufferedReader(new FileReader("teste.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

//    public static void lerArquivo() throws IOException {
    public static void lerArquivo2() {
        try(Reader reader = new BufferedReader(new FileReader("teste.txt"))) {

        } catch (IOException e) {

        }
    }

    public static void lerArquivo3() {
        try (Leitor1 leitor1 = new Leitor1();
            Leitor2 leitor2 = new Leitor2()) {

        } catch (IOException e) {

        }
    }

}
