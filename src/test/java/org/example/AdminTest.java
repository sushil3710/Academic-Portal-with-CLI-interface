package org.example;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import static org.junit.jupiter.api.Assertions.*;
class AdminTest {

    @Test
    void admin() throws SQLException {
        Admin ad=new Admin();
        assertEquals(0,ad.admin("se21","1w2eft2fr@iitrpr.ac.in","1242"));
        assertEquals(1,ad.admin("dean123","dean123@iitrpr.ac.in","123456"));
    }
}