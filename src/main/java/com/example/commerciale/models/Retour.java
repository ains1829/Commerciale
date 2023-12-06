package com.example.commerciale.models;

public class Retour {
    int etat ;
    String about ;
    public int getEtat() {
        return etat;
    }
    public void setEtat(int etat) {
        this.etat = etat;
    }
    public String getAbout() {
        return about;
    }
    public void setAbout(String about) {
        this.about = about;
    }
    public Retour(int etat, String about) {
        this.etat = etat;
        this.about = about;
    }
}
