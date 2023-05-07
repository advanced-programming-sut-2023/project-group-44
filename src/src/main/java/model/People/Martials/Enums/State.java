package model.People.Martials.Enums;

public enum State {
    STANDING,
    DEFENSIVE,
    OFFENSIVE;

    // A method to return a state (enum) by the entered name. Indeed, it checks if an entered state name is valid.
    public static State getEnumState(String enteredState) {
        for (State state : State.values()) {
            if (state.toString().equalsIgnoreCase(enteredState.replaceAll("[\\s_-]", ""))) {
                return state;
            }
        }
        return null;
    }

}
