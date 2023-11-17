<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <form id="myForm">
        <div>
            <label for="dateproformat">Date Proformat:</label>
            <input type="text" id="dateproformat" name="dateproformat">
        </div>
        <div>
            <label for="nomproformat">Nom Proformat:</label>
            <input type="text" id="nomproformat" name="nomproformat">
        </div>
        <div>
            <label for="Id_fournisseur">ID Fournisseur:</label>
            <input type="text" id="Id_fournisseur" name="Id_fournisseur">
        </div>
        
        <div id="dynamicFields">
            <!-- Dynamic fields will be added here -->
        </div>
        
        <button type="button" onclick="addFields()">Ajouter</button>
        <button type="button" onclick="removeFields()">Effacer</button>
        <button type="button" onclick="submitForm()">Envoyer</button>
    </form>
