<%@page import = "com.example.commerciale.service.GroupementnotifService" %>
<%@page import = "java.util.List" %>
<%@page import = "java.sql.Date" %>
<%@page import = "com.example.commerciale.service.BandeDetail"%>
<%@page import = "com.example.commerciale.service.ArticleService"%>
<%@ page import="com.example.commerciale.models.Besoinmain" %>
<%@ page import="com.example.commerciale.models.Article" %>
<%@ page import="javax.servlet.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/detailGroupement.css">
    <title>About</title>
</head>
<body>
    <div class="container-page">
        <%@ include file = "Menu.jsp"  %> 
        <%
            List<Besoinmain> getList = (List<Besoinmain>) request.getAttribute("about") ; 
            ArticleService article = (ArticleService) request.getAttribute("article") ;
            GroupementnotifService service_notif = (GroupementnotifService) request.getAttribute("notif");
        %>
        <div class="content-about">
            <span>Detail de votre choix </span>
            <table>
                <tr>
                    <th>Article</th>
                    <th>Quantite</th>
                    <th>Date</th>
                    <th></th>
                </tr>
                <%
                    for(int i = 0 ; i<getList.size() ; i++){ 
                        Article getArticle = article.getArticleById(getList.get(i).getId_article()) ; 
                    %>
                        <tr>
                            <td><%=getArticle.getNom() %></td>
                            <td><%=getList.get(i).getQuantite() %> <%=getArticle.getUnite() %></td>
                            <td><%=getList.get(i).getDatebesoin() %></td>
                            <td><a href="/main/detail_groupement?dates=<%=getList.get(i).getDatebesoin()%>&idarticle=<%=getList.get(i).getId_article()%>">composition</a></td>
                        </tr>
                    <%}
                %>
            </table>
            <div class="content-href">
                <%
                    if(service_notif.DateisExist(getList.get(0).getDatebesoin())){ %>
                        <a class="encours">
                            <div>
                                encours                  
                            </div>
                        </a>
                    <% }else{ %> 
                        <a href="/main/insertnotif?dates=<%=getList.get(0).getDatebesoin()%>">
                            <div>
                                Give Bande                  
                            </div>
                        </a>
                    <%}%>
                    <a class="email" href="/main/send?dates=<%=getList.get(0).getDatebesoin()%>">send email</a>
            </div>
        </div>
    </div>
</body>
</html>