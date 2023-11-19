package com.example.commerciale.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.ZoneId;

import com.example.commerciale.models.Bandecommandedetail;
import com.example.commerciale.models.Besoinmain;
import com.example.commerciale.models.MereProformat;
import com.example.commerciale.models.Proformatmain;
import com.example.commerciale.repository.BandeR;
import com.example.commerciale.repository.MyProformatRepository;
import com.example.commerciale.repository.ProformatMereRepo;
import com.ibm.icu.text.RuleBasedNumberFormat;
import java.util.Locale;

import javax.transaction.Transaction;
@Service
public class BandeDetail {
    @Autowired
    private BandeR repositoryBande ;
    @Autowired
    private BesoinService groupement ;
    @Autowired
    private ProformatMereRepo pRepo ;
    @Autowired 
    private MyProformatService serviceDetail;
    @Autowired
    private MyProformatRepository proformatRepository ;
    public List<Bandecommandedetail> getDetails(){
        return repositoryBande.findAll() ;
    }
    public boolean DateIsNotExist(Date proformat){
        List<Bandecommandedetail> bdT = getDetails() ;
        for (int i = 0; i < bdT.size(); i++) {
            if(bdT.get(i).getDateproformat().equals(proformat)){
                return false;
            }
        }
        return true;
    }
    public double quanite_date_idarticle(int id_article){
        double quantite = 0 ;
        Date date = proformatRepository.getDatemax() ;
        List<Proformatmain> detailproformat = serviceDetail.getProformatDetail(); 
        System.out.println("taille : " + detailproformat.size());
        for (int i = 0; i < detailproformat.size(); i++) {
            System.out.println(detailproformat.get(i).getId_article() + "   " + detailproformat.get(i).getQuantite());
            if((detailproformat.get(i).getId_article() == id_article) && (detailproformat.get(i).getDateproformat().equals(date) == true)){
                System.out.println(detailproformat.get(i).getQuantite());
                quantite += detailproformat.get(i).getQuantite() ;
            }
        }
        System.out.println("idarticle = "  + id_article + " : " +   quantite);
        System.out.println("----------------------------");
        return quantite ;
    }
    public boolean CanhaveBande(Date datess){
        List<Besoinmain> groupemet = groupement.getBesoinAllBydate(datess) ;
        for (int i = 0; i < groupemet.size(); i++) {
            if(quanite_date_idarticle(groupemet.get(i).getId_article()) < groupemet.get(i).getQuantite()){
                System.out.println("id : = " + groupemet.get(i).getId_article());
                return false ;
            }else{
                System.out.println("id ??: = " + groupemet.get(i).getId_article());
            }
        }   
        return true ;
    }
    public boolean fournisseur_thisDate(int id_fournisseur , Date datemere){
        List<Bandecommandedetail> alldetails = getDetails() ;
        for (int i = 0; i < alldetails.size(); i++) {
            if((alldetails.get(i).getDateBandecommade().equals(datemere) == true) && (alldetails.get(i).getId_fournisseur() == id_fournisseur)){
                return true ;
            }
        }
        return false ;
    }
    public List<Bandecommandedetail> MyCommande(int id_fournisseur, Date date_mere){
        List <Bandecommandedetail> about_fournisseur_date = new ArrayList<Bandecommandedetail>() ;
        List <Bandecommandedetail> all = getDetails() ;
        for (int i = 0; i < all.size(); i++) {
            if((all.get(i).getId_fournisseur() == id_fournisseur) && (all.get(i).getDateBandecommade().equals(date_mere) == true)){
                about_fournisseur_date.add(all.get(i)) ;
            }
        }
        return about_fournisseur_date  ; 
    }
    public double SommeMyCommande(int id_fournisseur, Date date_mere){
        double somme = 0 ;
        List <Bandecommandedetail> all = getDetails() ;
        for (int i = 0; i < all.size(); i++) {
            if((all.get(i).getId_fournisseur() == id_fournisseur) && (all.get(i).getDateBandecommade().equals(date_mere) == true)){
                somme +=  TTC(all.get(i).getTva() , all.get(i).getPrixht()) ;
            }
        }
        return somme  ; 
    }
    public double TTC(double tva , double prixht) {
        return (prixht + ((prixht *tva)/100)) ;
    }
    public List<Integer> all_fournisseur(){
        return repositoryBande.getMereFournisseur() ;
    }
    public List<Date> all_date(){
        return repositoryBande.getDateMere() ;
    }
    public String getNameArticle(int id_article){
        return repositoryBande.Namearticle(id_article) ;
    }
    public double getMontant(Date datess){
        double totalmontant = 0 ;
        if(CanhaveBande(datess)){
            List<Besoinmain> groupemet = groupement.getBesoinAllBydate(datess) ;
            for (int i = 0; i < groupemet.size(); i++) {
                while(groupemet.get(i).getQuantite()!=0){
                    List<Proformatmain> detailproformat = serviceDetail.getProformatDetail();
                    for (int k = 0; k < detailproformat.size() ; k++) {
                        if(groupemet.get(i).getId_article() == detailproformat.get(k).getId_article()){
                            if(groupemet.get(i).getQuantite() > detailproformat.get(k).getQuantite()){
                                double reste =  groupemet.get(i).getQuantite() - detailproformat.get(k).getQuantite() ;   
                                totalmontant += detailproformat.get(k).getQuantite() * (detailproformat.get(k).getPrixunitaire() + ((detailproformat.get(k).getPrixunitaire() * detailproformat.get(k).getTva()) / 100)) ;
                                System.out.println(totalmontant);
                                RuleBasedNumberFormat formatter = new RuleBasedNumberFormat(Locale.FRENCH , RuleBasedNumberFormat.SPELLOUT) ;
                                String words = formatter.format(totalmontant) ;
                                System.out.println(words);
                                groupemet.get(i).setQuantite(reste);
                            }else{
                                double reste =  detailproformat.get(k).getQuantite() - groupemet.get(i).getQuantite() ;
                                totalmontant += groupemet.get(i).getQuantite() * (detailproformat.get(k).getPrixunitaire() + ((detailproformat.get(k).getPrixunitaire() * detailproformat.get(k).getTva()) / 100)) ;
                                System.out.println(totalmontant);
                                RuleBasedNumberFormat formatter = new RuleBasedNumberFormat(Locale.FRENCH , RuleBasedNumberFormat.SPELLOUT) ;
                                String words = formatter.format(totalmontant) ;
                                System.out.println(words);
                                groupemet.get(i).setQuantite(0);
                                break ;
                            }
                        }
                    }
                }
            }
        }
        return totalmontant ;
    }
    public String generateLetter(double montant){
        RuleBasedNumberFormat formatter = new RuleBasedNumberFormat(Locale.FRENCH , RuleBasedNumberFormat.SPELLOUT) ;
        String words = formatter.format(montant) ;
        return words ;
    }
    public Date getNow(){
        LocalDate date_now = LocalDate.now();
        Date date_now_local = Date.valueOf(date_now);
        return date_now_local ;
    }
    public List<Bandecommandedetail> ajouterBandeDetails(Date datess){
        double totalmontant = 0 ;
        List<Bandecommandedetail> result_save = new ArrayList<Bandecommandedetail>();
        if(CanhaveBande(datess)){
            List<Besoinmain> groupemet = groupement.getBesoinAllBydate(datess) ;
            for (int i = 0; i < groupemet.size(); i++) {
                double myquantiteBesoin = groupemet.get(i).getQuantite() ;
                while(myquantiteBesoin!=0){
                    List<Proformatmain> detailproformat = serviceDetail.getProformatDetail();
                    for (int k = 0; k < detailproformat.size() ; k++) {
                        if(groupemet.get(i).getId_article() == detailproformat.get(k).getId_article()){
                            if(myquantiteBesoin > detailproformat.get(k).getQuantite()){
                                double reste =  myquantiteBesoin - detailproformat.get(k).getQuantite() ;   
                                totalmontant += detailproformat.get(k).getQuantite() * (detailproformat.get(k).getPrixunitaire() + ((detailproformat.get(k).getPrixunitaire() * detailproformat.get(k).getTva()) / 100)) ;
                                System.out.println(totalmontant);
                                myquantiteBesoin = reste ;
                                Bandecommandedetail detail = new Bandecommandedetail(detailproformat.get(k).getQuantite(), detailproformat.get(k).getId_article(), detailproformat.get(k).getId_fournisseur(), detailproformat.get(k).getPrixunitaire(), detailproformat.get(k).getTva(), datess, getNow()) ;
                                result_save.add(repositoryBande.save(detail));
                            }else{
                                double reste =  detailproformat.get(k).getQuantite() - myquantiteBesoin ;
                                totalmontant += myquantiteBesoin * (detailproformat.get(k).getPrixunitaire() + ((detailproformat.get(k).getPrixunitaire() * detailproformat.get(k).getTva()) / 100)) ;
                                System.out.println(totalmontant);
                                Bandecommandedetail detail = new Bandecommandedetail(myquantiteBesoin, detailproformat.get(k).getId_article(), detailproformat.get(k).getId_fournisseur(), detailproformat.get(k).getPrixunitaire(), detailproformat.get(k).getTva(), datess, getNow()) ;
                                result_save.add(repositoryBande.save(detail)) ;
                                myquantiteBesoin = 0 ;
                                break ;
                            }
                        }
                    }
                }
            }
        }
        return result_save;
    }
}
