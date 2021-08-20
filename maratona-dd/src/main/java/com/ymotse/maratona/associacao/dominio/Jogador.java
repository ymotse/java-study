package com.ymotse.maratona.associacao.dominio;

public class Jogador {
    private String nome;
    private Time time;

    public void imprimir() {
        System.out.println(this.nome);
        if(time != null) {
            System.out.println(this.time.getNome());
        }
    }

    public Jogador(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
