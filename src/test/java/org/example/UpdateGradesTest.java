package org.example;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class UpdateGradesTest {

    @Test
    void updategrades() throws SQLException {
        UpdateGrades upg=new UpdateGrades();
        assertEquals(0,upg.updategrades(107,"1"));
        assertEquals(0,upg.updategrades(107,"34"));

    }
}