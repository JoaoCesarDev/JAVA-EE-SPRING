<%-- 
    Document   : lista
    Created on : 09/02/2021, 15:58:23
    Author     : jcrfm
<a id="remover" href="removeUsuario?id=${usuario.id}">Remover</a>

--%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri ="http://java.sun.com/jsp/jstl/fmt" prefix ="fmt"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <spring:url value="/resources/js/jquery-3.5.1.min.js" var="script"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="${script}" type="text/javascript"></script>
        <title>Lista de Usuários</title>
    </head>
    
    <c:import url="Headeradm.jsp" />
    <body>
        <div class="Container">
        <table id="tbl">
            <TR><h1>Usuários Cadastrados</h1></TR>
            <tr>
            <th>Id</th>
            <th>Login</th>
            <th>Senha</th>
            <th>Perfil</th>
            <th>Data de Cadastro</th>
            </tr>
            <c:forEach items="${usuarios}" var="usuario">
            <tr>
            <td>${usuario.id}</td>
            <td>${usuario.login}</td>
            <td>${usuario.senha}</td>
            <td>${usuario.perfil}</td>
            <td>
            <fmt:formatDate value="${usuario.dataCriacao.time}" pattern="dd/MM/yyyy"/>
            </td>
            <td><button id="remover" onclick="remover(${usuario.id})">Excluir</button></td>
            <td><button><a id="atualizar" href="mostraUsuario?id=${usuario.id}">Alterar</a></button></td>
            </tr>
            <dialog id="favDialog">
                <form method="dialog">
                    <label style="margin-left: 17px;">Confirmação de Exclusão?</label><BR>
                    <BR>
                    <button id="confirmBtn" Style="padding: 5px;width: 100px;" value="default">Sim</button>
                    <button id="cancelBtn" Style="padding: 5px;width: 100px;">Não</button>
                </form>
            </dialog>
            </c:forEach>
            
        </table>
            

        </div>
    </body>
    <c:import url="Footer.jsp" />
    <script>
       var removeButton = document.getElementById('remover');
       var favDialog = document.getElementById('favDialog'); 
       var confirmBtn = document.getElementById('confirmBtn');
       var cancelButton = document.getElementById('cancelBtn');
       
        function remover(id){
            
            favDialog.showModal();
            $(confirmBtn).on('click',function(){
                $.get('removeUsuario?id='+id);
                window.location.reload();
            });
        }
       
    </script>   
</html>
