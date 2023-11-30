<%@page import = "com.example.commerciale.service.ArticleService" %>
<%@page import = "com.example.commerciale.models.Article" %>
<%@page import = "java.util.List" %>
<%@ page import="javax.servlet.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/besoin.css">
    <title>Besoin</title>
</head>
<body>
    <div class="container-page">
        <%@ include file = "Menu.jsp"  %> 
        <%
            ArticleService service_article = (ArticleService) request.getAttribute("article") ;
            List<Article> articles = service_article.getArticleAll() ;
        %>
        <div class="content-insertion">
            <span class="besoin">Ajouter votre Besoin</span>
            <form action="/main/insertBesoin" method="get">
                <div class="article">
                    <label>Article</label>
                    <select name="article">
                        <%
                            for(int i =  0 ; i< articles.size() ; i++){ %>
                                <option value="<%=articles.get(i).getId_article()%>"><%=articles.get(i).getNom()%></option>
                            <%}
                        %>
                    </select>
                </div>
                <div class="details">
                    <div>
                        <label>Quantite</label>
                        <input type="text" name="quantite" required>
                    </div>
                    <div>
                        <label>Date</label>
                        <input type="date" name="date" required>
                    </div>
                </div>
                <div class="button">
                    <input type="submit" value="Valider">
                </div>
            </form>
        </div>
    </div>
</body>
</html>