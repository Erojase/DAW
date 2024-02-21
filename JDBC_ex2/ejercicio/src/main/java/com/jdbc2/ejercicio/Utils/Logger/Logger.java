package com.jdbc2.ejercicio.Utils.Logger;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.jdbc2.ejercicio.Utils.FileSystem;

public class Logger {

    public static LoggerState state = LoggerState.NotInitiated;

    private static File _errorFile;
    private static File _duplicatesFile;

    public static void Init(String errorLogPath, String duplicateLogPath) {
        _errorFile = new File(FileSystem.CreateFileIfNotExists(errorLogPath));
        _duplicatesFile = new File(FileSystem.CreateFileIfNotExists(duplicateLogPath));

        EmptyFiles();

        state = LoggerState.Initiated;
    }

    public static void LogError(String error) {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(_errorFile, true));
            writer.append('\n');
            writer.append(error);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void LogDuplicate(String duplicate) {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(_duplicatesFile, true));
            writer.append('\n');
            writer.append(duplicate);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void EmptyFiles(){
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(_errorFile, false));
            writer.write("");
            writer.flush();
            writer.close();

            writer = new BufferedWriter(new FileWriter(_duplicatesFile, false));
            writer.write("");
            writer.flush();
            writer.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }

}
