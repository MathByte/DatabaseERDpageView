package com.sk.groupassignment4.Servlets;

import com.sk.groupassignment4.DataBaseConnection.DBUtil;
import com.sk.groupassignment4.Module.GeoGraphicArea;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "GeoDetailServlet", value = "/geoAreaServlet/detail")
public class GeoDetailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        GeoGraphicArea singleData = DBUtil.getsingleDatas(id);
        int  total_ = DBUtil.getTotalPopulation(id);

        request.setAttribute("id", singleData.getGeoGraphicAreaId());
        request.setAttribute("name", singleData.getName());
        request.setAttribute("code", singleData.getCode());
        request.setAttribute("level", singleData.getLevel());
        request.setAttribute("altercode", singleData.getAlternativeCode());
        request.setAttribute("totalp", total_);

        RequestDispatcher dispatcher = request.getRequestDispatcher("../Detail.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
