package com.example.commerciale.models;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "member")
public class Membre {
    @Id
    int id_membre ;
    String  nom   ;
    String  email   ;
    Date dtn  ;
    String  mdp   ;
    String  profil  ;
    String departement ;
    public Membre() {
    }
    public Membre(int id_membre, String nom, String email, Date dtn, String mdp, String profil, String departement) {
        this.id_membre = id_membre;
        this.nom = nom;
        this.email = email;
        this.dtn = dtn;
        this.mdp = mdp;
        this.profil = profil;
        this.departement = departement;
    }
    public int getId_membre() {
        return id_membre;
    }
    public void setId_membre(int id_membre) {
        this.id_membre = id_membre;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Date getDtn() {
        return dtn;
    }
    public void setDtn(Date dtn) {
        this.dtn = dtn;
    }
    public String getMdp() {
        return mdp;
    }
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    public String getProfil() {
        return profil;
    }
    public void setProfil(String profil) {
        this.profil = profil;
    }
    public String getDepartement() {
        return departement;
    }
    public void setDepartement(String departement) {
        this.departement = departement;
    }
}
