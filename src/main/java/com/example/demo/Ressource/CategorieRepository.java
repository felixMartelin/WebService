package com.example.demo.Ressource;

import com.example.demo.Model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategorieRepository extends JpaRepository<Categorie, String> {

    @Query("SELECT c FROM Categorie c WHERE c.code =?1")
    Optional<Categorie> findById(String id);
}
