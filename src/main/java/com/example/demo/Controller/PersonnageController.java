package com.example.demo.Controller;

import com.example.demo.Model.Acteur;
import com.example.demo.Model.Personnage;
import com.example.demo.Service.FilmService;
import com.example.demo.Service.PersonnageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class PersonnageController {
    @Autowired
    private PersonnageService service;

    public PersonnageController(PersonnageService serv){
        this.service = serv;
    }

    @GetMapping(value = "/GetPersonnages")
    public List<Personnage> getAllPersonnages(){
        List<Personnage> personnages = this.service.getAllPersonnages();
        return personnages;
    }

    @GetMapping(value = "/GetPersonnage")
    public Optional<Personnage> getOnePersonnage(@RequestParam(value = "NoAct") int noAct, @RequestParam(value = "NoFilm") int noFilm){
        Optional<Personnage> personnage = this.service.getOneById(noAct,noFilm);
        return personnage;
    }

    @PostMapping(value = "/AddPersonnage")
    public void addPersonnage(@RequestBody Personnage personnage){
        this.service.AddPersonnage(personnage);
    }

    @PutMapping(value = "/UpdatePersonnage")
    public ResponseEntity updatePersonnage(@RequestBody Personnage personnage, @RequestParam(value = "NoAct") int noAct, @RequestParam(value = "NoFilm") int noFilm){
        this.service.updateById(personnage,noAct,noFilm);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/DeletePersonnage")
    public ResponseEntity deleteTemperature(@RequestParam(value = "NoAct") int noAct, @RequestParam(value = "NoFilm") int noFilm){
        this.service.deleteById(noAct,noFilm);
        return ResponseEntity.noContent().build();
    }
}
