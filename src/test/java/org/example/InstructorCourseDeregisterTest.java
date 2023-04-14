package org.example;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class InstructorCourseDeregisterTest {

    @Test
    void deregistration() throws SQLException {
        InstructorCourseDeregister icd=new InstructorCourseDeregister();
        assertEquals(1,icd.deregistration(19,"5"));
        assertEquals(1,icd.deregistration(3406,"4"));

    }
}