package com.ymotse.maratona.excecoes.execute;

public class RuntimeExceptionTest02 {

    public static void main(String[] args) {
        System.out.println(abrirConexao());;
    }

    private static String abrirConexao() {
        try {
            System.out.println("Abrindo arquivo");
//            System.out.println(1/0);
            System.out.println("Escrevendo dados no arquivo");

            return "Conexão aberta";
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Fechando recurso liberado pelo SO");
        }
        return null;
    }

}
