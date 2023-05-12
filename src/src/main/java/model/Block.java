package model;

import model.Buildings.Building;
import model.People.Engineer;
import model.People.Units.Unit;

import java.util.ArrayList;

public class Block {
    int x, y;
    private String texture;
    private String rockDirection;
    private Building building;
    private Tree tree;
    private ArrayList<Unit> units;
    private ArrayList<Engineer> engineers;

    public Block(int x, int y) {
        this.x = x;
        this.y = y;
        this.units = new ArrayList<>();
        this.engineers = new ArrayList<>();
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

    public ArrayList<Engineer> getEngineers() {
        return engineers;
    }

    public void addUnit(Unit unit) {
        this.units.add(unit);
    }

    public void addEngineer(Engineer engineer) {
        this.engineers.add(engineer);
    }

    public String getRockDirection() {
        return rockDirection;
    }

    public void setRockDirection(String rockDirection) {
        this.rockDirection = rockDirection;
    }
}

