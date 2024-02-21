package com.jdbc2.ejercicio.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class FileSystem {

    public FileSystem() {

    }

    public static String CreateFileIfNotExists(String path) {
        if (!Files.exists(Path.of(path), LinkOption.NOFOLLOW_LINKS))
            try {
                Files.createFile(Path.of(path));
            } catch (IOException e) {
                e.printStackTrace();
            }
        return path;
    }

    public static List<String[]> getFileLines(String path) {
        List<String[]> result = new ArrayList<String[]>();
        try {
            File thisFile = new File(path);
            Scanner reader = new Scanner(thisFile);
            while (reader.hasNextLine()) {
                String[] data = reader.nextLine().replaceAll("\"", "").split(",");
                result.add(data);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return result;
    }

    public static Map<String, String> listFolderCSVs(String path, Map<String, String> filePaths) {
        File folder = new File(path);

        for (File fileEntry : folder.listFiles()) {
            if (fileEntry.isFile()) {
                filePaths.put(fileEntry.getName(), fileEntry.getAbsolutePath());
            } else if (fileEntry.isDirectory()) {
                listFolderCSVs(fileEntry.getAbsolutePath(), filePaths);
            }
        }
        return filePaths;
    }
}
