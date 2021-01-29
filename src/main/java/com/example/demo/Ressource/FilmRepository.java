package com.example.demo.Ressource;

import com.example.demo.Model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FilmRepository extends JpaRepository<Film, Integer> {
    @Query("SELECT f FROM Film f WHERE f.NoRea =?1")
    List<Film> findAllWithRealisateur(int id);

    @Query("SELECT f FROM Film f WHERE f.CodeCat =?1")
    List<Film> findAllWithCategorie(String id);
}
