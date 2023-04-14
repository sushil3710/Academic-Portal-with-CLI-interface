package org.example;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class cgreqTest {

    @Test
    void cgreq() throws SQLException {
        cgreq cg=new cgreq();
        assertEquals(0,cg.cgreq(905));
    }
}