package com.example.commerciale.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Fournisseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_fournisseur ;
    String  nom   ;
    String manager  ;
    String  email   ;   
    String adresse ;
    public Fournisseur(int id_fournisseur, String nom, String manager, String email, String adresse) {
        this.id_fournisseur = id_fournisseur;
        this.nom = nom;
        this.manager = manager;
        this.email = email;
        this.adresse = adresse;
    }
    public Fournisseur() {
    }
    public int getId_fournisseur() {
        return id_fournisseur;
    }
    public void setId_fournisseur(int id_fournisseur) {
        this.id_fournisseur = id_fournisseur;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getManager() {
        return manager;
    }
    public void setManager(String manager) {
        this.manager = manager;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
}
