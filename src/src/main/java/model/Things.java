package model;

public enum Things {

    // Resources
    WOOD("wood", "resource", 1000, 1, 1),
    STONE("stone", "resource",500, 2, 1 ),
    IRON("iron", "resource",250, 4, 2),
    PITCH("pitch", "resource",750, 2, 2),
    // Raw Materials
    WHEAT("wheat","raw", 1000, 5, 3),
    FLOUR("flour", "raw",1000, 10, 5),
    // Foods
    MEAT("meat", "food",50, 10, 5),
    DAIRY("dairy",  "food",100, 9, 4),
    FRUIT("fruit",  "food",100, 3, 2),
    BREAD("bread",  "food",50, 5, 3),
    DRINK("drink",  "food",25, 3, 2),
    // Herd
    HORSE("horse", "herd", 10, 0, 0),
    COW("cow", "herd", 3, 0, 0),
    // Weapons
    BOW("bow", "weapon", 5, 16, 8),
    CROSSBOW("crossbow",  "weapon", 5, 16, 8),
    SPEAR("spear",  "weapon", 5, 12, 6),
    PIKE("pike",  "weapon", 5, 24, 12),
    MACE("mace",  "weapon", 5, 32, 16),
    SWORD("swords",  "weapon", 5, 32, 16),
    LEATHER_ARMOR("Leather armor",  "weapon", 5, 24, 12),
    METAL_ARMOR("metal armor",  "weapon", 5, 32, 16);
    private final String name;
    private final String type;
    private int count;
    private final double purchasePrice;
    private final double sellPrice;

    Things(String name, String type, int count, double purchasePrice, double sellPrice) {
        this.name = name;
        this.type = type;
        this.count = count;
        this.purchasePrice = purchasePrice;
        this.sellPrice = sellPrice;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getCount() {
        return count;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
