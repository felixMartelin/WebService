package com.example.demo.Controller;

import com.example.demo.Service.ActeurService;
import com.example.demo.Service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategorieController {
    @Autowired
    private CategorieService service;

    public CategorieController(CategorieService serv){
        this.service = serv;
    }
}
