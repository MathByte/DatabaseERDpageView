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
@WebServlet(name = "GeoAreaServlet", value = "/geoAreaServlet")
public class GeoAreaServlet extends HttpServlet {






    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doGet(req, resp);

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






    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);

        doGet(req,resp);
    }
}
