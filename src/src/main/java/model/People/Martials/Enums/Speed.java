package model.People.Martials.Enums;

public enum Speed {
    VERY_FAST(10),
    FAST(8),
    MEDIUM(5),
    SLOW(3),
    VERY_SLOW(1);
    private final int speed;

    private Speed (int speed) {
        this.speed = speed;
    }

    public int getSpeed() {
        return speed;
    }
}
