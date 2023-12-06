package com.example.commerciale.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="article")
public class ArticleMi  {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   int Id_article ;
   String nom ;
   String unite;
   int Id_categorie;
   String modegestion;
	public ArticleMi() {
	}
	public int getId_article() {
		return Id_article;
	}
	public void setId_article(int id_article){
		Id_article = id_article;
	}
	public void setId_article(String id_article)throws Exception{
		try{	Integer.valueOf(id_article); }
		catch(Exception e){ throw new Exception("id_article:"+id_article+" invalide"); }
		setId_article(Integer.valueOf(id_article));
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getUnite() {
		return unite;
	}

	public void setUnite(String unite) {
		this.unite = unite;
	}

	public int getId_categorie() {
		return Id_categorie;
	}
	public void setId_categorie(int id_categorie) {
		Id_categorie = id_categorie;
	}
	public void setId_categorie(String id_categorie)throws Exception{
		try{	Integer.valueOf(id_categorie); }
		catch(Exception e){ throw new Exception("id_categorie:"+id_categorie+" invalide"); }
		setId_categorie(Integer.valueOf(id_categorie));
	}
	public String getModegestion() {
        return modegestion;
    }
    public void setModegestion(String modegestion) {
        this.modegestion = modegestion;
    }

   
}

