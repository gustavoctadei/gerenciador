
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/entrada" var="linkServletNovaEmpresa" />

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
            
            Nome: <input type="text" name="login" />
            Senha: <input type="password" name="senha" />
            
            <input value="Enviar" type="submit" />
            
            <input name="acao" value="Login" type="hidden" />
            
        </form>
        
    </body>
</html>
