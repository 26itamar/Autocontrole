<%-- 
    Document   : cadastrarReceitas
    Created on : 22/05/2017, 11:22:00
    Author     : Sony Vaio
--%>

<%@page import="controle.ReceitaImpl"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@page import="modelo.Receita" %>
<%@page import="modelo.Data" %>
<jsp:useBean id="dataDao" class="controle.DataImpl"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Cadastro de Receita</Rtitle>
    </head>
    <body>
        <%@include file="index.html" %>
        <h1>Cadastro de Receitas</h1>
        <div>
            <form action="cadastrarReceitas" method="post">
                Descrição Receita:<input type="text" name="descricao" />
                Valor R$:<input type="text" name="valor"/>
                Data:
                <select name="data_r">
                    <option value="">Escolha</option>
                <%
                for(Data d : dataDao.getListAll()){
                %>
                    <option value="<%=d.getId()%>"><%=d.getMes()%>-<%=d.getAno()%> </option>
                <%
                }    
                %>
                </select>
                
                <input type="submit" value="Salvar Receita"/>
                <button><a href="index.html">Cancelar</a></button>
            </form>
        </div>
    </body>
</html>