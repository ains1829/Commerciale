package com.example.commerciale.models;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Immutable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
@Entity 
@Table(name = "_notcoast")
public class Proformatmain {
    int id_proformatmere ;
    Date dateproformat ;
    String nomproformat  ;
    @Id
    int id_proformat ;
    double quantite ;
    double prixunitaire ;
    double tva ;
    int id_fournisseur ;
    int  id_article ;
    public int getId_proformatmere() {
        return id_proformatmere;
    }
    public void setId_proformatmere(int id_proformatmere) {
        this.id_proformatmere = id_proformatmere;
    }
    public Date getDateproformat() {
        return dateproformat;
    }
    public void setDateproformat(Date dateproformat) {
        this.dateproformat = dateproformat;
    }
    public String getNomproformat() {
        return nomproformat;
    }
    public void setNomproformat(String nomproformat) {
        this.nomproformat = nomproformat;
    }
    public int getId_proformat() {
        return id_proformat;
    }
    public void setId_proformat(int id_proformat) {
        this.id_proformat = id_proformat;
    }
    public double getQuantite() {
        return quantite;
    }
    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }
    public double getPrixunitaire() {
        return prixunitaire;
    }
    public void setPrixunitaire(double prixunitaire) {
        this.prixunitaire = prixunitaire;
    }
    public double getTva() {
        return tva;
    }
    public void setTva(double tva) {
        this.tva = tva;
    }
    public int getId_fournisseur() {
        return id_fournisseur;
    }
    public void setId_fournisseur(int id_fournisseur) {
        this.id_fournisseur = id_fournisseur;
    }
    public int getId_article() {
        return id_article;
    }
    public void setId_article(int id_article) {
        this.id_article = id_article;
    }
    public Proformatmain(int id_proformatmere, Date dateproformat, String nomproformat, int id_proformat,
            double quantite, double prixunitaire, double tva, int id_fournisseur, int id_article) {
        this.id_proformatmere = id_proformatmere;
        this.dateproformat = dateproformat;
        this.nomproformat = nomproformat;
        this.id_proformat = id_proformat;
        this.quantite = quantite;
        this.prixunitaire = prixunitaire;
        this.tva = tva;
        this.id_fournisseur = id_fournisseur;
        this.id_article = id_article;
    }
    public Proformatmain() {
    }
}
