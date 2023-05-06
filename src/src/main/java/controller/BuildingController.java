package controller;

import model.App;
import model.Buildings.Armory;
import model.Buildings.CastleBuildings;
import model.Buildings.FoodProcessingBuildings;
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

    public static boolean checkTextureForCastle(int x , int y){
        if(!(App.gameMap.getBlock(x,y).getTexture().equals("ground") ||
             App.gameMap.getBlock(x,y).getTexture().equals("gravelGround") ||
             App.gameMap.getBlock(x,y).getTexture().equals("grass") ||
             App.gameMap.getBlock(x,y).getTexture().equals("grassland") ||
             App.gameMap.getBlock(x,y).getTexture().equals("denseGrassland"))){
            System.out.println("texture is inappropriate");
            return false;
        }
        return true;
    }

    public static boolean checkNeededWorkers(int workers){
        if(App.getCurrentUser().getGovernance().getWorkers().size() < workers){
            System.out.println("Inadequate workers");
            return false;
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
                if(!checkTextureForCastle(x,y)) return;
                CastleBuildings smallStoneGatehouse = new CastleBuildings(governance,"small stone gatehouse",x,y,100,0,0);
                App.gameMap.getBlock(x,y).setBuilding(smallStoneGatehouse);
                governance.addBuilding(smallStoneGatehouse);
                break;
            case "big stone gatehouse":
                if(!checkTextureForCastle(x,y)) return;
                if(!checkInventoryAndPurchase(20,0,0,0,0,0)) return;
                CastleBuildings bigStoneGatehouse = new CastleBuildings(governance,"big stone gatehouse",x,y,150,0,0);
                App.gameMap.getBlock(x,y).setBuilding(bigStoneGatehouse);
                governance.addBuilding(bigStoneGatehouse);
                break;
            case "drawbridge":
                if(!checkTextureForCastle(x,y)) return;
                if(!checkInventoryAndPurchase(0,10,0,0,0,0)) return;
                CastleBuildings drawbridge = new CastleBuildings(governance,"drawbridge",x,y,50,0,0);
                App.gameMap.getBlock(x,y).setBuilding(drawbridge);
                governance.addBuilding(drawbridge);
                break;
            case "lookout tower":
                if(!checkTextureForCastle(x,y)) return;
                if(!checkInventoryAndPurchase(10,0,0,0,0,0)) return;
                CastleBuildings lookoutTower = new CastleBuildings(governance,"lookoutTower",x,y,200,0,0);
                App.gameMap.getBlock(x,y).setBuilding(lookoutTower);
                governance.addBuilding(lookoutTower);
                break;
            case "perimeter tower":
                if(!checkTextureForCastle(x,y)) return;
                if(!checkInventoryAndPurchase(10,0,0,0,0,0)) return;
                CastleBuildings perimeterTower = new CastleBuildings(governance,"perimeterTower",x,y,100,0,0);
                App.gameMap.getBlock(x,y).setBuilding(perimeterTower);
                governance.addBuilding(perimeterTower);
                break;
            case "turret":
                if(!checkTextureForCastle(x,y)) return;
                if(!checkInventoryAndPurchase(15,0,0,0,0,0)) return;
                CastleBuildings turret = new CastleBuildings(governance,"turret",x,y,150,0,0);
                App.gameMap.getBlock(x,y).setBuilding(turret);
                governance.addBuilding(turret);
                break;
            case "circular tower":
                if(!checkTextureForCastle(x,y)) return;
                if(!checkInventoryAndPurchase(40,0,0,0,0,0)) return;
                CastleBuildings circularTower = new CastleBuildings(governance,"circularTower",x,y,150,0,0);
                App.gameMap.getBlock(x,y).setBuilding(circularTower);
                governance.addBuilding(circularTower);
                break;
            case "square tower":
                if(!checkTextureForCastle(x,y)) return;
                if(!checkInventoryAndPurchase(35,0,0,0,0,0)) return;
                CastleBuildings squareTower = new CastleBuildings(governance,"squareTower",x,y,120,0,0);
                App.gameMap.getBlock(x,y).setBuilding(squareTower);
                governance.addBuilding(squareTower);
                break;
            case "armory":
                if(!checkTextureForCastle(x,y)) return;
                if(!checkInventoryAndPurchase(0,5,0,0,0,0)) return;
                Armory armory = new Armory(governance,x,y,200);
                App.gameMap.getBlock(x,y).setBuilding(armory);
                governance.addBuilding(armory);
                break;
            case "barrack":
                if(!checkTextureForCastle(x,y)) return;
                if(!checkInventoryAndPurchase(15,0,0,0,0,0)) return;
                CastleBuildings barrack = new CastleBuildings(governance,"barrack",x,y,120,0,0);
                App.gameMap.getBlock(x,y).setBuilding(barrack);
                governance.addBuilding(barrack);
                break;
            case "mercenary barrack":
                if(!checkTextureForCastle(x,y)) return;
                if(!checkInventoryAndPurchase(0,10,0,0,0,0)) return;
                CastleBuildings mercenaryBarrack = new CastleBuildings(governance,"mercenaryBarrack",x,y,120,0,0);
                App.gameMap.getBlock(x,y).setBuilding(mercenaryBarrack);
                governance.addBuilding(mercenaryBarrack);
                break;
            case "engineer guild":
                if(!checkTextureForCastle(x,y)) return;
                if(!checkInventoryAndPurchase(0,10,100,0,0,0)) return;
                CastleBuildings engineerGuild = new CastleBuildings(governance,"engineerGuild",x,y,120,0,0);
                App.gameMap.getBlock(x,y).setBuilding(engineerGuild);
                governance.addBuilding(engineerGuild);
                break;
            case "killing pit":
                if(!checkTextureForCastle(x,y)) return;
                if(!checkInventoryAndPurchase(0,6,0,0,0,0)) return;
                CastleBuildings killingPit = new CastleBuildings(governance,"killingPit",x,y,120,0,0);
                App.gameMap.getBlock(x,y).setBuilding(killingPit);
                governance.addBuilding(killingPit);
                break;
            case "inn":
                if(!checkTextureForCastle(x,y)) return;
                if(!checkNeededWorkers(1)) return;
                if(!checkInventoryAndPurchase(0,20,100,0,0,0)) return;
                governance.getWorkers().remove(governance.getWorkers().size()-1);
                FoodProcessingBuildings inn = new FoodProcessingBuildings(governance,"inn",x,y,100);
                App.gameMap.getBlock(x,y).setBuilding(inn);
                governance.addBuilding(inn);
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
