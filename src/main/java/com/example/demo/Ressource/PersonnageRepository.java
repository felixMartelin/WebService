package com.example.demo.Ressource;

import com.example.demo.Model.Personnage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonnageRepository extends JpaRepository<Personnage, Integer> {
}
