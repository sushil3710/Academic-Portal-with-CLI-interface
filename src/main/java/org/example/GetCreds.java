package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Vector;

public class GetCreds {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/acads";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "SushilK3710@";



    public double getcreds(String StudentId,int year,int sem) throws SQLException {
        double re=0;
        Connection connection = null;
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        Scanner sc=null;

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            //check credits limit
            double creditDone = 0;


            Vector<String> enrolledCourses = new Vector<String>();

            //get the batch
            String query = "SELECT batch from student where student_id=?;";
            stmt = connection.prepareStatement(query);
            stmt.setString(1, StudentId);
            resultSet = stmt.executeQuery();
            int batch=0;
            while(resultSet.next()){
                batch=resultSet.getInt(1);
            }
            stmt.close();
            resultSet.close();


            SemCreds scred=new SemCreds();

            re = (sem == 1) ? ((scred.semcreds(StudentId, year-1, 1) + scred.semcreds(StudentId, year-1, 2)) * 1.25 / 2) : ((scred.semcreds(StudentId, year-1, 2) + scred.semcreds(StudentId, year, 1)) * 1.25 / 2);



        }
        catch (SQLException e) {e.printStackTrace();stmt.close();sc.close();}
        connection.close();return Math.round(re*100.0)/100.0;
}
}

