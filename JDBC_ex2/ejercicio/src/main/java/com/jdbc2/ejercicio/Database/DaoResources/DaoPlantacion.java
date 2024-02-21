package com.jdbc2.ejercicio.Database.DaoResources;

import java.sql.SQLException;
import java.util.List;

import com.jdbc2.ejercicio.Database.Database;
import com.jdbc2.ejercicio.Database.Interfaces.IDaoResource;
import com.jdbc2.ejercicio.Models.Plantacion;
import com.jdbc2.ejercicio.Utils.Logger.Logger;

public class DaoPlantacion implements IDaoResource<Plantacion>{

    @Override
    public Plantacion get(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public List<Plantacion> getAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public int insert(Plantacion t) {
        try {
            Database.ExecuteInsert(t.Insert());
        } catch (SQLException e) {
            Logger.LogError(e.toString());
        }
        return 0;
    }

    @Override
    public void update(Plantacion t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Plantacion t) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
