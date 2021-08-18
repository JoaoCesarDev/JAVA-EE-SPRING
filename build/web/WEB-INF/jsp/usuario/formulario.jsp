<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://www.springframework.org/tags/form"prefix="form"%>
<%@taglib uri ="http://java.sun.com/jsp/jstl/fmt" prefix ="fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <spring:url value="/resources/js/jquery-3.5.1.min.js" var="script"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="${script}" type="text/javascript"></script>
        <title>Welcome to Spring Web MVC project</title>
    </head>
    <c:import url="Headeradm.jsp"/>
    <body>
        
        <div class="Container">
            
        <form:form action="adicionarUsuario" method="POST" modelAttribute="Usuario">
            <table>
                <TR><TD ><h1>Cadastro de Usuários</h1></TD></TR>
                <TR>
                    <TD class="formcadastrar">Login: <form:input type="text" path="login" /></TD><br/>
                </TR>
                
                <TR>
                    <TD class="formcadastrar">Senha: <form:input type="text" path="senha" /></TD><br/>
                </TR>
                <TR>
                    <TD class="formcadastrar">Data de Criação: <form:input type="date" path="dataCriacao" SIZE="11"/></TD><br/>
                </TR>
                <TR>
                <TD class="formacadastrar">Perfil: <form:input type="text" path="perfil" SIZE="15"/></TD>
                </TR>
               
                <TR>
                    <TD class="formcadastrar" id="ad"><input type="submit" value="Adicionar"style="width:85px;height: 35px;"/> <input id = "limparbtn"type="Reset" value="Limpar" onclick="limpar()" style="margin-left: 35px;width:85px;height: 35px;"/></TD> 
                </TR>
                <p style="color:red;"><form:errors path="login" ><fmt:message key="usuario.login"/></form:errors></p>
                <p style="color:red;"><form:errors path="senha"><fmt:message key="usuario.senha"/></form:errors></p>
                 </table>
        </form:form>
               
        </div>
    </body>
    <c:import url="Footer.jsp" />
    <script>
        var limparButton = document.getElementById('limparbtn');
        var p = document.getElementsByTagName('p');
        function limpar(){
            $('p').hide();
        }
        
    </script>
</html>
