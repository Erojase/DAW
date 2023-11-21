package com.edu.joyfe.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.edu.joyfe.models.Materia.Ciclo;
import com.edu.joyfe.models.Materia.Curso;
import com.edu.joyfe.models.Materia.Materia;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import jakarta.annotation.PostConstruct;

@Service
public class Materias {

    private List<Materia> _materias = new ArrayList<Materia>();
    private ObjectMapper objectMapper = new ObjectMapper();

    @PostConstruct
    public void initialize(){
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        GenerateTestData();
    }

    public List<Materia> GetMaterias(){
        return _materias;
    }

    public void AddMaterias(Materia mat){
        _materias.add(mat);
    }

    public String MateriasToJson() {
        try {
            String materias = objectMapper.writeValueAsString(_materias);
            return materias;
        } catch (Exception e) {
            System.out.println(e);
            return e.getStackTrace().toString();
        }
        
    }

    public void GenerateTestData(){
        AddMaterias(new Materia(0, "Desarrollo de Servidor", "descripcion", Ciclo.DAW, Curso._2º));
        AddMaterias(new Materia(1, "Desarrollo de materias", "descripcion", Ciclo.DAW, Curso._2º));
        AddMaterias(new Materia(2, "Entorno entornado", "descripcion", Ciclo.DAW, Curso._1º));
        AddMaterias(new Materia(3, "Vini vidi vinci", "descripcion", Ciclo.DAM, Curso._2º));
        AddMaterias(new Materia(4, "Materia 3", "descripcion", Ciclo.DAM, Curso._1º));
        AddMaterias(new Materia(5, "Otra materia", "descripcion", Ciclo.DAM, Curso._1º));
        AddMaterias(new Materia(6, "Bandersnatch", "descripcion", Ciclo.ASIR, Curso._2º));
    }
    
}
