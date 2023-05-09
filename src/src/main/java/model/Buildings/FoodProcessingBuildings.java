package model.Buildings;

import model.Governance;

import java.util.ArrayList;

public class FoodProcessingBuildings extends Building{
    int rate;
    int capacity;
    public FoodProcessingBuildings(Governance governance,String type, int x, int y,int hp,int rate,int capacity){
        super(governance,type,x,y);
        this.hp = 0;
        this.maximumHp = hp;
        this.neededWorkers = 0;
        this.x = x;
        this.y = y;
        this.rate=rate;
        this.capacity=capacity;
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
}
