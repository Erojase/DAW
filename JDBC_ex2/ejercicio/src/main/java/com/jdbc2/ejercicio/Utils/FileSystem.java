package com.jdbc2.ejercicio.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileSystem {

    public FileSystem() {

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

    public static List<String> listFolderCSVs(String path, List<String> filePaths) {
        File folder = new File(path);

        for (File fileEntry : folder.listFiles()) {
            if (fileEntry.isFile()) {
                filePaths.add(fileEntry.getAbsolutePath());
            } else if (fileEntry.isDirectory()) {
                listFolderCSVs(fileEntry.getAbsolutePath(), filePaths);
            }
        }
        return filePaths;
    }
}
