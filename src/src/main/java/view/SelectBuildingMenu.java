package view;

import controller.LoginMenuController;
import controller.SelectBuildingController;
import model.App;

import java.util.Scanner;
import java.util.regex.Matcher;

public class SelectBuildingMenu {
    public void run(Scanner scanner,int x,int y){
        String command = "";
        Matcher matcher;
        if(!SelectBuildingController.selectErrors(x,y)) return;
        System.out.println(App.gameMap.getBlock(x,y).getBuilding().getHp());
        while(true){
            command = scanner.nextLine();
            if((matcher = LoginMenuController.getMatcher(command,"^repair$")) != null){
                SelectBuildingController.repair(x,y);
            }else if((matcher = LoginMenuController.getMatcher(command,"")) != null){

            }else if((matcher = LoginMenuController.getMatcher(command,"")) != null){

            }else if((matcher = LoginMenuController.getMatcher(command,"")) != null){

            }else if((matcher = LoginMenuController.getMatcher(command,"")) != null){

            }else if((matcher = LoginMenuController.getMatcher(command,"^back$")) != null){
                return;
            }else System.out.println("Invalid command");
        }
    }
}
