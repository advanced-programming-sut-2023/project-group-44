package model.Buildings;

import model.Governance;

public class TownBuildings extends Building{
    public TownBuildings(Governance governance, String type, int x, int y, int hp){
        super(governance,type,x,y);
        this.hp = 0;
        this.maximumHp = hp;
        this.neededWorkers = 0;
        this.x = x;
        this.y = y;
    }
}
