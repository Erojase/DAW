package com.jdbc2.ejercicio.Database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {


    public static void ExecuteUpdate(Connection conn, PreparedStatement updateSql){
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
