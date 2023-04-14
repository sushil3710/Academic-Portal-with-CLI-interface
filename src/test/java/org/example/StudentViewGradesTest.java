package org.example;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class StudentViewGradesTest {

    @Test
    void viewgrades() throws SQLException {
        StudentViewGrades svg=new StudentViewGrades();
        assertEquals(true,svg.viewgrades("2020CSB1132"));
    }
}