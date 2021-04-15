/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSPCalculator;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jonghyun Park
 */
@WebServlet(name = "jspCalculatorServlet", urlPatterns = {"/jspCalculatorServlet"})
public class jspCalculatorServlet extends HttpServlet {

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

        String firstNum = request.getParameter("first");
        String secondNum = request.getParameter("second");
        String message = "";

        if (firstNum.isEmpty() || secondNum.isEmpty()) {
            message = "--";
        } else {
            int first = Integer.parseInt(firstNum);
            int second = Integer.parseInt(secondNum);
            int total = 0;

            if (request.getParameter("add") != null) {
                total = first + second;
                message = Integer.toString(total);
            } else if (request.getParameter("minus") != null) {
                total = first - second;
                message = Integer.toString(total);
            } else if (request.getParameter("multiply") != null) {
                total = first * second;
                message = Integer.toString(total);
            } else if (request.getParameter("devide") != null) {
                total = first / second;
                message = Integer.toString(total);
            } else {
                message = "--";
            }

        }

        request.setAttribute("message", message);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
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
