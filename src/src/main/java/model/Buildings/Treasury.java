package model.Buildings;

import model.Buildings.Building;
import model.Governance;

public class Treasury extends Building {
    private int woods;
    private int golds;
    private int coins;
    private int iron;
    private int stones;
    private int pitch;

    public Treasury(Governance governance, String type, int x, int y){
        super(governance,type,x,y);
        this.woods = 0;
        this.golds = 0;
        this.coins = 0;
        this.iron = 0;
        this.coins = 0;
        this.stones = 0;
        this.pitch = 0;
    }

    public int getWoods() {
        return woods;
    }

    public void addWoods(int woods) {
        this.woods += woods;
    }

    public int getGolds() {
        return golds;
    }

    public void addGolds(int golds) {
        this.golds += golds;
    }

    public int getCoins() {
        return coins;
    }

    public void addCoins(int coins) {
        this.coins += coins;
    }

    public int getIron() {
        return iron;
    }

    public void addIron(int iron) {
        this.iron += iron;
    }

    public int getStones() {
        return stones;
    }

    public void addStones(int stones) {
        this.stones += stones;
    }

    public int getPitch() {
        return pitch;
    }

    public void addPitch(int pitch) {
        this.pitch += pitch;
    }

}
