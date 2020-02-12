<%-- 
    Document   : listaEmpresas
    Created on : 05/02/2020, 17:17:42
    Author     : Gustavo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List, br.com.alura.gerenciador.modelo.Empresa"  %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Java Standard Taglib</title>
    </head>
    <body>
        
        <c:if test="${not empty empresa}">
            Empresa ${ empresa } cadastrada com Sucesso! <br/>
        </c:if>
        
        Lista de Empresas: <br/>
        
        <ul>
            <c:forEach items="${requestScope.empresas}" var="e">
                <li>${e.nome} - <fmt:formatDate value="${e.dataAbertura}" pattern="dd/MM/yyyy" />
                    <a href="/gerenciador/entrada?acao=MostraEmpresa&id=${e.id}">Edita</a>
                    <a href="/gerenciador/entrada?acao=RemoveEmpresa&id=${e.id}">Remove</a>
                </li>
            </c:forEach>
        </ul>
        
    </body>
</html>
