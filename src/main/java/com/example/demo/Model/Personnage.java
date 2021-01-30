package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

class PersonnageId implements Serializable {
    public Integer NoFilm;

    public Integer NoAct;

    @Id
    @Column(name = "nofilm", nullable = false)
    public Integer getNoFilm() {
        return NoFilm;
    }

    public void setNoFilm(Integer NoF) {
        NoFilm = NoF;
    }

    @Id
    @Column(name = "noact", nullable = false)
    public Integer getNoAct() {
        return NoAct;
    }

    public void setNoAct(Integer NoA) {
        NoAct = NoA;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonnageId that = (PersonnageId) o;
        return Objects.equals(NoFilm, that.NoFilm) &&
                Objects.equals(NoAct, that.NoAct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(NoFilm, NoAct);
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
        return NoFilm;
    }

    public void setNoFilm(Integer noFilm) {
        NoFilm = noFilm;
    }

    @Id
    @Column(name = "noact", nullable = false)
    public int getNoAct() {
        return NoAct;
    }

    public void setNoAct(Integer noAct) {
        NoAct = noAct;
    }

    @Basic
    @Column(name = "nompers", nullable = false)
    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
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
