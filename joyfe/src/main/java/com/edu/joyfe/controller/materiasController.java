package com.edu.joyfe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.edu.joyfe.service.Materias;
import com.fasterxml.jackson.core.JsonProcessingException;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api/v1/materias")
public class materiasController {
    
    @Autowired
    Materias materias;

    @RequestMapping(method = RequestMethod.GET)
    public String GetMaterias() throws JsonProcessingException {
        return materias.MateriasToJson();
    }

}
