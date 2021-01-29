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


}
