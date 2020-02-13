
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/entrada" var="linkEntradaServlet" />

<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        
        <c:import url="logout-parcial.jsp" />
        
        <form action="${linkEntradaServlet}" method="post">
            
            Nome: <input type="text" name="nome" value="${empresa.nome}" />
            Data Abertura: <input type="text" name="data" value="<fmt:formatDate value="${empresa.dataAbertura}" pattern="dd/MM/yyyy" />" />
            
            <input type="hidden" name="id" value="${empresa.id}" />
            <input type="hidden" name="acao" value="AlteraEmpresa" />
            <input value="Enviar" type="submit" />
            
        </form>
        
    </body>
</html>
