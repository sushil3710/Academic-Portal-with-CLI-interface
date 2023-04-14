package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class RegBatch{
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/acads";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "SushilK3710@";
    Connection connection = null;
    PreparedStatement stmt = null;
    ResultSet resultSet = null;
    Scanner sc=null;


    public int regbatch(String StudentId,int offer_id)throws SQLException {

        try{
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            String query = "SELECT batch from student where student_id=?;";
            stmt = connection.prepareStatement(query);
            stmt.setString(1, StudentId);
            resultSet = stmt.executeQuery();
            int batch=0;
            while(resultSet.next()){
                batch=resultSet.getInt(1);
            }
            stmt.close();
            resultSet.close();


            query = "SELECT count(*) from course_offering where offering_id=? and ?= ANY(allowed_batches);";
            stmt = connection.prepareStatement(query);
            stmt.setInt(1, offer_id);
            stmt.setInt(2,batch);
            resultSet = stmt.executeQuery();
            int count=0;
            while(resultSet.next()){
                count=resultSet.getInt(1);
            }
            stmt.close();
            resultSet.close();

            if(count!=0){
                connection.close();  return 1;
            }
            System.out.println("No offering of the given course for your batch");


        }
        catch (SQLException e) {e.printStackTrace();stmt.close();sc.close();}

        connection.close();return 0;
    }


}
