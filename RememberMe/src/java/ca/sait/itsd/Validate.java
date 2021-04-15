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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrator
 */
@WebServlet(name = "Validate", urlPatterns = {"/Validate"})
public class Validate extends HttpServlet {

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

        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String rememberMe = request.getParameter("rememberMe");
        String message = request.getParameter("message");

        if (username == null || password == null) {
            request.setAttribute("message", message);
            request.getRequestDispatcher("LoginPage").forward(request, response);
        } else if (username.equals("") || password.equals("")) {
            request.setAttribute("messgae", "Both username and password are requird!");
            request.getRequestDispatcher("LoginPage").forward(request, response);
        } else {
            if (rememberMe != null) {
                if (username.equals("user") && password.equals("pass")) {
                    Cookie usernameCookie = new Cookie("username", username);
                    Cookie rememberMeCookie = new Cookie("rememberMe", "true");

                    usernameCookie.setMaxAge(60 * 60);
                    rememberMeCookie.setMaxAge(60 * 60);

                    response.addCookie(usernameCookie);
                    response.addCookie(rememberMeCookie);
                }

            } else {
                for (Cookie c : request.getCookies()) {
                    if (c.getName().equals("username") || c.getName().equals("rememberMe")) {
                        c.setMaxAge(0);
                        response.addCookie(c);
                    }
                }
            }

            request.setAttribute("messgae", "Valid");
            request.getRequestDispatcher("LoginPage").forward(request, response);
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
