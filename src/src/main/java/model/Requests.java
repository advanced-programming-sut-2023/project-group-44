package model;

public class Requests {
    private User owner;
    private User donator=null;
    private String resourceType;
    private int amount;
    private int price;
    private String requestMessage;
    private String acceptMessage;
    private boolean isThisRequestNew;

    public Requests(User owner, String resourceType, int amount, int price, String message) {
        this.owner = owner;
        this.resourceType = resourceType;
        this.amount = amount;
        this.price = price;
        this.requestMessage = message;
        isThisRequestNew=true;
    }

    public User getOwner() {
        return owner;
    }

    public User getDonator() {
        return donator;
    }

    public void setDonator(User donator) {
        this.donator = donator;
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
        return requestMessage;
    }

    public String getAcceptMessage() {
        return acceptMessage;
    }

    public void setAcceptMessage(String acceptMessage) {
        this.acceptMessage = acceptMessage;
    }

    public String getRequestMessage() {
        return requestMessage;
    }

    public boolean isThisRequestNew() {
        return isThisRequestNew;
    }

    public void setThisRequestNew(boolean thisRequestNew) {
        isThisRequestNew = thisRequestNew;
    }
}
