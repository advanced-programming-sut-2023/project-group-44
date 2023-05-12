package view;

import controller.LoginMenuController;
import controller.BuildingMenuController;
import model.App;

import java.util.Scanner;
import java.util.regex.Matcher;

public class BuildingMenu {
    public void run(Scanner scanner,int x,int y){
        String command = "";
        Matcher matcher;
        if(!BuildingMenuController.selectErrors(x,y)) return;
        System.out.println(App.gameMap.getBlock(x,y).getBuilding().getType());
        System.out.println(App.gameMap.getBlock(x,y).getBuilding().getHp());
        while(true){
            command = scanner.nextLine();
            if((matcher = LoginMenuController.getMatcher(command,"^repair$")) != null){
                BuildingMenuController.repair(x,y);
            }else if((matcher = LoginMenuController.getMatcher(command,"^change\\s+tax\\s+rate\\s+(?<rateNumber>[0-8]|\\-[1-3])$")) != null){
                BuildingMenuController.stoneGateHouse(Integer.parseInt(matcher.group("rateNumber")),x,y);
            }
            else if((matcher = LoginMenuController.getMatcher(command,"^change\\s+the\\s+position\\s+of\\s+the\\s+bridge\\s+(?<position>up|down)$")) != null){
                BuildingMenuController.drawBridge(matcher.group("position"),x,y);
            }
            else if((matcher = LoginMenuController.getMatcher(command,"buy\\s+number:\\s+(?<numberOfSoldiers>\\d+)\\s+type:\\s+(?<typeOfSoldier>\\w+)")) != null){
                BuildingMenuController.mercenaryBarrack(matcher.group("typeOfSoldier"),Integer.parseInt(matcher.group("numberOfSoldiers")),x,y);
            }
            else if((matcher = LoginMenuController.getMatcher(command,"hire\\s+number:\\s+(?<numberOfPeople>\\d+)\\s+type:\\s+(?<typeOfPeople>\\w+)")) != null){
                BuildingMenuController.engineerGuild(matcher.group("typeOfPeople"),Integer.parseInt(matcher.group("numberOfPeople")),x,y);
            }
            else if((matcher = LoginMenuController.getMatcher(command,"^back$")) != null){
                return;
            }else System.out.println("Invalid command");
        }
    }
}
