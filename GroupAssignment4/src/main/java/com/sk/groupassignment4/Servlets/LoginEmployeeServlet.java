package com.sk.groupassignment4.Servlets;


import com.sk.groupassignment4.DataBaseConnection.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "EmployeeServlet", value = "/Login")
public class LoginEmployeeServlet extends HttpServlet {


    @Override

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ///String firstname = request.getParameter("firstname");
        //String lastname = request.getParameter("lastname");
        //String username = request.getParameter("username");
        String password = request.getParameter("password");
        String username = request.getParameter("username");



        try {
            String sucessLogin = DBUtil.checkEmployeeRegistration(username, password);
            if ( !sucessLogin.equals("")){
                request.setAttribute("firstname", sucessLogin.split(" ")[0]);
                request.setAttribute("lastname", sucessLogin.split(" ")[1]);
                request.getRequestDispatcher("success.jsp").forward(request, response);
            }
            else{
                request.getRequestDispatcher("signup.jsp").forward(request, response);
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        request.getRequestDispatcher("signup.jsp").forward(request, response);
    }
}
