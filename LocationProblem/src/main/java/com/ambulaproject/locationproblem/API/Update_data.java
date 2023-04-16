package com.ambulaproject.locationproblem.API;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Update_data {
    private String name;
    private int longitude;
    private int latitude;

    public int update_data(String name,int longitude,int latitude){
        this.name=name;
        this.longitude=longitude;
        this.latitude=latitude;
        int flag=0;
        try {
            Connection connection=null;

            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/", "SA", "");
            Statement DbStatement = connection.createStatement();

            flag = DbStatement.executeUpdate("INSERT INTO user_location VALUES(name,longitude,latitude);");
        }
        catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return flag;
    }


}
