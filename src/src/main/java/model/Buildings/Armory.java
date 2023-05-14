package model.Buildings;

import model.Governance;
import model.Things;

public class Armory extends Building{
    private Things metalArmor;
    private Things bow;
    private Things spear;
    private Things mace;
    private Things sword;
    private Things leatherArmor;
    public Armory(Governance governance,int x, int y,int hp){
        super(governance,"armory",x,y);
        this.hp = hp;
        this.maximumHp = hp;
    }

    public double getMetalArmor(){return this.metalArmor.getCount();}
    public double getBow(){return this.bow.getCount();}
    public double getSpear(){return this.spear.getCount();}
    public double getMace(){return this.mace.getCount();}
    public double getSword(){return this.sword.getCount();}
    public double getLeatherArmor(){return this.leatherArmor.getCount();}
    public void addMetalArmor(int a){this.metalArmor.setCount(this.metalArmor.getCount()+a);}
    public void addBow(int a){this.bow.setCount(this.bow.getCount()+a);}
    public void addSpear(int a){this.spear.setCount(this.spear.getCount()+a);}
    public void addMace(int a){this.mace.setCount(this.mace.getCount()+a);}
    public void addSword(int a){this.sword.setCount(this.sword.getCount()+a);}
    public void addLeatherArmor(int a){this.leatherArmor.setCount(this.leatherArmor.getCount()+a);}

}
