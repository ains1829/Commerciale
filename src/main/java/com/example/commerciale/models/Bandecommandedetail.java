package com.example.commerciale.models;
import java.sql.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="bandecommandedetail")
public class Bandecommandedetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_bande_commande")
    int id_bande_commande ;
    double quantite ;
    int id_article ;
    int id_fournisseur ;
    double prixht ;
    double tva ; 
    Date dateproformat ;
    @Column(name  = " datebandecommade")
    Date dateBandecommade ;
    public Bandecommandedetail(double quantite, int id_article, int id_fournisseur, double prixht, double tva,
            Date dateproformat, Date dateBandecommade) {
        this.quantite = quantite;
        this.id_article = id_article;
        this.id_fournisseur = id_fournisseur;
        this.prixht = prixht;
        this.tva = tva;
        this.dateproformat = dateproformat;
        this.dateBandecommade = dateBandecommade;
    }
    public int getId_bande_commande() {
        return id_bande_commande;
    }
    public void setId_bande_commande(int id_bande_commande) {
        this.id_bande_commande = id_bande_commande;
    }
    public double getQuantite() {
        return quantite;
    }
    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }
    public int getId_article() {
        return id_article;
    }
    public void setId_article(int id_article) {
        this.id_article = id_article;
    }
    public int getId_fournisseur() {
        return id_fournisseur;
    }
    public void setId_fournisseur(int id_fournisseur) {
        this.id_fournisseur = id_fournisseur;
    }
    public double getPrixht() {
        return prixht;
    }
    public void setPrixht(double prixht) {
        this.prixht = prixht;
    }
    public double getTva() {
        return tva;
    }
    public void setTva(double tva) {
        this.tva = tva;
    }
    public Date getDateproformat() {
        return dateproformat;
    }
    public void setDateproformat(Date dateproformat) {
        this.dateproformat = dateproformat;
    }
    public Date getDateBandecommade() {
        return dateBandecommade;
    }
    public void setDateBandecommade(Date dateBandecommade) {
        this.dateBandecommade = dateBandecommade;
    }
    public Bandecommandedetail(int id_bande_commande, double quantite, int id_article, int id_fournisseur,
            double prixht, double tva, Date dateproformat, Date dateBandecommade) {
        this.id_bande_commande = id_bande_commande;
        this.quantite = quantite;
        this.id_article = id_article;
        this.id_fournisseur = id_fournisseur;
        this.prixht = prixht;
        this.tva = tva;
        this.dateproformat = dateproformat;
        this.dateBandecommade = dateBandecommade;
    }
    public Bandecommandedetail() {
    } 
}
