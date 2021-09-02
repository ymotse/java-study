package com.ymotse.maratona.io;

import java.io.File;
import java.io.IOException;

public class FileTest02 {

    public static void main(String[] args) throws IOException {

        /* Criar pasta */
        File folder = new File("pasta");
        boolean isCreatedFolder = folder.mkdir();
        System.out.println("isCreatedFolder: " + isCreatedFolder);

        /* Criar arquivo na pasta */
        File file = new File(folder, "arquivo.txt");
        boolean isCreatedFile = file.createNewFile();
        System.out.println("isCreatedFile: " + isCreatedFile);

        /* Renomear arquivo dentro da pasta */
        File fileRenamed = new File(folder, "arquivo_renomeado.txt");
        boolean isRenamedFile = file.renameTo(fileRenamed);
        System.out.println("isRenamedFile: " + isRenamedFile);

        /* Renomear pasta */
        File folderRenamed = new File("pasta2");
        boolean isRenamedFolder = folder.renameTo(folderRenamed);
        System.out.println("isRenamedFolder: " + isRenamedFolder);
    }

}
