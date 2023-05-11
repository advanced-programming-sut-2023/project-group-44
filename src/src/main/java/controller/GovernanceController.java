package controller;

import model.App;

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
}
