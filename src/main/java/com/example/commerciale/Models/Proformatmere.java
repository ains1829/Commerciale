package com.example.commerciale.Models;
import com.example.commerciale.service.*;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Proformatmere  {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	int Id_proformatmere ;
	Date dateproformat;
	String nomproformat ;
	int Id_fournisseur;
	public Proformatmere() {
	}
	public int getId_proformatmere() {
		return Id_proformatmere;
	}
	public void setId_proformatmere(int id_proformatmere) {
		Id_proformatmere = id_proformatmere;
	}
	public void setId_proformatmere(String id_proformatmere)throws Exception{
		try{	Integer.valueOf(id_proformatmere); }
		catch(Exception e){ throw new Exception("id_proformatmere:"+id_proformatmere+" invalide"); }
		setId_proformatmere(Integer.valueOf(id_proformatmere));
	}
	public Date getDateproformat() {
		return dateproformat;
	}
	public void setDateproformat(Date dateproformat) {
		this.dateproformat = dateproformat;
	}
	public void setDateproformat(String dateproformat)throws Exception{
		try{	Date.valueOf(dateproformat); }
		catch(Exception e){ throw new Exception("dateproformat:"+dateproformat+" invalide"); }
		setDateproformat(Date.valueOf(dateproformat));
	}

	public String getNomproformat() {
		return nomproformat;
	}
	public void setNomproformat(String nomproformat) {
		this.nomproformat = nomproformat;
	}

	public int getId_fournisseur() {
		return Id_fournisseur;
	}
	public void setId_fournisseur(int id_fournisseur) {
		Id_fournisseur = id_fournisseur;
	}
	public void setId_fournisseur(String id_fournisseur)throws Exception{
		try{	Integer.valueOf(id_fournisseur); }
		catch(Exception e){ throw new Exception("id_fournisseur:"+id_fournisseur+" invalide"); }
		setId_fournisseur(Integer.valueOf(id_fournisseur));
	}
	public void insererProformatmereAndAllProformat(ProformatService proformatservice,ProformatmereService proformatmereService,Proformat[] proformats)throws Exception{
		if(proformats==null){ throw new Exception("proformat vide"); }
		if(this.dateproformat.after(Date.valueOf(LocalDate.now()))==true){ throw new Exception("Date proformat doit etre <= a aujourd\'hui ("+LocalDate.now().toString()+")"); }
		if(this.Id_fournisseur<=0){ throw new Exception("fournisseur(id:"+this.Id_fournisseur+") invalide"); }
		Proformatmere proformatmere=proformatmereService.saveProformatmere(this);
		for(int i=0;i<proformats.length;i++){
			proformats[i].setId_proformatmere(proformatmere.getId_proformatmere());
			proformats[i].insertion(proformatservice);
		}
	}
	
}
