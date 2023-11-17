<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.example.demo.Models.*" %>


<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulaire</title>
</head>
<body>
<!-- Header avec menus -->
<div class="header">
    <div class="menu">
        <a href="#"> Menu1</a>
        <a href="#">Menu2</a>
    </div>
</div>
<div class="content">
    
    <jsp:include page="${content}" />

</div>
<script src="/formproformat.js"></script>
</body>
</html>