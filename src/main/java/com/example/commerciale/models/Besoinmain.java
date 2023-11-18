package com.example.commerciale.models;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity 
@Table(name = "simple_groupement")
public class Besoinmain {
    @Id
    int id_article ;
    Date datebesoin ;
    double quantite ;
    boolean havebesoin;
    public boolean isHavabesoin() {
        return havebesoin;
    }
    public void setHavabesoin(boolean havabesoin) {
        this.havebesoin = havabesoin;
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
    public int getId_article() {
        return id_article;
    }
    public void setId_article(int id_article) {
        this.id_article = id_article;
    }
    public Besoinmain(Date datebesoin, double quantite, int id_article , boolean havabesoins){
        this.datebesoin = datebesoin;
        this.quantite = quantite;
        this.id_article = id_article;
        this.havebesoin = havabesoins;
    }
    public Besoinmain() {
    }
}
