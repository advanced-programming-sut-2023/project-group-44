package controller;

import model.App;
import model.Buildings.CastleBuildings;
import model.Governance;
import model.User;

public class BuildingController {

    public static boolean checkInventoryAndPurchase(int stone, int wood, int gold, int coin, int iron, int pitch){
        if(App.getCurrentUser().getGovernance().getTreasury().getStones() < stone){
            System.out.println("Not enough stones");
            return false;
        }else if(App.getCurrentUser().getGovernance().getTreasury().getWoods() < wood){
            System.out.println("Not enough woods");
            return false;
        }else if(App.getCurrentUser().getGovernance().getTreasury().getGolds() < gold){
            System.out.println("Not enough golds");
            return false;
        }else if(App.getCurrentUser().getGovernance().getTreasury().getCoins() < coin){
            System.out.println("Not enough coins");
            return false;
        }else if(App.getCurrentUser().getGovernance().getTreasury().getIron() < iron){
            System.out.println("Not enough iron");
            return false;
        }else if(App.getCurrentUser().getGovernance().getTreasury().getPitch() < pitch){
            System.out.println("Not enough pitch");
            return false;
        }else {
            App.getCurrentUser().getGovernance().getTreasury().addStones(-stone);
            App.getCurrentUser().getGovernance().getTreasury().addWoods(-wood);
            App.getCurrentUser().getGovernance().getTreasury().addGolds(-gold);
            App.getCurrentUser().getGovernance().getTreasury().addCoins(-coin);
            App.getCurrentUser().getGovernance().getTreasury().addIron(-iron);
            App.getCurrentUser().getGovernance().getTreasury().addPitch(-pitch);
        }
        return true;
    }

    public static void createBuilding(int x,int y,String type){
        if(x > 400 || y > 400){
            System.out.println("InvalidCoordinates");
            return;
        }
        Governance governance = App.getCurrentUser().getGovernance();
        if(App.gameMap.getBlock(x,y).getBuilding() !=null){
            System.out.println("this block have another building");
            return;
        }

        switch (type){
            case "small stone gatehouse":
                if(!(App.gameMap.getBlock(x,y).getTexture().equals("ground") || App.gameMap.getBlock(x,y).getTexture().equals("gravelGround") || App.gameMap.getBlock(x,y).getTexture().equals("grass") || App.gameMap.getBlock(x,y).getTexture().equals("grassland") || App.gameMap.getBlock(x,y).getTexture().equals("denseGrassland"))){
                    System.out.println("texture is inappropriate");
                    return;
                }
                CastleBuildings smallStoneGatehouse = new CastleBuildings(governance,"small stone gatehouse",x,y);
                App.gameMap.getBlock(x,y).setBuilding(smallStoneGatehouse);
                break;
            case "big stone gatehouse":
                if(!(App.gameMap.getBlock(x,y).getTexture().equals("ground") || App.gameMap.getBlock(x,y).getTexture().equals("gravelGround") || App.gameMap.getBlock(x,y).getTexture().equals("grass") || App.gameMap.getBlock(x,y).getTexture().equals("grassland") || App.gameMap.getBlock(x,y).getTexture().equals("denseGrassland"))){
                    System.out.println("texture is inappropriate");
                    return;
                }
                if(!checkInventoryAndPurchase(20,0,0,0,0,0)) return;
                CastleBuildings bigStoneGatehouse = new CastleBuildings(governance,"big stone gatehouse",x,y);
                App.gameMap.getBlock(x,y).setBuilding(bigStoneGatehouse);
                break;
            case "drawbridge":
                break;
            case "lookout tower":
                break;
            case "perimeter tower":
                break;
            case "turret":
                break;
            case "circular tower":
                break;
            case "square tower":
                break;
            case "armoury":
                break;
            case "barrack":
                break;
            case "mercenary barrack":
                break;
            case "engineer guild":
                break;
            case "killing pit":
                break;
            case "inn":
                break;
            case "mill":
                break;
            case "iron mine":
                break;
            case "market":
                break;
            case "ox tether":
                break;
            case "pitch rig":
                break;
            case "quarry":
                break;
            case "stockpile":
                break;
            case "woodcutter":
                break;
            case "hovel":
                break;
            case "church":
                break;
            case "cathedral":
                break;
            case "armourer":
                break;

        }
    }
}
