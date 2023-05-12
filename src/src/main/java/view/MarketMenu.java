package view;

import controller.LoginMenuController;
import controller.MarketMenuController;

import java.util.Scanner;
import java.util.regex.Matcher;

public class MarketMenu {
    public void run(Scanner scanner){
        Matcher matcher=null;
        String input;
        String[] commands={
                "show\\s+price\\s+list",
                "buy(?=.*\\s+-i\\s+(?<item>.+))(?=.*\\s+-a\\s+(?<amount>.+))$",
                "sell(?=.*\\s+-i\\s+(?<item>.+))(?=.*\\s+-a\\s+(?<amount>.+))$",
                "back"
        };
        while(true){
            String result="";
            input=scanner.nextLine();
            for(String command: commands){
                if((matcher = LoginMenuController.getMatcher(command,input))!=null){
                    switch (command){
                        case "show\\s+price\\s+list":
                            result= MarketMenuController.showPriceList();
                            break;
                        case "buy(?=.*\\s+-i\\s+(?<item>.+))(?=.*\\s+-a\\s+(?<amount>.+))$":
                            result=MarketMenuController.buyItem(matcher);
                            break;
                        case "sell(?=.*\\s+-i\\s+(?<item>.+))(?=.*\\s+-a\\s+(?<amount>.+))$":
                            result=MarketMenuController.sellItem(matcher);
                            break;
                        case "back":
                            return;
                    }
                    System.out.println(result);
                    break;
                }
            }
            if(matcher==null)
                System.out.println("invalid command!");
        }
    }
}
