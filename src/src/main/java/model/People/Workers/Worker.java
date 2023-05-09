package model.People.Workers;

import model.Buildings.Building;
import model.People.Martials.Enums.RoleMartial;
import model.People.People;
import model.People.Type;
import model.User;

public class Worker extends People {
    private RoleWorker roleWorker;
    private Building workPlace;

    public Worker(Type type, User owner, int hp, Building workPlace,RoleWorker roleWorker) {
        super(type, owner, hp);
        this.workPlace = workPlace;
        this.roleWorker = roleWorker;
    }

    public RoleWorker getRoleWorker() {
        return roleWorker;
    }

    public void setRoleWorker(RoleWorker roleWorker) {
        this.roleWorker = roleWorker;
    }

    public Building getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(Building workPlace) {
        this.workPlace = workPlace;
    }

    public static RoleWorker convertEnumRoleWorker(String roleWorker){
        for(RoleWorker x:RoleWorker.values()){
            if(x.toString().replaceAll("_","").equalsIgnoreCase(roleWorker.replaceAll("[\\s_-]",""))) return x;
        }
        return null;
    }
}
