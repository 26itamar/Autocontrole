;<%-- 
    Document   : testes
    Created on : 22/05/2017, 10:29:48
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
        <h1>Selecione A Data</h1>
        <div>
            <form action="listarautocontrole.jsp" method="post">
                Data:
                <select name="data">
                    <option value="">Escolha</option>
                <%
                for(Data d : dataDao.getListAll()){
                %>
                    <option value="<%=d.getId()%>"><%=d.getMes()%>-<%=d.getAno()%> </option>
                <%
                }    
                %>
                </select>
                
                <input type="submit" value="Verificar Gastos"/>
                <button><a href="index.html">Cancelar</a></button>
            </form>
        </div>
    </body>
</html>
