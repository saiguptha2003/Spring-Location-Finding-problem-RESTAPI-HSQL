package com.ambulaproject.locationproblem.API;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Create_Data {
    public int create_data() throws SQLException {
        Connection connection = null;
        int flag = 0;

        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/", "SA", "");
            Statement DbStatement = connection.createStatement();

            flag = DbStatement.executeUpdate("CREATE  TABLE user_location (Name VARCHAR(100) NOT NULL,Latitude INT NOT NULL, Longitude INT NOT NULL PRIMARY KEY (id));");
        }
        catch (Exception e) {
                System.err.println("error-failed to driver.");
                e.printStackTrace();
            }
        return flag;
    }


}
