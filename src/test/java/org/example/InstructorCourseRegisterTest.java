package org.example;

import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class InstructorCourseRegisterTest {

    @Test
    void registration() throws SQLException {
        InstructorCourseRegister icr=new InstructorCourseRegister();
        int[] array={2019};
        assertEquals(0,icr.registration("PH457","1",2023,1,"",array));//reg
        assertEquals(0,icr.registration("HS507","1",2023,1,"",array));//already pres
        assertEquals(0,icr.registration("CY427","1",2023,1,"9.5",array));//with cg reg

    }
}