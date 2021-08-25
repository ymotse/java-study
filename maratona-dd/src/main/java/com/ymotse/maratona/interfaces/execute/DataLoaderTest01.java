package com.ymotse.maratona.interfaces.execute;

import com.ymotse.maratona.interfaces.dominio.DataLoader;
import com.ymotse.maratona.interfaces.dominio.DatabaseLoader;
import com.ymotse.maratona.interfaces.dominio.FileLoader;

public class DataLoaderTest01 {

    public static void main(String[] args) {
        DatabaseLoader databaseLoader = new DatabaseLoader();
        FileLoader fileLoader = new FileLoader();
        databaseLoader.load();
        fileLoader.load();

        databaseLoader.remove();
        fileLoader.remove();

        databaseLoader.checkPermission();
        fileLoader.checkPermission();

        DataLoader.retrieveMaxDataSize();
        DatabaseLoader.retrieveMaxDataSize();
    }

}
