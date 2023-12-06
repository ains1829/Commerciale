package com.example.commerciale.models;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Livraison {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idlivraison ;
    String name_livreur ;
    int id_article ;
    double quantite ;
    Date datelivraison ;
    Date datebandecommande ;
    int id_fournisseur ;
    public Livraison(String name_livreur, int id_article, double quantite, Date datelivraison, Date datebandecommande,
            int id_fournisseur) {
        this.name_livreur = name_livreur;
        this.id_article = id_article;
        this.quantite = quantite;
        this.datelivraison = datelivraison;
        this.datebandecommande = datebandecommande;
        this.id_fournisseur = id_fournisseur;
    }
    public Livraison(int idlivraison, String name_livreur, int id_article, double quantite, Date datelivraison,
            Date datebandecommande, int id_fournisseur) {
        this.idlivraison = idlivraison;
        this.name_livreur = name_livreur;
        this.id_article = id_article;
        this.quantite = quantite;
        this.datelivraison = datelivraison;
        this.datebandecommande = datebandecommande;
        this.id_fournisseur = id_fournisseur;
    }
    public int getIdlivraison() {
        return idlivraison;
    }
    public void setIdlivraison(int idlivraison) {
        this.idlivraison = idlivraison;
    }
    public String getName_livreur() {
        return name_livreur;
    }
    public void setName_livreur(String name_livreur) {
        this.name_livreur = name_livreur;
    }
    public int getId_article() {
        return id_article;
    }
    public void setId_article(int id_article) {
        this.id_article = id_article;
    }
    public double getQuantite() {
        return quantite;
    }
    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }
    public Date getDatelivraison() {
        return datelivraison;
    }
    public void setDatelivraison(Date datelivraison) {
        this.datelivraison = datelivraison;
    }
    public Date getDatebandecommande() {
        return datebandecommande;
    }
    public void setDatebandecommande(Date datebandecommande) {
        this.datebandecommande = datebandecommande;
    }
    public int getId_fournisseur() {
        return id_fournisseur;
    }
    public void setId_fournisseur(int id_fournisseur) {
        this.id_fournisseur = id_fournisseur;
    }
    public Livraison(){}
}
