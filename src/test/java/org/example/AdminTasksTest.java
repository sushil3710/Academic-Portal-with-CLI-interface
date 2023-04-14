package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AdminTasksTest {

    @Test
    void tasks() {
        AdminTasks at=new AdminTasks();
        assertEquals(1,at.tasks(1));
    }
}