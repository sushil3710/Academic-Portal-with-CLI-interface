package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.Vector;

public class PreReq {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/acads";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "SushilK3710@";
    Connection connection = null;
    PreparedStatement stmt = null;
    ResultSet resultSet = null;
    Scanner sc=null;


    public int prereq(String StudentId,int offer_id ) throws SQLException {

        try{
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            String query = "SELECT * FROM course_offering WHERE offering_id=?;";
            stmt = connection.prepareStatement(query);
            stmt.setInt(1,offer_id);
            resultSet = stmt.executeQuery();
            String course_id="";
            while(resultSet.next()){
                course_id=resultSet.getString("course_id");
            }


            int pre_chk=0;
            query = "SELECT * from course_catalogue where course_id=?;";
            stmt = connection.prepareStatement(query);
            stmt.setString(1, course_id);
            resultSet = stmt.executeQuery();
            Vector<String> prereqs = new Vector<>();
            while(resultSet.next()){
                String prerequisitesStr = resultSet.getString("prerequisites");
                if (prerequisitesStr != null && !prerequisitesStr.isEmpty()) {
                    String[] prerequisitesArray = prerequisitesStr.split(",");
                    for (String prerequisite : prerequisitesArray) {
                        prereqs.add(prerequisite.trim());
                        //System.out.println(prerequisite.trim());
                    }
                }

            }


            if(prereqs.size()==0){
                pre_chk=1;
            }
            else{
                query = "SELECT * from student_courses_status where student_id=? and status='Completed';";
                stmt = connection.prepareStatement(query);
                stmt.setString(1, StudentId);
                resultSet = stmt.executeQuery();
                while(resultSet.next()){
                    String id=resultSet.getString("course_id");
                    if(prereqs.contains("{"+id+"}")){
                        pre_chk=1;
                        break;
                    }

                }

            }



            if(pre_chk==0){
                System.out.println("You have not done any prerequisite of the Given course, hence you cannot apply");
                connection.close(); return 0;
            }



        }
        catch (SQLException e) {e.printStackTrace();stmt.close();sc.close(); }
        connection.close(); return 1;}

}
