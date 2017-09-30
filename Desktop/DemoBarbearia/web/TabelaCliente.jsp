<%-- 
    Document   : TabelaCliente
    Created on : 28/09/2017, 14:24:51
    Author     : Jeferson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri= "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tabela de Clientes</title>
    </head>
    <body>
        <h1>Usuários</h1>
        <br>
        <table>
            <tr>
            <th>ID</th>
            <th>CPF</th>
            <th>Nome</th>
            <th>Endereço</th>
            <th>Fone</th>
            <th>Email</th>
            <th colspan="2">Opções</th>
            </tr>
            
    <tbody> 
      <c:forEach items="${clientes}" var="d">
       <tr>
        <td><c:out value="${d.IDC}"/> </td>  
        <td><c:out value="${d.Cpf}"/> </td>
        <td><c:out value="${d.Nome}"/> </td>
        <td><c:out value="${d.Endereco}"/> </td>
        <td><c:out value="${d.Fone}"/> </td>
        <td><c:out value="${d.Email}"/> </td>
       
       <td><a href="CCliente?action=editar&idCliente=<c:out value="${d.IDC}"/>">Alterar</a></td>
       <td><a href="CCliente?action=deletar&idCliente=<c:out value="${d.IDC}"/>">Excluir</a></td>
                        
       
       </tr>
      </c:forEach>
      </tbody>
      </table>
      <p><a href="CCliente?action=inserir">Adicionar</a></p>   
     </body>
</html>
