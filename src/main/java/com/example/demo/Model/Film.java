package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

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
    private List<Personnage> personnageList;
    private Realisateur realisateurByRealisateurId;
    private Categorie categorieByCategorieId;

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

    @OneToMany
    @JoinColumn(name = "nofilm", referencedColumnName = "nofilm", insertable = false, updatable = false)
    @JsonIgnore
    public List<Personnage> getPersonnageList() {
        return this.personnageList;
    }

    public void setPersonnageList(List<Personnage> p) {
        this.personnageList = p;
    }

    @ManyToOne
    @JoinColumn(name = "codecat", referencedColumnName = "codecat", insertable = false, updatable = false)
    @JsonIgnore
    public Categorie getCategorieByCategorieId() {
        return this.categorieByCategorieId;
    }

    public void setCategorieByCategorieId(Categorie cat) {
        this.categorieByCategorieId = cat;
    }

    @ManyToOne
    @JoinColumn(name = "norea", referencedColumnName = "norea", insertable = false, updatable = false)
    @JsonIgnore
    public Realisateur getRealisateurByRealisateurId() {
        return this.realisateurByRealisateurId;
    }

    public void setRealisateurByRealisateurId(Realisateur real) {
        this.realisateurByRealisateurId = real;
    }
}
