package com.jdbc2.ejercicio;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;

import com.jdbc2.ejercicio.Utils.CSVParser;
import com.jdbc2.ejercicio.Utils.FileSystem;

import com.jdbc2.ejercicio.Utils.Logger.Logger;

public class EntryPoint {
    
    private Properties properties;

    public EntryPoint(String[] args){
        properties = new Properties();
        try {
            properties.load(new FileInputStream(args[0]));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Logger.Init(
            properties.getProperty("ERROR_LOG_PATH"), 
            properties.getProperty("DUPLICATES_LOG_PATH"));


        Map<String, String> csvPathList = new Hashtable<>();
        FileSystem.listFolderCSVs(properties.getProperty("CSV_DIR_PATH"), csvPathList);
        

        for (String csvName : csvPathList.keySet()) {
            String csv = csvPathList.get(csvName);
            CSVParser.loadCSV(csv);
        }
    }
}
