package view;

import controller.LoginMenuController;
import controller.SignUpMenuController;

import java.util.Scanner;
import java.util.regex.Matcher;

public class SignUpMenu {
    public void run(Scanner scanner){
         String command = "";
         Matcher matcher;
         String userCreateRegex = "^user\\s+create((?=.*\\s+-u\\s+(?<username>\"[^\"]+\"|[^-\\s]\\S+))?"+
                                  "(?=.*\\s+-p\\s+(?<password>\"[^\"]+\"|[^-\\s]\\S+))?(?=.*\\s+-c\\s+(?<passwordConfirmation>\"[^\"]+\"|[^-\\s]\\S+))?"+
                                  "(?=.*\\s+--email\\s+(?<email>[^-\\s]\\S+))?(?=.*?\\s+-n\\s+(?<nickname>\"[^\"]+\"|[^-\\s]\\S+))?"+
                                  "(?=.*\\s+--slogan\\s+(?<slogan>\"[^\"]\"|\\S+))?).*$";

        SignUpMenuController.signUpMenuGuid(command,scanner);
         while(true){
             command = scanner.nextLine();
             if((matcher = LoginMenuController.getMatcher(command,userCreateRegex)) != null){
                 String output = SignUpMenuController.userCreate(matcher,scanner);
                 System.out.println(output);
                 if(output.equals("Successful signup"))
                     SignUpMenuController.signUpMenuGuid(command,scanner);
             }else if((matcher = LoginMenuController.getMatcher(command,"^end$")) != null){
                 return;
             }else System.out.println("Invalid command");
         }
    }
}
