package view;

import controller.BuildingController;
import controller.GovernanceController;
import view.Commands.GameMenuCommands;
import controller.SignUpMenuController;
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

            } else if ((matcher = GameMenuCommands.getMatcher(command, GameMenuCommands.SHOW_POPULARITY_FACTORS)) != null) {
                GovernanceController.showPopularityFactors();

            } else if ((matcher = GameMenuCommands.getMatcher(command, GameMenuCommands.SHOW_POPULARITY)) != null) {
                GovernanceController.showPopularity();

            } else if ((matcher = GameMenuCommands.getMatcher(command, GameMenuCommands.SHOW_FOOD_LIST)) != null) {

            } else if ((matcher = GameMenuCommands.getMatcher(command, GameMenuCommands.FOOD_RATE_DETERMINATION)) != null) {
                App.getCurrentUser().getGovernance().setFoodRate(Integer.parseInt(matcher.group("rateNumber")));

            } else if ((matcher = GameMenuCommands.getMatcher(command, GameMenuCommands.FOOD_RATE_SHOW)) != null) {
                System.out.println(App.getCurrentUser().getGovernance().getFoodRate());

            } else if ((matcher = GameMenuCommands.getMatcher(command, GameMenuCommands.TAX_RATE_DETERMINATION)) != null) {
                App.getCurrentUser().getGovernance().setTaxRate(Integer.parseInt(matcher.group("rateNumber")));

            } else if ((matcher = GameMenuCommands.getMatcher(command, GameMenuCommands.TAX_RATE_SHOW)) != null) {
                System.out.println(App.getCurrentUser().getGovernance().getTaxRate());

            } else if ((matcher = GameMenuCommands.getMatcher(command, GameMenuCommands.FEAR_RATE_DETERMINATION)) != null) {
                App.getCurrentUser().getGovernance().setFearRate(Integer.parseInt(matcher.group("rateNumber")));

            } else if ((matcher = GameMenuCommands.getMatcher(command, GameMenuCommands.DROP_BUILDING)) != null) {
                BuildingController.createBuilding(Integer.parseInt(matcher.group("x")), Integer.parseInt(matcher.group("y")), SignUpMenuController.deleteQuotations(matcher.group("type")));

            } else if ((matcher = GameMenuCommands.getMatcher(command, GameMenuCommands.SELECT_BUILDING)) != null) {

            } else System.out.println("Invalid command");
        }
    }
}
