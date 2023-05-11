package model.People.Units.Enums;

public enum Weapon {

    BOW,
    MACE,
    STAFF,
    SLING,
    PICKAXE,
    SPEAR,
    SCIMITAR,
    CROSSBOW,
    TORCH,
    SWORD,
    PIKE,
    GREEKFIRE,
    LADDER,
    NA;
    // A method to return a weapon (enum) by the entered name. Indeed, it checks if an entered weapon name is valid.
    public static Weapon getEnumWeapon(String enteredWeapon) {
        for (Weapon weapon : Weapon.values()) {
            if (weapon.toString().equalsIgnoreCase(enteredWeapon.replaceAll("[\\s_-]", ""))) {
                return weapon;
            }
        }
        return null;
    }
}
