package model.Buildings;

public class WeaponBuildings extends Building{
    public WeaponBuildings(String type,int x,int y){
        super(type,x,y);
        switch (type) {
            case "typeName":
                this.hp = 0;
                this.neededCoin = 0;
                this.neededGold = 0;
                this.neededPitch = 0;
                this.neededStone = 0;
                this.neededWood = 0;
                this.neededWorkers = 0;
                this.neededIron = 0;
                this.x = x;
                this.y = y;
                break;
        }
    }
}
