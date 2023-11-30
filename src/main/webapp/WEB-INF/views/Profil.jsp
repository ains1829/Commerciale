<%@ page import="com.example.commerciale.models.Membre" %>
<%@ page import="javax.servlet.*" %>
<%@ page import="java.sql.Date" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/profil.css">
    <title>profil</title>
</head>
<body>
    <div class="container-page">
        <%@ include file = "Menu.jsp"  %> 
        <div class="content-profil">
            <div class="bienvenu">
                <span>Cher client Bienvenue dans l'APP-Commerciale</span>
            </div>
            <div class="public">
                <div class="img">
                    <img src="/image/5856-removebg-preview.png" alt="">
                </div>
                <div class="detail">
                    <span>Nom :  <%=membrelogin.getNom()%></span>
                    <span>Email : <%=membrelogin.getEmail()%></span>
                    <span>Date naissance :  <%=membrelogin.getDtn()%></span>
                </div>
            </div>
            <div class="travaille">
                <span class="travaille-title">Travaille</span>
                <span>Profil : <%=membrelogin.getProfil()%> </span>
                <span>Departement : <%=membrelogin.getDepartement()%></span>
            </div>
        </div>
    </div>
</body>
</html>