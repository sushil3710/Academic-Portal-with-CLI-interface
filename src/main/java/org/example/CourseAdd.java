package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Vector;

public class CourseAdd {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/acads";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "SushilK3710@";
    Connection connection = null;
    PreparedStatement stmt = null;
    ResultSet resultSet = null;
    Scanner sc=new Scanner(System.in);

    public int courseadd(String courseid,String coursname,int l,double t,double p,double s, double c,String[] stringArray) throws SQLException {

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            String query="insert into course_catalogue(course_id,name,l,t,p,s,c,prerequisites) values(?,?,?,?,?,?,?,?);";
            stmt=connection.prepareStatement(query);
            stmt.setString(1,courseid);
            stmt.setString(2,coursname);
            stmt.setInt(3,l);
            stmt.setDouble(4,t);
            stmt.setDouble(5,p);
            stmt.setDouble(6,s);
            stmt.setDouble(7,c);
            stmt.setArray(8,connection.createArrayOf("varchar", stringArray));
            stmt.execute();
            System.out.println("Course Added");
            stmt.close();


        }
        catch (SQLException e) {e.printStackTrace();stmt.close();sc.close();System.out.println("Connection Failed in registration");}
        connection.close();return 1;

    }
}
