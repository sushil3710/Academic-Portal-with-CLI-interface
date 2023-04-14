package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class CredLimit {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/acads";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "SushilK3710@";
    Connection connection = null;
    PreparedStatement stmt = null;
    ResultSet resultSet = null;
    Scanner sc=null;


    public boolean limit(String StudentId,int year,int sem,String courseid) throws SQLException {

        try{
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            String query = "SELECT batch from student where student_id=?;";
            stmt = connection.prepareStatement(query);
            stmt.setString(1, StudentId);
            resultSet = stmt.executeQuery();
            int batch=0;
            while(resultSet.next()){
                batch=resultSet.getInt(1);
            }

            query = "SELECT c from course_catalogue where course_id=?;";
            stmt = connection.prepareStatement(query);
            stmt.setString(1, courseid);
            resultSet = stmt.executeQuery();
            double ccreds=0;
            while(resultSet.next()){
                ccreds=resultSet.getDouble(1);
            }


            EnrolledCreds e=new EnrolledCreds();
            double creden=e.encreds(StudentId);
            GetCreds a=new GetCreds();

            if(year==batch){
                    if(creden+ccreds<=19.5)return false;
            }
            else{
                double ck=a.getcreds(StudentId,year,sem);
                if(creden+ccreds>ck){
                    return true;
                }
            }


        }
        catch (SQLException e) {e.printStackTrace();stmt.close();sc.close();}
       connection.close(); return false;
    }



}
