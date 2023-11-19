<%@page import = "com.example.commerciale.models.Groupementnotif" %>
<%@page import = "java.util.List" %>
<%@page import = "com.example.commerciale.service.BandeDetail"%>
<%@ page import="com.example.commerciale.models.Membre" %>
<%@ page import="javax.servlet.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/notification.css">
    <title>Notification</title>
</head>
<body>
    <div class="container-page">
        <%@ include file = "Menu.jsp"  %> 
        <div class="content-notification">
            <%
                List<Groupementnotif> notif = (List<Groupementnotif>) request.getAttribute("notification") ;
                BandeDetail details = (BandeDetail) request.getAttribute("bande") ;
            %>
            <%
                for(int i = 0 ; i <notif.size() ; i++){ %>
                    <div class="notification">
                        <span class="besoin">Besoin</span>
                        <span class="date">Date : <%= notif.get(i).getDatebesoin() %></span>
                        <span class="somme"> Somme de : <%= details.getMontant(notif.get(i).getDatebesoin()) %> ar </span>
                        <%if((membrelogin.getDepartement().compareTo("FINANCE") == 0) && (membrelogin.getProfil().compareTo("Employer") == 0)) { %>
                            <span><a href="/main/updateetat?idgroupenet=<%=notif.get(i).getIdgroupement() %>"> Approuvez le demande </a></span> 
                        <% } %>
                        <%if((membrelogin.getProfil().compareTo("DG") == 0)) { %>
                            <span><a href="/main/updateetatdg?idgroupenet=<%=notif.get(i).getIdgroupement() %>"> Generer  </a></span> 
                        <%} %>
                    </div>
                <%}
            %>
        </div>
    </div>
</body>
</html>