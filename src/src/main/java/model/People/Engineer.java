package model.People;

import controller.GameMenuController;
import model.Block;
import model.Governance;
import model.People.Units.Unit;

import java.util.ArrayList;

public class Engineer extends People {
    private int buildSpeed;
    private int repairSpeed;
    private boolean canBuild;
    private boolean canRepair;

    public Engineer(Governance owner, int hp, int buildSpeed, int repairSpeed, boolean canBuild, boolean canRepair) {
        super(Type.ENGINEER, owner, hp);
        this.buildSpeed = buildSpeed;
        this.repairSpeed = repairSpeed;
        this.canBuild = canBuild;
        this.canRepair = canRepair;
    }

    public static ArrayList<Engineer> getEngineersByBlock(int x, int y) {
        Block block = GameMenuController.currentMap.getBlock(x, y);
        return block.getEngineers();
    }
}
