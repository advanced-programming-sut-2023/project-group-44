package controller;

import model.App;
import model.Buildings.CastleBuildings;

public class SelectBuildingController {

    public static boolean selectErrors(int x, int y){
        if(App.gameMap.getBlock(x,y).getBuilding() == null){
            System.out.println("there is not any building in this block");
            return false;
        }else if(!App.gameMap.getBlock(x,y).getBuilding().getGovernment().getOwner().equals(App.getCurrentUser())){
            System.out.println("this building does not belong to you");
            return false;
        }
        return true;
    }

    public static void repair(int x,int y){
        if(App.gameMap.getBlock(x,y).getBuilding() instanceof CastleBuildings){
            if(App.getCurrentUser().getGovernance().getTreasury().getStones() < 5) System.out.println("you don't have enough stones");
            else{
                App.gameMap.getBlock(x,y).getBuilding().setHp(App.gameMap.getBlock(x,y).getBuilding().getMaximumHp());
                App.getCurrentUser().getGovernance().getTreasury().addStones(-5);
                System.out.println("repair was successful");
            }
        }else System.out.println("only castle buildings are repairable");
    }



}
