package com.jdbc2.ejercicio.Database.Interfaces;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface IQueriableResource {
    PreparedStatement SelectById(int id) throws SQLException;
    PreparedStatement Insert() throws SQLException;
}
