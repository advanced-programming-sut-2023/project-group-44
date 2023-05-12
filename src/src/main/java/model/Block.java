package model;

import model.Buildings.Building;
import model.People.Units.Unit;

import java.util.ArrayList;

public class Block {
    int x, y;
    private String texture;
    private String rockDirection;
    private Building building;
    private Tree tree;
    private ArrayList<Unit> units;

    public Block(int x, int y) {
        this.x = x;
        this.y = y;
        this.units = new ArrayList<>();
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

    public ArrayList<Unit> getUnits() {
        return units;
    }

    public void addUnit(Unit unit) {
        this.units.add(unit);
    }
    public void setUnits(ArrayList<Unit> units){ this.units = units;}

    public String getRockDirection() {
        return rockDirection;
    }

    public void setRockDirection(String rockDirection) {
        this.rockDirection = rockDirection;
    }
}

