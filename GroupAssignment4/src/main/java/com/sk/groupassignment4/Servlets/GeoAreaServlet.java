package com.sk.groupassignment4.Servlets;

import com.sk.groupassignment4.Module.GeoGraphicArea;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.sk.groupassignment4.DataBaseConnection.DBUtil;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

//GeoAreaServlet
@WebServlet(name = "GeoAreaServlet", value = "/")
public class GeoAreaServlet extends HttpServlet {







    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);

        String action = req.getServletPath();

        try {
            switch (action) {

                case "/detail":
                    showDetailsForm(req, resp);
                    break;

                default:
                    listGeoAreas(req, resp);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }


    }





    private void listGeoAreas(HttpServletRequest req, HttpServletResponse resp)
            throws SQLException, ServletException, IOException {
        List<GeoGraphicArea> allData = DBUtil.getAllDatas();

        List<GeoGraphicArea> level0 = new ArrayList<GeoGraphicArea>();
        List<GeoGraphicArea> level1 = new ArrayList<GeoGraphicArea>();
        List<GeoGraphicArea> level2 = new ArrayList<GeoGraphicArea>();
        List<GeoGraphicArea> level3 = new ArrayList<GeoGraphicArea>();

        if ( allData.size() > 1)
        {
            for( GeoGraphicArea g : allData)
            {
                if(g.getLevel() == 0)
                    level0.add(g);
                if(g.getLevel() == 1)
                    level1.add(g);
                if(g.getLevel() == 2)
                    level2.add(g);
                if(g.getLevel() == 3)
                    level3.add(g);
            }

            req.setAttribute("list0", level0);
            req.setAttribute("list1", level1);
            req.setAttribute("list2", level2);
            req.setAttribute("list3", level3);
        }


        req.getRequestDispatcher("GeoArea.jsp").forward(req, resp);

    }

    private void showDetailsForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        GeoGraphicArea singleData = DBUtil.getsingleDatas(id);
        int  total_ = DBUtil.getTotalPopulation(id);

        request.setAttribute("id", singleData.getGeoGraphicAreaId());
        request.setAttribute("name", singleData.getName());
        request.setAttribute("code", singleData.getCode());
        request.setAttribute("level", singleData.getLevel());
        request.setAttribute("altercode", singleData.getAlternativeCode());
        request.setAttribute("totalp", total_);

        RequestDispatcher dispatcher = request.getRequestDispatcher("Detail.jsp");
        dispatcher.forward(request, response);

    }

















    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);

        doGet(req,resp);
    }
}
