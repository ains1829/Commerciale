package com.example.commerciale.service;
import java.sql.Date;
import java.util.List;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.commerciale.models.Besoin;
import com.example.commerciale.repository.MyBesoinRepo;
@Service
public class BesoinTservice {
    @Autowired
    private MyBesoinRepo respository_besoin ;
    public Besoin insertBesoin(Besoin besoin){
        return respository_besoin.save(besoin) ;
    }
    public List<Besoin> getBesoinList(){
        return respository_besoin.findAll() ;
    }
    public List<Besoin> getcomposition(Date dates , int article){
        List<Besoin> besoinList = new ArrayList<Besoin>();
        List<Besoin> all = getBesoinList() ;
        for (int i = 0; i < all.size(); i++) {
            if((all.get(i).getDatebesoin().equals(dates)) && (all.get(i).getId_article() == article)){
                besoinList.add(all.get(i)) ;
            }
        }
        return besoinList ;
    }
    public String getNameDepartement(int iddepartement){
        return respository_besoin.Namedepartement(iddepartement) ;
    }
}
