package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class courseofferstatus {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/acads";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "SushilK3710@";
    Connection connection = null;
    PreparedStatement stmt = null;
    ResultSet resultSet = null;
    Scanner sc=null;


    public int status(int year,int sem,String courseid) throws SQLException {

        int offering_id=0;
        try{
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);


        String query="select offering_id,year,semester from course_offering where course_id=?;";
        stmt=connection.prepareStatement(query);
        stmt.setString(1,courseid);
        resultSet=stmt.executeQuery();

        int ychk=0,semchk=0;
        while(resultSet.next()){
            offering_id=resultSet.getInt(1);
            ychk=resultSet.getInt(2);
            semchk=resultSet.getInt(3);

        }


        if(year!=ychk || semchk!=sem){
            System.out.println("Course is not open for offering");
            return 0;
        }

            System.out.println("Course open for offering");



    }
        catch (SQLException e) {e.printStackTrace();stmt.close();sc.close();}
      connection.close(); return offering_id;
    }


}
