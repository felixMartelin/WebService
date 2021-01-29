package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;

class PersonnageId implements Serializable {
    @NotNull
    public Integer NoFilm;

    @NotNull
    public Integer NoAct;

    public Integer getNoFilm() {
        return this.NoFilm;
    }

    public void setNoFilm(Integer NoF) {
        this.NoFilm = NoF;
    }

    public Integer getNoAct() {
        return this.NoAct;
    }

    public void setNoAct(Integer NoA) {
        this.NoAct = NoA;
    }
}


@Entity
@IdClass(PersonnageId.class)
@Table(name = "personnage", schema = "cinema")
public class Personnage {
    private Integer NoFilm;
    private Integer NoAct;
    private String Nom;
    private Acteur acteurByActeurId;
    private Film filmByFilmId;

    @Id
    @Column(name = "nofilm", nullable = false)
    public int getNoFilm() {
        return this.NoFilm;
    }

    public void setNoFilm(Integer noFilm) {
        this.NoFilm = noFilm;
    }

    @Id
    @Column(name = "noact", nullable = false)
    public int getNoAct() {
        return this.NoAct;
    }

    public void setNoAct(Integer noAct) {
        this.NoAct = noAct;
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
