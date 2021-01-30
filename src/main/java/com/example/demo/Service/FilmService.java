package com.example.demo.Service;

import com.example.demo.Model.Film;
import com.example.demo.Ressource.CategorieRepository;
import com.example.demo.Ressource.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FilmService {
    @Autowired
    private FilmRepository repository;

    public FilmService(FilmRepository repo){
        this.repository = repo;
    }

    public List<Film> getAllFilms() {return this.repository.findAll();}

    public Optional<Film> getOneById(long id){return this.repository.findById(id);}

    public void AddFilm(Film film){this.repository.save(film);}

    public void deleteById(long id){this.repository.deleteById(id);}

    public void updateById(Film film,long id){
        Optional<Film> filmUpdate = this.repository.findById(id);
        if(filmUpdate.isPresent())
        {
            Film filmUpdated = filmUpdate.get();
            if(film.getBudget() != filmUpdated.getBudget()){
                filmUpdated.setBudget(film.getBudget());
            }
            if(!film.getCodeCat().equals(filmUpdated.getCodeCat())){
                filmUpdated.setCodeCat(film.getCodeCat());
            }
            if(film.getDuree() != filmUpdated.getDuree()){
                filmUpdated.setDuree(film.getDuree());
            }
            if(film.getDateSortie() != filmUpdated.getDateSortie()){
                filmUpdated.setDateSortie(film.getDateSortie());
            }
            if(film.getRecette() != filmUpdated.getRecette()){
                filmUpdated.setRecette(film.getRecette());
            }
            if(!film.getTitre().equals(filmUpdated.getTitre())){
                filmUpdated.setTitre(film.getTitre());
            }
            this.repository.save(filmUpdated);
        }
        else {
            this.repository.save(film);
        }
    }

}
