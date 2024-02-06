package com.jdbc2.ejercicio.Models;

public class Construccion {

    private int id;
    private String nombre;
    private int precio;
    private int id_granjero;

    public Construccion(int id, String nombre, int precio, int id_granjero){
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
    public int GetPrecio(){
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
}
