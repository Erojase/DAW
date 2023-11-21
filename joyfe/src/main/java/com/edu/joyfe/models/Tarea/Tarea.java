package com.edu.joyfe.models.Tarea;

import java.util.Date;

public class Tarea {

    private int _id;
    private String _titulo;
    private String _descripcion;
    private Date _fecha_entrega;
    private int _materiaId;

    public Tarea(int id, String titulo, String descripcion, Date fecha_entrega, int materiaId){
        _id = id;
        _titulo = titulo;
        _descripcion = descripcion;
        _fecha_entrega = fecha_entrega;
        _materiaId = materiaId;
    }

    public int GetId(){
        return _id;
    }
    
    public void SetId(int id){
        _id = id;
    }

    public int GetMateria(){
        return _materiaId;
    }
    
    public void SetMateria(int materiaId){
        _materiaId = materiaId;
    }

    public Date GetFecha_entrega(){
        return _fecha_entrega;
    }
    
    public void SetFecha_entrega(Date fecha_entrega){
        _fecha_entrega = fecha_entrega;
    }
    public String GetDescripcion(){
        return _descripcion;
    }
    
    public void SetDescripcion(String descripcion){
        _descripcion = descripcion;
    }
    public String GetTitulo(){
        return _titulo;
    }
    
    public void SetTitulo(String titulo){
        _titulo = titulo;
    }
}
