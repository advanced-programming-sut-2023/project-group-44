package model.People.Units;

import controller.GameMenuController;
import model.Block;
import model.Governance;
import model.People.Units.Enums.RoleUnit;
import model.People.Units.Enums.State;
import model.People.Units.Enums.Weapon;
import model.People.People;
import model.People.Type;

import java.util.ArrayList;

public class Unit extends People {
    private RoleUnit roleMartial;
    private Weapon weapon;
    private State state;
    private int count;
    private int attackPower;
    private int attackDistance;
    private int defencePower;
    private int speed;
    private boolean canClimb;

    public Unit(Type type, Governance owner, int hp, RoleUnit role) {
        super(type, owner, hp);
        this.roleMartial = role;
    }

    public static RoleUnit convertEnumRoleMartial(String roleMartial) {
        for (RoleUnit x : RoleUnit.values()) {
            if (x.toString().replaceAll("_", "").equalsIgnoreCase(roleMartial.replaceAll("[\\s_-]", ""))) return x;
        }
        return null;
    }

    public static ArrayList<Unit> getUnitsByBlock(int x, int y) {
        Block block = GameMenuController.currentMap.getBlock(x, y); // What block do we want?
        return block.getUnits();
    }

    public void setState(State state) {
        this.state = state;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void addAttackPower(int attackPower) {
        this.attackPower += attackPower;
    }
}
