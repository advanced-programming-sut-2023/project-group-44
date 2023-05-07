package model.People.Martials.Enums;

public enum AttackPower {

    LOW(10),
    MEDIUM(40),
    HIGH(70),
    VERY_HIGH(100),
    NO(0);

    private final int attackPower;

    private AttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getAttackPower() {
        return attackPower;
    }
}
