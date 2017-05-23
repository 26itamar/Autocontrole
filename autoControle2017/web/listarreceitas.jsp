<%-- 
    Document   : listarreceitas
    Created on : 23/05/2017, 16:58:13
    Author     : Sony Vaio
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="modelo.Receita"%>
<%@page import="controle.ReceitaImpl"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Lista de Receitas</title>
    </head>
    <body>
        <%@include file="index.html" %>
        <h1>Receitas</h1>
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
                    ReceitaImpl receitaImpl = new ReceitaImpl();
                    List<Receita> list =  receitaImpl.getListAll();
                    for(Receita r : list){
                        %>
                        <tr>
                            <td><%= r.getId() %></td>
                            <td><%= r.getDescricaoReceita() %></td>
                            <td><%= r.getValorReceita() %></td>
                            <td><%= r.getData().getMes() %></td>
                            <td><%= r.getData().getAno() %></td>
                            
                            <td><a href="listarreceitas.jsp?id=<%= r.getId()%>">Excluir</a></td>
                        </tr>
                        <%
                    }
                %>
            </table>
            
            <%
                    int id = 0;
                    Receita receita = new Receita();
                    if (request.getParameter("id") != null) {
                       id = Integer.valueOf(request.getParameter("id"));
                       
                       Receita r= new Receita();               
                       r.setId(id);
                       receitaImpl.remover(r);       
                       
                       response.sendRedirect("listarreceitas.jsp");
                       
                    }
                %>
                
            <br>         
             <button><a href="index.html">Inicio</a></button>
        </div>
    </body>
</html>