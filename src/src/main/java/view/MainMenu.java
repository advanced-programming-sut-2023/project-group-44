package view;

import controller.LoginMenuController;

import java.util.Scanner;
import java.util.regex.Matcher;

public class MainMenu {
    public void run(Scanner scanner){
        String command = "";
        Matcher matcher;

        while(true){
            command = scanner.nextLine();
            if((matcher = LoginMenuController.getMatcher(command,"^show\\s+map(?=.*\\s+-x\\s+(?<x>[0-9]+))(?=.*\\s+-y\\s+(?<y>[0-9]+)).*$")) != null){
                MapMenu mapMenu = new MapMenu();
                mapMenu.run(scanner,matcher);
            }else System.out.println("Invalid command");
        }
    }
}
