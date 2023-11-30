<%@page import = "java.util.List" %>
<%@ page import="javax.servlet.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/groupement.css">
    <title>Groupement</title>
</head>
<body>
    <div class="container-page">
        <%@ include file = "Menu.jsp"  %> 
        <div class="content-date">
            <div class="label">
                <span>Choissisez votre date pour voir les besoin correspondant</span>
            </div>
            <div class="date">
                <%
                    List<Date> datelist = (List<Date>) request.getAttribute("dateG");
                    for(int i =  0; i < datelist.size(); i++){ %>
                        <a href="/main/detail?dates=<%=datelist.get(i)%>">
                            <div><%=datelist.get(i)%></div>
                        </a>
                    <%}
                %>
            </div>
        </div>
    </div>
</body>
</html>