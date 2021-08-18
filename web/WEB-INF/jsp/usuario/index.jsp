<%-- 
    Document   : index
    Created on : 12/02/2021, 15:40:58
    Author     : jcrfm
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form"prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <spring:url value="/resources/js/jquery-3.5.1.min.js" var="script"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Spring-MVC</title>
        <script src="${script}" type="text/javascript"></script>
    </head>
    <c:set var="perfil" scope="session" value="${perfilUsuario.perfil}"/>
      <c:choose>
        <c:when test = "${perfil == 'administrador'}">
            <c:import url="Headeradm.jsp" />
        </c:when>
       
        <c:otherwise>
           <c:import url="Headercomum.jsp" />
        </c:otherwise>
        
     </c:choose>
    <body>
        <div class="Container">
        
        </div>
    </body>
    <c:import url="Footer.jsp" />
</html>
