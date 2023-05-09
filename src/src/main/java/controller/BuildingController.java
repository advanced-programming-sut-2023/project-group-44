package controller;

import model.App;
import model.Buildings.*;
import model.Governance;
import model.People.People;
import model.People.Type;
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

    public static boolean checkNeededEngineers(int engineers){
        if(App.getCurrentUser().getGovernance().getEngineers().size() < engineers){
            System.out.println("Inadequate engineers");
            return false;
        }
        return true;
    }


    public static void workerTransfer(Building building,int workerNeeded){
        int index;
        for(int i=0; i<workerNeeded; i++){
            index = App.getCurrentUser().getGovernance().getWorkers().size()-1;
            building.addWorkers(App.getCurrentUser().getGovernance().getWorkers().get(index));
            App.getCurrentUser().getGovernance().getWorkers().remove(index);
        }
    }


    public static void engineerTransfer(Building building,int engineerNeeded){
        int index;
        for(int i=0; i<engineerNeeded; i++){
            index = App.getCurrentUser().getGovernance().getEngineers().size()-1;
            building.addEngineer(App.getCurrentUser().getGovernance().getEngineers().get(index));
            App.getCurrentUser().getGovernance().getEngineers().remove(index);
        }
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
                CastleBuildings smallStoneGatehouse = new CastleBuildings(governance,"small stone gatehouse",x,y,100,0,0,0);
                App.gameMap.getBlock(x,y).setBuilding(smallStoneGatehouse);
                governance.addBuilding(smallStoneGatehouse);
                break;
            case "big stone gatehouse":
                if(!checkTextureForCastle(x,y)) return;
                if(!checkInventoryAndPurchase(20,0,0,0,0,0)) return;
                CastleBuildings bigStoneGatehouse = new CastleBuildings(governance,"big stone gatehouse",x,y,150,0,0,0);
                App.gameMap.getBlock(x,y).setBuilding(bigStoneGatehouse);
                governance.addBuilding(bigStoneGatehouse);
                break;
            case "drawbridge":
                if(!checkTextureForCastle(x,y)) return;
                if(!checkInventoryAndPurchase(0,10,0,0,0,0)) return;
                CastleBuildings drawbridge = new CastleBuildings(governance,"drawbridge",x,y,50,0,0,0);
                App.gameMap.getBlock(x,y).setBuilding(drawbridge);
                governance.addBuilding(drawbridge);
                break;
            case "lookout tower":
                if(!checkTextureForCastle(x,y)) return;
                if(!checkInventoryAndPurchase(10,0,0,0,0,0)) return;
                CastleBuildings lookoutTower = new CastleBuildings(governance,"lookout tower",x,y,200,0,0,0);
                App.gameMap.getBlock(x,y).setBuilding(lookoutTower);
                governance.addBuilding(lookoutTower);
                break;
            case "perimeter tower":
                if(!checkTextureForCastle(x,y)) return;
                if(!checkInventoryAndPurchase(10,0,0,0,0,0)) return;
                CastleBuildings perimeterTower = new CastleBuildings(governance,"perimeter tower",x,y,100,0,0,0);
                App.gameMap.getBlock(x,y).setBuilding(perimeterTower);
                governance.addBuilding(perimeterTower);
                break;
            case "turret":
                if(!checkTextureForCastle(x,y)) return;
                if(!checkInventoryAndPurchase(15,0,0,0,0,0)) return;
                CastleBuildings turret = new CastleBuildings(governance,"turret",x,y,150,0,0,0);
                App.gameMap.getBlock(x,y).setBuilding(turret);
                governance.addBuilding(turret);
                break;
            case "circular tower":
                if(!checkTextureForCastle(x,y)) return;
                if(!checkInventoryAndPurchase(40,0,0,0,0,0)) return;
                CastleBuildings circularTower = new CastleBuildings(governance,"circular tower",x,y,150,0,0,0);
                App.gameMap.getBlock(x,y).setBuilding(circularTower);
                governance.addBuilding(circularTower);
                break;
            case "square tower":
                if(!checkTextureForCastle(x,y)) return;
                if(!checkInventoryAndPurchase(35,0,0,0,0,0)) return;
                CastleBuildings squareTower = new CastleBuildings(governance,"square tower",x,y,120,0,0,0);
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
                CastleBuildings barrack = new CastleBuildings(governance,"barrack",x,y,120,0,0,0);
                App.gameMap.getBlock(x,y).setBuilding(barrack);
                governance.addBuilding(barrack);
                break;
            case "mercenary barrack":
                if(!checkTextureForCastle(x,y)) return;
                if(!checkInventoryAndPurchase(0,10,0,0,0,0)) return;
                CastleBuildings mercenaryBarrack = new CastleBuildings(governance,"mercenary barrack",x,y,120,0,0,0);
                App.gameMap.getBlock(x,y).setBuilding(mercenaryBarrack);
                governance.addBuilding(mercenaryBarrack);
                break;
            case "engineer guild":
                if(!checkTextureForCastle(x,y)) return;
                if(!checkInventoryAndPurchase(0,10,100,0,0,0)) return;
                CastleBuildings engineerGuild = new CastleBuildings(governance,"engineer guild",x,y,120,0,0,0);
                App.gameMap.getBlock(x,y).setBuilding(engineerGuild);
                governance.addBuilding(engineerGuild);
                break;
            case "killing pit":
                if(!checkTextureForCastle(x,y)) return;
                if(!checkInventoryAndPurchase(0,6,0,0,0,0)) return;
                CastleBuildings killingPit = new CastleBuildings(governance,"killing pit",x,y,120,0,0,0);
                App.gameMap.getBlock(x,y).setBuilding(killingPit);
                governance.addBuilding(killingPit);
                break;
            case "inn":
                if(!checkTextureForCastle(x,y)) return;
                if(!checkNeededWorkers(1)) return;
                if(!checkInventoryAndPurchase(0,20,100,0,0,0)) return;
                FoodProcessingBuildings inn = new FoodProcessingBuildings(governance,"inn",x,y,100,0,0);
                workerTransfer(inn,1);
                App.gameMap.getBlock(x,y).setBuilding(inn);
                governance.addBuilding(inn);
                break;
            case "mill":
                if(!checkTextureForCastle(x,y)) return;
                if(!checkNeededWorkers(3)) return;
                if(!checkInventoryAndPurchase(0,20,0,0,0,0)) return;
                FoodProcessingBuildings mill = new FoodProcessingBuildings(governance,"mill",x,y,100,0,0);
                workerTransfer(mill,3);
                App.gameMap.getBlock(x,y).setBuilding(mill);
                governance.addBuilding(mill);
                break;
            case "iron mine":
                if(!checkTextureForCastle(x,y)) return;
                if(!checkNeededWorkers(2)) return;
                if(!checkInventoryAndPurchase(0,20,0,0,0,0)) return;
                IndustryBuildings ironMine = new IndustryBuildings(governance,"iron mine",x,y,100,30);
                workerTransfer(ironMine,2);
                App.gameMap.getBlock(x,y).setBuilding(ironMine);
                governance.addBuilding(ironMine);
                break;
            case "market":
                if(!checkTextureForCastle(x,y)) return;
                if(!checkNeededWorkers(1)) return;
                if(!checkInventoryAndPurchase(0,5,0,0,0,0)) return;
                IndustryBuildings market = new IndustryBuildings(governance,"market",x,y,100,0);
                workerTransfer(market,1);
                App.gameMap.getBlock(x,y).setBuilding(market);
                governance.addBuilding(market);
                break;
            case "ox tether":
                //******************************************************************************************************
                break;
            case "pitch rig":
                if(!(App.gameMap.getBlock(x,y).getTexture().equals("plain"))){
                    System.out.println("texture is inappropriate");
                    return;
                }
                if(!checkNeededWorkers(1)) return;
                if(!checkInventoryAndPurchase(0,20,0,0,0,0)) return;
                IndustryBuildings pitchRig = new IndustryBuildings(governance,"pitch rig",x,y,100,30);
                workerTransfer(pitchRig,1);
                App.gameMap.getBlock(x,y).setBuilding(pitchRig);
                governance.addBuilding(pitchRig);
                break;
            case "quarry":
                if(!(App.gameMap.getBlock(x,y).getTexture().equals("rock"))){
                    System.out.println("texture is inappropriate");
                    return;
                }
                if(!checkNeededWorkers(3)) return;
                if(!checkInventoryAndPurchase(0,20,0,0,0,0)) return;
                IndustryBuildings quarry = new IndustryBuildings(governance,"quarry",x,y,100,30);
                workerTransfer(quarry,3);
                App.gameMap.getBlock(x,y).setBuilding(quarry);
                governance.addBuilding(quarry);
                break;
            case "stockpile":
                if(!checkTextureForCastle(x,y)) return;
                IndustryBuildings stockpile = new IndustryBuildings(governance,"stockpile",x,y,100,0);
                App.gameMap.getBlock(x,y).setBuilding(stockpile);
                governance.addBuilding(stockpile);
                break;
            case "woodcutter":
                if(!checkTextureForCastle(x,y)) return;
                if(!checkNeededWorkers(1)) return;
                if(!checkInventoryAndPurchase(0,3,0,0,0,0)) return;
                IndustryBuildings woodCutter = new IndustryBuildings(governance,"woodcutter",x,y,100,30);
                workerTransfer(woodCutter,1);
                App.gameMap.getBlock(x,y).setBuilding(woodCutter);
                governance.addBuilding(woodCutter);
                break;
            case "hovel":
                if(!checkTextureForCastle(x,y)) return;
                if(!checkInventoryAndPurchase(0,6,0,0,0,0)) return;
                TownBuildings hovel=new TownBuildings(governance,"hovel",x,y,100);
                governance.setCapacity(governance.getCapacity()+8);
                App.gameMap.getBlock(x,y).setBuilding(hovel);
                governance.addBuilding(hovel);
                break;
            case "church":
                if(!checkTextureForCastle(x,y)) return;
                if(!checkInventoryAndPurchase(0,0,0,250,0,0)) return;
                TownBuildings church=new TownBuildings(governance,"church",x,y,100);
                governance.setPopularity(governance.getPopularity()+2);
                App.gameMap.getBlock(x,y).setBuilding(church);
                governance.addBuilding(church);
                break;
            case "cathedral":
                if(!checkTextureForCastle(x,y)) return;
                if(!checkInventoryAndPurchase(0,0,0,1000,0,0)) return;
                TownBuildings cathedral=new TownBuildings(governance,"cathedral",x,y,100);
                governance.setPopularity(governance.getPopularity()+2);
                People priest=new People(Type.OTHER,App.getCurrentUser(),50);
                cathedral.getPeopleWhoWorksIn().add(priest);
                App.gameMap.getBlock(x,y).setBuilding(cathedral);
                governance.addBuilding(cathedral);
                break;
            case "armourer":
                if(!checkTextureForCastle(x,y)) return;
                if(!checkNeededWorkers(1)) return;
                if(!checkInventoryAndPurchase(0,20,0,100,0,0)) return;
                WeaponBuildings armourer=new WeaponBuildings(governance,"armourer",x,y,100,"iron",50,10);
                workerTransfer(armourer,1);
                App.gameMap.getBlock(x,y).setBuilding(armourer);
                governance.addBuilding(armourer);
                break;
            case "blacksmith":
                if(!checkTextureForCastle(x,y)) return;
                if(!checkNeededWorkers(1)) return;
                if(!checkInventoryAndPurchase(0,20,0,100,0,0)) return;
                WeaponBuildings blacksmith=new WeaponBuildings(governance,"blacksmith",x,y,100,"iron",70,10);
                workerTransfer(blacksmith,1);
                App.gameMap.getBlock(x,y).setBuilding(blacksmith);
                governance.addBuilding(blacksmith);
                break;
            case "fletcher":
                if(!checkTextureForCastle(x,y)) return;
                if(!checkNeededWorkers(1)) return;
                if(!checkInventoryAndPurchase(0,20,0,100,0,0)) return;
                WeaponBuildings fletcher=new WeaponBuildings(governance,"fletcher",x,y,100,"wood",50,10);
                workerTransfer(fletcher,1);
                App.gameMap.getBlock(x,y).setBuilding(fletcher);
                governance.addBuilding(fletcher);
                break;
            case "oil smelter":
                if(!checkTextureForCastle(x,y)) return;
                if(!checkNeededEngineers(1)) return;
                if(!checkInventoryAndPurchase(0,0,0,100,10,0)) return;
                CastleBuildings oilSmelter=new CastleBuildings(governance,"oil smelter",x,y,100,0,0,10);
                engineerTransfer(oilSmelter,1);
                App.gameMap.getBlock(x,y).setBuilding(oilSmelter);
                governance.addBuilding(oilSmelter);
                break;
            case "pitch ditch":
                if(!checkTextureForCastle(x,y)) return;
                if(!checkInventoryAndPurchase(0,0,0,0,10,2)) return;
                CastleBuildings pitchDitch=new CastleBuildings(governance,"pitch ditch",x,y,0,0,0,0);
                App.gameMap.getBlock(x,y).setBuilding(pitchDitch);
                governance.addBuilding(pitchDitch);
                break;
            case "caged war dogs":
                if(!checkTextureForCastle(x,y)) return;
                if(!checkInventoryAndPurchase(0,10,0,100,10,0)) return;
                CastleBuildings cagedWarDogs=new CastleBuildings(governance,"caged war dogs",x,y,30,0,0,0);
                App.gameMap.getBlock(x,y).setBuilding(cagedWarDogs);
                governance.addBuilding(cagedWarDogs);
                break;
            case "siege tent":
                if(!checkTextureForCastle(x,y)) return;
                if(!checkNeededEngineers(1)) return;
                if(!checkInventoryAndPurchase(0,0,0,0,0,0)) return;
                CastleBuildings siegeTent=new CastleBuildings(governance,"siege tent",x,y,50,0,0,0);
                engineerTransfer(siegeTent,1);
                App.gameMap.getBlock(x,y).setBuilding(siegeTent);
                governance.addBuilding(siegeTent);
                break;
            case "stable":
                if(!checkTextureForCastle(x,y)) return;
                if(!checkInventoryAndPurchase(0,20,0,400,0,0)) return;
                CastleBuildings stable=new CastleBuildings(governance,"stable",x,y,100,0,0,20);
                App.gameMap.getBlock(x,y).setBuilding(stable);
                governance.addBuilding(stable);
                break;
            case "apple garden":
                if(!checkTextureForCastle(x,y)) return;
                if(!checkNeededWorkers(1)) return;
                if(!checkInventoryAndPurchase(0,5,0,0,0,0)) return;
                FarmBuildings appleGarden=new FarmBuildings(governance,"apple garden",x,y,100,150);
                workerTransfer(appleGarden,1);
                App.gameMap.getBlock(x,y).setBuilding(appleGarden);
                governance.addBuilding(appleGarden);
                break;
            case "dairy products":
                if(!checkTextureForCastle(x,y)) return;
                if(!checkNeededWorkers(1)) return;
                if(!checkInventoryAndPurchase(0,10,0,0,0,0)) return;
                FarmBuildings dairyProducts=new FarmBuildings(governance,"dairy products",x,y,100,120);
                workerTransfer(dairyProducts,1);
                App.gameMap.getBlock(x,y).setBuilding(dairyProducts);
                governance.addBuilding(dairyProducts);
                break;
            case "hop farm":
                if(!checkTextureForCastle(x,y)) return;
                if(!checkNeededWorkers(1)) return;
                if(!checkInventoryAndPurchase(0,15,0,0,0,0)) return;
                FarmBuildings hopFarm=new FarmBuildings(governance,"hop farm",x,y,100,200);
                workerTransfer(hopFarm,1);
                App.gameMap.getBlock(x,y).setBuilding(hopFarm);
                governance.addBuilding(hopFarm);
                break;
            case "hunting post":
                if(!checkTextureForCastle(x,y)) return;
                if(!checkNeededWorkers(1)) return;
                if(!checkInventoryAndPurchase(0,5,0,0,0,0)) return;
                FarmBuildings huntingPost=new FarmBuildings(governance,"hunting post",x,y,100,40);
                workerTransfer(huntingPost,1);
                App.gameMap.getBlock(x,y).setBuilding(huntingPost);
                governance.addBuilding(huntingPost);
                break;
            case "wheat farm":
                if(!checkTextureForCastle(x,y)) return;
                if(!checkNeededWorkers(1)) return;
                if(!checkInventoryAndPurchase(0,15,0,0,0,0)) return;
                FarmBuildings wheatFarm=new FarmBuildings(governance,"wheat farm",x,y,100,200);
                workerTransfer(wheatFarm,1);
                App.gameMap.getBlock(x,y).setBuilding(wheatFarm);
                governance.addBuilding(wheatFarm);
                break;
            case "bakery":
                if(!checkTextureForCastle(x,y)) return;
                if(!checkNeededWorkers(1)) return;
                if(!checkInventoryAndPurchase(0,10,0,0,0,0)) return;
                FoodProcessingBuildings bakery=new FoodProcessingBuildings(governance,"bakery",x,y,100,100,0);
                workerTransfer(bakery,1);
                App.gameMap.getBlock(x,y).setBuilding(bakery);
                governance.addBuilding(bakery);
                break;
            case "brewery":
                if(!checkTextureForCastle(x,y)) return;
                if(!checkNeededWorkers(1)) return;
                if(!checkInventoryAndPurchase(0,10,0,0,0,0)) return;
                FoodProcessingBuildings brewery=new FoodProcessingBuildings(governance,"brewery",x,y,100,100,0);
                workerTransfer(brewery,1);
                App.gameMap.getBlock(x,y).setBuilding(brewery);
                governance.addBuilding(brewery);
                break;
            case "food stockpile":
                if(!checkTextureForCastle(x,y)) return;
                if(!checkInventoryAndPurchase(0,5,0,0,0,0)) return;
                FoodProcessingBuildings foodStockpile=new FoodProcessingBuildings(governance,"food stockpile",x,y,100,0,500);
                App.gameMap.getBlock(x,y).setBuilding(foodStockpile);
                governance.addBuilding(foodStockpile);
                break;
        }
    }
}
