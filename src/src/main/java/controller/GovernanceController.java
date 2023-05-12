package controller;

import model.App;
import model.Buildings.FoodProcessingBuildings;

public class GovernanceController {
    public static void showPopularityFactors() {
        System.out.println("food: " + App.getCurrentUser().getGovernance().getFoodFactorPopularity() + "\n" +
                "tax: " + App.getCurrentUser().getGovernance().getTaxFactorPopularity() + "\n" +
                "religion: " + App.getCurrentUser().getGovernance().getReligionFactorPopularity() + "\n" +
                "fear: " + App.getCurrentUser().getGovernance().getFearFactorPopularity());
    }

    public static void showPopularity() {
        System.out.println(App.getCurrentUser().getGovernance().getFoodFactorPopularity() +
                App.getCurrentUser().getGovernance().getTaxFactorPopularity() +
                App.getCurrentUser().getGovernance().getReligionFactorPopularity() +
                App.getCurrentUser().getGovernance().getFearFactorPopularity());
    }

    public static void showFoodList(){
        FoodProcessingBuildings foodTreasury = null;
        String output = "";
        for(int i=0 ; i<App.getCurrentUser().getGovernance().getBuildings().size() ; i++){
            if(App.getCurrentUser().getGovernance().getBuildings().get(i).getType().equals("food stockpile")){
                foodTreasury = (FoodProcessingBuildings) App.getCurrentUser().getGovernance().getBuildings().get(i);
                break;
            }
        }

        for(int i = 0; i<foodTreasury.getFoods().size(); i++){
            if(foodTreasury.getFoods().get(i).getName().equals("meat"))
                output += "meat: " + foodTreasury.getFoods().get(i).getCount();
            else if(foodTreasury.getFoods().get(i).getName().equals("bread"))
                output += "bread: " + foodTreasury.getFoods().get(i).getCount();
            else if(foodTreasury.getFoods().get(i).getName().equals("apple"))
                output += "apple: " + foodTreasury.getFoods().get(i).getCount();
            else if(foodTreasury.getFoods().get(i).getName().equals("cheese"))
                output += "cheese: " + foodTreasury.getFoods().get(i).getCount();
        }
        System.out.println(output);
    }
}
