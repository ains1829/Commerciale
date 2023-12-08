package com.example.commerciale.controller;

import java.time.LocalTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.commerciale.models.ArticleMi;
import com.example.commerciale.models.BonentreMi;
import com.example.commerciale.models.DetailArticleRecu;
import com.example.commerciale.models.MagasinMi;
import com.example.commerciale.models.ProformatMi;
import com.example.commerciale.models.ProformatDetail;
import com.example.commerciale.models.ProformatmereMi;
import com.example.commerciale.models.ProformatmereDetail;
import com.example.commerciale.bodyrequest.Proformatsbody;
import com.example.commerciale.service.ArticleMiService;
import com.example.commerciale.service.FournisseurMiService;
import com.example.commerciale.service.ProformatMiService ;
import com.example.commerciale.service.ProformatmereMiService;
import com.example.commerciale.service.MagasinMiService;
import com.example.commerciale.service.DetailArticleRecuService;
import com.example.commerciale.service.DetailEntreeService;
import com.example.commerciale.service.BonentreMiService;
import com.example.commerciale.service.BonsortieMiService;
import com.example.commerciale.service.DetailArticleEntreService;

@Controller // Utiliser @Controller au lieu de @RestController
@RequestMapping("/mi")
public class Micontrolleur {

    @Autowired
    private ArticleMiService articleService;
    @Autowired
    private FournisseurMiService fournisseurService;
    @Autowired
    private ProformatMiService proformatService;
    @Autowired
    private ProformatmereMiService proformatmereService;
    @Autowired
    private MagasinMiService magasinService;
    @Autowired
    private DetailArticleRecuService detailArticleRecuService;
    @Autowired
    private BonentreMiService bonentreMiService;
    @Autowired
    private BonsortieMiService bonsortieMiService;
    @Autowired
    private DetailArticleEntreService detailArticleEntreService;
    @Autowired
    private DetailEntreeService detailEntreeService;
    @GetMapping("/")
    public String root(HttpServletRequest request,@RequestParam(name = "erreur", defaultValue = "") String erreur) {       
        request.setAttribute("articles",articleService.getTabAllArticles());
        request.setAttribute("fournisseurs",fournisseurService.getTabAllFournisseurs());
        request.setAttribute("erreur", erreur);
        System.out.println("--------------->>>>"+erreur);
        request.setAttribute("content", "proformatform.jsp");
        return "template"; 
    }
    @PostMapping("/saveproformats")
    public String savedataproformat(@RequestBody Proformatsbody proformatsbody,HttpServletRequest request){
        System.out.println("Tooooooongaaaaaaaaaa");
        String erreur="";
        try{
            int nbchecked=0;
            if(proformatsbody.getProformatmerebody()!=null ){   nbchecked++;    }
            if(proformatsbody.getProformatbodies()!=null ){ nbchecked++;    }
            if(nbchecked==2){
                System.out.println("date:"+proformatsbody.getProformatmerebody().getDateproformat()+" fournisseur:"+proformatsbody.getProformatmerebody().getId_fournisseur()+" nom:"+proformatsbody.getProformatmerebody().getNomproformat());
                ProformatmereMi proformatmere=new ProformatmereMi("0", proformatsbody.getProformatmerebody().getDateproformat(), proformatsbody.getProformatmerebody().getNomproformat(), proformatsbody.getProformatmerebody().getId_fournisseur());
                ProformatMi[] proformats=new ProformatMi[proformatsbody.getProformatbodies().size()];
                for(int i=0;i<proformatsbody.getProformatbodies().size();i++){
                    System.out.println("article:"+proformatsbody.getProformatbodies().get(i).getId_article()+" prix:"+proformatsbody.getProformatbodies().get(i).getPrixunitaire()+" quantite:"+proformatsbody.getProformatbodies().get(i).getQuantite()+" tva:"+proformatsbody.getProformatbodies().get(i).getTva());
                    proformats[i]=new ProformatMi("0","0",proformatsbody.getProformatbodies().get(i).getQuantite(),proformatsbody.getProformatbodies().get(i).getPrixunitaire(),proformatsbody.getProformatbodies().get(i).getTva(),proformatsbody.getProformatbodies().get(i).getId_article());
                }
                proformatmere.insererProformatmereAndAllProformat(proformatService, proformatmereService, proformats);
            }
        }catch(Exception ex){
            ex.printStackTrace();
            erreur=ex.getMessage();
            System.out.println("----------->"+erreur);
        }
        //request.setAttribute("", null);
        return "redirect:/?erreur="+erreur;
    }
    @PostMapping("/getArticles")
    public ResponseEntity<?> getArticles() {
        return ResponseEntity.ok(articleService.getAllArticles());
    }
    @GetMapping("/voirproformatmeres")
    public String voirproformatmere(HttpServletRequest request){
        ProformatmereDetail[] proformatmereDetails=new ProformatmereDetail().getAllProformatDetail(proformatmereService, fournisseurService);
        if(proformatmereDetails!=null){
            System.out.println(proformatmereDetails.length);
        }
        request.setAttribute("proformatmereDetails", proformatmereDetails);
        request.setAttribute("content", "proformatmeres.jsp");
        return "template";
    }
    @GetMapping("/voidetailByIdproformatmere")
    public String voidetailByIdproformatmere(@RequestParam(name = "Id_proformatmere",defaultValue = "0") String Id_proformatmere ,HttpServletRequest request){
        ProformatDetail[] proformatDetails=new ProformatDetail().getProformatDetailsById_proformatmere(proformatService, articleService, Integer.valueOf(Id_proformatmere));
        request.setAttribute("proformatDetails", proformatDetails);
        request.setAttribute("content", "proformatdetails.jsp");
        return "template";
    }
    @GetMapping("/insertbonentreep1")
    public String insertbonentreep1(@RequestParam(name = "erreur",defaultValue = " ") String erreur,HttpServletRequest request){
        request.setAttribute("magasinMis", magasinService.getTabAllmagasins());
        request.setAttribute("erreur",erreur);
        request.setAttribute("fournisseurs", fournisseurService.getTabAllFournisseurs());
        return "Entreep1";
    }
    @GetMapping("/insertbonentreep2")
    public String insertbonentreep2(
        @RequestParam(name = "idmagasin",defaultValue = "0") String idmagasin,
        @RequestParam(name = "datereception",defaultValue = "") String datereception ,
        @RequestParam(name = "idfournisseur",defaultValue = "0") String idfournisseur ,
        HttpServletRequest request
    ){
       
        try{
            System.out.println("magasin--->"+idmagasin+" datereception-->"+datereception+" idfournisseur-->"+idfournisseur);
            MagasinMi magasinMi=new MagasinMi();
            magasinMi.setIdmagasin(idmagasin);
            magasinMi=magasinMi.getByTheId(magasinService);
            if(magasinMi==null){ throw new Exception("magasin id:"+idmagasin+" invalide"); }
            DetailArticleRecu detailArticleRecu=new DetailArticleRecu();
            detailArticleRecu.setDatereception(datereception);
            detailArticleRecu.setId_fournisseur(idfournisseur);
            DetailArticleRecu[] detailArticleRecus=detailArticleRecu.getDetailArticleRecusOfDaterecepionOfId_fournisseur(detailArticleRecuService);
            if(detailArticleRecus==null){ throw new Exception("aucune article recu le "+datereception); }
            request.setAttribute("magasinmi", magasinMi);
            request.setAttribute("detailArticleRecus", detailArticleRecus);
            return "Entreep2";
        }catch(Exception ex){
            ex.printStackTrace();
            return "redirect:/mi/insertbonentreep1?erreur="+ex.getMessage();
        }
    }

