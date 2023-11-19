package com.example.commerciale.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.commerciale.models.Groupementnotif;
import com.example.commerciale.repository.NotificationGroupement;
@Service
public class GroupementnotifService {
    @Autowired
    private NotificationGroupement groupement ;
    public List<Groupementnotif> getAllNotification(){
        return groupement.findAll() ;
    }
    public Groupementnotif notifigroupement(Integer id){
        return groupement.findById(id).orElse(null) ;
    }
    public Groupementnotif updateGroupement(Integer id){
        Groupementnotif notif = groupement.findById(id).orElse(null);
        if (notif != null) {
            notif.setEtat(10);
            return groupement.save(notif);
        }
        return null;
    }
    public Groupementnotif updateGroupementdg(Integer id){
        Groupementnotif notif = groupement.findById(id).orElse(null);
        if (notif != null) {
            notif.setEtat(100);
            return groupement.save(notif);
        }
        return null;
    }
    public List<Groupementnotif> getNotif(String profil , String departement){
        List <Groupementnotif> all = getAllNotification() ;
        System.out.println("taille = " + all.size());
        List <Groupementnotif> mynotif = new ArrayList<Groupementnotif>();
        for (int i = 0; i < all.size(); i++) {
            if(profil.compareTo("DG") == 0){
                if(all.get(i).getEtat() == 10){
                    mynotif.add(all.get(i)) ;
                }
            }
            if((departement.compareTo("FINANCE") == 0) && (profil.compareTo("Employer") == 0)){
                if(all.get(i).getEtat() == 0){
                    mynotif.add(all.get(i)) ;
                }
            }
        }
        return mynotif ;
    }
}
