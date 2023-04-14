package org.example;
import java.sql.*;
import java.util.Scanner;

public class editaddress implements editDetail{


    private static final String DB_URL = "jdbc:postgresql://localhost:5432/acads";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "SushilK3710@";
    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet result = null;
    Scanner sc=new Scanner(System.in);
    final String USER="student";

    @Override
    public boolean editdetail(String StudentId,String address) throws SQLException {


        try{
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            String sql = "Update student set address=? where student_id=?;";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, address);
            stmt.setString(2, StudentId);
            stmt.execute();
            System.out.println("Address has been updated to: " + address);
            stmt.close();
            sc.close();
            conn.close();

        }

        catch (SQLException e) {e.printStackTrace();stmt.close();sc.close(); }
        return true;
        }
}
