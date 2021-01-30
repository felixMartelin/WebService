package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "realisateur", schema = "cinema")
public class Realisateur {
    private long NoRea;
    private String Nom;
    private String Prenom;
    private List<Film> filmList;

    @Basic
    @Column(name = "nomrea", nullable = false)
    public String getNom() {
        return this.Nom;
    }

    public void setNom(String nom) {
        this.Nom = nom;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "norea", nullable = false)
    public long getNoRea() {
        return this.NoRea;
    }

    public void setNoRea(long noRea) {
        this.NoRea = noRea;
    }

    @Basic
    @Column(name = "prenrea", nullable = false)
    public String getPrenom() {
        return this.Prenom;
    }

    public void setPrenom(String prenom) {
        this.Prenom = prenom;
    }

    @OneToMany
    @JoinColumn(name = "norea", referencedColumnName = "norea", insertable = false, updatable = false)
    @JsonIgnore
    public List<Film> getFilmList() {
        return this.filmList;
    }

    public void setFilmList(List<Film> f) {
        this.filmList = f;
    }
}
