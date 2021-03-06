<%-- 
    Document   : TabelaServico
    Created on : 28/09/2017, 14:25:51
    Author     : Jeferson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tabela de Serviços</title>
    </head>
    <body>
        <h1>Serviços</h1>
        <br>
        <table>
            <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Descrição</th>
            <th>Profissional</th>
            <th>Tempo</th>
            <th>Valor</th>
            <th colspan="2">Opções</th>
            </tr>
            <tbody> 
       
        <c:forEach items="${servicos}" var="ds">
        <tr>
        <td><c:out value="${ds.IDS}"/> </td>  
        <td><c:out value="${ds.nome}"/> </td>
        <td><c:out value="${ds.descricao}"/> </td>
        <td><c:out value="${ds.profissional}"/> </td>
        <td><c:out value="${ds.tempo}"/> </td>
        <td><c:out value="${ds.valor}"/> </td>
       
       <td><a href="CServiço?action=editar&idServico=<c:out value="${ds.IDS}"/>">Alterar</a></td>
       <td><a href="CServiço?action=deletar&idServico=<c:out value="${ds.IDS}"/>">Excluir</a></td>
                        
       
       </tr>
      </c:forEach>
      </tbody>
      </table>
      <p><a href="CServiço?action=inserir">Adicionar</a></p>   
    
    </body>
</html>
