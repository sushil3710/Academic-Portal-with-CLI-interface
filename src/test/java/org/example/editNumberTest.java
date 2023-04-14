package org.example;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class editNumberTest {

    @Test
    void editdetail() throws SQLException {
        editNumber en=new editNumber();
        assertEquals(true,en.editdetail("2020CSB1132","9818157062"));
    }

}