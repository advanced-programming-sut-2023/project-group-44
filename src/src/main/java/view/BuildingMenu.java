package view;

import controller.LoginMenuController;
import controller.BuildingMenuController;
import model.App;
import view.Commands.BuildingMenuCommands;

import java.util.Scanner;
import java.util.regex.Matcher;

public class BuildingMenu {
    public static void run(Scanner scanner, int x, int y) {
        String command;
        Matcher matcher;
        System.out.println(App.gameMap.getBlock(x, y).getBuilding().getType());
        System.out.println(App.gameMap.getBlock(x, y).getBuilding().getHp());
        while (true) {
            command = scanner.nextLine();

            // .:: Repair ::.
            if ((matcher = BuildingMenuCommands.getMatcher(command, BuildingMenuCommands.REPAIR)) != null) {
                BuildingMenuController.repair(x, y);
            }

            // .:: Change Tax Rate ::.
            else if ((matcher = BuildingMenuCommands.getMatcher(command, BuildingMenuCommands.CHANGE_TAX_RATE)) != null) {
                BuildingMenuController.stoneGateHouse(Integer.parseInt(matcher.group("rateNumber")), x, y);
            }

            // .:: Change Position Of Bridge ::.
            else if ((matcher = BuildingMenuCommands.getMatcher(command, BuildingMenuCommands.CHANGE_BRIDGE_POSITION)) != null) {
                BuildingMenuController.drawBridge(matcher.group("position"), x, y);
            }

            // .:: Buy Soldiers ::.
            else if ((matcher = BuildingMenuCommands.getMatcher(command, BuildingMenuCommands.BUY_SOLDIERS)) != null) {
                BuildingMenuController.mercenaryBarrack(matcher.group("typeOfSoldier"), Integer.parseInt(matcher.group("numberOfSoldiers")), x, y);
            }

            // .:: Hire Soldiers ::.
            else if ((matcher = BuildingMenuCommands.getMatcher(command, BuildingMenuCommands.HIRE_SOLDIERS)) != null) {
                BuildingMenuController.engineerGuild(matcher.group("typeOfPeople"), Integer.parseInt(matcher.group("numberOfPeople")), x, y);
            }

            // .:: Create Unit ::.
            else if ((matcher = BuildingMenuCommands.getMatcher(command, BuildingMenuCommands.CREATE_UNIT)) != null) {
                BuildingMenuController.createUnit(matcher.group("type"), Integer.parseInt(matcher.group("count")), x, y);
            }

            // .:: Back ::.
            else if ((matcher = LoginMenuController.getMatcher(command, "^back$")) != null) {
                return;
            } else System.out.println("Invalid command");
        }
    }
}
