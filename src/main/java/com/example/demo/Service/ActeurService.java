package com.example.demo.Service;

import com.example.demo.Model.Acteur;
import com.example.demo.Model.Film;
import com.example.demo.Ressource.ActeurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ActeurService {
    @Autowired
    private ActeurRepository repository;

    public ActeurService(ActeurRepository repo){
        this.repository = repo;
    }

    public List<Acteur> getAllActeurs() {return this.repository.findAll();}

    public Optional<Acteur> getOneById(int id){return this.repository.findById(id);}

    public void AddActeur(Acteur acteur){this.repository.save(acteur);}

    public void deleteById(int id){this.repository.deleteById(id);}

    public void updateById(Acteur acteur,int id){
        Optional<Acteur> ActeurUpdate = this.repository.findById(id);
        if(ActeurUpdate.isPresent())
        {
            Acteur ActeurUpdated = ActeurUpdate.get();
            if(acteur.getDateDeces() != ActeurUpdated.getDateDeces()){
                ActeurUpdated.setDateDeces(acteur.getDateDeces());
            }
            if(acteur.getDateNaissance() != ActeurUpdated.getDateNaissance()){
                ActeurUpdated.setDateNaissance(acteur.getDateNaissance());
            }
            if(!acteur.getNom().equals(ActeurUpdated.getNom())){
                ActeurUpdated.setNom(acteur.getNom());
            }
            if(!acteur.getPrenom().equals(ActeurUpdated.getPrenom())){
                ActeurUpdated.setPrenom(acteur.getPrenom());
            }
            this.repository.save(ActeurUpdated);
        }
        else {
            this.repository.save(acteur);
        }
    }
}
