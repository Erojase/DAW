package com.jdbc2.ejercicio.Models;

import java.sql.Date;

public class Plantacion {

    private int id;
    private String nombre;
    private int precio_compra;
    private int precio_venta;
    private Date proxima_coshecha;
    private int id_granjero;

    public Plantacion(int id, String nombre, int precio_compra, int precio_venta, Date proxima_coshecha, int id_granjero){
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
    public int GetPrecio_venta(){
        return this.precio_venta;
    }
    
    public void SetPrecio_venta(int precio_venta){
        this.precio_venta = precio_venta;
    }
    public int GetPrecio_compra(){
        return this.precio_compra;
    }
    
    public void SetPrecio_compra(int precio_compra){
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
}
