package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Deregistration {

    private static final String DB_URL = "jdbc:postgresql://localhost:5432/acads";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "SushilK3710@";
    Connection connection = null;
    PreparedStatement stmt = null;
    ResultSet resultSet = null;
    Scanner sc=new Scanner(System.in);


    public int deregister(String StudentId,String courseId) throws SQLException {
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            currentSemester sem = new currentSemester();
            pair yearsem = sem.currentSem();

            if (yearsem.getFirst() != 0) {
                deregcourse dc = new deregcourse();
                dc.deregister(StudentId, courseId);

            } else {System.out.println("No ongoing Semester for registration");}


        } catch (SQLException e) {e.printStackTrace();stmt.close();sc.close();System.out.println("Connection Failed in deregistartion");return 0;}
        connection.close(); return 1; }

}
