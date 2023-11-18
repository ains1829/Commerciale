package com.example.commerciale.Models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Fournisseur  {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   int Id_fournisseur;
   String nom;
   String manager;
   String email;
   String adresse;
	public Fournisseur() {
	}
	public int getId_fournisseur() {
		return Id_fournisseur;
	}
	public void setId_fournisseur(int id_fournisseur){
		Id_fournisseur = id_fournisseur;
	}
	public void setId_fournisseur(String id_fournisseur)throws Exception{
		try{	Integer.valueOf(id_fournisseur); }
		catch(Exception e){ throw new Exception("id_fournisseur:"+id_fournisseur+" invalide"); }
		setId_fournisseur(Integer.valueOf(id_fournisseur));
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getManager() {
		return manager;
	}
	public void setManager(String manager) {
		this.manager = manager;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	

   
}

