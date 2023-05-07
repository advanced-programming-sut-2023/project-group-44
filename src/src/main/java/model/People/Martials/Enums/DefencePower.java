package model.People.Martials.Enums;

public enum DefencePower {
    VERY_HIGH(25),
    HIGH(20),
    MEDIUM(15),
    LOW(10),
    VERY_LOW(5),
    NO(0);

    private final int defencePower;
    private DefencePower(int defencePower) {
        this.defencePower = defencePower;
    }

    public int getDefencePower() {
        return defencePower;
    }
}
