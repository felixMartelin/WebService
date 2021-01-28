package com.example.demo.Service;

import com.example.demo.Model.Acteur;
import com.example.demo.Model.Categorie;
import com.example.demo.Ressource.ActeurRepository;
import com.example.demo.Ressource.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategorieService {
    @Autowired
    private CategorieRepository repository;

    public CategorieService(CategorieRepository repo){
        this.repository = repo;
    }

    public List<Categorie> getAllCategories() {return this.repository.findAll();}

    public Optional<Categorie> getOneById(int id){return this.repository.findById(id);}

    public void AddCategorie(Categorie categorie){this.repository.save(categorie);}

    public void deleteById(int id){this.repository.deleteById(id);}
}
