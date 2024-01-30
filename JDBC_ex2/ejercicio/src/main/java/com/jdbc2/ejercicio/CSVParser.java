package com.jdbc2.ejercicio;

import java.util.List;
import java.util.Map;

public class CSVParser {
    
    public static Map<String, Object> loadCSV(String path){
        List<String> csvLines =  FileSystem.getFileLines(path);
        String headers = csvLines.get(0);
        
        
        return null;
    }
}
