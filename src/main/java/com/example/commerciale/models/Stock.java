package com.example.commerciale.models;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_stock ;
    double quantite ;
    Date datestock  ;
    int id_fournisseur ;
    int id_article ;
    public Stock(){}
    public Stock(int id_stock, double quantite, Date datestock, int id_fournisseur, int id_article) {
        this.id_stock = id_stock;
        this.quantite = quantite;
        this.datestock = datestock;
        this.id_fournisseur = id_fournisseur;
        this.id_article = id_article;
    }
    public int getId_stock() {
        return id_stock;
    }
    public void setId_stock(int id_stock) {
        this.id_stock = id_stock;
    }
    public double getQuantite() {
        return quantite;
    }
    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }
    public Date getDatestock() {
        return datestock;
    }
    public void setDatestock(Date datestock) {
        this.datestock = datestock;
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
}
