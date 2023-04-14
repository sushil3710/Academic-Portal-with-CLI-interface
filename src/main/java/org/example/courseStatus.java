package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class courseStatus {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/acads";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "SushilK3710@";
    Connection connection = null;
    PreparedStatement stmt = null;
    ResultSet resultSet = null;


    public int coursestatus(String StudentId,int offer_id ) throws SQLException {

        try{
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            String query = "SELECT * FROM course_offering WHERE offering_id=?;";
            stmt = connection.prepareStatement(query);
            stmt.setInt(1,offer_id);
            resultSet = stmt.executeQuery();
            String course_id="";
            while(resultSet.next()){
                course_id=resultSet.getString("course_id");
            }
            resultSet.close();
            stmt.close();


            query = "SELECT status FROM student_courses_status WHERE student_id=? and course_id=?;";
            stmt = connection.prepareStatement(query);
            stmt.setString(2, course_id);
            stmt.setString(1,StudentId);
            resultSet = stmt.executeQuery();
            String status="";

            while(resultSet.next()){
                status=resultSet.getString(1);
            }

            if(status==""){return 1;}
            if(status=="Completed"){
                System.out.println("You have already completed the course, hence you can't Apply");
            }
            else if(status=="Enrolled"){System.out.println("You are already Enrolled for this course");}

            resultSet.close();stmt.close();connection.close();

        }
        catch (SQLException e) {e.printStackTrace();stmt.close();}
        return 0;
    }


}
