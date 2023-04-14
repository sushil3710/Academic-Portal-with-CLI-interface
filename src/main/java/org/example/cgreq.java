package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class cgreq {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/acads";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "SushilK3710@";
    Connection connection = null;
    PreparedStatement stmt = null;
    ResultSet resultSet = null;
    Scanner sc=null;


    public double cgreq(int offer_id ) throws SQLException {

        double req_cg=0;
        try{
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            double cgpa;

            String query = "select cgpa_requirement from course_offering where offering_id=?;";
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, offer_id);
            resultSet = stmt.executeQuery();

            while(resultSet.next()){
                //if course is again floated for same batch then automatically last offering will be considered for cgpa req
                req_cg=resultSet.getDouble("cgpa_requirement");
            }
            resultSet.close();
            stmt.close();

            }

        catch (SQLException e) {e.printStackTrace();stmt.close();sc.close();}
       connection.close(); return req_cg;}
}
