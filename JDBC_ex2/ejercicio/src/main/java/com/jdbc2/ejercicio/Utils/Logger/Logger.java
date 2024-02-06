package com.jdbc2.ejercicio.Utils.Logger;

public class Logger {
    
    public static LoggerState state = LoggerState.NotInitiated;

    private static String _errorLogPath;
    private static String _duplicateLogPath;

    public static void Init(String errorLogPath, String dupolicateLogPath){
        _errorLogPath = errorLogPath;
        _duplicateLogPath = dupolicateLogPath;

        state = LoggerState.Initiated;
    }

    public static void LogError(String error){
        
    }

    public static void LogDuplicate(String duplicate){
        
    }

}
