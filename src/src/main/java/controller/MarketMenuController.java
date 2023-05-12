package controller;

import model.App;
import model.Buildings.Building;
import model.Buildings.CastleBuildings;
import model.Buildings.FoodProcessingBuildings;
import model.Buildings.Treasury;
import model.Governance;
import model.Things;

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
        double governanceCoins=App.getCurrentUser().getGovernance().getTreasury().getCoins();
        Governance governance=App.getCurrentUser().getGovernance();
        if(Things.searchItemNames(nameOfItem) ==null)
            return "This item is invalid in shop! ";
        Things things=Things.searchItemNames(nameOfItem);
        if(governanceCoins< things.getPurchasePrice()*amount/things.getNumberOfSalesPerBuyOrSell())
            return "You don't have enough coins!";
        if(governance.getBuildingByName(things.getStorageName())==null)
            return "There is no "+things.getStorageName()+"in your governance!";
        governance.getTreasury().addCoins(-things.getPurchasePrice()*amount/things.getNumberOfSalesPerBuyOrSell());
        switch (things.getStorageName()){
            case "treasury":
                Treasury storage1= (Treasury) governance.getBuildingByName(things.getStorageName());
                switch (things.getName()){
                    case "wood":
                        storage1.addWoods(amount);
                        break;
                    case "stone":
                        storage1.addStones(amount);
                        break;
                    case "iron":
                        storage1.addIron(amount);
                        break;
                    case "gold":
                        storage1.addGolds(amount);
                        break;
                    case "pitch":
                        storage1.addPitch(amount);
                        break;
                }
                break;
            case "food stockpile":
                FoodProcessingBuildings storage2= (FoodProcessingBuildings) governance.getBuildingByName(things.getStorageName());
                storage2.addFoodInStorage(things.getName(),amount);
                break;
            case "armory":
                CastleBuildings storage3= (CastleBuildings) governance.getBuildingByName(things.getStorageName());
                storage3.addWeaponInStorage(things.getName(),amount);
                break;
        }
        return "purchased successfully!";
    }

    public static String sellItem(Matcher matcher){
        String nameOfItem= matcher.group("item");
        int amount=Integer.parseInt(matcher.group("amount"));
        Governance governance=App.getCurrentUser().getGovernance();
        if(Things.searchItemNames(nameOfItem) ==null)
            return "This item is invalid in shop! ";
        Things things=Things.searchItemNames(nameOfItem);
        if(governance.getBuildingByName(things.getStorageName())==null)
            return "There is no "+things.getStorageName()+"in your governance!";
        switch (things.getStorageName()){
            case "treasury":
                Treasury storage1= (Treasury) governance.getBuildingByName(things.getStorageName());
                switch (things.getName()){
                    case "wood":
                        if(storage1.getWoods()<amount)
                            return "You don't have enough wood!";
                        storage1.addWoods(-amount);
                        break;
                    case "stone":
                        if(storage1.getStones()<amount)
                            return "You don't have enough stone!";
                        storage1.addStones(-amount);
                        break;
                    case "iron":
                        if(storage1.getIron()<amount)
                            return "You don't have enough iron!";
                        storage1.addIron(-amount);
                        break;
                    case "gold":
                        if(storage1.getGolds()<amount)
                            return "You don't have enough gold!";
                        storage1.addGolds(-amount);
                        break;
                    case "pitch":
                        if(storage1.getPitch()<amount)
                            return "You don't have enough pitch!";
                        storage1.addPitch(-amount);
                        break;
                }
                break;
            case "food stockpile":
                FoodProcessingBuildings storage2= (FoodProcessingBuildings) governance.getBuildingByName(things.getStorageName());
                if(!storage2.checkIfFoodIsEnoughForSell(things.getName(),amount))
                    return "You don't have enough "+things.getName()+"!";
                storage2.addFoodInStorage(things.getName(),-amount);
                break;
            case "armory":
                CastleBuildings storage3= (CastleBuildings) governance.getBuildingByName(things.getStorageName());
                if(!storage3.checkIfWeaponIsEnoughForSell(things.getName(),amount))
                    return "You don't have enough "+things.getName()+"!";
                storage3.addWeaponInStorage(things.getName(),-amount);
                break;
        }
        governance.getTreasury().addCoins(things.getPurchasePrice()*amount/things.getNumberOfSalesPerBuyOrSell());
        return "sold successfully!";
    }
}
