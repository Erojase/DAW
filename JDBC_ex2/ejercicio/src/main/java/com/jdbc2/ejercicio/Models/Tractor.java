package com.jdbc2.ejercicio.Models;

public class Tractor {

    private int id;
    private String modelo;
    private int velocidad;
    private int precio_venta;
    private int id_construccion;

    public Tractor(int id, String modelo, int velocidad, int precio_venta, int id_construccion){
        this.id = id;
        this.modelo = modelo;
        this.velocidad = velocidad;
        this.precio_venta = precio_venta;
        this.id_construccion = id_construccion;
    }

    public int GetId_construccion(){
        return this.id_construccion;
    }
    
    public void SetId_construccion(int id_construccion){
        this.id_construccion = id_construccion;
    }
    public int GetPrecio_venta(){
        return this.precio_venta;
    }
    
    public void SetPrecio_venta(int precio_venta){
        this.precio_venta = precio_venta;
    }
    public int GetVelocidad(){
        return this.velocidad;
    }
    
    public void SetVelocidad(int velocidad){
        this.velocidad = velocidad;
    }
    public String GetModelo(){
        return this.modelo;
    }
    
    public void SetModelo(String modelo){
        this.modelo = modelo;
    }
    public int GetId(){
        return this.id;
    }
    
    public void SetId(int id){
        this.id = id;
    }
}
