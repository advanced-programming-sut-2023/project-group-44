package model.Buildings;

import model.Governance;
import model.User;

public class Building {
    protected Governance government;
    protected String type;
    protected int hp;
    protected int maximumHp;
    protected int neededWorkers;
    protected int x, y;

    public Building(Governance governance,String  type, int x, int y) {
        this.government = governance;
        this.type = type;
        this.x = x;
        this.y=y;
    }


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
}
