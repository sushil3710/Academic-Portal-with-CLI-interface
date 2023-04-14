package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class Admin {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/acads";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "SushilK3710@";

    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;
    String studentName = null;

    Scanner sc=new Scanner(System.in);


    AdminViewGrade avg=new AdminViewGrade();
    AdminViewAllGrade avlg=new AdminViewAllGrade();
    transcript trans=new transcript();


    int res=0;

    public Admin() {

    }

    public int admin(String AdminId, String email, String password) throws SQLException {

        try {
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            String sql = "SELECT * FROM admin WHERE admin_id = ? AND email = ? AND password = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, AdminId);
            statement.setString(2, email);
            statement.setString(3, password);
            ResultSet result = statement.executeQuery();

            if (!result.next()) {
                System.out.println("Invalid email or password.");
                statement.close();
                result.close();
                return 0;
            }


            if(AdminId=="dean123"){
                System.out.println("Login successful as Dean. Welcome, " + AdminId + "!");
            }
            statement.close();
            result.close();

        }
        catch (SQLException e) {e.printStackTrace();stmt.close();sc.close();System.out.println("Connection Failed in Student");}

        System.out.println("Login successful. Welcome, " + AdminId + "!");
        conn.close();
        return  1;

    }
}
