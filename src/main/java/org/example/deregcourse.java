package org.example;
import java.sql.*;
import java.util.Scanner;

public class deregcourse {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/acads";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "SushilK3710@";
    Connection connection = null;
    PreparedStatement stmt = null;
    ResultSet resultSet = null;
    Scanner sc=new Scanner(System.in);
    public int deregister(String StudentId,String CourseID) throws SQLException {
        try{
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            String query="Delete from student_courses_status where student_id=? and course_id=? and status='Enrolled';";
            stmt = connection.prepareStatement(query);
            stmt.setString(1,StudentId);
            stmt.setString(2,CourseID);

            int rowsDeleted = stmt.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("The course has been deregistered from the students Enrolled courses");
            } else {
                System.out.println("No such course enrolled currently");

            }


        } catch (SQLException e) {e.printStackTrace();stmt.close();sc.close();System.out.println("Connection Failed in deregcourse");return -1;  }
        connection.close(); return 0;}
}
