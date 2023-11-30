<%@page import = "com.example.commerciale.service.GroupementnotifService" %>
<%@page import = "java.util.List" %>
<%@page import = "java.sql.Date" %>
<%@page import = "com.example.commerciale.service.BandeDetail"%>
<%@page import = "com.example.commerciale.service.BesoinTservice"%>
<%@page import = "com.example.commerciale.service.ArticleService"%>
<%@ page import="com.example.commerciale.models.Besoin" %>
<%@ page import="com.example.commerciale.models.Article" %>
<%@ page import="javax.servlet.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/detailGroupement.css">
    <title>Composition</title>
</head>
<body>
    <div class="container-page">
        <%@ include file = "Menu.jsp"  %> 
        <%
            List<Besoin> getList = (List<Besoin>) request.getAttribute("details") ; 
            BesoinTservice getT = (BesoinTservice) request.getAttribute("serviceBesoin") ;
            ArticleService article = (ArticleService) request.getAttribute("article") ;
        %>
        <div class="content-about">
            <span>Composition </span>
            <table>
                <tr>
                    <th>Deapartement</th>
                    <th>Article</th>
                    <th>Quantite</th>
                    <th>Date</th>
                </tr>
                <%
                    for(int i = 0 ; i<getList.size() ; i++){ 
                        Article getArticle = article.getArticleById(getList.get(i).getId_article()) ; 
                    %>
                        <tr>
                            <td><%=getT.getNameDepartement(getList.get(i).getId_departement())%></td>
                            <td><%=getArticle.getNom()%></td>
                            <td><%=getList.get(i).getQuantite() %> <%=getArticle.getUnite() %></td>
                            <td><%=getList.get(i).getDatebesoin() %></td>
                        </tr>
                    <%}
                %>
            </table>
        </div>
    </div>
</body>
</html>