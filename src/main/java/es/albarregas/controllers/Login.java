/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package es.albarregas.controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Pedro Lazaro
 */
@WebServlet(name = "Login", urlPatterns = { "/Login" })
public class Login extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String error = "Tienes que logearte primero";

        request.setAttribute("error", error);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        final String user = "pedro19";
        final String password = "789123";

        String userRequest = request.getParameter("usuario");
        String userPassword = request.getParameter("password");
        String recordar = request.getParameter("recordar");
        String error = "";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        Cookie[] cookies = request.getCookies();

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("ultimoAcceso")) {

                LocalDateTime fecha = LocalDateTime.parse(cookie.getValue());
                String formattedDate = fecha.format(formatter);
                request.setAttribute("ultimoAcceso", formattedDate);
            }
        }

        if (userRequest.equals(user) && userPassword.equals(password)) {
            request.getSession().setAttribute("usuario", userRequest);
            request.getSession().setAttribute("password", userPassword);
            request.getRequestDispatcher("JSP/logeado.jsp").forward(request, response);
        } else {
            error = "Usuario o contraseña incorrectos";
            request.setAttribute("error", error);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

        if (recordar != null) {
            Cookie cookie = new Cookie("user", userRequest);
            cookie.setMaxAge(86400);
            response.addCookie(cookie);
        }

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
