package controller;

import model.App;

import java.util.Scanner;
import java.util.regex.Matcher;

public class ProfileMenuController {
    public static String passwordValidation(Matcher matcher) {
        String password = SignUpMenuController.deleteQuotations(matcher.group("newPassword"));
        if (!password.matches("(?=.*[a-z]).+")) return "Weak password: small letter leak";
        if (!password.matches("(?=.*[A-Z]).+")) return "Weak password: capital letter leak";
        if (!password.matches("(?=.*[0-9]).+")) return "Weak password: number leak";
        if (!password.matches("(?=.*[\\W]).+")) return "Weak password: character leak";
        if (!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[\\W]).{6,}$"))
            return "Weak password: short length";
        return null;
    }

    public static String changeUsername(Matcher matcher, Scanner scanner) {
        if (matcher.group("username") == null)
            return "You must enter require informations for changing userName";
        String userName = SignUpMenuController.usernameValidation(matcher);
        if (userName == null)
            return "userName format is invalid";
        if (App.getUserByUsername(userName) != null) {
            System.out.println("This userName already exists");
            userName = SignUpMenuController.randomUsername(userName, scanner);
            if (userName == null)
                return "changing userName failed try again";
        }
        LoginMenuController.loggedInUser.setUsername(userName);
        return "UserName successfully changed!";
    }


    public static String changeNickname(Matcher matcher) {
        if (matcher.group("nickname") == null)
            return "You must enter require informations for changing nickName";
        String nickName = SignUpMenuController.deleteQuotations(matcher.group("nickname"));
        LoginMenuController.loggedInUser.setNickname(nickName);
        return "NickName successfully changed!";
    }


    public static String changePassword(Matcher matcher, Scanner scanner) {
        if (matcher.group("oldPassword") == null || matcher.group("newPassword") == null)
            return "You must enter require informations for changing password";
        String oldPassword = SignUpMenuController.deleteQuotations(matcher.group("oldPassword"));
        String newPassword = SignUpMenuController.deleteQuotations(matcher.group("newPassword"));
        if (!oldPassword.equals(LoginMenuController.loggedInUser.getPassword()))
            return "Current password is incorrect!";
        if (oldPassword.equals(newPassword))
            return "Please enter a new password!";
        if (newPassword.equals("random")) {
            newPassword = SignUpMenuController.randomPassword(newPassword, scanner);
            if (newPassword == null)
                return "Random password confirmation failed";
        } else {
            String passwordValidationMessage = passwordValidation(matcher);
            if (passwordValidationMessage != null)
                return passwordValidationMessage;
        }
        LoginMenuController.loggedInUser.setPassword(newPassword);
        return "Password successfully changed!";
    }


    public static String changeEmail(Matcher matcher) {
        if (matcher.group("email") == null)
            return "You must enter require informations for changing email";
        if (App.getUserByEmail(matcher.group("email")) != null)
            return "A user with this email already exists";
        if (!matcher.group("email").matches("^[\\w_.]+@[\\w_]+\\.?[\\w+]+\\.[\\w_]+$"))
            return "Invalid email format";
        LoginMenuController.loggedInUser.setEmail(matcher.group("email"));
        return "Email successfully changed!";
    }


    public static String changeSlogan(Matcher matcher) {
        if (matcher.group("slogan") == null)
            return "You must enter require informations for changing slogan";
        LoginMenuController.loggedInUser.setSlogan(SignUpMenuController.slogan(matcher));
        return "Slogan successfully changed!";
    }


    public static String removeSlogan() {
        if (LoginMenuController.loggedInUser.getSlogan() == null) {
            return "Slogan is already empty!";
        }
        LoginMenuController.loggedInUser.setSlogan(null);
        return "Slogan successfully removed!";
    }


    public static String displayHighScore() {
        return "Your highSore : " + LoginMenuController.loggedInUser.getHighScore();
    }


    public static String displayRank() {
        return "Your rank : " + LoginMenuController.loggedInUser.getRank();
    }


    public static String displaySlogan() {
        if (LoginMenuController.loggedInUser.getSlogan() == null)
            return "Slogan is empty!";
        return "Your slogan : " + LoginMenuController.loggedInUser.getSlogan();
    }


    public static String display() {
        String result = "Presentable information:\n" +
                "HighScore : " + LoginMenuController.loggedInUser.getHighScore() +
                "\nRank : " + LoginMenuController.loggedInUser.getRank() +
                "\nSlogan : ";
        if (LoginMenuController.loggedInUser.getSlogan() == null)
            result += "Your slogan is empty!";
        result += LoginMenuController.loggedInUser.getSlogan();
        return result;
    }


}
