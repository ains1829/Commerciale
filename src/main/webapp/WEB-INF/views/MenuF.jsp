<%@ page import="com.example.commerciale.models.Fournisseur" %>
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
                Fournisseur fournisseur = (Fournisseur) session.getAttribute("aboutfournisseur") ;
            %>
            <span><%=fournisseur.getNom()%></span> 
        </div>
        <div class="content-menu">
            <span> 
                <a href="/main/getstock">Stock</a>
            </span>
            <span> 
                <a href="/main/bandecommandeF">Bande Commande</a>
            </span>
            <span> 
                <a href="/main/loginfournisseur">Se Deconnecter</a>
            </span>
        </div>
    </div>
</body>
</html>