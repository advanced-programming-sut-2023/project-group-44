package controller;

import model.App;
import model.User;
import view.MainMenu;

import java.io.IOException;
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
    public static int checkCredentials(String username, String password) {
        User user = App.getUserByUsername(username);
        if (user != null) {
            if (user.getPassword().equals(password)) {
                return 1; // successful login
            }
            return 2; // wrong password
        }
        return 3; // does not exist
    }

    public static boolean loginWithRetry(String username, String password, Scanner scanner) {
        int delay = 5; // initial delay
        while (true) {
            if (checkCredentials(username, password) == 1) {
                System.out.println("User logged in successfully!"); // login successful
                loggedInUser = App.getUserByUsername(username);
                return true;
            } else if (checkCredentials(username, password) == 2) {
                System.out.println("Username and password didn't match!");

                if (LoginMenuController.wantToTryAgain(scanner)) { // wants to try again
                    System.out.println("Please try again in " + delay + " seconds.");
                    try { // delay
                        Thread.sleep(delay * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    delay += 5; // Add 5 to the delay for the next attempt
                    password = scanner.nextLine(); // input password again
                } else {
                    return false;
                }
            } else if (checkCredentials(username, password) == 3) {
                System.out.println("Username and password didn't match! (User not found)");
                return false;
            }
        }
    }


    /* ---------- Forgot Password Process ---------- */

    public static void forgotPass(String username, Scanner scanner) {
        User user = App.getUserByUsername(username);
        if (user != null) { // user found
            String securityQuestion = user.getSecurityQuestion();
            System.out.println(securityQuestion);
            while (true) {
                String answer = scanner.nextLine();
                if (user.getAnswerOfSecurityQuestion().equals(answer)) { // correct answer
                    System.out.println("Please set new password:");
                    String newPass = scanner.nextLine();
                    if ((LoginMenuController.getMatcher(newPass, "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[^A-Za-z0-9]).{6,}$")) != null) { // Password RegEx
                        user.setPassword(newPass);
                        System.out.println("Password changed successfully. Please keep it safe.");
                        return;
                    } else { // weak password
                        System.out.println("Password is weak!");
                    }
                } else { // wrong answer
                    System.out.println("Answer is wrong! Please answer again.");
                }
                if (!LoginMenuController.wantToTryAgain(scanner)) {
                    return;
                }
            }
        } else { // user not found
            System.out.println("No user with this username exists!");
        }
    }


    public static boolean wantToTryAgain(Scanner scanner) {
        System.out.println("Do you want to try again? [y/n]");
        String want = scanner.nextLine();
        if (want.equals("y") || want.equals("yes") || want.equals("Yes")) { // if the user wants to try again
            return true;
        } else {
            return false;
        }
    }
}
