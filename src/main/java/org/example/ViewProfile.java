package org.example;
import java.sql.*;
import java.util.Scanner;
public class ViewProfile {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/acads";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "SushilK3710@";
    Connection connection = null;
    PreparedStatement stmt = null;
    ResultSet resultSet = null;
    Scanner sc=null;

    public boolean viewprofile(String StudentId) throws SQLException {
        try{
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        String result = "SELECT * from student where student_id=?;";
        stmt = connection.prepareStatement(result);
       stmt.setString(1, StudentId);
        resultSet = stmt.executeQuery();


        while (resultSet.next()) {


            String student_id = resultSet.getString("student_id");
            String name = resultSet.getString("name");
            String dept_name = resultSet.getString("dept_name");
            int batch = resultSet.getInt("batch");
            String phone = resultSet.getString("phone_numb");
            String address = resultSet.getString("address");

            // Print the values
            System.out.println("ID: " + student_id);
            System.out.println("Name: " + name);
            System.out.println("Department name: " + dept_name);
            System.out.println("Batch: " + batch);
            System.out.println("Phone Number: " + phone);
            System.out.println("Address: " + address);
            System.out.println();

            System.out.println("\nProfile Viewed Successfully");
            stmt.close();
            resultSet.close();
            connection.close(); return true;

        }

        }
        catch (SQLException e) {e.printStackTrace();stmt.close();sc.close(); }
        connection.close();return false;
    }


}
