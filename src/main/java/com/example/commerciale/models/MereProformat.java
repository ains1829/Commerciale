package com.example.commerciale.models;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "proformatmere")
public class MereProformat {
    @Id
    int id_proformatmere ;
    Date dateproformat ;
    String  nomproformat ;
    int id_fournisseur ;
    public int getId_proformatmere() {
        return id_proformatmere;
    }
    public void setId_proformatmere(int id_proformatmere) {
        this.id_proformatmere = id_proformatmere;
    }
    public Date getDateproformat() {
        return dateproformat;
    }
    public void setDateproformat(Date dateproformat) {
        this.dateproformat = dateproformat;
    }
    public String getNomproformat() {
        return nomproformat;
    }
    public void setNomproformat(String nomproformat) {
        this.nomproformat = nomproformat;
    }
    public int getId_fournisseur() {
        return id_fournisseur;
    }
    public void setId_fournisseur(int id_fournisseur) {
        this.id_fournisseur = id_fournisseur;
    }
    public MereProformat(int id_proformatmere, Date dateproformat, String nomproformat, int id_fournisseur) {
        this.id_proformatmere = id_proformatmere;
        this.dateproformat = dateproformat;
        this.nomproformat = nomproformat;
        this.id_fournisseur = id_fournisseur;
    }
    public MereProformat() {
    }
}
