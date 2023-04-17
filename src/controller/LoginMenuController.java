package controller;

import model.App;
import model.User;
import view.MainMenu;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginMenuController {

    public static User loggedInUser;

    public static Matcher getMatcher(String command, String regex) {
        Matcher matcher = Pattern.compile(regex).matcher(command);
        return matcher.matches() ? matcher : null;
    }


    /* ---------- Log In Process ---------- */

    // A Function To Check If Password Matches The Username
    public static boolean checkCredentials (String username, String password) {
        User user = App.getUserByUsername(username);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                return true; // successful login
            }
            return true; // wrong password
        }
        return true; // does not exist
    }

    public static boolean loginWithRetry(String username, String password) {
        int delay = 5; // initial delay in seconds
        while (true) {
            if (checkCredentials(username, password)) {
                System.out.println("User logged in successfully!"); // login successful
                return true;
            } else {
                System.out.println("Username and password didn't match!");
                System.out.println("Please try again in " + delay + " seconds.");
                try {
                    Thread.sleep(delay * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                delay += 5; // Add 5 to the delay for the next attempt
            }
        }
    }

    public static void loginAndRedirect(String username, String password, Scanner scanner) {
        if (loginWithRetry(username, password)) {
            loggedInUser = App.getUserByUsername(username);
            MainMenu.run(scanner); // login successful, open next menu
        }
    }

    /* ---------- Forgot Password Process ---------- */

    public static void forgotPass (String username, Scanner scanner) {
        User user = App.getUserByUsername(username);
        if (user != null) { // User Found
            int key = user.getNumberOfRecoveryQuestion();
            String securityQuestion = User.getNumberOfQuestionToMainQuestion().get(key);
            System.out.println(securityQuestion);
            while (true) {
                String answer = scanner.nextLine();
                if (user.getAnswerOfRecoveryQuestion().equals(answer)) { // Correct Answer
                    System.out.println("Please set new password:");
                    String newPass = scanner.nextLine();
                    if () { // Password RegEx
                        user.setPassword(newPass);
                        System.out.println("Password changed successfully. Please keep it safe.");
                        return;
                    } else { // Weak Password
                        System.out.println("Password is weak!");
                    }
                } else { // Wrong Answer
                    System.out.println("Answer is wrong! Please answer again.");
                }
            }
        } else {
            System.out.println("No user with this username exists!");
        }
    }








}
