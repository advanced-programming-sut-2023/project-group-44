package view;

import controller.LoginMenuController;
import model.App;
import model.User;

import java.util.Scanner;
import java.util.regex.*;


public class LoginMenu {

    boolean flagLoggedIn = false;
    public void run(Scanner scanner) {

        // .:: Login Command ::.

        Matcher matcher;
        String command, result;

        String regexNotStay = "^user login (?=.*-u\\s)(?=.*-p\\s)(?:.*-u\\s(\\S+)\\s?-p\\s(\\S+)|.*-p\\s(\\S+)\\s?-u\\s(\\S+))$";
        String regexStay = "^user login (?=.*-u\\s)(?=.*-p\\s)(?:.*-u\\s(\\S+)\\s?-p\\s(\\S+)|.*-p\\s(\\S+)\\s?-u\\s(\\S+))$";
        String regexForgotPass = "^forgot my password -u \"?([^\"]*)\"?$";

        if (flagLoggedIn == false) {
            while (true) {
                command = scanner.nextLine();

                // Not Staying Logged In
                if ((matcher = LoginMenuController.getMatcher(command, regexNotStay)) != null) {
                    String username = matcher.group(1) != null ? matcher.group(1) : matcher.group(4);
                    String password = matcher.group(2) != null ? matcher.group(2) : matcher.group(3);
                    LoginMenuController.loginAndRedirect(username, password, scanner);
                }

                // Staying Logged in
                else if ((matcher = LoginMenuController.getMatcher(command, regexStay)) != null) {
                    String username = matcher.group(1) != null ? matcher.group(1) : matcher.group(4);
                    String password = matcher.group(2) != null ? matcher.group(2) : matcher.group(3);
                    LoginMenuController.loginAndRedirect(username, password, scanner);
                    flagLoggedIn = true;
                }

                // Forgot Password
                else if ((matcher = LoginMenuController.getMatcher(command, regexForgotPass)) != null) {
                    String username = matcher.group(1);


                }

                // Invalid Command
                else {
                    System.out.println("Invalid command");
                }
            }
        }
    }
}
