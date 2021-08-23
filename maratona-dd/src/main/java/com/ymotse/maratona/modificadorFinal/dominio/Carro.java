package com.ymotse.maratona.modificadorFinal.dominio;

//public final class Carro {
public class Carro {
    private String nome;
//    private static final double VELOCIDADE_LIMITE = 250;
    public static final double VELOCIDADE_LIMITE;
    public final Comprador COMPRADOR = new Comprador();

    static {
        VELOCIDADE_LIMITE = 250;
    }

    public final void imprimir() {
        System.out.println(this.nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
