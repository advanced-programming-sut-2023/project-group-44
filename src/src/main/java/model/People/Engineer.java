package model.People;

import model.Governance;

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
}
