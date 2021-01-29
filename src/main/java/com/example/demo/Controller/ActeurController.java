package com.example.demo.Controller;

import com.example.demo.Model.Acteur;
import com.example.demo.Model.Film;
import com.example.demo.Model.Personnage;
import com.example.demo.Service.ActeurService;
import com.example.demo.Service.FilmService;
import com.example.demo.Service.PersonnageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class ActeurController {
    @Autowired
    private ActeurService service;
    @Autowired
    private FilmService serviceFilm;
    @Autowired
    private PersonnageService servicePerso;

    public ActeurController(ActeurService serv, FilmService serv2){
        this.service = serv;
        this.serviceFilm = serv2;
    }

    @GetMapping(value = "/GetActeurs")
    public List<Acteur> getAllActeurs(){
        List<Acteur> acteurs = this.service.getAllActeurs();
        return acteurs;
    }

    @GetMapping(value = "/GetActeur/{NoAct}")
    public Optional<Acteur> getOneActeur(@PathVariable("NoAct") int id){
        Optional<Acteur> acteur = this.service.getOneById(id);
        return acteur;
    }

    @GetMapping(value = "/GetFilmOfActeur/{NoAct}")
    public List<Film> getFilmOfActeur(@PathVariable("NoAct") int id){
        List<Personnage> persos = this.servicePerso.getAllByNoAct(id);
        List<Film> films = new ArrayList<>();
        for(int i=0;i<persos.size();i++){
            films.add(this.serviceFilm.getOneById(persos.get(i).getNoFilm()).get());
        }
        return films;
    }

    @GetMapping(value = "/GetPersonnageOfActeur/{NoAct}")
    public List<Personnage> getPersonnageOfActeur(@PathVariable("NoAct") int id){
        List<Personnage> persos = this.servicePerso.getAllByNoAct(id);
        return persos;
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
