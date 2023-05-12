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

        while (true) {
            System.out.println("Choose a menu by number: 1.SignUpMenu 2.LoginMenu 3.finishProgram");
            command = scanner.nextLine();
            if (command.equals("1")) {
                System.out.println("entered signUpMenu");
                while(true){
                    command = scanner.nextLine();
                    if((matcher = LoginMenuController.getMatcher(command,userCreateRegex)) != null){
                        System.out.println(SignUpMenuController.userCreate(matcher,scanner));
                        break;
                    }else if((matcher = LoginMenuController.getMatcher(command,"^end$")) != null){
                        break;
                    }else System.out.println("Invalid command");
                }
            }
            else if (command.equals("2")) {
                LoginMenu loginMenu = new LoginMenu();
                loginMenu.run(scanner);
            }
            else if (command.equals("3")) {
                return;
            }
        }
        //System.out.println("entered signUpMenu");
         /*SignUpMenuController.signUpMenuGuid(command,scanner);
         while(true){
             command = scanner.nextLine();
             if((matcher = LoginMenuController.getMatcher(command,userCreateRegex)) != null){
                 String output = SignUpMenuController.userCreate(matcher,scanner);
                 System.out.println(output);
                 if(output.equals("Successful signup"))
                     SignUpMenuController.signUpMenuGuid(command,scanner);
             }else if((matcher = LoginMenuController.getMatcher(command,"^end$")) != null){
                 return;
             }else System.out.println("Invalid command");*/
    }
}
