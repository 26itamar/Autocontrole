<%-- 
    Document   : cadastrargastos
    Created on : 23/05/2017, 10:08:22
    Author     : Sony Vaio
--%>

<%@page import="controle.GastoImpl"%>
<%@page contentType="text/html" pageEncoding="ISO-8859-1"%>
<%@page import="modelo.Gasto" %>
<%@page import="modelo.Data" %>
<jsp:useBean id="dataDao" class="controle.DataImpl"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Cadastro de Receita</Rtitle>
    </head>
    <body>
        <%@include file="index.html"%>
        <h1>Cadastro de Gastos</h1>
        <div>
            <form action="cadastrarGastos" method="post">
                Descrição do Gasto:<input type="text" name="descricao" /><br>
                Valor:<input type="text" name="valor"/><br>
                Data:
                <select name="data_g">
                    <option value="">Escolha</option>
                <%
                for(Data d : dataDao.getListAll()){
                %>
                    <option value="<%=d.getId()%>"><%=d.getMes()%>-<%=d.getAno()%> </option>
                <%
                }    
                %>
                </select>
                
                <input type="submit" value="Salvar Gasto"/>
                <a href="index.html">Cancelar</a>
            </form>
        </div>
    </body>
</html>
