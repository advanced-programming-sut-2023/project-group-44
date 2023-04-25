package model;

import model.Buildings.Building;

import java.util.ArrayList;

public class Governance {
    private User owner;
    private int popularity;
    private int foodRate;
    private double numberOfAllFoods;
    private int taxRate;
    private ArrayList<Building> buildings;
    private ArrayList<People> people;
    private ArrayList<String> foodKinds;
    private int fearRate;

    public Governance(User owner) {
        this.owner = owner;
        this.popularity =0;
        this.foodRate =0;
        this.numberOfAllFoods = 0;
        this.taxRate = 0;
        this.buildings = new ArrayList<>();
        this.people = new ArrayList<>();
        this.foodKinds = new ArrayList<>();
        this.fearRate = 0;
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

    public ArrayList<People> getPeople() {
        return people;
    }

    public ArrayList<String> getFoodKinds() {
        return foodKinds;
    }

    public int getFearRate() {
        return fearRate;
    }
}

