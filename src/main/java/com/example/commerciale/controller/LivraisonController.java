package com.example.commerciale.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.sql.Date;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.commerciale.models.Fournisseur;
import com.example.commerciale.models.Livraison;
import com.example.commerciale.models.Retour;
import com.example.commerciale.models.Stock;
import com.example.commerciale.service.ServiceLivraison;
import com.example.commerciale.service.StockService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@RestController
@RequestMapping("/livraisoncontroller")
public class LivraisonController {
    @Autowired
    StockService servicestock ;
    @Autowired
    ServiceLivraison livraison_service ;
    @PostMapping("/insertlivraison")
    public String getInsertion(HttpServletRequest request , HttpSession session) throws JsonProcessingException{
        try {
            Fournisseur fournisseur = (Fournisseur) session.getAttribute("aboutfournisseur") ;
            String countArticle = request.getParameter("countArticle");
            System.out.println(countArticle);
            String livreur = request.getParameter("livreur");
            System.out.println(livreur);
            String date_livraison = request.getParameter("date");
            System.out.println(date_livraison);
            String Datebandecommande = request.getParameter("datebandecommande");
            System.out.println(Datebandecommande);
            List<Integer> article_id = new ArrayList<Integer>();
            List<Double> article_quantity = new ArrayList<Double>();
            List<Livraison> livraison_effectuer = new ArrayList<Livraison>();
            for (int i = 0; i < Integer.valueOf(countArticle.trim()); i++) {
                String idarticle = request.getParameter("article"+i) ;
                String quantite = request.getParameter("quantite"+i) ;
                article_id.add(Integer.valueOf(idarticle.trim())) ;
                article_quantity.add(Double.valueOf(quantite.trim())) ;
            }
            if(servicestock.VerifyStockAvailbl(article_id, article_quantity, fournisseur.getId_fournisseur()) == true){
                for (int i = 0; i < article_id.size(); i++) {
                    int article_id_ = (int) article_id.get(i) ;
                    double quantity = (double) article_quantity.get(i) ;
                    Date livraison_date = Date.valueOf(date_livraison.trim()) ;
                    Date commande = Date.valueOf(Datebandecommande.trim()) ;
                    livraison_effectuer.add(livraison_service.Saving(new Livraison(livreur, article_id_, quantity, livraison_date, commande, fournisseur.getId_fournisseur())) ) ;
                }  
                List<Stock> stock_new = servicestock.UpdateAllStock(article_id, article_quantity, fournisseur.getId_fournisseur()) ; 
            }
        } catch (Exception e) {
            ObjectMapper objectMapper = new ObjectMapper();
            String json = objectMapper.writeValueAsString(new Retour(505, e.getMessage()));
            e.printStackTrace();
            return  json;
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(new Retour(200, "sucessful"));
        return  json;
    }
}
