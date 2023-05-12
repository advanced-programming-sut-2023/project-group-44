package model.Buildings;

import model.Governance;
import model.People.People;
import model.Things;

import java.util.ArrayList;

public class FoodProcessingBuildings extends Building{
    int rate;
    int capacity;
    private ArrayList<Things> foods;
    public FoodProcessingBuildings(Governance governance,String type, int x, int y,int hp,int rate,int capacity){
        super(governance,type,x,y);
        this.hp = 0;
        this.maximumHp = hp;
        this.neededWorkers = 0;
        this.x = x;
        this.y = y;
        this.rate=rate;
        this.capacity=capacity;
        if(type.equals("food stockpile")){
            Things meat=Things.MEAT;
            Things cheese=Things.CHEESE;
            Things apple=Things.APPLE;
            Things bread=Things.BREAD;
            Things beer=Things.BEER;
            Things wheat=Things.WHEAT;
            Things hop=Things.HOP;
            Things flour=Things.FLOUR;
            foods=new ArrayList<>();
            foods.add(meat);
            foods.add(cheese);
            foods.add(apple);
            foods.add(bread);
            foods.add(beer);
            foods.add(wheat);
            foods.add(hop);
            foods.add(flour);
        }
    }

    public ArrayList<People> getWorkers() {
        return workers;
    }

    public void addWorkers(People worker) {
        this.workers.add(worker);
    }

    public int getRate() {
        return rate;
    }

    public int getCapacity() {
        return capacity;
    }

    public ArrayList<Things> getFoods() {
        return foods;
    }
}
