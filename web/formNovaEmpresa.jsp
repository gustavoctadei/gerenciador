
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/novaEmpresa" var="linkServletNovaEmpresa" />

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
        
        <form action="${linkServletNovaEmpresa}" method="post">
            
            Nome: <input type="text" name="nome" />
            Data Abertura: <input type="text" name="data" />
            
            <input value="Enviar" type="submit" />
            
        </form>
        
    </body>
</html>
