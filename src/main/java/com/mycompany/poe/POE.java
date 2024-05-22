package com.mycompany.poe;
import javax.swing.JOptionPane;

public class POE {
  
    /* This project has 3 things
    no.1 login system which is the main poe part 1 
    no.2 the class for the task2 feature which is part 2
    no.3 and the unit test */
    
    
    public static void main(String[] args) {
        boolean isUserIdSuccess = false;
        boolean isPasswordSuccess = false;

        String userId = "";
        String password = "";

        while (!isUserIdSuccess) {
            //prompting the user to enter useId
            userId = JOptionPane.showInputDialog("Enter userId that has 5 charaters long with a under score:  ");
            // Check if userId is valid
            isUserIdSuccess = confirmingUserId(userId);
        }

        while (!isPasswordSuccess) {
            //prompting the user to enter password
            password = JOptionPane.showInputDialog("Enter a password with 8 characters, at least one number, one special character, and one capital letter: ");  
            // Check if password is valid
            isPasswordSuccess = confirmingPassword(password);
        }

        // Display login status
        JOptionPane.showMessageDialog(null,returnLoginStatus(isUserIdSuccess && isPasswordSuccess));  
        
        //If both userId and password are valid, display welcome message
        if (isUserIdSuccess && isPasswordSuccess) {
            JOptionPane.showMessageDialog(null,"Welcome to EasyKanban");
        }  
        
        //calling the class for the task feature(PART2)
         tasksFeature.main(new String[]{});
    }

    public static String returnLoginStatus(boolean isSuccess) {
        if (isSuccess) {
            return "Login successful ";
        } else {
            return "Login failed. Please check your credentials and try again.";
        }
    }

    public static boolean confirmingUserId(String userId) { 
        // Check if userId contains "_"
        if (!userId.contains("_")) {
            JOptionPane.showMessageDialog(null,"Please ensure your userId has a '_'.");
            return false;
        }
    
        // Check if userId length is 5
        if (userId.length() != 5) {
           JOptionPane.showMessageDialog(null,"Please ensure your userId has 5 characters long.");
           return false;
        }
    
        // If userId meets all requirements
        if (userId.contains("_") && userId.length() == 5) {
            JOptionPane.showMessageDialog(null,"userId meets all requirements.");
            return true;
        }
        return false;
    }

    public static boolean confirmingPassword(String password) {
        // Checking character lenght 
        if (password.length() < 8) {
              JOptionPane.showMessageDialog(null,"Do ensure your password has 8 character ");
            return false;
        }

        // Checking for at least one uppercase letter
        if (!password.matches(".*[A-Z].*")) {
            JOptionPane.showMessageDialog(null,"Do ensure your password has a letter " ); 
            return false;
        }

        // Checking for at least one digit
        if (!password.matches(".*[0-9].*")) {
              JOptionPane.showMessageDialog(null,"Do ensure your password has a digit ");
            return false;
        }

        // Checking for at least one special character
        if (!password.matches(".*[!@#$%^&*()].*")) {
              JOptionPane.showMessageDialog(null,"Do ensure your password has a special character ");
            return false;
        }

        return true;
    }
}
