<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.example.commerciale.models.ArticleMi" %>
<%@ page import="com.example.commerciale.models.FournisseurMi" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/InsertProformat.css">
    <title>Formulaire</title>
</head>
<body>
<div class="container-page">
    <%@ include file = "Menu.jsp"  %> 
    <jsp:include page="${content}" />
</div>
<script src="/formproformat.js"></script>
</body>
</html>