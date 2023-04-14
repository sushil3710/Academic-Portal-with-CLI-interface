package org.example;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class InstructorTest {

    @Test
    void instructor() throws SQLException {
        Instructor ins=new Instructor();
        assertEquals(1,ins.instructor("1","abc@iitrpr.ac.in","12345"));
        assertEquals(0,ins.instructor("8","abc@iitrpr.ac.in","12345"));
    }
}