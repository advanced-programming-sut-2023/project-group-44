package model.People.Martials.Enums;

public enum AttackDistance {
    FAR(10),
    MIDDLE(5),
    CLOSE(1);
    private final int attackDistance;
    private AttackDistance (int attackDistance) {
        this.attackDistance = attackDistance;
    }

    public int getAttackDistance() {
        return attackDistance;
    }
}
