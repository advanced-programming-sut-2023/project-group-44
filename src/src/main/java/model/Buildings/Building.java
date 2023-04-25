package model.Buildings;

import model.Governance;
import model.User;

public class Building {

    User owner;
    Governance government;
    protected String type;
    protected int hp;
    protected int neededWood;
    protected int neededStone;
    protected int neededGold;
    protected int neededPitch;
    protected int neededCoin;
    protected int neededIron;
    protected int neededWorkers;
    protected int x, y;

    public Building(String type, int x, int y) {
        this.type = type;
        this.x = x;
        this.y=y;
    }

    public User getOwner() {
        return owner;
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

    public int getNeededWood() {
        return neededWood;
    }

    public int getNeededStone() {
        return neededStone;
    }

    public int getNeededGold() {
        return neededGold;
    }

    public int getNeededPitch() {
        return neededPitch;
    }

    public int getNeededCoin() {
        return neededCoin;
    }

    public int getNeededIron() {
        return neededIron;
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
