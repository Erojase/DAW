package com.edu.joyfe.models.Materia;



public class Materia {

    private int _id;
    private String _nombre;
    private String _descripcion;
    private Ciclo _ciclo;
    private Curso _curso;

    public Materia(int id, String nombre, String descripcion, Ciclo ciclo, Curso curso) {
        _id = id;
        _nombre = nombre;
        _descripcion = descripcion;
        _ciclo = ciclo;
        _curso = curso;
    }

    public String GetNombre() {
        return _nombre;
    }

    public void SetNombre(String nombre) {
        _nombre = nombre;
    }

    public int GetId() {
        return _id;
    }

    public void SetId(int id) {
        _id = id;
    }

    public String GetDescripcion() {
        return _descripcion;
    }

    public void SetDescripcion(String descripcion) {
        _descripcion = descripcion;
    }

    public Ciclo GetCiclo() {
        return _ciclo;
    }

    public void SetCiclo(Ciclo ciclo) {
        _ciclo = ciclo;
    }

    public Curso GetCurso() {
        return _curso;
    }

    public void SetCurso(Curso curso) {
        _curso = curso;
    }

}