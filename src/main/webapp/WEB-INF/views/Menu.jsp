<%@ page import="com.example.commerciale.models.Membre" %>
<%@ page import="javax.servlet.*" %>
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
            <span><a href="/main/notification">Notification</a></span>
            <span><a href="">Proformat</a></span>
            <span><a href="/main/commande">Bandecommande</a></span>
            <span><a href="/main/maPage">Se Deconnecter</a></span>
        </div>
    </div>
</body>
</html>