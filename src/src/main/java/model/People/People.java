package model.People;
import model.Block;
import model.Governance;
import model.User;
import view.Commands.GameMenuCommands;

public class People {

    /* __________ Attributes of People __________ */
    private Type type;
    private boolean busy;
    private float foodPortion;
    private float tax; // positive=receive, negative=pay
    private Block block;
    private Governance owner;
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

    public Block getBlock() {
        return block;
    }

    public Governance getOwner() {
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

    public void setBlock(Block block) {
        this.block = block;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setType(Type type) {
        this.type = type;
    }
    public static Type convertEnumPeople(String type){
        for(Type x:Type.values()){
            if(x.toString().replaceAll("_","").equalsIgnoreCase(type.replaceAll("[\\s_-]",""))) return x;
        }
        return null;
    }
    /* _____________________________ */

    // .:: Constructor ::.
    public People(Type type, Governance owner, int hp) {
        this.type = type;
        this.owner = owner;
        this.hp = hp;
    }
}
