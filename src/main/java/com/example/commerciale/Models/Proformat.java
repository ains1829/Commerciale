package com.example.commerciale.Models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.example.commerciale.service.ProformatService;

@Entity
public class Proformat  {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   int Id_proformat;
   int Id_proformatmere;
   double quantite;
   double prixunitaire;
   double tva ;
   int Id_article; 
	public Proformat() {
	}

	public Proformat(String id_proformat, String id_proformatmere,String quantite,String prixunitaire,String tva,String id_article)throws Exception{
		setId_proformat(id_proformatmere);
		setId_proformatmere(id_proformatmere);
		setQuantite(quantite);
		setPrixunitaire(prixunitaire);
		setTva(tva);
		setId_article(id_article);
	}

	public int getId_proformat() {
		return Id_proformat;
	}
	public void setId_proformat(int id_proformat){
		Id_proformat = id_proformat;
	}
	public void setId_proformat(String id_proformat)throws Exception{
		try{	Integer.valueOf(id_proformat); }
		catch(Exception e){ throw new Exception("id_proformat:"+id_proformat+" invalide"); }
		setId_proformat(Integer.valueOf(id_proformat));
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

	public double getQuantite() {
		return quantite;
	}
	public void setQuantite(double quantite) {
		this.quantite = quantite;
	}
	public void setQuantite(String quantite)throws Exception{
		try{	Double.valueOf(quantite); }
		catch(Exception e){ throw new Exception("quantite:"+quantite+" invalide"); }
		setQuantite(Double.valueOf(quantite));
	}

	public double getPrixunitaire() {
		return prixunitaire;
	}
	public void setPrixunitaire(double prixunitaire) {
		this.prixunitaire = prixunitaire;
	}
	public void setPrixunitaire(String prixunitaire)throws Exception{
		try{	Double.valueOf(prixunitaire); }
		catch(Exception e){ throw new Exception("prixunitaire:"+prixunitaire+" invalide"); }
		setPrixunitaire(Double.valueOf(prixunitaire));
	}

	public double getTva() {
		return tva;
	}
	public void setTva(double tva) {
		this.tva = tva;
	}
	public void setTva(String tva)throws Exception{
		try{	Double.valueOf(tva); }
		catch(Exception e){ throw new Exception("tva:"+tva+" invalide"); }
		setTva(Double.valueOf(tva));
	}
	public int getId_article() {
		return Id_article;
	}
	public void setId_article(int id_article) {
		Id_article = id_article;
	}
	public void setId_article(String id_article)throws Exception{
		try{	Integer.valueOf(id_article); }
		catch(Exception e){ throw new Exception("id_article:"+id_article+" invalide"); }
		setId_article(Integer.valueOf(id_article));
	}

	public void insertion(ProformatService proformatservice)throws Exception{
			if(this.Id_proformatmere<=0){ throw new Exception("proformatmere(id:"+this.Id_proformatmere+") invalide"); }
			if(this.quantite<=0){ throw new Exception("quantite doit etre > 0"); }
			if(prixunitaire<=0){ throw new Exception("quantite doit etre > 0"); }
			if(this.tva< 0 || this.tva > 100){ throw new Exception("quantite doit etre entre > ou = 0 et < ou = 100"); }
			if(this.Id_article<=0){ throw new Exception("article(id:"+this.Id_article+") invalide"); }
			proformatservice.saveProformat(this);
	}

   
}

