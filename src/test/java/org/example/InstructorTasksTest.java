package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InstructorTasksTest {

    @Test
    void tasks() {
        InstructorTasks it=new InstructorTasks();
        assertEquals(1,it.tasks(0));
    }
}