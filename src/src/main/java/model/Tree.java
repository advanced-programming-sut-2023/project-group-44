package model;

public class Tree {
    private String treeName;
    private int x,y;
    public Tree(String treeName,int x,int y){
        this.treeName=treeName;
        this.x=x;
        this.y=y;
    }
    public String getTreeName() {
        return treeName;
    }
}
