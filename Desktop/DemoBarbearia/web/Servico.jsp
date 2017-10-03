<%-- 
    Document   : Servico
    Created on : 28/09/2017, 10:29:45
    Author     : Jeferson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Serviço</title>
    </head>
    <body>
        <form>
         <form action="CServiço" method="post" name="AddSer">
            ID:<br><input type="text" readonly="readonly" name="id"  
                         value="<c:out value="${ds.IDS}"/>"><br/> 
            Nome:<br><input type="text" name="nome" required 
                           value="<c:out value="${ds.nome}"/>"><br>
            Descrição:<br><input type="text" name="descricao" required
                            value="<c:out value="${ds.descricao}"/>"><br>
            Profissional:<br><input type="text" name="profissional" required 
                            value="<c:out value="${ds.profissional}"/>"><br>
            Tempo:<br><input type="text" name="tempo" required
                            value="<c:out value="${ds.tempo}"/>"><br>
            Valor:<br><input type="number" name="valor" required
                             value="<c:out value="${ds.valor}"/>"><br>
            <br /> <input type="submit" value="Salvar"/>
           </form>
    </body>
</html>
