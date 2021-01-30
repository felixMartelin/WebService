package com.example.demo.Service;

import com.example.demo.Model.Film;
import com.example.demo.Model.Realisateur;
import com.example.demo.Ressource.CategorieRepository;
import com.example.demo.Ressource.RealisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RealisateurService {
    @Autowired
    private RealisateurRepository repository;

    public RealisateurService(RealisateurRepository repo){
        this.repository = repo;
    }

    public List<Realisateur> getAllRealisateurs() {return this.repository.findAll();}

    public Optional<Realisateur> getOneById(long id){return this.repository.findById(id);}

    public void AddRealisateur(Realisateur realisateur){this.repository.save(realisateur);}

    public void deleteById(long id){this.repository.deleteById(id);}

    public void updateById(Realisateur realisateur,long id){
        Optional<Realisateur> RealisateurUpdate = this.repository.findById(id);
        if(RealisateurUpdate.isPresent())
        {
            Realisateur realisateurUpdated = RealisateurUpdate.get();
            if(!realisateur.getNom().equals(realisateurUpdated.getNom())){
                realisateurUpdated.setNom(realisateur.getNom());
            }
            if(!realisateur.getPrenom().equals(realisateurUpdated.getPrenom())){
                realisateurUpdated.setPrenom(realisateurUpdated.getPrenom());
            }
            this.repository.save(realisateurUpdated);
        }
        else {
            this.repository.save(realisateur);
        }
    }
}
