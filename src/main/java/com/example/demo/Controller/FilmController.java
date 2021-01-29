package com.example.demo.Controller;

import com.example.demo.Model.Categorie;
import com.example.demo.Model.Film;
import com.example.demo.Service.CategorieService;
import com.example.demo.Service.FilmService;
import com.example.demo.Service.RealisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FilmController {
    @Autowired
    private FilmService service;
    @Autowired
    private CategorieService categorieService;
    @Autowired
    private RealisateurService realisateurService;

    public FilmController(FilmService serv, CategorieService serv2, RealisateurService serv3){
        this.service = serv;
        this.categorieService = serv2;
        this.realisateurService = serv3;
    }

    @GetMapping(value = "/GetFilms")
    public List<Film> getAllFilms(){
        List<Film> films = this.service.getAllFilms();
        return films;
    }

    @GetMapping(value = "/GetFilmsByRealisateur/{NoRea}")
    public List<Film> getAllFilms(@PathVariable("NoRea") int id){
        List<Film> films = this.realisateurService.getOneById(id).get().getFilmList();
        return films;
    }

    @GetMapping(value = "/GetFilmsByCategorie/{CodeCat}")
    public List<Film> getAllFilmsByCategorie(@PathVariable("CodeCat") String id){
        List<Film> films = this.categorieService.getOneById(id).get().getFilmList();
        return films;
    }

    @GetMapping(value = "/GetFilm/{NoFilm}")
    public Optional<Film> getOneFilm(@PathVariable("NoFilm") int id){
        Optional<Film> film = this.service.getOneById(id);
        return film;
    }

    @PostMapping(value = "/AddFilm")
    public void addFilm(@RequestBody Film film){
        this.service.AddFilm(film);
    }

    @PutMapping(value = "/UpdateFilm/{NoFilm}")
    public ResponseEntity updateFilm(@RequestBody Film film, @RequestParam(value = "NoFilm") int id){
        this.service.updateById(film,id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/DeleteFilm")
    public ResponseEntity deleteTemperature(@RequestParam(value = "NoFilm") int noFilm){
        this.service.deleteById(noFilm);
        return ResponseEntity.noContent().build();
    }
}
