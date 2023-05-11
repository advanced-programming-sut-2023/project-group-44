package model.People.Units.Enums;

public enum RoleUnit { // According to pages 26-29 of English Doc

    // Roles of Martial people
    ARCHER,
    CROSSBOWMAN,
    SPEARMAN,
    PIKEMAN,
    MACEMAN,
    SWORDSMAN,
    KNIGHT,
    TUNNELER,
    LADDERMAN,
    ENGINEER,
    BLACK_MONK,
    ARCHER_BOW,
    SLAVE,
    SLINGER,
    ASSASSIN,
    HORSE_ARCHER,
    ARABIAN_SWORDSMAN,
    FIRE_THROWER,
    LORD;

    public static RoleUnit convertEnumRoleUnit (String roleName){
        for (RoleUnit roleUnit : RoleUnit.values()) {
            if (roleUnit.toString().equalsIgnoreCase(roleName.replaceAll("[\\s_-]", ""))) {
                return roleUnit;
            }
        }
        return null;
    }
}
