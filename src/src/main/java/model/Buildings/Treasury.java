package model.Buildings;

import model.Buildings.Building;
import model.Governance;
import model.Things;

public class Treasury extends Building {
    private Things woods;
    private Things golds;
    private double coins;
    private Things iron;
    private Things stones;
    private Things pitch;
    private int maximumRate;

    public Treasury(Governance governance, String type, int x, int y,int hp){
        super(governance,type,x,y);
        woods = Things.WOOD;
        golds = Things.GOLD;
        iron = Things.IRON;
        this.coins = 0;
        stones = Things.STONE;
        pitch = Things.PITCH;
        this.hp=hp;
        this.maximumHp=hp;

    }

    public double getWoods() {
        return woods.getCount();
    }

    public void addWoods(int woods) {
        this.woods.setCount(this.woods.getCount()+woods);
    }

    public double getGolds() {
        return golds.getCount();
    }

    public void addGolds(int golds) {
        this.golds.setCount(this.golds.getCount()+golds);
    }

    public double getCoins() {
        return coins;
    }

    public void addCoins(double coins) {
        this.coins += coins;
    }

    public double getIron() {
        return iron.getCount();
    }

    public void addIron(int iron) {
        this.iron.setCount(this.iron.getCount()+iron);
    }

    public double getStones() {
        return stones.getCount();
    }

    public void addStones(int stones) {
        this.stones.setCount(this.stones.getCount()+stones);
    }

    public double getPitch() {
        return pitch.getCount();
    }

    public void addPitch(int pitch) {
        this.pitch.setCount(this.pitch.getCount()+pitch);
    }

}
