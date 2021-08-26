package com.ymotse.maratona.excecoes.execute;

public class RuntimeExceptionTest01 {

    public static void main(String[] args) {
        try {
            dividir(1, 0);
        } catch(RuntimeException e) {
            e.printStackTrace();
        }

        System.out.println("Código finalizado");
    }

    /**
     *
     * @param a
     * @param b Nao pode ser zero.
     * @return
     * @throws IllegalArgumentException caso b for zero
     */
    private static int dividir(int a, int b) {
        if(b == 0) {
            throw new IllegalArgumentException("Argumento ilegal. Não pode ser 0");
        }

        return a/b;
    }

}
