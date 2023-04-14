package org.example;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class InstructorViewGradeTest {

    @Test
    void viewgrades() throws SQLException {
        InstructorViewGrade ivg=new InstructorViewGrade();
        assertEquals(true,ivg.viewgrades("CS101"));
    }
}