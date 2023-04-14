package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class Student {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/acads";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "SushilK3710@";

    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    String studentName = null;
    int res=0;

    public int student(String studentId,String email,String password) throws SQLException {

        try {
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            String sql = "SELECT * FROM student WHERE student_id = ? AND email = ? AND password = ?";
            stmt= conn.prepareStatement(sql);
            stmt.setString(1, studentId);
            stmt.setString(2, email);
            stmt.setString(3, password);
            rs = stmt.executeQuery();
//            rs.close();

            if (!rs.next()) {
                System.out.println("Invalid email or password.");
                stmt.close();
                rs.close();
                return 0;
            }

            stmt.close();
            rs.close();
            System.out.println("Login successful. Welcome, " + studentId + "!");



    }
        catch (SQLException e) {e.printStackTrace();stmt.close();return 0; }
        conn.close(); return 1;
}
}
