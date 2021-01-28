package com.example.demo.Controller;

import com.example.demo.Model.Acteur;
import com.example.demo.Model.Film;
import com.example.demo.Service.ActeurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ActeurController {
    @Autowired
    private ActeurService service;

    public ActeurController(ActeurService serv){
        this.service = serv;
    }

    @GetMapping(value = "/GetActeurs")
    public List<Acteur> getAllActeurs(){
        List<Acteur> acteurs = this.service.getAllActeurs();
        return acteurs;
    }

    @GetMapping(value = "/GetActeur/{NoAct}")
    public Optional<Acteur> getAllFilms(@PathVariable("NoAct") int id){
        Optional<Acteur> acteur = this.service.getOneById(id);
        return acteur;
    }

    @PostMapping(value = "/AddActeur")
    public void addActeur(@RequestBody Acteur acteur){
        this.service.AddActeur(acteur);
    }

    @PutMapping(value = "/UpdateActeur/{NoAct}")
    public ResponseEntity updateActeur(@RequestBody Acteur acteur, @RequestParam(value = "NoAct") int id){
        this.service.updateById(acteur,id);
        return ResponseEntity.noContent().build();
    }
}
