package org.example;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class SemCredsTest {

    @Test
    void semcreds() throws SQLException {
        SemCreds sc=new SemCreds();
        assertEquals(29.08,sc.semcreds("2019CSB1000",2019,1));
    }
}