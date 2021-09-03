package com.ymotse.maratona.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class PathTest02 {

    public static void main(String[] args) throws IOException {
        Path pasta = Paths.get("pasta");
        if(Files.notExists(pasta)) {
            Path diretorio = Files.createDirectory(pasta);
        }

        Path subPasta = Paths.get("pasta/subpasta/subsubpasta");
        Path subDiretorio = Files.createDirectories(subPasta);

        Path filePath = Paths.get(subPasta.toString(), "file.txt");
        if (Files.notExists(filePath)) {
            Path filePathCreated = Files.createFile(filePath);
        }

        Path source = filePath;
        Path target = Paths.get(filePath.getParent().toString(), "file_renamed.txt");
        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
    }

}
