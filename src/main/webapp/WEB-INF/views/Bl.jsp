<%@page import = "java.util.List" %>
<%@page import = "com.example.commerciale.service.BandeDetail"%>
<%@page import = "com.example.commerciale.models.Bandecommandedetail"%>
<%@page import = "com.example.commerciale.models.Livraison"%>
<%@page import="javax.servlet.*" %>
<%@page import="java.sql.Date" %>
<%@page import="com.example.commerciale.service.ServiceLivraison"%>
<%@page import="com.example.commerciale.service.ArticleService"%>
<%@page import="com.example.commerciale.models.Article"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bande Livraison</title>
    <link rel="stylesheet" href="/css/bl.css">
</head>
<body>
    <div class="container-page">
        <%@ include file = "MenuF.jsp"%> 
        <div class="content-bl">
            <%
                Date dates = (Date) request.getAttribute("datebc");
                ArticleService article = (ArticleService) request.getAttribute("article");
                ServiceLivraison livraison = (ServiceLivraison) request.getAttribute("livraison"); 
                List<Livraison> bandelivraison = livraison.MyLivraison(fournisseur.getId_fournisseur() , dates) ;
            %>
            <%
                if(bandelivraison.size()!=0){%>
                    <div class="content-about-livraison">
                        <div class="fournisseur">
                            <span class="fournisseur">Fournisseur : <%=fournisseur.getNom()%></span>
                            <span class="manager">Manager :  <%=fournisseur.getManager()%></span>
                            <span class="manager">Email :  <%=fournisseur.getEmail()%></span>
                            <span class="manager">Addresse :  <%=fournisseur.getAdresse()%></span>
                        </div>
                        <div class="societe">
                            <span class="fournisseur">Dimpex Madagascar</span>
                            <span class="manager">IT-Universite </span>
                            <span class="manager">It@gmail.com</span>
                            <span class="manager">Andoharanofotsy</span>
                        </div>  
                    </div>
                    <div> Livreur : <%=bandelivraison.get(0).getName_livreur() %> </div>
                    <div> Date bandecommande : <%=bandelivraison.get(0).getDatebandecommande() %> </div>
                    <div> Date Livraison : <%=bandelivraison.get(0).getDatelivraison() %> </div>
                <%}
            %>
            <table>
                <tr class="title-table">
                    <th>Article</th>
                    <th>Quantite</th>
                    <th>unite</th>
                </tr>
                <%
                    for(int i = 0; i < bandelivraison.size(); i++){ 
                        Article getMyarticle = article.getArticleById(bandelivraison.get(i).getId_article()) ;
                    %>
                        <tr>
                            <td><%=getMyarticle.getNom()%></td>
                            <td><%=bandelivraison.get(i).getQuantite()%></td>
                            <td>piece</td>
                        </tr>
                    <%}
                %>
            </table>
        </div>
    </div>
</body>
</html>