package model.People.OtherPeople;

import model.People.People;
import model.People.Type;
import model.User;

public class OtherPeople extends People {
    private RoleOtherPeople roleOtherPeople;
    public OtherPeople(Type type, User owner, int hp, RoleOtherPeople role) {
        super(type, owner, hp);
        this.roleOtherPeople = role;
    }
}
