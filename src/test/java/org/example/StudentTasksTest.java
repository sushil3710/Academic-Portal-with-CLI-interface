package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTasksTest {

    @Test
    void tasks() {
        StudentTasks ts=new StudentTasks();
        assertEquals(true,ts.tasks(0));
    }


}