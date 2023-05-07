package model.Buildings;

import model.Governance;
import model.People;

import java.util.ArrayList;

public class IndustryBuildings extends Building{
    private ArrayList<People> workers;
    private int rate;
    private int maximumRate;

    public IndustryBuildings(Governance governance, String type, int x, int y, int hp, int maximumRate){
        super(governance,type,x,y);
        this.hp = 0;
        this.maximumHp = hp;
        this.neededWorkers = 0;
        this.rate = 0;
        this.maximumRate = maximumRate;
        this.x = x;
        this.y = y;
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

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getMaximumRate() {
        return maximumRate;
    }

    public void setMaximumRate(int maximumRate) {
        this.maximumRate = maximumRate;
    }
}
