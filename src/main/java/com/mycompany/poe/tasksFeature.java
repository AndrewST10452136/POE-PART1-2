package com.mycompany.poe;

import javax.swing.JOptionPane;

public class tasksFeature {
     
    //THIS IS THE CLASS FOR PART 2
    
    // Count of tasks
    private static int taskCount = 0;
    // StringBuilder to store details of all tasks
    private static StringBuilder taskDetails = new StringBuilder();

    public static void main(String[] args) {
        // Infinite loop to keep the program running until user chooses to quit
        while (true) {
            // Menu options
            String menu = "Choose an option:\n1. Add Task\n2. Coming Soon\n3. Quit";
            // Prompt user to choose an option
            String choice = JOptionPane.showInputDialog(menu);

            // Perform action based on user's choice
            switch (choice) {
                case "1":
                    // If user chooses to add tasks
                    int numTasks = getNumberOfTasks();
                    for (int i = 0; i < numTasks; i++) {
                        addTask();
                    }
                    break;
                case "2":
                    // If user chooses the 'Coming Soon' option
                    JOptionPane.showMessageDialog(null, "Coming Soon!");
                    break;
                case "3":
                    // If user chooses to quit
                    JOptionPane.showMessageDialog(null, "Application exiting...");
                    System.exit(0);
                    break;
                default:
                    // If user enters an invalid option
                    JOptionPane.showMessageDialog(null, "Invalid option. Please try again.");
                    break;
            }
        }
    }

    // Method to prompt the user for the number of tasks to add
    public static int getNumberOfTasks() {
        String input = JOptionPane.showInputDialog("Enter the number of tasks to add:");
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
            return getNumberOfTasks();
        }
    }

    // Method to add a task
    public static void addTask() {
        // Prompt user for task name
        String taskName = JOptionPane.showInputDialog("Enter the task name:");
        // Prompt user for task description until a valid description is entered
        String taskDescription;
        while (!(taskDescription = getTaskDescription()).isEmpty() &&!checkTaskDescription(taskDescription)) {
            JOptionPane.showMessageDialog(null, "Task description should not exceed 50 characters.");
        }
        // Get developer details
        String developerDetails = getDeveloperDetails();
        // Get task duration
        int taskDuration = getTaskDuration();
        // Create task ID
        String taskID = createTaskID(taskName, developerDetails);
        // Get task status
        String taskStatus = getTaskStatus();

        // Construct task detail string
        String taskDetail = "Task Name: " + taskName + "\n" +
                "Task Description: " + taskDescription + "\n" +
                "Developer Details: " + developerDetails + "\n" +
                "Task Duration: " + taskDuration + " hours\n" +
                "Task ID: " + taskID + "\n" +
                "Task Status: " + taskStatus;

        // Append task detail to taskDetails StringBuilder
        taskDetails.append(taskDetail).append("\n\n");

        // Display message that task has been added
        JOptionPane.showMessageDialog(null, "Task Added:\n" + taskDetail);
    }

    // Method to get task description from user
    public static String getTaskDescription() {
        return JOptionPane.showInputDialog("Enter the task description (50 characters max):");
    }

    // Method to check if task description is valid
    public static boolean checkTaskDescription(String description) {
        return description.length() <= 50;
    }

    // Method to get developer details from user
    public static String getDeveloperDetails() {
        String firstName = JOptionPane.showInputDialog("Enter the developer's first name:");
        String lastName = JOptionPane.showInputDialog("Enter the developer's last name:");
        return firstName + " " + lastName;
    }

   // Method to get task duration from user
public static Integer getTaskDuration() {
    while (true) {
        try {
            // Try to get the input from the user and parse it as an integer
            String input = JOptionPane.showInputDialog("Enter the task duration in hours:");
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            // If the input cannot be parsed as an integer, display an error message
            JOptionPane.showMessageDialog(null,"Error: Please enter an integer.");
        } catch (NullPointerException e) {
            // If the input is null (i.e., the user left it empty), display an error message
            JOptionPane.showMessageDialog(null,"Error: Please do not leave this field empty.");
        }
    }
}


    // Method to create task ID
    public static String createTaskID(String taskName, String developerDetails) {
        StringBuilder id = new StringBuilder();
        id.append(taskName.substring(0, Math.min(2, taskName.length())).toUpperCase());
        id.append(":");
        id.append(taskName.toUpperCase());
        id.append(":");
        id.append(developerDetails.substring(Math.max(0, developerDetails.length() - 3)).toUpperCase());
        return id.toString();
    }
     
    // Method to get task status from user
    public static String getTaskStatus() {
    String statusChoice = JOptionPane.showInputDialog(null, "Enter the task status number:\n1. To Do\n2. Done\n3. Doing", "Task Status",
            JOptionPane.INFORMATION_MESSAGE);
    switch (statusChoice) {
        case "1":
            return "To Do";
        case "2":
            return "Done";
        case "3":
            return "Doing";
        default:
            return "Invalid choice";
    }
}

   // Method to calculate total hours of all tasks
public static int returnTotalHours() {
    // Initialize total hours to 0
    int totalHours = 0;

    // Convert task details to string
    String details = taskDetails.toString();

    // Define the key to search for task duration in the details
    String taskDurationKey = "Task Duration:";

    // Initialize the index for the search start position
    int index = 0;
    

    // Loop until no more task duration key is found in the details
    while (true) {
        // Find the position of the next task duration key
        index = details.indexOf(taskDurationKey, index);

        // If no more task duration key is found, break the loop
        if (index == -1) break;

        // Find the start and end positions of the task duration value
        int startOfNumber = index + taskDurationKey.length();
        int endOfLine = details.indexOf("\n", startOfNumber);
        if (endOfLine == -1) endOfLine = details.length();

        // Extract the task duration value and convert it to an integer
        String durationStr = details.substring(startOfNumber, endOfLine).trim();
        totalHours += Integer.parseInt(durationStr.split(" ")[0]);

        // Move the index to the end of the current line for the next search
        index = endOfLine;
    }

    // Return the total hours of all tasks
    return totalHours;
}


    // Method to display details of all tasks
    public static String printTaskDetails() {
        return taskDetails.toString();
    }
}
