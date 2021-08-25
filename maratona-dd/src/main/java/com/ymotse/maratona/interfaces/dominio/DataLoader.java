package com.ymotse.maratona.interfaces.dominio;

public interface DataLoader {
    int MAX_DATA_SIZE = 18;

    void load();

    default void checkPermission() {
        System.out.println("[Default] Fazendo checagem de permissões");
    }

    static void retrieveMaxDataSize() {
        System.out.println("Dentro do retrieveMaxDataSize na interface");
    }
}
