package com.example.commerciale.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.commerciale.models.DetailArticleRecu;
import com.example.commerciale.repository.DetailArticleRecuRepository;

import java.util.List;
import java.sql.Date;
@Service
public class DetailArticleRecuService {

    @Autowired
    private DetailArticleRecuRepository  detailArticleRepository;

    // Méthode pour récupérer tous les magasins
    public List<DetailArticleRecu> getAllDetailArticles() {
        return  detailArticleRepository.findAll();
    }
    public DetailArticleRecu[] getTabAllDetailArticleRecus(){
        List<DetailArticleRecu> lstA=getAllDetailArticles();
        if(lstA==null){ return null; }
        if(lstA.isEmpty()==true){ return null; }
        DetailArticleRecu[] magasins=new DetailArticleRecu[lstA.size()];
        for(int i=0;i<lstA.size();i++){
            magasins[i]=lstA.get(i);
        }
        return magasins;
    }
    public DetailArticleRecu[] getByDatereceptionById_fournisseur(Date datereception,int id_fournisseur){
        List<DetailArticleRecu> ld=detailArticleRepository.findByDatereceptionById_fournisseur(datereception, id_fournisseur);
        if(ld.isEmpty()==true){ return null; }
        DetailArticleRecu[] detailArticleRecus=new DetailArticleRecu[ld.size()];
        for(int i=0;i<ld.size();i++){
            detailArticleRecus[i]=ld.get(i);
        }
        return detailArticleRecus;
    }
}
