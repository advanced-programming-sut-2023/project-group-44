package controller;

import model.App;
import model.Governance;

import java.util.regex.Matcher;

public class MarketMenuController {
    public static String showPriceList(){
        String result="List of items:\n" +
                "item's name           number of sales     buy price   sell price" +
                " ********************** resources ************************\n"+
                " wood:                     10               3           2\n" +
                " iron:                     10               8           6\n" +
                " stone:                    10               5           3\n" +
                " pitch:                    10               6           4\n" +
                " ************************ foods **************************\n"+
                " hop:                      25               5           4\n" +
                " wheat:                    25               5           4\n" +
                " flour:                    20               5           4\n" +
                " apple:                    50               5           3\n" +
                " meat:                     7                2           1\n" +
                " cheese:                   30               5           4\n" +
                " bread:                    15               5           4\n" +
                " beer:                     15               5           4\n" +
                " *********************** weapons *************************\n"+
                " metal armour:             5                2           1\n" +
                " sword:                    5                3           2\n" +
                " mace:                     5                3           2\n" +
                " bow:                      5                4           2\n" +
                " spear:                    5                4           2\n" +
                " melting pot:              4                2           1\n" +
                " leather vest:             10               2           1\n" +
                " ********************** animals *************************\n"+
                " cow:                      3                2           1\n" +
                " horse:                    3                2           1\n" ;
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