    // idbonentre SERIAL PRIMARY KEY,
    // idmagasin int references magasin(idmagasin),
    // IdReceptiondetail int references Receptiondetail(IdReceptiondetail),
    // quantiteentre float,
    // dateentre date
    @GetMapping("/insertbonentre")
    public String insertbonentre(HttpServletRequest request){
        String idmagasin=request.getParameter("idmagasin")+"";
        String taille=request.getParameter("taille");
        String dateentre=request.getParameter("dateentre")+"";

        String datereception=request.getParameter("datereception")+"";
        String idfournisseur=request.getParameter("idfournisseur")+"";
        try{

            if(taille==null){
                taille="0";
            }
            int size=Integer.valueOf(taille);
            String[] idbandereceptioni=new String[size];
            String[] idarticlei=new String[size];
            String[] quantiteentrei=new String[size];
            for(int i=0;i<size;i++){
                idbandereceptioni[i]=request.getParameter("idbandereception"+(size+1))+"";
                idarticlei[i]=request.getParameter("idarticle"+(size+1))+"";
                quantiteentrei[i]=request.getParameter("quantiteentre"+(size+1))+"";
            }
            BonentreMi bonentreMi=new BonentreMi();
            bonentreMi.insertAll(bonentreMiService,idmagasin,dateentre,idbandereceptioni,quantiteentrei);
            
            return "redirect:/mi/insertbonentreep2?idmagasin="+idmagasin+"&datereception="+datereception+"&idfournisseur="+idfournisseur;
        }catch(Exception ex){
            ex.printStackTrace();
            return "redirect:/mi/insertbonentreep2?idmagasin="+idmagasin+"&datereception="+datereception+"&idfournisseur="+idfournisseur+"&erreur="+ex.getMessage();
        }
    }

    @GetMapping("/tosortir")
    public String tosortir(@RequestParam(name = "erreur",defaultValue = " ") String erreur,HttpServletRequest request){
        request.setAttribute("magasinMis", magasinService.getTabAllmagasins());
        request.setAttribute("articles",articleService.getTabAllArticles());
        request.setAttribute("erreur",erreur);
        return "Sortir";
    }
    
    @GetMapping("/sortirstock")
    public String sortirstock(
        @RequestParam(name = "idmagasin",defaultValue = " ") String idmagasin,
        @RequestParam(name = "idarticle",defaultValue = " ") String idarticle,
        @RequestParam(name = "quantite",defaultValue = " ") String quantite,
        @RequestParam(name = "datesortie",defaultValue = " ") String datesortie,
        @RequestParam(name = "erreur",defaultValue = " ") String erreur,
        HttpServletRequest request
    ){
    try{
        MagasinMi magasinMi=new MagasinMi();
        magasinMi=magasinMi.getByTheId(magasinService);
        if(magasinMi==null){ throw new Exception("Magasin id:"+idmagasin+" invalide"); }
        magasinMi.sortirStock(bonsortieMiService,articleService,detailEntreeService,detailArticleEntreService,idarticle,quantite,datesortie );
    }catch(Exception ex){

    }  
        return "Sortir";
    }
}

