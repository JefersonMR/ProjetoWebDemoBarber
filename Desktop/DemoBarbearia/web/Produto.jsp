<%-- 
    Document   : cadastro
    Created on : 28/09/2017, 10:27:59
    Author     : Jeferson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri= "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css"
    href="css/ui-lightness/jquery-ui-1.8.18.custom.css" rel="stylesheet" />
<script type="text/javascript" src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript" src="js/jquery-ui-1.8.18.custom.min.js"></script>
        <title>Produto</title>
    </head>
    <body>
        <script>
        $(function() {
            $('input[name=fabricacao]').datepicker();
            $('input[name=validade]').datepicker();
        });
    </script>

    <form method="POST" action='CProduto' name="AddPro">
        ID:<br><input type="text" readonly="readonly" name="id"  
                         value="<c:out value="${dp.IDP}"/>"><br/> 
        Marca:<br><input type="text" name="marca" required 
                           value="<c:out value="${dp.cpf}"/>"><br>
        Nome:<br><input type="text" name="nome" required
                            value="<c:out value="${dp.nome}"/>"><br>
        Descrição:<br><input type="text" name="descricao" required 
                            value="<c:out value="${dp.descricao}"/>"><br>
        Fabricação:<br><input type="text" name="fabricacao" required
                            value="<fmt:formatDate pattern="MM/dd/yyyy" value="${dp.fabricacao}" />" /><br>
        Validade : <input
            type="text" name="validade"
            value="<fmt:formatDate pattern="MM/dd/yyyy" value="${dp.validade}" />" /> <br> 
        <input type="submit" value="Salvar"/>    
    </form>
    </body>
</html>
