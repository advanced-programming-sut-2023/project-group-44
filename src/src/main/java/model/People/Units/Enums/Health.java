package model.People.Units.Enums;

public enum Health {
    VERY_LOW(10),
    LOW(25),
    MEDIUM(50),
    HIGH(70),
    VERY_HIGH(100),
    NO(0);
    private final int health;
    private Health(int health) {
        this.health = health;
    }

    public int getHealth() {
        return health;
    }
}
