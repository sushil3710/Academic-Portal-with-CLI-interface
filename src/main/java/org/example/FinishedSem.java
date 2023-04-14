package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class FinishedSem {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/acads";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "SushilK3710@";
    Connection connection = null;
    PreparedStatement stmt = null;
    ResultSet resultSet = null;
    Scanner sc=null;



    public pair finSem() throws SQLException {
        int yearOn = 0, semOn = 0;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            String query = "Select year,semester from semester_status where status='Completed';";
            stmt = connection.prepareStatement(query);
            resultSet = stmt.executeQuery();

            resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                yearOn = resultSet.getInt("year");
                semOn = resultSet.getInt("semester");
            }
            resultSet.close();
            stmt.close();
            connection.close();

        }     catch (SQLException e) {e.printStackTrace();stmt.close();sc.close();System.out.println("Connection Failed in deregistartion");}
        connection.close();return new pair(yearOn, semOn);
    }

}
