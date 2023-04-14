package org.example;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class AdminViewAllGradeTest {

    @Test
    void viewgrades() throws SQLException {
        AdminViewAllGrade avag=new AdminViewAllGrade();
        assertEquals(true,avag.viewgrades(0));
    }
}