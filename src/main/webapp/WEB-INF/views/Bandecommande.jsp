<%@page import = "java.util.List" %>
<%@page import = "com.example.commerciale.service.BandeDetail"%>
<%@page import = "com.example.commerciale.models.Bandecommandedetail"%>
<%@page import="javax.servlet.*" %>
<%@page import="java.sql.Date" %>
<%@page import="com.example.commerciale.service.ServiceFournisseur"%>
<%@page import="com.example.commerciale.models.Fournisseur"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bande Commande</title>
    <link rel="stylesheet" href="/css/commande.css">
</head>
<body>
    <div class="container-page">
        <%@ include file = "Menu.jsp"  %> 
        <%
            BandeDetail details = (BandeDetail) request.getAttribute("bande") ;
            ServiceFournisseur servicefounisseur = (ServiceFournisseur) request.getAttribute("fournisseur");
        %>
        <%
            List<Date> alldates = details.all_date() ;
            List<Integer> fournisseur = details.all_fournisseur() ;
        %>
        <div class="content-commande">
            <%
                for(int i = 0; i < alldates.size(); i++){
                    for(int j = 0; j < fournisseur.size(); j++){ 
                        if(details.fournisseur_thisDate(fournisseur.get(j) , alldates.get(i)) == true){
                            Fournisseur fournisseur_article = servicefounisseur.getFournisseur(fournisseur.get(j)) ;
                        %>
                            <div class="commande">
                                <span class="date">Date  : <%=alldates.get(i)%></span>
                                <span class="fournisseur">Fournisseur : <%=fournisseur_article.getNom()%></span>
                                <span class="manager">Manager :  <%=fournisseur_article.getManager()%></span>
                                <span class="manager">Email :  <%=fournisseur_article.getEmail()%></span>
                                <span class="manager">Addresse :  <%=fournisseur_article.getAdresse()%></span>
                                <table>
                                    <tr>
                                        <th>Article</th>
                                        <th>Quantite</th>
                                        <th>Prix HT</th>
                                        <th>Tva</th>
                                        <th>TTC</th>
                                    </tr>
                                    <%
                                        List<Bandecommandedetail> mycommande = details.MyCommande(fournisseur.get(j) , alldates.get(i)) ;
                                        for(int u = 0; u < mycommande.size() ; u++){ %>
                                            <tr>
                                                <td><%=details.getNameArticle(mycommande.get(u).getId_article())%></td>
                                                <td><%=mycommande.get(u).getQuantite() %></td>
                                                <td><%=mycommande.get(u).getPrixht() %> ar</td>
                                                <td><%=mycommande.get(u).getTva() %> %</td>
                                                <td><%=details.TTC(mycommande.get(u).getTva() , mycommande.get(u).getPrixht())  %> ar</td>
                                            </tr>
                                        <%}
                                    %>
                                </table>
                                <span class="somme"> Somme total : <%=details.SommeMyCommande(fournisseur.get(j) , alldates.get(i)) %> ar</span>
                                <span class="arreter"> Arreter a la somme de : <%=details.generateLetter(details.SommeMyCommande(fournisseur.get(j) , alldates.get(i)))%> ariary </span>
                            </div>
                        <%}
                    }
                } 
            %>
        </div>
    </div>
</body>
</html>