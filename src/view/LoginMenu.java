package view;

import controller.LoginMenuController;
import model.App;
import model.User;

import java.util.Scanner;
import java.util.regex.*;


public class LoginMenu {

    boolean flagLoggedIn = false;

    public void run(Scanner scanner) {

        Matcher matcher;
        String command;
        String regexNotStay = "^user login (?=.*-u\\s)(?=.*-p\\s)(?:.*-u\\s(\\S+)\\s?-p\\s(\\S+)|.*-p\\s(\\S+)\\s?-u\\s(\\S+))$";
        String regexStay = "^user login (?=.*-u\\s)(?=.*-p\\s)(?:.*-u\\s(\\S+)\\s?-p\\s(\\S+)|.*-p\\s(\\S+)\\s?-u\\s(\\S+)) \\-\\-stay\\-logged\\-in$";
        String regexForgotPass = "^forgot my password -u \"?([^\"]*)\"?$";

        if (flagLoggedIn == false) {
            while (true) {
                command = scanner.nextLine();

                // .::           Login Commands           ::.

                // Not Staying Logged In
                if ((matcher = LoginMenuController.getMatcher(command, regexNotStay)) != null) {
                    String username = matcher.group(1) != null ? matcher.group(1) : matcher.group(4);
                    String password = matcher.group(2) != null ? matcher.group(2) : matcher.group(3);
                    if (LoginMenuController.loginWithRetry(username, password, scanner)) {
                        // ---->>>> nextMenu.run();
                        MainMenu mainMenu = new MainMenu();
                        mainMenu.run(scanner);
                    }
                }

                // Staying Logged in
                else if ((matcher = LoginMenuController.getMatcher(command, regexStay)) != null) {
                    String username = matcher.group(1) != null ? matcher.group(1) : matcher.group(4);
                    String password = matcher.group(2) != null ? matcher.group(2) : matcher.group(3);
                    if (LoginMenuController.loginWithRetry(username, password, scanner)) {
                        // ---->>>> nextMenu.run();
                        MainMenu mainMenu = new MainMenu();
                        mainMenu.run(scanner);
                    }
                    flagLoggedIn = true;
                }

                // Forgot Password
                else if ((matcher = LoginMenuController.getMatcher(command, regexForgotPass)) != null) {
                    String username = matcher.group(1);
                    LoginMenuController.forgotPass(username, scanner);
                }

                // Invalid Command
                else {
                    System.out.println("Invalid command");
                }
            }
        }
    }
}
