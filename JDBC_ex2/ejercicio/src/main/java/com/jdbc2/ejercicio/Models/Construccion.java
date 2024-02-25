package com.jdbc2.ejercicio.Models;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jdbc2.ejercicio.Database.DataSource;
import com.jdbc2.ejercicio.Database.Interfaces.IQueriableResource;

public class Construccion implements IQueriableResource{

    private int id;
    private String nombre;
    private double precio;
    private int id_granjero;

    public Construccion(int id, String nombre, double precio, int id_granjero){
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.id_granjero = id_granjero;
    }

    public int GetId_granjero(){
        return this.id_granjero;
    }
    
    public void SetId_granjero(int id_granjero){
        this.id_granjero = id_granjero;
    }
    public double GetPrecio(){
        return this.precio;
    }
    
    public void SetPrecio(int precio){
        this.precio = precio;
    }
    public String GetNombre(){
        return this.nombre;
    }
    
    public void SetNombre(String nombre){
        this.nombre = nombre;
    }
    public int GetId(){
        return this.id;
    }
    
    public void SetId(int id){
        this.id = id;
    }

    @Override
    public PreparedStatement SelectById(int id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'SelectById'");
    }

    @Override
    public PreparedStatement Insert() throws SQLException {
        //id nombre precio id_granjero
        String sql = "INSERT INTO construcciones (id, nombre, precio, id_granjero) VALUES (?, ?, ?, ?)";
        PreparedStatement statement = DataSource.getConnection().prepareStatement(sql);
        statement.setInt(1, id);
        statement.setString(2, nombre);
        statement.setDouble(3, precio);
        statement.setInt(4, id_granjero);
        return statement;
    }
}
