package com.example.demo.Model;

import javax.persistence.*;

@Entity
@Table(name = "personnage", schema = "cinema")
public class Personnage {
    private int NoFilm;
    private int NoAct;
    private String Nom;

    @Id
    @Column(name = "nofilm", nullable = false)
    public int getNoFilm() {
        return this.NoFilm;
    }

    public void setNoFilm(int noFilm) {
        this.NoFilm = noFilm;
    }

    @Basic
    @Column(name = "nompers", nullable = false)
    public String getNom() {
        return this.Nom;
    }

    public void setNom(String nom) {
        this.Nom = nom;
    }

    @Basic
    @Column(name = "noact", nullable = false)
    public int getNoAct() {
        return this.NoAct;
    }

    public void setNoAct(int noAct) {
        this.NoAct = noAct;
    }
}
