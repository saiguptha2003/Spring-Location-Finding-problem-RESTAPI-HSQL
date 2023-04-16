package com.ambulaproject.locationproblem.API;

import java.sql.*;

public class ConnectDatabase {
    public static void main(String[] args) throws SQLException {
        Connection con = null;

        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver" );
        } catch (Exception e) {
            System.err.println("ERROR: failed to load HSQLDB JDBC driver.");
            e.printStackTrace();
            return;
        }

        Connection c = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/", "SA", "");
        Statement stm=c.createStatement();
        ResultSet rs=stm.executeQuery("SELECT * FROM user_location ");
        ResultSetMetaData rsmd = rs.getMetaData();
        System.out.println("querying SELECT * FROM XXX");
        int columnsNumber = rsmd.getColumnCount();
        while (rs.next()) {
            for (int i = 1; i <= columnsNumber; i++) {
                if (i > 1) System.out.print(",  ");
                String columnValue = rs.getString(i);
                System.out.print(columnValue + " " + rsmd.getColumnName(i));
            }
            System.out.println("");
        }
        String s=rs.getString(1);
        System.out.println(s);
    }
}