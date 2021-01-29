package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "personnage", schema = "cinema")
public class Personnage {
    @EmbeddedId
    private PersonnageId personnageId;
    private String Nom;
    private Acteur acteurByActeurId;
    private Film filmByFilmId;

    public PersonnageId getPersonnageId(){return this.personnageId;}

    public void setPersonnageId(PersonnageId p){
        this.personnageId = p;
    }

    @Basic
    @Column(name = "nompers", nullable = false)
    public String getNom() {
        return this.Nom;
    }

    public void setNom(String nom) {
        this.Nom = nom;
    }

    @ManyToOne
    @JoinColumn(name = "noact", referencedColumnName = "noact", insertable = false, updatable = false)
    @JsonIgnore
    public Acteur getActeurByActeurId() {
        return acteurByActeurId;
    }

    public void setActeurByActeurId(Acteur acteur) {
        this.acteurByActeurId = acteur;
    }

    @ManyToOne
    @JoinColumn(name = "nofilm", referencedColumnName = "nofilm", insertable = false, updatable = false)
    @JsonIgnore
    public Film getFilmByFilmId() {
        return filmByFilmId;
    }

    public void setFilmByFilmId(Film film) {
        this.filmByFilmId = film;
    }
}
