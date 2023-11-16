<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
   <div>
        <div class="form-container">
            <h1>Voir l'etat de stock</h1>
            <form method="post" action="/stocketatview" class="custom-form">
                <div class="form-group">
                    <label for="datefabrication">Date debut:</label>
                    <input name="datedebut" type="date" id="datefabrication" />
                </div>
                <div class="form-group">
                    <label for="datefabrication">Date fin:</label>
                    <input name="datefin" type="date" id="datefabrication" />
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