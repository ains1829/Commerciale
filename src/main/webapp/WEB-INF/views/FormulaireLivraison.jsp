<%@page import="java.sql.Date" %>
<%@page import="com.example.commerciale.models.Article"%>
<%@page import = "java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/livraison.css">
    <script src="/js/livraison.js" defer></script>
    <title>livraion</title>
</head>
<body>
    <div class="container-page">
        <%@include file = "MenuF.jsp" %>
        <%
            List<Article> articles = (List<Article>) request.getAttribute("articles");
            Date datebandecommande = (Date) request.getAttribute("datebandecommande") ;
        %>
        <div class="content-form-livraison">
            <form id="formulaire">
                <input type="hidden" name="datebandecommande" value="<%=datebandecommande%>">
                <div>
                    <label>Livreur</label>
                    <input type="text" name="livreur" id="">
                </div>
                <div>
                    <label for="">Date livraison</label>
                    <input type="date" name="date" id="">
                </div>
                <div class="article">
                    <div class="article-content">
                        <label>Artcile</label>
                        <select name="article0">
                            <%
                                for(int i = 0 ; i<articles.size() ; i++){%>
                                    <option value="<%=articles.get(i).getId_article()%>"><%=articles.get(i).getNom()%></option>
                                <%}
                            %>
                        </select>
                    </div>
                    <div class="article-quantity">
                        <label for="">Quantite</label>
                        <input type="text" name="quantite0">
                    </div>
                </div>
                <div class="add-remove">
                    <span class="ajouter">Ajouter</span>
                </div>
                <div class="inputsubmit">
                    <input type="submit" value="Effectuer">
                </div>
            </form>
        </div>
    </div>
</body>
</html>