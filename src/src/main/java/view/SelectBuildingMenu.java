package view;

import controller.LoginMenuController;
import controller.SelectBuildingController;
import model.App;

import javax.swing.event.ListSelectionListener;
import java.util.Scanner;
import java.util.regex.Matcher;

public class SelectBuildingMenu {
    public void run(Scanner scanner,int x,int y){
        String command = "";
        Matcher matcher;
        if(!SelectBuildingController.selectErrors(x,y)) return;
        System.out.println(App.gameMap.getBlock(x,y).getBuilding().getType());
        System.out.println(App.gameMap.getBlock(x,y).getBuilding().getHp());
        while(true){
            command = scanner.nextLine();
            if((matcher = LoginMenuController.getMatcher(command,"^repair$")) != null){
                SelectBuildingController.repair(x,y);
            }else if((matcher = LoginMenuController.getMatcher(command,"^change\\s+tax\\s+rate(?<rateNumber>[0-8]|\\-[1-3])$")) != null){
                SelectBuildingController.stoneGateHouse(Integer.parseInt(matcher.group("rateNumber")),x,y);
            }else if((matcher = LoginMenuController.getMatcher(command,"")) != null){

            }else if((matcher = LoginMenuController.getMatcher(command,"")) != null){

            }else if((matcher = LoginMenuController.getMatcher(command,"")) != null){

            }else if((matcher = LoginMenuController.getMatcher(command,"^back$")) != null){
                return;
            }else System.out.println("Invalid command");
        }
    }
}
