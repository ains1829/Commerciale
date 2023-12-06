package com.example.commerciale.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id_article ;
    String   nom   ;
    String unite ;
    int id_categorie ;
    String modegestion;
    public Article(int id_article, String nom, String unite, int id_categorie) {
        this.id_article = id_article;
        this.nom = nom;
        this.unite = unite;
        this.id_categorie = id_categorie;
    }
    public Article() {
    }
    public int getId_article() {
        return id_article;
    }
    public void setId_article(int id_article) {
        this.id_article = id_article;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getUnite() {
        return unite;
    }
    public void setUnite(String unite) {
        this.unite = unite;
    }
    public int getId_categorie() {
        return id_categorie;
    }
    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
    }
    public String getModegestion() {
        return modegestion;
    }
    public void setModegestion(String modegestion) {
        this.modegestion = modegestion;
    }
    
}
