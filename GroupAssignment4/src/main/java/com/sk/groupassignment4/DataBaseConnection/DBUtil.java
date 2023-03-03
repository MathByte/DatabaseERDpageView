package com.sk.groupassignment4.DataBaseConnection;

import com.sk.groupassignment4.Beans.Ages;
import com.sk.groupassignment4.Beans.Employee;
import com.sk.groupassignment4.Beans.GeoGraphicArea;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtil {





    public static int getTotalPopulation(int id) {
        String CHECK_geoArea_SQL = "select age.combined from age where age.censusYear = 1 and age.ageGroup = 1 and age.geographicArea = " + String.valueOf(id);
        int tot = 0;

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

                tot = rs.getInt(1);


            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return tot;
    }

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



    public static Ages getAllAges2016(){

        String CHECK_geoArea_SQL = "SELECT sum(combined), sum(male), sum(female) FROM age where censusYear = 1 and ageGroup = 1";
        Ages agelist = new Ages();

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
                Ages temp = new Ages();
                temp.setCombined(rs.getInt(1));
                temp.setMale(rs.getInt(2));
                temp.setFemale(rs.getInt(3));

                agelist = (temp);
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return agelist;
    }





    public static Ages getAllAges2021(){

        String CHECK_geoArea_SQL = "SELECT sum(combined), sum(male), sum(female) FROM age where censusYear = 2 and ageGroup = 1";
        Ages agelist = new Ages();

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
                Ages temp = new Ages();
                temp.setCombined(rs.getInt(1));
                temp.setMale(rs.getInt(2));
                temp.setFemale(rs.getInt(3));

                agelist = (temp);
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return agelist;
    }


    public  static int registerEmployee (Employee emp) throws ClassNotFoundException {
        String INSERT_USERS_SQL = "INSERT INTO employees" +
                "(userName, password, firstName, lastName) VALUES " +
                "(?, ?, ?, ?);";
        int result = 0;

        Class.forName("com.mysql.jdbc.Driver");
        // Get Connection
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Census", "root", "admin123");
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            //preparedStatement.setInt(1,1);
            preparedStatement.setString(1, emp.getUsername());
            preparedStatement.setString(2, emp.getPassword());
            preparedStatement.setString(3, emp.getFirstname());
            preparedStatement.setString(4, emp.getLastname());


            result = preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return result;
    }


    public static String checkEmployeeRegistration (String username, String password) throws ClassNotFoundException {
        String CHECK_USER_SQL = "SELECT username, password FROM employees";
        String result = "";

        Class.forName("com.mysql.jdbc.Driver");
        // Get Connection
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Census", "root", "admin123");
             Statement  stmt  = connection.createStatement();) {
            ResultSet rs = stmt.executeQuery(CHECK_USER_SQL);
            while(rs.next()){

                if (rs.getString(1).equals(username) && rs.getString(2).equals(password)){
                    result = rs.getString(1) + " " + rs.getString(2);
                }
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return result;
    }


}
