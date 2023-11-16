<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.example.demo.Models.*" %>
<div class="table-container">
   <table class="styled-table" style="font-size:80%;">
        <caption class="table-title">Etat de stock</caption>
        <thead>
            <tr>
                <th>Article</th>
                <th>Methode</th>
                <th>Magasin</th>
                <th>Unité</th>
                <th>entrée debut</th>
                <th>sortie debut</th>
                <th>Quantite debut</th>
                <th>Montant </br>total debut</th>
                <th>PUM debut</th>
                <th>Date debut</th>
                <th>entrée fin</th>
                <th>sortie fin</th>
                <th>Quantite fin</th>   
                <th>Montant </br>total fin</th>
                <th>PUM fin</th>
                <th>Date fin</th>
            </tr>
        </thead>
        <tbody>
            <%
            Etatstock[] etatstocks = (Etatstock[]) request.getAttribute("etatstocks");
            if(etatstocks!=null){ 
                for(Etatstock etatstock: etatstocks){ %>
                <tr>
                    <td><%=etatstock.getNomarticle()%></td>
                    <td><%=etatstock.getCodemethodgestion()%></td>
                    <td><%=etatstock.getNommagasin()%></td>
                    <td><%=etatstock.getUnite()%></td>
                    <td style="background-color:rgba(194, 187, 187, 0.7);"><%=etatstock.getQuantitetotaldebutin()%></td>
                    <td style="background-color:rgba(194, 187, 187, 0.7);"><%=etatstock.getQuantitetotaldebutout()%></td>
                    <td style="background-color:rgba(194, 187, 187, 0.7);"><%=etatstock.getQuantitetotaldebut()%></td>
                    <td style="background-color:rgba(194, 187, 187, 0.7);"><%=etatstock.getPrixtotaldebut()%> ar</td>
                    <td style="background-color:rgba(194, 187, 187, 0.7);"><%=etatstock.getPuminitial()%> ar</td>
                    <td style="background-color:rgba(194, 187, 187, 0.7);"><%=etatstock.getDate1()%></td>
                    <td style="background-color:rgba(0, 183, 255, 0.885);"><%=etatstock.getQuantitetotalin()%></td>
                    <td style="background-color:rgba(0, 183, 255, 0.885);"><%=etatstock.getQuantitetotalout()%></td>
                    <td style="background-color:rgba(0, 183, 255, 0.885);"><%=etatstock.getQuantitetotal()%></td>
                    <td style="background-color:rgba(0, 183, 255, 0.885);"><%=etatstock.getPrixtotal()%> ar</td>
                    <td style="background-color:rgba(0, 183, 255, 0.885);"><%=etatstock.getPumfinal()%> ar</td>
                    <td style="background-color:rgba(0, 183, 255, 0.885);"><%=etatstock.getDate2()%></td>
                </tr><%
                }
            }
            %>
        </tbody>
    </table>
</div>