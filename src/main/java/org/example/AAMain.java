//Main.java
package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class AAMain {
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/acads";
    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "SushilK3710@";


  
  

    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet resultSet = null;
        String studentName = null;
        while (true) {
            System.out.println("Welcome to the Academic Portal\n");
            System.out.println("Login as:");
            System.out.println("1. Student");
            System.out.println("2. Instructor");
            System.out.println("3. Academic Office");
            System.out.println("Press something else to Exit");
            try {
                conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                BufferedReader sc= new BufferedReader(new InputStreamReader(System.in));
                int option = Integer.parseInt(sc.readLine());
                AaRegistration reg = new AaRegistration();
                Deregistration dereg = new Deregistration();
                StudentViewGrades viewgrades = new StudentViewGrades();
                InstructorViewGrade insgrade = new InstructorViewGrade();
                InstructorCourseRegister Insreg = new InstructorCourseRegister();
                InstructorCourseDeregister Insdereg = new InstructorCourseDeregister();
                UpdateGrades upgrad = new UpdateGrades();
                AdminViewGrade avg = new AdminViewGrade();
                AdminViewAllGrade avlg = new AdminViewAllGrade();
                transcript trans = new transcript();
                CourseAdd ca = new CourseAdd();
                RemoveCourse rc = new RemoveCourse();
                while (true) {
                    if (option == 1) {
                        System.out.print("Enter Student ID, email and password\n");
                      
                        String StudentId = sc.readLine();
                        String email = sc.readLine();
                        String password = sc.readLine();
                        Student student = new Student();
                        if (student.student(StudentId, email, password) == 0) break;
                        while (true) {
                            StudentTasks tsk = new StudentTasks();
                            tsk.tasks(0);
                            int value = 0;

                            value = Integer.parseInt(sc.readLine());

                            if (value == 1) {
                                System.out.println("Student Profile\n1. Edit  Phone Number\n2. Edit Address\n3. View profile\n4. Go back");
                                while (true) {
                                    int ed = Integer.parseInt(sc.readLine());
                                    if (ed == 1) {
                                        editNumber b = new editNumber();
                                        System.out.println("Enter New Phone number: ");
                                        String phone = sc.readLine();
                                        b.editdetail(StudentId, phone);
                                      }
                                    else if (ed == 2) {
                                        editaddress b = new editaddress();
                                        System.out.println("Enter New Address: ");
                                        String address = sc.readLine();
                                        b.editdetail(StudentId, address);
                                    }
                                       else if (ed == 3) {
                                        ViewProfile b = new ViewProfile();
                                        b.viewprofile(StudentId);
                                    } else {
                                        break;
                                    }
                                }
                            } else if (value == 2) {
                                System.out.println("Register a course\nEnter the Course Id:");
                                String courseid = sc.readLine();
                                reg.registration(StudentId, courseid);
                            } else if (value == 3) {
                                System.out.println("Enter the course to be deregistered");
                                String courseId = sc.readLine();
                                dereg.deregister(StudentId, courseId);
                            } else if (value == 4) {
                                viewgrades.viewgrades(StudentId);
                            } else if (value == 5) {
                                break;
                            }
                        }
                    } else if (option == 2) {
                        System.out.print("Enter Instructor ID, email and password\n");
                        String InstructorId = sc.readLine();
                        String email = sc.readLine();
                        String password = sc.readLine();
                        Instructor instructor = new Instructor();
                        if (instructor.instructor(InstructorId, email, password) == 0) break;
                        while (true) {
                            InstructorTasks tsk = new InstructorTasks();
                            tsk.tasks(0);
                            int value = Integer.parseInt(sc.readLine());
                            if (value == 1) {
                                System.out.println("Enter the courseID whose grades are to be viewed:");
                                String courseID = sc.readLine();
                                insgrade.viewgrades(courseID);
                            } else if (value == 2) {
                                System.out.println("Register a course, Enter details for the course");
                                System.out.println("Course Id: ");
                                String course_id = sc.readLine();
                                System.out.println("Year: ");
                                int year = Integer.parseInt(sc.readLine());
                                System.out.println("Semester: ");
                                int sem = Integer.parseInt(sc.readLine());
                                System.out.println("Cgpa required: ");
                                String cgpa_req = sc.readLine();
                                System.out.println("allowed batches: ");
                                String input = sc.readLine();
                                String[] inputArray = input.split(",");
                                int[] array = new int[inputArray.length];
                                for (int i = 0; i < inputArray.length; i++) {
                                    array[i] = Integer.parseInt(inputArray[i]);
                                }
                                Insreg.registration(course_id, InstructorId, year, sem, cgpa_req, array);
                            } else if (value == 3) {
                                System.out.println("Enter the Offer_ID of the course to be deregistered:");
                                String offer_ID = sc.readLine();
                                reg.registration(offer_ID, InstructorId);
                            } else if (value == 4) {
                                System.out.println("Update grades of the students");
                                System.out.println("Enter the offering ID of the course to be graded: ");
                                int offer_id = Integer.parseInt(sc.readLine());
                                upgrad.updategrades(offer_id, InstructorId);
                               // break;
                            } else {
                                break;
                            }
                        }
                    } else if (option == 3) {
                        System.out.print("Enter Admin ID, Email and Password\n");
                        String AdminId = sc.readLine();
                        String email = sc.readLine();
                        String password = sc.readLine();
                        Admin admin = new Admin();
                        if (admin.admin(AdminId, email, password) == 0) {
                            break;
                        } else {
                            while (true) {
                                AdminTasks tsk = new AdminTasks();
                                tsk.tasks(0);
                                int value = Integer.parseInt(sc.readLine());
                                if (value == 1) {
                                    while (true) {
                                        System.out.println("Edit Course Catalogue\n 1. Add Courses\n2. Remove Courses\nPress Anything else to go back");
                                        int inp = Integer.parseInt(sc.readLine());
                                        if (inp == 1) {
                                            System.out.println("Add Courses to the Course_Catalogue\n How many courses would you like to add");
                                            int count = Integer.parseInt(sc.readLine());
                                            System.out.println("Enter Courses");
                                            for (int i = 0; i < count; i++) {
                                                Vector<String> prereq = new Vector<>();
                                                System.out.println("CourseID:");
                                                String courseid = sc.readLine();
                                                System.out.println("Course Name:");
                                                String coursname = sc.readLine();
                                                System.out.println("l:");
                                                int l = Integer.parseInt(sc.readLine());
                                                System.out.println("t");
                                                double t = Double.parseDouble(sc.readLine());
                                                System.out.println("p");
                                                double p = Double.parseDouble(sc.readLine());
                                                System.out.println("s");
                                                double s = Double.parseDouble(sc.readLine());
                                                System.out.println("c");
                                                double c = Double.parseDouble(sc.readLine());
                                                System.out.println("PreRequisites");
                                                String input = sc.readLine();
                                                String[] stringArray = input.split(",");
                                                ca.courseadd(courseid, coursname, l, t, p, s, c, stringArray);
                                            }
                                        } else if (inp == 2) {
                                            System.out.println("Remove a Courses from  the Course Catalogue\n How many courses would you like to remove");
                                            int count = Integer.parseInt(sc.readLine());
                                            System.out.println("Enter Course IDs");
                                            for (int i = 0; i < count; i++) {
                                                System.out.println("CourseID:");
                                                String courseid = sc.readLine();
                                                rc.courserem(courseid);
                                            }
                                        } else {
                                            break;
                                        }
                                    }
                                } else if (value == 2) {
                                    System.out.println("View Grades\n1.Grades Of Every course\n2. Grades of One course");
                                    int ct = Integer.parseInt(sc.readLine());
                                    if (ct == 1) {
                                        avlg.viewgrades(0);
                                    } else if(ct==2){
                                        System.out.println("Enter the courseID:");
                                        String courseID = sc.readLine();
                                        avg.viewgrades(courseID);
                                    }else{
                                        break;
                                    }
                                } else if (value == 3) {
                                    System.out.println("Generate a Transcript, Enter the StudentID:");
                                    String studentID = sc.readLine();
                                    trans.transcript(studentID);
                                    //break;
                                } else if (value == 4) {
                                    break;
                                }
                            }
                        }
                    }
                }
            } catch (SQLException e) {throw new RuntimeException(e);} catch (IOException e) {throw new RuntimeException(e);}
            return ;
        }
    }
}


