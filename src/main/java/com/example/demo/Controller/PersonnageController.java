package com.example.demo.Controller;

import com.example.demo.Model.Acteur;
import com.example.demo.Model.Film;
import com.example.demo.Model.Personnage;
import com.example.demo.Service.ActeurService;
import com.example.demo.Service.FilmService;
import com.example.demo.Service.PersonnageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
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
        try { return ResponseEntity.ok(this.service.getAllPersonnages()); }
        catch (Exception e) {
            System.err.println("Unable to get list of roles.");
            e.printStackTrace();
            return ResponseEntity.notFound().build(); }
    }

    @GetMapping(value = "/GetPersonnage")
    public ResponseEntity getOnePersonnage(@RequestParam(value = "NoAct", defaultValue = "none") String noActStr,
                                           @RequestParam(value = "NoFilm", defaultValue = "none") String noFilmStr){
        ResponseEntity<Acteur> acteur = getActeur(noActStr);
        if(acteur.getStatusCode() != HttpStatus.OK) {
            return acteur;
        }
        ResponseEntity<Film> film = getFilm(noFilmStr);
        if(film.getStatusCode() != HttpStatus.OK) {
            return film;
        }
        try { return ResponseEntity.ok(this.service.getById(acteur.getBody().getNoAct(), film.getBody().getNoFilm())); }
        catch (Exception e) {
            System.err.println("Unable to get role for noAct '" + acteur.getBody().getNoAct() + "' and noFilm '" + film.getBody().getNoFilm() + "'.");
            e.printStackTrace();
            return ResponseEntity.notFound().build(); }
    }

    @PostMapping(value = "/AddPersonnage")
    public ResponseEntity addPersonnage(@RequestBody Map<String, String> payload) {
        String nomPers = payload.get("nomPers"), noActStr = payload.get("noAct"), noFilmStr = payload.get("noFilm");
        ResponseEntity<Acteur> acteur = getActeur(noActStr);
        if(acteur.getStatusCode() != HttpStatus.OK) {
            return acteur;
        }
        ResponseEntity<Film> film = getFilm(noFilmStr);
        if(film.getStatusCode() != HttpStatus.OK) {
            return film;
        }
        Personnage newPers = new Personnage();
        newPers.setNom(nomPers);
        newPers.setNoAct(acteur.getBody().getNoAct());
        newPers.setNoFilm(film.getBody().getNoFilm());
        newPers.setActeurByActeurId(acteur.getBody());
        newPers.setFilmByFilmId(film.getBody());
        System.out.println("Essai new pers get acteur get prenom : " + newPers.getActeurByActeurId().getPrenom());
        return ResponseEntity.ok(this.service.addNewPersonnage(newPers));
    }

    @PutMapping(value = "/UpdatePersonnage")
    public ResponseEntity updatePersonnage(@RequestBody Map<String, String> payload){
        return addPersonnage(payload);
    }

    @DeleteMapping(value = "/DeletePersonnage")
    public ResponseEntity deleteTemperature(@RequestParam(value = "NoAct") String noActStr,
                                            @RequestParam(value = "NoFilm") String noFilmStr){
        ResponseEntity<Acteur> acteur = getActeur(noActStr);
        if(acteur.getStatusCode() != HttpStatus.OK) {
            return acteur;
        }
        ResponseEntity<Film> film = getFilm(noFilmStr);
        if(film.getStatusCode() != HttpStatus.OK) {
            return film;
        }
        System.out.println("Delete role by actor id " + acteur.getBody().getNoAct() + " and movie id " + film.getBody().getNoFilm());
        return ResponseEntity.ok(this.service.delete(acteur.getBody().getNoAct(),film.getBody().getNoFilm()));
    }

    private ResponseEntity<Acteur> getActeur(String noActStr) {
        long noAct;
        try { noAct = Long.valueOf(noActStr); }
        catch (NumberFormatException e) {
            System.err.println("Unable to parse noAct : '" + noActStr + "'.");
            e.printStackTrace();
            return ResponseEntity.badRequest().build(); }
        if (noAct < 1) {
            System.err.println("noAct < 1 : '" + noAct + "'");
            return ResponseEntity.badRequest().build(); }
        try { return  ResponseEntity.ok(acteurService.getById(noAct).get()); }
        catch (NoSuchElementException e) {
            System.err.println("No actor for noAct '" + noAct + "'.");
            e.printStackTrace();
            return ResponseEntity.badRequest().build(); }
    }

    private ResponseEntity<Film> getFilm(String noFilmStr) {
        long noFilm;
        try { noFilm = Long.valueOf(noFilmStr); }
        catch (NumberFormatException e) {
            System.err.println("Unable to parse noFilm : '" + noFilmStr + "'.");
            e.printStackTrace();
            return ResponseEntity.badRequest().build(); }
        if (noFilm < 1) {
            System.err.println("noFilm < 1 : '" + noFilm + "'");
            return ResponseEntity.badRequest().build(); }
        try { return  ResponseEntity.ok(filmService.getOneById(noFilm).get()); }
        catch (NoSuchElementException e) {
            System.err.println("No film for noFilm '" + noFilm + "'.");
            e.printStackTrace();
            return ResponseEntity.badRequest().build(); }
    }
}
