<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.example.commerciale.models.ProformatmereDetail" %>
<div class="content-mere">
    <div class="super-title">Tous les Proformats </div>
    <table>
        <thead>
            <tr>
                <th>Nom Proformat</th>
                <th>Fournisseur</th>
                <th>Date Proformat</th>
                <th></th>
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
                        <td><a href="/mi/voidetailByIdproformatmere?Id_proformatmere=<%=proformatmereDetail.getId_proformatmere()%>">voir details</a></td>
                    </tr>
                <% }
            } %>
        </tbody>
    </table>
    <a href="/mi/">retour</a>
</div>
