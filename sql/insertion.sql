insert into Departement(nom) values
    ('RH') , ('SECURITY') ,('SERVICE') , ('FINANCE') ;
insert into profil (name_profil) values
    ('DG') , ('Employer');

insert into membre (nom , email , dtn , mdp , Id_Departement, profil) values 
    ('Mirado' , 'Mirado@gmail.com' , '2002-08-10' , 'akondro' , 1 , 2) , 
    ('Kanto' , 'Kanto@gmail.com' , '2002-08-10' , 'voatafo' , 2 , 2) ,
    ('Andy' , 'Andrew@gmail.com' , '2002-08-10' , 'manga' , 4 , 2) ,
    ('Ains' , 'Ains@gmail.com' , '2002-08-10' ,'blill' ,1 , 1) ;

insert into fournisseur(nom , manager , email , adresse) values
    ('JUMBO SCORE' , 'Mamiarivony' , 'Mamiarivony@gmail.com' , 'Ambatobe') ,
    ('SUPER U' , 'Balita' , 'Balita@gmail.com' , 'Analakely') ,
    ('AINS COMPANY' , 'LeBoss' , 'LeBoss@gmail.com' , 'Ankorondrano') ;

insert into categorie (nomcategorie) values 
    ('Bureatique') , ('Scolaire') ;

insert into article (nom , unite , Id_categorie) values 
    ('ordinateur' , 'piece' , 1) ,
    ('Chargeur Ordinateur' , 'piece' , 1) ,
    ('Souris' , 'piece' , 1) ,
    ('Cahier' , 'piece' , 2) ,
    ('Stylo' , 'piece' ,2) ,
    ('Regle' , 'piece' ,2) ;

insert into stock (quantite , datestock , Id_fournisseur , Id_article) values 
    (20 , current_date , 1 , 1) ,
    (20 , current_date , 1 , 2) ,
    (10 , current_date , 2 , 1) ,
    (10 , current_date , 2 , 2) ,
    (10 , current_date , 2 , 3) ,
    (5 , current_date , 3 , 1) ,
    (5 , current_date , 3 , 2) ,
    (5 , current_date , 3 , 3) ,
    (50 , current_date , 3 , 4) ,
    (50 , current_date , 3 , 5) ,
    (50 , current_date , 3 , 6) ;

insert into articleprix (prixht , dateprix , tva , Id_fournisseur , Id_article) values
    ('500000' , current_date ,15,1,1) ,
    ('20000' , current_date ,15,1,2) ,
    ('600000',current_date , 15 , 2 , 1 ),
    ('10000',current_date , 15 , 2 , 2 ),
    ('5000',current_date , 15 , 2 , 3 ),
    ('650000',current_date , 0 , 3 , 1 ),
    ('15000',current_date , 0 , 3 , 2 ),
    ('9000',current_date , 0 , 3 , 3 ),
    ('2000',current_date , 15 , 3 , 4 ),
    ('800',current_date , 15 , 3 , 5 ),
    ('1500',current_date , 15 , 3 , 6 );

insert into besoin (datebesoin , quantite , Id_Departement , Id_article) values 
    (current_date , 35 ,  1 , 1) ,
    (current_date , 40 ,  2 , 1) ,
    (current_date , 50 , 3 , 4) ;

insert into proformatmere (dateproformat , nomproformatmere) values
    (current_date , 'Proformat Jumbo score') ,
    (current_date ,'Proformat Super U') ,
    (current_date ,'Proformat Ains') ;

insert into proformat (Id_proformatmere , quantite , prixunitaire , tva , Id_fournisseur , Id_article) values 
    (1 , 20 , '500000',15,1,1),
    (2 , 10 , '600000' , 15 ,2,1),
    (3 , 5 , '600000' , 0 ,3,1),
    (3,50,'2000',15,3,4);