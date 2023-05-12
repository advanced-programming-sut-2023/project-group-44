package model;

public enum Things {

    // Resources
    WOOD("wood", "resource", 1000,10, 3, 2),
    STONE("stone", "resource",500,10, 5, 3 ),
    IRON("iron", "resource",250,10, 8, 6),
    PITCH("pitch", "resource",750,10, 6, 4),
    // Foods
    WHEAT("wheat","raw", 1000,25, 5, 4),
    HOP("hop","raw",1000,25,5,4),
    FLOUR("flour", "raw",1000,20, 5, 4),
    MEAT("meat", "food",50,7, 2, 1),
    CHEESE("cheese",  "food",100,30, 5, 4),
    APPLE("apple",  "food",100,50, 5, 3),
    BREAD("bread",  "food",50,15, 5, 4),
    BEER("beer",  "food",25,15, 5, 4),
    // Herd
    HORSE("horse", "herd", 10,3, 2, 1),
    COW("cow", "herd", 3,3, 2, 1),
    // Weapons
    BOW("bow", "weapon", 5,5, 4, 2),
    SPEAR("spear",  "weapon", 5,5, 4, 2),
    MACE("mace",  "weapon", 5,5, 3, 2),
    SWORD("swords",  "weapon", 5,5, 3, 2),
    LEATHER_ARMOR("Leather armor",  "weapon", 5,10, 2, 1),
    METAL_ARMOR("metal armor",  "weapon", 5,5, 2, 1),
    MELTING_POT("melting pot","weapon",5,4,2,1);
    private final String name;
    private final String type;
    private int count;
    private final int numberOfSalesPerBuyOrSell;
    private final double purchasePrice;
    private final double sellPrice;

    Things(String name, String type, int count, int numberOfSalesPerBuyOrSell, double purchasePrice, double sellPrice) {
        this.name = name;
        this.type = type;
        this.count = count;
        this.numberOfSalesPerBuyOrSell=numberOfSalesPerBuyOrSell;
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

    public int getNumberOfSalesPerBuyOrSell() {
        return numberOfSalesPerBuyOrSell;
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
