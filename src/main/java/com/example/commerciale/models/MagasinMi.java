package com.example.commerciale.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.commerciale.service.MagasinMiService;
@Entity
@Table(name="magasin")
public class MagasinMi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idmagasin;
    String nommagasin ;
    String adresse ;
    public MagasinMi() {
    }
    public int getIdmagasin() {
        return idmagasin;
    }
    public void setIdmagasin(int idmagasin) {
        this.idmagasin = idmagasin;
    }
    public void setIdmagasin(String idmagasin)throws Exception{
        try{ Integer.valueOf(idmagasin); }
        catch(Exception ex){ throw new Exception("idmagasin :"+idmagasin+" invalide"); }
        setIdmagasin(Integer.valueOf(idmagasin));
    }
    public String getNommagasin() {
        return nommagasin;
    }
    public void setNommagasin(String nommagasin) {
        this.nommagasin = nommagasin;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public MagasinMi getByTheId(MagasinMiService magasinMiService){
        return magasinMiService.getById(this.idmagasin).get();
    }
    
}
