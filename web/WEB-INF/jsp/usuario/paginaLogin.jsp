<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form"prefix="form"%>
<HTML>
    <head>
        <spring:url value="/resources/js/jquery-3.5.1.min.js" var="script"/>
        <spring:url value="/resources/css/Estilos.css" var="Estilo"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="${script}" type="text/javascript"></script>
        <link rel="stylesheet" type="text/css" href="${Estilo}"/>
        <title>Spring-MVC</title>
    </head>
    
    <BODY>
<div class="Container">
    <form action="efetuaLogin" method="POST">
            <table>
                <TR><TD ><h1>Login no Sistema</h1></TD></TR>
                <TR>
                    <TD class="formcadastrar">Login: <input type="text" name="login" /></TD><br/>
                </TR>
                
                <TR>
                    <TD class="formcadastrar">Senha: <input type="password" name="senha" /></TD><br/>
                </TR>
               
                <TR><TD></TD></TR>
              
                <TR>
                    <TD class="formcadastrar" id="ad"><input type="submit" value="Entrar"style="width:85px;height: 35px;"/> </TD> 
                </TR>
                
                <p style="color:red;"><form:errors path="login" ><fmt:message key="usuario.login"/></form:errors></p>
                <p style="color:red;"><form:errors path="senha"><fmt:message key="usuario.senha"/></form:errors></p>
                 </table>
        </form>
</div>
</BODY>
<c:import url="Footer.jsp" />
<script>
        var limparButton = document.getElementById('limparbtn');
        var p = document.getElementsByTagName('p');
        function limpar(){
            $('p').hide();
        }
        
    </script>
</HTML>