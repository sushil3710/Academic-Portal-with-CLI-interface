package org.example;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class transcriptTest {

    @Test
    void transcriptTest() throws SQLException {
        transcript tp=new transcript();
        assertEquals(true,tp.transcript("2019CSB1000"));
         }

}