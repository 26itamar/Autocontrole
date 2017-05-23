/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import controle.GastoImpl;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Gasto;

/**
 *
 * @author Sony Vaio
 */
@WebServlet(name = "CadastrarGastos", urlPatterns = {"/cadastrarGastos"})
public class CadastrarGastos extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CadastrarGastos</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet CadastrarGastos at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
         //recupera as informações da pagina cadastrarreceita.jsp   
        String descricao = request.getParameter("descricao");
        Double valor = Double.parseDouble(request.getParameter("valor"));   
        int id_data_g = Integer.valueOf(request.getParameter("data_g"));
        
   
        //cria o objeto para manipular e salvar no banco
        GastoImpl gastoImpl = new GastoImpl();
           
        //popula o objeto Receita
        Gasto g =new Gasto();
        g.setDescricaoGasto(descricao);
        g.setValorgasto(valor);
         
        //relaciona Receita com Data  
        g.getData().setId(id_data_g);

        //salva no banco
        gastoImpl.salvar(g);

        //retorna pra a tela de cadastro
        response.sendRedirect("index.html");      
        
        
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
