package com.example.commerciale.models;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
@Entity 
@Table(name = "proformat_view")
public class Proformatmain {
    @Id
    int id_proformatmere ;
    Date dateproformat ;
    String   nomproformatmere    ;
    int id_proformat ;
    double quantite ;
    double prixunitaire ;
    double tva ;
    int id_fournisseur ;
    int id_article ;
    public Proformatmain() {
    }
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
    public String getNomproformatmere() {
        return nomproformatmere;
    }
    public void setNomproformatmere(String nomproformatmere) {
        this.nomproformatmere = nomproformatmere;
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
    public Proformatmain(int id_proformatmere, Date dateproformat, String nomproformatmere, int id_proformat,
            double quantite, double prixunitaire, double tva, int id_fournisseur, int id_article) {
        this.id_proformatmere = id_proformatmere;
        this.dateproformat = dateproformat;
        this.nomproformatmere = nomproformatmere;
        this.id_proformat = id_proformat;
        this.quantite = quantite;
        this.prixunitaire = prixunitaire;
        this.tva = tva;
        this.id_fournisseur = id_fournisseur;
        this.id_article = id_article;
    }
}
