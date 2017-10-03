<%-- 
    Document   : TabelaProduto
    Created on : 28/09/2017, 14:25:13
    Author     : Jeferson
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri= "http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tabela Produtos</title>
    </head>
    <body>
        <h1>Produtos</h1>
        <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Marca</th>
                <th>Nome</th>
                <th>Descrição</th>
                <th>Fabricação</th>
                <th>Validade</th>
                <th colspan=2>Opcões</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${produtos}" var="dp">
                <tr>
                    <td><c:out value="${dp.IDP}" /></td>
                    <td><c:out value="${dp.cpf}" /></td>
                    <td><c:out value="${dp.nome}" /></td>
                    <td><c:out value="${dp.descricao}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MMM-dd" value="${dp.fabricacao}" /></td>
                    <td><fmt:formatDate pattern="yyyy-MMM-dd" value="${dp.validade}" /></td>
                    
                    <td><a href="CProduto?action=editar&idProduto=<c:out value="${dp.IDP}"/>">Alterar</a></td>
                    <td><a href="CProduto?action=deletar&idProduto=<c:out value="${dp.IDP}"/>">Excluir</a></td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <p><a href="CProduto?action=inserir">Adicionar</a></p>
    </body>
</html>
