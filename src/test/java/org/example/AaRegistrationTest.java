package org.example;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class AaRegistrationTest {

    @Test
    void registration() throws SQLException {
        AaRegistration aaRegistration =new AaRegistration();
       assertEquals(1, aaRegistration.registration("2020CSB1132","CS546"));//reg
      assertEquals(0, aaRegistration.registration("2020CSB1132","CS503"));//not offered
       assertEquals(0, aaRegistration.registration("2020CSB1132","CS535"));//not open for batch
       assertEquals(0, aaRegistration.registration("2020CSB1132","CS546"));//already enrolled
       assertEquals(0, aaRegistration.registration("2020CSB1132","CS101"));//already done
       assertEquals(0, aaRegistration.registration("2020CSB1132","CS616"));//prereq not done
        assertEquals(0, aaRegistration.registration("2020CSB1132","CS536"));//cg less
       assertEquals(1, aaRegistration.registration("2020CSB1132","CS712"));//reg
       assertEquals(1, aaRegistration.registration("2020CSB1132","CS531"));//reg
        assertEquals(1, aaRegistration.registration("2020CSB1132","HS507"));//reg
        assertEquals(0, aaRegistration.registration("2020CSB1132","HS505"));//cred/reg
        assertEquals(1, aaRegistration.registration("2020CSB1132","CS603"));//cred limit reg

        //assertEquals(0,registration.registration("2020CSB1132","HS507"));//reg


    }
}