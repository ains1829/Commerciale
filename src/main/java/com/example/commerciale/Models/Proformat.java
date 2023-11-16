package com.example.commerciale.Models;
import java.sql.Date;
public class Proformat  {
   int Id_proformat;
   int Id_proformatmere;
   double quantite;
   double prixunitaire;
   double tva ;
   int Id_fournisseur;
   int Id_article; 
public Proformat() {
}
public int getId_proformat() {
	return Id_proformat;
}
public void setId_proformat(int id_proformat) {
	Id_proformat = id_proformat;
}
public int getId_proformatmere() {
	return Id_proformatmere;
}
public void setId_proformatmere(int id_proformatmere) {
	Id_proformatmere = id_proformatmere;
}
public double getQuantite() {
	return quantite;
}
public void setQuantite(double quantite) {
	this.quantite = quantite;
}
public double getPrixunitaire() {
	return prixunitaire;
}
public void setPrixunitaire(double prixunitaire) {
	this.prixunitaire = prixunitaire;
}
public double getTva() {
	return tva;
}
public void setTva(double tva) {
	this.tva = tva;
}
public int getId_fournisseur() {
	return Id_fournisseur;
}
public void setId_fournisseur(int id_fournisseur) {
	Id_fournisseur = id_fournisseur;
}
public int getId_article() {
	return Id_article;
}
public void setId_article(int id_article) {
	Id_article = id_article;
}
   
}