package org.example;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class ViewProfileTest {

    @Test
    void viewprofile() throws SQLException {
        ViewProfile vp=new ViewProfile();
        String Id="2020CSB1132";
        assertEquals(true,vp.viewprofile(Id));
        assertEquals(false,vp.viewprofile("2020CSB1133"));
    }
}