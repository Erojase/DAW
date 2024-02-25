package com.jdbc2.ejercicio.Database.DaoResources;

import java.sql.SQLException;
import java.util.List;

import com.jdbc2.ejercicio.Database.Database;
import com.jdbc2.ejercicio.Database.Interfaces.IDaoResource;
import com.jdbc2.ejercicio.Models.Riego;
import com.jdbc2.ejercicio.Utils.Logger.Logger;

public class DaoRiego implements IDaoResource<Riego>{

    @Override
    public Riego get(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public List<Riego> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public int insert(Riego t) {
        try {
            Database.ExecuteInsert(t.Insert());
        } catch (SQLException e) {
            Logger.LogError(e.toString());
        }
        return 0;
    }

    @Override
    public void update(Riego t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Riego t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}