package com.example.commerciale.models;

import java.util.List;

import com.example.commerciale.service.ArticleMiService;
import com.example.commerciale.service.ProformatMiService;

public class ProformatDetail  {
   ProformatMi proformat;
   ArticleMi article;

   
	public ProformatDetail() {
	}
	public ProformatDetail(ProformatMi proformat, ArticleMi article) {
		this.proformat = proformat;
		this.article = article;
	}

	public ProformatMi getProformat() {
		return proformat;
	}
	public void setProformat(ProformatMi proformat) {
		this.proformat = proformat;
	}
	public ArticleMi getArticle() {
		return article;
	}
	public void setArticle(ArticleMi article) {
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


	public ProformatDetail[] getProformatDetailsById_proformatmere(ProformatMiService proformatService,ArticleMiService articleService,int id_proformatmere){
		List<ProformatMi> lstp=proformatService.getAllProformatsById_proformatmere(id_proformatmere);
		if(lstp.isEmpty()){ return null; }
		ProformatDetail[] proformatDetail=new ProformatDetail[lstp.size()];
		for(int i=0;i<lstp.size();i++){
			proformatDetail[i]=new ProformatDetail(lstp.get(i), articleService.getArticleById(lstp.get(i).getId_article()).get());
		}
		return proformatDetail;
	}
   
}

