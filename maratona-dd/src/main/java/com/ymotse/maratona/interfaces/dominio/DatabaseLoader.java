package com.ymotse.maratona.interfaces.dominio;

public class DatabaseLoader implements DataLoader {

    @Override
    public void load() {
        System.out.println("Carregando dados do Banco de Dados");
    }

}
