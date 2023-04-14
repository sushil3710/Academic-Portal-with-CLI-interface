package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Vector;

public class SemCreds{
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/acads";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "SushilK3710@";
    Connection connection = null;
    PreparedStatement stmt = null;
    ResultSet resultSet = null;
    Scanner sc=null;


    public double semcreds(String StudentId,int year,int sem) throws SQLException {

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            //check credits limit
            double creditDone = 0;
            Vector<Integer> CompltedCourses = new Vector<>();
            Vector<Integer> CreditCourses = new Vector<>();
            Vector<String> Credits = new Vector<String>();


            //Get the credits of currently enrolled Courses for this sem
            String query = "select offering_id from student_courses_status where student_id=? and status='Completed';";
            stmt = connection.prepareStatement(query);
            stmt.setString(1, StudentId);
            resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                CompltedCourses.add(resultSet.getInt(1));

            }




            for (int k = 0; k < CompltedCourses.size(); k++) {
                query = "select course_id from course_offering where offering_id=? and year=? and semester=?;";
                stmt = connection.prepareStatement(query);
                stmt.setInt(1, CompltedCourses.get(k));
                stmt.setInt(2,year);
                stmt.setInt(3,sem);
                resultSet = stmt.executeQuery();

                while (resultSet.next()) {
                    Credits.add(resultSet.getString(1));
                }

            }

                for (int k = 0; k < Credits.size(); k++) {
                    query = "select * from course_catalogue where course_id=?;";
                    stmt = connection.prepareStatement(query);
                    stmt.setString(1, Credits.get(k));
                    resultSet = stmt.executeQuery();

                    while (resultSet.next()) {
                        creditDone = creditDone + (resultSet.getDouble("c"));
                    }

            }

            //System.out.println(Math.round(creditDone*100.0)/100.0);
            connection.close();
                return Math.round(creditDone*100.0)/100.0;

        }
        catch (SQLException e) {e.printStackTrace();stmt.close();sc.close();return 0;}

    }
}

