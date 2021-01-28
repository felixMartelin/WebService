package com.example.demo.Service;

import com.example.demo.Ressource.CategorieRepository;
import com.example.demo.Ressource.PersonnageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonnageService {
    @Autowired
    private PersonnageRepository repository;

    public PersonnageService(PersonnageRepository repo){
        this.repository = repo;
    }
}
