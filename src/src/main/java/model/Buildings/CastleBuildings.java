package model.Buildings;

import model.Governance;
import model.Things;

import java.util.ArrayList;

public class CastleBuildings extends Building{
    private int fireRange;
    private int defendRange;
    private int rate;
    private String positionOfTheDrawBridge=null;
    private ArrayList<Things> weapons;

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
        if(type.equals("armory")){
            Things bow=Things.BOW;
            Things spear=Things.SPEAR;
            Things mace=Things.MACE;
            Things sword=Things.SWORD;
            Things leatherArmor=Things.LEATHER_ARMOR;
            Things metalArmor=Things.METAL_ARMOR;
            Things meltingPot=Things.MELTING_POT;
            weapons=new ArrayList<>();
            weapons.add(bow);
            weapons.add(spear);
            weapons.add(mace);
            weapons.add(sword);
            weapons.add(leatherArmor);
            weapons.add(meltingPot);
            weapons.add(metalArmor);
        }
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

    public String getPositionOfTheDrawBridge() {
        return positionOfTheDrawBridge;
    }

    public void setPositionOfTheDrawBridge(String positionOfTheDrawBridge) {
        this.positionOfTheDrawBridge = positionOfTheDrawBridge;
    }

    public ArrayList<Things> getWeapons() {
        return weapons;
    }
}
