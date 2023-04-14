package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Vector;

public class EnrolledCreds {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/acads";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "SushilK3710@";
    Connection connection = null;
    PreparedStatement stmt = null;
    ResultSet resultSet = null;
    Scanner sc=null;


    public double encreds(String StudentId) throws SQLException {

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            //check credits limit
            double getCredits = 0;
            double creditEnrolled = 0;
            Vector<String> enrolledCourses = new Vector<String>();

            //Get the credits of currently enrolled Courses for this sem
            String query = "select course_id from student_courses_status where student_id=? and status='Enrolled';";
            stmt = connection.prepareStatement(query);
            stmt.setString(1,StudentId);
            resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                enrolledCourses.add(resultSet.getString(1));
            }


            for (int k = 0; k < enrolledCourses.size(); k++) {
                query = "select * from course_catalogue where course_id=?";
                stmt = connection.prepareStatement(query);
                stmt.setString(1, enrolledCourses.get(k));
                resultSet = stmt.executeQuery();
                while (resultSet.next()) {
                    creditEnrolled = creditEnrolled + (resultSet.getDouble("c"));
                }

            }

            connection.close();  return Math.round(creditEnrolled*100)/100.0;

        } catch (SQLException e) {e.printStackTrace();stmt.close();sc.close();connection.close(); }
        return 0;

    }

    }
