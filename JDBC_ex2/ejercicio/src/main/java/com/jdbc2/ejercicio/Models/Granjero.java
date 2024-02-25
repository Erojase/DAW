package com.jdbc2.ejercicio.Models;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jdbc2.ejercicio.Database.DataSource;
import com.jdbc2.ejercicio.Database.Interfaces.IQueriableResource;

public class Granjero implements IQueriableResource{

    private int id;
    private String nombre;
    private String descripcion;
    private double dinero;
    private int puntos;
    private int nivel;

    public Granjero(int id, String nombre, String descripcion, double dinero, int puntos, int nivel){
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.dinero = dinero;
        this.puntos = puntos;
        this.nivel = nivel;
    }

    public int GetNivel(){
        return this.nivel;
    }
    
    public void SetNivel(int nivel){
        this.nivel = nivel;
    }
    public int GetPuntos(){
        return this.puntos;
    }
    
    public void SetPuntos(int puntos){
        this.puntos = puntos;
    }
    public double GetDinero(){
        return this.dinero;
    }
    
    public void SetDinero(double dinero){
        this.dinero = dinero;
    }
    public String GetDescripcion(){
        return this.descripcion;
    }
    
    public void SetDescripcion(String descripcion){
        this.descripcion = descripcion;
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
        // id nombre descripcion dinero puntos nivel
        String sql = "INSERT INTO granjeros (id, nombre, descripcion, dinero, puntos, nivel) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement statement =  DataSource.getConnection().prepareStatement(sql);
        statement.setInt(1, id);
        statement.setString(2, nombre);
        statement.SetString(3, descripcion);
        statement.SetDouble(4, dinero);
        statement.SetInt(5, puntos);
        statement.setInt(6, nivel);
        return statement;
    }
}
