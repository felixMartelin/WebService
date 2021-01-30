package com.example.demo.Ressource;

import com.example.demo.Model.Acteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActeurRepository extends JpaRepository<Acteur, Long> {
}
