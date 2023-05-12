package controller;

import model.App;
import model.Buildings.Building;
import model.Buildings.FoodProcessingBuildings;
import model.Governance;
import model.Things;

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
}
