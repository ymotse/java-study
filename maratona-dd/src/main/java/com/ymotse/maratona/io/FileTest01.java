package com.ymotse.maratona.io;

import java.io.File;
import java.time.Instant;
import java.time.ZoneId;

public class FileTest01 {

    public static void main(String[] args) {
        File file = new File("C:\\Users\\Isac\\Documents\\workspace_java\\java-estudos\\maratona-dd\\arquivo\\file.txt");

        try {
            boolean exists = file.exists();

            if(exists) {
                boolean isDeleted = file.delete();
                System.out.println("Deleted: " + isDeleted);
            }

            boolean isCreated = file.createNewFile();
            System.out.println("Created: " + isCreated);

            System.out.println("Path: " + file.getPath());
            System.out.println("Path absolute: " + file.getAbsolutePath());
            System.out.println("Is file: " + file.isFile());
            System.out.println("Is directory: " + file.isDirectory());
            System.out.println("Is hidden: " + file.isHidden());
            System.out.println("Can read: " + file.canRead());
            System.out.println("Last modified: " + Instant.ofEpochMilli(file.lastModified()).atZone(ZoneId.systemDefault()).toLocalDateTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
