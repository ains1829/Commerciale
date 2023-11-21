<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.example.commerciale.Models.ArticleMi" %>
<%@ page import="com.example.commerciale.Models.FournisseurMi" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulaire</title>
</head>
<style>
    body {
        font-family: 'Arial', sans-serif;
        background-color: #f0f2f5;
        display: flex;
        align-items: center;
        justify-content: center;
    }

    #myForm {
        background-color: #fff;
        border-radius: 8px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        padding: 20px;
        width: 800px;

        justify-content: center;

    }
    h1 {
            text-align: center;
            color: #1877f2; /* Couleur du bouton Envoyer */
            margin-bottom: 20px;
    }
    div {
        margin-bottom: 15px;
    }

    label {
        display: block;
        font-weight: bold;
        margin-bottom: 5px;
    }

    input, select {
        width: 100%;
        padding: 8px;
        box-sizing: border-box;
        border: 1px solid #ccc;
        border-radius: 4px;
    }

    .buttonOk {
        background-color: #1877f2;
        color: #fff;
        padding: 10px;
        border: none;
        border-radius: 4px;
        width: 100%; /* Pour occuper la largeur du conteneur */
    }

    .buttonOk:hover {
        background-color: #14568f;
    }
    .buttonAdd {
        background-color: #18f264;
        color: #fff;
        padding: 10px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        width: 30%; /* Pour occuper la largeur du conteneur */
        flex-direction: row;
    }

    .buttonAdd:hover {
        background-color: #2acd63;
    }
    .buttonDel {
        background-color: #f23518;
        color: #fff;
        padding: 10px;
        border: none;
        border-radius: 4px;
        width: 30%; /* Pour occuper la largeur du conteneur */
        flex-direction: row;
    }

    .buttonDel:hover {
        background-color: rgb(167, 34, 13);
    }

    /* Media query pour la responsivité */
    @media screen and (max-width: 600px) {
        #myForm {
            width: 100%; /* Occuper la largeur de l'écran */
        }
    }
    #dynamicFields2 {
        display: flex;
        flex-direction: row;
    }

    #dynamicFields2 div {
        flex: 1;
        margin-right: 10px;
    }
    /*tableau*/
    table {
        width: 100%;
        margin-top: 20px;
        border-collapse: collapse;
        background-color: #fff;
        border-radius: 8px;
        box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
    }

    th, td {
        border: 1px solid #ccc;
        padding: 10px;
        text-align: left;
    }

    th {
        background-color: #f0f2f5;
    }
    .super-title {
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 20px;
            color: #333; /* Couleur de texte de votre choix */
            text-align: center;
    }
</style>
<body>
<div class="content">
    
    <jsp:include page="${content}" />

</div>
<script src="/formproformat.js"></script>
</body>
</html>