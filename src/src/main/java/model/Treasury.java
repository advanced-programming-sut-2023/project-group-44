package model;

public class Treasury {
    private int woods=0;
    private int golds=0;
    private int coins=0;
    private int iron=0;
    private int stones=0;
    private int pitch=0;

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
