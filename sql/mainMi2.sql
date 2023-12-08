create database commerciale;
CREATE TABLE Departement(
   Id_Departement SERIAL,
   nom VARCHAR(50) ,
   PRIMARY KEY(Id_Departement)
);
CREATE TABLE profil(
    Id_profil SERIAL PRIMARY KEY ,
    name_profil VARCHAR(50) 
);
CREATE TABLE membre(
   Id_membre SERIAL,
   nom VARCHAR(50)  NOT NULL,
   email VARCHAR(50) ,
   dtn DATE,
   mdp VARCHAR(50) ,
   Id_Departement INTEGER NOT NULL,
   PRIMARY KEY(Id_membre),
   FOREIGN KEY(Id_Departement) REFERENCES Departement(Id_Departement)
);
alter table membre add column profil int references profil (Id_profil) ;
CREATE TABLE fournisseur(
   Id_fournisseur SERIAL,
   nom VARCHAR(50) ,
   manager VARCHAR(50) ,
   email VARCHAR(50) ,
   adresse VARCHAR(50) ,
   PRIMARY KEY(Id_fournisseur)
);

CREATE TABLE categorie(
   Id_categorie SERIAL,
   nomcategorie VARCHAR(50) ,
   PRIMARY KEY(Id_categorie)
);
CREATE TABLE article(
   Id_article SERIAL,
   nom VARCHAR(50) ,
   unite VARCHAR(50) ,
   Id_categorie INTEGER NOT NULL,
   PRIMARY KEY(Id_article),
   FOREIGN KEY(Id_categorie) REFERENCES categorie(Id_categorie)
);
alter table article add column modegestion VARCHAR(20);

CREATE TABLE stock(
   Id_stock SERIAL,
   quantite DOUBLE PRECISION,
   datestock DATE,
   Id_fournisseur INTEGER NOT NULL,
   Id_article INTEGER NOT NULL,
   PRIMARY KEY(Id_stock),
   FOREIGN KEY(Id_fournisseur) REFERENCES fournisseur(Id_fournisseur),
   FOREIGN KEY(Id_article) REFERENCES article(Id_article)
);

CREATE TABLE articleprix(
   Id_articleprix SERIAL,
   prixht DOUBLE PRECISION,
   dateprix DATE,
   tva DOUBLE PRECISION,
   Id_fournisseur INTEGER NOT NULL,
   Id_article INTEGER NOT NULL,
   PRIMARY KEY(Id_articleprix),
   FOREIGN KEY(Id_fournisseur) REFERENCES fournisseur(Id_fournisseur),
   FOREIGN KEY(Id_article) REFERENCES article(Id_article)
);
CREATE TABLE proformatmere(
   Id_proformatmere SERIAL,
   dateproformat DATE,
   nomproformat VARCHAR(100),
   Id_fournisseur INTEGER NOT NULL ,
   PRIMARY KEY(Id_proformatmere),
   FOREIGN KEY(Id_fournisseur) REFERENCES fournisseur(Id_fournisseur)
);
CREATE TABLE proformat(
   Id_proformat SERIAL,
   Id_proformatmere INTEGER NOT NULL,
   quantite DOUBLE PRECISION,
   prixunitaire DOUBLE PRECISION,
   tva DOUBLE PRECISION,
   Id_article INTEGER NOT NULL,
   PRIMARY KEY(Id_proformat),
   FOREIGN KEY (Id_proformatmere) REFERENCES proformatmere(Id_proformatmere),
   FOREIGN KEY(Id_article) REFERENCES article(Id_article)
);

CREATE TABLE besoin(
   Id_besoin SERIAL,
   datebesoin DATE,
   quantite DOUBLE PRECISION,
   Id_Departement INTEGER NOT NULL,
   Id_article INTEGER NOT NULL,
   PRIMARY KEY(Id_besoin),
   FOREIGN KEY(Id_Departement) REFERENCES Departement(Id_Departement),
   FOREIGN KEY(Id_article) REFERENCES article(Id_article)
);
alter table besoin add column havebesoin boolean default false;

