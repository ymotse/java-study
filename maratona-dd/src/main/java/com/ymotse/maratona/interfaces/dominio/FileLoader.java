package com.ymotse.maratona.interfaces.dominio;

public class FileLoader implements DataLoader {

    @Override
    public void load() {
        System.out.println("Carregando dados de um arquivo");
    }

}
