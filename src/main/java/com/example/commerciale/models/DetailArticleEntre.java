package com.example.commerciale.models;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//  id_article | nomarticle | idmagasin | nommagasin | entrees | sorties | ladate
@Entity
@Table(name="etatquantitearticle_f")
public class DetailArticleEntre {
    @Id
    int id_article;
    String nomarticle;
    int idmagasin;
    String nommagasin;
    float entrees;
    float sorties;
    Date ladate;

    public DetailArticleEntre() {
    }

    public int getId_article() {
        return id_article;
    }

    public void setId_article(int id_article) {
        this.id_article = id_article;
    }

    public String getNomarticle() {
        return nomarticle;
    }

    public void setNomarticle(String nomarticle) {
        this.nomarticle = nomarticle;
    }

    public int getIdmagasin() {
        return idmagasin;
    }

    public void setIdmagasin(int idmagasin) {
        this.idmagasin = idmagasin;
    }

    public String getNommagasin() {
        return nommagasin;
    }

    public void setNommagasin(String nommagasin) {
        this.nommagasin = nommagasin;
    }

    public float getEntrees() {
        return entrees;
    }

    public void setEntrees(float entrees) {
        this.entrees = entrees;
    }

    public float getSorties() {
        return sorties;
    }

    public void setSorties(float sorties) {
        this.sorties = sorties;
    }

    public Date getLadate() {
        return ladate;
    }

    public void setLadate(Date ladate) {
        this.ladate = ladate;
    }
    public float getQuantiteReste(){
        return (this.entrees-this.sorties);
    }

}
