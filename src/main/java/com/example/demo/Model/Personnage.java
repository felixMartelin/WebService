package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;

class PersonnageId implements Serializable {
    public long NoFilm;

    public long NoAct;

    @Id
    @Column(name = "nofilm", nullable = false)
    public long getNoFilm() {
        return NoFilm;
    }

    public void setNoFilm(long NoF) {
        NoFilm = NoF;
    }

    @Id
    @Column(name = "noact", nullable = false)
    public long getNoAct() {
        return NoAct;
    }

    public void setNoAct(long NoA) {
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
    private long NoFilm;
    private long NoAct;
    private String Nom;

    private Acteur acteurByActeurId;
    private Film filmByFilmId;


    @Id
    @Column(name = "nofilm", nullable = false)
    public long getNoFilm() {
        return NoFilm;
    }

    public void setNoFilm(long noFilm) {
        NoFilm = noFilm;
    }

    @Id
    @Column(name = "noact", nullable = false)
    public long getNoAct() {
        return NoAct;
    }

    public void setNoAct(long noAct) {
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
    public Acteur getActeurByActeurId() {
        return acteurByActeurId;
    }

    public void setActeurByActeurId(Acteur acteur) {
        this.acteurByActeurId = acteur;
        acteurByActeurId.setPersonnageList(new ArrayList<>());
    }



    @ManyToOne
    @JoinColumn(name = "nofilm", referencedColumnName = "nofilm", insertable = false, updatable = false)
    public Film getFilmByFilmId() {
        return filmByFilmId;
    }

    public void setFilmByFilmId(Film film) {
        this.filmByFilmId = film;
    }

}
