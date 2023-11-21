package com.edu.joyfe.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;



@RestController
@EnableAutoConfiguration
@RequestMapping("/users")
public class testController {

    
    @RequestMapping(method = RequestMethod.GET)
    public String SampleUser() {
        String response = "buenas tardes";
        return response;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String SamplePOST(@RequestBody final String user) {
        String response = "buenas tardes " + user;
        return response;
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public String deleteUser(@PathVariable("id") int userId) {
        return userId + " is the userid";
    }
}