package com.example.commerciale.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.sql.Insert;

import com.example.commerciale.service.BonentreMiService;

import java.sql.Date;

@Entity
@Table(name="bonentre")
public class BonentreMi  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int idbonentre ;
	int idmagasin ;
	int idreceptiondetail ;
	float quantiteentre ;
	Date dateentre;

	public BonentreMi() {
	}
	public BonentreMi(String idbonentre, String idmagasin, String idreceptiondetail, String quantiteentre, String dateentre)throws Exception {
		setIdbonentre(idbonentre);
		setIdmagasin(idmagasin);
		setIdreceptiondetail(idreceptiondetail);
		setQuantiteentre(quantiteentre);
		setDateentre(dateentre);
	}

	public int getIdbonentre() {
		return idbonentre;
	}
	public void setIdbonentre(int idbonentre) {
		this.idbonentre = idbonentre;
	}
	public void setIdbonentre(String idbonentre)throws Exception{
		try{	Integer.valueOf(idbonentre);
		}catch(Exception ex){ throw new Exception("idbonentre :"+idbonentre+" invalide"); }
		setIdbonentre(Integer.valueOf(idbonentre));
	}
	public int getIdmagasin() {
		return idmagasin;
	}
	public void setIdmagasin(int idmagasin) {
		this.idmagasin = idmagasin;
	}
	public void setIdmagasin(String idmagasin)throws Exception{
		try{	Integer.valueOf(idmagasin);
		}catch(Exception ex){ throw new Exception("idmagasin :"+idmagasin+" invalide"); }
		setIdmagasin(Integer.valueOf(idmagasin));
	}
	public int getIdreceptiondetail() {
		return idreceptiondetail;
	}
	public void setIdreceptiondetail(int idreceptiondetail) {
		this.idreceptiondetail = idreceptiondetail;
	}
	public void setIdreceptiondetail(String idreceptiondetail)throws Exception{
		try{	Integer.valueOf(idreceptiondetail);
		}catch(Exception ex){ throw new Exception("idreceptiondetail :"+idreceptiondetail+" invalide"); }
		setIdreceptiondetail(Integer.valueOf(idreceptiondetail));
	}
	public float getQuantiteentre() {
		return quantiteentre;
	}
	public void setQuantiteentre(float quantiteentre) {
		this.quantiteentre = quantiteentre;
	}
	public void setQuantiteentre(String quantiteentre)throws Exception{
		try{	Float.valueOf(quantiteentre);
		}catch(Exception ex){ throw new Exception("Quantiteentre :"+quantiteentre+" invalide"); }
		setQuantiteentre(Float.valueOf(quantiteentre));
	}
	public Date getDateentre() {
		return dateentre;
	}
	public void setDateentre(Date dateentre) {
		this.dateentre = dateentre;
	}
	public void setDateentre(String dateentre)throws Exception{
		try{	Date.valueOf(dateentre);
		}catch(Exception ex){ throw new Exception("dateentre :"+dateentre+" invalide"); }
		setDateentre(Date.valueOf(dateentre));
	}
	public BonentreMi[] getALlBonetreMiBy(String idmagasin,String dateentre,String[] idbandereceptions,String[] quantiteentres)throws Exception{
		if(idbandereceptions==null){ return null; }
		else if(idbandereceptions.length==0){ return null; }
		else if(quantiteentres==null){ return null; }
		else if(quantiteentres.length==0){ return null; }
		else if(idmagasin==null ){ throw new Exception("idmagasin null"); }
		else if(idmagasin.compareTo("0")!=0){ throw new Exception("idmagasin invalide"); }
		else if(dateentre==null ){ throw new Exception("date entree null"); }
		if(idbandereceptions.length!=quantiteentres.length){ throw new Exception("nombre  bandereceptions !=  nombre quantiteentres"); }
		BonentreMi[] bonentreMis=new BonentreMi[idbandereceptions.length];
		for(int i=0;i<quantiteentres.length;i++){
			bonentreMis[i]=new BonentreMi("0",idmagasin,idbandereceptions[i],quantiteentres[i],dateentre);
			if(bonentreMis[i].getQuantiteentre()<0){
				throw new Exception("quantite entree inferieur a zero");
			}
		}
		return bonentreMis;
	}
	public void insertAll(BonentreMiService bonentreMiService,String idmagasin,String dateentre,String[] idbandereceptions,String[] quantiteentres)throws Exception{
		BonentreMi[] bonentreMis=getALlBonetreMiBy(idmagasin, dateentre, idbandereceptions, quantiteentres);
		if(bonentreMis!=null){
			for(int i=0;i<bonentreMis.length;i++){
				bonentreMis[i]=bonentreMiService.saveBonentre(bonentreMis[i]);
			}
		}
	}
   
   
}

