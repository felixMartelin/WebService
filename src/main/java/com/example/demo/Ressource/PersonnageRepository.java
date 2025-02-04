package com.example.demo.Ressource;

import com.example.demo.Model.Acteur;
import com.example.demo.Model.Film;
import com.example.demo.Model.Personnage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonnageRepository extends JpaRepository<Personnage, Integer> {

    @Query("SELECT p FROM Personnage p WHERE p.noAct =?1 AND p.noFilm =?2")
    Optional<Personnage> findById(long id, long id2);

    @Transactional
    @Modifying
    @Query("DELETE FROM Personnage p WHERE p.noAct =?1 AND p.noFilm =?2")
    void DeleteById(long id, long id2);

    List<Personnage> findAllByNoAct(long noAct);

    @Transactional
    @Modifying
    Personnage findByNoActAndNoFilm(long noAct, long noFilm);

    @Transactional
    @Modifying
    void deleteByNoActAndNoFilm(long noAct, long noFilm);
}
