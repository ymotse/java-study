package com.ymotse.maratona.interfaces.dominio;

public interface DataLoader {
    void load();

    default void checkPermission() {
        System.out.println("[Default] Fazendo checagem de permissões");
    }
}
