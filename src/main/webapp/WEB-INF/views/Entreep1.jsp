<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import = "com.example.commerciale.models.MagasinMi" %>
<%@page import = "com.example.commerciale.models.FournisseurMi" %>
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
            <span class="besoin">Ajout bon entrée</span>
            <form action="/mi/insertbonentreep2" method="get">
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
                    <label>Venant du Fournisseur :</label>
                    <select name="idfournisseur">
                        <%
                            FournisseurMi[] fournisseurMis=(FournisseurMi[])request.getAttribute("fournisseurs");
                            if(fournisseurMis!=null){
                                for(FournisseurMi fournisseurMi : fournisseurMis){ %>
                                    <option value="<%=fournisseurMi.getId_fournisseur()%>"><%=fournisseurMi.getNom() %></option>
                                <%}
                            }
                        %>
                    </select>
                </div>
                <div class="article">
                    <label>A la date reception le :</label>
                    <input type="date" name="datereception" required>
                </div>
                <div class="button">
                    <input type="submit" value="Suivant">
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