package org.example;
import java.sql.*;
import java.util.Scanner;
public class editNumber implements editDetail{


    private static final String DB_URL = "jdbc:postgresql://localhost:5432/acads";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "SushilK3710@";
    Connection connection = null;
    PreparedStatement stmt = null;
    ResultSet result = null;
    Scanner sc=new Scanner(System.in);
    final String USER="student";

    @Override
    public boolean editdetail(String StudentId,String phone) throws SQLException {
try{
        connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        String sql = "Update student set phone_numb=? where student_id=?;";
        stmt = connection.prepareStatement(sql);
        stmt.setString(1, phone);
        stmt.setString(2, StudentId);
        stmt.execute();
        System.out.println("Phone number has been updated to: " + phone);
        stmt.close();
        sc.close();
    connection.close();

    }

    catch (SQLException e) {e.printStackTrace();stmt.close();sc.close();connection.close();}
return true;
    }
}
