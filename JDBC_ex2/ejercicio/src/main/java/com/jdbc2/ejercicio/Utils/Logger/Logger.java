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

        state = LoggerState.Initiated;
    }

    public static void LogError(String error) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(_errorFile, true));
        writer.append('\n');
        writer.append(error);
        writer.close();
    }

    public static void LogDuplicate(String duplicate) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(_duplicatesFile, true));
        writer.append('\n');
        writer.append(duplicate);
        writer.close();
    }

}
