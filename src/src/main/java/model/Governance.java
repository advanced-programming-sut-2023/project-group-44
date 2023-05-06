package model;

import model.Buildings.Building;

import java.util.ArrayList;

public class Governance {
    private User owner;
    private int popularity;
    private int foodRate;
    private int freePopulation;
    private double numberOfAllFoods;
    private int taxRate;
    private ArrayList<Building> buildings;
    private ArrayList<People> workers;
    private ArrayList<String> foodKinds;
    private int fearRate;
    private int foodFactorPopularity;
    private int taxFactorPopularity;
    private int religionFactorPopularity;
    private int fearFactorPopularity;
    private Treasury treasury;

    public Governance(User owner) {
        this.owner = owner;
        this.popularity =0;
        this.foodRate =0;
        this.numberOfAllFoods = 0;
        this.taxRate = 0;
        this.freePopulation = 0;
        this.buildings = new ArrayList<>();
        this.workers = new ArrayList<>();
        this.foodKinds = new ArrayList<>();
        this.fearRate = 0;
        this.foodFactorPopularity=0;
        this.taxFactorPopularity=0;
        this.fearFactorPopularity=0;
        this.religionFactorPopularity=0;
    }

    public User getOwner() {
        return owner;
    }

    public int getPopularity() {
        return popularity;
    }

    public int getFoodRate() {
        return foodRate;
    }

    public double getNumberOfAllFoods() {
        return numberOfAllFoods;
    }

    public int getTaxRate() {
        return taxRate;
    }

    public ArrayList<Building> getBuildings() {
        return buildings;
    }
    public void addBuilding(Building building){ buildings.add(building);}

    public ArrayList<People> getWorkers() {
        return workers;
    }

    public ArrayList<String> getFoodKinds() {
        return foodKinds;
    }

    public int getFearRate() {
        return fearRate;
    }

    public int getFoodFactorPopularity() {
        return foodFactorPopularity;
    }

    public void setFoodFactorPopularity(int foodFactorPopularity) {
        this.foodFactorPopularity = foodFactorPopularity;
    }

    public int getTaxFactorPopularity() {
        return taxFactorPopularity;
    }

    public void setTaxFactorPopularity(int taxFactorPopularity) {
        this.taxFactorPopularity = taxFactorPopularity;
    }

    public int getReligionFactorPopularity() {
        return religionFactorPopularity;
    }

    public void setReligionFactorPopularity(int religionFactorPopularity) {
        this.religionFactorPopularity = religionFactorPopularity;
    }

    public int getFearFactorPopularity() {
        return fearFactorPopularity;
    }

    public void setFearFactorPopularity(int fearFactorPopularity) {
        this.fearFactorPopularity = fearFactorPopularity;
    }

    public void setFoodRate(int foodRate) {
        this.foodRate = foodRate;
    }

    public void setTaxRate(int taxRate) {
        this.taxRate = taxRate;
    }

    public void setFearRate(int fearRate) {
        this.fearRate = fearRate;
    }

    public Treasury getTreasury() {
        return treasury;
    }

    public int getFreePopulation() {
        return freePopulation;
    }

    public void addFreePopulation(int freePopulation) {
        this.freePopulation += freePopulation;
    }
}

