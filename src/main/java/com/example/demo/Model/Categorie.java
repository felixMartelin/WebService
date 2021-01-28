package com.example.demo.Model;

import javax.persistence.*;

@Entity
@Table(name = "categorie", schema = "cinema")
public class Categorie {

    private String Code;
    private String Libelle;

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
}
