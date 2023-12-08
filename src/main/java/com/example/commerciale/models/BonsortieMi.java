package com.example.commerciale.models;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="bonsortie")
public class BonsortieMi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idbonsorti;
    int idbonentre;
    float quantitesortie;
    Date datesortie;
    
    public BonsortieMi() {
    }
    public int getIdbonsorti() {
        return idbonsorti;
    }
    public void setIdbonsorti(int idbonsorti) {
        this.idbonsorti = idbonsorti;
    }
    public int getIdbonentre() {
        return idbonentre;
    }
    public void setIdbonentre(int idbonentre) {
        this.idbonentre = idbonentre;
    }
    public float getQuantitesortie() {
        return quantitesortie;
    }
    public void setQuantitesortie(float quantitesortie) {
        this.quantitesortie = quantitesortie;
    }
    public Date getDatesortie() {
        return datesortie;
    }
    public void setDatesortie(Date datesortie) {
        this.datesortie = datesortie;
    }
    
}
