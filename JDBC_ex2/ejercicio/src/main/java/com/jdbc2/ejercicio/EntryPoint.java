package com.jdbc2.ejercicio;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class EntryPoint {
    
    private Properties properties;

    public EntryPoint(String[] args){
        properties = new Properties();
        try {
            properties.load(new FileInputStream(args[0]));
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        for (String csv : FileSystem.listFolderFiles(properties.getProperty("CSV_DIR_PATH"))) {
            CSVParser.loadCSV(csv);
        }
    }
}
