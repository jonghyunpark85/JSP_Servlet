/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ca.sait.itsd;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author john
 */
@WebServlet(name = "SLcontroller", urlPatterns = {"/SLcontroller"})
public class SLcontroller extends HttpServlet {

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
        
        String listitem=request.getParameter("listitem");
        
        String add=request.getParameter("add");
        String remove=request.getParameter("remove");
        
        String delete=request.getParameter("delete");
        
        DBoperations dbOps=new DBoperations();
        
        if (listitem!=null && !listitem.equals((""))) {
            if (dbOps.addListItem(listitem)) {
                request.setAttribute("message","Item added");
            }
            else {
                request.setAttribute("message", "Error adding list item");
            }
        }
        else if (add!=null) {
            
            if (dbOps.toggleInCartStatus(Integer.parseInt(add))) {
                request.setAttribute("message","Item added to cart");
            }
            else {
                request.setAttribute("message", "Error adding item to cart");
            }            
        }
        else if (remove!=null) {
            
            if (dbOps.toggleInCartStatus(Integer.parseInt(remove))) {
                request.setAttribute("message","Item removed from cart");
            }
            else {
                request.setAttribute("message", "Error removing item from cart");
            }            
        }
        else if (delete!=null) {
            if (dbOps.deleteListItem(Integer.parseInt(delete))) {
                request.setAttribute("message","Item deleted");
            }
            else {
                request.setAttribute("message", "Error deleting item");
            }            
        }        
        
        //Get list data for JSP
        request.setAttribute("inCartItems", dbOps.getInCartItems());
        request.setAttribute("notInCartItems", dbOps.getNotInCartItems());
        
        request.getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
        
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
        processRequest(request, response);
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
