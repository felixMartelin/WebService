package com.example.demo.Service;

import com.example.demo.Ressource.ActeurRepository;
import com.example.demo.Ressource.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategorieService {
    @Autowired
    private CategorieRepository repository;

    public CategorieService(CategorieRepository repo){
        this.repository = repo;
    }
}
