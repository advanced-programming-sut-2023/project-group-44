package model;

import model.Buildings.Building;
import model.Buildings.Treasury;
import model.People.People;
import model.People.Units.Unit;
import model.People.Workers.Worker;

import java.util.ArrayList;

public class Governance {
    private int capacity;
    private int popularity;
    private int foodRate;
    private int freePopulation;
    private double numberOfAllFoods;
    private int taxRate;
    private ArrayList<Building> buildings;
    private ArrayList<People> ordinaryPeople;
    private ArrayList<Worker> workers;
    private ArrayList<Worker> engineers;
    private ArrayList<Unit> units;
    private ArrayList<String> foodKinds;
    private int fearRate;
    private int foodFactorPopularity;
    private int taxFactorPopularity;
    private int religionFactorPopularity;
    private int fearFactorPopularity;
    private Treasury treasury;

    public Governance(User owner) {

        this.capacity = 0;
        this.popularity = 0;
        this.foodRate = 0;
        this.numberOfAllFoods = 0;
        this.taxRate = 0;
        this.freePopulation = 0;
        this.buildings = new ArrayList<>();
        this.workers = new ArrayList<>();
        this.engineers = new ArrayList<>();
        this.units = new ArrayList<>();
        this.foodKinds = new ArrayList<>();
        this.ordinaryPeople = new ArrayList<>();
        this.fearRate = 0;
        this.foodFactorPopularity = 0;
        this.taxFactorPopularity = 0;
        this.fearFactorPopularity = 0;
        this.religionFactorPopularity = 0;
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
    public Building getBuildingByName(String name){
        for(Building building: buildings){
            if(building.getType().equals(name))
                return building;
        }
        return null;
    }

    public ArrayList<Building> getBuildings() {
        return buildings;
    }
    public void addBuilding(Building building){ buildings.add(building);}

    public ArrayList<Worker> getWorkers() {
        return workers;
    }

    public ArrayList<Worker> getEngineers() {
        return engineers;
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

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setPopularity(int popularity) {
        this.popularity = popularity;
    }

    public ArrayList<Unit> getUnits() {
        return units;
    }

    public ArrayList<People> getOrdinaryPeople() {
        return ordinaryPeople;
    }
}

