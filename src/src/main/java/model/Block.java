package model;

import model.Buildings.Building;
import model.People.Martials.Martial;

import java.util.ArrayList;

public class Block {
    int x, y;
    private String texture;
    private Building building;
    private Tree tree;
    private ArrayList<Martial> martial;

    public Block(int x, int y) {
        this.x = x;
        this.y = y;
        this.martial = new ArrayList<>();
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

    public ArrayList<Martial> getSolider() {
        return martial;
    }

    public void addSolider(Martial martial) {
        this.martial.add(martial);
    }
}
