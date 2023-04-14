package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class StudentTasks{


    public boolean tasks(int a) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose an Option");
        System.out.println("1. Edit profile\n2. Register for a course\n3.Deregister course\n4.View grades\n5. Log out");
        return true;

    }
}
