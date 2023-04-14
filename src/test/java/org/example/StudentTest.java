package org.example;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void student() throws SQLException {
    Student student=new Student();
    assertEquals(1,student.student("2020CSB1132","2020csb1132@iitrpr.ac.in","root"));
    assertEquals(0,student.student("2020CSB1232","2020csb1132@iitrpr.ac.in","root"));

    }
}