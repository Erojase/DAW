package com.jdbc2.ejercicio.Models;

public class Granjero {

    private int id;
    private String nombre;
    private String descripcion;
    private int dinero;
    private int puntos;
    private int nivel;

    public Granjero(int id, String nombre, String descripcion, int dinero, int puntos, int nivel){
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
    public int GetDinero(){
        return this.dinero;
    }
    
    public void SetDinero(int dinero){
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
}
