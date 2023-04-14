package org.example;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class AaRegistration {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/acads";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "SushilK3710@";
    Connection connection = null;
    PreparedStatement stmt = null;
    ResultSet resultSet = null;
    Scanner sc=new Scanner(System.in);

    public int registration(String StudentId,String courseid) throws SQLException {

        try {
            connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            currentSemester sem = new currentSemester();
            pair yearsem = sem.currentSem();

            courseofferstatus cos = new courseofferstatus();
            int offer_id = cos.status(yearsem.getFirst(), yearsem.getSecond(), courseid);

            if (offer_id == 0) {
                return 0;//course not offered
            } else {
                RegBatch available = new RegBatch();
                int av = available.regbatch(StudentId, offer_id);
                if (av == 0) {
                    return 0;//not available for the batch
                } else {
                    courseStatus stat = new courseStatus();
                    int st = stat.coursestatus(StudentId, offer_id);

                    if (st == 0) {
                        return 0;//already enrolled or registered
                    } else {
                        PreReq pr = new PreReq();
                        if (pr.prereq(StudentId, offer_id) == 0) {
                            return 0;//prereq not done
                        } else {
                            GetCgpa cg = new GetCgpa();
                            cgreq cg_req = new cgreq();

                            if (cg.getcgpa(StudentId) < cg_req.cgreq(offer_id)) {
                                System.out.println("CGPA less than required, cannot register for the course");
                                return 0;
                            } else {
                                CredLimit cl = new CredLimit();
                                if (cl.limit(StudentId, yearsem.getFirst(), yearsem.getSecond(),courseid) == true) {
                                    return 0;
                                } else {
                                    String query = "select course_id from course_offering where offering_id=?;";
                                    stmt = connection.prepareStatement(query);
                                    stmt.setInt(1, offer_id);
                                    String cr = "";
                                    resultSet = stmt.executeQuery();
                                    while (resultSet.next()) {
                                        cr = resultSet.getString(1);
                                    }
                                    query = "Insert into student_courses_status(student_id,offering_id,course_id,status) VALUES(?,?,?,'Enrolled');";
                                    stmt = connection.prepareStatement(query);
                                    stmt.setString(1, StudentId);
                                    stmt.setInt(2, offer_id);
                                    stmt.setString(3, cr);
                                    stmt.execute();
                                    System.out.println("You are now Enrolled in the given Course!!");

                                }

                            }

                        }

                    }

                }

            }

        }
        catch (SQLException e) {e.printStackTrace();
            stmt.close();
            sc.close();
            System.out.println("Connection Failed in registration");

        }connection.close();return 1;
    }



}
