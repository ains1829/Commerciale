<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.example.demo.Models.*" %>
<body>
   <div>
        <div class="form-container">
            <h1>Stock a sortir</h1>
        <form method="post" action="/outstock" class="custom-form">
            <div class="form-group">
                <%
                Motherobj[] articlesOb=(Motherobj[])request.getAttribute("articlesOb");
                Article article=null;
                %>
                <label for="idarticle">Article :</label>
                <select name="idarticle" id="idarticle"><%
                if(articlesOb!=null){
                        for(Motherobj articleob : articlesOb){ 
                            article=(Article)articleob; %> 
                            <option <% out.println("value=\""+article.getIdarticle()+"\""); %> > <% out.println(article.getNomarticle()); %> </option><%
                        } 
                }%>
                </select>
            </div>
            <div class="form-group">
                <%
                Motherobj[] magasinsOb=(Motherobj[])request.getAttribute("magasinsOb");
                Magasin magasin=null;
                %>
                <label for="idmagasin">magasin :</label>
                <select name="idmagasin" id="idmagasin"><%
                if(magasinsOb!=null){
                    for(Motherobj magasinob : magasinsOb){ 
                        magasin=(Magasin)magasinob;  %> 
                        <option <% out.println("value=\""+magasin.getIdmagasin()+"\""); %> > <% out.println(magasin.getNommagasin()); %> </option><%
                    } 
                }%>
                </select>
            </div>
            <div class="form-group">
                <label for="quantite">Quantite :</label>
                <input name="quantiteout" type="text" id="quantite" />
            </div>
            <div class="form-group">
                <label for="dateout">Date de sorti :</label>
                <input name="dateout" type="date" id="dateout" />
            </div>

            <div class="form-group">
                <input type="submit" value="Valider" id="submit-btn" />
            </div>
        </form>
        <p style="color:red;"><%
            if(request.getAttribute("erreur")!=null){
                out.println(request.getAttribute("erreur"));
            }
            %>
        </p>
        </div>
        
   </div>