package com.example.demo.Model;

import javax.persistence.*;

@Entity
@Table(name = "realisateur", schema = "cinema")
public class Realisateur {
    private int NoRea;
    private String Nom;
    private String Prenom;

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
    public int getNoRea() {
        return this.NoRea;
    }

    public void setNoRea(int noRea) {
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
}
