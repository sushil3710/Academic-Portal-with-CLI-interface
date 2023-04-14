package org.example;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class AdminViewGradeTest {

    @Test
    void viewgrades() throws SQLException {
        AdminViewGrade avg=new AdminViewGrade();
        assertEquals(true,avg.viewgrades("CS101"));
    }
}