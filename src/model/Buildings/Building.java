package model.Buildings;

import model.Government;
import model.User;

public class Building {

    User owner;
    Government government;
    protected String type;
    protected int hp;
    protected int neededWood;
    protected int neededStone;
    protected int neededGold;
    protected int neededPitch;
    protected int neededCoin;
    protected int neededWorkers;
    protected int x, y;

    public Building(String type, int x, int y) {
        this.type = type;
        switch (type) {
            case "typeName":
                this.hp = 0;
                this.neededCoin = 0;
                this.neededGold = 0;
                this.neededPitch = 0;
                this.neededStone = 0;
                this.neededWood = 0;
                this.neededWorkers = 0;
                this.x = x;
                this.y = y;
                break;
        }
    }
}
