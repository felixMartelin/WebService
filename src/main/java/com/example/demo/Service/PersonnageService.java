package com.example.demo.Service;

import com.example.demo.Model.Acteur;
import com.example.demo.Model.Film;
import com.example.demo.Model.Personnage;
import com.example.demo.Ressource.CategorieRepository;
import com.example.demo.Ressource.PersonnageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonnageService {
    @Autowired
    private PersonnageRepository repository;

    public PersonnageService(PersonnageRepository repo){
        this.repository = repo;
    }

    public List<Personnage> getAllPersonnages() {return this.repository.findAll();}

    public Optional<Personnage> getOneById(long id,long id2){return this.repository.findById(id,id2);}

    public Personnage getById(long act, long film) { return repository.findByNoActAndNoFilm(act, film); }

    public Personnage addNewPersonnage(Personnage p) { return repository.save(p); }

    public void AddPersonnage(Personnage personnage){this.repository.save(personnage);}

    public void delete(long act, long film) { repository.deleteByNoActAndNoFilm(act, film); }

    public void deleteById(long id, long id2){this.repository.DeleteById(id,id2);}

    public List<Personnage> getAllByNoAct(long noAct){return this.repository.findAllByNoAct(noAct);}

    public void updateById(Personnage personnage,long id, long id2){
        Optional<Personnage> personnageUpdate = this.repository.findById(id,id2);
        if(personnageUpdate.isPresent())
        {
            Personnage personnageUpdated = personnageUpdate.get();
            if(!personnage.getNom().equals(personnageUpdated.getNom())){
                personnageUpdated.setNom(personnage.getNom());
            }
            this.repository.save(personnageUpdated);
        }
        else {
            this.repository.save(personnage);
        }
    }
}
