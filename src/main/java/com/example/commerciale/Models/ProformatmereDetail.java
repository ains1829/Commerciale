package com.example.commerciale.Models;

import java.sql.Date;
import java.util.List;

import com.example.commerciale.service.FournisseurService;
import com.example.commerciale.service.ProformatmereService;

public class ProformatmereDetail  {
	Proformatmere proformatmere;
	Fournisseur fournisseur;
	
	public ProformatmereDetail() {
	}

	public ProformatmereDetail(Proformatmere proformatmere, Fournisseur fournisseur) {
		this.proformatmere = proformatmere;
		this.fournisseur = fournisseur;
	}

	public Proformatmere getProformatmere() {
		return proformatmere;
	}

	public void setProformatmere(Proformatmere proformatmere) {
		this.proformatmere = proformatmere;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
	//------
	public int getId_proformatmere(){
		if(proformatmere==null){ return 0; }
		return proformatmere.getId_proformatmere();
	}
	public String getNomproformatmere(){
		if(proformatmere==null){ return ""; }
		return proformatmere.getNomproformat();
	}
	public String getNomfournisseur(){
		if(fournisseur==null){ return ""; }
		return fournisseur.getNom();
	}
	public String getDateproformatmere(){
		if(proformatmere==null){ return ""; }
		else if(proformatmere.getDateproformat()==null){ return ""; }
		return proformatmere.getDateproformat().toString();
	}

	public ProformatmereDetail[] getAllProformatDetail(ProformatmereService proformatmereService,FournisseurService fournisseurService){
		List<Proformatmere> lstpm=proformatmereService.getAllProformatmeres();
		System.out.println(lstpm.isEmpty());
		if(lstpm.isEmpty()==true){ return null; }
		ProformatmereDetail[] proformatmereDetails=new ProformatmereDetail[lstpm.size()];
		for(int i=0;i<lstpm.size();i++){
			proformatmereDetails[i]=new ProformatmereDetail(lstpm.get(i), fournisseurService.getFournisseurById( lstpm.get(i).getId_fournisseur() ).get() );
		}
		return proformatmereDetails;
	}
}

