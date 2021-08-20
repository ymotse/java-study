package com.ymotse.maratona.sobrecargaMetodos.dominio;

public class Anime {
    private String nome;
    private String tipo;
    private int episodios;
    private String genero;

    public Anime(String nome, String tipo, int episodios) {
        this.nome = nome;
        this.tipo = tipo;
        this.episodios = episodios;
    }

    public Anime(String nome, String tipo, int episodios, String genero) {
        this(nome, tipo, episodios);
        this.genero = genero;
    }

    public void imprimir() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Anime: {" +
                "nome='" + nome + '\'' +
                ", tipo='" + tipo + '\'' +
                ", episodios=" + episodios +
                ", genero='" + genero + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return this.tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getEpisodios() {
        return this.episodios;
    }
    public void setEpisodios(int episodios) {
        this.episodios = episodios;
    }

    public String getGenero() {
        return genero;
    }
    public void setGenero(String genero) {
        this.genero = genero;
    }

}
