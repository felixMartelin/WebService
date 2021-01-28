package com.example.demo.Controller;

import com.example.demo.Model.Film;
import com.example.demo.Service.CategorieService;
import com.example.demo.Service.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FilmController {
    @Autowired
    private FilmService service;

    public FilmController(FilmService serv){
        this.service = serv;
    }

    @GetMapping(value = "/GetFilms")
    public List<Film> getAllFilms(){
        List<Film> films = this.service.getAllFilms();
        return films;
    }

    @GetMapping(value = "/GetFilm/{NoFilm}")
    public Optional<Film> getAllFilms(@PathVariable("NoFilm") int id){
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
}
