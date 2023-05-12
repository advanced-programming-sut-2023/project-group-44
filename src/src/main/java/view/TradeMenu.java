package view;

import controller.LoginMenuController;
import controller.MarketMenuController;
import controller.TradeMenuController;

import java.util.Scanner;
import java.util.regex.Matcher;

public class TradeMenu {
    public void run(Scanner scanner){
        Matcher matcher=null;
        String input;
        String[] commands={
                "^trade((?=.*\\s+-t\\s+(?<resourceType>\"[^\"]+\"|[^-\\s]\\S+))(?=.*\\s+-a\\s+(?<resourceAmount>\\d+))" +
                        "(?=.*\\s+-p\\s+(?<price>\\d+))(?=.*\\s+-m\\s+(?<message>\"[^\"]+\"|[^-\\s]\\S+))).*$",
                "trade\\s+list",
                "^trade\\s+accept((?=.*\\s+-i\\s+(?<id>\\d+))(?=.*\\s+-m\\s+(?<message>\"[^\"]+\"|[^-\\s]\\S+))).*$",
                "trade\\s+history",
                "back"
        };
        while(true){
            String result="";
            TradeMenuController.showNewNotifications();
            input=scanner.nextLine();
            for(String command: commands){
                if((matcher = LoginMenuController.getMatcher(command,input))!=null){
                    switch (command){
                        case "^trade((?=.*\\s+-t\\s+(?<resourceType>\"[^\"]+\"|[^-\\s]\\S+))(?=.*\\s+-a\\s+(?<resourceAmount>\\d+))" +
                                "(?=.*\\s+-p\\s+(?<price>\\d+))(?=.*\\s+-m\\s+(?<message>\"[^\"]+\"|[^-\\s]\\S+))).*$":
                            result= TradeMenuController.donationRequest(matcher);
                            break;
                        case "trade\\s+list":
                            result= TradeMenuController.showTradeList();
                            break;
                        case "^trade\\s+accept((?=.*\\s+-i\\s+(?<id>\\d+))(?=.*\\s+-m\\s+(?<message>\"[^\"]+\"|[^-\\s]\\S+))).*$":
                            result= TradeMenuController.acceptTrade(matcher);
                            break;
                        case "trade\\s+history":
                            result= TradeMenuController.showTradeHistory();
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
