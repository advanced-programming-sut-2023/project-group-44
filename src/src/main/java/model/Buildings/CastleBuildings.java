package model.Buildings;

import model.Governance;
import model.User;

public class CastleBuildings extends Building{
    private int fireRange;
    private int defendRange;
    private int rate;

    public CastleBuildings(Governance governance, String type, int x, int y,int hp,int fireRange,int defendRange,int rate){
        super(governance,type,x,y);
        this.fireRange = fireRange;
        this.defendRange = defendRange;
        this.hp = hp;
        this.maximumHp = hp;
        this.neededWorkers = 0;
        this.x = x;
        this.y = y;
        this.rate=rate;
    }

    public int getFireRange() {
        return fireRange;
    }

    public int getDefendRange() {
        return defendRange;
    }

    public int getRate() {
        return rate;
    }
}
