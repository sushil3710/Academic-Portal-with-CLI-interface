package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class InstructorTasks implements tasks{

    @Override
    public int tasks(int a) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose an Option");
        System.out.println("1. View grade of all students\n2. Register\n3.deregister courses \n4.Update grades\n5. Log out");
        return 1;
    }
}
