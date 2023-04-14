package org.example;
import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

public class InstructorCourseRegister {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/acads";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "SushilK3710@";
    Connection connection = null;
    PreparedStatement stmt = null;
    ResultSet resultSet = null;
    Scanner sc=new Scanner(System.in);

    public int registration(String course_id,String InstructorID,int year,int sem,String cgpa_req,int array[]) throws SQLException {

        try{
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            currentSemester semy=new currentSemester();
            pair yearsem=semy.currentSem();
            if(yearsem.getFirst()!=0){
                if(year==yearsem.getFirst()){
                    if(sem==yearsem.getSecond()){
                        String chk_query="Select * from course_offering where course_id=? and year=? and semester=?;";
                        stmt=connection.prepareStatement(chk_query);
                        stmt.setString(1,course_id);
                        stmt.setInt(2,year);
                        stmt.setInt(3,sem);
                        resultSet=stmt.executeQuery();

                        if(resultSet.next()){
                            System.out.println("Course already exists for the same semester, cannot register");
                            return 0;
                        }

                        else {
                            Array sqlArray = connection.createArrayOf("INTEGER", Arrays.stream(array).boxed().toArray());
                            if (cgpa_req != "") {
                                String query = "Insert into course_offering(course_id,year,semester,instructor_id,cgpa_requirement,allowed_batches) values(?,?,?,?,?,?);";
                                stmt.close();
                                stmt = connection.prepareStatement(query);
                                stmt.setString(1, course_id);
                                stmt.setInt(2, year);
                                stmt.setInt(3, sem);
                                stmt.setString(4, InstructorID);
                                stmt.setDouble(5, Double.parseDouble(cgpa_req));
                                stmt.setArray(6, sqlArray);

                            } else{
                                String query = "Insert into course_offering(course_id,year,semester,instructor_id,allowed_batches) values(?,?,?,?,?);";
                                stmt = connection.prepareStatement(query);
                                stmt.setString(1, course_id);
                                stmt.setInt(2, year);
                                stmt.setInt(3, sem);
                                stmt.setString(4, InstructorID);
                                stmt.setArray(5, sqlArray);

                            }
                            stmt.execute();
                            System.out.println("Course Registered");


                        }

                }

            }
            else{
                System.out.println("No ongoing Semester for registration");
            }

        }


        }
        catch (SQLException e) {e.printStackTrace();stmt.close();sc.close();System.out.println("Connection Failed in registration");return -1;    }
        connection.close(); return 0;
    }
}
