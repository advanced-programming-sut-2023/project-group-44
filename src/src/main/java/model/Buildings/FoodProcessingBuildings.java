package model.Buildings;

import model.Governance;
import model.People.People;

import java.util.ArrayList;

public class FoodProcessingBuildings extends Building{
    private ArrayList<People> workers;
    public FoodProcessingBuildings(Governance governance,String type, int x, int y,int hp){
        super(governance,type,x,y);
        this.hp = 0;
        this.maximumHp = hp;
        this.neededWorkers = 0;
        this.x = x;
        this.y = y;
        this.workers = new ArrayList<>();
    }

    public ArrayList<People> getWorkers() {
        return workers;
    }

    public void addWorkers(People worker) {
        this.workers.add(worker);
    }
}
