package org.example;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class RemoveCourseTest {

    @Test
    void courserem() throws SQLException {
        RemoveCourse rc=new RemoveCourse();
        assertEquals(1,rc.courserem("PH111"));
    }
}