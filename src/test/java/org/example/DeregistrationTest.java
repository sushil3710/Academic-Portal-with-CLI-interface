package org.example;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class DeregistrationTest {

    @Test
    void deregister() throws SQLException {
        Deregistration dereg=new Deregistration();
        assertEquals(1,dereg.deregister("2020CSB1132","CS546"));
        assertEquals(1,dereg.deregister("2020CSB1132","CS712"));
        assertEquals(1,dereg.deregister("2020CSB1132","CS531"));
        assertEquals(1,dereg.deregister("2020CSB1132","CS517"));

    }
}