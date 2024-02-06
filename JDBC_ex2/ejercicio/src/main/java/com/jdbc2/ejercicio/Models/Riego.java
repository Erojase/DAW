package com.jdbc2.ejercicio.Models;

public class Riego {

    private int id;
    private String tipo;
    private int velocidad;
    private int id_plantacion;

    public Riego(int id, String tipo, int velocidad, int id_plantacion){
        this.id = id;
        this.tipo = tipo;
        this.velocidad = velocidad;
        this.id_plantacion = id_plantacion;
    }

    public int Getid_plantacion(){
        return this.id_plantacion;
    }
    
    public void Setid_plantacion(int id_plantacion){
        this.id_plantacion = id_plantacion;
    }
    public int GetVelocidad(){
        return this.velocidad;
    }
    
    public void SetVelocidad(int velocidad){
        this.velocidad = velocidad;
    }
    public String GetTipo(){
        return this.tipo;
    }
    
    public void SetTipo(String tipo){
        this.tipo = tipo;
    }
    public int GetId(){
        return this.id;
    }
    
    public void SetId(int id){
        this.id = id;
    }
}
