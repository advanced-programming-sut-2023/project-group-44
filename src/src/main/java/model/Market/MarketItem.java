package model.Market;

import model.People.Type;

public class MarketItem {
    private ItemType type;
    private int numberOfSalesPerBuyORSell;
    private int buyPrice;
    private int sellPrice;
    public MarketItem(ItemType type){
        this.type=type;
        switch (type){
            case WOOD :
                this.numberOfSalesPerBuyORSell=10;
                this.buyPrice=3;
                this.sellPrice=2;
                break;
            case IRON:
                this.numberOfSalesPerBuyORSell=10;
                this.buyPrice=8;
                this.sellPrice=6;
                break;
            case STONE:
                this.numberOfSalesPerBuyORSell=10;
                this.buyPrice=5;
                this.sellPrice=3;
                break;
            case PITCH:
                this.numberOfSalesPerBuyORSell=10;
                this.buyPrice=6;
                this.sellPrice=4;
                break;
            case FLOUR:
                this.numberOfSalesPerBuyORSell=20;
                this.buyPrice=5;
                this.sellPrice=4;
                break;
            case METAl_ARMOUR:
                this.numberOfSalesPerBuyORSell=5;
                this.buyPrice=2;
                this.sellPrice=1;
                break;
            case SWORD, MACE:
                this.numberOfSalesPerBuyORSell=5;
                this.buyPrice=3;
                this.sellPrice=2;
                break;
            case BOW , SPEAR:
                this.numberOfSalesPerBuyORSell=5;
                this.buyPrice=4;
                this.sellPrice=2;
                break;
            case MELTING_POT:
                this.numberOfSalesPerBuyORSell=4;
                this.buyPrice=2;
                this.sellPrice=1;
                break;
            case HORSE:
                this.numberOfSalesPerBuyORSell=3;
                this.buyPrice=2;
                this.sellPrice=1;
                break;
            case APPLE:
                this.numberOfSalesPerBuyORSell=50;
                this.buyPrice=5;
                this.sellPrice=3;
                break;
            case CHEESE:
                this.numberOfSalesPerBuyORSell=30;
                this.buyPrice=5;
                this.sellPrice=4;
                break;
            case LEATHER_VEST:
                this.numberOfSalesPerBuyORSell=10;
                this.buyPrice=2;
                this.sellPrice=1;
                break;
            case HOP:
                this.numberOfSalesPerBuyORSell=25;
                this.buyPrice=5;
                this.sellPrice=4;
                break;
            case BEER , BREAD:
                this.numberOfSalesPerBuyORSell=15;
                this.buyPrice=5;
                this.sellPrice=4;
                break;
            case MEAT:
                this.numberOfSalesPerBuyORSell=7;
                this.buyPrice=2;
                this.sellPrice=1;
                break;
        }
    }

    public static ItemType convertEnumItem(String type){
        for(ItemType x:ItemType.values()){
            if(x.toString().replaceAll("_","").equalsIgnoreCase(type.replaceAll("[\\s_-]",""))) return x;
        }
        return null;
    }

    public ItemType getType() {
        return type;
    }

    public int getNumberOfSalesPerBuyORSell() {
        return numberOfSalesPerBuyORSell;
    }

    public int getBuyPrice() {
        return buyPrice;
    }

    public int getSellPrice() {
        return sellPrice;
    }
}
