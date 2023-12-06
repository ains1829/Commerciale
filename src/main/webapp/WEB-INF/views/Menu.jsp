<%@ page import="com.example.commerciale.models.Membre" %>
<%@ page import="javax.servlet.*" %>
<%@ page import="java.sql.Date" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/menu.css">
</head>
<body>
    <div class="menu">
        <div class="User">
            <img src="/image/5856-removebg-preview.png" alt="">
            <%
                Membre membrelogin = (Membre) session.getAttribute("aboutmember") ;
            %>
            <span><%=membrelogin.getEmail()%></span> 
        </div>
        <div class="content-menu">
            <span><a href="/main/Besoin">Besoin</a></span>
            <%
                if(membrelogin.getDepartement().compareTo("SERVICE") == 0) { %>
                    <span><a href="/main/groupement">Groupement</a></span>
                <%} 
                if(membrelogin.getDepartement().compareTo("MAGASIN") == 0){ %>
                    <span><a href="/mi/insertbonentreep1">Ajouter entree</a></span>
                    <span><a href="#">Ajouter sortie</a></span>
                    <span><a href="#">Voir Etat Stock</a></span>
                <% }
            %>
            <span><a href="/main/notification">Notification</a></span>
            <span><a href="/mi/">Proformat</a></span>
            <span><a href="/main/commande">Bandecommande</a></span>
            <span><a href="/main/profil">Profil</a></span>
            <span><a href="/main/maPage">Se Deconnecter</a></span>
        </div>
    </div>
</body>
</html>