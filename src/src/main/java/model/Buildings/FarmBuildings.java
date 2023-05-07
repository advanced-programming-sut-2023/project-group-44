package model.Buildings;

import model.Governance;

public class FarmBuildings extends Building{
    int rate;
    public FarmBuildings(Governance governance,String  type, int x, int y,int hp,int rate){
        super(governance,type,x,y);
        this.hp = 0;
        this.maximumHp = hp;
        this.neededWorkers = 0;
        this.x = x;
        this.y = y;
        this.rate=rate;
    }
}
