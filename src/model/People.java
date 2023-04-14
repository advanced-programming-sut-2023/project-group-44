package model;

public class People {
    private String name;
    private String type;
    private int x,y;
    public People(String type,int x, int y){
        this.type=type;
        this.x=x;
        this.y=y;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
