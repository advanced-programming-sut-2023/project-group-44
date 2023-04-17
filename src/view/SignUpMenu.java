package view;

import controller.LoginMenuController;
import controller.SignUpMenuController;

import java.util.Scanner;
import java.util.regex.Matcher;

public class SignUpMenu {
    public void run(Scanner scanner){
         String command;
         Matcher matcher;
         String userCreateRegex = "^user\\s+create((?=.*\\s+-u\\s+(?<username>\"[^\"]+\"|\\S+))?"+
                                  "(?=.*\\s+-p\\s+(?<password>\"[^\"]+\"|\\S+))?(?=.*\\s+-c\\s+(?<passwordConfirmation>\"[^\"]+\"|\\S+))?"+
                                  "(?=.*\\s+--email\\s+(?<email>\\S+))?(?=.*?\\s+-n\\s+(?<nickname>\"[^\"]+\"|\\S+))?"+
                                  "(?=.*\\s+--slogan\\s+(?<slogan>\"[^\"]\"|\\S+))?).*$";
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
         while(true){
             command = scanner.nextLine();
             if((matcher = LoginMenuController.getMatcher(userCreateRegex,command)) != null){
                 String output = SignUpMenuController.userCreate(matcher,scanner);
                 System.out.println(output);
                 if(output.equals("Successful signup")){
                     LoginMenu loginMenu = new LoginMenu();
                     loginMenu.run(scanner);
                     System.out.println("entered signUpMenu");
                 }
             }else if((matcher = LoginMenuController.getMatcher("^end$",command)) != null){
                 return;
             }else System.out.println("Invalid command");
         }
    }
}
