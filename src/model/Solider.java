package model;

public class Solider extends People{
    private String name;
    private int attackPower;
    private int defencePower;
    private int speed;
    private int radiusOfMotion;
    private String state;
    public Solider(String name,String type,int x,int y){
        super(type,x,y);
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getDefencePower() {
        return defencePower;
    }

    public int getSpeed() {
        return speed;
    }

    public int getRadiusOfMotion() {
        return radiusOfMotion;
    }

    public String getState() {
        return state;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public void setDefencePower(int defencePower) {
        this.defencePower = defencePower;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setRadiusOfMotion(int radiusOfMotion) {
        this.radiusOfMotion = radiusOfMotion;
    }

    public void setState(String state) {
        this.state = state;
    }
}
