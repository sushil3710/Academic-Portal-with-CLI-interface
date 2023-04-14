package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class Instructor {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/acads";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "SushilK3710@";

    Connection conn = null;
    PreparedStatement stmt = null;

    Scanner sc=new Scanner(System.in);


    public int instructor(String InstructorId, String email,String password) throws SQLException {

        try {
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            String sql = "SELECT * FROM instructor WHERE instructor_id = ? AND email = ? AND password = ?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, InstructorId);
            statement.setString(2, email);
            statement.setString(3, password);
            ResultSet result = statement.executeQuery();

            if (!result.next()) {
                System.out.println("Invalid email or password.");
                statement.close();
                result.close();
                return 0;
            }

            System.out.println("Login successful. Welcome, Instructor with ID:" + InstructorId + "!");
            statement.close();
            result.close();





        }
        catch (SQLException e) {e.printStackTrace();stmt.close();sc.close();System.out.println("Connection Failed");return 0;}
        conn.close(); return 1;

    }


}
