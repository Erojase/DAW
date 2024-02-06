package com.jdbc2.ejercicio.Utils;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class CSVParser {
    
    public static List<Dictionary<String, Object>> loadCSV(String path){
        List<String[]> csvLines =  FileSystem.getFileLines(path);
        String[] headers = csvLines.get(0);

        List<Dictionary<String, Object>> list = new ArrayList<>();

        for (int i = 1; i < csvLines.size(); i++) {
            Dictionary<String, Object> dict = new Hashtable<>();
            for (int j = 0; j < csvLines.get(i).length; j++) {
                dict.put(headers[j], csvLines.get(i)[j]);
            }
            list.add(dict);
        }
        
        return list;
    }
}
