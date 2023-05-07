package model.People;
import model.Block;
import model.Buildings.Building;
import model.User;

public class People {

    /* __________ Attributes of People __________ */
    private Type type;
    private boolean busy;
    private float foodPortion;
    private float tax; // positive=receive, negative=pay
    private Block position;
    private User owner;
    private int hp;
    /* _________________________________________ */

    /* __________ Getters __________ */

    public Type getType() {
        return type;
    }

    public boolean isBusy() {
        return busy;
    }

    public float getFoodPortion() {
        return foodPortion;
    }

    public float getTax() {
        return tax;
    }

    public Block getPosition() {
        return position;
    }

    public User getOwner() {
        return owner;
    }

    public int getHp() {
        return hp;
    }
    /* _____________________________ */

    /* __________ Setters __________ */

    public void setBusy(boolean busy) {
        this.busy = busy;
    }

    public void setFoodPortion(float foodPortion) {
        this.foodPortion = foodPortion;
    }

    public void setTax(float tax) {
        this.tax = tax;
    }

    public void setPosition(Block position) {
        this.position = position;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
    /* _____________________________ */

    // .:: Constructor ::.
    public People(Type type, User owner, int hp) {
        this.type = type;
        this.owner = owner;
        this.hp = hp;
    }
}
