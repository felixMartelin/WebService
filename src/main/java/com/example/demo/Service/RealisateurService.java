package com.example.demo.Service;

import com.example.demo.Ressource.CategorieRepository;
import com.example.demo.Ressource.RealisateurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RealisateurService {
    @Autowired
    private RealisateurRepository repository;

    public RealisateurService(RealisateurRepository repo){
        this.repository = repo;
    }
}
