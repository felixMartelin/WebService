package com.example.demo.Controller;

import com.example.demo.Service.FilmService;
import com.example.demo.Service.PersonnageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonnageController {
    @Autowired
    private PersonnageService service;

    public PersonnageController(PersonnageService serv){
        this.service = serv;
    }
}
