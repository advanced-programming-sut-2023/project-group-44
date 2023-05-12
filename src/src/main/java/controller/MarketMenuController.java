package controller;

import model.App;
import model.Governance;

import java.util.regex.Matcher;

public class MarketMenuController {
    public static String showPriceList(){
        String result="List of items:\n" +
                "item's name           number of sales     buy price   sell price" +
                "1) wood:                     10               3           2\n" +
                "2) iron:                     10               8           6\n" +
                "3) stone:                    10               5           3\n" +
                "4) flour:                    20               5           4\n" +
                "5) metal armour:             5                2           1\n" +
                "6) sword:                    5                3           2\n" +
                "7) mace:                     5                3           2\n" +
                "8) bow:                      5                4           2\n" +
                "9) spear:                    5                4           2\n" +
                "10) melting pot:             4                2           1\n" +
                "11) horse:                   3                2           1\n" +
                "12) apple:                   50               5           3\n" +
                "13) cheese:                  30               5           4\n" +
                "14) leather vest:            10               2           1\n" +
                "15) hop:                     25               5           4\n" +
                "16) beer:                    15               5           4\n" +
                "17) bread:                   15               5           4\n" +
                "18) meat:                    7                2           1\n";
        return result;
    }

    public static String buyItem(Matcher matcher){
        String nameOfItem= matcher.group("item");
        int amount=Integer.parseInt(matcher.group("amount"));
        int governanceCoins=App.getCurrentUser().getGovernance().getTreasury().getCoins();
        Governance governance=App.getCurrentUser().getGovernance();
        if(MarketItem.convertEnumItem(nameOfItem)==null)
            return "This item is invalid in shop! ";
        MarketItem marketItem=new MarketItem(MarketItem.convertEnumItem(nameOfItem));
        if(governanceCoins< marketItem.getBuyPrice()*amount)
            return "You don't have enough coins!";
        governance.getTreasury().addCoins(-marketItem.getBuyPrice()*amount);
        for(int i=0;i<amount;i++){
            MarketItem marketItem1=new MarketItem(MarketItem.convertEnumItem(nameOfItem));
            /*Must be added*/
        }
        return "purchased successfully!";
    }

    public static String sellItem(Matcher matcher){
        String nameOfItem= matcher.group("item");
        int amount=Integer.parseInt(matcher.group("amount"));
        Governance governance=App.getCurrentUser().getGovernance();
        if(MarketItem.convertEnumItem(nameOfItem)==null)
            return "This item is invalid in shop! ";
        MarketItem marketItem=new MarketItem(MarketItem.convertEnumItem(nameOfItem));
        governance.getTreasury().addCoins(marketItem.getSellPrice()*amount);
        for(int i=0;i<amount;i++){
            MarketItem marketItem1=new MarketItem(MarketItem.convertEnumItem(nameOfItem));
            /*Must be added*/
        }
        return "sold successfully!";
    }
}
