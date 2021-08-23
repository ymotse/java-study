package com.ymotse.maratona.modificadorFinal.dominio;

public class Carro {
    private String nome;
//    private static final double VELOCIDADE_LIMITE = 250;
    public static final double VELOCIDADE_LIMITE;

    static {
        VELOCIDADE_LIMITE = 250;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
