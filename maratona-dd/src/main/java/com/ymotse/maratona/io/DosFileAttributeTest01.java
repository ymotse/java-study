package com.ymotse.maratona.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributeView;
import java.nio.file.attribute.DosFileAttributes;

public class DosFileAttributeTest01 {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("pasta/teste.txt");

        if(Files.notExists(path)) {
            Files.createFile(path);
        }
        Files.setAttribute(path, "dos:hidden", true);
        Files.setAttribute(path, "dos:readonly", false);

        DosFileAttributes dosFileAttributes = Files.readAttributes(path, DosFileAttributes.class);
        System.out.println(dosFileAttributes.isHidden());
        System.out.println(dosFileAttributes.isReadOnly());

        DosFileAttributeView dosFileAttributeView = Files.getFileAttributeView(path, DosFileAttributeView.class);
        dosFileAttributeView.setHidden(false);
        dosFileAttributeView.setReadOnly(true);

        System.out.println(dosFileAttributeView.readAttributes().isHidden());
        System.out.println(dosFileAttributeView.readAttributes().isReadOnly());
    }

}
