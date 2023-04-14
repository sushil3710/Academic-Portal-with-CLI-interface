package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class AdminViewAllGrade implements ViewAllGrades{

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/acads";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "SushilK3710@";
    Connection connection = null;
    PreparedStatement stmt = null;
    ResultSet resultSet = null;
    Scanner sc=new Scanner(System.in);

    public boolean viewgrades(int a) throws SQLException {

        try{
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);


            String query="Select * from student_courses_status where status='Completed';";
            stmt = connection.prepareStatement(query);
            resultSet=stmt.executeQuery();

                System.out.println("Grades of All the students who have completed the courses");
                System.out.println("StudentID\tCourseId\tGrade");
                while(resultSet.next()){

                    String cr=resultSet.getString("student_id");
                    String cid=resultSet.getString("course_id");
                    String grades=resultSet.getString("grade");
                    System.out.println(cr+"\t"+cid+"\t"+grades);
                }

                resultSet.close();
                stmt.close();

        }
        catch (SQLException e) {e.printStackTrace();stmt.close();sc.close();System.out.println("Connection Failed in registration");}
connection.close();
        return true;


    }
}
