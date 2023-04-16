package com.ambulaproject.locationproblem.API;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Get_Users {
    String name;
    int longitude;
    int latitude;
    double distance=0.0;

    Get_Users(String name, int a, int b ){
        this.name=name;
        longitude=a;
        latitude=b;
    }
    Get_Users(Get_Users a){
        this.name=a.name;
        this.longitude=a.longitude;
        this.latitude=a.latitude;
        this.distance=a.distance;
    }

    private Get_Users [] sortUsers(Get_Users[] arr,int fer){
        int i,j;
        for( i=0;i<fer-1;i++){
            for(j=0;j<fer-i-1;j++){
                if(arr[j].distance>arr[j+1].distance){
                    Get_Users s=new Get_Users(arr[j]);
                    arr[j]=new Get_Users(arr[j+1]);
                    arr[j+1]=new Get_Users(s);
                }
            }
        }
        return arr;
    }

    public Get_Users[] get_users(int n){
        Connection connection=null;
        int flag=0;
        ResultSet rs;
        int fer=0;
        Get_Users userlist[]=new Get_Users[10];

        try {
            Class.forName("org.hsqldb.jdbc.JDBCDriver");
            connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/", "SA", "");
            Statement DbStatement = connection.createStatement();
            ResultSet re = DbStatement.executeQuery("SELECT COUNT(*) FROM studentdetail");
            re.next();
            fer=re.getInt(1);
            String[] result = new String[fer-1];
             rs= DbStatement.executeQuery("SELECT * FROM user_locations;");

             int i=0;
             while(rs.next()) {
                 String dataLine = rs.getString(1) + " " + rs.getString(2) + " " + rs.getString(3);
                 userlist[i] = new Get_Users(rs.getString(1), rs.getInt(2), rs.getInt(3));
                 i++;
             }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        for(int i=0;i<fer;i++){
            double dis=Math.sqrt(Math.pow(userlist[i].latitude,2)+Math.pow(userlist[i].longitude,2));
            userlist[i].distance=dis;
        }
        userlist=sortUsers(userlist,fer);
        Get_Users [] result=new Get_Users[n];
        for(int i=0;i<n;i++) {
            result[i] = new Get_Users(userlist[i]);
        }
        return result;
    }

}
