<%-- 
    Document   : index
    Created on : 09/02/2021, 08:38:28
    Author     : jcrfm
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     
    <head>
    <spring:url value="/resources/css/Estilos.css" var="Estilo"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Spring-MVC</title>
    <link rel="stylesheet" type="text/css" href="${Estilo}"/>
    </head>
   
    <body>
        <div class="menu">
       <div class="topnav">
            <a class="active" href="home">Início</a>
            <a href="listaUsuarios">Listar Usuários</a>
            
        </div>
            
        </div>
        <div>Usuário Logado: ${usuarioLogado.login} - ${perfilUsuario.perfil} <a href="logout">Log-Out</a></div>
    </body>
</html>