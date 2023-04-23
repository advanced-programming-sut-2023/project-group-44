package controller;

import model.App;
import model.User;
import view.LoginMenu;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.regex.Matcher;

public class SignUpMenuController {

    public static void signUpMenuGuid(String command,Scanner scanner){
        while(true) {
            System.out.println("Choose a menu by number: 1.SignUpMenu 2.LoginMenu");
            command = scanner.nextLine();
            if(command.equals("1"))
                break;
            else if(command.equals("2")){
                LoginMenu loginMenu = new LoginMenu();
                loginMenu.run(scanner);
                break;
            }
        }
        System.out.println("entered signUpMenu");
    }

    public static String deleteQuotations(String string) {
        if(string.startsWith("\""))
            return string.substring(1,string.length()-1);
        else return string;
    }

    public static String usernameValidation(Matcher matcher){
        String userName = deleteQuotations(matcher.group("username"));
        if(!(matcher.group("username").matches("^[a-zA-Z0-9\\s_]+$")))
            return null;
        else return userName;
    }

    public static String randomUsername(String name,Scanner scanner){
        for(int i=0;;i++){
            if(App.getUserByUsername(name+i) == null){
                System.out.println("If you want this username ( "+name+i+" ) type yes else no");
                if(scanner.nextLine().equals("yes"))
                    return name+i;
                else return null;
            }
        }
    }

    public static String randomPassword(String password, Scanner scanner){
        String randomCapitalLetter = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String randomSmallLetter = "abcdefghijklmnopqrstuvwxyz";
        String randomNumber = "0123456789";
        String randomCharacter = "~!@#$%^&*_/";
        StringBuilder sb = new StringBuilder(16);
        for(int i = 0; i<4 ; i++){
            sb.append(randomSmallLetter.charAt((int)(randomSmallLetter.length() * Math.random())));
            sb.append(randomCharacter.charAt((int)(randomCharacter.length() * Math.random())));
            sb.append(randomCapitalLetter.charAt((int)(randomCapitalLetter.length() * Math.random())));
            sb.append(randomNumber.charAt((int)(randomNumber.length() * Math.random())));
        }
        password = sb.toString();
        System.out.println("Your random password is: "+password+" please rewrite it");
        if(!scanner.nextLine().equals(password)) return null;
        else return password;
    }

    public static String passwordValidation(Matcher matcher){
        String password = deleteQuotations(matcher.group("password"));
        if(!password.matches("(?=.*[a-z]).+")) return "Weak password: small letter leak";
        if(!password.matches("(?=.*[A-Z]).+")) return "Weak password: capital letter leak";
        if(!password.matches("(?=.*[0-9]).+")) return "Weak password: number leak";
        if(!password.matches("(?=.*[\\W]).+")) return "Weak password: character leak";
        if(!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[\\W]).{6,}$")) return "Weak password: short length";
        if(!password.equals(deleteQuotations(matcher.group("passwordConfirmation"))))
            return "Incorrect password confirmation";
        return null;
    }

    public static String slogan(Matcher matcher){
        String slogan = deleteQuotations(matcher.group("slogan"));
        if(slogan.equals("random")){
            ArrayList<String> randomSlogan = new ArrayList<>();
            randomSlogan.add("I'm powerfull");
            randomSlogan.add("I'm strong");
            randomSlogan.add("I'm the lord of stronghold");
            slogan = randomSlogan.get((int) (Math.random() * (2)));
            System.out.println("Your random slogan is "+slogan);
            return slogan;
        }
        return slogan;
    }

    public static String securityQuestion(User user,Scanner scanner){
        LinkedHashMap<Integer,String> question = new LinkedHashMap<>();
        question.put(1, "What is my father’s name?");
        question.put(2, "What was my first pet’s name?");
        question.put(3,"What is my mother’s last name?" );

        System.out.println("Pick your security question: 1. What is my father’s name? 2. What was my first pet’s name? 3. What is my mother’s last name?");
        String command;
        Matcher matcher;
        command = scanner.nextLine();
        if((matcher = LoginMenuController.getMatcher(command,"^question\\s+pick((?=.*\\s+-q\\s+(?<questionNum>[123]))(?=.*\\s+-a\\s+(?<answer>\"[^\"]+\"|\\S+))(?=.*\\s+-c\\s+(?<answerCon>\"[^\"]+\"|\\S+))).*$")) != null){
            if(!(matcher.group("answer").equals(matcher.group("answerCon"))))
                return "Question pick failed";
            user.setNumberOfSecurityQuestion(Integer.parseInt(matcher.group("questionNum")));
            user.setSecurityQuestion(question.get(Integer.parseInt(matcher.group("questionNum"))-1));
            user.setAnswerOfSecurityQuestion(deleteQuotations(matcher.group("answer")));
            return "Successful signup";
        }
        return "Question pick failed";
    }

    public static String userCreate(Matcher matcher, Scanner scanner){
        if(matcher.group("username") == null || matcher.group("password") == null  ||matcher.group("email")==null || matcher.group("nickname") == null)
            return "You must enter require informations for signup";
        String userName = usernameValidation(matcher);
        String password = deleteQuotations(matcher.group("password"));
        if(userName == null) return "userName format is invalid";
        if(App.getUserByUsername(userName) != null) {
            System.out.println("This userName already exists");
            userName = randomUsername(userName,scanner);
            if(userName == null) return "SignUp failed try again";
        }
        if(password.equals("random")){
            password = randomPassword(password,scanner);
            if(password == null) return "Random password confirmation failed";
        }else{
            String passwordValidationMessage = passwordValidation(matcher);
            if(passwordValidationMessage != null) return passwordValidationMessage;
        }
        if(App.getUserByEmail(matcher.group("email")) != null) return "A user with this email already exists";
        if(!matcher.group("email").matches("^[\\w_\\.]+@[\\w_]+\\.?[\\w+]+\\.[\\w_]+$")) return "Invalid email format";
        User user = new User(userName,password,deleteQuotations(matcher.group("nickname")),matcher.group("email"));
        if(matcher.group("slogan") != null) {
            if(matcher.group("slogan").startsWith("-"))
                return "Empty slogan field";
            else
                user.setSlogan(slogan(matcher));
        }
        if(securityQuestion(user,scanner).equals("Question pick failed")) return "Question pick failed";
        App.addUser(user);
        return "Successful signup";
    }
}
