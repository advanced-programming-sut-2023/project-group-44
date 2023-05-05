package model.Buildings;

import model.Governance;
import model.User;

public class CastleBuildings extends Building{
    public CastleBuildings(Governance governance, String type, int x, int y){
        super(governance,type,x,y);
        this.hp = 0;
        this.neededWorkers = 0;
        this.x = x;
        this.y = y;
    }
    int fireRange;
    int defendRange;
}
