package org.example;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;
import java.util.Scanner;
import java.util.Vector;

import static java.lang.Math.min;

public class transcript {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/acads";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "SushilK3710@";
    Connection connection = null;
    PreparedStatement stmt = null;
    ResultSet resultSet = null;

    public boolean transcript(String StudentID) throws SQLException {



        try{
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            String query="Select batch from student where student_id=?;";
            stmt=connection.prepareStatement(query);
            stmt.setString(1,StudentID);
            resultSet= stmt.executeQuery();
            int batch=0;
            while(resultSet.next()){
                batch=resultSet.getInt("batch");
            }

            FinishedSem sem=new FinishedSem();
            pair yearsem=sem.finSem();

            String transcript = "Transcript for Student with ID:"  + StudentID + "\n\n";
            int semsDone=2*(yearsem.getFirst()-batch);
            if(yearsem.getSecond()==2){
                semsDone=semsDone+2;
            }
            else{
                semsDone=semsDone+1;
            }

            query="select offering_id from student_courses_status where student_id=? and status='Completed';";
            stmt=connection.prepareStatement(query);
            stmt.setString(1,StudentID);
            Vector<Integer> offer_ids=new Vector<>();
            resultSet=stmt.executeQuery();
            while(resultSet.next()){
                offer_ids.add(resultSet.getInt(1));

            }


            for(int i=1;i<=min(8,semsDone);i++){

//                query="select * from course_offering where year=? and semester=? and offering_id=?;";
//                stmt=connection.prepareStatement(query);

                if(i==1){
                    transcript+="\n1st Semester\n";
                    for(int j=0;j<offer_ids.size();j++){
                        query="select * from course_offering where year=? and semester=? and offering_id=?;";
                        stmt=connection.prepareStatement(query);
                        stmt.setInt(1,batch);
                        stmt.setInt(2,1);
                        stmt.setInt(3,offer_ids.get(j));
                        resultSet=stmt.executeQuery();
                        while (resultSet.next()){
                                query="select * from student_courses_status where offering_id=?;";
                                stmt=connection.prepareStatement(query);
                                stmt.setInt(1,offer_ids.get(j));
                                ResultSet res=stmt.executeQuery();
                                while (res.next()){
                                    transcript+=res.getString("course_id")+"\t"+res.getString("grade")+"\n";;
                                }
                        }
                    }


                } else if (i==2) {
                    transcript+="\n2nd Semester\n";
                    for(int j=0;j<offer_ids.size();j++){
                        query="select * from course_offering where year=? and semester=? and offering_id=?;";
                        stmt=connection.prepareStatement(query);
                        stmt.setInt(1,batch);
                        stmt.setInt(2,2);
                        stmt.setInt(3,offer_ids.get(j));
                        resultSet=stmt.executeQuery();
                        while (resultSet.next()){
                            query="select * from student_courses_status where offering_id=?;";
                            stmt=connection.prepareStatement(query);
                            stmt.setInt(1,offer_ids.get(j));
                            ResultSet res=stmt.executeQuery();
                            while (res.next()){
                                transcript+=res.getString("course_id")+"\t"+res.getString("grade")+"\n";;
                            }
                        }
                    }

                } else if (i==3) {
                    transcript+="\n3rd Semester\n";
                    for(int j=0;j<offer_ids.size();j++){
                        query="select * from course_offering where year=? and semester=? and offering_id=?;";
                        stmt=connection.prepareStatement(query);
                        stmt.setInt(1,batch+1);
                        stmt.setInt(2,1);
                        stmt.setInt(3,offer_ids.get(j));
                        resultSet=stmt.executeQuery();
                        while (resultSet.next()){
                            query="select * from student_courses_status where offering_id=?;";
                            stmt=connection.prepareStatement(query);
                            stmt.setInt(1,offer_ids.get(j));
                            ResultSet res=stmt.executeQuery();
                            while (res.next()){
                                transcript+=res.getString("course_id")+"\t"+res.getString("grade")+"\n";;
                            }
                        }
                    }


                } else if (i==4) {
                    transcript+="\n4th Semester\n";
                    for(int j=0;j<offer_ids.size();j++){
                        query="select * from course_offering where year=? and semester=? and offering_id=?;";
                        stmt=connection.prepareStatement(query);
                        stmt.setInt(1,batch+1);
                        stmt.setInt(2,2);
                        stmt.setInt(3,offer_ids.get(j));
                        resultSet=stmt.executeQuery();
                        while (resultSet.next()){
                            query="select * from student_courses_status where offering_id=?;";
                            stmt=connection.prepareStatement(query);
                            stmt.setInt(1,offer_ids.get(j));
                            ResultSet res=stmt.executeQuery();
                            while (res.next()){
                                transcript+=res.getString("course_id")+"\t"+res.getString("grade")+"\n";;
                            }
                        }
                    }

                }else if (i==5) {
                    transcript+="\n5th Semester\n";
                    for(int j=0;j<offer_ids.size();j++){
                        query="select * from course_offering where year=? and semester=? and offering_id=?;";
                        stmt=connection.prepareStatement(query);
                        stmt.setInt(1,batch+2);
                        stmt.setInt(2,1);
                        stmt.setInt(3,offer_ids.get(j));
                        resultSet=stmt.executeQuery();
                        while (resultSet.next()){
                            query="select * from student_courses_status where offering_id=?;";
                            stmt=connection.prepareStatement(query);
                            stmt.setInt(1,offer_ids.get(j));
                            ResultSet res=stmt.executeQuery();
                            while (res.next()){
                                transcript+=res.getString("course_id")+"\t"+res.getString("grade")+"\n";;
                            }
                        }
                    }

                }else if (i==6) {
                    transcript+="\n6th Semester\n";
                    for(int j=0;j<offer_ids.size();j++){
                        query="select * from course_offering where year=? and semester=? and offering_id=?;";
                        stmt=connection.prepareStatement(query);
                        stmt.setInt(1,batch+2);
                        stmt.setInt(2,2);
                        stmt.setInt(3,offer_ids.get(j));
                        resultSet=stmt.executeQuery();
                        while (resultSet.next()){
                            query="select * from student_courses_status where offering_id=?;";
                            stmt=connection.prepareStatement(query);
                            stmt.setInt(1,offer_ids.get(j));
                            ResultSet res=stmt.executeQuery();
                            while (res.next()){
                                transcript+=res.getString("course_id")+"\t"+res.getString("grade")+"\n";;
                            }
                        }
                    }

                }else if (i==7) {
                    transcript+="\n7th Semester\n";
                    for(int j=0;j<offer_ids.size();j++){
                        query="select * from course_offering where year=? and semester=? and offering_id=?;";
                        stmt=connection.prepareStatement(query);
                        stmt.setInt(1,batch+3);
                        stmt.setInt(2,1);
                        stmt.setInt(3,offer_ids.get(j));
                        resultSet=stmt.executeQuery();
                        while (resultSet.next()){
                            query="select * from student_courses_status where offering_id=?;";
                            stmt=connection.prepareStatement(query);
                            stmt.setInt(1,offer_ids.get(j));
                            ResultSet res=stmt.executeQuery();
                            while (res.next()){
                                transcript+=res.getString("course_id")+"\t"+res.getString("grade")+"\n";;
                            }
                        }
                    }

                }else if (i==8) {
                    transcript+="\n8th Semester\n";
                    for(int j=0;j<offer_ids.size();j++){
                        query="select * from course_offering where year=? and semester=? and offering_id=?;";
                        stmt=connection.prepareStatement(query);
                        stmt.setInt(1,batch+3);
                        stmt.setInt(2,2);
                        stmt.setInt(3,offer_ids.get(j));
                        resultSet=stmt.executeQuery();
                        while (resultSet.next()){
                            query="select * from student_courses_status where offering_id=?;";
                            stmt=connection.prepareStatement(query);
                            stmt.setInt(1,offer_ids.get(j));
                            ResultSet res=stmt.executeQuery();
                            while (res.next()){
                                transcript+=res.getString("course_id")+"\t"+res.getString("grade")+"\n";;
                            }
                        }
                    }

                 }

            }

            if(semsDone==8){

                query="select * from student where student_id=?;";
                stmt=connection.prepareStatement(query);
                stmt.setString(1,StudentID);
                resultSet=stmt.executeQuery();
                String dept="";
                while(resultSet.next()){
                    dept=resultSet.getString("dept_name");
                }
                BtechComplete bt=new BtechComplete();
                transcript+=bt.btech(batch,dept,StudentID);
            }
               // System.out.println(transcript);
                FileWriter fw = new FileWriter("transcript.txt");
                fw.write(transcript);
               if(transcript != null && !transcript.isEmpty()) {
                fw.write(transcript);
                fw.flush();
                }
                fw.close();


        }

        catch (SQLException | IOException e) {e.printStackTrace();stmt.close();System.out.println("Connection Failed ");}
        connection.close(); return true;

    }

}
