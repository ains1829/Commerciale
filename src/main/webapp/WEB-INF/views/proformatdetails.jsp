<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.example.commerciale.models.ProformatDetail" %>
<div class="content-detail">
    <div class="super-title">Proformat details enregistré </div>
    <table>
        <thead>
            <tr>
                <th>Article</th>
                <th>Quantite</th>
                <th>Prix unitaire HT</th>
                <th>Tva</th>
                <th>Prix TTC</th>
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
                    </tr>
                <% }
            } %>
        </tbody>
    </table>
    <a href="/mi/voirproformatmeres">retour</a>
</div>
