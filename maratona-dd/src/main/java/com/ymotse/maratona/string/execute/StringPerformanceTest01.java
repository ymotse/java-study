package com.ymotse.maratona.string.execute;

public class StringPerformanceTest01 {

    public static void main(String[] args) {
        long inicioString = System.currentTimeMillis();
        concatString(10_000);
        long fimString = System.currentTimeMillis();
        System.out.println("Tempo gasto para String: " + (fimString - inicioString) + "ms");

        long inicioSb = System.currentTimeMillis();
        concatString(10_000);
        long fimSb = System.currentTimeMillis();
        System.out.println("Tempo gasto para StringBuilder: " + (fimSb - inicioSb) + "ms");

        long inicioSBuffer = System.currentTimeMillis();
        concatString(10_000);
        long fimSBuffer = System.currentTimeMillis();
        System.out.println("Tempo gasto para StringBuffer: " + (fimSBuffer - inicioSBuffer) + "ms");
    }

    private static void concatString(int tamanho) {
        String texto = "";
        for (int i = 0; i < tamanho; i++) {
            texto += i;
        }
    }

    private static void concatStringBuilder(int tamanho) {
        StringBuilder sb = new StringBuilder(tamanho);
        for (int i = 0; i < tamanho; i++) {
            sb.append(i);
        }
    }

    private static void concatStringBuffer(int tamanho) {
        StringBuffer sb = new StringBuffer(tamanho);
        for (int i = 0; i < tamanho; i++) {
            sb.append(i);
        }
    }

}
