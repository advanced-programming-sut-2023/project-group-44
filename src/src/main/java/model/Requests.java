package model;

public class Requests {
    private User owner;
    private User donator;
    private String resourceType;
    private int amount;
    private int price;
    private String message;

    public Requests(User owner, User donator, String resourceType, int amount, int price, String message) {
        this.owner = owner;
        this.donator = donator;
        this.resourceType = resourceType;
        this.amount = amount;
        this.price = price;
        this.message = message;
    }

    public User getOwner() {
        return owner;
    }

    public User getDonator() {
        return donator;
    }

    public String getResourceType() {
        return resourceType;
    }

    public int getAmount() {
        return amount;
    }

    public int getPrice() {
        return price;
    }

    public String getMessage() {
        return message;
    }
}
