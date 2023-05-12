package view;

import controller.GovernanceController;
import controller.LoginMenuController;
import model.App;

import java.util.Scanner;
import java.util.regex.Matcher;

public class MainMenu {
    public void run(Scanner scanner){
        String command = "";
        Matcher matcher;

        while(true){
            System.out.println("You are in main menu select a menu or type exit to back to SignUp/login");
            command = scanner.nextLine();
            if((matcher = LoginMenuController.getMatcher(command,"^game\\s+menu$")) != null){
                GameMenu gameMenu = new GameMenu();
                gameMenu.run(scanner);
            }else if((matcher = LoginMenuController.getMatcher(command,"^profile\\s+menu$")) != null){
                ProfileMenu profileMenu = new ProfileMenu();
                profileMenu.run(scanner);
            }else  if((matcher = LoginMenuController.getMatcher(command,"^exit$")) != null){
                return;
            }else System.out.println("Invalid command");
        }
    }
}
