<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.example.commerciale.models.ArticleMi" %>
<%@ page import="com.example.commerciale.models.FournisseurMi" %>

<%
    ArticleMi[] articles=(ArticleMi[])request.getAttribute("articles");
    FournisseurMi[] fournisseurs=(FournisseurMi[])request.getAttribute("fournisseurs");
%>
    <div class="content-format">
        <form id="myForm">
            <div class="first">
                <label for="dateproformat">Date Proformat:</label>
                <input type="date" id="dateproformat" name="dateproformat">
            </div>
            <div class="first">
                <label for="nomproformat">Nom Proformat:</label>
                <input type="text" id="nomproformat" name="nomproformat">
            </div>
            <div class="first">
                <label for="Id_fournisseur">Fournisseur :</label>
                <select name="Id_fournisseur" id="Id_fournisseur"><%
                    if(fournisseurs!=null){
                            for(FournisseurMi fournisseur : fournisseurs){  %> 
                                <option <%="value=\""+fournisseur.getId_fournisseur()+"\"" %> > <%=fournisseur.getNom() %> </option><%
                            } 
                    }%>
                </select>
            </div>
            <div id="dynamicFields">
                <!-- Dynamic fields will be added here -->
                <div id="dynamicFields2">
                    <div>
                        <label for="Id_article1">Article:</label>
                        <select name="Id_article1" id="Id_article1"><%
                            if(articles!=null){
                                    for(ArticleMi article : articles){  %> 
                                        <option <%="value=\""+article.getId_article()+"\"" %> > <%=article.getNom() %> </option><%
                                    } 
                            }%>
                        </select>
                    </div>
                    <div>
                        <label for="quantite1">Quantité:</label>
                        <input type="text" id="quantite1" name="quantite1">
                    </div>
                    <div>
                        <label for="prixunitaire1">Prix Unitaire:</label>
                        <input type="text" id="prixunitaire1" name="prixunitaire1">
                    </div>
                    <div>
                        <label for="tva1">TVA:</label>
                        <input type="text" id="tva1" name="tva1">
                    </div>
                </div>
            </div>
            <button class="buttonAdd" type="button" onclick="addFields()">Ajouter</button>
            <button class="buttonDel" type="button" onclick="removeFields()">Effacer</button></br></br>
            <button class="buttonOk" type="button" onclick="submitForm()">Envoyer</button></br>
            <p><a href="/mi/voirproformatmeres">Listes des proformats</a></p>
            <p id="erreur" style="color:red;"></p>
        </form>
    </div>