<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.example.commerciale.Models.Article" %>
<%@ page import="com.example.commerciale.Models.Fournisseur" %>

<%
    Article[] articles=(Article[])request.getAttribute("articles");
    Fournisseur[] fournisseurs=(Fournisseur[])request.getAttribute("fournisseurs");
%>
    <form id="myForm">
        <h1>Insertion de Pro-format</h1>
        <div>
            <label for="dateproformat">Date Proformat:</label>
            <input type="date" id="dateproformat" name="dateproformat">
        </div>
        <div>
            <label for="nomproformat">Nom Proformat:</label>
            <input type="text" id="nomproformat" name="nomproformat">
        </div>
        <div>
            <label for="Id_fournisseur">Fournisseur :</label>
            <select name="Id_fournisseur" id="Id_fournisseur"><%
                if(fournisseurs!=null){
                        for(Fournisseur fournisseur : fournisseurs){  %> 
                            <option <%="value=\""+fournisseur.getId_fournisseur()+"\"" %> > <%=fournisseur.getNom() %> </option><%
                        } 
                }%>
            </select>
        </div>
        <div id="dynamicFields">
            <!-- Dynamic fields will be added here -->
            <div id="dynamicFields2">
                <label for="Id_article1">Article:</label>
                <select name="Id_article1" id="Id_article1"><%
                    if(articles!=null){
                            for(Article article : articles){  %> 
                                <option <%="value=\""+article.getId_article()+"\"" %> > <%=article.getNom() %> </option><%
                            } 
                    }%>
                </select>
                <label for="quantite1">Quantité:</label>
                <input type="text" id="quantite1" name="quantite1">
                
                <label for="prixunitaire1">Prix Unitaire:</label>
                <input type="text" id="prixunitaire1" name="prixunitaire1">
                
                <label for="tva1">TVA:</label>
                <input type="text" id="tva1" name="tva1">
            </div>
        </div>
        </br>
        <button class="buttonAdd" type="button" onclick="addFields()">Ajouter</button>
        <button class="buttonDel" type="button" onclick="removeFields()">Effacer</button></br></br>
        <button class="buttonOk" type="button" onclick="submitForm()">Envoyer</button></br>
    </form>