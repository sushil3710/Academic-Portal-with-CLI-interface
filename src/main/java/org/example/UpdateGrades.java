package org.example;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import com.opencsv.CSVReader;


public class UpdateGrades{
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/acads";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "SushilK3710@";
    Connection connection = null;
    PreparedStatement stmt = null;ResultSet resultSet = null;Scanner sc=new Scanner(System.in);

    public int updategrades(int offer_id,String InstructorID) throws SQLException {


        try {

            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            FinishedSem fsem = new FinishedSem();
            pair yearsem = fsem.finSem();

            if (yearsem.getFirst() != 0) {
                String query = "Select * from course_offering where instructor_id=? and offering_id=?;";
                stmt = connection.prepareStatement(query);
                stmt.setString(1, InstructorID);
                stmt.setInt(2, offer_id);
                resultSet = stmt.executeQuery();

                if (!resultSet.next()) {
                    System.out.println("No such course exists offered by the given Instructor");
                }


                String csvFilePath = "C:\\Users\\sushi\\Downloads\\AIMS\\src\\main\\java\\org\\example\\Errors.txt";

                try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] values = line.split(",");
                        String Sid = values[0];
                        String Cid = values[1];
                        String grade = values[2];
                        query = "update student_courses_status set grade=?,status='Completed' where student_id=? and offering_id=?;";
                        stmt = connection.prepareStatement(query);
                        stmt.setString(1, grade);
                        stmt.setString(2, Sid);
                        stmt.setInt(3,offer_id);
                        stmt.execute();
                    }

                    System.out.println("Grades Updated");

                } catch (Exception e) {e.printStackTrace();}

            } else {System.out.println("Semester has not been completed yet, Grades can not be updated right now");}

        } catch (SQLException e) {e.printStackTrace();stmt.close();sc.close();System.out.println("Connection Failed in deregistartion");}
        connection.close(); return 0;

    }

}
