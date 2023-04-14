package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class AdminTasks implements tasks{
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/acads";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "SushilK3710@";
    Connection connection = null;
    PreparedStatement stmt = null;
    ResultSet resultSet = null;
    Scanner sc=new Scanner(System.in);
    @Override
    public int tasks(int a) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose an Option");
        System.out.println("1.Edit Course Catalogue\n2.View Grades of All Student\n3.Generate Transcript of a Student\n4.LogOut");
        //connection.close();
        return 1;
    }

}
