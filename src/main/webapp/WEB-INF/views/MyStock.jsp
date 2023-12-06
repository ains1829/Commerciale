<%@page import="java.sql.Date" %>
<%@page import="com.example.commerciale.service.ArticleService"%>
<%@page import="com.example.commerciale.models.Article"%>
<%@page import="com.example.commerciale.models.Stock"%>
<%@page import = "java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/stock.css">
    <title>Stock</title>
</head>
<body>
    <div class="container-page">
        <%@include file = "MenuF.jsp" %>
        <div class="content-stock">
            <%
                List<Stock> stock = (List<Stock>) request.getAttribute("stock") ;
                ArticleService articleService = (ArticleService) request.getAttribute("article") ;
            %>
            <%
            for(int i = 0 ; i < stock.size() ; i++){ 
                Article article = articleService.getArticleById(stock.get(i).getId_article()) ;
            %>
                <div class="bloc">
                    <span class="title-article"><%=article.getNom()%></span>
                    <span class="quantite">Quanitite : <%=stock.get(i).getQuantite()%> piece</span>
                    <span class="date"> <%=stock.get(i).getDatestock()%></span>
                </div>
                <%} 
            %>
        </div>
    </div>
</body>
</html>