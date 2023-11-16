package com.example.commerciale.Models;
import java.sql.Date;
public class Proformatmere  {
	int Id_proformatmere ;
	Date dateproformat;
	String nomproformat ;
	public Proformatmere() {
	}
	public int getId_proformatmere() {
		return Id_proformatmere;
	}
	public void setId_proformatmere(int id_proformatmere) {
		Id_proformatmere = id_proformatmere;
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
	
}
