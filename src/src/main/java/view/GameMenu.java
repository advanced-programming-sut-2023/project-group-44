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

            // Tax Rate Determination ::.
            else if ((matcher = GameMenuCommands.getMatcher(command, GameMenuCommands.TAX_RATE_DETERMINATION)) != null) {
                App.getCurrentUser().getGovernance().setTaxRate(Integer.parseInt(matcher.group("rateNumber")));
            }

            // .:: Tax Rate Show ::.
            else if ((matcher = GameMenuCommands.getMatcher(command, GameMenuCommands.TAX_RATE_SHOW)) != null) {
                System.out.println(App.getCurrentUser().getGovernance().getTaxRate());
            }

            // .:: Fear Rate Determination
            else if ((matcher = GameMenuCommands.getMatcher(command, GameMenuCommands.FEAR_RATE_DETERMINATION)) != null) {
                App.getCurrentUser().getGovernance().setFearRate(Integer.parseInt(matcher.group("rateNumber")));
            }

            // .:: Drop Building ::.
            else if ((matcher = GameMenuCommands.getMatcher(command, GameMenuCommands.DROP_BUILDING)) != null) {
                BuildingController.createBuilding(Integer.parseInt(matcher.group("x")), Integer.parseInt(matcher.group("y")), SignUpMenuController.deleteQuotations(matcher.group("type")));
            }

            // .:: Set Texture Of A Single Cell ::.
            else if((matcher = GameMenuCommands.getMatcher(command, GameMenuCommands.SET_TEXTURE_MONO)) != null) {
                int x = Integer.parseInt(matcher.group("x"));
                int y = Integer.parseInt(matcher.group("y"));
                System.out.println(MapController.setTexture(x,y,x,y,matcher.group("type")));
            }

            // .:: Set Texture Of A Rectangle Of Cells ::.
            else if((matcher = GameMenuCommands.getMatcher(command, GameMenuCommands.SET_TEXTURE_POLY)) != null) {
                int x1 = Integer.parseInt(matcher.group("x1"));
                int y1 = Integer.parseInt(matcher.group("y1"));
                int x2 = Integer.parseInt(matcher.group("x2"));
                int y2 = Integer.parseInt(matcher.group("y2"));
                System.out.println(MapController.setTexture(x1,y1,x2,y2,matcher.group("type")));
            }

            // .:: Clear Cell ::.
            else if((matcher = GameMenuCommands.getMatcher(command, GameMenuCommands.CLEAR)) != null) {
                int x = Integer.parseInt(matcher.group("x"));
                int y = Integer.parseInt(matcher.group("y"));
                System.out.println(MapController.clear(x,y));
            }

            // .:: Drop Rock ::.
            else if((matcher = GameMenuCommands.getMatcher(command, GameMenuCommands.DROP_ROCK)) != null) {
                int x = Integer.parseInt(matcher.group("x"));
                int y = Integer.parseInt(matcher.group("y"));
                System.out.println(MapController.dropRock(x,y,matcher.group("direction")));
            }

            // .:: Drop Tree ::.
            else if((matcher = GameMenuCommands.getMatcher(command, GameMenuCommands.DROP_TREE)) != null) {
                int x = Integer.parseInt(matcher.group("x"));
                int y = Integer.parseInt(matcher.group("y"));
                System.out.println(MapController.dropTree(x,y,matcher.group("direction")));
            }

            // .:: Select Building ::. (And Then Open Building Menu)
            else if ((matcher = GameMenuCommands.getMatcher(command, GameMenuCommands.SELECT_BUILDING)) != null) {
                // TODO
            }

            // .:: Select Unit (And Engineers) ::. (And Then Open Unit Menu)
            else if ((matcher = GameMenuCommands.getMatcher(command, GameMenuCommands.SELECT_UNIT)) != null) {
                int x = Integer.parseInt(matcher.group("x"));
                int y = Integer.parseInt(matcher.group("y"));
                switch (GameMenuController.selectUnit(x, y)) {
                    case SUCCESS -> {
                        System.out.println("Unit selected successfully.");
                        UnitMenu.run(scanner);
                    }
                    case NO_UNIT -> System.out.println("Select unit failed. There is no unit in this block.");
                    case INVALID_COORDINATION ->
                            System.out.println("Select unit failed. This block is not in the map.");
                    case FORBIDDEN -> System.out.println("Select unit failed. Opponents' unit!");
                }
            }
            // .:: Open TradeMenu ::.
            else if ((matcher = GameMenuCommands.getMatcher(command, GameMenuCommands.OPEN_TRADE_MENU))!=null) {
                TradeMenu tradeMenu=new TradeMenu();
                tradeMenu.run(scanner);
            }

            // .:: Back ::.
            else if ((matcher = GameMenuCommands.getMatcher(command, GameMenuCommands.BACK)) != null) {
                return;
            }

            // .:: Invalid Command ::.
            else {
                System.out.println("Invalid command");
                break;
            }
        }
    }
}
