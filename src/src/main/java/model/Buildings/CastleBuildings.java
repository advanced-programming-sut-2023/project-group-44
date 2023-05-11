package model.Buildings;

import model.Governance;
import model.Market.MarketItem;
import model.User;

import java.util.ArrayList;

public class CastleBuildings extends Building{
    private int fireRange;
    private int defendRange;
    private int rate;
    private String positionOfTheDrawBridge=null;
    private ArrayList<MarketItem> weapons;

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
        if(type.equals("armory"))
            weapons=new ArrayList<>();
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
}
