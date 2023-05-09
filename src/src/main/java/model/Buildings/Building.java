package model.Buildings;

import model.Governance;
import model.People.People;
import model.User;

import java.util.ArrayList;

public class Building {
    protected Governance government;
    protected String type;
    protected int hp;
    protected int maximumHp;
    protected int neededWorkers;
    protected int x, y;
    protected ArrayList<People> workers;
    protected ArrayList<People> engineers;

    public Building(Governance governance,String  type, int x, int y) {
        this.government = governance;
        this.type = type;
        this.x = x;
        this.y=y;
        this.workers=new ArrayList<>();
        this.engineers=new ArrayList<>();
    }


    public ArrayList<People> getWorkers() {
        return workers;
    }

    public void addWorkers(People worker) {
        this.workers.add(worker);
    }
    public void addEngineer(People engineer){ this.engineers.add(engineer);}
    public Governance getGovernment() {
        return government;
    }

    public String getType() {
        return type;
    }

    public int getHp() {
        return hp;
    }

    public int getNeededWorkers() {
        return neededWorkers;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMaximumHp() {
        return maximumHp;
    }

    public void setMaximumHp(int maximumHp) {
        this.maximumHp = maximumHp;
    }
}
