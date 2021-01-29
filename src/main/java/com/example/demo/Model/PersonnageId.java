package com.example.demo.Model;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class PersonnageId implements Serializable {
    private int NoFilm;
    private int NoAct;

    public PersonnageId(int NoF,int NoA){
        this.NoAct = NoA;
        this.NoFilm = NoF;
    }

    public PersonnageId() {

    }

    public int getNoAct() {
        return this.NoAct;
    }

    public void setNoAct(int noAct) {
        this.NoAct = noAct;
    }

    public int getNoFilm() {
        return this.NoFilm;
    }

    public void setNoFilm(int noFilm) {
        this.NoFilm = noFilm;
    }
}
