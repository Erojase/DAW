package com.jdbc2.ejercicio;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import com.jdbc2.ejercicio.Models.Construccion;
import com.jdbc2.ejercicio.Models.Granjero;
import com.jdbc2.ejercicio.Models.Plantacion;
import com.jdbc2.ejercicio.Models.Riego;
import com.jdbc2.ejercicio.Models.Tractor;
import com.jdbc2.ejercicio.Utils.CSVParser;
import com.jdbc2.ejercicio.Utils.FileSystem;

import com.jdbc2.ejercicio.Utils.Logger.Logger;

public class EntryPoint {

    private Properties properties;

    public EntryPoint(String[] args,
            List<Construccion> construcciones,
            List<Granjero> granjeros,
            List<Plantacion> plantaciones,
            List<Riego> riegos,
            List<Tractor> tractores) {
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
            List<Dictionary<String, Object>> model = CSVParser.loadCSV(csv);
            switch (csvName) {
                case "construcciones.csv":
                    for (Dictionary<String, Object> dict : model) {
                        // "id","nombre","precio","id_granjero"
                        try {
                            construcciones.add(new Construccion(
                                    Integer.parseInt((String) dict.get("id")),
                                    (String) dict.get("nombre"),
                                    Double.parseDouble((String) dict.get("precio")),
                                    Integer.parseInt((String) dict.get("id_granjero"))));
                        } catch (Exception e) {
                            Logger.LogError(e.toString());
                        }
                    }

                    break;
                case "granjero_granjero.csv":

                    break;
                case "granjeros.csv":
                    for (Dictionary<String, Object> dict : model) {
                        // "id","nombre","descripcion","dinero","puntos","nivel"
                        try {
                            granjeros.add(new Granjero(
                                Integer.parseInt((String)dict.get("id")),
                                (String) dict.get("nombre"),
                                (String) dict.get("descripcion"),
                                Double.parseDouble((String) dict.get("dinero")),
                                Integer.parseInt((String) dict.get("puntos")),
                                Integer.parseInt((String) dict.get("nivel"))
                                    ));
                        } catch (Exception e) {
                            Logger.LogError(e.toString());
                        }
                    }
                    break;
                case "plantaciones.csv":
                    for (Dictionary<String, Object> dict : model) {
                        // "id","nombre","precio_compra","precio_venta","proxima_cosecha","id_granjero"
                        try {
                            plantaciones.add(new Plantacion(
                                    Integer.parseInt((String) dict.get("id")),
                                    (String) dict.get("nombre"),
                                    Double.parseDouble((String) dict.get("precio_compra")),
                                    Double.parseDouble((String) dict.get("precio_venta")),
                                    Date.valueOf((String) dict.get("proxima_cosecha")),
                                    Integer.parseInt((String) dict.get("id_granjero"))));
                        } catch (Exception e) {
                            Logger.LogError(e.toString());
                        }
                    }
                    break;
                case "riegos.csv":
                    for (Dictionary<String, Object> dict : model) {
                        // "id","tipo","velocidad","id_plantacion"
                        try {
                            riegos.add(new Riego(
                                    Integer.parseInt((String) dict.get("id")),
                                    (String) dict.get("tipo"),
                                    Integer.parseInt((String) dict.get("velocidad")),
                                    Integer.parseInt((String) dict.get("id_plantacion"))));
                        } catch (Exception e) {
                            Logger.LogError(e.toString());
                        }
                    }
                    break;
                case "tractores.csv":
                    for (Dictionary<String, Object> dict : model) {
                        // "id","modelo","velocidad","precio_venta","id_construccion"
                        try {
                            tractores.add(new Tractor(
                                    Integer.parseInt((String) dict.get("id")),
                                    (String) dict.get("nombre"),
                                    Integer.parseInt((String) dict.get("velocidad")),
                                    Double.parseDouble((String) dict.get("precio_venta")),
                                    Integer.parseInt((String) dict.get("id_construccion"))));
                        } catch (Exception e) {
                            Logger.LogError(e.toString());
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }
}
