package com.ymotse.maratona.interfaces.dominio;

public class DatabaseLoader implements DataLoader, DataRemover {

    @Override
    public void load() {
        System.out.println("Carregando dados do Banco de Dados");
    }

    @Override
    public void remove() {
        System.out.println("Removendo dados do Banco de Dados");
    }

    @Override
    public void checkPermission() {
        System.out.println("Fazendo checagem de permissões no Banco de Dados");
    }
}
