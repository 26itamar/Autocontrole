<%-- 
    Document   : testes
    Created on : 22/05/2017, 10:29:48
    Author     : Sony Vaio
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Data"%>
<%@page import="controle.DataImpl"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Lista de Data</title>
    </head>
    <body>
        <%@include file="index.html" %>
        <h1>Datas</h1>
        <div>
            <table>
                <tr>
                    <td>ID</td>
                    <td>Mês </td>
                    <td>Ano</td>
                    <td>AÇÃO</td>
                </tr>
                <%
                    DataImpl dataImpl = new DataImpl();
                    List<Data> list = dataImpl.getListAll();
                    for(Data d : list){
                        %>
                        <tr>
                            <td><%= d.getId() %></td>
                            <td><%= d.getMes() %></td>
                            <td><%= d.getAno() %></td>
                            <td><a href="index.html?id=<%= d.getId()%>">editar</a></td>
                        </tr>
                        <%
                    }
                %>
            </table>
            <a href="index.html">Inicio</a>
        </div>
    </body>
</html>
