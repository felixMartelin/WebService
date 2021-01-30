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

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
public class PersonnageController {
    @Autowired
    private PersonnageService service;

    @Autowired
    private FilmService filmService;

    @Autowired
    private ActeurService acteurService;

    public PersonnageController(PersonnageService serv){
        this.service = serv;
    }

    @GetMapping(value = "/GetPersonnages")
    public ResponseEntity<List<Personnage>> getAllPersonnages(){
        try { return ResponseEntity.ok().body(this.service.getAllPersonnages()); }
        catch (Exception e) {
            System.err.println("Unable to get list of roles.");
            e.printStackTrace();
            return ResponseEntity.notFound().build(); }
    }

    @GetMapping(value = "/GetPersonnage")
    public ResponseEntity<Personnage> getOnePersonnage(@RequestParam(value = "NoAct", defaultValue = "-1") String noActStr, @RequestParam(value = "NoFilm", defaultValue = "-1") String noFilmStr){
        long noAct, noFilm;
        try { noAct = Long.valueOf(noActStr); }
        catch (NumberFormatException e) {
            System.err.println("Unable to parse noAct : '" + noActStr + "'.");
            e.printStackTrace();
            return ResponseEntity.badRequest().build(); }
        try { noFilm = Long.valueOf(noFilmStr); }
        catch (NumberFormatException e) {
            System.err.println("Unable to parse noFilm : '" + noFilmStr + "'.");
            e.printStackTrace();
            return ResponseEntity.badRequest().build(); }
        Acteur acteur = null;
        try { acteur = acteurService.getById(noAct).get(); }
        catch (NoSuchElementException e) {
            System.err.println("No actor for noAct '" + noAct + "'.");
            e.printStackTrace();
            return ResponseEntity.badRequest().build(); }
        Film film = null;
        try { film = filmService.getOneById(noFilm).get(); }
        catch (NoSuchElementException e) {
            System.err.println("No film for noFilm '" + noFilm + "'.");
            e.printStackTrace();
            return ResponseEntity.badRequest().build(); }
        try { return ResponseEntity.ok().body(this.service.getById(acteur, film)); }
        catch (Exception e) {
            System.err.println("Unable to get role for noAct '" + noAct + "' and noFilm '" + noFilm + "'.");
            e.printStackTrace();
            return ResponseEntity.notFound().build(); }
    }

    @PostMapping(value = "/AddPersonnage")
    public void addPersonnage(@RequestBody Personnage personnage){
        System.out.println("Ajout de " + personnage.getNom() + " au film " + personnage.getNoFilm() + " par l'acteur " + personnage.getNoAct());
        this.service.AddPersonnage(personnage);
    }

    @PutMapping(value = "/UpdatePersonnage")
    public ResponseEntity updatePersonnage(@RequestBody Personnage personnage, @RequestParam(value = "NoAct") int noAct, @RequestParam(value = "NoFilm") int noFilm){
        this.service.updateById(personnage,noAct,noFilm);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/DeletePersonnage")
    public ResponseEntity deleteTemperature(@RequestParam(value = "NoAct") int noAct, @RequestParam(value = "NoFilm") int noFilm){
        System.out.println("Delete role by actor id " + noAct + " and movie id " + noFilm);
        this.service.deleteById(noAct,noFilm);
        return ResponseEntity.noContent().build();
    }
}
