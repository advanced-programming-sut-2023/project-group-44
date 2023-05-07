package model.People.Workers;

import model.Buildings.Building;
import model.People.People;
import model.People.Type;
import model.User;

public class Worker extends People {
    private Building workPlace;
    private RoleWorker roleWorker;

    public Worker(Type type, User owner, int hp, Building workPlace, RoleWorker role) {
        super(type, owner, hp);
        this.workPlace = workPlace;
        this.roleWorker = role;
    }
}
