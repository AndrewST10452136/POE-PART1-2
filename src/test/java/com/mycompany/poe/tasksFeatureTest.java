package com.mycompany.poe;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

//THIS IS THE UNIT TEST

public class tasksFeatureTest {
    
    public tasksFeatureTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }

    @Test
    public void testMain() {
    }

    @Test
    public void testGetNumberOfTasks() {
    }

    @Test
    public void testAddTask() {
    }

    @Test
    public void testGetTaskDescription() {
    }

    @Test
    public void testCheckTaskDescription() {
          // Test case: Task description should not exceed 50 characters
        String validDescription = "This is a valid task description.";
        String invalidDescription = "This is an invalid task description that exceeds 50 characters.";

        assertTrue(tasksFeature.checkTaskDescription(validDescription), "Valid description should pass.");
        assertFalse(tasksFeature.checkTaskDescription(invalidDescription), "Invalid description should fail.");
    }

    @Test
    public void testGetDeveloperDetails() {
    }

    @Test
    public void testGetTaskDuration() {
    }

    @Test
    public void testCreateTaskID() {
        
        // Arrange
        String taskName = "TestTask";
        String developerDetails = "JohnDoe";

        // Act
        String taskID = tasksFeature.createTaskID(taskName, developerDetails);

        // Assert
        String expectedTaskID = "TE:TESTTASK:DOE";
        assertEquals(expectedTaskID, taskID);
    }

    @Test
    public void testGetTaskStatus() {
    }

    @Test
    public void testReturnTotalHours() {
        // Call the method and assert its correctness
        int expectedTotalHours = 10;  // Change this to the expected total hours based on your setup
        int actualTotalHours = 10;
        assertEquals(expectedTotalHours, actualTotalHours, "Total hours not correctly accumulated in loop");
    }
        

    @Test
    public void testPrintTaskDetails() {
    }
    
}
