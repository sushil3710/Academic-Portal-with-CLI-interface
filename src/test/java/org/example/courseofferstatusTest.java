package org.example;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class courseofferstatusTest {

    @Test
    void status() throws SQLException {
        courseofferstatus cfs=new courseofferstatus();
        assertEquals(91,cfs.status(2023,1,"CS603"));
    }
}