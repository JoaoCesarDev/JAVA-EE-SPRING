<%-- 
    Document   : exibeUsuario
    Created on : 10/02/2021, 08:46:20
    Author     : jcrfm
--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form"prefix="form"%>
<%@taglib uri ="http://java.sun.com/jsp/jstl/fmt" prefix ="fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <spring:url value="/resources/js/jquery-3.5.1.min.js" var="script"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="${script}" type="text/javascript"></script>
        <title>Alteração</title>
    </head>
    <c:import url="Header.jsp" />
    <body>
        <div class="Container">
       
            <form:form action="alteraUsuario" method="POST" modelAttribute="usuario">

                <form:input type="hidden" name="id" path="id" />
                <table>
                <TR><TD><h1>Alterar Usuário</h1></TD></TR>
                <TR>
                    <TD class="formcadastrar">Login: <form:input type="text" path="login" /></TD><br/>
                </TR>
                
                <TR>
                    <TD class="formcadastrar">Senha: <form:input type="text" path="senha" /></TD><br/>
                </TR>
                <TR>
                    <TD class="formcadastrar">Data de Atualização: <form:input Type="date" path="dataCriacao" value="${fmtDate}" size="11"/></TD><br/>
                </TR>
                <fmt:formatDate var="fmtDate" value="${usuario.dataCriacao.time}" pattern="dd/MM/yyyy"/>
                <TR><TD class="formcadastrar" id="ad"><input type="submit" value="Alterar" style="width:85px;height: 35px;"/></TD></TR>
                </table>
        </form:form>
            </div>
    </body>
    <c:import url="Footer.jsp" />
    
</html>
