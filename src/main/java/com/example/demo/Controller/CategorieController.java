package com.example.demo.Controller;

import com.example.demo.Model.Categorie;
import com.example.demo.Model.Film;
import com.example.demo.Service.ActeurService;
import com.example.demo.Service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class CategorieController {
    @Autowired
    private CategorieService service;

    public CategorieController(CategorieService serv){
        this.service = serv;
    }

    @GetMapping(value = "/GetCategories")
    public List<Categorie> getAllCategories(){
        List<Categorie> categories = this.service.getAllCategories();
        return categories;
    }
}
