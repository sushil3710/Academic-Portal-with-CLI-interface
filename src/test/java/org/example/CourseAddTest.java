package org.example;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class CourseAddTest {

    @Test
    void courseadd() throws SQLException {
        CourseAdd cd=new CourseAdd();
        String[] stringarray={""};
        assertEquals(1,cd.courseadd("PH111","Physics mine",3,1,1,3,3,stringarray));
    }
}