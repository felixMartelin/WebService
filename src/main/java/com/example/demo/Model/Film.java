package com.example.demo.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "film", schema = "cinema")
public class Film {
    private int NoFilm;
    private String Titre;
    private int Duree;
    private Date DateSortie;
    private int Budget;
    private int Recette;
    private int NoRea;
    private String CodeCat;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "nofilm", nullable = false)
    public int getNoFilm() {
        return this.NoFilm;
    }

    public void setNoFilm(int noFilm) {
        this.NoFilm = noFilm;
    }

    @Basic
    @Column(name = "datesortie", nullable = false)
    public Date getDateSortie() {
        return this.DateSortie;
    }

    public void setDateSortie(Date dateSortie) {
        this.DateSortie = dateSortie;
    }

    @Basic
    @Column(name = "budget", nullable = false)
    public int getBudget() {
        return this.Budget;
    }

    public void setBudget(int budget) {
        this.Budget = budget;
    }

    @Basic
    @Column(name = "duree", nullable = false)
    public int getDuree() {
        return this.Duree;
    }

    public void setDuree(int duree) {
        this.Duree = duree;
    }

    @Basic
    @Column(name = "norea", nullable = false)
    public int getNoRea() {
        return this.NoRea;
    }

    public void setNoRea(int noRea) {
        this.NoRea = noRea;
    }

    @Basic
    @Column(name = "montantrecette")
    public int getRecette() {
        return this.Recette;
    }

    public void setRecette(int recette) {
        this.Recette = recette;
    }

    @Basic
    @Column(name = "codecat", nullable = false)
    public String getCodeCat() {
        return this.CodeCat;
    }

    public void setCodeCat(String codeCat) {
        this.CodeCat = codeCat;
    }

    @Basic
    @Column(name = "titre", nullable = false)
    public String getTitre() {
        return this.Titre;
    }

    public void setTitre(String titre) {
        this.Titre = titre;
    }
}
