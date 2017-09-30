<%-- 
    Document   : cliente
    Created on : 28/09/2017, 10:29:05
    Author     : Jeferson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri= "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cliente</title>
    </head>
    <body>
        <form action="CCliente" method="post" name="AddCli">
            ID:<br><input type="text" readonly="readonly" name="id"  
                         value="<c:out value="${cliente.IDC}"/>"><br/> 
            CPF:<br><input type="text" name="cpf" required 
                           value="<c:out value="${cliente.Cpf}"/>"><br>
            Nome:<br><input type="text" name="nome" required
                            value="<c:out value="${cliente.Nome}"/>"><br>
            Endereço:<br><input type="text" name="endereco" required 
                            value="<c:out value="${cliente.Endereco}"/>"><br>
            Fone:<br><input type="text" name="fone" required
                            value="<c:out value="${cliente.Fone}"/>"><br>
            Email;<br><input type="email" name="email" required
                             value="<c:out value="${cliente.Email}"/>"><br>
            <br /> <input type="submit" value="Salvar"/>
        </form>
    </body>
</html>
