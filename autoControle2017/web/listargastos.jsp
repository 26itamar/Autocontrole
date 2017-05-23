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
        <h1>Gastos</h1>
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
                            
                            <td><a href="listargastos.jsp?id=<%= g.getId()%>">Excluir</a></td>
                        </tr>
                        <%
                    }
                %>
            </table>
           <%
                    int id = 0;
                    Gasto gasto = new Gasto();
                    if (request.getParameter("id") != null) {
                       id = Integer.valueOf(request.getParameter("id"));
                       
                       Gasto g= new Gasto();               
                       g.setId(id);
                       gastoImpl.remover(g);       
                       
                       response.sendRedirect("listargastos.jsp");
                       
                    }
                %>
            <br>         
             <button><a href="index.html">Inicio</a></button>
        </div>
    </body>
</html>
