package org.example;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class courseStatusTest {

    @Test
    void coursestatus() throws SQLException {
        courseStatus cs=new courseStatus();
        assertEquals(1,cs.coursestatus("2020CSB1132",91));
    }
}