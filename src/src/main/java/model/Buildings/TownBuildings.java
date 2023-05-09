package model.Buildings;

import model.Governance;
import model.People.People;

import java.util.ArrayList;

public class TownBuildings extends Building{
    ArrayList<People> peopleWhoWorksIn;
    public TownBuildings(Governance governance, String type, int x, int y, int hp){
        super(governance,type,x,y);
        this.hp = 0;
        this.maximumHp = hp;
        this.neededWorkers = 0;
        this.x = x;
        this.y = y;
        peopleWhoWorksIn=new ArrayList<>();
    }

    public ArrayList<People> getPeopleWhoWorksIn() {
        return peopleWhoWorksIn;
    }
}
