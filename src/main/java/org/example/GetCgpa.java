package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class GetCgpa {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/acads";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "SushilK3710@";
    Connection connection = null;
    PreparedStatement stmt = null;
    ResultSet resultSet = null;
    Scanner sc=null;


    public double getcgpa(String StudentId) throws SQLException {

        try{
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            double cgpa=0;
            double grades=0;
            double credits=0;

                Vector<String> completedCourses = new Vector<>();
                String query = "SELECT course_id,grade FROM student_courses_status WHERE student_id=? and status = 'Completed';";
            stmt = connection.prepareStatement(query);
            stmt.setString(1, StudentId);
            resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                    completedCourses.add(resultSet.getString(1));
                    grades=grades+gradepoints(resultSet.getString(2));
            }

            for(int i=0;i<completedCourses.size();i++){
                 query = "SELECT c FROM course_catalogue WHERE course_id=?;";
                stmt = connection.prepareStatement(query);
                stmt.setString(1, completedCourses.get(i));
                resultSet = stmt.executeQuery();
                while (resultSet.next()) {
                   credits=credits+resultSet.getDouble(1);
                }

            }

//           System.out.println(credits);
//            System.out.println(grades);
            cgpa=(double)grades/credits;
            resultSet.close();
            stmt.close();connection.close();
            return Math.round(cgpa * 100.0) / 100.0;

        }
        catch (SQLException e) {e.printStackTrace();stmt.close();sc.close();connection.close();}
        return 0;
    }

    private double gradepoints(String grade) {
        double gradePoints = 0;

        if (grade.equals("A") || grade.equals("A+")) {
            gradePoints = 10.0;
        } else if (grade.equals("A-")) {
            gradePoints = 9.0;
        } else if (grade.equals("B")) {
            gradePoints = 8.0;
        } else if (grade.equals("B-")) {
            gradePoints = 7.0;
        } else if (grade.equals("C")) {
            gradePoints = 6.0;
        } else if (grade.equals("C-")) {
            gradePoints = 5.0;
           }
//        else if (grade.equals("D")) {
//            gradePoints = 4.0;
//        }  else {
//            gradePoints = 0.0;
//        }

        return gradePoints;
    }

}
