package view;

import controller.BuildingController;
import controller.GovernanceController;
import controller.LoginMenuController;
import controller.SignUpMenuController;
import model.App;

import java.util.Scanner;
import java.util.regex.Matcher;

public class GameMenu {
    public void run(Scanner scanner){
        String command = "";
        Matcher matcher;

        while(true){
            command = scanner.nextLine();
            if((matcher = LoginMenuController.getMatcher(command,"^show\\s+map(?=.*\\s+-x\\s+(?<x>[0-9]+))(?=.*\\s+-y\\s+(?<y>[0-9]+)).*$")) != null){
                MapMenu mapMenu = new MapMenu();
                mapMenu.run(scanner,matcher);
            }else if((matcher = LoginMenuController.getMatcher(command,"^show\\s+popularity\\s+factors$")) != null){
                GovernanceController.showPopularityFactors();
            }else if((matcher = LoginMenuController.getMatcher(command,"^show\\s+popularity$")) != null){
                GovernanceController.showPopularity();
            }else if((matcher = LoginMenuController.getMatcher(command,"^show\\s+food\\s+list$")) != null){

            }else if((matcher = LoginMenuController.getMatcher(command,"^food\\s+rate\\s+-r\\s+(?<rateNumber>[0-2]|\\-[1-2])$")) != null){
                App.getCurrentUser().getGovernance().setFoodRate(Integer.parseInt(matcher.group("rateNumber")));
            }else if((matcher = LoginMenuController.getMatcher(command,"^food\\s+rate\\s+show$")) != null){
                System.out.println(App.getCurrentUser().getGovernance().getFoodRate());
            }else if((matcher = LoginMenuController.getMatcher(command,"^tax\\s+rate\\s+-r\\s+(?<rateNumber>[0-8]|\\-[1-3])$")) != null){
                App.getCurrentUser().getGovernance().setTaxRate(Integer.parseInt(matcher.group("rateNumber")));
            }else if((matcher = LoginMenuController.getMatcher(command,"^tax\\s+rate\\s+show$")) != null){
                System.out.println(App.getCurrentUser().getGovernance().getTaxRate());
            }else if((matcher = LoginMenuController.getMatcher(command,"^fear\\s+rate\\s+-r\\s+(?<rateNumber>[0-5]|\\-[1-5])$")) != null){
                App.getCurrentUser().getGovernance().setFearRate(Integer.parseInt(matcher.group("rateNumber")));
            }else if((matcher = LoginMenuController.getMatcher(command,"^dropbuilding(?=.*\\s+-x\\s+(?<x>[0-9]+))(?=.*\\s+-y\\s+(?<y>[0-9]+))(?=.*\\s+-type\\s+(?<type>\"[^\"]+\"|\\S+)).*$")) != null){
                BuildingController.createBuilding(Integer.parseInt(matcher.group("x")),Integer.parseInt(matcher.group("y")), SignUpMenuController.deleteQuotations(matcher.group("type")));
            }else if((matcher = LoginMenuController.getMatcher(command,"^select\\s+building(?=.*\\s+-x\\s+(?<x>[0-9]+))(?=.*\\s+-y\\s+(?<y>[0-9]+)).*$")) != null){

            }else System.out.println("Invalid command");
        }
    }
}
