package com.example.commerciale.Models;

import java.util.List;

import com.example.commerciale.service.ArticleService;
import com.example.commerciale.service.ProformatService;

public class ProformatDetail  {
   Proformat proformat;
   Article article;

   
	public ProformatDetail() {
	}
	public ProformatDetail(Proformat proformat, Article article) {
		this.proformat = proformat;
		this.article = article;
	}

	public Proformat getProformat() {
		return proformat;
	}
	public void setProformat(Proformat proformat) {
		this.proformat = proformat;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	//-----
	public double getQuantite(){
		if(proformat==null){ return 0; }
		return proformat.getQuantite();
	}
	public double getPrixunitaire(){
		if(proformat==null){ return 0; }
		return proformat.getPrixunitaire();
	}
	public double getTva(){
		if(proformat==null){ return 0; }
		return proformat.getTva();
	}
	public double getprixttc(){
		if(proformat==null){ return 0; }
		return getPrixunitaire()+((proformat.getTva()/100)*getPrixunitaire());
	}
	public String getNomarticle(){
		if(article==null){ return ""; }
		return article.getNom();
	}


	public ProformatDetail[] getProformatDetailsById_proformatmere(ProformatService proformatService,ArticleService articleService,int id_proformatmere){
		List<Proformat> lstp=proformatService.getAllProformatsById_proformatmere(id_proformatmere);
		if(lstp.isEmpty()){ return null; }
		ProformatDetail[] proformatDetail=new ProformatDetail[lstp.size()];
		for(int i=0;i<lstp.size();i++){
			proformatDetail[i]=new ProformatDetail(lstp.get(i), articleService.getArticleById(lstp.get(i).getId_article()).get());
		}
		return proformatDetail;
	}
   
}

