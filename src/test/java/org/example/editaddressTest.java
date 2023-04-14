package org.example;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class editaddressTest {

    @Test
    void editdetail() throws SQLException {
        editaddress en=new editaddress();
        assertEquals(true,en.editdetail("2020CSB1132","Dhanota"));
    }


}