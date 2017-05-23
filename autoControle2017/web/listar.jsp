<%--
    Document   : listar
    Created on : 22/05/2017, 10:20:52
    Author     : Sony Vaio
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Gasto"%>
<%@page import="controle.GastoImpl"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Lista de Gastos</title>
    </head>
    <body>
        <%@include file="index.html" %>
        <h1>Receitas/Gastos</h1>
        <div>
            <table>
                <tr>
                    <td>ID</td>
                    <td>Descrição Gastos</td>
                    <td>Valor Gastos </td>
                    <td>Mês </td>
                    <td>Ano</td>
                    <td>AÇÃO</td>
                </tr>
                <%
                    GastoImpl gastoImpl = new GastoImpl();
                    List<Gasto> list =  gastoImpl.getListAll();
                    for(Gasto g : list){
                        %>
                        <tr>
                            <td><%= g.getId() %></td>
                            <td><%= g.getDescricaoGasto() %></td>
                            <td><%= g.getValorgasto() %></td>
                            <td><%= g.getData().getMes() %></td>
                            <td><%= g.getData().getAno() %></td>
                            
                            <td><a href="index.html?id=<%= g.getId()%>">editar</a></td>
                        </tr>
                        <%
                    }
                %>
            </table>
            <a href="index.html">Inicio</a>
        </div>
    </body>
</html>
