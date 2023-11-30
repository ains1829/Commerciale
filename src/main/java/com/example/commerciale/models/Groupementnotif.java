package com.example.commerciale.models;
import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.commerciale.service.BandeDetail;
@Entity
@Table(name = "groupement_date_etat")
public class Groupementnotif {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idgroupement ;
    Date datebesoin ;
    int etat ;
    public Groupementnotif(Date datebesoin, int etat) {
        this.datebesoin = datebesoin;
        this.etat = etat;
    }
    public int getIdgroupement() {
        return idgroupement;
    }
    public void setIdgroupement(int idgroupement) {
        this.idgroupement = idgroupement;
    }
    public Date getDatebesoin() {
        return datebesoin;
    }
    public void setDatebesoin(Date datebesoin) {
        this.datebesoin = datebesoin;
    }
    public int getEtat() {
        return etat;
    }
    public void setEtat(int etat) {
        this.etat = etat;
    }
    public Groupementnotif(int idgroupement, Date datebesoin, int etat) {
        this.idgroupement = idgroupement;
        this.datebesoin = datebesoin;
        this.etat = etat;
    }
    public Groupementnotif() {}
    
}
