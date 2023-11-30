package com.example.commerciale.models;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Besoin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_besoin ;
    Date datebesoin ;
    double quantite ;
    int id_departement ;
    int id_article ;
    boolean havebesoin ;
    public Besoin(Date datebesoin, double quantite, int id_departement, int id_article) {
        this.datebesoin = datebesoin;
        this.quantite = quantite;
        this.id_departement = id_departement;
        this.id_article = id_article;
    }
    public Besoin(int id_besoin, Date datebesoin, double quantite, int id_departement, int id_article,
            boolean havebesoin) {
        this.id_besoin = id_besoin;
        this.datebesoin = datebesoin;
        this.quantite = quantite;
        this.id_departement = id_departement;
        this.id_article = id_article;
        this.havebesoin = havebesoin;
    }
    public Besoin() {
    }
    public int getId_besoin() {
        return id_besoin;
    }
    public void setId_besoin(int id_besoin) {
        this.id_besoin = id_besoin;
    }
    public Date getDatebesoin() {
        return datebesoin;
    }
    public void setDatebesoin(Date datebesoin) {
        this.datebesoin = datebesoin;
    }
    public double getQuantite() {
        return quantite;
    }
    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }
    public int getId_departement() {
        return id_departement;
    }
    public void setId_departement(int id_departement) {
        this.id_departement = id_departement;
    }
    public int getId_article() {
        return id_article;
    }
    public void setId_article(int id_article) {
        this.id_article = id_article;
    }
    public boolean isHavebesoin() {
        return havebesoin;
    }
    public void setHavebesoin(boolean havebesoin) {
        this.havebesoin = havebesoin;
    }
}
