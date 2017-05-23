<%-- 
    Document   : listarautocontrole
    Created on : 23/05/2017, 12:25:43
    Author     : Sony Vaio
--%>

<%@page import="modelo.Gasto"%>
<%@page import="modelo.Receita"%>
<%@page import="java.util.List"%>
<%@page import="controle.GastoImpl"%>
<%@page import="controle.ReceitaImpl"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%
            int id_data = Integer.valueOf(request.getParameter("data"));
         %>
         
         <h1>Resumo Do Mês</h1>
        
          <div>
         
              <table border =4>
                  
                  <tr><a><b>RECEITAS:</b></a>    
                  
                    <td>Descrição Receita</td>
                    <td>Valor Receita</td>
                    <td>Mês </td>
                    <td>Ano</td>
                   
                </tr>
                <%
                    double totalReceita=0;
                    ReceitaImpl receitaImpl = new ReceitaImpl();
                    List<Receita> listMesReceita= receitaImpl.getListData(id_data);
                    for(Receita r : listMesReceita){
                        %>
                        <tr>
                            
                            <td><%= r.getDescricaoReceita()%></td>
                            <td><%= r.getValorReceita()%></td>
                            <td><%= r.getData().getMes() %></td>
                            <td><%= r.getData().getAno() %></td>
                            
                           
                        </tr>
                        
                        <%
                        totalReceita=r.getValorReceita()+totalReceita;
                    }
                %>
                <tr>
                <br>
                <td colspan="4"><b>Total Receita R$: <%= totalReceita %> </b></td>
               </tr>
                
            </table >
               <br>       
            <table border=4>
                <tr><a><b>GASTOS:</b></a>   
                  
                    <td>Descrição Gastos</td>
                    <td>Valor Gastos </td>
                    <td>Mês </td>
                    <td>Ano</td>
                   
                </tr>
                <%
                    double totalGasto=0;
                    GastoImpl gastoImpl = new GastoImpl();
                    List<Gasto> listMesGasto= gastoImpl.getListData(id_data);
                    for(Gasto g : listMesGasto){
                        %>
                        <tr>
                            
                            <td><%= g.getDescricaoGasto() %></td>
                            <td><%= g.getValorgasto() %></td>
                            <td><%= g.getData().getMes() %></td>
                            <td><%= g.getData().getAno() %></td>
                            
                            
                        </tr>
                        
                        <%
                        totalGasto=g.getValorgasto()+totalGasto;
                    }
                %>
                <tr>
                <br>
                <td colspan="4"><b>Total Gatos R$: <%= totalGasto %> </b></td>
               </tr>
                
            </table>            
             <br> 
        
             <table>
                <tr>           
                <td><b>Saldo Restante R$: <%= totalReceita-totalGasto %> </b></td>
               </tr>
             </table>
               <br>         
             <button><a href="index.html">Inicio</a></button>
        </div>
    </body>
</html>
