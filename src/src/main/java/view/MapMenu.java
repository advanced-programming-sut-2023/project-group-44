package view;

import controller.LoginMenuController;
import controller.MapController;

import java.util.Scanner;
import java.util.regex.Matcher;

public class MapMenu {
    public void run(Scanner scanner, Matcher matcher){
        String command;
        Matcher mapMatcher;
        int x = Integer.parseInt(matcher.group("x"));
        int y = Integer.parseInt(matcher.group("y"));
        MapController.showMap(x,y);
        String moveMapRegex = "^map(?=.*\\s+left\\s+(?<left>[0-9]+))?(?=.*\\s+right\\s+(?<right>[0-9]+))?"+
                              "(?=.*\\s+up\\s+(?<up>[0-9]+))?(?=.*\\s+down\\s+(?<down>[0-9]+))?.*$";
        String mapDetailRegex = "^show\\s+details(?=.*\\s+-x\\s+(?<x>[0-9]+))?(?=.*\\s+-y\\s+(?<y>[0-9]+))?.*$";
        while(true){
            command = scanner.nextLine();
            if((mapMatcher = LoginMenuController.getMatcher(command,moveMapRegex)) != null){
                x = MapController.moveMapX(mapMatcher,command,x);
                y = MapController.moveMapY(mapMatcher,command,y);
                MapController.showMap(x,y);
            }else if((mapMatcher = LoginMenuController.getMatcher(command,mapDetailRegex)) != null){
                MapController.showDetails(Integer.parseInt(mapMatcher.group("x")),Integer.parseInt(mapMatcher.group("y")));
            }else if((mapMatcher = LoginMenuController.getMatcher(command,"^exit$")) != null){
                return;
            }else System.out.println("Invalid command");
        }
    }
}
