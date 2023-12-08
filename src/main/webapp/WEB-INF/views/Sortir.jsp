<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import = "com.example.commerciale.models.MagasinMi" %>
<%@page import = "com.example.commerciale.models.ArticleMi" %>
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
        <div class="content-insertion">
            <span class="besoin">Sortir des stocks</span>
            <form action="/mi/sortirstock" method="get">
                <div class="article">
                    <label>Magasin</label>     
                    <select name="idmagasin">
                        <%
                            MagasinMi[] magasinMis=(MagasinMi[])request.getAttribute("magasinMis");
                            if(magasinMis!=null){
                                for(MagasinMi magasin : magasinMis){ %>
                                    <option value="<%=magasin.getIdmagasin()%>"><%=magasin.getNommagasin()%></option>
                                <%}
                            }
                        %>
                    </select>
                </div>
                <div class="article">
                    <label>Magasin</label>
                    <select name="idarticle">
                        <%
                            ArticleMi[] articleMis=(ArticleMi[])request.getAttribute("articles");
                            if(articleMis!=null){
                                for(ArticleMi article : articleMis){ %>
                                    <option value="<%=article.getId_article()%>"><%=article.getNom()%></option>
                                <%}
                            }
                        %>
                    </select>
                </div>
                <div class="article">
                    <label>Quantite à sortir :</label>
                    <input type="text" name="quantite" required>
                </div>
                <div class="article">
                    <label>Date de sortie :</label>
                    <input type="date" name="datesortie" required>
                </div>
                <div class="button">
                    <input type="submit" value="Valider">
                </div>
                <%
                if(request.getAttribute("erreur")!=null){%>
                    <p style="color:red;"><%=request.getAttribute("erreur")%></p><%
                }
                %>
            </form>
        </div>
    </div>
</body>
</html>