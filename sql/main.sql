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
alter table fournisseur add column password VARCHAR(55) default 'password' ;
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
    Id_proformatmere SERIAL PRIMARY KEY ,
    dateproformat DATE,
    nomproformatmere VARCHAR(100)
) ;

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