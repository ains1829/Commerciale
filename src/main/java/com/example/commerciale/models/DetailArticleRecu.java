package com.example.commerciale.models;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.commerciale.service.DetailArticleRecuService;
@Entity
@Table(name="detailarticlerecu_view")
public class DetailArticleRecu {
    @Id
    int idbandereception;
    int id_fournisseur;
    int id_article;
    int nomarticle;
    Date datereception;
    double quantiterecu;
    public DetailArticleRecu() {
    }
    public int getIdbandereception() {
        return idbandereception;
    }
    public void setIdbandereception(int idbandereception) {
        this.idbandereception = idbandereception;
    }
    public int getId_fournisseur() {
        return id_fournisseur;
    }
    public void setId_fournisseur(int id_fournisseur) {
        this.id_fournisseur = id_fournisseur;
    }
    public void setId_fournisseur(String id_fournisseur)throws Exception{
        try{ Integer.valueOf(id_fournisseur); }
        catch(Exception ex){ throw new Exception(" id_fournisseur :"+id_fournisseur+" invalide"); }
        setId_fournisseur(Integer.valueOf(id_fournisseur));
    }
    public int getId_article() {
        return id_article;
    }
    public void setId_article(int id_article) {
        this.id_article = id_article;
    }
    public int getNomarticle() {
        return nomarticle;
    }
    public void setNomarticle(int nomarticle) {
        this.nomarticle = nomarticle;
    }
    public Date getDatereception() {
        return datereception;
    }
    public void setDatereception(Date datereception) {
        this.datereception = datereception;
    }
    public void setDatereception(String datereception)throws Exception{
        try{ Date.valueOf(datereception); }
        catch(Exception ex){ throw new Exception(" date reception :"+datereception+" invalide"); }
        setDatereception(Date.valueOf(datereception));
    }
    public double getQuantiterecu() {
        return quantiterecu;
    }
    public void setQuantiterecu(double quantiterecu) {
        this.quantiterecu = quantiterecu;
    }
    public DetailArticleRecu[] getDetailArticleRecusOfDaterecepionOfId_fournisseur(DetailArticleRecuService detailArticleRecuService){
        return detailArticleRecuService.getByDatereceptionById_fournisseur(this.datereception, this.id_fournisseur);
    }
    

    
}
