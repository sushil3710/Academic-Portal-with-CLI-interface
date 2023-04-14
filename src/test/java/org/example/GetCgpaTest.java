package org.example;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class GetCgpaTest {

    @Test
    void getcgpa() throws SQLException {
        GetCgpa cg=new GetCgpa();
        assertEquals(0,cg.getcgpa("2025CSB1132"));
    }
}