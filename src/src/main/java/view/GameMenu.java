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

            // .:: Show Map ::.
            if ((matcher = GameMenuCommands.getMatcher(command, GameMenuCommands.SHOW_MAP)) != null) {
                MapMenu mapMenu = new MapMenu();
                mapMenu.run(scanner, matcher);
            }

            // .:: Show Popularity Factors ::.
            else if ((matcher = GameMenuCommands.getMatcher(command, GameMenuCommands.SHOW_POPULARITY_FACTORS)) != null) {
                GovernanceController.showPopularityFactors();
            }

            // .:: Show Popularity ::.
            else if ((matcher = GameMenuCommands.getMatcher(command, GameMenuCommands.SHOW_POPULARITY)) != null) {
                GovernanceController.showPopularity();

            }

            // .:: Show Food List ::.
            else if ((matcher = GameMenuCommands.getMatcher(command, GameMenuCommands.SHOW_FOOD_LIST)) != null) {
                // TODO
            }

            // .:: Food Rate Determination ::.
            else if ((matcher = GameMenuCommands.getMatcher(command, GameMenuCommands.FOOD_RATE_DETERMINATION)) != null) {
                App.getCurrentUser().getGovernance().setFoodRate(Integer.parseInt(matcher.group("rateNumber")));

            }

            // .:: Food Rate Show ::.
            else if ((matcher = GameMenuCommands.getMatcher(command, GameMenuCommands.FOOD_RATE_SHOW)) != null) {
                System.out.println(App.getCurrentUser().getGovernance().getFoodRate());
            }

            // .:: Tax Rate Determination ::.
            else if ((matcher = GameMenuCommands.getMatcher(command, GameMenuCommands.TAX_RATE_DETERMINATION)) != null) {
                App.getCurrentUser().getGovernance().setTaxRate(Integer.parseInt(matcher.group("rateNumber")));
            }

            // .:: Tax Rate Show ::.
            else if ((matcher = GameMenuCommands.getMatcher(command, GameMenuCommands.TAX_RATE_SHOW)) != null) {
                System.out.println(App.getCurrentUser().getGovernance().getTaxRate());
            }
            // .:: Fear Rate Determination ::.
            else if ((matcher = GameMenuCommands.getMatcher(command, GameMenuCommands.FEAR_RATE_DETERMINATION)) != null) {
                App.getCurrentUser().getGovernance().setFearRate(Integer.parseInt(matcher.group("rateNumber")));
            }

            // .:: Drop Building ::.
            else if ((matcher = GameMenuCommands.getMatcher(command, GameMenuCommands.DROP_BUILDING)) != null) {
                BuildingController.createBuilding(Integer.parseInt(matcher.group("x")), Integer.parseInt(matcher.group("y")), SignUpMenuController.deleteQuotations(matcher.group("type")));
            }

            // .:: Select Building ::.
            else if ((matcher = GameMenuCommands.getMatcher(command, GameMenuCommands.SELECT_BUILDING)) != null) {
                // TODO
            }

            // .:: Select Unit ::.
            // Unit Menu will be opened afterwards.
            else if ((matcher = GameMenuCommands.getMatcher(command, GameMenuCommands.SELECT_UNIT)) != null) {
                int x = Integer.parseInt(matcher.group("x"));
                int y = Integer.parseInt(matcher.group("y"));
                switch (GameMenuController.selectUnit(x, y)) {
                    case SUCCESS -> System.out.println("Unit selected successfully.");
                    case NO_UNIT -> System.out.println("Select unit failed. There is no unit in this block.");
                    case INVALID_COORDINATION ->
                            System.out.println("Select unit failed. This block is not in the map.");
                }
            } else System.out.println("Invalid command");
        }
    }
}
