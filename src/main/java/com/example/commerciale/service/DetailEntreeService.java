package com.example.commerciale.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.commerciale.models.DetailEntree;
import com.example.commerciale.repository.DetailEntreeRepository;

import java.util.List;
import java.sql.Date;
@Service
public class DetailEntreeService {

    @Autowired
    private DetailEntreeRepository  detailEntreeRepository;

    // Méthode pour récupérer tous les magasins
    public List<DetailEntree> getAllDetailEntrees() {
        return  detailEntreeRepository.findAll();
    }
    public DetailEntree[] getTabAllmagasins(){
        List<DetailEntree> lst=getAllDetailEntrees();
        if(lst==null){ return null; }
        DetailEntree[] tab=new DetailEntree[lst.size()];
        for(int i=0;i<lst.size();i++){
            tab[i]=lst.get(i);
        }
        return tab;
    }
    public DetailEntree[] getById_articleByIdmagasinBeforeDate(int id_article,int idmagasin,Date date){
        List<DetailEntree> ld=detailEntreeRepository.findById_articleByIdmagasinBeforeDate(id_article,idmagasin,date);
        if(ld.isEmpty()==true){ return null; }
        DetailEntree[] tab=new DetailEntree[ld.size()];
        for(int i=0;i<ld.size();i++){
            tab[i]=ld.get(i);
        }
        return tab;
    }
    public DetailEntree[] getById_articleByIdmagasinBeforeDateFifo(int id_article,int idmagasin,Date date){
        List<DetailEntree> ld=detailEntreeRepository.findById_articleByIdmagasinBeforeDateFifo(id_article,idmagasin,date);
        if(ld.isEmpty()==true){ return null; }
        DetailEntree[] tab=new DetailEntree[ld.size()];
        for(int i=0;i<ld.size();i++){
            tab[i]=ld.get(i);
        }
        return tab;
    }
    public DetailEntree[] getById_articleByIdmagasinBeforeDateLifo(int id_article,int idmagasin,Date date){
        List<DetailEntree> ld=detailEntreeRepository.findById_articleByIdmagasinBeforeDateLifo(id_article,idmagasin,date);
        if(ld.isEmpty()==true){ return null; }
        DetailEntree[] tab=new DetailEntree[ld.size()];
        for(int i=0;i<ld.size();i++){
            tab[i]=ld.get(i);
        }
        return tab;
    }
}
