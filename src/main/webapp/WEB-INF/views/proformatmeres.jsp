<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.example.commerciale.Models.ProformatmereDetail" %>
<div class="super-title">Les Proformats Enregistrés:</div>
<table>
    <thead>
        <tr>
            <th>Nom Proformat</th>
            <th>Fournisseur</th>
            <th>Date Proformat</th>
            <th><a href="/">retour</a></th>
            <!-- Ajoutez d'autres en-têtes de colonnes au besoin -->
        </tr>
    </thead>
    <tbody>
        <% 
        ProformatmereDetail[] proformatmereDetails=(ProformatmereDetail[])request.getAttribute("proformatmereDetails");
        if (proformatmereDetails != null) {
            for (ProformatmereDetail proformatmereDetail : proformatmereDetails) { %>
                <tr>
                    <td><%= proformatmereDetail.getNomproformatmere() %></td>
                    <td><%= proformatmereDetail.getNomfournisseur() %></td>
                    <td><%= proformatmereDetail.getDateproformatmere() %></td>
                    <td><a href="/voidetailByIdproformatmere?Id_proformatmere=<%=proformatmereDetail.getId_proformatmere()%>">voir details</a></td>
                    <!-- Ajoutez d'autres cellules de données au besoin -->
                </tr>
            <% }
        } %>
    </tbody>
</table>
