package com.example.demo.Model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "acteur", schema = "cinema")
public class Acteur {
    private int NoAct;
    private String Nom;
    private String Prenom;
    private Date dateNaissance;
    private Date dateDeces;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "noact", nullable = false)
    public int getNoAct() {
        return this.NoAct;
    }

    public void setNoAct(int noAct) {
        NoAct = noAct;
    }

    @Basic
    @Column(name = "datedeces")
    public Date getDateDeces() {
        return this.dateDeces;
    }

    public void setDateDeces(Date dateDeces) {
        this.dateDeces = dateDeces;
    }

    @Basic
    @Column(name = "datenaiss", nullable = false)
    public Date getDateNaissance() {
        return this.dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    @Basic
    @Column(name = "nomact ", nullable = false)
    public String getNom() {
        return this.Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    @Basic
    @Column(name = "prenact", nullable = false)
    public String getPrenom() {
        return this.Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }
}
