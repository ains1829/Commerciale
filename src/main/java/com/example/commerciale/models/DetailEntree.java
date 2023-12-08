package com.example.commerciale.models;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
// idbonentre | id_article | idmagasin | quantiteentre | totalsortie | dateentre | ladate | prixht | tva | prixttc
@Entity
@Table(name="etatquantiteentre_f")
public class DetailEntree {
    @Id
    int idbonentre;
    int id_article;
    int idmagasin;
    float quantiteentre;
    float totalsortie;
    Date dateentre;
    Date ladate;
    float prixht;
    float tva;
    float prixttc;

    public DetailEntree() {
    }

    public int getIdbonentre() {
        return idbonentre;
    }

    public void setIdbonentre(int idbonentre) {
        this.idbonentre = idbonentre;
    }

    public int getId_article() {
        return id_article;
    }

    public void setId_article(int id_article) {
        this.id_article = id_article;
    }

    public int getIdmagasin() {
        return idmagasin;
    }

    public void setIdmagasin(int idmagasin) {
        this.idmagasin = idmagasin;
    }

    public float getQuantiteentre() {
        return quantiteentre;
    }

    public void setQuantiteentre(float quantiteentre) {
        this.quantiteentre = quantiteentre;
    }

    public float getTotalsortie() {
        return totalsortie;
    }

    public void setTotalsortie(float totalsortie) {
        this.totalsortie = totalsortie;
    }

    public Date getDateentre() {
        return dateentre;
    }

    public void setDateentre(Date dateentre) {
        this.dateentre = dateentre;
    }

    public Date getLadate() {
        return ladate;
    }

    public void setLadate(Date ladate) {
        this.ladate = ladate;
    }

    public float getPrixht() {
        return prixht;
    }

    public void setPrixht(float prixht) {
        this.prixht = prixht;
    }

    public float getTva() {
        return tva;
    }

    public void setTva(float tva) {
        this.tva = tva;
    }

    public float getPrixttc() {
        return prixttc;
    }

    public void setPrixttc(float prixttc) {
        this.prixttc = prixttc;
    }
    public float getQuantiteReste(){
        return (this.quantiteentre-this.totalsortie);
    }
  
    

    
    
}
