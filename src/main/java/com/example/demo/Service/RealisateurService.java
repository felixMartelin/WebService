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

    public Optional<Realisateur> getOneById(int id){return this.repository.findById(id);}

    public void AddRealisateur(Realisateur realisateur){this.repository.save(realisateur);}

    public void deleteById(int id){this.repository.deleteById(id);}

    public void updateById(Realisateur realisateur,int id){
        Optional<Realisateur> RealisateurUpdate = this.repository.findById(id);
        if(RealisateurUpdate.isPresent())
        {
            Realisateur realisateurUpdated = RealisateurUpdate.get();
            if(realisateur.getNom() != realisateurUpdated.getNom()){
                realisateurUpdated.setNom(realisateur.getNom());
            }
            if(realisateur.getPrenom() != realisateurUpdated.getPrenom()){
                realisateurUpdated.setPrenom(realisateurUpdated.getPrenom());
            }
            this.repository.save(realisateurUpdated);
        }
        else {
            this.repository.save(realisateur);
        }
    }
}
