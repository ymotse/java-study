package com.ymotse.maratona.lambda.dominio;

public class Anime {
    private String title;
    private int episodes;

    public Anime(String title, int quantity) {
        this.title = title;
        this.episodes = quantity;
    }

    @Override
    public String toString() {
        return "Anime{" +
                "title='" + title + '\'' +
                ", episodes=" + episodes +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public int getEpisodes() {
        return episodes;
    }
}