CREATE TABLE BandeCommandeDetail(
    Id_bande_commande SERIAL PRIMARY KEY,
    quantite DOUBLE PRECISION ,
    Id_article INTEGER NOT NULL REFERENCES Article(Id_article) ,
    Id_fournisseur INTEGER NOT NULL REFERENCES Fournisseur(Id_fournisseur) ,
    prixht DOUBLE PRECISION ,
    tva DOUBLE PRECISION , 
    dateproformat date ,
    dateBandecommade date 
) ;
CREATE TABLE Livraison (
   idlivraison SERIAL PRIMARY KEY ,
   name_livreur VARCHAR(55) not NULL ,
   id_article int references article (id_article) ,
   quantite float ,
   datelivraison date
);
------RECEPTION DU LIVRAISON DE L'ARTICLE QUI A ETE COMMANDE ( PAR COMMANDE )
CREATE TABLE BandeReception(
   idBandeReception  SERIAL PRIMARY KEY ,
   Id_fournisseur int references fournisseur (id_fournisseur) ,
   datelivraison date ,
   validationsAchat int default 0,
   validationsF int default 0,
   datebandereception date,
   dateBandecommade date
);
--alter table BandeReception add column dateBandecommade date
CREATE TABLE Receptiondetail(
   IdReceptiondetail SERIAL PRIMARY KEY ,
   idBandeReception int references BandeReception (idBandeReception) ,
   id_article int references article (id_article) ,
   quantite float
);
------BON ENTREE VENANT DU BON DE RECEPTION
CREATE TABLE magasin(
   idmagasin SERIAL PRIMARY KEY,
   nommagasin VARCHAR(30),
   adresse VARCHAR(50)
);

CREATE TABLE bonentre(
   idbonentre SERIAL PRIMARY KEY,
   idmagasin int references magasin(idmagasin),
   IdReceptiondetail int references Receptiondetail(IdReceptiondetail),
   quantiteentre float,
   dateentre date
);
------BON DE SORTIE ( SORTIE DANS UNE ENTREE )
CREATE TABLE bonsortie(
   idbonsortie SERIAL PRIMARY KEY,
   idbonentre int references bonentre(idbonentre),
   quantitesortie float,
   datesortie date
);

select tab.idbonentre,tab.idmagasin,tab.quantiteentre,tab.totalsortie,datefin from (
   select be.idbonentre,be.idmagasin,be.quantiteentre,sum(bo.quantitesortie) as totalsortie
   from bonentre as be join bonsortie as bo on be.idbonentre=bo.idbonentre
   where be.dateentre<=datefin and bo.datesortie<=datefin
   group by be.idbonentre,be.idmagasin,be.quantiteentre
) as tab 
---idbandereception | id_fournisseur | id_article | nomarticle | datereception | quantiterecu
create or REPLACE VIEW detailarticlerecu_view as
select 
   brd.idBandeReception,
   br.Id_fournisseur,
   brd.Id_article,
   a.nom as nomarticle,
   br.datebandereception as datereception,
   brd.quantite as quantiterecu
   from Receptiondetail as brd
   join BandeReception as br on (br.idBandeReception=brd.idBandeReception)
   join article as a on (brd.id_article=a.Id_article)
   where br.validationsAchat=10 and br.validationsF=10
   order by br.Id_fournisseur ASC;
;
--drop VIEW detailarticlerecu_view;

------idbonentre | id_article | prixht | tva | prixttc | quantiteentre | dateentre
create or REPLACE view entreedetail_view as
   select 
   be.idbonentre,
   rd.id_article,
   bcd.prixht,
   bcd.tva,
   (bcd.prixht+(bcd.prixht*bcd.tva/100)) as prixttc,
   be.quantiteentre,
   be.dateentre 
   from bonentre as be 
   join Receptiondetail as rd on be.IdReceptiondetail=rd.IdReceptiondetail
   join BandeReception as br on rd.idbandereception=br.idbandereception
   join BandeCommandeDetail as bcd on (bcd.Id_article=rd.id_article and bcd.dateBandecommade=br.dateBandecommade)
   where br.validationsAchat=10 and br.validationsF=10

