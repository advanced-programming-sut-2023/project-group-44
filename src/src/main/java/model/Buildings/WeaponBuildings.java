package model.Buildings;

import model.Governance;

public class WeaponBuildings extends Building{
    int productionRate;
    String textureNeeded;
    int consumptionRate;
    public WeaponBuildings(Governance governance, String type, int x, int y, int hp,String textureNeeded,int consumptionRate,int productionRate){
        super(governance,type,x,y);
        this.hp = 0;
        this.maximumHp = hp;
        this.neededWorkers = 0;
        this.x = x;
        this.y = y;
        this.textureNeeded=textureNeeded;
        this.consumptionRate=consumptionRate;
        this.productionRate=productionRate;
    }
}
