package view;

import controller.*;
import view.Commands.GameMenuCommands;
import model.App;

import java.util.Scanner;
import java.util.regex.Matcher;

public class GameMenu {
    public void run(Scanner scanner) {
        String command = "";
        Matcher matcher;

        while (true) {
            command = scanner.nextLine();

            if ((matcher = GameMenuCommands.getMatcher(command, GameMenuCommands.SHOW_MAP)) != null) {
                MapMenu mapMenu = new MapMenu();
                mapMenu.run(scanner, matcher);
            }
            else if ((matcher = GameMenuCommands.getMatcher(command, GameMenuCommands.SHOW_POPULARITY_FACTORS)) != null) {
                GovernanceController.showPopularityFactors();
            }
            else if ((matcher = GameMenuCommands.getMatcher(command, GameMenuCommands.SHOW_POPULARITY)) != null) {
                GovernanceController.showPopularity();
            }
            else if ((matcher = GameMenuCommands.getMatcher(command, GameMenuCommands.SHOW_FOOD_LIST)) != null) {
                // TODO
            }
            else if ((matcher = GameMenuCommands.getMatcher(command, GameMenuCommands.FOOD_RATE_DETERMINATION)) != null) {
                App.getCurrentUser().getGovernance().setFoodRate(Integer.parseInt(matcher.group("rateNumber")));

            }
            else if ((matcher = GameMenuCommands.getMatcher(command, GameMenuCommands.FOOD_RATE_SHOW)) != null) {
                System.out.println(App.getCurrentUser().getGovernance().getFoodRate());
            }
            else if ((matcher = GameMenuCommands.getMatcher(command, GameMenuCommands.TAX_RATE_DETERMINATION)) != null) {
                App.getCurrentUser().getGovernance().setTaxRate(Integer.parseInt(matcher.group("rateNumber")));
            }
            else if ((matcher = GameMenuCommands.getMatcher(command, GameMenuCommands.TAX_RATE_SHOW)) != null) {
                System.out.println(App.getCurrentUser().getGovernance().getTaxRate());
            }
            else if ((matcher = GameMenuCommands.getMatcher(command, GameMenuCommands.FEAR_RATE_DETERMINATION)) != null) {
                App.getCurrentUser().getGovernance().setFearRate(Integer.parseInt(matcher.group("rateNumber")));
            }
            else if ((matcher = GameMenuCommands.getMatcher(command, GameMenuCommands.DROP_BUILDING)) != null) {
                BuildingController.createBuilding(Integer.parseInt(matcher.group("x")), Integer.parseInt(matcher.group("y")), SignUpMenuController.deleteQuotations(matcher.group("type")));
            }
            else if ((matcher = GameMenuCommands.getMatcher(command, GameMenuCommands.SELECT_BUILDING)) != null) {
                // TODO
            }
            else if ((matcher = GameMenuCommands.getMatcher(command, GameMenuCommands.SELECT_UNIT)) != null) {
                int x = Integer.parseInt(matcher.group("x"));
                int y = Integer.parseInt(matcher.group("y"));
                switch (GameMenuController.selectUnit(x, y)) {
                    case SUCCESS -> System.out.println("Unit selected successfully.");
                    case NO_UNIT -> System.out.println("Select unit failed. There is no unit in this block.");
                    case INVALID_COORDINATION ->
                            System.out.println("Select unit failed. This block is not in the map.");
                }
            }
            else if((matcher = GameMenuCommands.getMatcher(command, GameMenuCommands.SET_TEXTURE_1)) != null) {
                int x = Integer.parseInt(matcher.group("x"));
                int y = Integer.parseInt(matcher.group("y"));
                System.out.println(MapController.setTexture(x,y,x,y,matcher.group("type")));
            }
            else if((matcher = GameMenuCommands.getMatcher(command, GameMenuCommands.SET_TEXTURE_2)) != null) {
                int x1 = Integer.parseInt(matcher.group("x1"));
                int y1 = Integer.parseInt(matcher.group("y1"));
                int x2 = Integer.parseInt(matcher.group("x2"));
                int y2 = Integer.parseInt(matcher.group("y2"));
                System.out.println(MapController.setTexture(x1,y1,x2,y2,matcher.group("type")));
            }
            else if((matcher = GameMenuCommands.getMatcher(command, GameMenuCommands.CLEAR)) != null) {
                int x = Integer.parseInt(matcher.group("x"));
                int y = Integer.parseInt(matcher.group("y"));
                System.out.println(MapController.clear(x,y));
            }
            else if((matcher = GameMenuCommands.getMatcher(command, GameMenuCommands.DROP_ROCK)) != null) {
                int x = Integer.parseInt(matcher.group("x"));
                int y = Integer.parseInt(matcher.group("y"));
                System.out.println(MapController.dropRock(x,y,matcher.group("direction")));
            }
            else if((matcher = GameMenuCommands.getMatcher(command, GameMenuCommands.DROP_TREE)) != null) {
                int x = Integer.parseInt(matcher.group("x"));
                int y = Integer.parseInt(matcher.group("y"));
                System.out.println(MapController.dropTree(x,y,matcher.group("direction")));
            }
            else System.out.println("Invalid command");
        }
    }
}