--------  idbonentre | id_article | idmagasin | quantiteentre | totalsortie | dateentre | ladate
create or replace function etatquantiteentre_f(datefin date)
    returns table (idbonentre int ,id_article int,idmagasin int ,quantiteentre float, totalsortie float,dateentre date,ladate date,prixht float,tva float,prixttc float) As $$
    BEGIN
    return query
      select tab.idbonentre,tab.id_article,tab.idmagasin,tab.quantiteentre,sum( tab.totalsortie) as totalsortie ,tab.dateentre,datefin,tab.prixht,tab.tva,tab.prixttc from (
         
         select be.idbonentre,rd.id_article,be.idmagasin,be.quantiteentre,be.dateentre,sum(bo.quantitesortie) as totalsortie,ed.prixht,ed.tva,ed.prixttc
         from bonentre as be 
         join bonsortie as bo on be.idbonentre=bo.idbonentre
         join Receptiondetail as rd on (rd.IdReceptiondetail=be.IdReceptiondetail)
         join entreedetail_view as ed on  (ed.idbonentre=be.idbonentre)
         where be.dateentre<=datefin and bo.datesortie<=datefin and ed.dateentre<=datefin
         group by be.idbonentre,rd.id_article,be.idmagasin,be.quantiteentre,be.dateentre,ed.prixht,ed.tva,ed.prixttc
         
         union

         select be.idbonentre,rd.id_article,be.idmagasin,be.quantiteentre,be.dateentre,0 as totalsortie,ed.prixht,ed.tva,ed.prixttc
         from bonentre as be
         join Receptiondetail as rd on (rd.IdReceptiondetail=be.IdReceptiondetail)
         join entreedetail_view as ed on  (ed.idbonentre=be.idbonentre)
         where be.dateentre<=datefin and ed.dateentre<=datefin
         group by be.idbonentre,rd.id_article,be.idmagasin,be.quantiteentre,be.dateentre,ed.prixht,ed.tva,ed.prixttc

      ) as tab group by  tab.idbonentre,tab.id_article,tab.idmagasin,tab.quantiteentre,tab.dateentre,datefin,tab.prixht,tab.tva,tab.prixttc ;
    end;
    $$ language plpgsql
--------  id_article | nomarticle | idmagasin | nommagasin | entrees | sorties | ladate
create or replace function etatquantitearticle_f(datefin date)
    returns table (id_article int,nomarticle VARCHAR,idmagasin int ,nommagasin VARCHAR,entrees float, sorties float,ladate date) As $$
    BEGIN
    return query
      select ee_f.id_article,a.nom as nomarticle,ee_f.idmagasin,m.nommagasin,sum(ee_f.quantiteentre) as entrees,sum(totalsortie) as sorties,datefin 
      from etatquantiteentre_f(datefin) as ee_f
      join article as a on a.id_article=ee_f.id_article
      join magasin as m on m.idmagasin=ee_f.idmagasin
      group by ee_f.id_article,a.nom,ee_f.idmagasin,m.nommagasin;
   end;
    $$ language plpgsql
---- idbonsortie | idbonentre | idmagasin | id_article | quantitesortie | datesortie
create or replace view bonsortie_view as 
   select bo.idbonsortie,bo.idbonentre,be.idmagasin,rd.id_article,bo.quantitesortie,bo.datesortie
   from bonsortie as bo
   join bonentre as be on bo.idbonentre=be.idbonentre
   join Receptiondetail as rd on rd.IdReceptiondetail=be.IdReceptiondetail;

--idbonsortie | idbonentre | idmagasin | id_article | quantitesortie | datesortie
create or replace view lastbonsortie_view as 
   select bo_v.*
   from bonsortie_view as bo_v
   join 
   (select idmagasin, id_article, quantitesortie, max(datesortie) as lastdate 
   from bonsortie_view group by idmagasin, id_article, quantitesortie) as tab
   on (tab.idmagasin=bo_v.idmagasin and tab.id_article=bo_v.id_article and tab.lastdate=bo_v.datesortie)
--drop function etatquantitearticle_f;
--drop function etatquantiteentre_f;
------fonction de calcule du valeur du stock

