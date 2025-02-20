package com.Capgemini.tomcat_servlet.simple_login_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve form parameters
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Hardcoded authentication (for testing)
        if ("bipin".equals(username) && "bipin123".equals(password)) {
            out.println("<h3>Login Successful! Welcome, " + username + ".</h3>");
        } else {
            out.println("<h3>Invalid Credentials. Please try again.</h3>");
        }
    }
}
