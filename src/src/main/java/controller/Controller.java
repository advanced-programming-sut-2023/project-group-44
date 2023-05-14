package controller;

import model.App;
import model.Buildings.Armory;
import model.Buildings.Building;
import model.Buildings.FoodProcessingBuildings;
import model.Buildings.Treasury;
import model.Governance;
import model.Things;
import model.User;

import java.util.ArrayList;
import java.util.regex.Matcher;

public class Controller {
    public static void taxCollect(){
        Governance governance = App.getCurrentUser().getGovernance();
        int population = governance.getOrdinaryPeople().size() + governance.getWorkers().size() + governance.getEngineers().size();
        if(governance.getTaxRate() == -3){
            governance.getTreasury().addCoins(-population);
            governance.setPopularity(governance.getPopularity()+7);
        }else if(governance.getTaxRate() == -2){
            governance.getTreasury().addCoins(-population*0.8);
            governance.setPopularity(governance.getPopularity()+5);
        }else if(governance.getTaxRate() == -1){
            governance.getTreasury().addCoins(-population*0.6);
            governance.setPopularity(governance.getPopularity()+3);
        }else if(governance.getTaxRate() == 0){
            governance.getTreasury().addCoins(0);
            governance.setPopularity(governance.getPopularity()+1);
        }else if(governance.getTaxRate() == 1){
            governance.getTreasury().addCoins(population*0.6);
            governance.setPopularity(governance.getPopularity()-2);
        }else if(governance.getTaxRate() == 2){
            governance.getTreasury().addCoins(population*0.8);
            governance.setPopularity(governance.getPopularity()-4);
        }else if(governance.getTaxRate() == 3){
            governance.getTreasury().addCoins(population);
            governance.setPopularity(governance.getPopularity()-6);
        }else if(governance.getTaxRate() == 4){
            governance.getTreasury().addCoins(population*1.2);
            governance.setPopularity(governance.getPopularity()-8);
        }else if(governance.getTaxRate() == 5){
            governance.getTreasury().addCoins(population*1.4);
            governance.setPopularity(governance.getPopularity()-12);
        }else if(governance.getTaxRate() == 6){
            governance.getTreasury().addCoins(population*1.6);
            governance.setPopularity(governance.getPopularity()-16);
        }else if(governance.getTaxRate() == 7){
            governance.getTreasury().addCoins(population*1.8);
            governance.setPopularity(governance.getPopularity()-20);
        }else if(governance.getTaxRate() == 8){
            governance.getTreasury().addCoins(population*2);
            governance.setPopularity(governance.getPopularity()-24);
        }
    }

    public static void religionEffect(){
        for(int i=0; i<App.getCurrentUser().getGovernance().getBuildings().size(); i++){
            if(App.getCurrentUser().getGovernance().getBuildings().get(i).getType().equals("church"))
                App.getCurrentUser().getGovernance().setPopularity(App.getCurrentUser().getGovernance().getPopularity()+2);
            if(App.getCurrentUser().getGovernance().getBuildings().get(i).getType().equals("cathedral"))
                App.getCurrentUser().getGovernance().setPopularity(App.getCurrentUser().getGovernance().getPopularity()+2);
        }
    }

    public static void fearEffect(){
        for(int i=0; i<App.getCurrentUser().getGovernance().getUnits().size(); i++){
            App.getCurrentUser().getGovernance().getUnits().get(i).addAttackPower(App.getCurrentUser().getGovernance().getFearRate());
        }

        int x=0,y=0;
        for(int i=0; i<App.getCurrentUser().getGovernance().getBuildings().size(); i++){
            if(App.getCurrentUser().getGovernance().getBuildings().get(i).getType().equals("small stone gatehouse")){
                x = App.getCurrentUser().getGovernance().getBuildings().get(i).getX();
                y = App.getCurrentUser().getGovernance().getBuildings().get(i).getY();
            }
        }

        for(int i=x-3; i<x+3; i++){
            for(int j=y-3; j<y+3; i++){
                if(App.gameMap.getBlock(x,y).getBuilding() != null)
                    App.getCurrentUser().getGovernance().setPopularity(App.getCurrentUser().getGovernance().getPopularity()+1);
            }
        }
    }

