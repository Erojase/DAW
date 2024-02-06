package com.jdbc2.ejercicio.Database.Interfaces;

import java.util.List;

public interface IDaoResource<T> {
    
    T get(int id);
    List<T> getAll();
    int insert(T t);
    void update(T t);
    void delete(T t);

}
