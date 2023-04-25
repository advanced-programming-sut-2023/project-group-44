package view;

import controller.LoginMenuController;
import controller.ProfileMenuController;
import controller.SignUpMenuController;

import java.util.Scanner;
import java.util.regex.Matcher;

public class ProfileMenu {
    public void run(Scanner scanner){
        Matcher matcher=null;
        String input;
        String[] commands={
                "profile\\s+change\\s+-u\\s+(?<username>.+)",
                "profile\\s+change\\s+-n\\s+(?<nickname>.+)",
                "profile\\s+change\\s+(-o\\s+(?<oldPassword>.+))?\\s+(-n\\s+(?<newPassword>.+))?",
                "profile\\s+change\\s+-e\\s+(?<email>.+)",
                "profile\\s+change\\s+slogan\\s+-s\\s+(?<slogan>.+)",
                "profile\\s+remove\\s+slogan",
                           //display information commands:
                "profile\\s+display\\s+highscore",
                "profile\\s+display\\s+rank",
                "profile\\s+display\\s+slogan",
                "profile\\s+display",
                           //exit the current menu:
                "exit"
        };
        while (true){
            String result="";
            input=scanner.nextLine();
            for(String command: commands){
                if((matcher= LoginMenuController.getMatcher(command,input))!=null){
                    switch (command){
                        case "profile\\s+change\\s+-u\\s+(?<username>.+)":
                            result= ProfileMenuController.changeUsername(matcher,scanner);
                            break;
                        case "profile\\s+change\\s+-n\\s+(?<nickname>.+)":
                            result=ProfileMenuController.changeNickname(matcher);
                            break;
                        case "profile\\s+change\\s+(-o\\s+(?<oldPassword>.+))?\\s+(-n\\s+(?<newPassword>.+))?":
                            result=ProfileMenuController.changePassword(matcher,scanner);
                            break;
                        case "profile\\s+change\\s+-e\\s+(?<email>.+)":
                            result=ProfileMenuController.changeEmail(matcher);
                            break;
                        case "profile\\s+change\\s+slogan\\s+-s\\s+(?<slogan>.+)":
                            result=ProfileMenuController.changeSlogan(matcher);
                            break;
                        case "profile\\s+remove\\s+slogan":
                            result=ProfileMenuController.removeSlogan();
                            break;
                        case "profile\\s+display\\s+highscore":
                            result=ProfileMenuController.displayHighScore();
                            break;
                        case "profile\\s+display\\s+rank":
                            result=ProfileMenuController.displayRank();
                            break;
                        case "profile\\s+display\\s+slogan":
                            result=ProfileMenuController.displaySlogan();
                            break;
                        case "profile\\s+display":
                            result=ProfileMenuController.display();
                            break;
                        case "exit":
                            return;

                    }
                    System.out.println(result);
                    break;
                }
            }
            if(matcher==null){
                System.out.println("Invalid Command!");
            }
        }
    }
}
