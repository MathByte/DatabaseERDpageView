package com.sk.groupassignment4.DataBaseConnection;

import com.sk.groupassignment4.Module.GeoGraphicArea;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtil {



    public static GeoGraphicArea getsingleDatas(int id) {
        String CHECK_geoArea_SQL = "SELECT * FROM GEOGRAPHICAREA where geographicAreaID = " + String.valueOf(id);
        GeoGraphicArea gArea = new GeoGraphicArea();

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        // Get Connection
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Census", "root", "admin123");
             Statement stmt  = connection.createStatement();) {
            ResultSet rs = stmt.executeQuery(CHECK_geoArea_SQL);
            while(rs.next()){
                GeoGraphicArea temp = new GeoGraphicArea();
                temp.setGeoGraphicAreaId(rs.getInt(1));
                temp.setCode(rs.getInt(2));
                temp.setLevel(rs.getInt(3));
                temp.setName(rs.getString(4));
                temp.setAlternativeCode(rs.getInt(5));
                //gArea.add(temp);
                gArea = temp;
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return gArea;
    }

    public static List<GeoGraphicArea> getAllDatas() {
        String CHECK_geoArea_SQL = "SELECT * FROM GEOGRAPHICAREA";
        ArrayList<GeoGraphicArea> gArea = new ArrayList<GeoGraphicArea>();

        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        // Get Connection
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Census", "root", "admin123");
             Statement stmt  = connection.createStatement();) {
            ResultSet rs = stmt.executeQuery(CHECK_geoArea_SQL);
            while(rs.next()){
                GeoGraphicArea temp = new GeoGraphicArea();
                temp.setGeoGraphicAreaId(rs.getInt(1));
                temp.setCode(rs.getInt(2));
                temp.setLevel(rs.getInt(3));
                temp.setName(rs.getString(4));
                temp.setAlternativeCode(rs.getInt(5));
                gArea.add(temp);
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return gArea;
    }
}
