package com.files.files;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FilesApplication {

    public static void listFilesForFolder(final File folder) {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                System.out.println(fileEntry.getName());
            }
        }
    }

    public static void main(String[] args) {
        // String gearRepo = System.getenv("GEAR_REPO");
        String gearRepo = "/home/annipi/GEAR/files/src/main/resources/DocIntegradosGEAR";
        System.out.println("Gear repo: " + gearRepo);
        File folder = new File(gearRepo);
        listFilesForFolder(folder);
        // SpringApplication.run(FilesApplication.class, args);
    }

}
