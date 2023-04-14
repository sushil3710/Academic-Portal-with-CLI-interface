package org.example;

import java.sql.*;
import java.util.Scanner;
import java.util.Vector;

public class BtechComplete {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/acads";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "SushilK3710@";
    Connection connection = null;
    PreparedStatement stmt = null;
    ResultSet resultSet = null;
    Scanner sc=new Scanner(System.in);

    public String btech(int batch,String Dept,String StudentId) throws SQLException {

        String transcript="";
        try{
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);

            String query="select * from student_courses_status where course_id='CP302' and status='Completed';";
            stmt=connection.prepareStatement(query);
            resultSet=stmt.executeQuery();
            if(!resultSet.next()){
                transcript+="BTP Course Not Completed";
            }

                query="select * from student_courses_status where course_id='CP303' and status='Completed';";
                stmt=connection.prepareStatement(query);
                resultSet=stmt.executeQuery();
                if(!resultSet.next()){
                    transcript+="BTP Course Not Completed";
                }
                //check for credits completed or not programs wise
                    Vector<Integer>courses=new Vector<>();
                    query="select * from student_courses_status where status='Completed';";
                    stmt=connection.prepareStatement(query);
                    resultSet=stmt.executeQuery();
                    while(resultSet.next()){
                        courses.add(resultSet.getInt("offering_id"));
                    }

                    Vector<String>cour=new Vector<>();
                    for(int i=0;i<courses.size();i++) {
                        query = "select * from course_offering where offering_id=?;";
                        stmt = connection.prepareStatement(query);
                        stmt.setInt(1,courses.get(i));
                        resultSet = stmt.executeQuery();
                        while (resultSet.next()) {
                            cour.add(resultSet.getString("course_id"));
                        }
                    }


                    //program core
                    double pc_creds=0;
                    double el_creds=0;
                    double ec_creds=0;
                    double total_creds=0;


                    for(String course: cour){

                        query="select * from " +Dept+ " where batch=? and ?=ANY(program_core);";
                        stmt=connection.prepareStatement(query);
                        stmt.setInt(1,batch);
                        stmt.setString(2,course);
                        resultSet=stmt.executeQuery();
                        while(resultSet.next()){
                            query="select * from course_catalogue where course_id=? ";
                            stmt=connection.prepareStatement(query);
                            stmt.setString(1,course);
                            ResultSet res=stmt.executeQuery();
                            while(res.next()){
                                pc_creds+=res.getDouble("c");
                            }
                        }


                        query="select * from " +Dept+" where batch=? and ?=ANY(electives);";
                        stmt=connection.prepareStatement(query);
                           stmt.setInt(1,batch);
                           stmt.setString(2,course);
                        resultSet=stmt.executeQuery();
                        while(resultSet.next()){
                            query="select * from course_catalogue where course_id=?;";
                            stmt=connection.prepareStatement(query);
                            stmt.setString(1,course);
                            ResultSet res=stmt.executeQuery();
                            while(res.next()){
                                el_creds+=res.getDouble("c");
                            }

                        }


                        query="select * from "+Dept+" where batch=? and ?=ANY(engineering_core);";
                        stmt=connection.prepareStatement(query);
                           stmt.setInt(1,batch);
                           stmt.setString(2,course);
                        resultSet=stmt.executeQuery();
                        while(resultSet.next()){
                            query="select * from course_catalogue where course_id=?;";
                            stmt=connection.prepareStatement(query);
                            stmt.setString(1,course);
                            ResultSet res=stmt.executeQuery();
                            while(res.next()){
                                ec_creds+=res.getDouble("c");
                            }
                        }

                           query="select * from course_catalogue where  course_id=?;";
                           stmt=connection.prepareStatement(query);
                           stmt.setString(1,course);
                           ResultSet res=stmt.executeQuery();
                           while(res.next()){
                            total_creds+=res.getDouble("c");
                        }

                    }

                   if(pc_creds<60 || ec_creds<30){
                       transcript+="\nCredits Not Complete For Btech,Failed\n";

                   }else{
                       transcript+="\nCredits  Done="+total_creds+" For Btech, Passed\n";
                   }
                    GetCgpa getcg=new GetCgpa();
                   double cgpa=Math.round(getcg.getcgpa(StudentId)*100.0)/100.0;
                   transcript+="\nCGPA : "+Double.toString(cgpa)+"\n";
                  // System.out.println(transcript);

           }

        catch (SQLException e) {e.printStackTrace();sc.close();System.out.println("Connection Failed");return "";}
       connection.close(); return transcript;

}
}
