package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "categorie", schema = "cinema")
public class Categorie {

    private String Code;
    private String Libelle;
    private List<Film> filmList;

    @Id
    @Column(name = "codecat", nullable = false)
    public String getCode() {
        return this.Code;
    }

    public void setCode(String code) {
        this.Code = code;
    }

    @Basic
    @Column(name = "libellecat", nullable = false)
    public String getLibelle() {
        return this.Libelle;
    }

    public void setLibelle(String libelle) {
        this.Libelle = libelle;
    }

    @OneToMany
    @JoinColumn(name = "codecat", referencedColumnName = "codecat", insertable = false, updatable = false)
    public List<Film> getFilmList() {
        return this.filmList;
    }

    public void setFilmList(List<Film> f) {
        this.filmList = f;
    }
}
