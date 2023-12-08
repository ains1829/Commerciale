package com.example.commerciale.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.example.commerciale.service.ArticleMiService;
import com.example.commerciale.service.BonsortieMiService;
import com.example.commerciale.service.DetailArticleEntreService;
import com.example.commerciale.service.DetailEntreeService;
import com.example.commerciale.service.MagasinMiService;

import java.sql.Date;
import java.util.Vector;

@Entity
@Table(name="magasin")
public class MagasinMi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idmagasin;
    String nommagasin ;
    String adresse ;
    public MagasinMi() {
    }
    public int getIdmagasin() {
        return idmagasin;
    }
    public void setIdmagasin(int idmagasin) {
        this.idmagasin = idmagasin;
    }
    public void setIdmagasin(String idmagasin)throws Exception{
        try{ Integer.valueOf(idmagasin); }
        catch(Exception ex){ throw new Exception("idmagasin :"+idmagasin+" invalide"); }
        setIdmagasin(Integer.valueOf(idmagasin));
    }
    public String getNommagasin() {
        return nommagasin;
    }
    public void setNommagasin(String nommagasin) {
        this.nommagasin = nommagasin;
    }
    public String getAdresse() {
        return adresse;
    }
    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }
    public MagasinMi getByTheId(MagasinMiService magasinMiService){
        return magasinMiService.getById(this.idmagasin).get();
    }
 
    // public Movementstockout[] decomposermovementout(Connection connection)throws Exception{
    //     verificationOuStock(connection);
    //     Article article=new Article();
	// 	article.setIdarticle(idarticle);
	// 	article=(Article)article.readById(connection, "idarticle");
	// 	if(article==null){ throw new Exception("article(id="+idarticle+") non valide"); }

    //     Unitarticle unitarticle=new Unitarticle();
    //     unitarticle.setIdunitarticle(this.idunitarticleorigine);
    //     unitarticle.setIdarticle(this.idarticle);
    //     unitarticle=unitarticle.getByIdAndIdarticle(connection);
    //     if(unitarticle==null){ throw new ExceptionStock("unite :"+getIdunitarticleorigine()+" invalide pour article id:"+this.idarticle); }

	// 	Object[] omvins=this.getAllMovementstockinOrderByMethodeGestionQuantiteinitIsRest(connection);
	// 	Movementstockin mvin=null;
    //     Movementstockout mout=null;
    //     Vector<Movementstockout> vmout=new Vector<Movementstockout>();
	// 	double quantiteR=unitarticle.toMinUnite(connection, this.quantite);
	// 	double quantiteR2=unitarticle.toMinUnite(connection, this.quantite);

	// 	//connection.setAutoCommit(false);
	// 	for(int i=0;i<omvins.length;i++){
	// 		mvin=(Movementstockin)omvins[i];
	// 		mout=new Movementstockout();
	// 		mout.setIdmovementstockin(mvin.getIdmovementstockin());
    //         mout.setIdmovementmereout(this.idmovementmereout);
    //         //anesorana le reste(le sisa avoaka)
	// 		quantiteR2=quantiteR2-mvin.getQuantiteinitial(); //REMARQUE :getQuantiteinitial()--> (quantiteinitial-quantiteout) = quantite reste ao @ io mvin io
	// 		if(quantiteR2<=0){//raha efa niala daholo
	// 			mout.setQuantiteout(quantiteR);
	// 			i=omvins.length;//arret
	// 		}else{ //raha mbola quantiteR2>0 ambony donc mbola tsy feno ,donc afaka tonga de alaina daholo le mvin.getQuantiteinitial()
	// 			quantiteR=quantiteR2;
	// 			mout.setQuantiteout(mvin.getQuantiteinitial());
	// 		}
    //         vmout.add(mout);
	// 	}
    //     if(vmout.size()==0){ return null; }
    //     Movementstockout[] movementstockouts=new Movementstockout[vmout.size()];
    //     for(int i=0;i<vmout.size();i++){ movementstockouts[i]=vmout.elementAt(i); }
    //     return movementstockouts;
    // }
    public BonsortieMi[] decomposer(ArticleMiService articleMiService,DetailEntreeService detailEntreeService,DetailArticleEntreService detailArticleEntreService,int id_article,float quantite,Date datesortie )throws Exception{
        Vector<BonsortieMi> vbonsortieMi=new Vector<BonsortieMi>();
        if(quantite<0){ throw new Exception("quantite negatif"); } 
        ArticleMi articleMi=articleMiService.getArticleById(id_article).get();
        if(articleMi==null){ throw new Exception("article id:"+id_article+" invalide"); }

        DetailArticleEntre detailArticleEntre=detailArticleEntreService.getOneById_articleByIdmagasinBeforeDate(id_article, this.idmagasin, datesortie);
        if(detailArticleEntre==null){ throw new Exception("quantite null"); }
        if( detailArticleEntre.getQuantiteReste()<quantite){ throw new Exception("quantite insuffisante: reste="+detailArticleEntre.getQuantiteReste());  } 

        DetailEntree[] detailEntrees=null;// idbonentre | id_article | idmagasin | quantiteentre | totalsortie | dateentre | ladate | prixht | tva | prixttc
        if(articleMi.getModegestion().compareToIgnoreCase("FIFO")==0){  detailEntrees=detailEntreeService.getById_articleByIdmagasinBeforeDateFifo(id_article, this.idmagasin, datesortie);
        }else if(articleMi.getModegestion().compareToIgnoreCase("LIFO")==0){    detailEntrees=detailEntreeService.getById_articleByIdmagasinBeforeDateLifo(id_article, this.idmagasin, datesortie);
        }else{  detailEntrees=detailEntreeService.getById_articleByIdmagasinBeforeDate(id_article, this.idmagasin, datesortie); }
        if(detailEntrees==null){ throw new Exception("detail entree null"); }
        
        float quantiteR=quantite;
	    float quantiteR2=quantite;
        BonsortieMi bonsortieMi=null;// idbonsortie | idbonentre | quantitesortie | datesortie
		for(int i=0;i<detailEntrees.length;i++){
			bonsortieMi=new BonsortieMi();
			bonsortieMi.setIdbonentre(detailEntrees[i].getIdbonentre());
            //anesorana le reste(le sisa avoaka)
			quantiteR2=quantiteR2-detailEntrees[i].getQuantiteReste(); 
			if(quantiteR2<=0){//raha efa niala daholo
				bonsortieMi.setQuantitesortie(quantiteR);
				i=detailEntrees.length;//arret
			}else{ //raha mbola quantiteR2>0 ambony donc mbola tsy feno ,donc afaka tonga de alaina daholo le quantite
				quantiteR=quantiteR2;
                bonsortieMi.setQuantitesortie(detailEntrees[i].getQuantiteReste());
			}
            vbonsortieMi.add(bonsortieMi);
		}
        BonsortieMi[] bonsortieMis=new BonsortieMi[vbonsortieMi.size()];
        for(int i=0;i<vbonsortieMi.size();i++){ bonsortieMis[i]=vbonsortieMi.elementAt(i); }
        return bonsortieMis;
    }

    public void sortirStock(BonsortieMiService bonsortieMiService,ArticleMiService articleMiService,DetailEntreeService detailEntreeService,DetailArticleEntreService detailArticleEntreService,int id_article,float quantite,Date datesortie )throws Exception{
        //verifier si il y avait deja une movement avant
        BonsortieMi bonsortielast=bonsortieMiService.getLastBonsortieMi(this.idmagasin, id_article);
        if(bonsortielast!=null){ 
            if(bonsortielast.getDatesortie().after(datesortie)==true){
                throw new Exception("ce sortie le :"+datesortie.toString()+" doit etre apres la derniere sortie le:"+bonsortielast.getDatesortie().toString());
            } 
        }
        BonsortieMi[] bonsortieMis=decomposer(articleMiService, detailEntreeService, detailArticleEntreService, id_article, quantite, datesortie);
        for(int i=0;i<bonsortieMis.length;i++){ bonsortieMis[i]=bonsortieMiService.savebonsortie(bonsortieMis[i]); }
    }
     public void sortirStock(BonsortieMiService bonsortieMiService,ArticleMiService articleMiService,DetailEntreeService detailEntreeService,DetailArticleEntreService detailArticleEntreService,String id_article,String quantite,String datesortie )throws Exception{
        try{ Integer.valueOf(id_article);
        }catch(Exception ex){ throw new Exception("idarticle :"+id_article+" invalide");  }
        try{ Float.valueOf(quantite);
        }catch(Exception ex){ throw new Exception("quantite :"+quantite+" invalide");  }
        try{ Date.valueOf(datesortie);
        }catch(Exception ex){ throw new Exception("datesortie :"+datesortie+" invalide");  }
        this.sortirStock(bonsortieMiService, articleMiService, detailEntreeService, detailArticleEntreService,Integer.valueOf(id_article) ,Float.valueOf(quantite),Date.valueOf(datesortie) );
        
    }


    
}
