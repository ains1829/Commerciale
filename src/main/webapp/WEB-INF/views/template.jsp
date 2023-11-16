<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.example.demo.Models.*" %>


<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>etatstock</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/index.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/stocketatviews.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/stockout.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/template.css">
</head>
<body>
<!-- Header avec menus -->
<div class="header">
    <div class="menu">
        <a href="/tostockout"> Sortir des stocks</a>
        <a href="/">Etat de Stock</a>
    </div>
</div>
<div class="content">
    
    <jsp:include page="${content}" />

</div>
<!-- Footer -->
<div class="footer">
    <p>&copy; 2023 Mirado. Tous droits réservés.</p>
</div>
</body>
</html>