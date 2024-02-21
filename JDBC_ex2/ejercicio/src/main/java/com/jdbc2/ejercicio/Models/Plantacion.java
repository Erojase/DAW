package com.jdbc2.ejercicio.Models;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.jdbc2.ejercicio.Database.Interfaces.IQueriableResource;

public class Plantacion implements IQueriableResource{

    private int id;
    private String nombre;
    private double precio_compra;
    private double precio_venta;
    private Date proxima_coshecha;
    private int id_granjero;

    public Plantacion(int id, String nombre, double precio_compra, double precio_venta, Date proxima_coshecha, int id_granjero){
        this.id = id;
        this.nombre = nombre;
        this.precio_compra = precio_compra;
        this.precio_venta = precio_venta;
        this.proxima_coshecha = proxima_coshecha;
        this.id_granjero = id_granjero;
    }

    public int GetId_granjero(){
        return this.id_granjero;
    }
    
    public void SetId_granjero(int id_granjero){
        this.id_granjero = id_granjero;
    }
    public Date GetProxima_coshecha(){
        return this.proxima_coshecha;
    }
    
    public void SetProxima_coshecha(Date proxima_coshecha){
        this.proxima_coshecha = proxima_coshecha;
    }
    public double GetPrecio_venta(){
        return this.precio_venta;
    }
    
    public void SetPrecio_venta(double precio_venta){
        this.precio_venta = precio_venta;
    }
    public double GetPrecio_compra(){
        return this.precio_compra;
    }
    
    public void SetPrecio_compra(double precio_compra){
        this.precio_compra = precio_compra;
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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'Insert'");
    }
}
