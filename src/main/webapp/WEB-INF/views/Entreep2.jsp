<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import = "com.example.commerciale.models.MagasinMi" %>
<%@page import = "com.example.commerciale.models.DetailArticleRecu" %>
<%@ page import="javax.servlet.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/besoin.css">
    <title>Besoin</title>
</head>
<%
DetailArticleRecu[] detailArticleRecus=(DetailArticleRecu[])request.getAttribute("detailArticleRecus");
MagasinMi magasinMi=(MagasinMi)request.getAttribute("magasinmi");
String date="";
String magasinname="";
String idmagasin="0";
String idfournisseur="0";
if(detailArticleRecus!=null){
    date=detailArticleRecus[0].getDatereception().toString();
    idfournisseur=detailArticleRecus[0].getId_fournisseur();
}
if(magasinMi!=null){
    magasinname=magasinMi.getNommagasin();
    idmagasin=magasinMi.getIdmagasin()+"";
}
%>
<body>
    <div class="container-page">
        <%@ include file = "Menu.jsp"  %> 
        <div class="content-insertion">
            <span class="besoin">Ajout bon entrée</span>
            <form action="/mi/insertbonentre" method="get">
                <p><strong>Magasin: </strong><%=magasinname%></p>
                <input type="hidden" name="idmagasin" value="<%=idmagasin %>">
                <p><strong>Date de reception le: </strong><%=date%></p>
                <input type="hidden" name="datereception" value="<%=date%>">
                <input type="hidden" name="idfournisseur" value="<%=fournisseur%>">
                <div class="article">
                    <label>Date entree :</label>
                    <input type="date" name="dateentre">
                </div>
                <%
                if(detailArticleRecus!=null){ %>
                    <input type="hidden" name="taille" value="<%=detailArticleRecus.length %>"><%
                    int i=1;
                    for(DetailArticleRecu detailArticleRecu: detailArticleRecus){ %>
                        <input type="hidden" name="idbandereception<%=i%>" value="<%=detailArticleRecu.getIdbandereception() %>">
                        <p><strong>Article :</strong><%=detailArticleRecu.getNomarticle()%> et <strong>Quantite recu: </strong><%=detailArticleRecu.getQuantiterecu() %></p>
                        <input type="hidden" name="idarticle<%=i%>" value="<%=detailArticleRecu.getId_article() %>">
                        <div class="article">
                            <label>Quantite entree :</label>
                            <input type="text" name="quantiteentre<%=i%>">
                        </div>
                        <%
                        i++;
                    }
                }
                %>
                <div class="button">
                    <input type="submit" value="Suivant">
                </div>
            </form>
        </div>
    </div>
</body>
</html>