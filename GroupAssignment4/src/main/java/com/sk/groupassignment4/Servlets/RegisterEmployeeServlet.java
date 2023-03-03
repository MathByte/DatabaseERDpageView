package com.sk.groupassignment4.Servlets;



import com.sk.groupassignment4.Beans.Employee;
import com.sk.groupassignment4.DataBaseConnection.DBUtil;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "RegisterEmployeeServlet", value = "/Register")
public class RegisterEmployeeServlet extends HttpServlet {




    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String password = request.getParameter("password");




        Employee employee = new Employee();

        employee.setUsername(username);
        employee.setFirstname(firstname);
        employee.setLastname(lastname);
        employee.setPassword(password);


        try {
            if(DBUtil.checkEmployeeRegistration(username, password).equals("")){
                DBUtil.registerEmployee(employee);
            }else {
                request.setAttribute("tag1", "Already Registered, Please Sign in!");
                request.getRequestDispatcher("Login.jsp").forward(request, response);
            }

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        request.setAttribute("tag1", "Registered, Please Sign in!");
        request.getRequestDispatcher("Login.jsp").forward(request, response);
    }
}
