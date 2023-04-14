package org.example;
import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;

public class InstructorCourseDeregister {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/acads";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "SushilK3710@";
    Connection connection = null;
    PreparedStatement stmt = null;
    ResultSet resultSet = null;


    public int deregistration(int offer_id,String InstructorID) throws SQLException {

        try{
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            currentSemester semy=new currentSemester();
            pair yearsem=semy.currentSem();
            if(yearsem.getFirst()!=0) {

                String query = "Select offering_id from course_offering where offering_id=? and instructor_id=?;";
                stmt = connection.prepareStatement(query);
                stmt.setInt(1, offer_id);
                stmt.setString(2, InstructorID);
                resultSet = stmt.executeQuery();

                if (!resultSet.next()) {
                    System.out.println("No such course exists offered by the given Instructor");
                } else {
                    query = "BEGIN; DELETE FROM student_courses_status WHERE offering_id=?;"+"DELETE FROM course_offering WHERE offering_id=?; COMMIT;";stmt = connection.prepareStatement(query);stmt.setInt(1, offer_id);
                    stmt.setInt(2, offer_id);stmt.execute();
                    System.out.println("Course Dereg");}}}


        catch (SQLException e) {e.printStackTrace();stmt.close();System.out.println("Connection Failed in registration"); }
        connection.close();
        stmt.close();
        resultSet.close();
        return 1;}}
