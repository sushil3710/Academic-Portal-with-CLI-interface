package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class StudentViewGrades implements ViewGrades{

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/acads";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "SushilK3710@";
    Connection connection = null;
    PreparedStatement stmt = null;
    ResultSet resultSet = null;
    Scanner sc=new Scanner(System.in);

    public boolean viewgrades(String StudentId) throws SQLException {

        try{
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            String query="Select * from student_courses_status where student_id=? and status='Completed';";
            stmt = connection.prepareStatement(query);
            stmt.setString(1,StudentId);
            resultSet=stmt.executeQuery();

            String cr="";
                System.out.println("Grades of All the courses of Student with Id "+StudentId+":");
                System.out.println("CourseId\tGrade");
                while(resultSet.next()){
                     cr=resultSet.getString("course_id");
                    String grades=resultSet.getString("grade");
                    System.out.println(cr+"\t"+grades);
                }


            if(cr==""){System.out.println("No Completed Courses yet");
            }
            resultSet.close();
            stmt.close();


        }
        catch (SQLException e) {e.printStackTrace();stmt.close();sc.close();System.out.println("Connection Failed in registration");}

        connection.close(); return true;
    }

}
