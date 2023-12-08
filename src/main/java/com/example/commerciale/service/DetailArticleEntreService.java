package com.example.commerciale.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.commerciale.models.DetailArticleEntre;
import com.example.commerciale.repository.DetailArticleEntreRepository;

import java.util.List;
import java.sql.Date;
@Service
public class DetailArticleEntreService {

    @Autowired
    private DetailArticleEntreRepository  detailArticleEntreRepository;

    // Méthode pour récupérer tous les magasins
    public List<DetailArticleEntre> getAllDetailArticleEntres() {
        return  detailArticleEntreRepository.findAll();
    }
    public DetailArticleEntre[] getTabAll(){
        List<DetailArticleEntre> lst=getAllDetailArticleEntres();
        if(lst==null){ return null; }
        if(lst.isEmpty()==true){ return null; }
        DetailArticleEntre[] tab=new DetailArticleEntre[lst.size()];
        for(int i=0;i<lst.size();i++){
            tab[i]=lst.get(i);
        }
        return tab;
    }
    public DetailArticleEntre getOneById_articleByIdmagasinBeforeDate(int id_article,int idmagasin,Date date){
        List<DetailArticleEntre> ld=detailArticleEntreRepository.findById_articleByIdmagasinBeforeDate(id_article,idmagasin,date);
        if(ld.isEmpty()==true){ return null; }
        DetailArticleEntre a=ld.get(0);
        return a;
    }
}
