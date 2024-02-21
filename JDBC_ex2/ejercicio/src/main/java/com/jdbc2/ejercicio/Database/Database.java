package com.jdbc2.ejercicio.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jdbc2.ejercicio.Utils.Logger.Logger;

public class Database {


    public static void ExecuteSelect(PreparedStatement selectSql) throws SQLException{
        Connection conn = DataSource.getConnection();
        try {
            
            conn.setAutoCommit(false);
            selectSql.executeQuery();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    public static void ExecuteInsert(PreparedStatement insertSql) throws SQLException{
        Connection conn = DataSource.getConnection();
        try {
            conn.setAutoCommit(false);
            insertSql.execute();
            conn.commit();
        } catch (SQLException e) {
            Logger.LogError(e.toString());
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    public static void ExecuteUpdate(PreparedStatement updateSql) throws SQLException{
        Connection conn = DataSource.getConnection();
        try {
            conn.setAutoCommit(false);
            updateSql.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                conn.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }


    
}
