<%-- 
    Document   : index
    Created on : 19/09/2017, 21:36:49
    Author     : aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/menu.css">
        <link rel="icon" type="image/jpg" href="pho/title.jpg">
        <title>DemoBarbearia</title>
    </head>
    <header> 
        <figure>
            <img src="pho/head.jpg" height="400" width="1000">
        </figure>
    </header>
    <body>
        <nav> 
            <a href="Cliente.jsp">Clientes</a>
            <a href="Produto.jsp">Produto</a>
            <a href="Servico.jsp">Serviço</a>
            <a href="CCliente?action=TabelaCliente">Tabela Clientes</a>
            <a href="CServiço?action=TabelaServico">Tabela Serviços</a>
            
        </nav>   
        
        
    </body>
</html>
