package com.example.demo.Ressource;

import com.example.demo.Model.Personnage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonnageRepository extends JpaRepository<Personnage, Integer> {

    @Query("SELECT p FROM Personnage p WHERE p.noAct =?1 AND p.noFilm =?2")
    Optional<Personnage> findById(int id, int id2);

    @Query("DELETE FROM Personnage p WHERE p.noAct =?1 AND p.noFilm =?2")
    void DeleteById(int id, int id2);

    @Query("SELECT p FROM Personnage p WHERE p.noAct =?1")
    List<Personnage> findAllByNoAct(int id);
}
