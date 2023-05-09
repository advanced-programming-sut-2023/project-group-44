package model.People.Martials;

import model.People.Martials.Enums.RoleMartial;
import model.People.Martials.Enums.State;
import model.People.Martials.Enums.Weapon;
import model.People.People;
import model.People.Type;
import model.User;

public class Martial extends People {
    private RoleMartial roleMartial;
    private Weapon weapon;
    private State state;
    private int attackPower;
    private int attackDistance;
    private int defencePower;
    private int speed;
    private int hp;
    private boolean canClimb;

    public Martial(Type type, User owner, int hp, RoleMartial role) {
        super(type, owner, hp);
        this.roleMartial = role;
    }
    public static RoleMartial convertEnumRoleMartial(String roleMartial){
        for(RoleMartial x:RoleMartial.values()){
            if(x.toString().replaceAll("_","").equalsIgnoreCase(roleMartial.replaceAll("[\\s_-]",""))) return x;
        }
        return null;
    }
}
