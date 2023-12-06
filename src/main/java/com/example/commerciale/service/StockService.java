package com.example.commerciale.service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.commerciale.models.Stock;
import com.example.commerciale.repository.StockRepository;
@Service
public class StockService {
    @Autowired 
    private StockRepository stockdao ;
    public List<Stock> getStockList() {
        return stockdao.findAll();
    }
    public List<Stock> getStockFournisseur(Integer fournisseur){
        List<Stock> stocks = getStockList() ;
        List<Stock> stock_new = new ArrayList<Stock>();
        for (int i = 0; i < stocks.size(); i++) {
            if(stocks.get(i).getId_fournisseur() == fournisseur){
                stock_new.add(stocks.get(i)) ;
            }
        }
        return stock_new ;
    }
    public boolean articleIsExist(Integer idarticle , int id_fournisseur){
        List<Stock> stocks =  getStockList() ;
        for(int i = 0; i < stocks.size(); i++){
            if((stocks.get(i).getId_article() == idarticle) && (stocks.get(i).getId_fournisseur() == id_fournisseur)){
                return true ;
            }
        }
        return false ;
    }
    public double SumAllQuantite(Integer idarticle , int id_fournisseur){
        List<Stock> stocks =  getStockList() ;
        double quantite = 0.0 ;
        for(int i = 0; i < stocks.size(); i++){
            if((stocks.get(i).getId_article() == idarticle) && (stocks.get(i).getId_fournisseur() == id_fournisseur)){
                quantite += stocks.get(i).getQuantite() ;
            }
        }
        return quantite ;
    }
    public boolean VerifyAllArticle(List<Integer> article , int id_fournisseur) throws Exception{
        for (int i = 0; i < article.size(); i++) {
            if(articleIsExist(article.get(i), id_fournisseur) == false){
                throw new Exception("votre stock ne contient pas cette article") ;
            }
        }
        return true ;
    }
    public boolean VerifyStockAvailbl(List<Integer> article , List<Double> quantite , int id_fournisseur) throws Exception{
        if(VerifyAllArticle(article , id_fournisseur) == true){
            for(int i = 0; i < article.size() ; i++){
                if(SumAllQuantite(article.get(i), id_fournisseur) < quantite.get(i)){
                    throw new Exception("votre stock est insuffisant") ;
                }
            }
            return true ;
        }
        return false ;
    }
    public Stock UpdateStock(Integer id_stock , double quantite){
        Stock stock = stockdao.getById(id_stock) ;
        stock.setQuantite(quantite);
        System.out.println(stock);
        return stockdao.save(stock) ;
    }
    public List<Stock> UpdateAllStock(List<Integer> article , List<Double> quantite , int id_fournisseur){
        List<Stock> stock = getStockList() ;
        List<Stock> stock_new = new ArrayList<Stock>() ;
            for (int j = 0; j < article.size(); j++) {
                double quantite_want = quantite.get(j) ;
                int compteur = 0 ;
                while(quantite_want!=0){
                    if(stock.get(compteur).getId_article() == article.get(j)){
                        if(stock.get(compteur).getQuantite() < quantite_want){
                            quantite_want = quantite_want - stock.get(compteur).getQuantite() ;
                            stock_new.add(UpdateStock(stock.get(compteur).getId_stock(), 0)) ;
                        }else{
                            double quantite_stock = stock.get(compteur).getQuantite() - quantite_want ;
                            stock_new.add(UpdateStock(stock.get(compteur).getId_stock(), quantite_stock)) ;
                            quantite_want = 0 ;
                        }
                    }
                    compteur ++ ;
                }
            }
        return stock_new ;
    }
}
