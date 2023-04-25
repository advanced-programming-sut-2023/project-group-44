package model;

import model.Buildings.Building;

import java.util.ArrayList;

public class Block {
    int x, y;
    private String texture;
    private Building building;
    private Tree tree;
    private ArrayList<Solider> solider;

    public Block(int x, int y) {
        this.x = x;
        this.y = y;
        this.solider = new ArrayList<>();
    }

    public String getTexture() {
        return texture;
    }

    public void setTexture(String texture) {
        this.texture = texture;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Tree getTree() {
        return tree;
    }

    public void setTree(Tree tree) {
        this.tree = tree;
    }

    public ArrayList<Solider> getSolider() {
        return solider;
    }

    public void addSolider(Solider solider) {
        this.solider.add(solider);
    }
}
