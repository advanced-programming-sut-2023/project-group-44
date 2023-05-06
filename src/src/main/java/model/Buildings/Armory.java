package model.Buildings;

import model.Governance;

public class Armory extends Building{
    private int weapons = 0;
    private int armours = 0;
    public Armory(Governance governance,int x, int y,int hp){
        super(governance,"armory",x,y);
        this.hp = hp;
        this.maximumHp = hp;
    }

    public int getWeapons() {
        return weapons;
    }

    public void addWeapons(int weapons) {
        this.weapons += weapons;
    }

    public int getArmours() {
        return armours;
    }

    public void addArmours(int armours) {
        this.armours += armours;
    }
}
