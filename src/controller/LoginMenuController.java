package controller;

import model.App;
import model.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginMenuController {

    public static Matcher getMatcher(String command, String regex) {
        Matcher matcher = Pattern.compile(regex).matcher(command);
        return matcher.matches() ? matcher : null;
    }

    public User loggedInUser;
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
                System.out.println("Invalid username or password.");

                System.out.println("Please try again in " + delay + " seconds.");
                try {
                    Thread.sleep(delay * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                delay += 5; // double the delay for the next attempt
            }
        }
    }

    public void loginAndRedirect(String username, String password) {
        if (loginWithRetry(username, password)) {
            NextMenu(); // login successful, open next menu
        } else {
            System.out.println("Login failed!");
        }
    }







}
