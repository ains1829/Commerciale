<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.example.commerciale.Models.ProformatDetail" %>
<!-- Ajout d'un tableau pour afficher les données -->
<div class="super-title">Proformat details enregistré </div>
<table>
    <thead>
        <tr>
            <th>Article</th>
            <th>Quantite</th>
            <th>Prix unitaire HT</th>
            <th>Tva</th>
            <th>Prix TTC</th>
            <!-- Ajoutez d'autres en-têtes de colonnes au besoin -->
        </tr>
    </thead>
    <tbody>
        <% 
        ProformatDetail[] proformatDetails=(ProformatDetail[])request.getAttribute("proformatDetails");
        if (proformatDetails != null) {
            for (ProformatDetail proformatDetail : proformatDetails) { %>
                <tr>
                    <td><%= proformatDetail.getNomarticle() %></td>
                    <td><%= proformatDetail.getQuantite() %></td>
                    <td><%= proformatDetail.getPrixunitaire() %></td>
                    <td><%= proformatDetail.getTva() %> %</td>
                    <td><%= proformatDetail.getprixttc() %></td>
                    <!-- Ajoutez d'autres cellules de données au besoin -->
                </tr>
            <% }
        } %>
    </tbody>
</table>
<a href="/voirproformatmeres">retour</a>