    public static void foodEffect(){
        Governance governance = App.getCurrentUser().getGovernance();

        FoodProcessingBuildings foodTreasury;
        ArrayList<Things> foods = null;
        for(int i=0; i<governance.getBuildings().size(); i++){
            if(governance.getBuildings().get(i).getType().equals("food stockpile")) {
                foodTreasury = (FoodProcessingBuildings) governance.getBuildings().get(i);
                foods = foodTreasury.getFoods();
            }
        }

        double rate = 0;
        if(governance.getFoodRate() == -2){
            rate = 0;
            governance.setPopularity(governance.getPopularity()-8);
        }else if(governance.getFoodRate()== -1){
            rate = 0.5;
            governance.setPopularity(governance.getPopularity()-4);
        }else if(governance.getFoodRate() == -0){
            rate = 1;
            governance.setPopularity(governance.getPopularity());
        }else if(governance.getFoodRate() == 1){
            rate = 1.5;
            governance.setPopularity(governance.getPopularity()+4);
        }else if(governance.getFoodRate() == 2){
            rate = 2;
            governance.setPopularity(governance.getPopularity()+8);
        }

        double population = (double) (governance.getOrdinaryPeople().size() + governance.getWorkers().size() +
                                                  governance.getEngineers().size())*rate;

        for(int i=0; i<foods.size(); i++) {
            if(foods.get(i).getName().equals("meat")){
                if(foods.get(i).getCount() < population){
                    population -= (double)foods.get(i).getCount();
                    foods.get(i).setCount(0);
                }else{
                    foods.get(i).setCount(foods.get(i).getCount() - population);
                    break;
                }
            }else if(foods.get(i).getName().equals("bread")){
                if(foods.get(i).getCount() < population*rate){
                    population -= foods.get(i).getCount();
                    foods.get(i).setCount(0);
                }else{
                    foods.get(i).setCount(foods.get(i).getCount() - population);
                    break;
                }
            }else if(foods.get(i).getName().equals("cheese")){
                if(foods.get(i).getCount() < population){
                    population -= foods.get(i).getCount();
                    foods.get(i).setCount(0);
                }else{
                    foods.get(i).setCount(foods.get(i).getCount() - population);
                    break;
                }
            }else if(foods.get(i).getName().equals("apple")){
                if(foods.get(i).getCount() < population){
                    population -= foods.get(i).getCount();
                    foods.get(i).setCount(0);
                }else{
                    foods.get(i).setCount(foods.get(i).getCount() - population);
                    break;
                }
            }

        }
    }

    public static void nextTurn(){
        Governance governance = App.getCurrentUser().getGovernance();
        FoodProcessingBuildings foodStockpile = null;
        Treasury treasury = null;
        Armory armory = null;
        taxCollect();
        foodEffect();
        fearEffect();
        religionEffect();
        for(Building x: governance.getBuildings()){
            if(x.getType().equals("food stockpile")){
                foodStockpile = (FoodProcessingBuildings) x;
                break;
            }
        }
        for(Building x: governance.getBuildings()){
            if(x.getType().equals("treasury")){
                treasury = (Treasury) x;
                break;
            }
        }
        for(Building x: governance.getBuildings()){
            if(x.getType().equals("armory")){
                armory = (Armory) x;
                break;
            }
        }
        for(Building x: governance.getBuildings()){
            if(x.getType().equals("inn"))
                governance.setPopularity(governance.getPopularity()+1);
            else if(x.getType().equals("mill"))
                foodStockpile.addFoodInStorage("flour",30);
            else if(x.getType().equals("iron mine"))
                treasury.addIron(30);
            else if(x.getType().equals("pitch rig"))
                treasury.addPitch(30);
            else if(x.getType().equals("quarry"))
                treasury.addStones(30);
            else if(x.getType().equals("woodcutter"))
                treasury.addWoods(30);
            else if(x.getType().equals("armourer")){
                treasury.addIron(-10);
                armory.addMetalArmor(10);
            }else if(x.getType().equals("blacksmith")){
                treasury.addIron(-20);
                armory.addSword(10);
                armory.addMace(10);
            }else if(x.getType().equals("fletcher")){
                treasury.addWoods(-10);
                armory.addBow(10);
            }else if(x.getType().equals("apple garden"))
                foodStockpile.addFoodInStorage("apple",10);
            else if(x.getType().equals("dairy products")){
                armory.addLeatherArmor(10);
                foodStockpile.addFoodInStorage("cheese",10);
            }else if(x.getType().equals("hop farm"))
                foodStockpile.addFoodInStorage("hop",10);
            else if(x.getType().equals("hunting post"))
                foodStockpile.addFoodInStorage("meat",10);
            else if(x.getType().equals("wheat farm"))
                foodStockpile.addFoodInStorage("wheat",10);
            else if(x.getType().equals("bakery"))
                foodStockpile.addFoodInStorage("bread",10);
            else if(x.getType().equals("brewery"))
                foodStockpile.addFoodInStorage("beer",10);
        }
        App.nextTurn = true;
    }
}
